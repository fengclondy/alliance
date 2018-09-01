package com.ai.aso.security.shiro;

import com.ai.aso.base.constants.ResultInfo;
import com.ai.aso.security.constants.SecurityConstants;
import com.ai.aso.security.constants.SecurityResultCode;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public abstract class AbstractAuthenticationFilter extends
		FormAuthenticationFilter {

	Logger logger = LoggerFactory.getLogger(AbstractAuthenticationFilter.class);

	public AbstractAuthenticationFilter() {
		super();
		this.setFailureKeyAttribute(SecurityConstants.LOGIN_ERROR_KEY);
	}

	/**
	 * 已认证成功处理<br>
	 * 1、如果是认证请求，则退出认证成功状态<br>
	 * 2、非认证请求，跳过该拦截器处理
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		boolean isAuth = subject.isAuthenticated();
		// 如果是POST登录验证，则退出登录状态
		if (isAuth && isLoginRequest(request, response)
				&& isLoginSubmission(request, response)) {
			subject.logout();
			isAuth = subject.isAuthenticated();
		}
		return isAuth;
	}

	/**
	 * 非认证成功情况处理<br>
	 * 1、非认证请求，则保持当前请求信息，重定向到登录页面<br>
	 * 2、认证请求，则执行认证，认证执行如下：<br>
	 * a、认证成功，跳转入登录成功页面(FORM)或返回认证成功信息(AJAX)<br>
	 * b、认证失败，记录失败信息，进入后置过滤器处理
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
		// 前置过滤器已出现错误，则直接转入后置过滤器
		if (request.getAttribute(getFailureKeyAttribute()) != null) {
			return true;
		}
		// 判断是否认证请求
		if (isLoginRequest(request, response)) {
			// 是否POST请求
			if (isLoginSubmission(request, response)) {
				if (logger.isTraceEnabled()) {
					logger.trace("Form Login submission detected.  Attempting to execute login.");
				}
				return executeLogin(request, response);
			} else {
				if (logger.isTraceEnabled()) {
					logger.trace("Login page view.");
				}
				// allow them to see the login page ;)
				return true;
			}
		} else {
			if (logger.isTraceEnabled()) {
				logger.trace("Attempting to access a path which requires authentication.  Forwarding to the "
						+ "Authentication url [" + getLoginUrl() + "]");
			}
			saveRequestAndRedirectToLogin(request, response);
			return false;
		}
	}

	/**
	 * 执行登录认证过程
	 */
	@Override
	protected boolean executeLogin(ServletRequest request,
                                   ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		try {
			// 执行认证
			Subject subject = getSubject(request, response);
			subject.login(token);
			// 缓存扩展用户信息
			doLoginSuccess(request);
			if (ShiroWebUtils.isAjaxRequest(request)) {
				return onAjaxLoginSuccess(token, subject, request, response);
			} else {
				return onFormLoginSuccess(token, subject, request, response);
			}
		} catch (AuthenticationException e) {
			logger.warn("认证失败，失败原因为:{}-{}", e.getClass().getName(), e.getMessage());
			return onLoginFailure(token, e, request, response);
		}
	}

	/**
	 * 认证失败，转入后续处理
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		setFailureAttribute(request, e);
		// login failed, let request continue back to the login page:
		return true;
	}

	/**
	 * AJAX方式认证成功后，响应请求返回成功信息，主要执行逻辑如下：<br>
	 * 1、返回AJAX请求响应报文，返回报文格式JSON<br>
	 * 2、终止过滤器链
	 * 
	 * @param token
	 * @param subject
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected boolean onAjaxLoginSuccess(AuthenticationToken token,
                                         Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		ResultInfo result = new ResultInfo();
		result.setCode(SecurityResultCode.AUTHEN_SUCCESS);
		result.setMsg("认证成功！");
		try {
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(result.toJSONString());
			response.getWriter().flush();
		} catch (IOException ioe) {
			logger.warn("AJAX认证响应异常：{}", ioe.getMessage());
		}
		// 终止过滤链
		return false;
	}

	/**
	 * FORM POST方式认证成功后，重定向成功页面：<br>
	 * 1、重定向认证成功页面，如缓存了原始请求则优先跳转原始请求<br>
	 * 2、终止过滤器链
	 * 
	 * @param token
	 * @param subject
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected boolean onFormLoginSuccess(AuthenticationToken token,
                                         Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		// 重定向成功页面，有缓存请求则重定向到原始请求
		issueSuccessRedirect(request, response);
		// 终止过滤链
		return false;
	}

	/**
	 * 登录成功后，扩展处理
	 * @param request 
	 * 
	 * @param request
	 */
	protected abstract void doLoginSuccess(ServletRequest request);

	@Override
	protected void issueSuccessRedirect(ServletRequest request,
                                        ServletResponse response) throws Exception {
		ShiroWebUtils
				.redirectToSavedRequest(request, response, getSuccessUrl());
	}

	@Override
	protected void saveRequestAndRedirectToLogin(ServletRequest request,
                                                 ServletResponse response) throws IOException {
		saveRequest(request);
		redirectToLogin(request, response);
	}

	@Override
	protected void saveRequest(ServletRequest request) {
		ShiroWebUtils.saveRequest(request);
	}

}

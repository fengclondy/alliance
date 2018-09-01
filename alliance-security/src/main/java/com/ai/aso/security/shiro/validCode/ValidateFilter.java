package com.ai.aso.security.shiro.validCode;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ValidateFilter extends AccessControlFilter {
	private boolean validateEnabled = true;// 是否开启验证码支持
	private String reqParamName = "validateCode";// 前台提交的验证码参数名
	private String failureKeyAttribute = "shiroLoginFailure"; // 验证失败后存储到的属性名
	private String volidateError = "validate.error";

	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		// 1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
		request.setAttribute("jcaptchaEbabled", validateEnabled);
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		// 2、判断验证码是否禁用或不是表单提交（允许访问）
		if (validateEnabled == false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {
			return true;
		}
		// 3、此时是表单提交，验证验证码是否正确
		Session session = SecurityUtils.getSubject().getSession();
		String code =(String) session.getAttribute(ValidateCodeBean.VALIDCODE);
		 session.removeAttribute(ValidateCodeBean.VALIDCODE);
		String paramsCode = httpServletRequest.getParameter(reqParamName);
		if(paramsCode.equalsIgnoreCase(code)){
			return true;
		}
		request.setAttribute(failureKeyAttribute, volidateError);
		return true;
	}

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 如果验证码失败了，存储失败key属性
		request.setAttribute(failureKeyAttribute, volidateError);
		return true;
	}

	public void setValidateEnabled(boolean validateEnabled) {
		this.validateEnabled = validateEnabled;
	}

	public void setReqParamName(String reqParamName) {
		this.reqParamName = reqParamName;
	}

	public void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}
}

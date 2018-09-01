package com.ai.aso.security.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ShiroWebUtils extends WebUtils {

	public static void saveRequest(ServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		HttpServletRequest httpRequest = toHttp(request);
		ShiroSavedRequest savedRequest = new ShiroSavedRequest(httpRequest);
		session.setAttribute(SAVED_REQUEST_KEY, savedRequest);
	}

	public static ShiroSavedRequest getAndClearSavedRequest(
			ServletRequest request) {
		ShiroSavedRequest savedRequest = getSavedRequest(request);
		if (savedRequest != null) {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.removeAttribute(SAVED_REQUEST_KEY);
		}
		return savedRequest;
	}

	public static ShiroSavedRequest getSavedRequest(ServletRequest request) {
		ShiroSavedRequest savedRequest = null;
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		if (session != null) {
			savedRequest = (ShiroSavedRequest) session
					.getAttribute(SAVED_REQUEST_KEY);
		}
		return savedRequest;
	}

	public static void redirectToSavedRequest(ServletRequest request,
                                              ServletResponse response, String fallbackUrl) throws IOException {
		String successUrl = null;
		boolean contextRelative = true;
		ShiroSavedRequest savedRequest = ShiroWebUtils
				.getAndClearSavedRequest(request);
		if (savedRequest != null) {
			// AJAX请求则跳转到RefererUrl
			if (savedRequest.isAjax()) {
				successUrl = savedRequest.getRefererUrl();
				contextRelative = false;
			} else if (savedRequest.getMethod().equalsIgnoreCase(
					AccessControlFilter.GET_METHOD)) {
				successUrl = savedRequest.getRequestUrl();
				contextRelative = false;
			}
		}

		if (successUrl == null) {
			successUrl = fallbackUrl;
		}

		if (successUrl == null) {
			throw new IllegalStateException(
					"Success URL not available via saved request or via the "
							+ "successUrlFallback method parameter. One of these must be non-null for "
							+ "issueSuccessRedirect() to work.");
		}

		WebUtils.issueRedirect(request, response, successUrl, null,
				contextRelative);
	}

	/**
	 * 判断是否AJAX请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(ServletRequest request) {
		if (request instanceof HttpServletRequest) {
			String requestType = WebUtils.toHttp(request).getHeader(
					"X-Requested-With");
			if (requestType != null && "XMLHttpRequest".equals(requestType)) {
				return true;
			}
		}
		return false;
	}
}

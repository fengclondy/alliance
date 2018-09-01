package com.ai.aso.security.shiro;

import org.apache.shiro.web.util.SavedRequest;

import javax.servlet.http.HttpServletRequest;

public class ShiroSavedRequest extends SavedRequest {

	private static final long serialVersionUID = -8876077433123587381L;

	private String refererUrl;

	private boolean isAjax;

	public ShiroSavedRequest(HttpServletRequest request) {
		super(request);
		this.refererUrl = request.getHeader("Referer");
		this.isAjax = ShiroWebUtils.isAjaxRequest(request);
	}

	public String getRefererUrl() {
		return refererUrl;
	}

	public boolean isAjax() {
		return isAjax;
	}

}

package com.ai.aso.security.shiro;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class RolesAuthFilter extends RolesAuthorizationFilter {

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

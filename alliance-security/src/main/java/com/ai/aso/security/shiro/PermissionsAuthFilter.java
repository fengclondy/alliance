package com.ai.aso.security.shiro;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class PermissionsAuthFilter extends PermissionsAuthorizationFilter {

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

package com.ai.aso.base.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ai.aso.base.constants.SysConstants;

public class RedirectSessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Object errors = request.getSession().getAttribute(SysConstants.SYS_EXCEPTION_INFO);
		
		if (null != errors) {
			request.setAttribute(SysConstants.SYS_EXCEPTION_INFO, errors);
			request.getSession().removeAttribute(SysConstants.SYS_EXCEPTION_INFO);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}

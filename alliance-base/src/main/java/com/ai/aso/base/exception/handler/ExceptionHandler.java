package com.ai.aso.base.exception.handler;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ai.aso.base.constants.ResultInfo;
import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.base.exception.BaseException;
import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.ExInfoEnum;
import com.ai.aso.base.utils.StringUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * 文件名：ExceptionHandler.java<br>
 * 描述：捕捉系统所有未处理的异常，<br>
 * 同步请求的异常将错误码、错误信息返回到统一异常显示页面，<br>
 * 异步请求异常将错误码、错误信息返回<br>
 * 
 * @author yusx
 * @version 1.0
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

	Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		logger.error("原始错误信息：", ex);
		
		ResultInfo result = new ResultInfo();
		if (ex instanceof BaseException) { // 自定义异常
			BaseException exp = (BaseException) ex;
			logger.warn("自定义异常统一处理，错误码：{}，错误原因：{}", exp.getCode(),
					exp.getMessage());
			result.setCode(exp.getCode());
			result.setMsg(exp.getTip());
		} else {
			logger.error("列外异常统一处理，错误信息：{}", ex.getMessage(), ex);
			ExInfo exInfo = ExInfoEnum.SYS_GLOBAL_ERROR;
			result.setCode(exInfo.getCode());
			result.setMsg(exInfo.getTip());
		}
		
		request.getSession().setAttribute(SysConstants.SYS_EXCEPTION_REDIRECT_FLAG, true);

		if (this.isAjaxRequest(request)) { // ajax请求异常处理
			response.setContentType("text/json;charset=utf-8");
			try {
				response.getWriter().write(JSONObject.toJSONString(result));
				response.getWriter().flush();
			} catch (IOException e) {
				logger.error("AJAX返回异常，错误信息：{}", ex.getMessage());
				return new ModelAndView("redirect:/sys/error.html").addObject("result", result);
			}
			return new ModelAndView();
		} else if ("GET".equalsIgnoreCase(request.getMethod())) {
			Map<String, String> map = new HashMap<String, String>();
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = e.nextElement();
				String value = request.getParameter(name);
				map.put(name, value);
			}
			
			request.getSession().setAttribute(SysConstants.SYS_EXCEPTION_INFO, result);
			String url = request.getHeader("Referer");
			if (StringUtil.isNotEmpty(url)) {
				String beforeUrl = url.substring(url.indexOf(request.getContextPath()) + request.getContextPath().length());
				return new ModelAndView("redirect:" + beforeUrl, map);
			}
		}
		
		return new ModelAndView("redirect:/sys/error.html").addObject("result", result);
	}

	/**
	 * 判断是否AJAX请求
	 * 
	 * @param request
	 * @return true or false
	 */
	private boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && "XMLHttpRequest".equals(requestType)) {
			return true;
		}
		return false;
	}
}

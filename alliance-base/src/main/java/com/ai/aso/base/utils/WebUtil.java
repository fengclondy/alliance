package com.ai.aso.base.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	
	/**
	 * 根据REQ获取IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
				String ipLeval = ip.substring(ip.indexOf(",") + 1, ip.length());
				while ("unknown".equals(ip)) {
					if (ip.indexOf(",") > 0) {
						ip = ipLeval.substring(0, ipLeval.indexOf(","));
					} else {
						ip = ipLeval;
						break;
					}
				}
			}
		}
		return ip;
	}
}

/**
 * With Gfound.
 *
 * xu.xiaolong
 */
package com.ai.aso.manager.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie工具类
 * @author Gfound
 * @version 2013-01-15
 */
public class CookieUtils {
	
	public static String COOKE_NAME_AUTO_SUBMIT = "_a"; 
	public static String COOKE_NAME_USER_LOGIN = "_u"; 
	public static String COOKE_NAME_PASSWD = "_p"; 
	public static void addCookie(HttpServletResponse response, String name, String value, Integer maxAge, String path, String domain, Boolean secure)
    {
        Assert.notNull(response);
        Assert.hasText(name);
        try
        {
            name = URLEncoder.encode(name, "UTF-8");
            value = URLEncoder.encode(value, "UTF-8");
            Cookie cookie = new Cookie(name, value);
            if(maxAge != null)
                cookie.setMaxAge(maxAge.intValue());
           if(StringUtils.isNotEmpty(path))
                cookie.setPath(path);
            if(StringUtils.isNotEmpty(domain))
                cookie.setDomain(domain);
            if(secure != null)
                cookie.setSecure(secure.booleanValue());
            response.addCookie(cookie);
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
    }
	
	
	public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, Integer maxAge)
    {
        addCookie(response, name, value, maxAge,"/", "", null);
    }
	
	public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value)
    {
        addCookie(response, name, value, null, "/", "", null);
    }
	
	public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name, String path, String domain)
    {
        Assert.notNull(request);
        Assert.notNull(response);
        Assert.hasText(name);
        try
        {
            name = URLEncoder.encode(name, "UTF-8");
            Cookie cookie = new Cookie(name, null);
            cookie.setMaxAge(0);
            if(StringUtils.isNotEmpty(path))
                cookie.setPath(path);
            if(StringUtils.isNotEmpty(domain))
                cookie.setDomain(domain);
            response.addCookie(cookie);
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
    }
	
	public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		removeCookie(request, response, name, "/", "");
	}

	/**
	 * 设置 Cookie（生成时间为1天）
	 * @param name 名称
	 * @param value 值
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 60*60*24);
	}
	
	/**
	 * 设置 Cookie
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 生存时间（单位秒）
	 * @param uri 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		if (response != null)
		{
			Cookie cookie = new Cookie(name, null);
			cookie.setPath("/");
			cookie.setMaxAge(maxAge);
			try {
				cookie.setValue(URLEncoder.encode(value, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.addCookie(cookie);
		}

	}
	/**
	 * 获得指定Cookie的值
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, null, name, false);
	}
	/**
	 * 获得指定Cookie的值，并删除。
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		return getCookie(request, response, name, true);
	}
	/**
	 * 获得指定Cookie的值
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param name 名字
	 * @param isRemove 是否移除
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					try {
						value = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (isRemove) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return value;
	}
}

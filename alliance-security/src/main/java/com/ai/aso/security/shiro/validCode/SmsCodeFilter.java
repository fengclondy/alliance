package com.ai.aso.security.shiro.validCode;

import com.ai.aso.base.utils.StringUtil;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SmsCodeFilter extends AccessControlFilter {
	private boolean validateEnabled = true;// 是否开启验证码支持
	private String reqParamName = "smsValidateCode";// 前台提交的验证码参数名
	private String failureKeyAttribute = "shiroLoginFailure"; // 验证失败后存储到的属性名
	private String volidateError = "sms.validate.error";
	private String smsCodeKey = "userMobile";// 前台接收验证码的主键
	private String totalCounts = "totalCounts";// 短信验证码使用的次数
	private RedisTemplate<String, String> redisOps;// 缓存
	private static int ADD_COUNTS = 1;
	protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception {
		// 1、设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
		request.setAttribute("jcaptchaEbabled", validateEnabled);
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		// 2、判断验证码是否禁用或不是表单提交（允许访问）
		if (validateEnabled == false
				|| !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {
			return true;
		}
		// 3、此时是表单提交，验证验证码是否正确
		// Session session = SecurityUtils.getSubject().getSession();
		// String code = (String)
		// session.removeAttribute(ValidateCodeBean.VALIDCODE);

		//Session session = SecurityUtils.getSubject().getSession();
		// TODO redis查询接口，参数key为生成验证码类提供
		String code = null;
		String secondKey = request.getParameter(smsCodeKey);
		String checkCounts = "";
		String paramsCode = httpServletRequest.getParameter(reqParamName);
		if (StringUtil.isNotEmpty(secondKey)) {
			code = redisOps.opsForValue().get(secondKey);
			if (StringUtil.isNotEmpty(paramsCode)
					&& paramsCode.equalsIgnoreCase(code)) {

				redisOps.delete("LOGIN_PHONENO_SMSCODE_LIMITS" + secondKey);
				return true;
			} else {

				checkCounts = redisOps.opsForValue().get(
						"LOGIN_PHONENO_SMSCODE_LIMITS" + secondKey);
				if (StringUtil.isNotEmpty(checkCounts)) {
					if (Integer.parseInt(checkCounts) >= Integer
							.parseInt(totalCounts)) {
						// 3次后移除验证码
						redisOps.delete(secondKey);
						redisOps.delete("LOGIN_PHONENO_SMSCODE_LIMITS"
								+ secondKey);
					} else {
						checkCounts = String.valueOf(ADD_COUNTS
								+ Integer.parseInt(checkCounts));
						redisOps.opsForValue().set(
								"LOGIN_PHONENO_SMSCODE_LIMITS" + secondKey,
								String.valueOf(checkCounts));
					}
				} else {
					redisOps.opsForValue().set(
							"LOGIN_PHONENO_SMSCODE_LIMITS" + secondKey,
							String.valueOf(ADD_COUNTS));
				}
			}
		}
		request.setAttribute(failureKeyAttribute, volidateError);
		return true;

		//
		// if(null!=session.getAttribute(smsCodeKey)){
		// userPhone=(String) session.getAttribute(smsCodeKey);
		// if(userPhone.equals(secondKey)&&(StringUtil.isNotEmpty(userPhone)||StringUtil.isNotEmpty(secondKey))){
		// }else{
		// session.setAttribute(smsCodeKey, secondKey);
		// total=1;
		// session.setAttribute("total", total);
		// }
		// }else{
		// session.setAttribute(smsCodeKey, secondKey);
		// }
		//
		// //SmsCodeBean.VALIDCODE + ":" +
		// code = redisOps.opsForValue().get(secondKey);
		// if(StringUtil.isNotEmpty(code)){
		// if(null!=session.getAttribute("total")){
		// total=(int) session.getAttribute("total");
		// }
		// total++;
		// //判断是否取totalCounts次
		// if(total>Integer.parseInt(totalCounts)){
		// code =null;
		// redisOps.delete(secondKey);
		// session.removeAttribute("total");
		// total=0;
		// }
		// }
		// session.setAttribute("total", total);
		// String paramsCode = httpServletRequest.getParameter(reqParamName);
		//
		//
		// if(paramsCode.equalsIgnoreCase(code)){
		// return true;
		// }

	}

	protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
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

	public void setSmsCodeKey(String smsCodeKey) {
		this.smsCodeKey = smsCodeKey;
	}

	public void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}

	public void setRedisOps(RedisTemplate<String, String> redisOps) {
		this.redisOps = redisOps;
	}

	public void setTotalCounts(String totalCounts) {
		this.totalCounts = totalCounts;
	}
}

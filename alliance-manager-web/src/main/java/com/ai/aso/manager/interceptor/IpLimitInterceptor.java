package com.ai.aso.manager.interceptor;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.base.utils.WebUtil;
import com.ai.aso.common.bo.ResourcesBo;
import com.ai.aso.common.component.ResourcesComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.component.ResourcesComp;
import com.ai.aso.manager.exception.NoAccessException;
import com.ai.aso.manager.exception.OperationFrequent;
import com.ai.aso.manager.exception.UnsettledException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class IpLimitInterceptor implements HandlerInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(IpLimitInterceptor.class);
	
	@Autowired
	private ResourcesComp resourcesService;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("进入IP限制拦截器");
		//获取前缀
		String interval_pre = GlobalParamSet.getString(BizConstants.SYS_IP_REQ_INTERVAL_KEY);
		//1. 获取IP地址
		String IP = WebUtil.getIpAddr(request);
		
		//2. 获取访问地址信息
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (StringUtil.isNotEmpty(contextPath))
			url = url.replaceFirst(contextPath, "");
		log.debug("拦截的url为[" + url + "]");
		
		//3. 获取资源
		ResourcesBo resourcesbo = resourcesService.findResourcesByUrl(url);
		
		//检查资源信息，未检测到资源，拒绝访问
		if (null == resourcesbo || StringUtil.isEmpty(resourcesbo.getHostGroups())) {
			throw new UnsettledException();
		}
		
		//4. 开始检查
		//IP配置、白名单检查，未配置或配置错误将拒绝所有访问
		String hostGroups = resourcesbo.getHostGroups();
		if (!"%".equals(hostGroups)) {
			//IP配置校验
			Pattern patten = Pattern.compile("^(?!^255(\\.255){3}$)(?!^0{1,3}(\\.0{1,3}){3}$)((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)($|(?!\\.$)\\.)){4}$");
			String[] ips = hostGroups.split("\\|");
			boolean valid = true;
			for (String ip : ips) {
				if(!patten.matcher(ip).matches()){
					valid = false;
				}
			}
			//IP配置正确
			if (valid) {
				List<String> list = Arrays.asList(ips);
				if (!list.contains(IP)) {
					throw new NoAccessException();
				}
			} else {
				log.debug("IP配置异常，拒绝全部访问");
				//IP配置异常，拒绝全部访问
				throw new UnsettledException();
			}
		}
		
		//检查是否来自统一异常的转发
		Boolean from = (Boolean) request.getSession().getAttribute(SysConstants.SYS_EXCEPTION_REDIRECT_FLAG);
		if (null != from && from) {
			request.getSession().removeAttribute(SysConstants.SYS_EXCEPTION_REDIRECT_FLAG);
			return true;
		}
		//4.1 校验频率
		Integer interval = resourcesbo.getAccessInterval();
		
		if (interval <= 0) {
			//不拦截检查项
			log.debug("resources["+url+"] 未设置访问频率限制");
		} else {
			String key = interval_pre + IP + ":" + url;
			String val = redisTemplate.opsForValue().get(key);
			if (null != val) {
				//访问频率过快，请休息片刻
				throw new OperationFrequent();
			} else {
				redisTemplate.opsForValue().set(key, "1", interval, TimeUnit.SECONDS);
			}
		}
		
		//4.2 校验频次
		//获取前缀
		String count_pre = GlobalParamSet.getString(BizConstants.SYS_IP_REQ_LIMIT_KEY);
		String frequency = resourcesbo.getExt2();
		
		//检查参数合法性
		boolean b = Pattern.compile("^\\+?[1-9][0-9]*/\\+?[1-9][0-9]*$").matcher(frequency).matches();
		
		log.debug("校验频次参数合法性");
		if (b) {
			String[] temp = frequency.split("/");
			int count = Integer.parseInt(temp[0]);
			int time = Integer.parseInt(temp[1]);
			
			String key = count_pre + IP + ":" + url;
			if (redisTemplate.hasKey(key)) {
				int val = redisTemplate.opsForValue().increment(key, 1).intValue();
				if (val > count) {
					throw new OperationFrequent();
				}
			} else {
				log.debug("未检索到统计值，新建校验kv");
				redisTemplate.opsForValue().increment(key, 1);
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			
		} else {
			log.warn("资源参数错误[resources id: " + resourcesbo.getSourceId() + ",  frequency: " + frequency + "]");
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

}

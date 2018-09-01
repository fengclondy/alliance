package com.ai.aso.security.shiro.validCode;

import com.ai.aso.base.utils.RandomUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import javax.inject.Named;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * 自定义验证码
 * 
 * @author John
 */
@Named
@SuppressWarnings("serial")
public class SmsCodeBean implements Serializable {
	public static final String VALIDCODE = "smsValidCode";// 保存到session中的键
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;
	
	/**
	 * 生成验证码核心方法
	 */
	public String generate(String phone,OutputStream os) throws Exception {
		String code = RandomUtil.createRandom(RandomUtil.NUMBER, 6);
		//存入redits保留五分钟
		valueOps.set(phone, code, 300L, TimeUnit.SECONDS);
		return code;
	}
	
	public static void main(String[] args) throws Exception {
		SmsCodeBean a = new SmsCodeBean();
		System.out.println(a.generate(null,null));
	}
}

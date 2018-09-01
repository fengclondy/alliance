package com.ai.aso.manager.interceptor;

import com.ai.aso.base.constants.SysConstants;
import com.ai.aso.common.log.UnityLogService;
import com.ai.aso.common.log.model.UserOperLog;
import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.security.model.Principal;
import com.ai.aso.common.sequence.SequenceFactory;
import com.alibaba.fastjson.JSONArray;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 操作日志拦截类
 * 
 * @author Administrator
 *
 */
@Aspect
@Component
public class OperateLogAop {

	private static final Logger log = LoggerFactory.getLogger(OperateLogAop.class);

	@Autowired
	private UnityLogService unityLogService;
	@Autowired
	private SequenceFactory sequenceFactory;

	// 配置切入点
	@Pointcut("execution(* com.ai.aso.manager.web.viewService..*(..))")
	public void ServiceCall() {
	}

	/**
	 * 添加操作日志
	 * 
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Around(value = "ServiceCall() && @annotation(log)",argNames = "log")
	public Object ServiceCallCalls(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
		Object result = null;
		Subject subject = SecurityUtils.getSubject();
		Principal user = (Principal) subject.getPrincipals().getPrimaryPrincipal();

		UserOperLog userOperLog = new UserOperLog();
		userOperLog.setId(Long.parseLong(sequenceFactory.next(BizConstants.SEQ_KEY_OPERATELOG)));
		userOperLog.setLogDate(new Date());
		userOperLog.setLogLevel((short) 1);
		userOperLog.setOperator(user.getUserName());
		userOperLog.setOperatorId(user.getAccId());
		userOperLog.setOperComm(joinPoint.getSignature().getName());
		userOperLog.setOperDate(new Date());
		
		StringBuffer sb2 = new StringBuffer();
		if(user.getHostIp()!=null)
		{
			for(String ip : user.getHostIp())
			{
				sb2.append(ip+".");
			}
			userOperLog.setOperIp(sb2.toString());
		}else
		{
			userOperLog.setOperIp("-");
		}
		
		// 操作参数
		JSONArray array = new JSONArray();
		if (joinPoint.getArgs() != null) {
            for (Object obj : joinPoint.getArgs()) {
            	array.add(obj);
            }
            userOperLog.setOperParams(array.toJSONString());
        } else {
        	userOperLog.setOperParams("-");
		}

		userOperLog.setOperResult("failed");
		Signature signature =  joinPoint.getSignature();
		Class returnType = ((MethodSignature) signature).getReturnType();
		userOperLog.setOperType(returnType.getSimpleName());
		userOperLog.setSystemCode(GlobalParamSet.getString(SysConstants.SUB_SYS_MAN_CODE));
		
//		System.out.println("moduleName:" + log.moduleName());  
//        System.out.println("option:" + log.option());  
		userOperLog.setModelCode(log.moduleName());
		userOperLog.setModelName(log.option());
		
		unityLogService.operLogInsertSelective(userOperLog);
		
		result = joinPoint.proceed();
		
		userOperLog.setOperResult("sucess");
		
		unityLogService.operLogUpdate(userOperLog);

		return result;
	}
}

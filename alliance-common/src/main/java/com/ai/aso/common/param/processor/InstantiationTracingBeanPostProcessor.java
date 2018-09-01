package com.ai.aso.common.param.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.ai.aso.common.param.ParamLoadManager;
import com.ai.aso.common.param.service.ParamLoader;

public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);
	
	@Autowired
	private ParamLoader globalParamSetLoader;
	@Autowired
	private ParamLoader attributeSetLoader;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
		if (event.getApplicationContext().getParent() == null) {// root application context 没有parent，他就是老大.
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			log.info("spring容器初始化完毕，开始预加载");
			ParamLoadManager pm = new ParamLoadManager();
			
			pm.registerLoader(globalParamSetLoader.getClass().getSimpleName(), globalParamSetLoader);
			log.info("注册预加载项：GlobalParamSetLoader入预加载管理器");
			
			pm.registerLoader(attributeSetLoader.getClass().getSimpleName(), attributeSetLoader);
			log.info("注册预加载项：AttributeSetLoader入预加载管理器");
			
			log.info("预加载管理器正在初始化预加载");
			pm.initParam();
			log.info("预加载装填完毕");
		}
	}
}
package com.ai.aso.manager.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})  
@Documented
public @interface Log {
	//模块名  
    String moduleName() default "";  
    //操作内容  
    String option() default "";
}

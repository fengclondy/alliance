package com.ai.aso.base.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
/**
 * 读取配置文件
 * @author 李厚毅
 *
 */
public class AppProperties extends PropertyPlaceholderConfigurer 
{

	private static Map<String, String> ctxPropertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException 
		{
			AppProperties.this.setFileEncoding("utf-8");
			
			super.processProperties(beanFactory, props);
			
			super.setFileEncoding("utf-8");
			
			AppProperties.this.setFileEncoding("utf-8");
			
			ctxPropertiesMap = new HashMap<String, String>();
			
			for (Object key : props.keySet())
			{
				String keyStr = key.toString();
				String value = props.getProperty(keyStr);
				ctxPropertiesMap.put(keyStr, value);
			}
		
	}

	public static String getValue(String key)
	{
		return ctxPropertiesMap.get(key);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String v = AppProperties.getValue("upload.path");
//		System.out.println("******************"+v);
//		System.out.println(AppProperties.getValue("upload.path"));
//		System.out.println(AppProperties.getValue("upload.path"));
	}

}

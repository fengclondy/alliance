package com.ai.aso.common.param;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ai.aso.base.exception.BaseException;
import com.ai.aso.common.param.exception.ParamEnum;
import com.ai.aso.base.utils.StringUtil;

public class GlobalParamSet implements Serializable {

	private static GlobalParamSet singletonParamSet = null;

	private static final long serialVersionUID = 8053855798521554139L;
	
	private static final Logger log = LoggerFactory.getLogger(GlobalParamSet.class);

	/**
	 * 公共变量参数集
	 */
	private Map<String, String> paramSet;

	private GlobalParamSet() {
		this.paramSet = new HashMap<String, String>();
	}

	/**
	 * 获取单例方法
	 * 
	 * @return
	 */
	public static GlobalParamSet getInstance() {
		if (singletonParamSet == null) {
			singletonParamSet = new GlobalParamSet();
		}
		return singletonParamSet;
	}

	public static String getString(String paramKey) {
		return GlobalParamSet.getInstance().get(paramKey);
	}
	
	public static short getShort(String paramKey) {
		return Short.parseShort(GlobalParamSet.getInstance().get(paramKey));
	}
	
	public static int getInteger(String paramKey) {
		return Integer.parseInt(GlobalParamSet.getInstance().get(paramKey));
	}
	
	public static char getChar(String paramKey) {
		return GlobalParamSet.getInstance().get(paramKey).charAt(0);
	}
	
	public static long getLong(String paramKey) {
		return Long.parseLong(GlobalParamSet.getInstance().get(paramKey));
	}
	
	public static boolean getBoolean(String paramKey) {
		return Boolean.parseBoolean(GlobalParamSet.getInstance().get(paramKey));
	}
	
	public static float getFloat(String paramKey) {
		return Float.parseFloat(GlobalParamSet.getInstance().get(paramKey));
	}
	
	public static double getDouble(String paramKey) {
		return Double.parseDouble(GlobalParamSet.getInstance().get(paramKey));
	}

	public String put(String paramKey, String paramValue) {
		return this.paramSet.put(paramKey, paramValue);
	}

	public String get(String paramKey) {
		String rs = this.paramSet.get(paramKey);
		if (StringUtil.isEmpty(rs)) {
			log.debug("Global Param中未找到key: " + paramKey + "");
			throw new BaseException(ParamEnum.SYS_GLOBAL_PARAMS_NOT_FOUND);
		}
		return rs;
	}

	public String remove(String paramKey) {
		return this.paramSet.remove(paramKey);

	}

	public boolean containsKey(String paramKey) {
		return this.paramSet.containsKey(paramKey);
	}

	public boolean isEmpty() {
		return this.paramSet.isEmpty();
	}

	public void clear() {
		this.paramSet.clear();
	}
	
	public static void main(String[] args) {
		
	}

}

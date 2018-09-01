package com.ai.aso.common.param.service;

public interface ParamLoader {
	
	static final short IS_LOADED = 1;
	static final short IS_NOT_LOADED = 0;

	/**
	 * 初始加载
	 */
	public void init();

	/**
	 * 
	 * @param key
	 */
	public void reload(String key);

	/**
	 * 
	 */
	public void reloadAll();

}

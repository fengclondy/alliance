package com.ai.aso.common.service;

public interface LoginNameService {
	
	/**
	 * 根据登录名查找后台账户id
	 * @param loginName
	 * @return
	 */
	String findAcctIdFromMan(String loginName);
	
	/**
	 * 根据登录名查找门户账户id
	 * @param loginName
	 * @return
	 */
	String findAcctIdFromPor(String loginName);
}

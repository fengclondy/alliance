package com.ai.aso.common.service;

import com.ai.aso.common.db.model.LoginAcct;

public interface LoginAcctService {

	/**
	 * 新增市级管理员账户
	 * @param loginName
	 * @return acctId
	 */
	String addManagerAcct(String loginName, String roleId);
	
	/**
	 * 新增合作伙伴账户
	 * @param loginName
	 * @return acctId
	 */
	String addCustAcct(String loginName);
	
	/**
	 * 新增开放接口账户
	 * @param loginName
	 * @return
	 */
	String addCustEnablerAcct(String loginName);
	
	/**
	 * 重置密码（密码为随机密码）
	 * @param acctId
	 * @return
	 */
	String resetPassword(String acctId);
	
	/**
	 * 重置密码（密码为指定密码）
	 * @param acctId
	 * @return
	 */
	void resetPassword(String acctId, String pwd);
	
	/**
	 * 重置密码（密码为默认密码）
	 * @param acctId
	 * @return
	 */
	String resetDefaultPassword(String acctId);

	/**
	 * 移除随机账户
	 * @param acctId
	 */
	void removeCustEnablerApply(String acctId);
	
	/**
	 * 入参说明：若只提供明文密码及公钥，则返回新的私盐及密文，若提供明文、公钥、私盐，则返回密文
	 * @param loginAcct - acctId、password、salt
	 */
	public void encryptPassword(LoginAcct loginAcct);
}

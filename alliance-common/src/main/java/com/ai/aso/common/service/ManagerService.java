package com.ai.aso.common.service;

import com.ai.aso.common.bo.SysUserInfoBo;

public interface ManagerService {
	
	/**
	 * 新增管理员
	 * 
	 * @param userInfo
	 *            管理员信息
	 */
	String ceateManager(SysUserInfoBo userInfo);
	
	/**
	 * 修改管理员信息
	 * 
	 * @param userInfo
	 *            管理员信息
	 */
	String modifyManager(SysUserInfoBo userInfo);


	/**
	 * 根据管理员登陆ID获取管理员信息
	 * @param accId
	 * @return
     */
	SysUserInfoBo findManagerByAccId(String accId);
}

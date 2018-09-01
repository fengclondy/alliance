package com.ai.aso.common.component;

import com.ai.aso.common.bo.PageBo;
import com.ai.aso.common.bo.SysUserPageBo;
import com.ai.aso.common.db.model.User;
import com.ai.aso.common.bo.SysUserInfoBo;

public interface ManagerComp {
	
	/**
	 * 查询管理员分页数据
	 * @param user 查询条件
	 * @param pageBo 分页信息
	 * @returnTODOSysUserPageBo
	 */
	public SysUserPageBo findSysUserList(User user, PageBo pageBo);
	
	/**
	 * 新增管理员
	 * @param sysUserInfoBo 管理员信息
	 */
	public Integer createSysUser(SysUserInfoBo sysUserInfoBo);
	
	/**
	 * 修改管理员信息
	 * 
	 * @param user 管理员信息
	 */
	public String modifySysUser(User user);
	
}

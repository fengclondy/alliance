package com.ai.aso.common.component;

import java.util.List;

import com.ai.aso.common.bo.LoginAcctInfo;
import com.ai.aso.common.bo.PermissionBo;
import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.Role;

public interface LoginAcctComp {

	/**
	 * 新增用户账号
	 * 
	 * @param o
	 *            账号信息
	 */
	public String addUserAcct(LoginAcctInfo loginAcctInfo);
	
	/**
	 * 获取该账号未授予角色列表
	 * 
	 * @param acctId  账号ID
	 * @return 未分配角色列表
	 */
	public List<Role> findUnGrantRole(String acctId);
	
	/**
	 * 获取该账号已授予角色列表
	 * 
	 * @param acctId 账号ID
	 * @return 已分配角色列表
	 */
	public List<Role> findGrantedRole(String acctId);

	/**
	 * 授予账号角色
	 * 
	 * @param acctId 账号ID
	 * @param roleIdList 角色ID列表
	 */
	public Integer grantRole(String acctId, List<Integer> roleIdList);
	
	/**
	 * 根据登录名获取与登录账号关联的登录名列表
	 * @param username 登录账号
	 * */
	public List<LoginName> findLoginName(String username);
	
	/**
	 * 根据账号ID获取与登录账号关联的登录名列表
	 * @param username 账号ID
	 * */
	public List<LoginName> findLoginNameById(String acctId);
	
	/**
	 * 修改管理员信息
	 * 
	 * @param id 用户ID
	 * @param oldPwd
	 *            原密码
	 * @param newPwd
	 *            新密码
	 */
	public Integer modifyLoginAcct(LoginAcct loginAcct);
	
	/**
	 * 修改登录密码
	 * 
	 * @param acctId 账户ID
	 * @param oldPwd 原密码
	 * @param newPwd 新密码
	 */
	public Integer modifyPassWord(String acctId, String oldPwd, String newPwd);
	
	/**
	 * 重置登录密码
	 * 
	 * @param acctId 账户ID
	 */
	public Integer resetPassWord(String acctId, String resetPwd);
	
	
	/**
	 * 获取登录账号信息
	 * @param loginAcct 
	 * @param needExtInfo 是否获取扩展信息
	 * @returnTODOLoginAcctInfo
	 */
	public LoginAcctInfo findLoginAcctInfo(LoginAcct loginAcct, boolean needExtInfo);
	
	/**
	 * 根据登录名获取登录账号信息
	 * @param userName 登录名
	 * @param needExtInfo 是否获取扩展信息
	 * @returnTODOLoginAcctInfo
	 */
	public LoginAcctInfo findLoginAcctInfo(String userName, boolean needExtInfo);
	
	/**
	 * 获取不可作为登录账号名使用的列表
	 * @return 被排除的账号名列表
	 */
	public List<String> findLoginNameExcludeList();
	
	/**
	 * 根据账号ID禁用账号
	 * @param acctId 账号ID
	 * @returnTODOboolean
	 */
	public int disableLoginAcct(String acctId);
	
	/**
	 * 新增默认用户账号
	 * 
	 * @param o
	 *            账号信息
	 */
	public String addDefaultUserAcct(LoginAcctInfo loginAcctInfo);
	
	
	/**
	 * 获取账号所具有的权限
	 * @param acctId
	 * @returnTODOPermissionBo
	 */
	public PermissionBo findPermissionBo(String acctId);
}

package com.ai.aso.common.component;

import java.util.List;

import com.ai.aso.common.bo.CustBo;
import com.ai.aso.common.db.model.Cust;

public interface CustComp {
	
	/**
	 * 根据区域ID查询客户信息列表
	 * 
	 * @param id
	 *            区域ID
	 * @return 客户信息
	 */
	public List<CustBo> findCustByRegionId(String regionId);
	
	/**
	 * 根据客户管理者ID查询客户信息列表
	 * 
	 * @param id
	 *            客户管理者ID
	 * @return 客户信息
	 */
	public List<CustBo> findCustByManagerId(String managerId);
	
	/**
	 * 根据ID查询客户信息
	 * 
	 * @param id
	 *            客户ID
	 * @return 客户信息
	 */
	public CustBo findCustById(String id);

	/**
	 * 查找客户列表信息
	 * 
	 * @param o
	 * @return
	 */
	public List<CustBo> findCustList(CustBo bo);

	/**
	 * 补全客户扩展信息
	 * 
	 * @param o
	 */
	public void addExtCustInfo(CustBo bo);

	/**
	 * 修改用户信息
	 * 
	 * @param o
	 *            客户信息
	 */
	public void modifyCust(CustBo bo);

	/**
	 * 修改客户登录密码
	 * 
	 * @param id
	 *            客户ID
	 * @param oldPwd
	 *            原密码
	 * @param newPwd
	 *            新密码
	 */
	public void modifyCustPassword(String id, String oldPwd, String newPwd);

	/**
	 * 找回客户密码
	 * 
	 * @param id
	 *            客户ID
	 * @param newPwd
	 *            新密码
	 */
	public void retrieveCustPassword(String id, String newPwd);

	/**
	 * 删除客户信息
	 * @param custId
	 * 				客户ID
	 */
	public void removeCustById(String custId);

	/**
	 * 判断客户是否属于该管理员
	 */
	public boolean custIsManage(CustBo bo);
	
	/**
	 * 新增默认客户账号
	 */
	public CustBo addCustAcct(CustBo bo);
	
	/**
	 * 新增默认客户登录名
	 */
	public CustBo addCustAcctName(CustBo bo);

	/**
	 * 新增默认客户角色
	 */
	public CustBo addCustAcctRole(CustBo bo, List<String> roleIds);

	/**
	 * 客户资料审核不通过
	 * @param 
	 */
	public void noAuditCust(String custId);

	/**
	 * 客户资料审核通过
	 * @param 
	 */
	public void auditCust(Cust cust);

	/**
	 * 判断客户是否生效
	 * @param bo
	 */
	public boolean custIsValid(String custId);

	/**
	 * 客户名称模糊查询信息（支持拼音）
	 * @param transfer
	 * @return
	 */
	public List<CustBo> findCustListByCustNameLike(String custName, String managerId);
	
	/**
	 * 根据acctId查找客户信息
	 */
	public Cust findCustByAcctId(String acctId);

}

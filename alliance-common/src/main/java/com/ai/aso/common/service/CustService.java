package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.db.model.Cust;

public interface CustService {
	
	/**
	 * 根据地区查询客户列表<br>
	 * 必须查询条件为区域ID
	 * 
	 * @param o
	 *            查询条件
	 * @return 客户信息列表
	 */
	public List<Cust> findCustListByRegionId(String regionId);

	/**
	 * 根据地区查询客户列表, 提供分页查询功能<br>
	 * 必须查询条件为区域ID
	 * 
	 * @param o
	 *            查询条件
	 * @return 客户信息列表及分页信息
	 */
//	public List<CustBo> findCustListByRegion(String reginId);

	/**
	 * 新增客户
	 * 
	 * @param o
	 *            客户信息
	 * @return 客户ID
	 */
	public String addCust(Cust cust);

	/**
	 * 修改用户信息
	 * @param bo
	 * @param managerId
	 */
	public void modifyCust(Cust cust, String managerId);
	
	/**
	 * 
	 * @param custId
	 */
	public void removeCustById(String custId, String managerId);

	/**
	 * 根据客户登录的ID，查找客户的资料
	 * @param accId
	 * @return
	 */
	public Cust findCustByAcctId(String acctId);

	/**
	 * 根据客户号码查找客户资料
	 * @param crmUserCode
	 * @return
	 */
	public Cust findCustByUserCode(String crmUserCode);
	
	/**
	 * 根据客户ID查找客户资料
	 */
	public Cust findCustByCustId(String custId);
	
	public List<Cust> findCustListByCustNameLike(String custName, String regionId);
	
	/**
	 * 平行鉴权：访问
	 * @param custId
	 * @param userId
	 */
	public boolean authView(String custId, String userId);
	
	/**
	 * 检查所属地市范围
	 * @param custId
	 */
	public void checkCustRegion(String custId, String applyerRegionId);
}
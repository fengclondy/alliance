package com.ai.aso.common.service;

/**
 * 账务管理
 * @author bianxiaowen
 *
 */
@Deprecated
public interface BillManagerService {
	
	/**
	 * 出账统计
	 */
	public void outBill();

	/**
	 * 入账统计
	 */
	public void inBill(String[] billId);
	
}

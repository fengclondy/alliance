package com.ai.aso.common.service;

public interface BackupTableDataService {
	/**
	 * 备份合同表
	 */
	void backupContractData();

	/**
	 * 备份合同账本表
	 */
	void backupContractBookData();

	/**
	 * 备份本次缴费记录表
	 */
	void backupPaymentData();

	/**
	 * 备份所有未出账数据
	 */
	void backupCostBillData();

	/**
	 * 备份本次使用量表
	 */
	void backupDataBookaData();
	
	/**
	 * 备份客户信息表
	 * 
	 */
	void backupCustData();
	/**
	 * 入合同账本备份表
	 */
	void backupContbookDisk();
	/**
	 * 入量本备份表
	 */
	void backupDatabookDisk();
	/**
	 * 备份所有表文件入口
	 */
	void backupFile();
	
	/**
	 * 备份所有表入口
	 */
	void backupTable();
	void backupBillrecAndCostbill();
}

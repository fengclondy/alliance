package com.ai.aso.common.service;

public interface ContractBookRecordService {
	
	/**
	 * 转存保证金操作记录
	 * @param contId
	 * @param amount
	 * @param acctId
	 */
	int transferDeposit(String contId, long amount);

	int overdraft(String contId, long amount);
}

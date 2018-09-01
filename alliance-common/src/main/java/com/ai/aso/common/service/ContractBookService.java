package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.db.model.ContractBook;

public interface ContractBookService {

	void addContractBook(List<ContractBook> bookList);

	/**
	 * 查询保证金余额
	 * @param contId
	 * @return
	 */
	long findDeposit(String contId);

	/**
	 * 查询透支金额
	 * @param contId
	 * @return
	 */
	long findCredit(String contId);

	/**
	 * 查询已付金额
	 * @param contId
	 * @return
	 */
	long findPayment(String contId);

	/**
	 * 转存保证金
	 * @param contId
	 * @param amount
	 * @return
	 */
	int transferDeposit(String contId, long amount);

	/**
	 * 透支
	 * @param contId
	 * @param amount
	 * @return
	 */
	int overdraft(String contId, long amount);

}

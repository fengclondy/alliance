package com.ai.aso.common.service;

import com.ai.aso.common.bo.ContractBookBo;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.DataBooka;

/**
 * 账本管理
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月28日
 *
 */
public interface BookManagerService {
	/**
	 * 支付账本新增
	 * @param amount
	 * @param bo
	 * @return
	 */
	String PaymentBookOpen(String amount, ContractBookBo bo);
	/**
	 * 支付账本收入
	 * @param amount
	 * @param bo
	 * @return
	 */
	String PaymentBookIncome(String amount, ContractBookBo bo);
	
	/**
	 * 支付账本支出
	 * @param amount
	 * @param bo
	 * @return
	 */
	
	String PaymentBookPay(String amount, ContractBookBo bo);
	/**
	 * 保证金账本新增
	 * @param amount
	 * @param bo
	 * @return
	 */
	String DepositBookOpen(String amount, ContractBookBo bo);
	/**
	 * 保证金账本收入
	 * @param amount
	 * @param bo
	 * @return
	 */
	String DepositBookIncome(String amount, ContractBookBo bo);
	/**
	 * 保证金账本收入
	 * @param amount
	 * @param bo
	 * @return
	 */
	String DepositBookPay(String amount, ContractBookBo bo);
	/**
	 * 透支账本新增
	 * @param amount
	 * @param bo
	 * @return
	 */
	String creditBookOpen(String amount, ContractBookBo bo);
	/**
	 * 透支账本收入
	 * @param amount
	 * @param bo
	 * @return
	 */
	String creditBookIncome(String amount, ContractBookBo bo);
	/**
	 * 透支账本支出
	 * @param amount
	 * @param bo
	 * @return
	 */
	String creditBookPay(String amount, ContractBookBo bo);
	/**
	 * 支付账本收入
	 * @param amount
	 * @param contId
	 * @return
	 */
	String paymentBookPay(long amount, String contId);
	/**
	 * 支付账本支出
	 * @param amount
	 * @param contId
	 * @return
	 */
	String paymentBookIncome(long amount, String contId);
	/**
	 * 保证金账本收入
	 * @param amount
	 * @param contId
	 * @return
	 */
	String depositBookIncome(long amount, String contId);
	/**
	 * 保证金账本支出
	 * @param amount
	 * @param contId
	 * @return
	 */
	String depositBookPay(long amount, String contId);
	
	/**
	 * 信用账户支出
	 * @param amount
	 * @param contId
	 * @return
	 */
	String creditBookOut(long amount, String contId);
	
	/**
	 * 新增流量分销量本
	 * @param dataBooka
	 * @return
	 */
	int addDataBook(Contract contract);
}

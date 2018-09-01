package com.ai.aso.common.component;

import com.ai.aso.common.bo.ContractBookBo;
/**
 * 账本管理
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月29日
 *
 */
public interface BookManagerComp {
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 支付账本新建
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
	 * 保证金账本新建
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
	 * 透支账本新建
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
	
}

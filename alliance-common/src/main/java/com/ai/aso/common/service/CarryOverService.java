package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.db.model.Contract;

public interface CarryOverService {
	/**
	 * 合同状态
	 * @param contId
	 * @return
	 */
	boolean cheakState(String contId);

	/**
	 * 余额结转转入（目标合同）
	 * @param contract
	 * @param managerId
	 * @return
	 */
	int insertPaymentIn(Contract contract, String managerId);

	/**
	 * 余额结转转出（源合同）
	 * @param contract
	 * @param managerId
	 * @return
	 */
	int insertPaymentOut(Contract contract, String managerId);

	/**
	 * 合同列收处理
	 * @param billMonth
	 * @param custId
	 * @param list
	 * @param amount
	 */
 	void dealCont(String billMonth, String custId, List<Contract> list, Long amount);

	/**
	 * 统计入账数据
	 *
	 * @param billMonth 入账账期
	 * @param custId    客户
	 */
	int costBillEntry(String billMonth, String custId, List<Contract> list);

	/**
	 * 收入摊分
	 *
	 * @param billMonth 入账账期
	 * @param custId    客户
	 */
	int repartitionBill(String billMonth, String custId, List<Contract> list, Long amount);
	/**
	 * 合同余额（有效合同）
	 * @param contId
	 * @return
	 */
	Long getBlance(String contId);

	/**
	 * 生效合同校验
	 * @param contId
	 * @return
	 */
	boolean validatorState(String contId);
	/**
	 * 获取有余额合同
	 * @return
	 */
	List<String> checkCurrBalance() ;
}

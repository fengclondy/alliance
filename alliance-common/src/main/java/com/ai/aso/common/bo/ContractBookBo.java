package com.ai.aso.common.bo;

import com.ai.aso.common.db.model.ContractBook;

/**
 * 合同账本Bo
 * <p>
 * Description:
 * </p>
 *
 * @author liuwu
 * @date 2016年9月28日
 *
 */
public class ContractBookBo {

	private ContractBook contractBook;

	public ContractBookBo() {
		contractBook = new ContractBook();
	}

	public ContractBook toContractBook() {
		return this.contractBook;
	}

	public ContractBook getContractBook() {
		return contractBook;
	}

	public void setContractBook(ContractBook contractBook) {
		this.contractBook = contractBook;
	}

}

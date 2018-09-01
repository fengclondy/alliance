package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.db.model.Contract;
import com.ai.aso.common.db.model.ContractItem;

public class ContractBo {
	// 合同
	private Contract contract;
	// 合同项
	private List<ContractItem> contractItems;

	public ContractBo() {
		this.contract = new Contract();
		this.contractItems = new ArrayList<ContractItem>();

	}
	public Contract toContractt() {
		// TODO Auto-generated method stub
		return this.contract;
	}
	public List<ContractItem> toContractItems() {
		// TODO Auto-generated method stub
		return this.contractItems;
	}
	public static ContractBo fromContractAndContractItems(Contract contract, List<ContractItem> contractItems) {
		// TODO Auto-generated method stub
		ContractBo bo = new ContractBo();
		bo.contract = contract;
		bo.contractItems = contractItems;
		return bo;
	}
	public static ContractBo fromContract(Contract contract) {
		// TODO Auto-generated method stub
		ContractBo bo = new ContractBo();
		bo.contract = contract;
		return bo;
	}
	
	
	
	
	public static List<ContractBo> fromContractAndContractItems(List<Contract> contractList, List<ContractItem> contractItems) {
		List<ContractBo> boList = new ArrayList<ContractBo>();

		Map<String, ContractItem> contractItemsMap = new HashMap<String, ContractItem>();
		if (null != contractItems) {
			for (ContractItem contractItem : contractItems) {
				contractItemsMap.put(contractItem.getContId(), contractItem);
			}
		}

		for (Contract contract : contractList) {
			ContractBo bo = new ContractBo();
			if (null != contract) {
				bo.setContract(contract);;
				String contId = contract.getContId();
				if (StringUtil.isNotEmpty(contId)) {
					
					//bo.setContractItems(contractItemsMap.get(contId));
				}

				boList.add(bo);
			}
		}

		return boList;
	}
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public List<ContractItem> getContractItems() {
		return contractItems;
	}
	public void setContractItems(List<ContractItem> contractItems) {
		this.contractItems = contractItems;
	}


	
}

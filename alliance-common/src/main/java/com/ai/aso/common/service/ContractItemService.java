package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.db.model.ContractItem;

public interface ContractItemService {

	void addContractItem(List<ContractItem> item);

	List<ContractItem> findContractItemByContId(String contId);

}

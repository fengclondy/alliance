package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.db.model.ContractOff;

public interface ContractOffService {

	void addContractOff(List<ContractOff> offList);

	List<ContractOff> findContractOffByContId(String contId);

}

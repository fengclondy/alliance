package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.db.dao.ContractOffMapper;
import com.ai.aso.common.db.model.ContractOff;
import com.ai.aso.common.db.model.ContractOffExample;
import com.ai.aso.common.service.ContractOffService;

@Service
public class ContractOffServiceImpl implements ContractOffService{
	
	@Autowired
	private ContractOffMapper contractOffMapper;

	@Override
	public void addContractOff(List<ContractOff> offList) {
		for (ContractOff off : offList) {
			contractOffMapper.insertSelective(off);
		}
		
	}

	@Override
	public List<ContractOff> findContractOffByContId(String contId) {
		ContractOffExample example = new ContractOffExample();
		example.createCriteria().andContIdEqualTo(contId);
		return contractOffMapper.selectByExample(example);
	}

}

package com.ai.aso.common.component.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.component.AcctRoleComp;
import com.ai.aso.common.db.dao.AcctRoleMapper;
import com.ai.aso.common.db.model.AcctRole;
import com.ai.aso.common.db.model.AcctRoleExample;

@Component
public class AcctRoleCompImpl implements AcctRoleComp {

	@Autowired
	private AcctRoleMapper acctRoleMapper;
	
	@Override
	public List<AcctRole> selectByUid(String userId) {
		AcctRoleExample acctRoleExample = new AcctRoleExample();
		acctRoleExample.createCriteria().andAcctIdEqualTo(userId);
		List<AcctRole> acctRoles = acctRoleMapper.selectByExample(acctRoleExample);
		return acctRoles;
	}
	
	@Override
	public List<Integer> selectByAcctId(String acctId) {
		AcctRoleExample acctRoleExample = new AcctRoleExample();
		acctRoleExample.createCriteria().andAcctIdEqualTo(acctId);
		List<AcctRole> acctRoles = acctRoleMapper.selectByExample(acctRoleExample);
		
		List<Integer> list = new ArrayList<Integer>();
		for(AcctRole ar : acctRoles) {
			list.add(ar.getRoleId());
		}
		return list;
	}
}

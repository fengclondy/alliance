package com.ai.aso.common.component;

import java.util.List;

import com.ai.aso.common.db.model.AcctRole;


public interface AcctRoleComp {
	
	public List<AcctRole> selectByUid(String userId);
	
	public List<Integer> selectByAcctId(String acctId);
}

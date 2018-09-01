package com.ai.aso.common.db.dao.ext;

import java.util.List;

import com.ai.aso.common.db.model.AcctRole;

public interface AcctRoleExtMapper {
	int insertBatch(List<AcctRole> recordList);
}

package com.ai.aso.common.db.dao.ext;

import java.util.List;

import com.ai.aso.common.db.model.AcctRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcctRoleExtMapper {
	int insertBatch(List<AcctRole> recordList);
}

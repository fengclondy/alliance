package com.ai.aso.common.db.dao.ext;

import com.ai.aso.common.db.model.LoginName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LoginNameExtMapper {
	int insertBatch(List<LoginName> loginNameList);
}
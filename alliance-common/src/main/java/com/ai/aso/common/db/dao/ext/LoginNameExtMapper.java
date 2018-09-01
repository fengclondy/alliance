package com.ai.aso.common.db.dao.ext;

import com.ai.aso.common.db.model.LoginName;
import java.util.List;

public interface LoginNameExtMapper {
	int insertBatch(List<LoginName> loginNameList);
}
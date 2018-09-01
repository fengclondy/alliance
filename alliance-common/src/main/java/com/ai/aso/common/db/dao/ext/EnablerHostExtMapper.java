package com.ai.aso.common.db.dao.ext;

import java.util.List;

import com.ai.aso.common.db.model.EnablerHost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnablerHostExtMapper {

		public void insertHostIP(List<EnablerHost> lists);
}

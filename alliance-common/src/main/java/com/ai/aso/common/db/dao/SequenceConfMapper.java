package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.SequenceConf;

import java.util.List;

public interface SequenceConfMapper {

	SequenceConf selectByPrimaryKey(String seqKey);

	List<SequenceConf> selectAll();

	int saveNumberVal(SequenceConf record);

}
package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.SequenceConf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SequenceConfMapper {

	SequenceConf selectByPrimaryKey(String seqKey);

	List<SequenceConf> selectAll();

	int saveNumberVal(SequenceConf record);

}
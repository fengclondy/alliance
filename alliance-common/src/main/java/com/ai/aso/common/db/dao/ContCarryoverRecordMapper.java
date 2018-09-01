package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ContCarryoverRecord;
import com.ai.aso.common.db.model.ContCarryoverRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ContCarryoverRecordMapper {
    int countByExample(ContCarryoverRecordExample example);

    int deleteByExample(ContCarryoverRecordExample example);

    int deleteByPrimaryKey(Long operNo);

    int insert(ContCarryoverRecord record);

    int insertSelective(ContCarryoverRecord record);

    List<ContCarryoverRecord> selectByExample(ContCarryoverRecordExample example);

    ContCarryoverRecord selectByPrimaryKey(Long operNo);

    int updateByExampleSelective(@Param("record") ContCarryoverRecord record, @Param("example") ContCarryoverRecordExample example);

    int updateByExample(@Param("record") ContCarryoverRecord record, @Param("example") ContCarryoverRecordExample example);

    int updateByPrimaryKeySelective(ContCarryoverRecord record);

    int updateByPrimaryKey(ContCarryoverRecord record);
}
package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ContbookRecord;
import com.ai.aso.common.db.model.ContbookRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ContbookRecordMapper {
    int countByExample(ContbookRecordExample example);

    int deleteByExample(ContbookRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContbookRecord record);

    int insertSelective(ContbookRecord record);

    List<ContbookRecord> selectByExample(ContbookRecordExample example);

    ContbookRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContbookRecord record, @Param("example") ContbookRecordExample example);

    int updateByExample(@Param("record") ContbookRecord record, @Param("example") ContbookRecordExample example);

    int updateByPrimaryKeySelective(ContbookRecord record);

    int updateByPrimaryKey(ContbookRecord record);
}
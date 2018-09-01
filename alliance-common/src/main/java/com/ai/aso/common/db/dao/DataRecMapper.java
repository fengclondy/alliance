package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.DataRec;
import com.ai.aso.common.db.model.DataRecExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DataRecMapper {
    int countByExample(DataRecExample example);

    int deleteByExample(DataRecExample example);

    int deleteByPrimaryKey(String recNo);

    int insert(DataRec record);

    int insertSelective(DataRec record);

    List<DataRec> selectByExample(DataRecExample example);

    DataRec selectByPrimaryKey(String recNo);

    int updateByExampleSelective(@Param("record") DataRec record, @Param("example") DataRecExample example);

    int updateByExample(@Param("record") DataRec record, @Param("example") DataRecExample example);

    int updateByPrimaryKeySelective(DataRec record);

    int updateByPrimaryKey(DataRec record);
}
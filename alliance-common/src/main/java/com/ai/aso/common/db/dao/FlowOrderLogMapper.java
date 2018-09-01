package com.ai.aso.common.db.dao;

import java.util.List;

import com.ai.aso.common.db.model.FlowOrderLog;
import com.ai.aso.common.db.model.FlowOrderLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FlowOrderLogMapper {
    int countByExample(FlowOrderLogExample example);

    int deleteByExample(FlowOrderLogExample example);

    int deleteByPrimaryKey(String requestNo);

    int insert(FlowOrderLog record);

    int insertSelective(FlowOrderLog record);

    List<FlowOrderLog> selectByExample(FlowOrderLogExample example);

    FlowOrderLog selectByPrimaryKey(String requestNo);

    int updateByExampleSelective(@Param("record") FlowOrderLog record, @Param("example") FlowOrderLogExample example);

    int updateByExample(@Param("record") FlowOrderLog record, @Param("example") FlowOrderLogExample example);

    int updateByPrimaryKeySelective(FlowOrderLog record);

    int updateByPrimaryKey(FlowOrderLog record);
}
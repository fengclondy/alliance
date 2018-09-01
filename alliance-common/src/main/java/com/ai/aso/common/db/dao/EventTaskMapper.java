package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.EventTask;
import com.ai.aso.common.db.model.EventTaskExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EventTaskMapper {
    int countByExample(EventTaskExample example);

    int deleteByExample(EventTaskExample example);

    int deleteByPrimaryKey(Long taskId);

    int insert(EventTask record);

    int insertSelective(EventTask record);

    List<EventTask> selectByExample(EventTaskExample example);

    EventTask selectByPrimaryKey(Long taskId);

    int updateByExampleSelective(@Param("record") EventTask record, @Param("example") EventTaskExample example);

    int updateByExample(@Param("record") EventTask record, @Param("example") EventTaskExample example);

    int updateByPrimaryKeySelective(EventTask record);

    int updateByPrimaryKey(EventTask record);
}
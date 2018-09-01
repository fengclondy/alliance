package com.ai.aso.common.db.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ai.aso.common.db.model.DataBookaDisk;
import com.ai.aso.common.db.model.DataBookaDiskExample;
@Mapper
public interface DataBookaDiskMapper {
    int countByExample(DataBookaDiskExample example);

    int deleteByExample(DataBookaDiskExample example);

    int insert(DataBookaDisk record);

    int insertSelective(DataBookaDisk record);

    List<DataBookaDisk> selectByExample(DataBookaDiskExample example);

    int updateByExampleSelective(@Param("record") DataBookaDisk record, @Param("example") DataBookaDiskExample example);

    int updateByExample(@Param("record") DataBookaDisk record, @Param("example") DataBookaDiskExample example);
}
package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.DataBookaStock;
import com.ai.aso.common.db.model.DataBookaStockExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DataBookaStockMapper {
    int countByExample(DataBookaStockExample example);

    int deleteByExample(DataBookaStockExample example);

    int deleteByPrimaryKey(String stockId);

    int insert(DataBookaStock record);

    int insertSelective(DataBookaStock record);

    List<DataBookaStock> selectByExample(DataBookaStockExample example);

    DataBookaStock selectByPrimaryKey(String stockId);

    int updateByExampleSelective(@Param("record") DataBookaStock record, @Param("example") DataBookaStockExample example);

    int updateByExample(@Param("record") DataBookaStock record, @Param("example") DataBookaStockExample example);

    int updateByPrimaryKeySelective(DataBookaStock record);

    int updateByPrimaryKey(DataBookaStock record);
}
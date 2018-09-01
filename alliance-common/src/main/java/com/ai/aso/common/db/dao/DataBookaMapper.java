package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.DataBooka;
import com.ai.aso.common.db.model.DataBookaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DataBookaMapper {
    int countByExample(DataBookaExample example);

    int deleteByExample(DataBookaExample example);

    int deleteByPrimaryKey(String bookId);

    int insert(DataBooka record);

    int insertSelective(DataBooka record);

    List<DataBooka> selectByExample(DataBookaExample example);

    DataBooka selectByPrimaryKey(String bookId);

    int updateByExampleSelective(@Param("record") DataBooka record, @Param("example") DataBookaExample example);

    int updateByExample(@Param("record") DataBooka record, @Param("example") DataBookaExample example);

    int updateByPrimaryKeySelective(DataBooka record);

    int updateByPrimaryKey(DataBooka record);
}
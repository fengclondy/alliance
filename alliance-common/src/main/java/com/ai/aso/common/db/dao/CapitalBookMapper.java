package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CapitalBook;
import com.ai.aso.common.db.model.CapitalBookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CapitalBookMapper {
    int countByExample(CapitalBookExample example);

    int deleteByExample(CapitalBookExample example);

    int deleteByPrimaryKey(String bookId);

    int insert(CapitalBook record);

    int insertSelective(CapitalBook record);

    List<CapitalBook> selectByExample(CapitalBookExample example);

    CapitalBook selectByPrimaryKey(String bookId);

    int updateByExampleSelective(@Param("record") CapitalBook record, @Param("example") CapitalBookExample example);

    int updateByExample(@Param("record") CapitalBook record, @Param("example") CapitalBookExample example);

    int updateByPrimaryKeySelective(CapitalBook record);

    int updateByPrimaryKey(CapitalBook record);
}
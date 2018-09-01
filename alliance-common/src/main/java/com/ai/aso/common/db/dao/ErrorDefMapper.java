package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ErrorDef;
import com.ai.aso.common.db.model.ErrorDefExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ErrorDefMapper {
    int countByExample(ErrorDefExample example);

    int deleteByExample(ErrorDefExample example);

    int deleteByPrimaryKey(String errCode);

    int insert(ErrorDef record);

    int insertSelective(ErrorDef record);

    List<ErrorDef> selectByExample(ErrorDefExample example);

    ErrorDef selectByPrimaryKey(String errCode);

    int updateByExampleSelective(@Param("record") ErrorDef record, @Param("example") ErrorDefExample example);

    int updateByExample(@Param("record") ErrorDef record, @Param("example") ErrorDefExample example);

    int updateByPrimaryKeySelective(ErrorDef record);

    int updateByPrimaryKey(ErrorDef record);
}
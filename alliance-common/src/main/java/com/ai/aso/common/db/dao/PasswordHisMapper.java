package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.PasswordHis;
import com.ai.aso.common.db.model.PasswordHisExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PasswordHisMapper {
    int countByExample(PasswordHisExample example);

    int deleteByExample(PasswordHisExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PasswordHis record);

    int insertSelective(PasswordHis record);

    List<PasswordHis> selectByExample(PasswordHisExample example);

    PasswordHis selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PasswordHis record, @Param("example") PasswordHisExample example);

    int updateByExample(@Param("record") PasswordHis record, @Param("example") PasswordHisExample example);

    int updateByPrimaryKeySelective(PasswordHis record);

    int updateByPrimaryKey(PasswordHis record);
}
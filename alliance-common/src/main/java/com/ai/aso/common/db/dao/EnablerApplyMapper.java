package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.EnablerApply;
import com.ai.aso.common.db.model.EnablerApplyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EnablerApplyMapper {
    int countByExample(EnablerApplyExample example);

    int deleteByExample(EnablerApplyExample example);

    int deleteByPrimaryKey(Long applyId);

    int insert(EnablerApply record);

    int insertSelective(EnablerApply record);

    List<EnablerApply> selectByExample(EnablerApplyExample example);

    EnablerApply selectByPrimaryKey(Long applyId);

    int updateByExampleSelective(@Param("record") EnablerApply record, @Param("example") EnablerApplyExample example);

    int updateByExample(@Param("record") EnablerApply record, @Param("example") EnablerApplyExample example);

    int updateByPrimaryKeySelective(EnablerApply record);

    int updateByPrimaryKey(EnablerApply record);
}
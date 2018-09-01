package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.EnablerHost;
import com.ai.aso.common.db.model.EnablerHostExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface EnablerHostMapper {
    int countByExample(EnablerHostExample example);

    int deleteByExample(EnablerHostExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EnablerHost record);

    int insertSelective(EnablerHost record);

    List<EnablerHost> selectByExample(EnablerHostExample example);

    EnablerHost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EnablerHost record, @Param("example") EnablerHostExample example);

    int updateByExample(@Param("record") EnablerHost record, @Param("example") EnablerHostExample example);

    int updateByPrimaryKeySelective(EnablerHost record);

    int updateByPrimaryKey(EnablerHost record);
}
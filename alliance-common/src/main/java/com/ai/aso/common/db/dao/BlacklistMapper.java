package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.Blacklist;
import com.ai.aso.common.db.model.BlacklistExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BlacklistMapper {
    int countByExample(BlacklistExample example);

    int deleteByExample(BlacklistExample example);

    int deleteByPrimaryKey(String blacklistKey);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    List<Blacklist> selectByExample(BlacklistExample example);

    Blacklist selectByPrimaryKey(String blacklistKey);

    int updateByExampleSelective(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByExample(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);
}
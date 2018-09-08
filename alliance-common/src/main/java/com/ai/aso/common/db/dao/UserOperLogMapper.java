package com.ai.aso.common.db.dao;

import java.util.List;

import com.ai.aso.common.db.model.UserOperLog;
import com.ai.aso.common.db.model.UserOperLogExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOperLogMapper {
    int countByExample(UserOperLogExample example);

    int deleteByExample(UserOperLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserOperLog record);

    int insertSelective(UserOperLog record);

    List<UserOperLog> selectByExample(UserOperLogExample example);

    UserOperLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserOperLog record, UserOperLogExample example);

    int updateByExample(UserOperLog record, UserOperLogExample example);

    int updateByPrimaryKeySelective(UserOperLog record);

    int updateByPrimaryKey(UserOperLog record);
}
package com.ai.aso.common.log.dao;

import java.util.List;

import com.ai.aso.common.log.model.UserLoginLog;
import com.ai.aso.common.log.model.UserLoginLogExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginLogMapper {
    int countByExample(UserLoginLogExample example);

    int deleteByExample(UserLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLoginLog record);

    int insertSelective(UserLoginLog record);

    List<UserLoginLog> selectByExample(UserLoginLogExample example);

    UserLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserLoginLog record, UserLoginLogExample example);

    int updateByExample(UserLoginLog record, UserLoginLogExample example);

    int updateByPrimaryKeySelective(UserLoginLog record);

    int updateByPrimaryKey(UserLoginLog record);
}
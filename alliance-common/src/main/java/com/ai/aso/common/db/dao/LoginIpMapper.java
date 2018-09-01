package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.LoginIp;
import com.ai.aso.common.db.model.LoginIpExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LoginIpMapper {
    int countByExample(LoginIpExample example);

    int deleteByExample(LoginIpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoginIp record);

    int insertSelective(LoginIp record);

    List<LoginIp> selectByExample(LoginIpExample example);

    LoginIp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoginIp record, @Param("example") LoginIpExample example);

    int updateByExample(@Param("record") LoginIp record, @Param("example") LoginIpExample example);

    int updateByPrimaryKeySelective(LoginIp record);

    int updateByPrimaryKey(LoginIp record);
}
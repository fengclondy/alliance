package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.LoginAcct;
import com.ai.aso.common.db.model.LoginAcctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginAcctMapper {
    int countByExample(LoginAcctExample example);

    int deleteByExample(LoginAcctExample example);

    int deleteByPrimaryKey(String acctId);

    int insert(LoginAcct record);

    int insertSelective(LoginAcct record);

    List<LoginAcct> selectByExample(LoginAcctExample example);

    LoginAcct selectByPrimaryKey(String acctId);

    int updateByExampleSelective(@Param("record") LoginAcct record, @Param("example") LoginAcctExample example);

    int updateByExample(@Param("record") LoginAcct record, @Param("example") LoginAcctExample example);

    int updateByPrimaryKeySelective(LoginAcct record);

    int updateByPrimaryKey(LoginAcct record);
}
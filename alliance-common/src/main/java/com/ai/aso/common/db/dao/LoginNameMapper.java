package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.LoginName;
import com.ai.aso.common.db.model.LoginNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginNameMapper {
    int countByExample(LoginNameExample example);

    int deleteByExample(LoginNameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoginName record);

    int insertSelective(LoginName record);

    List<LoginName> selectByExample(LoginNameExample example);

    LoginName selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoginName record, @Param("example") LoginNameExample example);

    int updateByExample(@Param("record") LoginName record, @Param("example") LoginNameExample example);

    int updateByPrimaryKeySelective(LoginName record);

    int updateByPrimaryKey(LoginName record);
}
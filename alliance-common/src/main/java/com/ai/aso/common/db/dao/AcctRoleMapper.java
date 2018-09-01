package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.AcctRole;
import com.ai.aso.common.db.model.AcctRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcctRoleMapper {
    int countByExample(AcctRoleExample example);

    int deleteByExample(AcctRoleExample example);

    int deleteByPrimaryKey(@Param("acctId") String acctId, @Param("roleId") Integer roleId);

    int insert(AcctRole record);

    int insertSelective(AcctRole record);

    List<AcctRole> selectByExample(AcctRoleExample example);

    int updateByExampleSelective(@Param("record") AcctRole record, @Param("example") AcctRoleExample example);

    int updateByExample(@Param("record") AcctRole record, @Param("example") AcctRoleExample example);
}
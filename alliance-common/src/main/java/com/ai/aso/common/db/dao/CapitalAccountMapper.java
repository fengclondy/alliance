package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CapitalAccount;
import com.ai.aso.common.db.model.CapitalAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CapitalAccountMapper {
    int countByExample(CapitalAccountExample example);

    int deleteByExample(CapitalAccountExample example);

    int deleteByPrimaryKey(String acctId);

    int insert(CapitalAccount record);

    int insertSelective(CapitalAccount record);

    List<CapitalAccount> selectByExample(CapitalAccountExample example);

    CapitalAccount selectByPrimaryKey(String acctId);

    int updateByExampleSelective(@Param("record") CapitalAccount record, @Param("example") CapitalAccountExample example);

    int updateByExample(@Param("record") CapitalAccount record, @Param("example") CapitalAccountExample example);

    int updateByPrimaryKeySelective(CapitalAccount record);

    int updateByPrimaryKey(CapitalAccount record);
}
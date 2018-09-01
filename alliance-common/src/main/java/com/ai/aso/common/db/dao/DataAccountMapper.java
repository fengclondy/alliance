package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.DataAccount;
import com.ai.aso.common.db.model.DataAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataAccountMapper {
    int countByExample(DataAccountExample example);

    int deleteByExample(DataAccountExample example);

    int deleteByPrimaryKey(String acctId);

    int insert(DataAccount record);

    int insertSelective(DataAccount record);

    List<DataAccount> selectByExample(DataAccountExample example);

    DataAccount selectByPrimaryKey(String acctId);

    int updateByExampleSelective(@Param("record") DataAccount record, @Param("example") DataAccountExample example);

    int updateByExample(@Param("record") DataAccount record, @Param("example") DataAccountExample example);

    int updateByPrimaryKeySelective(DataAccount record);

    int updateByPrimaryKey(DataAccount record);
}
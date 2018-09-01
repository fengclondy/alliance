package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CapitalRecord;
import com.ai.aso.common.db.model.CapitalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CapitalRecordMapper {
    int countByExample(CapitalRecordExample example);

    int deleteByExample(CapitalRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapitalRecord record);

    int insertSelective(CapitalRecord record);

    List<CapitalRecord> selectByExample(CapitalRecordExample example);

    CapitalRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapitalRecord record, @Param("example") CapitalRecordExample example);

    int updateByExample(@Param("record") CapitalRecord record, @Param("example") CapitalRecordExample example);

    int updateByPrimaryKeySelective(CapitalRecord record);

    int updateByPrimaryKey(CapitalRecord record);
}
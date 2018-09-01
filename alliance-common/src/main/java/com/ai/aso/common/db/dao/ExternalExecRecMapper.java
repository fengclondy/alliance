package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.ExternalExecRec;
import com.ai.aso.common.db.model.ExternalExecRecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExternalExecRecMapper {
    int countByExample(ExternalExecRecExample example);

    int deleteByExample(ExternalExecRecExample example);

    int deleteByPrimaryKey(Long execId);

    int insert(ExternalExecRec record);

    int insertSelective(ExternalExecRec record);

    List<ExternalExecRec> selectByExample(ExternalExecRecExample example);

    ExternalExecRec selectByPrimaryKey(Long execId);

    int updateByExampleSelective(@Param("record") ExternalExecRec record, @Param("example") ExternalExecRecExample example);

    int updateByExample(@Param("record") ExternalExecRec record, @Param("example") ExternalExecRecExample example);

    int updateByPrimaryKeySelective(ExternalExecRec record);

    int updateByPrimaryKey(ExternalExecRec record);
}
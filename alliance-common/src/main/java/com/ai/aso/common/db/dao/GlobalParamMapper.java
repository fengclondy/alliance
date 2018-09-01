package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.GlobalParam;
import com.ai.aso.common.db.model.GlobalParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GlobalParamMapper {
    int countByExample(GlobalParamExample example);

    int deleteByExample(GlobalParamExample example);

    int deleteByPrimaryKey(String paramKey);

    int insert(GlobalParam record);

    int insertSelective(GlobalParam record);

    List<GlobalParam> selectByExample(GlobalParamExample example);

    GlobalParam selectByPrimaryKey(String paramKey);

    int updateByExampleSelective(@Param("record") GlobalParam record, @Param("example") GlobalParamExample example);

    int updateByExample(@Param("record") GlobalParam record, @Param("example") GlobalParamExample example);

    int updateByPrimaryKeySelective(GlobalParam record);

    int updateByPrimaryKey(GlobalParam record);
}
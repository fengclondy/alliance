package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CustExt;
import com.ai.aso.common.db.model.CustExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustExtMapper {
    int countByExample(CustExtExample example);

    int deleteByExample(CustExtExample example);

    int deleteByPrimaryKey(Long custExtId);

    int insert(CustExt record);

    int insertSelective(CustExt record);

    List<CustExt> selectByExample(CustExtExample example);

    CustExt selectByPrimaryKey(Long custExtId);

    int updateByExampleSelective(@Param("record") CustExt record, @Param("example") CustExtExample example);

    int updateByExample(@Param("record") CustExt record, @Param("example") CustExtExample example);

    int updateByPrimaryKeySelective(CustExt record);

    int updateByPrimaryKey(CustExt record);
}
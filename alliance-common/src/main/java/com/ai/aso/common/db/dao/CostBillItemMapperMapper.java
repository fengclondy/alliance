package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CostBillItemMapper;
import com.ai.aso.common.db.model.CostBillItemMapperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostBillItemMapperMapper {
    int countByExample(CostBillItemMapperExample example);

    int deleteByExample(CostBillItemMapperExample example);

    int deleteByPrimaryKey(@Param("costRegion") Integer costRegion, @Param("billItemId") String billItemId);

    int insert(CostBillItemMapper record);

    int insertSelective(CostBillItemMapper record);

    List<CostBillItemMapper> selectByExample(CostBillItemMapperExample example);

    CostBillItemMapper selectByPrimaryKey(@Param("costRegion") Integer costRegion, @Param("billItemId") String billItemId);

    int updateByExampleSelective(@Param("record") CostBillItemMapper record, @Param("example") CostBillItemMapperExample example);

    int updateByExample(@Param("record") CostBillItemMapper record, @Param("example") CostBillItemMapperExample example);

    int updateByPrimaryKeySelective(CostBillItemMapper record);

    int updateByPrimaryKey(CostBillItemMapper record);
}
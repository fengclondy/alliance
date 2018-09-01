package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CostBillItem;
import com.ai.aso.common.db.model.CostBillItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CostBillItemMapper {
    int countByExample(CostBillItemExample example);

    int deleteByExample(CostBillItemExample example);

    int deleteByPrimaryKey(Long costItemId);

    int insert(CostBillItem record);

    int insertSelective(CostBillItem record);

    List<CostBillItem> selectByExample(CostBillItemExample example);

    CostBillItem selectByPrimaryKey(Long costItemId);

    int updateByExampleSelective(@Param("record") CostBillItem record, @Param("example") CostBillItemExample example);

    int updateByExample(@Param("record") CostBillItem record, @Param("example") CostBillItemExample example);

    int updateByPrimaryKeySelective(CostBillItem record);

    int updateByPrimaryKey(CostBillItem record);
}
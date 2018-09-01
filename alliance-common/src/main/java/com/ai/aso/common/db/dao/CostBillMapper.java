package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CostBill;
import com.ai.aso.common.db.model.CostBillExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CostBillMapper {
    int countByExample(CostBillExample example);

    int deleteByExample(CostBillExample example);

    int deleteByPrimaryKey(Long costId);

    int insert(CostBill record);

    int insertSelective(CostBill record);

    List<CostBill> selectByExample(CostBillExample example);

    CostBill selectByPrimaryKey(Long costId);

    int updateByExampleSelective(@Param("record") CostBill record, @Param("example") CostBillExample example);

    int updateByExample(@Param("record") CostBill record, @Param("example") CostBillExample example);

    int updateByPrimaryKeySelective(CostBill record);

    int updateByPrimaryKey(CostBill record);
}
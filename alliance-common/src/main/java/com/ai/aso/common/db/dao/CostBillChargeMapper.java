package com.ai.aso.common.db.dao;

import com.ai.aso.common.db.model.CostBillCharge;
import com.ai.aso.common.db.model.CostBillChargeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CostBillChargeMapper {
    int countByExample(CostBillChargeExample example);

    int deleteByExample(CostBillChargeExample example);

    int deleteByPrimaryKey(Long costChargeId);

    int insert(CostBillCharge record);

    int insertSelective(CostBillCharge record);

    List<CostBillCharge> selectByExample(CostBillChargeExample example);

    CostBillCharge selectByPrimaryKey(Long costChargeId);

    int updateByExampleSelective(@Param("record") CostBillCharge record, @Param("example") CostBillChargeExample example);

    int updateByExample(@Param("record") CostBillCharge record, @Param("example") CostBillChargeExample example);

    int updateByPrimaryKeySelective(CostBillCharge record);

    int updateByPrimaryKey(CostBillCharge record);
}
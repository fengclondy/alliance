package com.ai.aso.common.webService.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ai.aso.common.db.model.CostBill;
import com.ai.aso.common.webService.model.CostBillBo;
@Mapper
public interface QuickCostBillBoMapper {
	
	List<CostBillBo> queryCostBillBo(Integer state);
	
	
	
}

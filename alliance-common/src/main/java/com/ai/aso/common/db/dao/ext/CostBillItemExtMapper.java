package com.ai.aso.common.db.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ai.aso.common.db.model.CostBillItem;
@Mapper
public interface CostBillItemExtMapper {
	
	public int batchInsert(List<CostBillItem> list);
	
	Long selectCulmunFee(@Param("billMonth") String billMonth, @Param("ext1") String ext1, @Param("custId") String custId, @Param("regionId") String regionId);
	
}
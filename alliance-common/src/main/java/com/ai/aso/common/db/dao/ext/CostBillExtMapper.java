package com.ai.aso.common.db.dao.ext;

import com.ai.aso.common.db.model.CostBill;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CostBillExtMapper {

	int batchInsert(List<CostBill> list);
	CostBill queryCostBill(@Param("custId") String custId);
}
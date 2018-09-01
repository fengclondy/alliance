package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.db.dao.CostBillItemMapperMapper;
import com.ai.aso.common.db.model.CostBillItemMapper;
import com.ai.aso.common.db.model.CostBillItemMapperExample;
import com.ai.aso.common.service.BillItemMapService;
@Service("billItemMapService")
public class BillItemMapServiceImpl implements BillItemMapService {

	@Autowired
	private CostBillItemMapperMapper costBillItemMapperMapper;

	@Override
	public String getBillItemId(Integer costRegion) {
		// TODO Auto-generated method stub
		CostBillItemMapperExample example = new CostBillItemMapperExample();
		example.createCriteria().andCostRegionEqualTo(costRegion);
		List<CostBillItemMapper> list = costBillItemMapperMapper.selectByExample(example);
		if (null != list&&list.size()>0) {
			CostBillItemMapper costBillItemMapper =list.get(0);
			return costBillItemMapper.getBillItemId();
		} else {
			return null;
		}
	}

}

package com.ai.aso.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.aso.common.db.dao.GoodsMapper;
import com.ai.aso.common.db.model.Goods;
import com.ai.aso.common.db.model.GoodsExample;
import com.ai.aso.common.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> findGoodsByDataType(Integer dataType) {
		GoodsExample example = new GoodsExample();
		example.createCriteria().andDataTypeEqualTo(dataType).andStateEqualTo(Short.valueOf("1"));
		example.setOrderByClause("GOODS_TYPE, GOODS_SPECS");
		return goodsMapper.selectByExample(example);
	}

	@Override
	public Goods findGoodsByGoodsId(String goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}
}

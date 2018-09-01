package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.db.model.Goods;

public interface GoodsService {

	/**
	 * 查找商品信息列表
	 * @param dataType - 商品流量类型
	 * @return
	 */
	List<Goods> findGoodsByDataType(Integer dataType);

	/**
	 * 查找商品信息
	 * @param goodsId
	 */
	Goods findGoodsByGoodsId(String goodsId);
}

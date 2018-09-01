package com.ai.aso.common.service;


public interface ProdService {
	/**
	 * 商品状态校验
	 * @param prodId
	 * @return
	 */
   boolean authProd(String prodId);
}

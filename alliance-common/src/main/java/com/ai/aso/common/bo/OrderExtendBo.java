package com.ai.aso.common.bo;

import java.util.List;
/**
 * 
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月6日
 *
 */
public class OrderExtendBo {
	private OrderBo orderBo;

	private List<OrderItemsBo> orderItemsBoList;

	private List<ProdBo> prodBoList;

	public OrderBo getOrderBo() {
		return orderBo;
	}

	public void setOrderBo(OrderBo orderBo) {
		this.orderBo = orderBo;
	}

	public List<OrderItemsBo> getOrderItemsBoList() {
		return orderItemsBoList;
	}

	public void setOrderItemsBoList(List<OrderItemsBo> orderItemsBoList) {
		this.orderItemsBoList = orderItemsBoList;
	}

	public List<ProdBo> getProdBoList() {
		return prodBoList;
	}

	public void setGoodsBoList(List<ProdBo> prodBoList) {
		this.prodBoList = prodBoList;
	}
	
}

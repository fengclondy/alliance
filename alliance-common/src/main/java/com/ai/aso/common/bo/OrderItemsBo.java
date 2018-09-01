package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.List;

import com.ai.aso.common.db.model.Goods;
import com.ai.aso.common.db.model.OrderItems;
/**
 * 
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月6日
 *
 */
public class OrderItemsBo {
	private OrderItems orderItems;
	private Goods goods;
	
	public OrderItems toOrderItems() {
		return this.orderItems;
	}
	public static List<OrderItemsBo> fromOrderItem(List<OrderItems> orderList) {
		List<OrderItemsBo> boList = new ArrayList<OrderItemsBo>();

		

		for (OrderItems orderItems : orderList) {
			OrderItemsBo bo = new OrderItemsBo();
			if (null != orderItems) {
				bo.setOrderItems(orderItems);		
				boList.add(bo);
			}
		}

		return boList;
	}
	public OrderItemsBo(){
		this.orderItems= new OrderItems();
		this.goods =new Goods();
	}
	public OrderItems getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(OrderItems orderItems) {
		this.orderItems = orderItems;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}

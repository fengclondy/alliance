package com.ai.aso.common.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.aso.common.db.model.Goods;
import com.ai.aso.common.db.model.Order;
import com.ai.aso.common.db.model.OrderItems;
/**
 * 
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月6日
 *
 */
public class OrderBo {
	private Order order;
	private List<Goods> goodsList;
	private List<OrderItems> orderItemsList;

	public OrderBo() {

		this.order = new Order();
		this.goodsList = new  ArrayList<Goods>();
		this.orderItemsList = new ArrayList<OrderItems>();
	}
	public static OrderBo fromOrder(Order order) {
		// TODO Auto-generated method stub
		OrderBo bo = new OrderBo();
		bo.order = order;
		return bo;
	}
	public Order toOrder() {
		// TODO Auto-generated method stub
		return this.order;
	}

	 public List<Goods> toGoods() {
	 // TODO Auto-generated method stub
	 return this.goodsList;
	 }
	public List<OrderItems> toOrderItems() {
		// TODO Auto-generated method stub
		return this.orderItemsList;
	}

	public static OrderBo fromOrderAndOrderItems(Order order, List<OrderItems> orderItemsList) {
		// TODO Auto-generated method stub
		OrderBo bo = new OrderBo();
		bo.order = order;
		bo.orderItemsList = orderItemsList;
		return bo;
	}
	
	
	public static OrderBo fromOrderAndOrderItemsAndGoods(Order order, List<OrderItems> orderItemsList,List<Goods> goodsList) {
		// TODO Auto-generated method stub
		OrderBo bo =new OrderBo();
		bo.order =order;
		bo.orderItemsList =orderItemsList;
		bo.goodsList =goodsList;
		return bo;
	}
	public static List<OrderBo> fromOrder(List<Order> orderList) {
		List<OrderBo> boList = new ArrayList<OrderBo>();

		

		for (Order order : orderList) {
			OrderBo bo = new OrderBo();
			if (null != order) {
				bo.setOrder(order);		
				boList.add(bo);
			}
		}

		return boList;
	}
	
	public static List<OrderBo> fromOrderAndOrderItems(List<Order> orderList, List<OrderItems> orderItemsList) {
		List<OrderBo> boList = new ArrayList<OrderBo>();

		Map<String, OrderItems> orderItemsMap = new HashMap<String, OrderItems>();
		if (null != orderItemsList) {
			for (OrderItems orderItems : orderItemsList) {
				orderItemsMap.put(orderItems.getOrderId(), orderItems);
			}
		}

		for (Order order : orderList) {
			OrderBo bo = new OrderBo();
			if (null != order) {
				bo.setOrder(order);
				String orderId = order.getOrderId();
				if (null != orderId) {
					bo.setOrderItems(orderItemsList);
				}

				boList.add(bo);
			}
		}

		return boList;
	}
	
	public static List<OrderBo> fromOrderAndOrderItemsAndGoods(List<Order> orderList, List<OrderItems> orderItemsList,List<Goods> goodsList) {
		List<OrderBo> boList = new ArrayList<OrderBo>();

		Map<String, OrderItems> orderItemsMap = new HashMap<String, OrderItems>();
		if (null != orderItemsList) {
			for (OrderItems orderItems : orderItemsList) {
				orderItemsMap.put(orderItems.getOrderId(), orderItems);
			}
		}

		for (Order order : orderList) {
			OrderBo bo = new OrderBo();
			if (null != order) {
				bo.setOrder(order);
				String orderId = order.getOrderId();
				if (null != orderId) {
					bo.setOrderItems(orderItemsList);
					bo.setGoodsList(goodsList);
				}

				boList.add(bo);
			}
		}

		return boList;
	}
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItems> getOrderItems() {
		return orderItemsList;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItemsList = orderItems;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public List<OrderItems> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItems> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}

}

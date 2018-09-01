package com.ai.aso.common.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.component.MyInfoComp;
import com.ai.aso.common.db.dao.OrderItemsMapper;
import com.ai.aso.common.db.dao.OrderMapper;
import com.ai.aso.common.db.model.Order;
import com.ai.aso.common.db.model.OrderExample;
import com.ai.aso.common.db.model.OrderItems;
import com.ai.aso.common.db.model.OrderItemsExample;
@Component
public class MyInfoCompImpl implements MyInfoComp{

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemsMapper orderItemsMapper;
	
	@Override
	public List<Order> findAllOrderByCustId(String custId) {
		OrderExample orderExample = new OrderExample();
		orderExample.createCriteria().andCustIdEqualTo(custId);
		return orderMapper.selectByExample(orderExample);
	}

	@Override
	public List<OrderItems> findAllOrderItems(String orderId) {
		OrderItemsExample orderItemsExample = new OrderItemsExample();
		orderItemsExample.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItems> OrderItemList = orderItemsMapper.selectByExample(orderItemsExample);
		return OrderItemList;
	}

}

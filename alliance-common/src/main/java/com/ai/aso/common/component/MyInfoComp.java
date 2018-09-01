package com.ai.aso.common.component;

import java.util.List;

import com.ai.aso.common.db.model.Order;
import com.ai.aso.common.db.model.OrderItems;

public interface MyInfoComp {

	List<Order> findAllOrderByCustId(String custId);

	List<OrderItems> findAllOrderItems(String orderId);
	
}

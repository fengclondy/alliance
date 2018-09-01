package com.ai.aso.common.component.impl;

import java.util.List;

import com.ai.aso.common.bo.OrderBo;
import com.ai.aso.common.bo.OrderExtendBo;

import org.springframework.stereotype.Component;

import com.ai.aso.common.component.OrderAdminComp;

@Component
public class OrderAdminCompImpl implements OrderAdminComp {

	@Override
	public void authOrder(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderIsPaid(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderState(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findOrderById(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPay(String orderId, String realMoney) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertToAccount(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertToPayList(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertToValume(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderBo findOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addOrder(OrderBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOrderById(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderBo> findOrderList(OrderBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBo> findOrderListByManagerId(String creatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createOrder(OrderBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createOrder(OrderExtendBo bo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOrder(String orderId, String managerId) {
		// TODO Auto-generated method stub
		return 0;
	}

}

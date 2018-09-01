package com.ai.aso.common.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ai.aso.common.bo.OrderBo;
import com.ai.aso.common.bo.OrderItemsBo;
import com.ai.aso.common.component.OrderComp;
import com.ai.aso.common.service.OrderService;
/**
 * 订单外部调用实现类
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月19日
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderComp orderComp;
	
	@Override
	@Transactional
	public String addOrder(OrderBo bo) {
		
		return orderComp.addOrder(bo);
	}

	@Override
	public OrderBo findOrderById(String id) {
		
		return orderComp.findOrderByOrderId(id);
	}

	@Override
	public List<OrderBo> findOrderList(OrderBo bo) {
		// TODO Auto-generated method stub
		return orderComp.findOrderList(bo);
	}

	@Override
	public List<OrderBo> findOrdeListByCreatorId(String creatorId) {
		
		return orderComp.findOrderListByManagerId(creatorId);
	}
	@Override
	public int upadteOrder(String orderId, String managerId) {
		orderComp.updateOrder(orderId,managerId);
		return 0;
	}

	@Override
	public int addOrderOp(OrderBo orderBo, String userId) {
	
		return 0;
	}

	@Override
	public int addOrderItem(OrderItemsBo orderItemsBo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void authOrder(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPay(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertToAccount(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderState(String orderId) {
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
	
}

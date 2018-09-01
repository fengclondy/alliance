package com.ai.aso.common.component.impl;

import java.util.List;
import java.util.Map;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.OrderBo;
import com.ai.aso.common.bo.OrderExtendBo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ai.aso.common.component.OrderCustComp;
import com.ai.aso.common.db.dao.OrderMapper;
import com.ai.aso.common.db.model.CustExample;
import com.ai.aso.common.db.model.Order;
import com.ai.aso.common.db.model.OrderExample;

@Component
public class OrderCustCompImpl implements OrderCustComp {

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public void authOrder(String userId) {
		//判断订单是否属于自己		
	}

	@Override
	public void orderIsPaid(String orderId) {
		//只有未支付的订单才能撤销
		
	}

	@Override
	public void updateOrderState(String orderId) {
		//更新数据库订单状态
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

	@Override
	public List<Order> findOrderByFiter(OrderBo bo) {
		OrderExample example = new OrderExample();
		if(!bo.getOrder().getOrderId().equals("") && bo.getOrder().getOrderId()!=null)
		{
			example.or().andOrderIdLike((StringUtil.insertSpliterBothSide(bo.getOrder().getOrderId(), "%")));
		}
		if(!"".equals(bo.getOrder().getCreateDate()) && null!=bo.getOrder().getCreateDate())
		{
			example.or().andCreateDateEqualTo(bo.getOrder().getCreateDate());
		}
		if(!bo.getOrder().getOrderState().equals("") && bo.getOrder().getOrderState()!=null)
		{
			example.or().andOrderStateEqualTo(bo.getOrder().getOrderState());
		}
		
		List<Order> listOrder = orderMapper.selectByExample(example);
		
		return listOrder;
	}

}

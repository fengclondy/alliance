package com.ai.aso.common.component.impl;

import java.util.List;
import java.util.Map;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.bo.OrderBo;
import com.ai.aso.common.bo.OrderExtendBo;
import com.ai.aso.common.bo.OrderItemsBo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.aso.common.component.OrderComp;
import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.db.dao.OrderItemsMapper;
import com.ai.aso.common.db.dao.OrderMapper;
import com.ai.aso.common.db.model.Order;
import com.ai.aso.common.db.model.OrderExample;
import com.ai.aso.common.db.model.OrderItems;
import com.ai.aso.common.db.model.OrderItemsExample;
import com.ai.aso.common.exception.NoAccessException;
import com.ai.aso.security.model.Principal;

@Component
public class OrderCompImpl implements OrderComp {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemsMapper orderItemsMapper;
	@Override
	public boolean authOrder(String userId,String orderId) {
		Order order =orderMapper.selectByPrimaryKey(orderId);
		if(null!=order&&userId.equals(order.getCreatorId())){
			return true;
		}else {
			throw new NoAccessException();
		}
	}

	@Override
	public boolean orderIsPaid(String orderId) {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(null!=order){
			if(BizConstants.ORDER_STATE_UNPAY.equals(String.valueOf(order.getOrderState())) ){
				return true;
			}else{
				//订单支付异常
				throw new NoAccessException();
			}
		}else{
			//订单空指针异常
			throw new NoAccessException();
		}
		
	}

	@Override
	public int updateOrderState(String orderId) {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(null!=order){
			order.setOrderState(Short.valueOf(BizConstants.ORDER_STATE_COMPLETED));
			return orderMapper.updateByPrimaryKeySelective(order);
		}else{
			//订单空指针异常
			throw new NoAccessException();
		}
	}

	@Override
	public OrderItemsBo findOrderById(String orderId) {
		OrderItemsExample example = new OrderItemsExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItems> list= orderItemsMapper.selectByExample(example);
		//List<OrderItemsBo> boList = 
		return null;
	}

	@Override
	public boolean checkPay(String orderId, String realMoney) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String insertToAccount(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertToPayList(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertToValume(String orderId) {
		// TODO Auto-generated method stub
		return null;
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
		if(this.getCurrentUser().equals(creatorId)){
			
			OrderExample example = new OrderExample();
			example.createCriteria().andCreatorIdEqualTo(creatorId);
			example.createCriteria().andOrderStateEqualTo(GlobalParamSet.getShort(BizConstants.ORDER_STATE_UNPAY));
			List<Order> orderList =orderMapper.selectByExample(example);
			
			List<OrderBo> boList =OrderBo.fromOrder(orderList);
			return boList;
		}
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
	public List<OrderBo> findOrderByFiter(Map<String, Object> map) {
		return null;
		
	}
	private String getCurrentUser() {
		Subject subject = SecurityUtils.getSubject();
		Principal user = (Principal) subject.getPrincipals().getPrimaryPrincipal();

		return user.getAccId();
	}
}

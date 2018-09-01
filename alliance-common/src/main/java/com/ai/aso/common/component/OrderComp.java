package com.ai.aso.common.component;

import java.util.List;
import java.util.Map;

import com.ai.aso.common.bo.OrderBo;
import com.ai.aso.common.bo.OrderExtendBo;
import com.ai.aso.common.bo.OrderItemsBo;

public interface OrderComp {

	/**
	 * 判断用户是否有权限
	 * @param userId
	 * @param orderId
	 */
	boolean authOrder(String userId, String orderId);

	/**
	 * 判断订单是否被支付过
	 * @param orderId
	 */
	boolean orderIsPaid(String orderId);

	/**
	 * 取消订单更新状态位
	 * @param orderId
	 */
	int updateOrderState(String orderId);

	/**
	 * 根据订单id查找订单详情
	 * @param orderId
	 */
	OrderItemsBo findOrderById(String orderId);

	/**
	 * 支付信息检查
	 * @param orderId
	 */
	boolean checkPay(String orderId, String realMoney);

	/**
	 * 支付金额存入账户
	 * @param orderId
	 */
	String insertToAccount(String orderId);

	/**
	 * 插入支付流水
	 * @param orderId
	 */
	String insertToPayList(String orderId);

	/**
	 * 流量账本入账
	 * @param orderId
	 */
	String insertToValume(String orderId);
	/**
	 * 通过Id获得订单信息
	 * @param id
	 * @return
	 */
	OrderBo findOrderByOrderId(String orderId);
	/**
	 * 新增订单
	 * @param bo
	 * @return
	 */
	 String addOrder(OrderBo bo);
	
	/**
	 * 删除订单
	 * @param orderId
	 */
	void removeOrderById(String orderId);
	
	/**
	 * 查询订单信息
	 * @param bo
	 * @return
	 */
	List<OrderBo> findOrderList(OrderBo bo);
	
	/**
	 * 订单创建者所有订单
	 * @param creatorId
	 * @return
	 */
	List<OrderBo> findOrderListByManagerId(String creatorId);
	/**
	 * 创建订单
	 * @param bo
	 * @return
	 */
	String createOrder(OrderBo bo);
	
	/**
	 * 创建订单
	 * @param bo
	 * @return
	 */
	public String createOrder(OrderExtendBo bo);
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param managerId
	 * @return
	 */
	int updateOrder(String orderId, String managerId);

	/**
	 * 根据条件查找订单
	 * @param map
	 */
	List<OrderBo> findOrderByFiter(Map<String, Object> map);
}

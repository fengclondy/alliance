package com.ai.aso.common.service;

import java.util.List;

import com.ai.aso.common.bo.OrderBo;
import com.ai.aso.common.bo.OrderItemsBo;
/**
 * 订单外部调用接口
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月1日
 *
 */
public interface OrderService {
	
	/**
	 * 通过Id获得订单信息
	 * @param id
	 * @return
	 */
	public OrderBo findOrderById(String id);
	
	/**
	 * 查询订单信息
	 * @param bo
	 * @return
	 */
	public List<OrderBo> findOrderList(OrderBo bo);
	
	
	/**
	 * 根据创建者查询订单详情<br>
	 * 必须查询条件为创建者ID
	 * 
	 * @param creatorId
	 * 
	 * @return 订单信息列表
	 */
	public List<OrderBo> findOrdeListByCreatorId(String creatorId);
	
	/**
	 * 订单状态修改
	 * @param orderId
	 * @param managerId
	 * @return
	 */
	int upadteOrder(String orderId, String managerId);
	/**
	 * 创建订单信息
	 * @param bo
	 * @return
	 */
	String addOrder(OrderBo bo);
	/**
	 * 订单项
	 * @param orderItemBo
	 * @return
	 */
	int addOrderItem(OrderItemsBo orderItemsBo);
	/**
	 * 订单操作日志
	 * @param orderBo
	 * @param userId
	 * @return
	 */
	int addOrderOp(OrderBo orderBo, String userId);
	
	/**
	 * 判断用户是否有权限取消订单
	 * @param userId
	 */
	void authOrder(String userId);
	
	
	/**
	 * 支付信息检查
	 * @param orderId
	 */
	void checkPay(String orderId);
	
	
	/**
	 * 支付金额存入账户
	 * @param orderId
	 */
	void insertToAccount(String orderId);
	/**
	 * 取消订单更新状态位
	 * @param orderId
	 */
	void updateOrderState(String orderId);
	
	/**
	 * 插入支付流水
	 * @param orderId
	 */
	void insertToPayList(String orderId);
	
	
	/**
	 * 流量账本入账
	 * @param orderId
	 */
	void insertToValume(String orderId);
}

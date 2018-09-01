package com.ai.aso.common.component;
/**
 * 收入统计component接口
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月14日
 *
 */
public interface CostBillComp {
	
	/**
	 * 统计入账数据
	 * @param billMonth 入账账期
	 * @param billBatch 出账批次数组
	 * @param custId 客户数组
	 */
	void custBillGroupCust(String billMonth, String[] billId);

}

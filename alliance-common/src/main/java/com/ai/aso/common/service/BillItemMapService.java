package com.ai.aso.common.service;
/**
 * 通过costRegion返回billItemId
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年11月14日
 *
 */
public interface BillItemMapService {
	/**
	 * 通过costRegion返回billItemId
	 * @param costRegion
	 * @return
	 */
	String getBillItemId(Integer costRegion);
}

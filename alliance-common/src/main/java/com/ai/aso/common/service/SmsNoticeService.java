package com.ai.aso.common.service;
/**
 * 短信提醒
 * @author lw
 *2017年2月24日
 */
public interface SmsNoticeService {
	/**
	 * 客户欠费定时短信提醒
	 * 
	 * @return
	 */
	void arrearage();
}

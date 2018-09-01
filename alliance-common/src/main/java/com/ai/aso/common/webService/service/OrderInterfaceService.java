package com.ai.aso.common.webService.service;

import com.alibaba.fastjson.JSONObject;

public interface OrderInterfaceService {
	
	/**
	 * CRM订购接口
	 * @param orderSeq
	 * @param accNbr
	 * @param offerSpecId
	 * @return
	 */
	JSONObject orderSprom(String orderSeq, String accNbr, String offerSpecId);
	/**
	 * CRM订购查询接口
	 * @param orderSeq
	 * @param accNbr
	 * @return
	 */
	JSONObject queryOrderResult(String orderSeq, String accNbr);
}

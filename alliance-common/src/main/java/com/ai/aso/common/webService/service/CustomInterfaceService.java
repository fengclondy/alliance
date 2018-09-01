package com.ai.aso.common.webService.service;

import com.ai.aso.common.webService.model.UserInfo;
import com.alibaba.fastjson.JSONObject;
/**
 * 客户信息查询接口
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年10月25日
 *
 */
public interface CustomInterfaceService {
	/**
	 * 查询客户资料
	 * @param accNbr
	 * @return
	 */
	JSONObject getCustInfoByPhoneNumber(String accNbr);
	/**
	 *  查询客户资料对外接口
	 * @param accNbr
	 * @return
	 */
	UserInfo customExternalService(String accNbr);
}

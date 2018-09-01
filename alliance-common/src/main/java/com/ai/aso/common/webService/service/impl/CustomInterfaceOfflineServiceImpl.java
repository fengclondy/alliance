package com.ai.aso.common.webService.service.impl;

import java.util.Random;

import com.ai.aso.common.utils.DateTimeUtil;
import com.ai.aso.common.webService.model.UserInfo;
import com.ai.aso.common.webService.service.CustomInterfaceService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service("customInterfaceOffline")
public class CustomInterfaceOfflineServiceImpl  implements CustomInterfaceService{

	@Override
	public UserInfo customExternalService(String accNbr) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setCertNumber("340121199408573890");
		userInfo.setCertType("1");
		userInfo.setCustName("亚信科技测试（" + DateTimeUtil.getTodayChar14() + new Random().nextInt(100) + "）");
		userInfo.setProdId("18654113456");
		userInfo.setProdSpec("18654113456");
		userInfo.setZoneNumber("0370");
		userInfo.setAcctId("18654113456");
		userInfo.setCustId("18654113456");
		userInfo.setResult("0");
		return userInfo;
	}

	@Override
	public JSONObject getCustInfoByPhoneNumber(String accNbr) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

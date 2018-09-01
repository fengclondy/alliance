package com.ai.aso.common.fps.webService.exception;

import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.ExInfoEnum;

public interface FpsExInfoEnum extends ExInfoEnum{

	ExInfo No_ACCESS_ERROR = ExInfo.create("10312", "鉴权失败，拒绝访问！", "鉴权失败，拒绝访问！");
	ExInfo RE_DATA_ERROR = ExInfo.create("10003", "入参信息不完整！", "入参信息不完整！");

	//查询合同信息
	ExInfo CONTACT_INFO_IS_NOT_EXISTS = ExInfo.create("99999", "无效的合同编号！", "无效的合同编号！");

	ExInfo FLOW_ORDER_REQNO_NOT_EXISTS = ExInfo.create("10003", "订购流水号不存在！", "订购流水号不存在！");

	ExInfo FLOW_ORDER_STATE_INFO_REQ_ERROR = ExInfo.create("10003", "参数错误！", "参数错误！");
}

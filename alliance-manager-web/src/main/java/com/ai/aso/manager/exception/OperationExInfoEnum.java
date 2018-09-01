package com.ai.aso.manager.exception;

import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.ExInfoEnum;

public interface OperationExInfoEnum extends ExInfoEnum {
	ExInfo SYS_IP_LIMIT_UNSETTING = ExInfo.create("F1001000", "未开放访问", "该链接未开放访问！");
	ExInfo SYS_IP_LIMIT_FREQUENT = ExInfo.create("F1001001", "操作过于频繁", "您操作过于频繁，请稍后再试！");
	ExInfo SYS_IP_LIMIT_HOST = ExInfo.create("F1001002", "您未获得访问许可", "您的IP不在允许访问范围内！");
}

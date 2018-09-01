package com.ai.aso.common.param.exception;

import com.ai.aso.base.exception.ExInfo;

public interface ParamEnum {

	ExInfo SYS_GLOBAL_PARAMS_NOT_FOUND = ExInfo.create("F100000003", "系统错误", "静态常量名未找到，请检查数据库！");
	ExInfo SYS_ATTRIBUTE_GROUP_NOT_FOUND = ExInfo.create("F100000004", "系统错误", "静态字典组名未找到，请检查数据库！");
	
}

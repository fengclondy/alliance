package com.ai.aso.base.exception;

public interface ExInfoEnum {

	ExInfo SYS_GLOBAL_ERROR = ExInfo.create("F100000000", "系统错误", "系统内部错误！");
	ExInfo SEQUNCE_CREATE_ERROR = ExInfo.create("F100000001", "基础错误", "序列生成异常！");
	ExInfo SYS_GLOBAL_UNAUTHORIZED = ExInfo.create("F100000002", "权限错误", "您没用使用该功能的权限！");
	ExInfo VALIDATE_CONT_NOT_EXSIT=ExInfo.create("F100008000", "合同异常", "合同不存在或者数据异常");
	ExInfo VALIDATE_CONT_STATE_EXCPTION=ExInfo.create("F100008001", "合同状态异常", "合同状态异常");
	ExInfo VALIDATE_CONTBOOK_NOT_EXSIT=ExInfo.create("F100008002", "合同账本异常", "合同账本不存在或者数据异常");
	
	ExInfo SYS_GLOBAL_PARAMS_NOT_FOUND = ExInfo.create("F100000003", "系统错误", "静态常量未找到，请检查数据库！");
	ExInfo SYS_GLOBAL_ERROR_CRMCUST = ExInfo.create("F100009009", "系统错误", "客户数据异常！");
	
	ExInfo SYS_GLOBAL_ERROR_CUST_INBILL = ExInfo.create("F100009008", "所选客户账单已入当前账期", "所选客户账单已入当前账期");
	
	ExInfo SYS_GLOBAL_ERROR_SMS_SEND = ExInfo.create("F100009007", "短信发送错误", "短信发送错误");

	ExInfo SYS_GLOBAL_ERROR_HTTPCLIENT_RESP = ExInfo.create("F100010001", "http访问失败", "http访问失败");
}

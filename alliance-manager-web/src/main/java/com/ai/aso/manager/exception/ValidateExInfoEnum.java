package com.ai.aso.manager.exception;

import com.ai.aso.base.exception.ExInfo;

public interface ValidateExInfoEnum {
	
	ExInfo VALIDATE_LENGTH_OUT = ExInfo.create("F1002000", "长度超长！", "长度超长！");
	//客户管理校验
	ExInfo VALIDATE_SHORT_NAME_EMPTY_STR = ExInfo.create("F1002001", "请输入企业简称！", "请输入企业简称！");
	ExInfo VALIDATE_SHORT_NAME_ILLEGAL_STR = ExInfo.create("F1002002", "企业简称只能包含中、英文或数字！", "企业简称只能包含中、英文或数字！");
	
	ExInfo VALIDATE_USER_NAME_EMPTY_STR = ExInfo.create("F1002003", "请输入联系人姓名！", "请输入联系人姓名！");
	ExInfo VALIDATE_USER_NAME_ILLEGAL_STR = ExInfo.create("F1002004", "联系人姓名只能包含中英文！", "联系人姓名只能包含中英文！");
	
	ExInfo VALIDATE_MOBILE_EMPTY_STR = ExInfo.create("F1002005", "请输入联系人手机号！", "请输入联系人手机号！");
	ExInfo VALIDATE_MOBILE_ILLEGAL_STR = ExInfo.create("F1002006", "请输入正确的手机号！", "请输入正确的手机号！");
	
	ExInfo VALIDATE_EMAIL_ILLEGAL_STR = ExInfo.create("F1002007", "请输入正确的邮箱！", "请输入正确的邮箱！");
	
	ExInfo VALIDATE_CRM_USER_CODE_EMPTY_STR = ExInfo.create("F1002008", "请输入客户号码！", "请输入客户号码！");
	
	ExInfo VALIDATE_SHARE_EMPTY_STR = ExInfo.create("F1002009", "请输入摊分比例！", "请输入摊分比例！");
	ExInfo VALIDATE_SHARE_ILLEGAL_STR = ExInfo.create("F1002010", "摊分比例介于0-100之间！", "摊分比例介于0-100之间！");
	ExInfo VALIDATE_CUST_EXT1_EMPTY = ExInfo.create("F1002008", "请输入摊分比例！", "请输入摊分比例！");
	ExInfo VALIDATE_CUST_EXT1_ILLEGAL = ExInfo.create("F1002008", "只能输入正整数！", "只能输入正整数！");
	
	ExInfo VALIDATE_REGION_ACCESS = ExInfo.create("F1002009", "不允许访问非本市（县）客户资料！", "不允许访问非本市（县）客户资料！");;
	
	//合同校验
	ExInfo VALIDATE_TRANSFER_BASY = ExInfo.create("F1003000", "业务繁忙，请稍候再试！", "业务繁忙，请稍候再试！");
	
	ExInfo VALIDATE_CONTRACT_ILLEGAL_CONTVALUE = ExInfo.create("F1003001", "合同金额必须为数字！", "合同金额必须为数字！");
	ExInfo VALIDATE_CONTRACT_ILLEGAL_DEPOSIT = ExInfo.create("F1003002", "保证金必须为数字！", "保证金必须为数字！");
	ExInfo VALIDATE_CONTRACT_ILLEGAL_PAYMENT = ExInfo.create("F1003003", "预付款必须为数字！", "预付款必须为数字！");
	ExInfo VALIDATE_CONTRACT_ILLEGAL_PUBOFFRATE = ExInfo.create("F1003004", "国内流量折扣只能输入0-100之间的整数！", "国内流量折扣只能输入0-100之间的整数！");
	ExInfo VALIDATE_CONTRACT_ILLEGAL_PROOFFRATE = ExInfo.create("F1003005", "省内流量折扣只能输入0-100之间的整数！", "省内流量折扣只能输入0-100之间的整数！");
	ExInfo VALIDATE_CONTRACT_ILLEGAL_CONTEFFDATE = ExInfo.create("F1003006", "请输入合理的合同有效期！", "请输入合理的合同有效期！");
	ExInfo VALIDATE_CONTRACT_ILLEGAL_GOODS = ExInfo.create("F1003007", "至少选择一种流量规格！", "至少选择一种流量规格！");
	
	ExInfo VALIDATE_ILLEGAL_DEPOSIT = ExInfo.create("F1003009", "保证金必须为数字！", "保证金必须为数字！");
	ExInfo VALIDATE_TRANSFER_DEPOSIT = ExInfo.create("F1003010", "保证金余额不足！", "保证金余额不足！");
	ExInfo VALIDATE_TRANSFER_CREDIT = ExInfo.create("F1003011", "透支金额过大！", "透支金额过大！");
	ExInfo VALIDATE_CONTRACT_ILLEGAL_PAYDEFEE = ExInfo.create("F1003098", "付款金额必须为数字！", "付款金额必须为数字！");
	ExInfo VALIDATE_CONTRACT_NOTNULL_PAYDEFEE = ExInfo.create("F1003097", "付款金额不能为空！", "付款金额不能为空！");
	ExInfo VALIDATE_CONTRACT_PAYDEFEE_OVER_DEPOSIT = ExInfo.create("F1003095", "付款金额需大于保证金！", "付款金额需大于保证金！");
	//用户管理
	ExInfo VALIDATE_LOGIN_NAME_EMPTY_STR = ExInfo.create("F1004001", "请输入登录名", "请输入登录名");
	
	ExInfo VALIDATE_LOGIN_NAME_Exist=ExInfo.create("F1004002", "登录名已经存在", "登录名已经存在");
	ExInfo VALIDATE_PAYCERT_NOT_EXSIT=ExInfo.create("F1004009", "支付凭证不存在", "支付凭证不存在");
	ExInfo VALIDATE_PAYCERT_NOT_IMAGE=ExInfo.create("F1004011", "支付凭证必须是图片", "支付凭证必须是图片");
	//密码重置
	ExInfo OLD_PASSWORD_ILLEGAL = ExInfo.create("F1001000", "原密码不正确！", "原密码不正确");
	ExInfo USERNAME_PASSWORD_ILLEGAL = ExInfo.create("F1001001", "用户名或密码不正确！", "用户名或密码不正确");
	ExInfo PASSWORD_FORMAT_ILLEGAL = ExInfo.create("F1001002", "密码必须由8-16位数字+字母+特殊字符组合！", "密码必须由8-16位数字+字母+特殊字符组合！");
	ExInfo SMSCODE_ILLEGAL = ExInfo.create("F1001003", "短信验证码不正确！", "短信验证码不正确！");
	ExInfo VALIDATE_ILLEGAL_IP_SPLITOR = ExInfo.create("F1001004", "多IP地址的分隔符不可为\".\" ", "多IP地址的分隔符不可为\".\"");
	ExInfo VALIDATE_ILLEGAL_IP = ExInfo.create("F1001005", "请输入正确的IP地址！", "请输入正确的IP地址，如：192.168.100.2！");

	ExInfo APPLY_TIP_STATE = ExInfo.create("F1001009", "意向单操作异常，请勿重复操作！", "意向单操作异常，请勿重复操作！");


	ExInfo VALIDATE_ILLEGAL_CARRYOVER = ExInfo.create("F1005001", "结转金额必须为大于0的数字！", "结转金额必须为大于0的数字！");

	ExInfo VALIDATE_ILLEGAL_DATE = ExInfo.create("F1001010", "日期格式不正确！", "日期格式不正确！");
}

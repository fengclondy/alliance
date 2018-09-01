package com.ai.aso.common.exception;

import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.ExInfoEnum;

public interface BizExInfoEnum extends ExInfoEnum{
	
	ExInfo No_ACCESS_ERROR = ExInfo.create("F100100000", "没有权限访问", "您没有权限执行此操作！");
	ExInfo CUST_VALID_ERROR = ExInfo.create("F200200000", "客户已经生效", "信息已审核，无需操作！");
	ExInfo CONTRACT_BOOK_ERROR = ExInfo.create("F300100000", "合同号异常", "合同号没有找到！");
	ExInfo CUST_EXISTS_WARN = ExInfo.create("F200200001", "客户已存在", "客户号码已注册在本系统！");
	ExInfo USER_EXISTS_WARN = ExInfo.create("F200200002", "登录号已存在", "登录号已注册在本系统！");
	ExInfo USER_REGION_ID_ILLEGAL = ExInfo.create("F200200003", "无效的地区码", "无效的地区码！");
	ExInfo CRM_CUST_INFO_NOTFOUND = ExInfo.create("F200200004", "没有检索到相关的客户信息", "没有检索到相关的客户信息！");
	ExInfo CONTRACT_UNIQUE_WAITAUDIT = ExInfo.create("F200200005", "已存在待审核合同，无法继续操作", "已存在待审核合同，无法继续新增！");
	ExInfo VALIDATE_CUST_NO_EXIST=ExInfo.create("F200200006", "客户不存在或者资料不全", "客户不存在或者资料不全");
	ExInfo VALIDATE_CUST_NOT_IN_REGION=ExInfo.create("F200200007", "客户不属于该地区", "客户不属于该地区");
	ExInfo CONTRACT_NOT_FOUND = ExInfo.create("F200200008", "合同不存在或者资料不全", "合同不存在或者资料不全");
	ExInfo CONTRACT_FILE_NOT_FOUND = ExInfo.create("F200200012", "合同副本文件未找到", "合同副本文件未找到");
	ExInfo PAYMENT_PAYCERT_NOT_FOUND = ExInfo.create("F200200009", "支付凭证未找到", "支付凭证未找到");
	ExInfo LOGINACCT_NOT_FOUND = ExInfo.create("F100100001", "账户信息不存在", "账户信息不存在！");
	ExInfo NO_ACCESS_REGION = ExInfo.create("F100100001", "不能访问非本市客户资料！", "不能访问非本市客户资料");
	ExInfo PARTNER_EXISTS_WARN = ExInfo.create("F200200032", "合作伙伴有未处理的注册单 ", "客户号码已注册在本系统！");
	ExInfo SMS_OPER_FAST = ExInfo.create("F200200033", "验证码发送太频繁！", "验证码发送太频繁,请稍后再试！");
	ExInfo RECHARAGE_ORDER_TOOLONG = ExInfo.create("F200200034", "订单流水号太长！", "订单流水号太长");
	ExInfo PICTURE_SIZE_TOOLARGE = ExInfo.create("F200200035", "图片大小超过了3M！", "图片大小超过了3M");
	ExInfo REMAINING_QUOTA_NOT_ENOUGH = ExInfo.create("F200200036", "剩余额度不足", "剩余额度不足");
	ExInfo COST_BILL_ENTRY_FAILED = ExInfo.create("F200200037", "入账失败", "入账失败");
}

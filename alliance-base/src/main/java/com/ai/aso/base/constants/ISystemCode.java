package com.ai.aso.base.constants;

/**
 * 系统功能模块编码定义<br>
 * 编码规则：<br>
 * 子系统编码(2位)，用于标识子系统编码，如"10"表示管理员门户子系统<br>
 * 模块编码(2位)，标识系统模块编码，如"11"标识安全模块<br>
 * 功能编码(3位)，标识系统功能如
 * 
 * @author yusx
 * @version 1.0
 */
public interface ISystemCode {
	
	String SUB_SYS_MAN_CODE = "100"; //管理门户子系统
	String SUB_SYS_PAR_CODE = "200";//合作伙伴门户子系统

	String MODEL_PUBLIC_CODE = "10"; // 系统公共模块，包括参数模块，序列模块等
	String MODEL_SECURITY_CODE = "11"; // 安全模块，包括身份认证、权限控制、账号管理、密码管理、角色管理
	String MODEL_SYS_MANAGE_CODE = "12"; // 系统管理，包括用户管理，日志管理
	String MODEL_CUSTOM_CODE = "20"; // 客户模块

	String FUNC_PUBLIC = "000"; // 公共，无法分类的都使用该分类
	String FUNC_PARAM_MANAGE = "100"; // 参数管理
	String FUNC_LOG_MANAGE = "101"; // 日志管理
	String FUNC_SEQ_MANAGE = "102"; // 序列管理
	String FUNC_SECURITY_RESOURCE_MANAGE = "103"; // 资源管理
	String FUNC_SECURITY_ROLE_MANAGE = "104"; // 角色管理
	String FUNC_SECURITY_ACCT_MANAGE = "103"; // 账号管理
	String FUNC_SECURITY_AUTHEN = "110"; // 认证管理
	String FUNC_SECURITY_AUTHOR = "111"; // 鉴权管理
	String FUNC_SYS_USER_MANAGE = "201"; // 平台用户管理
	String FUNC_CUST_MANAGE = "202"; // 客户管理

}

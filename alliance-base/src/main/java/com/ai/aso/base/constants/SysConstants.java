package com.ai.aso.base.constants;

/**
 * 系统全局常量定义，包括：<br>
 * 1、数据库常量表中的常量KEY<br>
 * 2、REDIS中用到的KEY<br>
 * 3、用于比较的的属性值常量<br>
 * 4、其它常量
 */
public interface SysConstants {
	
	// GlobalParam表中的常量KEY
	public static final String SUB_SYS_MAN_CODE = "SUB.SYS.MAN.CODE";
	public static final String SUB_SYS_PAR_CODE = "SUB.SYS.PAR.CODE";
	public static final String SUB_SYS_ENABLER_CODE = "SUB_SYS_ENABLER_CODE";

	public static final String SYS_IP_REQ_INTERVAL_KEY = "SYS.IP.REQ.INTERVAL.KEY"; // 系统请求访问时间间隔key
	public static final String SYS_IP_REQ_LIMIT_KEY = "SYS.IP.REQ.LIMIT.KEY"; // 系统请求访问总次数KEY

	
	// AttrDef表中的常量KEY
	public static final String SUB_SYS_CODE = "SUB_SYS_CODE";
	public static final String ATTR_CUST_STATE = "CUST_STATE";
	
	// REDIS KEY
	
	//系统全局状态字段功能码
	public static final String SYS_GLOBAL_STATE_ENABLE = "SYS.GLOBAL.STATE.ENABLE";
	public static final String SYS_GLOBAL_STATE_DISENABLED = "SYS.GLOBAL.STATE.DISENABLED";
	
	public static final String SYS_GLOBAL_CHANNEL_ID = "SYS.GLOBAL.CHANNEL.ID";
	
	public static final String SYS_EXCEPTION_REDIRECT_FLAG = "sysExceptionRedirect";
	public static final String SYS_EXCEPTION_INFO = "sysExceptionInfo";
	
	
	//CRM短信接口
		public static final String CRM_WEBSERVICE_SMS_URL="CRM_WEBSERVICE_SMS_URL";//CRM短息webService地址
		public static final String CRM_WEBSERVICE_SMS_METHOD="CRM_WEBSERVICE_SMS_METHOD";//CRM短息webService方法
		public static final String SEQUENCENAME_SMSCODE = "sqName_smsCode";
		//短信相关
		public static final String CRM_WEBSERVICE_SMS_USERNAME="CRM_WEBSERVICE_SMS_USERNAME";
		public static final String CRM_WEBSERVICE_SMS_PASS="CRM_WEBSERVICE_SMS_PASS";
		public static final String CRM_WEBSERVICE_SMS_SYSCODE="CRM_WEBSERVICE_SMS_SYSCODE";
		public static final String CRM_WEBSERVICE_SMS_PRODUCTID="CRM_WEBSERVICE_SMS_PRODUCTID";
		public static final String CRM_WEBSERVICE_SMS_LATNID="CRM_WEBSERVICE_SMS_LATNID";
		public static final String CRM_WEBSERVICE_SMS_SENTTYPE="CRM_WEBSERVICE_SMS_SENTTYPE";
		public static final String CRM_WEBSERVICE_SMS_BUSINESSID_DELAYED="CRM_WEBSERVICE_SMS_BUSINESSID_DELAYED";
		public static final String CRM_WEBSERVICE_SMS_BUSINESSID_CONSTANTLY="CRM_WEBSERVICE_SMS_BUSINESSID_CONSTANTLY";
		public static final String CRM_WEBSERVICE_SMS_CHANNELTYPE="CRM_WEBSERVICE_SMS_CHANNELTYPE";
		//短息模板定义
		public static final String SMS_TEMPLATE_REGISTER="SMS_TEMPLATE_REGISTER";//用户注册短信模板
		
		public static final String SMS_TEMPLATE_RES_NOTICE="SMS_TEMPLATE_RES_NOTICE";//用户注册短信完成通知管理员模板
		
		public static final String SMS_TEMPLATE_ADICUT_NOTICE="SMS_TEMPLATE_ADICUT_NOTICE";//短信完成通知用户模板

}

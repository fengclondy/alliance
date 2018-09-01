package com.ai.aso.common.constants;
/**
 * webService返回信息
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年10月26日
 *
 */
public class ResultMsg {
	// 全局结果码
	public static final String OPER_SUCCESS = "0"; // 成功
	public static final String OPER_FAILED = "1"; // 失败
	public static final String OPER_CONFIRM = "2"; // 待确认
	public static final String SMS_OPER_SUCCESS = "000"; // 成功
	//错误码
	public static final String  OPER_MSGCODE_SUCC ="0";// 成功
	public static final String  OPER_MSGCODE_CRM_RETURN_FAIL ="10000";// CRM返回失败
	public static final String  OPER_MSGCODE_URL_FAIL ="20000";// 连接超时失败
	public static final String  OPER_MSGCODE_RESPONSE_FAIL ="30000";// 响应超时
	public static final String  OPER_MSGCODE_XML_FAIL ="40000";// 响应解析失败

	//错误信息
	public static final String MSG_WEBSERVICE_URL_ERR="连接WebService超时！";		
	public static final String MSG_WEBSERVICE_RESPONSE_ERR="CRM响应超时！";
	public static final String MSG_ANALYTICAL_XML_ERR="解析xml失败！";		
	public static final String MSG_SUCCESS="成功！";		
	
	public static final String MSG_SYSTEM_ERR="系统内部错误!";

	//订购状态
	public static final String FPS_FLOWORDER_ORDER = "1";//订购中
	public static final String FPS_FLOWORDER_SUCCESS = "2";//订购成功
	public static final String FPS_FLOWORDER_ERROR = "3";//订购失败


	
}

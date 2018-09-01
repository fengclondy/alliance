/**
 * 
 */
package com.ai.aso.common.bo;

import java.io.Serializable;

/**
 * @ClassName: CrmOutParam
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-11-1 下午12:13:06
 * 
 */

public class CrmOutParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result="";// 0成功 1失败
	private String resultCode="";// 错误码
	private String resultMsg="";// 成功示例：受理成功olId=790892231;boId=2324334,43423424,32423423
								// 失败示例：入参检查:号码不存在 olId未crm流水号
	private String areaCode="";// 手机对应地区号 映射到本系统regionId 填入 rec表 Cost_Region
	private String provId="";// 手机号对应的serv_id 这两个字段 就对应rec表 Serv_Id
	private String errmsg="";
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getProvId() {
		return provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}

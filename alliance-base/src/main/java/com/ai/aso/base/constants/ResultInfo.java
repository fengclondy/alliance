package com.ai.aso.base.constants;

import java.io.Serializable;

import com.ai.aso.base.exception.BaseException;
import com.alibaba.fastjson.JSONObject;

/**
 * 封装结果集信息，主要用于Controller返回，对应ViewModel 其中：<br>
 * reType 标识执行成功失败，主要用于判断某操作是否成功 reCode 标识业务执行返回码，根据返回码可进一步确认操作执行结果 reMesg
 * 表示业务逻辑执行后最终返回的提示信息，一般与reCode一一对应 reModel
 * 最终返回的数据模型，一般表示的是成功执行后返回的数据，但也可扩展为必要的错误分析数据
 * */
public class ResultInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 处理结果(成功/失败)
	private boolean reType;

	// 返回结果码，一般与返回结果提示信息相对应，可作为查找结果提示信息的key
	private String code;

	// 返回结果提示信息
	private String msg;

	// 返回结果集，一般携带成功执行后要返回给调用者的数据
	private Object reModel;

	public ResultInfo() {
		this.reType = true;
		this.code = IResultCode.SYS_SUCCESS;
		this.msg = "";
	}

	public ResultInfo(BaseException exp) {
		this.reType = false;
		this.setCode(exp.getCode());
		this.msg = exp.getTip();
	}

	public boolean isReType() {
		return reType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (null != code && code.startsWith("F")) {
			this.reType = false;
		} else {
			this.reType = true;
		}
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getReModel() {
		return reModel;
	}

	public void setReModel(Object reModel) {
		this.reModel = reModel;
	}

	@Override
	public String toString() {
		return toJSONString();
	}

	public String toJSONString() {
		return JSONObject.toJSONString(this);
	}

	public void setReType(boolean reType) {
		this.reType = reType;
	}

}

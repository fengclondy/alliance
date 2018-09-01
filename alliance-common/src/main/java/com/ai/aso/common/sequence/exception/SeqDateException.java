package com.ai.aso.common.sequence.exception;

import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.SystemException;

public class SeqDateException extends SystemException {

	private static final long serialVersionUID = -6357105572444016887L;

	public SeqDateException() {
		super(ExInfo.create("F100000000", "日期序列获取失败！", "系统内部错误"));
	}
	
	public SeqDateException(String name) {
		super(ExInfo.create("F100000000", name+"日期序列获取失败！", "系统内部错误"));
	}

}

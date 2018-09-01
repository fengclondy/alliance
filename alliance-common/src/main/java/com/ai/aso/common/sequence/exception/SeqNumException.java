package com.ai.aso.common.sequence.exception;

import com.ai.aso.base.exception.ExInfo;
import com.ai.aso.base.exception.SystemException;

public class SeqNumException extends SystemException {

	private static final long serialVersionUID = -6357105572444016887L;

	public SeqNumException() {
		super(ExInfo.create("F100000000", "数字序列获取失败！", "系统内部错误"));
	}

}

package com.ai.aso.common.exception;

import com.ai.aso.base.exception.BusinessException;
import com.ai.aso.base.exception.ExInfo;
/**
 * 合同账本异常
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月29日
 *
 */
public class ContBookValidException extends BusinessException{

	private static final long serialVersionUID = 3065687495420615578L;

	public ContBookValidException() {
		super(BizExInfoEnum.No_ACCESS_ERROR);
	}

	public ContBookValidException(ExInfo exInfo) {
		super(exInfo);
	}

}

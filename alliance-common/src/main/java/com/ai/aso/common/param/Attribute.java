package com.ai.aso.common.param;

import java.io.Serializable;

public class        Attribute implements Serializable {

	private static final long serialVersionUID = 6774961374216259778L;

	/**
	 * 属性编码
	 */
	private String attrCode;

	/**
	 * 属性名称
	 */
	private String attrName;

	public String getAttrCode() {
		return attrCode;
	}

	public void setAttrCode(String attrCode) {
		this.attrCode = attrCode;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

}

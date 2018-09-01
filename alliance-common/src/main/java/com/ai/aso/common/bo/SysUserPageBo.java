package com.ai.aso.common.bo;

import java.util.List;

public class SysUserPageBo {
	private Long dataCount;
	
	private List<SysUserInfoBo> dataList;

	public SysUserPageBo(){
		dataCount = 0l;
	}
	
	public Long getDataCount() {
		return dataCount;
	}

	public void setDataCount(Long dataCount) {
		this.dataCount = dataCount;
	}

	public List<SysUserInfoBo> getDataList() {
		return dataList;
	}

	public void setDataList(List<SysUserInfoBo> dataList) {
		this.dataList = dataList;
	}
	
}

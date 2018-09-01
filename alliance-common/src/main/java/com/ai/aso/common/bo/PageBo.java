/**
 * 该模型用于携带分页参数
 * */
package com.ai.aso.common.bo;

import java.util.HashMap;
import java.util.Map;

public class PageBo {
	
	//要获取哪一页的数据，页号从零开始
	private Integer pageNo;
	//每页显示多少条数据
	private Integer pageSize;
    //排序字段名
    private String orderCol;
    
    public PageBo(){
    	pageNo = 0;
    	pageSize = 10;
    }

	public Map<String, Object> getPageParams(){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("index", pageNo);
		params.put("pageSize", getPageSize());
		return params;
	}
	
	public String getOrderCol() {
		return orderCol;
	}

	public void setOrderCol(String orderCol) {
		this.orderCol = orderCol;
	}

	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}

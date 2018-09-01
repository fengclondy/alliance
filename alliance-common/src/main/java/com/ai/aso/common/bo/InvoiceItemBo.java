package com.ai.aso.common.bo;
/**
 * 发票项
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月13日
 *
 */
public class InvoiceItemBo {
	private Long id;

    private String invcdId;

    private String orderId;

    private String custId;

    private String billMonth;

    private Long amount;

    private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvcdId() {
		return invcdId;
	}

	public void setInvcdId(String invcdId) {
		this.invcdId = invcdId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
}

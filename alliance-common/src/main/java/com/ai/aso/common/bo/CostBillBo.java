package com.ai.aso.common.bo;

import java.util.Date;

/**
 * 收入统计
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月13日
 *
 */
public class CostBillBo {
	private Long costId;

    private String billMonth;

    private String custId;

    private String custName;

    private Integer regionId;

    private String regionName;

    private String orderId;

    private Long usedData;

    private Long expData;

    private Long billFee;

    private Long totalFee;

    private Long offFee;

    private Integer discount;

    private Integer state;

    private Integer isInvcd;

    private Date begDate;

    private Date endDate;

    private Date createDate;

    private Date operDate;

    private String operator;

	public Long getCostId() {
		return costId;
	}

	public void setCostId(Long costId) {
		this.costId = costId;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getUsedData() {
		return usedData;
	}

	public void setUsedData(Long usedData) {
		this.usedData = usedData;
	}

	public Long getExpData() {
		return expData;
	}

	public void setExpData(Long expData) {
		this.expData = expData;
	}

	public Long getBillFee() {
		return billFee;
	}

	public void setBillFee(Long billFee) {
		this.billFee = billFee;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public Long getOffFee() {
		return offFee;
	}

	public void setOffFee(Long offFee) {
		this.offFee = offFee;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsInvcd() {
		return isInvcd;
	}

	public void setIsInvcd(Integer isInvcd) {
		this.isInvcd = isInvcd;
	}

	public Date getBegDate() {
		return begDate;
	}

	public void setBegDate(Date begDate) {
		this.begDate = begDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getOperDate() {
		return operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
    
}

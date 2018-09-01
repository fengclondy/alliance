package com.ai.aso.common.webService.model;


import java.util.Date;
import java.util.List;

import com.ai.aso.common.db.model.CostBill;
import com.ai.aso.common.db.model.CostBillCharge;
import com.ai.aso.common.db.model.CostBillItem;
/**
 * 
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年11月15日
 *
 */
public class CostBillBo {
	 private Long costId;

	    private String billMonth;

	    private String actuMonth;

	    private String custId;

	    private String custName;

	    private Integer regionId;

	    private String regionName;

	    private String contId;

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

	    private String ext1;

	    private String ext2;

	    private String ext3;

	private List<CostBillItem> costBillItems;
	private String acctId;

	private String servId;
	private CostBill costBill;
	private CostBillCharge costBillCharge;
	
public CostBill getCostBill() {
		return costBill;
	}
	public void setCostBill(CostBill costBill) {
		this.costBill = costBill;
	}
public CostBill toCostBill(CostBillBo costBillbo){
	CostBill costBill = new CostBill();
	costBill.setActuMonth(costBillbo.getActuMonth());
	costBill.setBegDate(costBillbo.getBegDate());
	costBill.setBillFee(costBillbo.getBillFee());
	costBill.setBillMonth(costBillbo.getBillMonth());
	costBill.setContId(costBillbo.getContId());
	costBill.setCostId(costBillbo.getCostId());
	costBill.setCreateDate(costBillbo.getCreateDate());
	costBill.setCustId(costBillbo.getCustId());
	costBill.setCustName(costBillbo.getCustName());
	costBill.setDiscount(costBillbo.getDiscount());
	costBill.setEndDate(costBillbo.getEndDate());
	costBill.setExpData(costBillbo.getExpData());
	costBill.setExt1(costBillbo.getExt1());
	costBill.setExt2(costBillbo.getExt2());
	costBill.setExt3(costBillbo.getExt3());
	costBill.setIsInvcd(costBillbo.getIsInvcd());
	costBill.setOffFee(costBillbo.getOffFee());
	costBill.setOperator(costBillbo.getOperator());
	costBill.setOperDate(costBillbo.getOperDate());
	costBill.setRegionId(costBillbo.getRegionId());
	costBill.setRegionName(costBillbo.getRegionName());
	costBill.setState(costBillbo.getState());
	costBill.setTotalFee(costBillbo.getTotalFee());
	costBill.setUsedData(costBillbo.getUsedData());
	return costBill;
}
	public List<CostBillItem> getCostBillItems() {
		return costBillItems;
	}

	public void setCostBillItems(List<CostBillItem> costBillItems) {
		this.costBillItems = costBillItems;
	}
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
	public String getActuMonth() {
		return actuMonth;
	}
	public void setActuMonth(String actuMonth) {
		this.actuMonth = actuMonth;
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
	public String getContId() {
		return contId;
	}
	public void setContId(String contId) {
		this.contId = contId;
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
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public String getServId() {
		return servId;
	}
	public void setServId(String servId) {
		this.servId = servId;
	}
	public CostBillCharge getCostBillCharge() {
		return costBillCharge;
	}
	public void setCostBillCharge(CostBillCharge costBillCharge) {
		this.costBillCharge = costBillCharge;
	}

}

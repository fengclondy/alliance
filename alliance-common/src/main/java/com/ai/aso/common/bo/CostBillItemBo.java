package com.ai.aso.common.bo;
/**
 * 分摊明细
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月13日
 *
 */
public class CostBillItemBo {
	 private Long costItemId;

	    private String billMonth;

	    private String custId;

	    private String custName;

	    private Integer regionId;

	    private String regionName;

	    private Integer busiMode;

	    private Short payType;

	    private String orderId;

	    private Long usedData;

	    private Long expData;

	    private Long billFee;

	    private Long totalFee;

	    private Long offFee;

	    private Integer discount;

	    private Integer costRegion;

	    private String costCenter;

		public Long getCostItemId() {
			return costItemId;
		}

		public void setCostItemId(Long costItemId) {
			this.costItemId = costItemId;
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

		public Integer getBusiMode() {
			return busiMode;
		}

		public void setBusiMode(Integer busiMode) {
			this.busiMode = busiMode;
		}

		public Short getPayType() {
			return payType;
		}

		public void setPayType(Short payType) {
			this.payType = payType;
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

		public Integer getCostRegion() {
			return costRegion;
		}

		public void setCostRegion(Integer costRegion) {
			this.costRegion = costRegion;
		}

		public String getCostCenter() {
			return costCenter;
		}

		public void setCostCenter(String costCenter) {
			this.costCenter = costCenter;
		}
	    
}

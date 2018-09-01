package com.ai.aso.common.db.model;

public class CostBillItem {
    private Long costItemId;

    private String billMonth;

    private String actuMonth;

    private String custId;

    private String custName;

    private Integer regionId;

    private String regionName;

    private Integer busiMode;

    private Short payType;

    private String contId;

    private Long usedData;

    private Long expData;

    private Long billFee;

    private Long totalFee;

    private Long offFee;

    private Long income;

    private Integer discount;

    private Integer costRegion;

    private String costCenter;

    private String ext1;

    private String ext2;

    private String ext3;

    private Integer costRate;

    private Integer costRegionName;

    private Long costFee;

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
        this.billMonth = billMonth == null ? null : billMonth.trim();
    }

    public String getActuMonth() {
        return actuMonth;
    }

    public void setActuMonth(String actuMonth) {
        this.actuMonth = actuMonth == null ? null : actuMonth.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
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
        this.regionName = regionName == null ? null : regionName.trim();
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

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
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

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
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
        this.costCenter = costCenter == null ? null : costCenter.trim();
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public Integer getCostRate() {
        return costRate;
    }

    public void setCostRate(Integer costRate) {
        this.costRate = costRate;
    }

    public Integer getCostRegionName() {
        return costRegionName;
    }

    public void setCostRegionName(Integer costRegionName) {
        this.costRegionName = costRegionName;
    }

    public Long getCostFee() {
        return costFee;
    }

    public void setCostFee(Long costFee) {
        this.costFee = costFee;
    }
}
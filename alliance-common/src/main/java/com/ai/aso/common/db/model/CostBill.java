package com.ai.aso.common.db.model;

import java.util.Date;

public class CostBill {
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
        this.operator = operator == null ? null : operator.trim();
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
}
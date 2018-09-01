package com.ai.aso.common.db.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_BILL_REC")
public class BillRec {

    private Long billRecId;

    private String billMonth;

    private String billBatch;

    private Integer sourceType;

    private Short payType;

    private String dataBookId;

    private String capBookId;

    private String recNo;

    private Long batchCode;

    private Short recClass;

    private Integer recMode;

    private String contId;

    private String contNo;

    private String custId;

    private String custName;

    private Integer regionId;

    private String regionName;

    private Integer busiMode;

    private String userNbr;

    private Integer costRegion;

    private String costRegionName;

    private String servId;

    private String billOfferId;

    private String offerInst;

    private String goodsId;

    private Integer goodsType;

    private Integer dataType;

    private String goodsName;

    private Long dataVal;

    private Integer discount;

    private Long billFee;

    private Long totalFee;

    private Long offFee;

    private Integer costRate;

    private Long costFee;

    private String remarks;

    private Short recState;

    private Date subDate;

    private Date recDate;

    private String trdRec;

    private String trdSaler;

    private String trdActivity;

    private String costCenter;

    private Integer state;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public Long getBillRecId() {
        return billRecId;
    }

    public void setBillRecId(Long billRecId) {
        this.billRecId = billRecId;
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth == null ? null : billMonth.trim();
    }

    public String getBillBatch() {
        return billBatch;
    }

    public void setBillBatch(String billBatch) {
        this.billBatch = billBatch == null ? null : billBatch.trim();
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public String getDataBookId() {
        return dataBookId;
    }

    public void setDataBookId(String dataBookId) {
        this.dataBookId = dataBookId == null ? null : dataBookId.trim();
    }

    public String getCapBookId() {
        return capBookId;
    }

    public void setCapBookId(String capBookId) {
        this.capBookId = capBookId == null ? null : capBookId.trim();
    }

    public String getRecNo() {
        return recNo;
    }

    public void setRecNo(String recNo) {
        this.recNo = recNo == null ? null : recNo.trim();
    }

    public Long getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(Long batchCode) {
        this.batchCode = batchCode;
    }

    public Short getRecClass() {
        return recClass;
    }

    public void setRecClass(Short recClass) {
        this.recClass = recClass;
    }

    public Integer getRecMode() {
        return recMode;
    }

    public void setRecMode(Integer recMode) {
        this.recMode = recMode;
    }

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
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

    public String getUserNbr() {
        return userNbr;
    }

    public void setUserNbr(String userNbr) {
        this.userNbr = userNbr == null ? null : userNbr.trim();
    }

    public Integer getCostRegion() {
        return costRegion;
    }

    public void setCostRegion(Integer costRegion) {
        this.costRegion = costRegion;
    }

    public String getCostRegionName() {
        return costRegionName;
    }

    public void setCostRegionName(String costRegionName) {
        this.costRegionName = costRegionName == null ? null : costRegionName.trim();
    }

    public String getServId() {
        return servId;
    }

    public void setServId(String servId) {
        this.servId = servId == null ? null : servId.trim();
    }

    public String getBillOfferId() {
        return billOfferId;
    }

    public void setBillOfferId(String billOfferId) {
        this.billOfferId = billOfferId == null ? null : billOfferId.trim();
    }

    public String getOfferInst() {
        return offerInst;
    }

    public void setOfferInst(String offerInst) {
        this.offerInst = offerInst == null ? null : offerInst.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Long getDataVal() {
        return dataVal;
    }

    public void setDataVal(Long dataVal) {
        this.dataVal = dataVal;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
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

    public Integer getCostRate() {
        return costRate;
    }

    public void setCostRate(Integer costRate) {
        this.costRate = costRate;
    }

    public Long getCostFee() {
        return costFee;
    }

    public void setCostFee(Long costFee) {
        this.costFee = costFee;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Short getRecState() {
        return recState;
    }

    public void setRecState(Short recState) {
        this.recState = recState;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public String getTrdRec() {
        return trdRec;
    }

    public void setTrdRec(String trdRec) {
        this.trdRec = trdRec == null ? null : trdRec.trim();
    }

    public String getTrdSaler() {
        return trdSaler;
    }

    public void setTrdSaler(String trdSaler) {
        this.trdSaler = trdSaler == null ? null : trdSaler.trim();
    }

    public String getTrdActivity() {
        return trdActivity;
    }

    public void setTrdActivity(String trdActivity) {
        this.trdActivity = trdActivity == null ? null : trdActivity.trim();
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter == null ? null : costCenter.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
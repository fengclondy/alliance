package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_DATA_REC")
public class DataRec {
    private String recNo;

    private String batchCode;

    private Short recClass;

    private Integer recMode;

    private String contId;

    private String custId;

    private String userNbr;

    private Integer busiMode;

    private String goodsId;

    private Integer goodsType;

    private String goodsName;

    private Long dataVal;

    private Long totalFee;

    private Long offFee;

    private Integer discount;

    private Long billFee;

    private String remarks;

    private Short state;

    private Date beginDate;

    private Date endDate;

    private String errMesg;

    private Date createDate;

    private Integer dealCount;

    private Integer redoFlag;

    private Long operId;

    private String operName;

    private String operComm;

    private Integer billRule;

    private String billSerial;

    private String resultMesg;

    private String offerId;

    private String servId;

    private String offerInst;

    private String trdRec;

    private Integer costRegion;

    private String costCenter;

    private String billBatch;

    private String billMonth;

    private Integer billState;

    private Integer ver;

    private String ext1;

    private String ext2;

    private String ext3;

    private Integer dataType;

    private Integer regionId;

    private String resultCode;

    private String trdSaler;

    private String trdActivity;

    private String contNo;
    @Id
    public String getRecNo() {
        return recNo;
    }

    public void setRecNo(String recNo) {
        this.recNo = recNo == null ? null : recNo.trim();
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getUserNbr() {
        return userNbr;
    }

    public void setUserNbr(String userNbr) {
        this.userNbr = userNbr == null ? null : userNbr.trim();
    }

    public Integer getBusiMode() {
        return busiMode;
    }

    public void setBusiMode(Integer busiMode) {
        this.busiMode = busiMode;
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

    public Long getBillFee() {
        return billFee;
    }

    public void setBillFee(Long billFee) {
        this.billFee = billFee;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getErrMesg() {
        return errMesg;
    }

    public void setErrMesg(String errMesg) {
        this.errMesg = errMesg == null ? null : errMesg.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDealCount() {
        return dealCount;
    }

    public void setDealCount(Integer dealCount) {
        this.dealCount = dealCount;
    }

    public Integer getRedoFlag() {
        return redoFlag;
    }

    public void setRedoFlag(Integer redoFlag) {
        this.redoFlag = redoFlag;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getOperComm() {
        return operComm;
    }

    public void setOperComm(String operComm) {
        this.operComm = operComm == null ? null : operComm.trim();
    }

    public Integer getBillRule() {
        return billRule;
    }

    public void setBillRule(Integer billRule) {
        this.billRule = billRule;
    }

    public String getBillSerial() {
        return billSerial;
    }

    public void setBillSerial(String billSerial) {
        this.billSerial = billSerial == null ? null : billSerial.trim();
    }

    public String getResultMesg() {
        return resultMesg;
    }

    public void setResultMesg(String resultMesg) {
        this.resultMesg = resultMesg == null ? null : resultMesg.trim();
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId == null ? null : offerId.trim();
    }

    public String getServId() {
        return servId;
    }

    public void setServId(String servId) {
        this.servId = servId == null ? null : servId.trim();
    }

    public String getOfferInst() {
        return offerInst;
    }

    public void setOfferInst(String offerInst) {
        this.offerInst = offerInst == null ? null : offerInst.trim();
    }

    public String getTrdRec() {
        return trdRec;
    }

    public void setTrdRec(String trdRec) {
        this.trdRec = trdRec == null ? null : trdRec.trim();
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

    public String getBillBatch() {
        return billBatch;
    }

    public void setBillBatch(String billBatch) {
        this.billBatch = billBatch == null ? null : billBatch.trim();
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth == null ? null : billMonth.trim();
    }

    public Integer getBillState() {
        return billState;
    }

    public void setBillState(Integer billState) {
        this.billState = billState;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
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

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
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

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }
}
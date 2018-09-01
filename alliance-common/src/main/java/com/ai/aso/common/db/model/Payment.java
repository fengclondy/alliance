package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_PAYMENT")
public class Payment {
    private String paymentId;

    private Integer payMode;

    private Integer costType;

    private String custId;

    private Integer objectType;

    private String objectId;

    private Long amount;

    private Date applyDate;

    private Date payDate;

    private Integer payState;

    private String payCert;

    private String billCode;

    private String billServid;

    private String billAcct;

    private String payNo;

    private String payReqid;

    private String payResid;

    private String operator;

    private String auditor;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId == null ? null : paymentId.trim();
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public Integer getObjectType() {
        return objectType;
    }

    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public String getPayCert() {
        return payCert;
    }

    public void setPayCert(String payCert) {
        this.payCert = payCert == null ? null : payCert.trim();
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    public String getBillServid() {
        return billServid;
    }

    public void setBillServid(String billServid) {
        this.billServid = billServid == null ? null : billServid.trim();
    }

    public String getBillAcct() {
        return billAcct;
    }

    public void setBillAcct(String billAcct) {
        this.billAcct = billAcct == null ? null : billAcct.trim();
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getPayReqid() {
        return payReqid;
    }

    public void setPayReqid(String payReqid) {
        this.payReqid = payReqid == null ? null : payReqid.trim();
    }

    public String getPayResid() {
        return payResid;
    }

    public void setPayResid(String payResid) {
        this.payResid = payResid == null ? null : payResid.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
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
package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import java.util.Date;
@Entity(name = "B_CAPITAL_RECORD")
public class CapitalRecord {
    private Long id;

    private String custId;

    private String acctId;

    private String bookId;

    private Long oldAmount;

    private Long curAmount;

    private Long operAmount;

    private Short operType;

    private Integer operSubType;

    private Date operDate;

    private String objectId;

    private String operComm;

    private Long lockVal;

    private String ext1;

    private String ext2;

    private String ext3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public Long getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(Long oldAmount) {
        this.oldAmount = oldAmount;
    }

    public Long getCurAmount() {
        return curAmount;
    }

    public void setCurAmount(Long curAmount) {
        this.curAmount = curAmount;
    }

    public Long getOperAmount() {
        return operAmount;
    }

    public void setOperAmount(Long operAmount) {
        this.operAmount = operAmount;
    }

    public Short getOperType() {
        return operType;
    }

    public void setOperType(Short operType) {
        this.operType = operType;
    }

    public Integer getOperSubType() {
        return operSubType;
    }

    public void setOperSubType(Integer operSubType) {
        this.operSubType = operSubType;
    }

    public Date getOperDate() {
        return operDate;
    }

    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getOperComm() {
        return operComm;
    }

    public void setOperComm(String operComm) {
        this.operComm = operComm == null ? null : operComm.trim();
    }

    public Long getLockVal() {
        return lockVal;
    }

    public void setLockVal(Long lockVal) {
        this.lockVal = lockVal;
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
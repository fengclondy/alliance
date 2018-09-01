package com.ai.aso.common.db.model;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
@Entity(name = "B_CONT_BOOK_RECORD")
public class ContbookRecord {

    private Long id;

    private String bookId;

    private Long operAmount;

    private Short operType;

    private Integer operSubType;

    private Date operDate;

    private String operComm;

    private Long lockVal;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
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
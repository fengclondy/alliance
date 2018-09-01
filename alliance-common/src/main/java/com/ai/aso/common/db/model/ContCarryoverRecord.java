package com.ai.aso.common.db.model;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
@Entity(name = "B_CONT_CARRYOVER_RECORD")
public class ContCarryoverRecord {

    private Long operNo;

    private String custid;

    private String custname;

    private String origContid;

    private String targetContid;

    private Long amount;

    private String opId;

    private String opName;

    private Date opDate;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public Long getOperNo() {
        return operNo;
    }

    public void setOperNo(Long operNo) {
        this.operNo = operNo;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid == null ? null : custid.trim();
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }

    public String getOrigContid() {
        return origContid;
    }

    public void setOrigContid(String origContid) {
        this.origContid = origContid == null ? null : origContid.trim();
    }

    public String getTargetContid() {
        return targetContid;
    }

    public void setTargetContid(String targetContid) {
        this.targetContid = targetContid == null ? null : targetContid.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId == null ? null : opId.trim();
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName == null ? null : opName.trim();
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
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
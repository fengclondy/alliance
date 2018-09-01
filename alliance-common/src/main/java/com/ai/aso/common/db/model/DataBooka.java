package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_DATA_BOOKA")
public class DataBooka {
    private String bookId;

    private String custId;

    private String acctId;

    private Integer acctType;

    private String contId;

    private String busiType;

    private Date effDate;

    private Date expDate;

    private Integer bookType;

    private String bookName;

    private Integer goodsType;

    private Short bookState;

    private Integer regionId;

    private String billRule;

    private Integer origType;

    private String origId;

    private String note;

    private Date createDate;

    private String serviceId;

    private Long totalVal;

    private Long cumuVal;

    private Long balaVal;

    private Integer ver;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;
    @Id
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
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

    public Integer getAcctType() {
        return acctType;
    }

    public void setAcctType(Integer acctType) {
        this.acctType = acctType;
    }

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType == null ? null : busiType.trim();
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Short getBookState() {
        return bookState;
    }

    public void setBookState(Short bookState) {
        this.bookState = bookState;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getBillRule() {
        return billRule;
    }

    public void setBillRule(String billRule) {
        this.billRule = billRule == null ? null : billRule.trim();
    }

    public Integer getOrigType() {
        return origType;
    }

    public void setOrigType(Integer origType) {
        this.origType = origType;
    }

    public String getOrigId() {
        return origId;
    }

    public void setOrigId(String origId) {
        this.origId = origId == null ? null : origId.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public Long getTotalVal() {
        return totalVal;
    }

    public void setTotalVal(Long totalVal) {
        this.totalVal = totalVal;
    }

    public Long getCumuVal() {
        return cumuVal;
    }

    public void setCumuVal(Long cumuVal) {
        this.cumuVal = cumuVal;
    }

    public Long getBalaVal() {
        return balaVal;
    }

    public void setBalaVal(Long balaVal) {
        this.balaVal = balaVal;
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

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5 == null ? null : ext5.trim();
    }
}
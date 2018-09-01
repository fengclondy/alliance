package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "B_DATA_BOOKA_STOCK")
public class DataBookaStock {
    private String stockId;

    private String bookId;

    private String goodsId;

    private String goodsName;

    private Integer goodsType;

    private Integer dataType;

    private Long goodsSpecs;

    private Long number;

    private Integer unitPrice;

    private Integer offRate;

    private Long stockVal;

    private Long usedVal;

    private String billOfferId;

    private Integer ver;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
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

    public Long getGoodsSpecs() {
        return goodsSpecs;
    }

    public void setGoodsSpecs(Long goodsSpecs) {
        this.goodsSpecs = goodsSpecs;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getOffRate() {
        return offRate;
    }

    public void setOffRate(Integer offRate) {
        this.offRate = offRate;
    }

    public Long getStockVal() {
        return stockVal;
    }

    public void setStockVal(Long stockVal) {
        this.stockVal = stockVal;
    }

    public Long getUsedVal() {
        return usedVal;
    }

    public void setUsedVal(Long usedVal) {
        this.usedVal = usedVal;
    }

    public String getBillOfferId() {
        return billOfferId;
    }

    public void setBillOfferId(String billOfferId) {
        this.billOfferId = billOfferId == null ? null : billOfferId.trim();
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
}
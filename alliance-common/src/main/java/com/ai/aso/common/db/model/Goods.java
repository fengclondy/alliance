package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_GOODS")
public class Goods {
    private String goodsId;

    private String catalogId;

    private Integer goodsType;

    private Integer dataType;

    private String goodsName;

    private String goodsModel;

    private Long goodsSpecs;

    private String goodsDesc;

    private Long goodsPrice;

    private Short state;

    private Date effDate;

    private Date expDate;

    private String billOfferId;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
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

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel == null ? null : goodsModel.trim();
    }

    public Long getGoodsSpecs() {
        return goodsSpecs;
    }

    public void setGoodsSpecs(Long goodsSpecs) {
        this.goodsSpecs = goodsSpecs;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
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

    public String getBillOfferId() {
        return billOfferId;
    }

    public void setBillOfferId(String billOfferId) {
        this.billOfferId = billOfferId == null ? null : billOfferId.trim();
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

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", catalogId=" + catalogId
				+ ", goodsType=" + goodsType + ", dataType=" + dataType
				+ ", goodsName=" + goodsName + ", goodsModel=" + goodsModel
				+ ", goodsSpecs=" + goodsSpecs + ", goodsDesc=" + goodsDesc
				+ ", goodsPrice=" + goodsPrice + ", state=" + state
				+ ", effDate=" + effDate + ", expDate=" + expDate
				+ ", billOfferId=" + billOfferId + ", ext1=" + ext1 + ", ext2="
				+ ext2 + ", ext3=" + ext3 + "]";
	}
    
    
}
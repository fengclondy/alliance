package com.ai.aso.manager.web.vo;

import java.util.Date;

public class DataRecVo {
	//订购流水
	private String recNo;
	
	private String contId;
	
    private Long batchCode;

    private Short recClass;

    private Integer recMode;
    private String custName;
    private String custId;
     //手机号码
    private String userNbr;
    //商品ID
    private String goodsId;

    private Integer goodsType;
    
    private Integer dataType;
    //流量类型
    private String dataTypeName;
    //商品名称
    private String goodsName;
    //充值流量规格
    private Long dataVal;
    //产品模式
    private String goodsModel;
    private Long totalFee;

    private Long offFee;
    //折扣
    private Integer discount;
    //价格
    private Long billFee;

    private String remarks;

    private Short state;
    //充值状态
    private String stateName;
    //充值时间
    private Date beginDate;
    private String sBeginDate;
    //充值完成时间
    private Date endDate;
    //完成时间
    private String sEndDate;
    //失败原因
    private String errMesg;

    private Date createDate;

    private Long operId;

    private String operName;

    private String operComm;

    private Integer billRule;

    private String billSerial;

    private String resultMesg;

    private Long offerId;

    private String servId;

    private Integer costRegion;

    private String costCenter;
    //账期
    private String billMonth;
    //出账状态
    private Integer billState;
    // 出账批次
    private String billBatch;
    //地区
    private Integer regionId;
    private Integer goodsSpecs;
    //销售地
	private String costRegionName;
	//所属地市
	private String regionName;
	
	public String getGoodsModel() {
		return goodsModel;
	}

	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}

	public String getCostRegionName() {
		return costRegionName;
	}

	public void setCostRegionName(String costRegionName) {
		this.costRegionName = costRegionName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRecNo() {
		return recNo;
	}

	public void setRecNo(String recNo) {
		this.recNo = recNo;
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

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getUserNbr() {
		return userNbr;
	}

	public void setUserNbr(String userNbr) {
		this.userNbr = userNbr;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
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

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
		this.remarks = remarks;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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
		this.errMesg = errMesg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		this.operName = operName;
	}

	public String getOperComm() {
		return operComm;
	}

	public void setOperComm(String operComm) {
		this.operComm = operComm;
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
		this.billSerial = billSerial;
	}

	public String getResultMesg() {
		return resultMesg;
	}

	public void setResultMesg(String resultMesg) {
		this.resultMesg = resultMesg;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
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
		this.costCenter = costCenter;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public Integer getBillState() {
		return billState;
	}

	public void setBillState(Integer billState) {
		this.billState = billState;
	}


	public Integer getGoodsSpecs() {
		return goodsSpecs;
	}

	public void setGoodsSpecs(Integer goodsSpecs) {
		this.goodsSpecs = goodsSpecs;
	}

	public String getBillBatch() {
		return billBatch;
	}

	public void setBillBatch(String billBatch) {
		this.billBatch = billBatch;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getContId() {
		return contId;
	}

	public void setContId(String contId) {
		this.contId = contId;
	}

	public String getsEndDate() {
		return sEndDate;
	}

	public void setsEndDate(String sEndDate) {
		this.sEndDate = sEndDate;
	}

	public String getsBeginDate() {
		return sBeginDate;
	}

	public void setsBeginDate(String sBeginDate) {
		this.sBeginDate = sBeginDate;
	}
    
}

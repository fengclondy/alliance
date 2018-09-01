package com.ai.aso.common.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ai.aso.common.db.model.ContractItem;
import com.ai.aso.common.db.model.DataRec;

public class DataRecBo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8724530854330957086L;

	private String recNo;

    private Long batchCode;

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
    
    private String regionId;
    
    private String resultCode;
    
    private String trdSaler;
    
    private String trdActivity;
    
    private String contNo;
    
    public DataRecBo convert(DataRec dr, DataRecBo bo) {
    	if (null != dr) {
    		BeanUtils.copyProperties(dr, bo);
    	}
    	return bo;
    }
    
    public static List<DataRecBo> convertList(List<DataRec> drList) {
    	List<DataRecBo> boList = null;
    	if (null != drList && !drList.isEmpty()) {
    		boList = new ArrayList<DataRecBo>();
    		for (DataRec dr : drList) {
    			DataRecBo bo = new DataRecBo();
    			bo.convert(dr, bo);
    			boList.add(bo);
    		}
    	}
    	return boList;
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

	public String getContId() {
		return contId;
	}

	public void setContId(String contId) {
		this.contId = contId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getUserNbr() {
		return userNbr;
	}

	public void setUserNbr(String userNbr) {
		this.userNbr = userNbr;
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
		this.goodsId = goodsId;
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

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
	}

	public String getOfferInst() {
		return offerInst;
	}

	public void setOfferInst(String offerInst) {
		this.offerInst = offerInst;
	}

	public String getTrdRec() {
		return trdRec;
	}

	public void setTrdRec(String trdRec) {
		this.trdRec = trdRec;
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

	public String getBillBatch() {
		return billBatch;
	}

	public void setBillBatch(String billBatch) {
		this.billBatch = billBatch;
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
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getTrdSaler() {
		return trdSaler;
	}

	public void setTrdSaler(String trdSaler) {
		this.trdSaler = trdSaler;
	}

	public String getTrdActivity() {
		return trdActivity;
	}

	public void setTrdActivity(String trdActivity) {
		this.trdActivity = trdActivity;
	}

	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false; 
		if( obj instanceof ContractItem )
		{
			ContractItem other = (ContractItem) obj;
			if( this.goodsId.equals( other.getGoodsId()))
			{
				return true;
			}
		}
		if( obj instanceof DataRecBo )
		{
			DataRecBo other = (DataRecBo) obj;
			if( this.goodsId.equals(other.getGoodsId()) )
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "DataRecBo [recNo=" + recNo + ", batchCode=" + batchCode
				+ ", recClass=" + recClass + ", recMode=" + recMode
				+ ", contId=" + contId + ", custId=" + custId + ", userNbr="
				+ userNbr + ", busiMode=" + busiMode + ", goodsId=" + goodsId
				+ ", goodsType=" + goodsType + ", goodsName=" + goodsName
				+ ", dataVal=" + dataVal + ", totalFee=" + totalFee
				+ ", offFee=" + offFee + ", discount=" + discount
				+ ", billFee=" + billFee + ", remarks=" + remarks + ", state="
				+ state + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", errMesg=" + errMesg + ", createDate=" + createDate
				+ ", dealCount=" + dealCount + ", redoFlag=" + redoFlag
				+ ", operId=" + operId + ", operName=" + operName
				+ ", operComm=" + operComm + ", billRule=" + billRule
				+ ", billSerial=" + billSerial + ", resultMesg=" + resultMesg
				+ ", offerId=" + offerId + ", servId=" + servId
				+ ", offerInst=" + offerInst + ", trdRec=" + trdRec
				+ ", costRegion=" + costRegion + ", costCenter=" + costCenter
				+ ", billBatch=" + billBatch + ", billMonth=" + billMonth
				+ ", billState=" + billState + ", ver=" + ver + ", ext1="
				+ ext1 + ", ext2=" + ext2 + ", ext3=" + ext3 + ", dataType="
				+ dataType + "]";
	}
	
}
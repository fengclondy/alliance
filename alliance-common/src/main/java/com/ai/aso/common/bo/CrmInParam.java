/**
 * 
 */
package com.ai.aso.common.bo;

import java.io.Serializable;

/**
 * @ClassName: CrmInParam
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author caiwz
 * @date 2016-11-1 下午12:12:50
 * 
 */

public class CrmInParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderSeq;// 订购流水号
	private String accNbr;// 手机号
	private String offerId;
	private String offerSpecId;//消费品id
	private String actionCd;
	private String areaCode;
	private String channelId;
	private String effDate;
	private String expDate;

	public String getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(String orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getAccNbr() {
		return accNbr;
	}

	public void setAccNbr(String accNbr) {
		this.accNbr = accNbr;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getOfferSpecId() {
		return offerSpecId;
	}

	public void setOfferSpecId(String offerSpecId) {
		this.offerSpecId = offerSpecId;
	}

	public String getActionCd() {
		return actionCd;
	}

	public void setActionCd(String actionCd) {
		this.actionCd = actionCd;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

}

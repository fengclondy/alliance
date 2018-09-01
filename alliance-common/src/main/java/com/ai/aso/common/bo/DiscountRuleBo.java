package com.ai.aso.common.bo;
/**
 * 
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月6日
 *
 */
public class DiscountRuleBo {
	private String ruleId;

	private Integer ruleClass;

	private String ruleDesc;

	private Integer ruleMin;

	private Integer ruleMax;

	private Integer discount;

	private Long payment;

	private Long deposit;

	private Integer state;

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public Integer getRuleClass() {
		return ruleClass;
	}

	public void setRuleClass(Integer ruleClass) {
		this.ruleClass = ruleClass;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public Integer getRuleMin() {
		return ruleMin;
	}

	public void setRuleMin(Integer ruleMin) {
		this.ruleMin = ruleMin;
	}

	public Integer getRuleMax() {
		return ruleMax;
	}

	public void setRuleMax(Integer ruleMax) {
		this.ruleMax = ruleMax;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Long getPayment() {
		return payment;
	}

	public void setPayment(Long payment) {
		this.payment = payment;
	}

	public Long getDeposit() {
		return deposit;
	}

	public void setDeposit(Long deposit) {
		this.deposit = deposit;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}

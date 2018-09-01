package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "B_DISCOUNT_RULE")
public class DiscountRule {
    private String ruleId;

    private Integer ruleClass;

    private String ruleDesc;

    private Integer ruleMin;

    private Integer ruleMax;

    private Integer discount;

    private Long payment;

    private Long deposit;

    private Integer state;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
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
        this.ruleDesc = ruleDesc == null ? null : ruleDesc.trim();
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
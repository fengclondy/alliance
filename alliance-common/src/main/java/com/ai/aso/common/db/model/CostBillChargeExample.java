package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CostBillChargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostBillChargeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCostChargeIdIsNull() {
            addCriterion("Cost_Charge_Id is null");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdIsNotNull() {
            addCriterion("Cost_Charge_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdEqualTo(Long value) {
            addCriterion("Cost_Charge_Id =", value, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdNotEqualTo(Long value) {
            addCriterion("Cost_Charge_Id <>", value, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdGreaterThan(Long value) {
            addCriterion("Cost_Charge_Id >", value, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Cost_Charge_Id >=", value, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdLessThan(Long value) {
            addCriterion("Cost_Charge_Id <", value, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdLessThanOrEqualTo(Long value) {
            addCriterion("Cost_Charge_Id <=", value, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdIn(List<Long> values) {
            addCriterion("Cost_Charge_Id in", values, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdNotIn(List<Long> values) {
            addCriterion("Cost_Charge_Id not in", values, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdBetween(Long value1, Long value2) {
            addCriterion("Cost_Charge_Id between", value1, value2, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andCostChargeIdNotBetween(Long value1, Long value2) {
            addCriterion("Cost_Charge_Id not between", value1, value2, "costChargeId");
            return (Criteria) this;
        }

        public Criteria andBillMonthIsNull() {
            addCriterion("Bill_Month is null");
            return (Criteria) this;
        }

        public Criteria andBillMonthIsNotNull() {
            addCriterion("Bill_Month is not null");
            return (Criteria) this;
        }

        public Criteria andBillMonthEqualTo(String value) {
            addCriterion("Bill_Month =", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotEqualTo(String value) {
            addCriterion("Bill_Month <>", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthGreaterThan(String value) {
            addCriterion("Bill_Month >", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthGreaterThanOrEqualTo(String value) {
            addCriterion("Bill_Month >=", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLessThan(String value) {
            addCriterion("Bill_Month <", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLessThanOrEqualTo(String value) {
            addCriterion("Bill_Month <=", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLike(String value) {
            addCriterion("Bill_Month like", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotLike(String value) {
            addCriterion("Bill_Month not like", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthIn(List<String> values) {
            addCriterion("Bill_Month in", values, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotIn(List<String> values) {
            addCriterion("Bill_Month not in", values, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthBetween(String value1, String value2) {
            addCriterion("Bill_Month between", value1, value2, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotBetween(String value1, String value2) {
            addCriterion("Bill_Month not between", value1, value2, "billMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthIsNull() {
            addCriterion("Actu_Month is null");
            return (Criteria) this;
        }

        public Criteria andActuMonthIsNotNull() {
            addCriterion("Actu_Month is not null");
            return (Criteria) this;
        }

        public Criteria andActuMonthEqualTo(String value) {
            addCriterion("Actu_Month =", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthNotEqualTo(String value) {
            addCriterion("Actu_Month <>", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthGreaterThan(String value) {
            addCriterion("Actu_Month >", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthGreaterThanOrEqualTo(String value) {
            addCriterion("Actu_Month >=", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthLessThan(String value) {
            addCriterion("Actu_Month <", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthLessThanOrEqualTo(String value) {
            addCriterion("Actu_Month <=", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthLike(String value) {
            addCriterion("Actu_Month like", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthNotLike(String value) {
            addCriterion("Actu_Month not like", value, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthIn(List<String> values) {
            addCriterion("Actu_Month in", values, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthNotIn(List<String> values) {
            addCriterion("Actu_Month not in", values, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthBetween(String value1, String value2) {
            addCriterion("Actu_Month between", value1, value2, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andActuMonthNotBetween(String value1, String value2) {
            addCriterion("Actu_Month not between", value1, value2, "actuMonth");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("Cust_Id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("Cust_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("Cust_Id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("Cust_Id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("Cust_Id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("Cust_Id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("Cust_Id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("Cust_Id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("Cust_Id like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("Cust_Id not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("Cust_Id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("Cust_Id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("Cust_Id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("Cust_Id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("Cust_Name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("Cust_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("Cust_Name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("Cust_Name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("Cust_Name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("Cust_Name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("Cust_Name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("Cust_Name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("Cust_Name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("Cust_Name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("Cust_Name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("Cust_Name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("Cust_Name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("Cust_Name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("Region_Id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("Region_Id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Integer value) {
            addCriterion("Region_Id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Integer value) {
            addCriterion("Region_Id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Integer value) {
            addCriterion("Region_Id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Region_Id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Integer value) {
            addCriterion("Region_Id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Integer value) {
            addCriterion("Region_Id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Integer> values) {
            addCriterion("Region_Id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Integer> values) {
            addCriterion("Region_Id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Integer value1, Integer value2) {
            addCriterion("Region_Id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Region_Id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("Region_Name is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("Region_Name is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("Region_Name =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("Region_Name <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("Region_Name >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("Region_Name >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("Region_Name <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("Region_Name <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("Region_Name like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("Region_Name not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("Region_Name in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("Region_Name not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("Region_Name between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("Region_Name not between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andContIdIsNull() {
            addCriterion("Cont_Id is null");
            return (Criteria) this;
        }

        public Criteria andContIdIsNotNull() {
            addCriterion("Cont_Id is not null");
            return (Criteria) this;
        }

        public Criteria andContIdEqualTo(String value) {
            addCriterion("Cont_Id =", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdNotEqualTo(String value) {
            addCriterion("Cont_Id <>", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdGreaterThan(String value) {
            addCriterion("Cont_Id >", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdGreaterThanOrEqualTo(String value) {
            addCriterion("Cont_Id >=", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdLessThan(String value) {
            addCriterion("Cont_Id <", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdLessThanOrEqualTo(String value) {
            addCriterion("Cont_Id <=", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdLike(String value) {
            addCriterion("Cont_Id like", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdNotLike(String value) {
            addCriterion("Cont_Id not like", value, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdIn(List<String> values) {
            addCriterion("Cont_Id in", values, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdNotIn(List<String> values) {
            addCriterion("Cont_Id not in", values, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdBetween(String value1, String value2) {
            addCriterion("Cont_Id between", value1, value2, "contId");
            return (Criteria) this;
        }

        public Criteria andContIdNotBetween(String value1, String value2) {
            addCriterion("Cont_Id not between", value1, value2, "contId");
            return (Criteria) this;
        }

        public Criteria andUsedDataIsNull() {
            addCriterion("Used_Data is null");
            return (Criteria) this;
        }

        public Criteria andUsedDataIsNotNull() {
            addCriterion("Used_Data is not null");
            return (Criteria) this;
        }

        public Criteria andUsedDataEqualTo(Long value) {
            addCriterion("Used_Data =", value, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataNotEqualTo(Long value) {
            addCriterion("Used_Data <>", value, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataGreaterThan(Long value) {
            addCriterion("Used_Data >", value, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataGreaterThanOrEqualTo(Long value) {
            addCriterion("Used_Data >=", value, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataLessThan(Long value) {
            addCriterion("Used_Data <", value, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataLessThanOrEqualTo(Long value) {
            addCriterion("Used_Data <=", value, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataIn(List<Long> values) {
            addCriterion("Used_Data in", values, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataNotIn(List<Long> values) {
            addCriterion("Used_Data not in", values, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataBetween(Long value1, Long value2) {
            addCriterion("Used_Data between", value1, value2, "usedData");
            return (Criteria) this;
        }

        public Criteria andUsedDataNotBetween(Long value1, Long value2) {
            addCriterion("Used_Data not between", value1, value2, "usedData");
            return (Criteria) this;
        }

        public Criteria andExpDataIsNull() {
            addCriterion("Exp_Data is null");
            return (Criteria) this;
        }

        public Criteria andExpDataIsNotNull() {
            addCriterion("Exp_Data is not null");
            return (Criteria) this;
        }

        public Criteria andExpDataEqualTo(Long value) {
            addCriterion("Exp_Data =", value, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataNotEqualTo(Long value) {
            addCriterion("Exp_Data <>", value, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataGreaterThan(Long value) {
            addCriterion("Exp_Data >", value, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataGreaterThanOrEqualTo(Long value) {
            addCriterion("Exp_Data >=", value, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataLessThan(Long value) {
            addCriterion("Exp_Data <", value, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataLessThanOrEqualTo(Long value) {
            addCriterion("Exp_Data <=", value, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataIn(List<Long> values) {
            addCriterion("Exp_Data in", values, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataNotIn(List<Long> values) {
            addCriterion("Exp_Data not in", values, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataBetween(Long value1, Long value2) {
            addCriterion("Exp_Data between", value1, value2, "expData");
            return (Criteria) this;
        }

        public Criteria andExpDataNotBetween(Long value1, Long value2) {
            addCriterion("Exp_Data not between", value1, value2, "expData");
            return (Criteria) this;
        }

        public Criteria andBillFeeIsNull() {
            addCriterion("Bill_Fee is null");
            return (Criteria) this;
        }

        public Criteria andBillFeeIsNotNull() {
            addCriterion("Bill_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andBillFeeEqualTo(Long value) {
            addCriterion("Bill_Fee =", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotEqualTo(Long value) {
            addCriterion("Bill_Fee <>", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeGreaterThan(Long value) {
            addCriterion("Bill_Fee >", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("Bill_Fee >=", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeLessThan(Long value) {
            addCriterion("Bill_Fee <", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeLessThanOrEqualTo(Long value) {
            addCriterion("Bill_Fee <=", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeIn(List<Long> values) {
            addCriterion("Bill_Fee in", values, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotIn(List<Long> values) {
            addCriterion("Bill_Fee not in", values, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeBetween(Long value1, Long value2) {
            addCriterion("Bill_Fee between", value1, value2, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotBetween(Long value1, Long value2) {
            addCriterion("Bill_Fee not between", value1, value2, "billFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("Total_Fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("Total_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            addCriterion("Total_Fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            addCriterion("Total_Fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            addCriterion("Total_Fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("Total_Fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            addCriterion("Total_Fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            addCriterion("Total_Fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Long> values) {
            addCriterion("Total_Fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            addCriterion("Total_Fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            addCriterion("Total_Fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            addCriterion("Total_Fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeIsNull() {
            addCriterion("Off_Fee is null");
            return (Criteria) this;
        }

        public Criteria andOffFeeIsNotNull() {
            addCriterion("Off_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andOffFeeEqualTo(Long value) {
            addCriterion("Off_Fee =", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeNotEqualTo(Long value) {
            addCriterion("Off_Fee <>", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeGreaterThan(Long value) {
            addCriterion("Off_Fee >", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("Off_Fee >=", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeLessThan(Long value) {
            addCriterion("Off_Fee <", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeLessThanOrEqualTo(Long value) {
            addCriterion("Off_Fee <=", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeIn(List<Long> values) {
            addCriterion("Off_Fee in", values, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeNotIn(List<Long> values) {
            addCriterion("Off_Fee not in", values, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeBetween(Long value1, Long value2) {
            addCriterion("Off_Fee between", value1, value2, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeNotBetween(Long value1, Long value2) {
            addCriterion("Off_Fee not between", value1, value2, "offFee");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("Discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("Discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Integer value) {
            addCriterion("Discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Integer value) {
            addCriterion("Discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Integer value) {
            addCriterion("Discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Integer value) {
            addCriterion("Discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("Discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Integer> values) {
            addCriterion("Discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Integer> values) {
            addCriterion("Discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Integer value1, Integer value2) {
            addCriterion("Discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("Discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("State is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("State is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("State =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("State <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("State >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("State >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("State <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("State <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("State in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("State not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("State between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("State not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andIsInvcdIsNull() {
            addCriterion("Is_Invcd is null");
            return (Criteria) this;
        }

        public Criteria andIsInvcdIsNotNull() {
            addCriterion("Is_Invcd is not null");
            return (Criteria) this;
        }

        public Criteria andIsInvcdEqualTo(Integer value) {
            addCriterion("Is_Invcd =", value, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdNotEqualTo(Integer value) {
            addCriterion("Is_Invcd <>", value, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdGreaterThan(Integer value) {
            addCriterion("Is_Invcd >", value, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Is_Invcd >=", value, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdLessThan(Integer value) {
            addCriterion("Is_Invcd <", value, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdLessThanOrEqualTo(Integer value) {
            addCriterion("Is_Invcd <=", value, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdIn(List<Integer> values) {
            addCriterion("Is_Invcd in", values, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdNotIn(List<Integer> values) {
            addCriterion("Is_Invcd not in", values, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdBetween(Integer value1, Integer value2) {
            addCriterion("Is_Invcd between", value1, value2, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andIsInvcdNotBetween(Integer value1, Integer value2) {
            addCriterion("Is_Invcd not between", value1, value2, "isInvcd");
            return (Criteria) this;
        }

        public Criteria andBegDateIsNull() {
            addCriterion("Beg_Date is null");
            return (Criteria) this;
        }

        public Criteria andBegDateIsNotNull() {
            addCriterion("Beg_Date is not null");
            return (Criteria) this;
        }

        public Criteria andBegDateEqualTo(Date value) {
            addCriterion("Beg_Date =", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateNotEqualTo(Date value) {
            addCriterion("Beg_Date <>", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateGreaterThan(Date value) {
            addCriterion("Beg_Date >", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Beg_Date >=", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateLessThan(Date value) {
            addCriterion("Beg_Date <", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateLessThanOrEqualTo(Date value) {
            addCriterion("Beg_Date <=", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateIn(List<Date> values) {
            addCriterion("Beg_Date in", values, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateNotIn(List<Date> values) {
            addCriterion("Beg_Date not in", values, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateBetween(Date value1, Date value2) {
            addCriterion("Beg_Date between", value1, value2, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateNotBetween(Date value1, Date value2) {
            addCriterion("Beg_Date not between", value1, value2, "begDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("End_Date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("End_Date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("End_Date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("End_Date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("End_Date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("End_Date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("End_Date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("End_Date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("End_Date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("End_Date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("End_Date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("End_Date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("Create_Date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("Create_Date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("Create_Date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("Create_Date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("Create_Date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Create_Date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("Create_Date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("Create_Date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("Create_Date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("Create_Date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("Create_Date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("Create_Date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNull() {
            addCriterion("Oper_Date is null");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNotNull() {
            addCriterion("Oper_Date is not null");
            return (Criteria) this;
        }

        public Criteria andOperDateEqualTo(Date value) {
            addCriterion("Oper_Date =", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotEqualTo(Date value) {
            addCriterion("Oper_Date <>", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThan(Date value) {
            addCriterion("Oper_Date >", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Oper_Date >=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThan(Date value) {
            addCriterion("Oper_Date <", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThanOrEqualTo(Date value) {
            addCriterion("Oper_Date <=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateIn(List<Date> values) {
            addCriterion("Oper_Date in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotIn(List<Date> values) {
            addCriterion("Oper_Date not in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateBetween(Date value1, Date value2) {
            addCriterion("Oper_Date between", value1, value2, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotBetween(Date value1, Date value2) {
            addCriterion("Oper_Date not between", value1, value2, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("Operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("Operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("Operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("Operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("Operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("Operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("Operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("Operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("Operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("Operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("Operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("Operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("Operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("Operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("Ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("Ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("Ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("Ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("Ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("Ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("Ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("Ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("Ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("Ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("Ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("Ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("Ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("Ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("Ext2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("Ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("Ext2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("Ext2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("Ext2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("Ext2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("Ext2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("Ext2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("Ext2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("Ext2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("Ext2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("Ext2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("Ext2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("Ext2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("Ext3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("Ext3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("Ext3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("Ext3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("Ext3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("Ext3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("Ext3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("Ext3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("Ext3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("Ext3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("Ext3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("Ext3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("Ext3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("Ext3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
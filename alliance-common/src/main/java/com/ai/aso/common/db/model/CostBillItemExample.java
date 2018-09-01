package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class CostBillItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostBillItemExample() {
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

        public Criteria andCostItemIdIsNull() {
            addCriterion("Cost_Item_Id is null");
            return (Criteria) this;
        }

        public Criteria andCostItemIdIsNotNull() {
            addCriterion("Cost_Item_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCostItemIdEqualTo(Long value) {
            addCriterion("Cost_Item_Id =", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdNotEqualTo(Long value) {
            addCriterion("Cost_Item_Id <>", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdGreaterThan(Long value) {
            addCriterion("Cost_Item_Id >", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Cost_Item_Id >=", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdLessThan(Long value) {
            addCriterion("Cost_Item_Id <", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdLessThanOrEqualTo(Long value) {
            addCriterion("Cost_Item_Id <=", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdIn(List<Long> values) {
            addCriterion("Cost_Item_Id in", values, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdNotIn(List<Long> values) {
            addCriterion("Cost_Item_Id not in", values, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdBetween(Long value1, Long value2) {
            addCriterion("Cost_Item_Id between", value1, value2, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdNotBetween(Long value1, Long value2) {
            addCriterion("Cost_Item_Id not between", value1, value2, "costItemId");
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

        public Criteria andBusiModeIsNull() {
            addCriterion("Busi_Mode is null");
            return (Criteria) this;
        }

        public Criteria andBusiModeIsNotNull() {
            addCriterion("Busi_Mode is not null");
            return (Criteria) this;
        }

        public Criteria andBusiModeEqualTo(Integer value) {
            addCriterion("Busi_Mode =", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeNotEqualTo(Integer value) {
            addCriterion("Busi_Mode <>", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeGreaterThan(Integer value) {
            addCriterion("Busi_Mode >", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Busi_Mode >=", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeLessThan(Integer value) {
            addCriterion("Busi_Mode <", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeLessThanOrEqualTo(Integer value) {
            addCriterion("Busi_Mode <=", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeIn(List<Integer> values) {
            addCriterion("Busi_Mode in", values, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeNotIn(List<Integer> values) {
            addCriterion("Busi_Mode not in", values, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeBetween(Integer value1, Integer value2) {
            addCriterion("Busi_Mode between", value1, value2, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeNotBetween(Integer value1, Integer value2) {
            addCriterion("Busi_Mode not between", value1, value2, "busiMode");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("Pay_Type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("Pay_Type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Short value) {
            addCriterion("Pay_Type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Short value) {
            addCriterion("Pay_Type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Short value) {
            addCriterion("Pay_Type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("Pay_Type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Short value) {
            addCriterion("Pay_Type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Short value) {
            addCriterion("Pay_Type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Short> values) {
            addCriterion("Pay_Type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Short> values) {
            addCriterion("Pay_Type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Short value1, Short value2) {
            addCriterion("Pay_Type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Short value1, Short value2) {
            addCriterion("Pay_Type not between", value1, value2, "payType");
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

        public Criteria andIncomeIsNull() {
            addCriterion("Income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("Income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Long value) {
            addCriterion("Income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Long value) {
            addCriterion("Income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Long value) {
            addCriterion("Income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Long value) {
            addCriterion("Income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Long value) {
            addCriterion("Income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Long value) {
            addCriterion("Income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Long> values) {
            addCriterion("Income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Long> values) {
            addCriterion("Income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Long value1, Long value2) {
            addCriterion("Income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Long value1, Long value2) {
            addCriterion("Income not between", value1, value2, "income");
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

        public Criteria andCostRegionIsNull() {
            addCriterion("Cost_Region is null");
            return (Criteria) this;
        }

        public Criteria andCostRegionIsNotNull() {
            addCriterion("Cost_Region is not null");
            return (Criteria) this;
        }

        public Criteria andCostRegionEqualTo(Integer value) {
            addCriterion("Cost_Region =", value, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionNotEqualTo(Integer value) {
            addCriterion("Cost_Region <>", value, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionGreaterThan(Integer value) {
            addCriterion("Cost_Region >", value, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cost_Region >=", value, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionLessThan(Integer value) {
            addCriterion("Cost_Region <", value, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionLessThanOrEqualTo(Integer value) {
            addCriterion("Cost_Region <=", value, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionIn(List<Integer> values) {
            addCriterion("Cost_Region in", values, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionNotIn(List<Integer> values) {
            addCriterion("Cost_Region not in", values, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionBetween(Integer value1, Integer value2) {
            addCriterion("Cost_Region between", value1, value2, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostRegionNotBetween(Integer value1, Integer value2) {
            addCriterion("Cost_Region not between", value1, value2, "costRegion");
            return (Criteria) this;
        }

        public Criteria andCostCenterIsNull() {
            addCriterion("Cost_Center is null");
            return (Criteria) this;
        }

        public Criteria andCostCenterIsNotNull() {
            addCriterion("Cost_Center is not null");
            return (Criteria) this;
        }

        public Criteria andCostCenterEqualTo(String value) {
            addCriterion("Cost_Center =", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotEqualTo(String value) {
            addCriterion("Cost_Center <>", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterGreaterThan(String value) {
            addCriterion("Cost_Center >", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterGreaterThanOrEqualTo(String value) {
            addCriterion("Cost_Center >=", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLessThan(String value) {
            addCriterion("Cost_Center <", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLessThanOrEqualTo(String value) {
            addCriterion("Cost_Center <=", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLike(String value) {
            addCriterion("Cost_Center like", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotLike(String value) {
            addCriterion("Cost_Center not like", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterIn(List<String> values) {
            addCriterion("Cost_Center in", values, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotIn(List<String> values) {
            addCriterion("Cost_Center not in", values, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterBetween(String value1, String value2) {
            addCriterion("Cost_Center between", value1, value2, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotBetween(String value1, String value2) {
            addCriterion("Cost_Center not between", value1, value2, "costCenter");
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

        public Criteria andCostRateIsNull() {
            addCriterion("Cost_Rate is null");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNotNull() {
            addCriterion("Cost_Rate is not null");
            return (Criteria) this;
        }

        public Criteria andCostRateEqualTo(Integer value) {
            addCriterion("Cost_Rate =", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotEqualTo(Integer value) {
            addCriterion("Cost_Rate <>", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThan(Integer value) {
            addCriterion("Cost_Rate >", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cost_Rate >=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThan(Integer value) {
            addCriterion("Cost_Rate <", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThanOrEqualTo(Integer value) {
            addCriterion("Cost_Rate <=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateIn(List<Integer> values) {
            addCriterion("Cost_Rate in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotIn(List<Integer> values) {
            addCriterion("Cost_Rate not in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateBetween(Integer value1, Integer value2) {
            addCriterion("Cost_Rate between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotBetween(Integer value1, Integer value2) {
            addCriterion("Cost_Rate not between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameIsNull() {
            addCriterion("Cost_Region_Name is null");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameIsNotNull() {
            addCriterion("Cost_Region_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameEqualTo(Integer value) {
            addCriterion("Cost_Region_Name =", value, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameNotEqualTo(Integer value) {
            addCriterion("Cost_Region_Name <>", value, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameGreaterThan(Integer value) {
            addCriterion("Cost_Region_Name >", value, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cost_Region_Name >=", value, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameLessThan(Integer value) {
            addCriterion("Cost_Region_Name <", value, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameLessThanOrEqualTo(Integer value) {
            addCriterion("Cost_Region_Name <=", value, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameIn(List<Integer> values) {
            addCriterion("Cost_Region_Name in", values, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameNotIn(List<Integer> values) {
            addCriterion("Cost_Region_Name not in", values, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameBetween(Integer value1, Integer value2) {
            addCriterion("Cost_Region_Name between", value1, value2, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostRegionNameNotBetween(Integer value1, Integer value2) {
            addCriterion("Cost_Region_Name not between", value1, value2, "costRegionName");
            return (Criteria) this;
        }

        public Criteria andCostFeeIsNull() {
            addCriterion("Cost_Fee is null");
            return (Criteria) this;
        }

        public Criteria andCostFeeIsNotNull() {
            addCriterion("Cost_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andCostFeeEqualTo(Long value) {
            addCriterion("Cost_Fee =", value, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeNotEqualTo(Long value) {
            addCriterion("Cost_Fee <>", value, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeGreaterThan(Long value) {
            addCriterion("Cost_Fee >", value, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("Cost_Fee >=", value, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeLessThan(Long value) {
            addCriterion("Cost_Fee <", value, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeLessThanOrEqualTo(Long value) {
            addCriterion("Cost_Fee <=", value, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeIn(List<Long> values) {
            addCriterion("Cost_Fee in", values, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeNotIn(List<Long> values) {
            addCriterion("Cost_Fee not in", values, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeBetween(Long value1, Long value2) {
            addCriterion("Cost_Fee between", value1, value2, "costFee");
            return (Criteria) this;
        }

        public Criteria andCostFeeNotBetween(Long value1, Long value2) {
            addCriterion("Cost_Fee not between", value1, value2, "costFee");
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
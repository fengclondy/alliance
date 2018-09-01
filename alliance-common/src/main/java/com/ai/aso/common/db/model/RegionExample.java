package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class RegionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegionExample() {
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

        public Criteria andPRegionIdIsNull() {
            addCriterion("P_Region_Id is null");
            return (Criteria) this;
        }

        public Criteria andPRegionIdIsNotNull() {
            addCriterion("P_Region_Id is not null");
            return (Criteria) this;
        }

        public Criteria andPRegionIdEqualTo(Integer value) {
            addCriterion("P_Region_Id =", value, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdNotEqualTo(Integer value) {
            addCriterion("P_Region_Id <>", value, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdGreaterThan(Integer value) {
            addCriterion("P_Region_Id >", value, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("P_Region_Id >=", value, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdLessThan(Integer value) {
            addCriterion("P_Region_Id <", value, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdLessThanOrEqualTo(Integer value) {
            addCriterion("P_Region_Id <=", value, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdIn(List<Integer> values) {
            addCriterion("P_Region_Id in", values, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdNotIn(List<Integer> values) {
            addCriterion("P_Region_Id not in", values, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdBetween(Integer value1, Integer value2) {
            addCriterion("P_Region_Id between", value1, value2, "pRegionId");
            return (Criteria) this;
        }

        public Criteria andPRegionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("P_Region_Id not between", value1, value2, "pRegionId");
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

        public Criteria andAbbrNameIsNull() {
            addCriterion("Abbr_Name is null");
            return (Criteria) this;
        }

        public Criteria andAbbrNameIsNotNull() {
            addCriterion("Abbr_Name is not null");
            return (Criteria) this;
        }

        public Criteria andAbbrNameEqualTo(String value) {
            addCriterion("Abbr_Name =", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameNotEqualTo(String value) {
            addCriterion("Abbr_Name <>", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameGreaterThan(String value) {
            addCriterion("Abbr_Name >", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameGreaterThanOrEqualTo(String value) {
            addCriterion("Abbr_Name >=", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameLessThan(String value) {
            addCriterion("Abbr_Name <", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameLessThanOrEqualTo(String value) {
            addCriterion("Abbr_Name <=", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameLike(String value) {
            addCriterion("Abbr_Name like", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameNotLike(String value) {
            addCriterion("Abbr_Name not like", value, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameIn(List<String> values) {
            addCriterion("Abbr_Name in", values, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameNotIn(List<String> values) {
            addCriterion("Abbr_Name not in", values, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameBetween(String value1, String value2) {
            addCriterion("Abbr_Name between", value1, value2, "abbrName");
            return (Criteria) this;
        }

        public Criteria andAbbrNameNotBetween(String value1, String value2) {
            addCriterion("Abbr_Name not between", value1, value2, "abbrName");
            return (Criteria) this;
        }

        public Criteria andRegionLevelIsNull() {
            addCriterion("Region_Level is null");
            return (Criteria) this;
        }

        public Criteria andRegionLevelIsNotNull() {
            addCriterion("Region_Level is not null");
            return (Criteria) this;
        }

        public Criteria andRegionLevelEqualTo(Short value) {
            addCriterion("Region_Level =", value, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelNotEqualTo(Short value) {
            addCriterion("Region_Level <>", value, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelGreaterThan(Short value) {
            addCriterion("Region_Level >", value, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("Region_Level >=", value, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelLessThan(Short value) {
            addCriterion("Region_Level <", value, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelLessThanOrEqualTo(Short value) {
            addCriterion("Region_Level <=", value, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelIn(List<Short> values) {
            addCriterion("Region_Level in", values, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelNotIn(List<Short> values) {
            addCriterion("Region_Level not in", values, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelBetween(Short value1, Short value2) {
            addCriterion("Region_Level between", value1, value2, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andRegionLevelNotBetween(Short value1, Short value2) {
            addCriterion("Region_Level not between", value1, value2, "regionLevel");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNull() {
            addCriterion("Seq_Id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("Seq_Id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(Integer value) {
            addCriterion("Seq_Id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(Integer value) {
            addCriterion("Seq_Id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(Integer value) {
            addCriterion("Seq_Id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Seq_Id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(Integer value) {
            addCriterion("Seq_Id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(Integer value) {
            addCriterion("Seq_Id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<Integer> values) {
            addCriterion("Seq_Id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<Integer> values) {
            addCriterion("Seq_Id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(Integer value1, Integer value2) {
            addCriterion("Seq_Id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Seq_Id not between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`State` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`State` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("`State` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("`State` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("`State` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("`State` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("`State` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("`State` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("`State` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("`State` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("`State` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("`State` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNull() {
            addCriterion("Region_Code is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("Region_Code is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("Region_Code =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("Region_Code <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("Region_Code >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Region_Code >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("Region_Code <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("Region_Code <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("Region_Code like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("Region_Code not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("Region_Code in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("Region_Code not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("Region_Code between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("Region_Code not between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeIsNull() {
            addCriterion("Crm_Region_Code is null");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeIsNotNull() {
            addCriterion("Crm_Region_Code is not null");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeEqualTo(String value) {
            addCriterion("Crm_Region_Code =", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeNotEqualTo(String value) {
            addCriterion("Crm_Region_Code <>", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeGreaterThan(String value) {
            addCriterion("Crm_Region_Code >", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Crm_Region_Code >=", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeLessThan(String value) {
            addCriterion("Crm_Region_Code <", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("Crm_Region_Code <=", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeLike(String value) {
            addCriterion("Crm_Region_Code like", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeNotLike(String value) {
            addCriterion("Crm_Region_Code not like", value, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeIn(List<String> values) {
            addCriterion("Crm_Region_Code in", values, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeNotIn(List<String> values) {
            addCriterion("Crm_Region_Code not in", values, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeBetween(String value1, String value2) {
            addCriterion("Crm_Region_Code between", value1, value2, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andCrmRegionCodeNotBetween(String value1, String value2) {
            addCriterion("Crm_Region_Code not between", value1, value2, "crmRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeIsNull() {
            addCriterion("Bill_Region_Code is null");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeIsNotNull() {
            addCriterion("Bill_Region_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeEqualTo(String value) {
            addCriterion("Bill_Region_Code =", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeNotEqualTo(String value) {
            addCriterion("Bill_Region_Code <>", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeGreaterThan(String value) {
            addCriterion("Bill_Region_Code >", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Bill_Region_Code >=", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeLessThan(String value) {
            addCriterion("Bill_Region_Code <", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("Bill_Region_Code <=", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeLike(String value) {
            addCriterion("Bill_Region_Code like", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeNotLike(String value) {
            addCriterion("Bill_Region_Code not like", value, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeIn(List<String> values) {
            addCriterion("Bill_Region_Code in", values, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeNotIn(List<String> values) {
            addCriterion("Bill_Region_Code not in", values, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeBetween(String value1, String value2) {
            addCriterion("Bill_Region_Code between", value1, value2, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andBillRegionCodeNotBetween(String value1, String value2) {
            addCriterion("Bill_Region_Code not between", value1, value2, "billRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeIsNull() {
            addCriterion("Fps_Region_Code is null");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeIsNotNull() {
            addCriterion("Fps_Region_Code is not null");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeEqualTo(String value) {
            addCriterion("Fps_Region_Code =", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeNotEqualTo(String value) {
            addCriterion("Fps_Region_Code <>", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeGreaterThan(String value) {
            addCriterion("Fps_Region_Code >", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Fps_Region_Code >=", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeLessThan(String value) {
            addCriterion("Fps_Region_Code <", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("Fps_Region_Code <=", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeLike(String value) {
            addCriterion("Fps_Region_Code like", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeNotLike(String value) {
            addCriterion("Fps_Region_Code not like", value, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeIn(List<String> values) {
            addCriterion("Fps_Region_Code in", values, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeNotIn(List<String> values) {
            addCriterion("Fps_Region_Code not in", values, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeBetween(String value1, String value2) {
            addCriterion("Fps_Region_Code between", value1, value2, "fpsRegionCode");
            return (Criteria) this;
        }

        public Criteria andFpsRegionCodeNotBetween(String value1, String value2) {
            addCriterion("Fps_Region_Code not between", value1, value2, "fpsRegionCode");
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
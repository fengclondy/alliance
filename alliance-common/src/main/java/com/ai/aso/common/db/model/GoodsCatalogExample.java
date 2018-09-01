package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsCatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsCatalogExample() {
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

        public Criteria andCatalogIdIsNull() {
            addCriterion("Catalog_Id is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIsNotNull() {
            addCriterion("Catalog_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdEqualTo(String value) {
            addCriterion("Catalog_Id =", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotEqualTo(String value) {
            addCriterion("Catalog_Id <>", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThan(String value) {
            addCriterion("Catalog_Id >", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThanOrEqualTo(String value) {
            addCriterion("Catalog_Id >=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThan(String value) {
            addCriterion("Catalog_Id <", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThanOrEqualTo(String value) {
            addCriterion("Catalog_Id <=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLike(String value) {
            addCriterion("Catalog_Id like", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotLike(String value) {
            addCriterion("Catalog_Id not like", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIn(List<String> values) {
            addCriterion("Catalog_Id in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotIn(List<String> values) {
            addCriterion("Catalog_Id not in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdBetween(String value1, String value2) {
            addCriterion("Catalog_Id between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotBetween(String value1, String value2) {
            addCriterion("Catalog_Id not between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdIsNull() {
            addCriterion("P_Catalog_Id is null");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdIsNotNull() {
            addCriterion("P_Catalog_Id is not null");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdEqualTo(String value) {
            addCriterion("P_Catalog_Id =", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdNotEqualTo(String value) {
            addCriterion("P_Catalog_Id <>", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdGreaterThan(String value) {
            addCriterion("P_Catalog_Id >", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdGreaterThanOrEqualTo(String value) {
            addCriterion("P_Catalog_Id >=", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdLessThan(String value) {
            addCriterion("P_Catalog_Id <", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdLessThanOrEqualTo(String value) {
            addCriterion("P_Catalog_Id <=", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdLike(String value) {
            addCriterion("P_Catalog_Id like", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdNotLike(String value) {
            addCriterion("P_Catalog_Id not like", value, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdIn(List<String> values) {
            addCriterion("P_Catalog_Id in", values, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdNotIn(List<String> values) {
            addCriterion("P_Catalog_Id not in", values, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdBetween(String value1, String value2) {
            addCriterion("P_Catalog_Id between", value1, value2, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andPCatalogIdNotBetween(String value1, String value2) {
            addCriterion("P_Catalog_Id not between", value1, value2, "pCatalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNull() {
            addCriterion("`Catalog_Name` is null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNotNull() {
            addCriterion("`Catalog_Name` is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameEqualTo(String value) {
            addCriterion("`Catalog_Name` =", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotEqualTo(String value) {
            addCriterion("`Catalog_Name` <>", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThan(String value) {
            addCriterion("`Catalog_Name` >", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("`Catalog_Name` >=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThan(String value) {
            addCriterion("`Catalog_Name` <", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("`Catalog_Name` <=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLike(String value) {
            addCriterion("`Catalog_Name` like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotLike(String value) {
            addCriterion("`Catalog_Name` not like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIn(List<String> values) {
            addCriterion("`Catalog_Name` in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotIn(List<String> values) {
            addCriterion("`Catalog_Name` not in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameBetween(String value1, String value2) {
            addCriterion("`Catalog_Name` between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotBetween(String value1, String value2) {
            addCriterion("`Catalog_Name` not between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogStateIsNull() {
            addCriterion("Catalog_State is null");
            return (Criteria) this;
        }

        public Criteria andCatalogStateIsNotNull() {
            addCriterion("Catalog_State is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogStateEqualTo(Short value) {
            addCriterion("Catalog_State =", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateNotEqualTo(Short value) {
            addCriterion("Catalog_State <>", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateGreaterThan(Short value) {
            addCriterion("Catalog_State >", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateGreaterThanOrEqualTo(Short value) {
            addCriterion("Catalog_State >=", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateLessThan(Short value) {
            addCriterion("Catalog_State <", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateLessThanOrEqualTo(Short value) {
            addCriterion("Catalog_State <=", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateIn(List<Short> values) {
            addCriterion("Catalog_State in", values, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateNotIn(List<Short> values) {
            addCriterion("Catalog_State not in", values, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateBetween(Short value1, Short value2) {
            addCriterion("Catalog_State between", value1, value2, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateNotBetween(Short value1, Short value2) {
            addCriterion("Catalog_State not between", value1, value2, "catalogState");
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
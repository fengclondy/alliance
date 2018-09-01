package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class ContractOffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractOffExample() {
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

        public Criteria andDataTypeIsNull() {
            addCriterion("Data_Type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("Data_Type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(Integer value) {
            addCriterion("Data_Type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(Integer value) {
            addCriterion("Data_Type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(Integer value) {
            addCriterion("Data_Type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Data_Type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(Integer value) {
            addCriterion("Data_Type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Data_Type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<Integer> values) {
            addCriterion("Data_Type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<Integer> values) {
            addCriterion("Data_Type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(Integer value1, Integer value2) {
            addCriterion("Data_Type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Data_Type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andOffRateIsNull() {
            addCriterion("Off_Rate is null");
            return (Criteria) this;
        }

        public Criteria andOffRateIsNotNull() {
            addCriterion("Off_Rate is not null");
            return (Criteria) this;
        }

        public Criteria andOffRateEqualTo(Integer value) {
            addCriterion("Off_Rate =", value, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateNotEqualTo(Integer value) {
            addCriterion("Off_Rate <>", value, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateGreaterThan(Integer value) {
            addCriterion("Off_Rate >", value, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Off_Rate >=", value, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateLessThan(Integer value) {
            addCriterion("Off_Rate <", value, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateLessThanOrEqualTo(Integer value) {
            addCriterion("Off_Rate <=", value, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateIn(List<Integer> values) {
            addCriterion("Off_Rate in", values, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateNotIn(List<Integer> values) {
            addCriterion("Off_Rate not in", values, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateBetween(Integer value1, Integer value2) {
            addCriterion("Off_Rate between", value1, value2, "offRate");
            return (Criteria) this;
        }

        public Criteria andOffRateNotBetween(Integer value1, Integer value2) {
            addCriterion("Off_Rate not between", value1, value2, "offRate");
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
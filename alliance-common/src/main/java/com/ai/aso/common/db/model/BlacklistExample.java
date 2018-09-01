package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class BlacklistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlacklistExample() {
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

        public Criteria andBlacklistKeyIsNull() {
            addCriterion("Blacklist_Key is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyIsNotNull() {
            addCriterion("Blacklist_Key is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyEqualTo(String value) {
            addCriterion("Blacklist_Key =", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyNotEqualTo(String value) {
            addCriterion("Blacklist_Key <>", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyGreaterThan(String value) {
            addCriterion("Blacklist_Key >", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyGreaterThanOrEqualTo(String value) {
            addCriterion("Blacklist_Key >=", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyLessThan(String value) {
            addCriterion("Blacklist_Key <", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyLessThanOrEqualTo(String value) {
            addCriterion("Blacklist_Key <=", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyLike(String value) {
            addCriterion("Blacklist_Key like", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyNotLike(String value) {
            addCriterion("Blacklist_Key not like", value, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyIn(List<String> values) {
            addCriterion("Blacklist_Key in", values, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyNotIn(List<String> values) {
            addCriterion("Blacklist_Key not in", values, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyBetween(String value1, String value2) {
            addCriterion("Blacklist_Key between", value1, value2, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistKeyNotBetween(String value1, String value2) {
            addCriterion("Blacklist_Key not between", value1, value2, "blacklistKey");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameIsNull() {
            addCriterion("Blacklist_Name is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameIsNotNull() {
            addCriterion("Blacklist_Name is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameEqualTo(String value) {
            addCriterion("Blacklist_Name =", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameNotEqualTo(String value) {
            addCriterion("Blacklist_Name <>", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameGreaterThan(String value) {
            addCriterion("Blacklist_Name >", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameGreaterThanOrEqualTo(String value) {
            addCriterion("Blacklist_Name >=", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameLessThan(String value) {
            addCriterion("Blacklist_Name <", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameLessThanOrEqualTo(String value) {
            addCriterion("Blacklist_Name <=", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameLike(String value) {
            addCriterion("Blacklist_Name like", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameNotLike(String value) {
            addCriterion("Blacklist_Name not like", value, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameIn(List<String> values) {
            addCriterion("Blacklist_Name in", values, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameNotIn(List<String> values) {
            addCriterion("Blacklist_Name not in", values, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameBetween(String value1, String value2) {
            addCriterion("Blacklist_Name between", value1, value2, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistNameNotBetween(String value1, String value2) {
            addCriterion("Blacklist_Name not between", value1, value2, "blacklistName");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueIsNull() {
            addCriterion("Blacklist_Value is null");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueIsNotNull() {
            addCriterion("Blacklist_Value is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueEqualTo(String value) {
            addCriterion("Blacklist_Value =", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueNotEqualTo(String value) {
            addCriterion("Blacklist_Value <>", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueGreaterThan(String value) {
            addCriterion("Blacklist_Value >", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueGreaterThanOrEqualTo(String value) {
            addCriterion("Blacklist_Value >=", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueLessThan(String value) {
            addCriterion("Blacklist_Value <", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueLessThanOrEqualTo(String value) {
            addCriterion("Blacklist_Value <=", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueLike(String value) {
            addCriterion("Blacklist_Value like", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueNotLike(String value) {
            addCriterion("Blacklist_Value not like", value, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueIn(List<String> values) {
            addCriterion("Blacklist_Value in", values, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueNotIn(List<String> values) {
            addCriterion("Blacklist_Value not in", values, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueBetween(String value1, String value2) {
            addCriterion("Blacklist_Value between", value1, value2, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andBlacklistValueNotBetween(String value1, String value2) {
            addCriterion("Blacklist_Value not between", value1, value2, "blacklistValue");
            return (Criteria) this;
        }

        public Criteria andVerIsNull() {
            addCriterion("Ver_ is null");
            return (Criteria) this;
        }

        public Criteria andVerIsNotNull() {
            addCriterion("Ver_ is not null");
            return (Criteria) this;
        }

        public Criteria andVerEqualTo(Integer value) {
            addCriterion("Ver_ =", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerNotEqualTo(Integer value) {
            addCriterion("Ver_ <>", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerGreaterThan(Integer value) {
            addCriterion("Ver_ >", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ver_ >=", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerLessThan(Integer value) {
            addCriterion("Ver_ <", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerLessThanOrEqualTo(Integer value) {
            addCriterion("Ver_ <=", value, "ver");
            return (Criteria) this;
        }

        public Criteria andVerIn(List<Integer> values) {
            addCriterion("Ver_ in", values, "ver");
            return (Criteria) this;
        }

        public Criteria andVerNotIn(List<Integer> values) {
            addCriterion("Ver_ not in", values, "ver");
            return (Criteria) this;
        }

        public Criteria andVerBetween(Integer value1, Integer value2) {
            addCriterion("Ver_ between", value1, value2, "ver");
            return (Criteria) this;
        }

        public Criteria andVerNotBetween(Integer value1, Integer value2) {
            addCriterion("Ver_ not between", value1, value2, "ver");
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
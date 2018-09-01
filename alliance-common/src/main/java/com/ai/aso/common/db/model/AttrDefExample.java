package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class AttrDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttrDefExample() {
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

        public Criteria andAttrIdIsNull() {
            addCriterion("Attr_Id is null");
            return (Criteria) this;
        }

        public Criteria andAttrIdIsNotNull() {
            addCriterion("Attr_Id is not null");
            return (Criteria) this;
        }

        public Criteria andAttrIdEqualTo(Integer value) {
            addCriterion("Attr_Id =", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotEqualTo(Integer value) {
            addCriterion("Attr_Id <>", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThan(Integer value) {
            addCriterion("Attr_Id >", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Attr_Id >=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThan(Integer value) {
            addCriterion("Attr_Id <", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThanOrEqualTo(Integer value) {
            addCriterion("Attr_Id <=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdIn(List<Integer> values) {
            addCriterion("Attr_Id in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotIn(List<Integer> values) {
            addCriterion("Attr_Id not in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdBetween(Integer value1, Integer value2) {
            addCriterion("Attr_Id between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Attr_Id not between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeIsNull() {
            addCriterion("Attr_Pkg_Code is null");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeIsNotNull() {
            addCriterion("Attr_Pkg_Code is not null");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeEqualTo(String value) {
            addCriterion("Attr_Pkg_Code =", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeNotEqualTo(String value) {
            addCriterion("Attr_Pkg_Code <>", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeGreaterThan(String value) {
            addCriterion("Attr_Pkg_Code >", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Attr_Pkg_Code >=", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeLessThan(String value) {
            addCriterion("Attr_Pkg_Code <", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeLessThanOrEqualTo(String value) {
            addCriterion("Attr_Pkg_Code <=", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeLike(String value) {
            addCriterion("Attr_Pkg_Code like", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeNotLike(String value) {
            addCriterion("Attr_Pkg_Code not like", value, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeIn(List<String> values) {
            addCriterion("Attr_Pkg_Code in", values, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeNotIn(List<String> values) {
            addCriterion("Attr_Pkg_Code not in", values, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeBetween(String value1, String value2) {
            addCriterion("Attr_Pkg_Code between", value1, value2, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrPkgCodeNotBetween(String value1, String value2) {
            addCriterion("Attr_Pkg_Code not between", value1, value2, "attrPkgCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeIsNull() {
            addCriterion("Attr_Code is null");
            return (Criteria) this;
        }

        public Criteria andAttrCodeIsNotNull() {
            addCriterion("Attr_Code is not null");
            return (Criteria) this;
        }

        public Criteria andAttrCodeEqualTo(String value) {
            addCriterion("Attr_Code =", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeNotEqualTo(String value) {
            addCriterion("Attr_Code <>", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeGreaterThan(String value) {
            addCriterion("Attr_Code >", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Attr_Code >=", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeLessThan(String value) {
            addCriterion("Attr_Code <", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeLessThanOrEqualTo(String value) {
            addCriterion("Attr_Code <=", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeLike(String value) {
            addCriterion("Attr_Code like", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeNotLike(String value) {
            addCriterion("Attr_Code not like", value, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeIn(List<String> values) {
            addCriterion("Attr_Code in", values, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeNotIn(List<String> values) {
            addCriterion("Attr_Code not in", values, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeBetween(String value1, String value2) {
            addCriterion("Attr_Code between", value1, value2, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrCodeNotBetween(String value1, String value2) {
            addCriterion("Attr_Code not between", value1, value2, "attrCode");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNull() {
            addCriterion("Attr_Name is null");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNotNull() {
            addCriterion("Attr_Name is not null");
            return (Criteria) this;
        }

        public Criteria andAttrNameEqualTo(String value) {
            addCriterion("Attr_Name =", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotEqualTo(String value) {
            addCriterion("Attr_Name <>", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThan(String value) {
            addCriterion("Attr_Name >", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("Attr_Name >=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThan(String value) {
            addCriterion("Attr_Name <", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThanOrEqualTo(String value) {
            addCriterion("Attr_Name <=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLike(String value) {
            addCriterion("Attr_Name like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotLike(String value) {
            addCriterion("Attr_Name not like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameIn(List<String> values) {
            addCriterion("Attr_Name in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotIn(List<String> values) {
            addCriterion("Attr_Name not in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameBetween(String value1, String value2) {
            addCriterion("Attr_Name between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotBetween(String value1, String value2) {
            addCriterion("Attr_Name not between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrDescIsNull() {
            addCriterion("Attr_Desc is null");
            return (Criteria) this;
        }

        public Criteria andAttrDescIsNotNull() {
            addCriterion("Attr_Desc is not null");
            return (Criteria) this;
        }

        public Criteria andAttrDescEqualTo(String value) {
            addCriterion("Attr_Desc =", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotEqualTo(String value) {
            addCriterion("Attr_Desc <>", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescGreaterThan(String value) {
            addCriterion("Attr_Desc >", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescGreaterThanOrEqualTo(String value) {
            addCriterion("Attr_Desc >=", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescLessThan(String value) {
            addCriterion("Attr_Desc <", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescLessThanOrEqualTo(String value) {
            addCriterion("Attr_Desc <=", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescLike(String value) {
            addCriterion("Attr_Desc like", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotLike(String value) {
            addCriterion("Attr_Desc not like", value, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescIn(List<String> values) {
            addCriterion("Attr_Desc in", values, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotIn(List<String> values) {
            addCriterion("Attr_Desc not in", values, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescBetween(String value1, String value2) {
            addCriterion("Attr_Desc between", value1, value2, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrDescNotBetween(String value1, String value2) {
            addCriterion("Attr_Desc not between", value1, value2, "attrDesc");
            return (Criteria) this;
        }

        public Criteria andAttrSeqIsNull() {
            addCriterion("Attr_Seq is null");
            return (Criteria) this;
        }

        public Criteria andAttrSeqIsNotNull() {
            addCriterion("Attr_Seq is not null");
            return (Criteria) this;
        }

        public Criteria andAttrSeqEqualTo(Short value) {
            addCriterion("Attr_Seq =", value, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqNotEqualTo(Short value) {
            addCriterion("Attr_Seq <>", value, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqGreaterThan(Short value) {
            addCriterion("Attr_Seq >", value, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqGreaterThanOrEqualTo(Short value) {
            addCriterion("Attr_Seq >=", value, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqLessThan(Short value) {
            addCriterion("Attr_Seq <", value, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqLessThanOrEqualTo(Short value) {
            addCriterion("Attr_Seq <=", value, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqIn(List<Short> values) {
            addCriterion("Attr_Seq in", values, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqNotIn(List<Short> values) {
            addCriterion("Attr_Seq not in", values, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqBetween(Short value1, Short value2) {
            addCriterion("Attr_Seq between", value1, value2, "attrSeq");
            return (Criteria) this;
        }

        public Criteria andAttrSeqNotBetween(Short value1, Short value2) {
            addCriterion("Attr_Seq not between", value1, value2, "attrSeq");
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
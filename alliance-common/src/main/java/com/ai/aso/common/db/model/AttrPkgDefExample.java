package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class AttrPkgDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttrPkgDefExample() {
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

        public Criteria andAttrPkgNameIsNull() {
            addCriterion("Attr_Pkg_Name is null");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameIsNotNull() {
            addCriterion("Attr_Pkg_Name is not null");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameEqualTo(String value) {
            addCriterion("Attr_Pkg_Name =", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameNotEqualTo(String value) {
            addCriterion("Attr_Pkg_Name <>", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameGreaterThan(String value) {
            addCriterion("Attr_Pkg_Name >", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameGreaterThanOrEqualTo(String value) {
            addCriterion("Attr_Pkg_Name >=", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameLessThan(String value) {
            addCriterion("Attr_Pkg_Name <", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameLessThanOrEqualTo(String value) {
            addCriterion("Attr_Pkg_Name <=", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameLike(String value) {
            addCriterion("Attr_Pkg_Name like", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameNotLike(String value) {
            addCriterion("Attr_Pkg_Name not like", value, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameIn(List<String> values) {
            addCriterion("Attr_Pkg_Name in", values, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameNotIn(List<String> values) {
            addCriterion("Attr_Pkg_Name not in", values, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameBetween(String value1, String value2) {
            addCriterion("Attr_Pkg_Name between", value1, value2, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andAttrPkgNameNotBetween(String value1, String value2) {
            addCriterion("Attr_Pkg_Name not between", value1, value2, "attrPkgName");
            return (Criteria) this;
        }

        public Criteria andIsReloadIsNull() {
            addCriterion("Is_Reload is null");
            return (Criteria) this;
        }

        public Criteria andIsReloadIsNotNull() {
            addCriterion("Is_Reload is not null");
            return (Criteria) this;
        }

        public Criteria andIsReloadEqualTo(Short value) {
            addCriterion("Is_Reload =", value, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadNotEqualTo(Short value) {
            addCriterion("Is_Reload <>", value, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadGreaterThan(Short value) {
            addCriterion("Is_Reload >", value, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadGreaterThanOrEqualTo(Short value) {
            addCriterion("Is_Reload >=", value, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadLessThan(Short value) {
            addCriterion("Is_Reload <", value, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadLessThanOrEqualTo(Short value) {
            addCriterion("Is_Reload <=", value, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadIn(List<Short> values) {
            addCriterion("Is_Reload in", values, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadNotIn(List<Short> values) {
            addCriterion("Is_Reload not in", values, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadBetween(Short value1, Short value2) {
            addCriterion("Is_Reload between", value1, value2, "isReload");
            return (Criteria) this;
        }

        public Criteria andIsReloadNotBetween(Short value1, Short value2) {
            addCriterion("Is_Reload not between", value1, value2, "isReload");
            return (Criteria) this;
        }

        public Criteria andReloadClassIsNull() {
            addCriterion("Reload_Class is null");
            return (Criteria) this;
        }

        public Criteria andReloadClassIsNotNull() {
            addCriterion("Reload_Class is not null");
            return (Criteria) this;
        }

        public Criteria andReloadClassEqualTo(String value) {
            addCriterion("Reload_Class =", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassNotEqualTo(String value) {
            addCriterion("Reload_Class <>", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassGreaterThan(String value) {
            addCriterion("Reload_Class >", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassGreaterThanOrEqualTo(String value) {
            addCriterion("Reload_Class >=", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassLessThan(String value) {
            addCriterion("Reload_Class <", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassLessThanOrEqualTo(String value) {
            addCriterion("Reload_Class <=", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassLike(String value) {
            addCriterion("Reload_Class like", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassNotLike(String value) {
            addCriterion("Reload_Class not like", value, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassIn(List<String> values) {
            addCriterion("Reload_Class in", values, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassNotIn(List<String> values) {
            addCriterion("Reload_Class not in", values, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassBetween(String value1, String value2) {
            addCriterion("Reload_Class between", value1, value2, "reloadClass");
            return (Criteria) this;
        }

        public Criteria andReloadClassNotBetween(String value1, String value2) {
            addCriterion("Reload_Class not between", value1, value2, "reloadClass");
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
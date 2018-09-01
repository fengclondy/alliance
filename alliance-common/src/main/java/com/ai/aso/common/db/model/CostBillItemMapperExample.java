package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class CostBillItemMapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostBillItemMapperExample() {
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

        public Criteria andBillItemIdIsNull() {
            addCriterion("Bill_Item_Id is null");
            return (Criteria) this;
        }

        public Criteria andBillItemIdIsNotNull() {
            addCriterion("Bill_Item_Id is not null");
            return (Criteria) this;
        }

        public Criteria andBillItemIdEqualTo(String value) {
            addCriterion("Bill_Item_Id =", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdNotEqualTo(String value) {
            addCriterion("Bill_Item_Id <>", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdGreaterThan(String value) {
            addCriterion("Bill_Item_Id >", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("Bill_Item_Id >=", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdLessThan(String value) {
            addCriterion("Bill_Item_Id <", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdLessThanOrEqualTo(String value) {
            addCriterion("Bill_Item_Id <=", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdLike(String value) {
            addCriterion("Bill_Item_Id like", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdNotLike(String value) {
            addCriterion("Bill_Item_Id not like", value, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdIn(List<String> values) {
            addCriterion("Bill_Item_Id in", values, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdNotIn(List<String> values) {
            addCriterion("Bill_Item_Id not in", values, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdBetween(String value1, String value2) {
            addCriterion("Bill_Item_Id between", value1, value2, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemIdNotBetween(String value1, String value2) {
            addCriterion("Bill_Item_Id not between", value1, value2, "billItemId");
            return (Criteria) this;
        }

        public Criteria andBillItemDescIsNull() {
            addCriterion("Bill_Item_Desc is null");
            return (Criteria) this;
        }

        public Criteria andBillItemDescIsNotNull() {
            addCriterion("Bill_Item_Desc is not null");
            return (Criteria) this;
        }

        public Criteria andBillItemDescEqualTo(String value) {
            addCriterion("Bill_Item_Desc =", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescNotEqualTo(String value) {
            addCriterion("Bill_Item_Desc <>", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescGreaterThan(String value) {
            addCriterion("Bill_Item_Desc >", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescGreaterThanOrEqualTo(String value) {
            addCriterion("Bill_Item_Desc >=", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescLessThan(String value) {
            addCriterion("Bill_Item_Desc <", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescLessThanOrEqualTo(String value) {
            addCriterion("Bill_Item_Desc <=", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescLike(String value) {
            addCriterion("Bill_Item_Desc like", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescNotLike(String value) {
            addCriterion("Bill_Item_Desc not like", value, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescIn(List<String> values) {
            addCriterion("Bill_Item_Desc in", values, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescNotIn(List<String> values) {
            addCriterion("Bill_Item_Desc not in", values, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescBetween(String value1, String value2) {
            addCriterion("Bill_Item_Desc between", value1, value2, "billItemDesc");
            return (Criteria) this;
        }

        public Criteria andBillItemDescNotBetween(String value1, String value2) {
            addCriterion("Bill_Item_Desc not between", value1, value2, "billItemDesc");
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
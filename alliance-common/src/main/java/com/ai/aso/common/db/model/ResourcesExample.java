package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourcesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourcesExample() {
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

        public Criteria andSourceIdIsNull() {
            addCriterion("Source_Id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("Source_Id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("Source_Id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("Source_Id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("Source_Id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Source_Id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("Source_Id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("Source_Id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("Source_Id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("Source_Id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("Source_Id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Source_Id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("Parent_Id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("Parent_Id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("Parent_Id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("Parent_Id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("Parent_Id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Parent_Id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("Parent_Id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("Parent_Id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("Parent_Id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("Parent_Id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("Parent_Id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Parent_Id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("Menu_Name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("Menu_Name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("Menu_Name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("Menu_Name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("Menu_Name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("Menu_Name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("Menu_Name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("Menu_Name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("Menu_Name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("Menu_Name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("Menu_Name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("Menu_Name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("Menu_Name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("Menu_Name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNull() {
            addCriterion("Menu_Icon is null");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNotNull() {
            addCriterion("Menu_Icon is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIconEqualTo(String value) {
            addCriterion("Menu_Icon =", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotEqualTo(String value) {
            addCriterion("Menu_Icon <>", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThan(String value) {
            addCriterion("Menu_Icon >", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThanOrEqualTo(String value) {
            addCriterion("Menu_Icon >=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThan(String value) {
            addCriterion("Menu_Icon <", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThanOrEqualTo(String value) {
            addCriterion("Menu_Icon <=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLike(String value) {
            addCriterion("Menu_Icon like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotLike(String value) {
            addCriterion("Menu_Icon not like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconIn(List<String> values) {
            addCriterion("Menu_Icon in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotIn(List<String> values) {
            addCriterion("Menu_Icon not in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconBetween(String value1, String value2) {
            addCriterion("Menu_Icon between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotBetween(String value1, String value2) {
            addCriterion("Menu_Icon not between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andSourNameIsNull() {
            addCriterion("Sour_Name is null");
            return (Criteria) this;
        }

        public Criteria andSourNameIsNotNull() {
            addCriterion("Sour_Name is not null");
            return (Criteria) this;
        }

        public Criteria andSourNameEqualTo(String value) {
            addCriterion("Sour_Name =", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameNotEqualTo(String value) {
            addCriterion("Sour_Name <>", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameGreaterThan(String value) {
            addCriterion("Sour_Name >", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameGreaterThanOrEqualTo(String value) {
            addCriterion("Sour_Name >=", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameLessThan(String value) {
            addCriterion("Sour_Name <", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameLessThanOrEqualTo(String value) {
            addCriterion("Sour_Name <=", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameLike(String value) {
            addCriterion("Sour_Name like", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameNotLike(String value) {
            addCriterion("Sour_Name not like", value, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameIn(List<String> values) {
            addCriterion("Sour_Name in", values, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameNotIn(List<String> values) {
            addCriterion("Sour_Name not in", values, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameBetween(String value1, String value2) {
            addCriterion("Sour_Name between", value1, value2, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourNameNotBetween(String value1, String value2) {
            addCriterion("Sour_Name not between", value1, value2, "sourName");
            return (Criteria) this;
        }

        public Criteria andSourDescIsNull() {
            addCriterion("Sour_Desc is null");
            return (Criteria) this;
        }

        public Criteria andSourDescIsNotNull() {
            addCriterion("Sour_Desc is not null");
            return (Criteria) this;
        }

        public Criteria andSourDescEqualTo(String value) {
            addCriterion("Sour_Desc =", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescNotEqualTo(String value) {
            addCriterion("Sour_Desc <>", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescGreaterThan(String value) {
            addCriterion("Sour_Desc >", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescGreaterThanOrEqualTo(String value) {
            addCriterion("Sour_Desc >=", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescLessThan(String value) {
            addCriterion("Sour_Desc <", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescLessThanOrEqualTo(String value) {
            addCriterion("Sour_Desc <=", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescLike(String value) {
            addCriterion("Sour_Desc like", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescNotLike(String value) {
            addCriterion("Sour_Desc not like", value, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescIn(List<String> values) {
            addCriterion("Sour_Desc in", values, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescNotIn(List<String> values) {
            addCriterion("Sour_Desc not in", values, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescBetween(String value1, String value2) {
            addCriterion("Sour_Desc between", value1, value2, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourDescNotBetween(String value1, String value2) {
            addCriterion("Sour_Desc not between", value1, value2, "sourDesc");
            return (Criteria) this;
        }

        public Criteria andSourTypeIsNull() {
            addCriterion("Sour_Type is null");
            return (Criteria) this;
        }

        public Criteria andSourTypeIsNotNull() {
            addCriterion("Sour_Type is not null");
            return (Criteria) this;
        }

        public Criteria andSourTypeEqualTo(Integer value) {
            addCriterion("Sour_Type =", value, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeNotEqualTo(Integer value) {
            addCriterion("Sour_Type <>", value, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeGreaterThan(Integer value) {
            addCriterion("Sour_Type >", value, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Sour_Type >=", value, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeLessThan(Integer value) {
            addCriterion("Sour_Type <", value, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Sour_Type <=", value, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeIn(List<Integer> values) {
            addCriterion("Sour_Type in", values, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeNotIn(List<Integer> values) {
            addCriterion("Sour_Type not in", values, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeBetween(Integer value1, Integer value2) {
            addCriterion("Sour_Type between", value1, value2, "sourType");
            return (Criteria) this;
        }

        public Criteria andSourTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Sour_Type not between", value1, value2, "sourType");
            return (Criteria) this;
        }

        public Criteria andShowSeqIsNull() {
            addCriterion("Show_Seq is null");
            return (Criteria) this;
        }

        public Criteria andShowSeqIsNotNull() {
            addCriterion("Show_Seq is not null");
            return (Criteria) this;
        }

        public Criteria andShowSeqEqualTo(Integer value) {
            addCriterion("Show_Seq =", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotEqualTo(Integer value) {
            addCriterion("Show_Seq <>", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqGreaterThan(Integer value) {
            addCriterion("Show_Seq >", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("Show_Seq >=", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqLessThan(Integer value) {
            addCriterion("Show_Seq <", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqLessThanOrEqualTo(Integer value) {
            addCriterion("Show_Seq <=", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqIn(List<Integer> values) {
            addCriterion("Show_Seq in", values, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotIn(List<Integer> values) {
            addCriterion("Show_Seq not in", values, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqBetween(Integer value1, Integer value2) {
            addCriterion("Show_Seq between", value1, value2, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("Show_Seq not between", value1, value2, "showSeq");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNull() {
            addCriterion("Method_Name is null");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNotNull() {
            addCriterion("Method_Name is not null");
            return (Criteria) this;
        }

        public Criteria andMethodNameEqualTo(String value) {
            addCriterion("Method_Name =", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotEqualTo(String value) {
            addCriterion("Method_Name <>", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThan(String value) {
            addCriterion("Method_Name >", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("Method_Name >=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThan(String value) {
            addCriterion("Method_Name <", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThanOrEqualTo(String value) {
            addCriterion("Method_Name <=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLike(String value) {
            addCriterion("Method_Name like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotLike(String value) {
            addCriterion("Method_Name not like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameIn(List<String> values) {
            addCriterion("Method_Name in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotIn(List<String> values) {
            addCriterion("Method_Name not in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameBetween(String value1, String value2) {
            addCriterion("Method_Name between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotBetween(String value1, String value2) {
            addCriterion("Method_Name not between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andSourUrlIsNull() {
            addCriterion("Sour_Url is null");
            return (Criteria) this;
        }

        public Criteria andSourUrlIsNotNull() {
            addCriterion("Sour_Url is not null");
            return (Criteria) this;
        }

        public Criteria andSourUrlEqualTo(String value) {
            addCriterion("Sour_Url =", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlNotEqualTo(String value) {
            addCriterion("Sour_Url <>", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlGreaterThan(String value) {
            addCriterion("Sour_Url >", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlGreaterThanOrEqualTo(String value) {
            addCriterion("Sour_Url >=", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlLessThan(String value) {
            addCriterion("Sour_Url <", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlLessThanOrEqualTo(String value) {
            addCriterion("Sour_Url <=", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlLike(String value) {
            addCriterion("Sour_Url like", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlNotLike(String value) {
            addCriterion("Sour_Url not like", value, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlIn(List<String> values) {
            addCriterion("Sour_Url in", values, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlNotIn(List<String> values) {
            addCriterion("Sour_Url not in", values, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlBetween(String value1, String value2) {
            addCriterion("Sour_Url between", value1, value2, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSourUrlNotBetween(String value1, String value2) {
            addCriterion("Sour_Url not between", value1, value2, "sourUrl");
            return (Criteria) this;
        }

        public Criteria andSystemCodeIsNull() {
            addCriterion("System_Code is null");
            return (Criteria) this;
        }

        public Criteria andSystemCodeIsNotNull() {
            addCriterion("System_Code is not null");
            return (Criteria) this;
        }

        public Criteria andSystemCodeEqualTo(String value) {
            addCriterion("System_Code =", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotEqualTo(String value) {
            addCriterion("System_Code <>", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeGreaterThan(String value) {
            addCriterion("System_Code >", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("System_Code >=", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeLessThan(String value) {
            addCriterion("System_Code <", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeLessThanOrEqualTo(String value) {
            addCriterion("System_Code <=", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeLike(String value) {
            addCriterion("System_Code like", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotLike(String value) {
            addCriterion("System_Code not like", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeIn(List<String> values) {
            addCriterion("System_Code in", values, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotIn(List<String> values) {
            addCriterion("System_Code not in", values, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeBetween(String value1, String value2) {
            addCriterion("System_Code between", value1, value2, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotBetween(String value1, String value2) {
            addCriterion("System_Code not between", value1, value2, "systemCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNull() {
            addCriterion("Model_Code is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNotNull() {
            addCriterion("Model_Code is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeEqualTo(String value) {
            addCriterion("Model_Code =", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotEqualTo(String value) {
            addCriterion("Model_Code <>", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThan(String value) {
            addCriterion("Model_Code >", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Model_Code >=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThan(String value) {
            addCriterion("Model_Code <", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThanOrEqualTo(String value) {
            addCriterion("Model_Code <=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLike(String value) {
            addCriterion("Model_Code like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotLike(String value) {
            addCriterion("Model_Code not like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIn(List<String> values) {
            addCriterion("Model_Code in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotIn(List<String> values) {
            addCriterion("Model_Code not in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeBetween(String value1, String value2) {
            addCriterion("Model_Code between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotBetween(String value1, String value2) {
            addCriterion("Model_Code not between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andIsAuthenIsNull() {
            addCriterion("Is_Authen is null");
            return (Criteria) this;
        }

        public Criteria andIsAuthenIsNotNull() {
            addCriterion("Is_Authen is not null");
            return (Criteria) this;
        }

        public Criteria andIsAuthenEqualTo(Short value) {
            addCriterion("Is_Authen =", value, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenNotEqualTo(Short value) {
            addCriterion("Is_Authen <>", value, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenGreaterThan(Short value) {
            addCriterion("Is_Authen >", value, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenGreaterThanOrEqualTo(Short value) {
            addCriterion("Is_Authen >=", value, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenLessThan(Short value) {
            addCriterion("Is_Authen <", value, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenLessThanOrEqualTo(Short value) {
            addCriterion("Is_Authen <=", value, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenIn(List<Short> values) {
            addCriterion("Is_Authen in", values, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenNotIn(List<Short> values) {
            addCriterion("Is_Authen not in", values, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenBetween(Short value1, Short value2) {
            addCriterion("Is_Authen between", value1, value2, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andIsAuthenNotBetween(Short value1, Short value2) {
            addCriterion("Is_Authen not between", value1, value2, "isAuthen");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcIsNull() {
            addCriterion("Access_Authc is null");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcIsNotNull() {
            addCriterion("Access_Authc is not null");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcEqualTo(String value) {
            addCriterion("Access_Authc =", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcNotEqualTo(String value) {
            addCriterion("Access_Authc <>", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcGreaterThan(String value) {
            addCriterion("Access_Authc >", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcGreaterThanOrEqualTo(String value) {
            addCriterion("Access_Authc >=", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcLessThan(String value) {
            addCriterion("Access_Authc <", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcLessThanOrEqualTo(String value) {
            addCriterion("Access_Authc <=", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcLike(String value) {
            addCriterion("Access_Authc like", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcNotLike(String value) {
            addCriterion("Access_Authc not like", value, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcIn(List<String> values) {
            addCriterion("Access_Authc in", values, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcNotIn(List<String> values) {
            addCriterion("Access_Authc not in", values, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcBetween(String value1, String value2) {
            addCriterion("Access_Authc between", value1, value2, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessAuthcNotBetween(String value1, String value2) {
            addCriterion("Access_Authc not between", value1, value2, "accessAuthc");
            return (Criteria) this;
        }

        public Criteria andAccessRoleIsNull() {
            addCriterion("Access_Role is null");
            return (Criteria) this;
        }

        public Criteria andAccessRoleIsNotNull() {
            addCriterion("Access_Role is not null");
            return (Criteria) this;
        }

        public Criteria andAccessRoleEqualTo(String value) {
            addCriterion("Access_Role =", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleNotEqualTo(String value) {
            addCriterion("Access_Role <>", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleGreaterThan(String value) {
            addCriterion("Access_Role >", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleGreaterThanOrEqualTo(String value) {
            addCriterion("Access_Role >=", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleLessThan(String value) {
            addCriterion("Access_Role <", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleLessThanOrEqualTo(String value) {
            addCriterion("Access_Role <=", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleLike(String value) {
            addCriterion("Access_Role like", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleNotLike(String value) {
            addCriterion("Access_Role not like", value, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleIn(List<String> values) {
            addCriterion("Access_Role in", values, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleNotIn(List<String> values) {
            addCriterion("Access_Role not in", values, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleBetween(String value1, String value2) {
            addCriterion("Access_Role between", value1, value2, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessRoleNotBetween(String value1, String value2) {
            addCriterion("Access_Role not between", value1, value2, "accessRole");
            return (Criteria) this;
        }

        public Criteria andAccessPermIsNull() {
            addCriterion("Access_Perm is null");
            return (Criteria) this;
        }

        public Criteria andAccessPermIsNotNull() {
            addCriterion("Access_Perm is not null");
            return (Criteria) this;
        }

        public Criteria andAccessPermEqualTo(String value) {
            addCriterion("Access_Perm =", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermNotEqualTo(String value) {
            addCriterion("Access_Perm <>", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermGreaterThan(String value) {
            addCriterion("Access_Perm >", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermGreaterThanOrEqualTo(String value) {
            addCriterion("Access_Perm >=", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermLessThan(String value) {
            addCriterion("Access_Perm <", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermLessThanOrEqualTo(String value) {
            addCriterion("Access_Perm <=", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermLike(String value) {
            addCriterion("Access_Perm like", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermNotLike(String value) {
            addCriterion("Access_Perm not like", value, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermIn(List<String> values) {
            addCriterion("Access_Perm in", values, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermNotIn(List<String> values) {
            addCriterion("Access_Perm not in", values, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermBetween(String value1, String value2) {
            addCriterion("Access_Perm between", value1, value2, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessPermNotBetween(String value1, String value2) {
            addCriterion("Access_Perm not between", value1, value2, "accessPerm");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalIsNull() {
            addCriterion("Access_Interval is null");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalIsNotNull() {
            addCriterion("Access_Interval is not null");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalEqualTo(Integer value) {
            addCriterion("Access_Interval =", value, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalNotEqualTo(Integer value) {
            addCriterion("Access_Interval <>", value, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalGreaterThan(Integer value) {
            addCriterion("Access_Interval >", value, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("Access_Interval >=", value, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalLessThan(Integer value) {
            addCriterion("Access_Interval <", value, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("Access_Interval <=", value, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalIn(List<Integer> values) {
            addCriterion("Access_Interval in", values, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalNotIn(List<Integer> values) {
            addCriterion("Access_Interval not in", values, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalBetween(Integer value1, Integer value2) {
            addCriterion("Access_Interval between", value1, value2, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("Access_Interval not between", value1, value2, "accessInterval");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeIsNull() {
            addCriterion("Access_Freque is null");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeIsNotNull() {
            addCriterion("Access_Freque is not null");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeEqualTo(String value) {
            addCriterion("Access_Freque =", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeNotEqualTo(String value) {
            addCriterion("Access_Freque <>", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeGreaterThan(String value) {
            addCriterion("Access_Freque >", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeGreaterThanOrEqualTo(String value) {
            addCriterion("Access_Freque >=", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeLessThan(String value) {
            addCriterion("Access_Freque <", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeLessThanOrEqualTo(String value) {
            addCriterion("Access_Freque <=", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeLike(String value) {
            addCriterion("Access_Freque like", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeNotLike(String value) {
            addCriterion("Access_Freque not like", value, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeIn(List<String> values) {
            addCriterion("Access_Freque in", values, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeNotIn(List<String> values) {
            addCriterion("Access_Freque not in", values, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeBetween(String value1, String value2) {
            addCriterion("Access_Freque between", value1, value2, "accessFreque");
            return (Criteria) this;
        }

        public Criteria andAccessFrequeNotBetween(String value1, String value2) {
            addCriterion("Access_Freque not between", value1, value2, "accessFreque");
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

        public Criteria andModiDateIsNull() {
            addCriterion("Modi_Date is null");
            return (Criteria) this;
        }

        public Criteria andModiDateIsNotNull() {
            addCriterion("Modi_Date is not null");
            return (Criteria) this;
        }

        public Criteria andModiDateEqualTo(Date value) {
            addCriterion("Modi_Date =", value, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateNotEqualTo(Date value) {
            addCriterion("Modi_Date <>", value, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateGreaterThan(Date value) {
            addCriterion("Modi_Date >", value, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Modi_Date >=", value, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateLessThan(Date value) {
            addCriterion("Modi_Date <", value, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateLessThanOrEqualTo(Date value) {
            addCriterion("Modi_Date <=", value, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateIn(List<Date> values) {
            addCriterion("Modi_Date in", values, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateNotIn(List<Date> values) {
            addCriterion("Modi_Date not in", values, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateBetween(Date value1, Date value2) {
            addCriterion("Modi_Date between", value1, value2, "modiDate");
            return (Criteria) this;
        }

        public Criteria andModiDateNotBetween(Date value1, Date value2) {
            addCriterion("Modi_Date not between", value1, value2, "modiDate");
            return (Criteria) this;
        }

        public Criteria andHostGroupsIsNull() {
            addCriterion("Host_Groups is null");
            return (Criteria) this;
        }

        public Criteria andHostGroupsIsNotNull() {
            addCriterion("Host_Groups is not null");
            return (Criteria) this;
        }

        public Criteria andHostGroupsEqualTo(String value) {
            addCriterion("Host_Groups =", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsNotEqualTo(String value) {
            addCriterion("Host_Groups <>", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsGreaterThan(String value) {
            addCriterion("Host_Groups >", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsGreaterThanOrEqualTo(String value) {
            addCriterion("Host_Groups >=", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsLessThan(String value) {
            addCriterion("Host_Groups <", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsLessThanOrEqualTo(String value) {
            addCriterion("Host_Groups <=", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsLike(String value) {
            addCriterion("Host_Groups like", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsNotLike(String value) {
            addCriterion("Host_Groups not like", value, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsIn(List<String> values) {
            addCriterion("Host_Groups in", values, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsNotIn(List<String> values) {
            addCriterion("Host_Groups not in", values, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsBetween(String value1, String value2) {
            addCriterion("Host_Groups between", value1, value2, "hostGroups");
            return (Criteria) this;
        }

        public Criteria andHostGroupsNotBetween(String value1, String value2) {
            addCriterion("Host_Groups not between", value1, value2, "hostGroups");
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
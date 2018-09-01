package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EventTaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("Task_Id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("Task_Id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("Task_Id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("Task_Id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("Task_Id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Task_Id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("Task_Id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("Task_Id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("Task_Id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("Task_Id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("Task_Id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("Task_Id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIsNull() {
            addCriterion("Task_Group is null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIsNotNull() {
            addCriterion("Task_Group is not null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupEqualTo(String value) {
            addCriterion("Task_Group =", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotEqualTo(String value) {
            addCriterion("Task_Group <>", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupGreaterThan(String value) {
            addCriterion("Task_Group >", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupGreaterThanOrEqualTo(String value) {
            addCriterion("Task_Group >=", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLessThan(String value) {
            addCriterion("Task_Group <", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLessThanOrEqualTo(String value) {
            addCriterion("Task_Group <=", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupLike(String value) {
            addCriterion("Task_Group like", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotLike(String value) {
            addCriterion("Task_Group not like", value, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIn(List<String> values) {
            addCriterion("Task_Group in", values, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotIn(List<String> values) {
            addCriterion("Task_Group not in", values, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupBetween(String value1, String value2) {
            addCriterion("Task_Group between", value1, value2, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskGroupNotBetween(String value1, String value2) {
            addCriterion("Task_Group not between", value1, value2, "taskGroup");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("Task_Name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("Task_Name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("Task_Name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("Task_Name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("Task_Name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("Task_Name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("Task_Name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("Task_Name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("Task_Name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("Task_Name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("Task_Name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("Task_Name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("Task_Name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("Task_Name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNull() {
            addCriterion("Event_Type is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("Event_Type is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(Integer value) {
            addCriterion("Event_Type =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(Integer value) {
            addCriterion("Event_Type <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(Integer value) {
            addCriterion("Event_Type >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Event_Type >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(Integer value) {
            addCriterion("Event_Type <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Event_Type <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(List<Integer> values) {
            addCriterion("Event_Type in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(List<Integer> values) {
            addCriterion("Event_Type not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(Integer value1, Integer value2) {
            addCriterion("Event_Type between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Event_Type not between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("Object_Id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("Object_Id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(String value) {
            addCriterion("Object_Id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(String value) {
            addCriterion("Object_Id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(String value) {
            addCriterion("Object_Id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("Object_Id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(String value) {
            addCriterion("Object_Id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(String value) {
            addCriterion("Object_Id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLike(String value) {
            addCriterion("Object_Id like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotLike(String value) {
            addCriterion("Object_Id not like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<String> values) {
            addCriterion("Object_Id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<String> values) {
            addCriterion("Object_Id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(String value1, String value2) {
            addCriterion("Object_Id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(String value1, String value2) {
            addCriterion("Object_Id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andEventParamsIsNull() {
            addCriterion("Event_Params is null");
            return (Criteria) this;
        }

        public Criteria andEventParamsIsNotNull() {
            addCriterion("Event_Params is not null");
            return (Criteria) this;
        }

        public Criteria andEventParamsEqualTo(String value) {
            addCriterion("Event_Params =", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsNotEqualTo(String value) {
            addCriterion("Event_Params <>", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsGreaterThan(String value) {
            addCriterion("Event_Params >", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsGreaterThanOrEqualTo(String value) {
            addCriterion("Event_Params >=", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsLessThan(String value) {
            addCriterion("Event_Params <", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsLessThanOrEqualTo(String value) {
            addCriterion("Event_Params <=", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsLike(String value) {
            addCriterion("Event_Params like", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsNotLike(String value) {
            addCriterion("Event_Params not like", value, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsIn(List<String> values) {
            addCriterion("Event_Params in", values, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsNotIn(List<String> values) {
            addCriterion("Event_Params not in", values, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsBetween(String value1, String value2) {
            addCriterion("Event_Params between", value1, value2, "eventParams");
            return (Criteria) this;
        }

        public Criteria andEventParamsNotBetween(String value1, String value2) {
            addCriterion("Event_Params not between", value1, value2, "eventParams");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("Remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("Remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("Remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("Remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("Remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("Remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("Remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("Remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("Remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("Remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("Remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("Remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("Remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("Remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCallObjectIsNull() {
            addCriterion("Call_Object is null");
            return (Criteria) this;
        }

        public Criteria andCallObjectIsNotNull() {
            addCriterion("Call_Object is not null");
            return (Criteria) this;
        }

        public Criteria andCallObjectEqualTo(String value) {
            addCriterion("Call_Object =", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectNotEqualTo(String value) {
            addCriterion("Call_Object <>", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectGreaterThan(String value) {
            addCriterion("Call_Object >", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectGreaterThanOrEqualTo(String value) {
            addCriterion("Call_Object >=", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectLessThan(String value) {
            addCriterion("Call_Object <", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectLessThanOrEqualTo(String value) {
            addCriterion("Call_Object <=", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectLike(String value) {
            addCriterion("Call_Object like", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectNotLike(String value) {
            addCriterion("Call_Object not like", value, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectIn(List<String> values) {
            addCriterion("Call_Object in", values, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectNotIn(List<String> values) {
            addCriterion("Call_Object not in", values, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectBetween(String value1, String value2) {
            addCriterion("Call_Object between", value1, value2, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallObjectNotBetween(String value1, String value2) {
            addCriterion("Call_Object not between", value1, value2, "callObject");
            return (Criteria) this;
        }

        public Criteria andCallMethodIsNull() {
            addCriterion("Call_Method is null");
            return (Criteria) this;
        }

        public Criteria andCallMethodIsNotNull() {
            addCriterion("Call_Method is not null");
            return (Criteria) this;
        }

        public Criteria andCallMethodEqualTo(String value) {
            addCriterion("Call_Method =", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodNotEqualTo(String value) {
            addCriterion("Call_Method <>", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodGreaterThan(String value) {
            addCriterion("Call_Method >", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodGreaterThanOrEqualTo(String value) {
            addCriterion("Call_Method >=", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodLessThan(String value) {
            addCriterion("Call_Method <", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodLessThanOrEqualTo(String value) {
            addCriterion("Call_Method <=", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodLike(String value) {
            addCriterion("Call_Method like", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodNotLike(String value) {
            addCriterion("Call_Method not like", value, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodIn(List<String> values) {
            addCriterion("Call_Method in", values, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodNotIn(List<String> values) {
            addCriterion("Call_Method not in", values, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodBetween(String value1, String value2) {
            addCriterion("Call_Method between", value1, value2, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallMethodNotBetween(String value1, String value2) {
            addCriterion("Call_Method not between", value1, value2, "callMethod");
            return (Criteria) this;
        }

        public Criteria andCallParamsIsNull() {
            addCriterion("Call_Params is null");
            return (Criteria) this;
        }

        public Criteria andCallParamsIsNotNull() {
            addCriterion("Call_Params is not null");
            return (Criteria) this;
        }

        public Criteria andCallParamsEqualTo(String value) {
            addCriterion("Call_Params =", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsNotEqualTo(String value) {
            addCriterion("Call_Params <>", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsGreaterThan(String value) {
            addCriterion("Call_Params >", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsGreaterThanOrEqualTo(String value) {
            addCriterion("Call_Params >=", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsLessThan(String value) {
            addCriterion("Call_Params <", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsLessThanOrEqualTo(String value) {
            addCriterion("Call_Params <=", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsLike(String value) {
            addCriterion("Call_Params like", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsNotLike(String value) {
            addCriterion("Call_Params not like", value, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsIn(List<String> values) {
            addCriterion("Call_Params in", values, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsNotIn(List<String> values) {
            addCriterion("Call_Params not in", values, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsBetween(String value1, String value2) {
            addCriterion("Call_Params between", value1, value2, "callParams");
            return (Criteria) this;
        }

        public Criteria andCallParamsNotBetween(String value1, String value2) {
            addCriterion("Call_Params not between", value1, value2, "callParams");
            return (Criteria) this;
        }

        public Criteria andReCodeIsNull() {
            addCriterion("Re_Code is null");
            return (Criteria) this;
        }

        public Criteria andReCodeIsNotNull() {
            addCriterion("Re_Code is not null");
            return (Criteria) this;
        }

        public Criteria andReCodeEqualTo(String value) {
            addCriterion("Re_Code =", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeNotEqualTo(String value) {
            addCriterion("Re_Code <>", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeGreaterThan(String value) {
            addCriterion("Re_Code >", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Re_Code >=", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeLessThan(String value) {
            addCriterion("Re_Code <", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeLessThanOrEqualTo(String value) {
            addCriterion("Re_Code <=", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeLike(String value) {
            addCriterion("Re_Code like", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeNotLike(String value) {
            addCriterion("Re_Code not like", value, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeIn(List<String> values) {
            addCriterion("Re_Code in", values, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeNotIn(List<String> values) {
            addCriterion("Re_Code not in", values, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeBetween(String value1, String value2) {
            addCriterion("Re_Code between", value1, value2, "reCode");
            return (Criteria) this;
        }

        public Criteria andReCodeNotBetween(String value1, String value2) {
            addCriterion("Re_Code not between", value1, value2, "reCode");
            return (Criteria) this;
        }

        public Criteria andReMesgIsNull() {
            addCriterion("Re_Mesg is null");
            return (Criteria) this;
        }

        public Criteria andReMesgIsNotNull() {
            addCriterion("Re_Mesg is not null");
            return (Criteria) this;
        }

        public Criteria andReMesgEqualTo(String value) {
            addCriterion("Re_Mesg =", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgNotEqualTo(String value) {
            addCriterion("Re_Mesg <>", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgGreaterThan(String value) {
            addCriterion("Re_Mesg >", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgGreaterThanOrEqualTo(String value) {
            addCriterion("Re_Mesg >=", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgLessThan(String value) {
            addCriterion("Re_Mesg <", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgLessThanOrEqualTo(String value) {
            addCriterion("Re_Mesg <=", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgLike(String value) {
            addCriterion("Re_Mesg like", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgNotLike(String value) {
            addCriterion("Re_Mesg not like", value, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgIn(List<String> values) {
            addCriterion("Re_Mesg in", values, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgNotIn(List<String> values) {
            addCriterion("Re_Mesg not in", values, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgBetween(String value1, String value2) {
            addCriterion("Re_Mesg between", value1, value2, "reMesg");
            return (Criteria) this;
        }

        public Criteria andReMesgNotBetween(String value1, String value2) {
            addCriterion("Re_Mesg not between", value1, value2, "reMesg");
            return (Criteria) this;
        }

        public Criteria andRedoMaxIsNull() {
            addCriterion("Redo_Max is null");
            return (Criteria) this;
        }

        public Criteria andRedoMaxIsNotNull() {
            addCriterion("Redo_Max is not null");
            return (Criteria) this;
        }

        public Criteria andRedoMaxEqualTo(Integer value) {
            addCriterion("Redo_Max =", value, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxNotEqualTo(Integer value) {
            addCriterion("Redo_Max <>", value, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxGreaterThan(Integer value) {
            addCriterion("Redo_Max >", value, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("Redo_Max >=", value, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxLessThan(Integer value) {
            addCriterion("Redo_Max <", value, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxLessThanOrEqualTo(Integer value) {
            addCriterion("Redo_Max <=", value, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxIn(List<Integer> values) {
            addCriterion("Redo_Max in", values, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxNotIn(List<Integer> values) {
            addCriterion("Redo_Max not in", values, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Max between", value1, value2, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Max not between", value1, value2, "redoMax");
            return (Criteria) this;
        }

        public Criteria andRedoCountIsNull() {
            addCriterion("Redo_Count is null");
            return (Criteria) this;
        }

        public Criteria andRedoCountIsNotNull() {
            addCriterion("Redo_Count is not null");
            return (Criteria) this;
        }

        public Criteria andRedoCountEqualTo(Integer value) {
            addCriterion("Redo_Count =", value, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountNotEqualTo(Integer value) {
            addCriterion("Redo_Count <>", value, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountGreaterThan(Integer value) {
            addCriterion("Redo_Count >", value, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Redo_Count >=", value, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountLessThan(Integer value) {
            addCriterion("Redo_Count <", value, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountLessThanOrEqualTo(Integer value) {
            addCriterion("Redo_Count <=", value, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountIn(List<Integer> values) {
            addCriterion("Redo_Count in", values, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountNotIn(List<Integer> values) {
            addCriterion("Redo_Count not in", values, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Count between", value1, value2, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Count not between", value1, value2, "redoCount");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalIsNull() {
            addCriterion("Redo_Interval is null");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalIsNotNull() {
            addCriterion("Redo_Interval is not null");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalEqualTo(Integer value) {
            addCriterion("Redo_Interval =", value, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalNotEqualTo(Integer value) {
            addCriterion("Redo_Interval <>", value, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalGreaterThan(Integer value) {
            addCriterion("Redo_Interval >", value, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("Redo_Interval >=", value, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalLessThan(Integer value) {
            addCriterion("Redo_Interval <", value, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("Redo_Interval <=", value, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalIn(List<Integer> values) {
            addCriterion("Redo_Interval in", values, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalNotIn(List<Integer> values) {
            addCriterion("Redo_Interval not in", values, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Interval between", value1, value2, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andRedoIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Interval not between", value1, value2, "redoInterval");
            return (Criteria) this;
        }

        public Criteria andCallTimeIsNull() {
            addCriterion("Call_Time is null");
            return (Criteria) this;
        }

        public Criteria andCallTimeIsNotNull() {
            addCriterion("Call_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCallTimeEqualTo(Date value) {
            addCriterion("Call_Time =", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeNotEqualTo(Date value) {
            addCriterion("Call_Time <>", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeGreaterThan(Date value) {
            addCriterion("Call_Time >", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Call_Time >=", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeLessThan(Date value) {
            addCriterion("Call_Time <", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeLessThanOrEqualTo(Date value) {
            addCriterion("Call_Time <=", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeIn(List<Date> values) {
            addCriterion("Call_Time in", values, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeNotIn(List<Date> values) {
            addCriterion("Call_Time not in", values, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeBetween(Date value1, Date value2) {
            addCriterion("Call_Time between", value1, value2, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeNotBetween(Date value1, Date value2) {
            addCriterion("Call_Time not between", value1, value2, "callTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("Create_Time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("Create_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("Create_Time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("Create_Time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("Create_Time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Create_Time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("Create_Time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("Create_Time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("Create_Time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("Create_Time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("Create_Time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("Create_Time not between", value1, value2, "createTime");
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

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`State` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`State` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`State` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`State` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`State` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`State` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`State` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`State` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`State` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`State` not between", value1, value2, "state");
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
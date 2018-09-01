package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExternalExecRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExternalExecRecExample() {
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

        public Criteria andExecIdIsNull() {
            addCriterion("Exec_Id is null");
            return (Criteria) this;
        }

        public Criteria andExecIdIsNotNull() {
            addCriterion("Exec_Id is not null");
            return (Criteria) this;
        }

        public Criteria andExecIdEqualTo(Long value) {
            addCriterion("Exec_Id =", value, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdNotEqualTo(Long value) {
            addCriterion("Exec_Id <>", value, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdGreaterThan(Long value) {
            addCriterion("Exec_Id >", value, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Exec_Id >=", value, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdLessThan(Long value) {
            addCriterion("Exec_Id <", value, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdLessThanOrEqualTo(Long value) {
            addCriterion("Exec_Id <=", value, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdIn(List<Long> values) {
            addCriterion("Exec_Id in", values, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdNotIn(List<Long> values) {
            addCriterion("Exec_Id not in", values, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdBetween(Long value1, Long value2) {
            addCriterion("Exec_Id between", value1, value2, "execId");
            return (Criteria) this;
        }

        public Criteria andExecIdNotBetween(Long value1, Long value2) {
            addCriterion("Exec_Id not between", value1, value2, "execId");
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

        public Criteria andUrlIsNull() {
            addCriterion("Url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("Url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("Url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("Url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("Url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("Url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("Url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("Url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("Url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("Url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("Url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("Url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("Url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("Url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("`Method` is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("`Method` is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("`Method` =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("`Method` <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("`Method` >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("`Method` >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("`Method` <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("`Method` <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("`Method` like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("`Method` not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("`Method` in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("`Method` not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("`Method` between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("`Method` not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("Params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("Params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("Params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("Params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("Params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("Params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("Params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("Params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("Params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("Params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("Params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("Params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("Params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("Params not between", value1, value2, "params");
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

        public Criteria andBegTimeIsNull() {
            addCriterion("Beg_Time is null");
            return (Criteria) this;
        }

        public Criteria andBegTimeIsNotNull() {
            addCriterion("Beg_Time is not null");
            return (Criteria) this;
        }

        public Criteria andBegTimeEqualTo(Date value) {
            addCriterion("Beg_Time =", value, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeNotEqualTo(Date value) {
            addCriterion("Beg_Time <>", value, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeGreaterThan(Date value) {
            addCriterion("Beg_Time >", value, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Beg_Time >=", value, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeLessThan(Date value) {
            addCriterion("Beg_Time <", value, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeLessThanOrEqualTo(Date value) {
            addCriterion("Beg_Time <=", value, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeIn(List<Date> values) {
            addCriterion("Beg_Time in", values, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeNotIn(List<Date> values) {
            addCriterion("Beg_Time not in", values, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeBetween(Date value1, Date value2) {
            addCriterion("Beg_Time between", value1, value2, "begTime");
            return (Criteria) this;
        }

        public Criteria andBegTimeNotBetween(Date value1, Date value2) {
            addCriterion("Beg_Time not between", value1, value2, "begTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("End_Time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("End_Time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("End_Time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("End_Time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("End_Time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("End_Time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("End_Time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("End_Time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("End_Time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("End_Time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("End_Time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("End_Time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNull() {
            addCriterion("Consume is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNotNull() {
            addCriterion("Consume is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeEqualTo(Integer value) {
            addCriterion("Consume =", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotEqualTo(Integer value) {
            addCriterion("Consume <>", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThan(Integer value) {
            addCriterion("Consume >", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Consume >=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThan(Integer value) {
            addCriterion("Consume <", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThanOrEqualTo(Integer value) {
            addCriterion("Consume <=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeIn(List<Integer> values) {
            addCriterion("Consume in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotIn(List<Integer> values) {
            addCriterion("Consume not in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeBetween(Integer value1, Integer value2) {
            addCriterion("Consume between", value1, value2, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotBetween(Integer value1, Integer value2) {
            addCriterion("Consume not between", value1, value2, "consume");
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
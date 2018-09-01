package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CapitalRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CapitalRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("Cust_Id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("Cust_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("Cust_Id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("Cust_Id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("Cust_Id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("Cust_Id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("Cust_Id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("Cust_Id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("Cust_Id like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("Cust_Id not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("Cust_Id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("Cust_Id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("Cust_Id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("Cust_Id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNull() {
            addCriterion("Acct_Id is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNotNull() {
            addCriterion("Acct_Id is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdEqualTo(String value) {
            addCriterion("Acct_Id =", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotEqualTo(String value) {
            addCriterion("Acct_Id <>", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThan(String value) {
            addCriterion("Acct_Id >", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThanOrEqualTo(String value) {
            addCriterion("Acct_Id >=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThan(String value) {
            addCriterion("Acct_Id <", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThanOrEqualTo(String value) {
            addCriterion("Acct_Id <=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLike(String value) {
            addCriterion("Acct_Id like", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotLike(String value) {
            addCriterion("Acct_Id not like", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIn(List<String> values) {
            addCriterion("Acct_Id in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotIn(List<String> values) {
            addCriterion("Acct_Id not in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdBetween(String value1, String value2) {
            addCriterion("Acct_Id between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotBetween(String value1, String value2) {
            addCriterion("Acct_Id not between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNull() {
            addCriterion("Book_Id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("Book_Id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(String value) {
            addCriterion("Book_Id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(String value) {
            addCriterion("Book_Id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(String value) {
            addCriterion("Book_Id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(String value) {
            addCriterion("Book_Id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(String value) {
            addCriterion("Book_Id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(String value) {
            addCriterion("Book_Id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLike(String value) {
            addCriterion("Book_Id like", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotLike(String value) {
            addCriterion("Book_Id not like", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<String> values) {
            addCriterion("Book_Id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<String> values) {
            addCriterion("Book_Id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(String value1, String value2) {
            addCriterion("Book_Id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(String value1, String value2) {
            addCriterion("Book_Id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andOldAmountIsNull() {
            addCriterion("Old_Amount is null");
            return (Criteria) this;
        }

        public Criteria andOldAmountIsNotNull() {
            addCriterion("Old_Amount is not null");
            return (Criteria) this;
        }

        public Criteria andOldAmountEqualTo(Long value) {
            addCriterion("Old_Amount =", value, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountNotEqualTo(Long value) {
            addCriterion("Old_Amount <>", value, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountGreaterThan(Long value) {
            addCriterion("Old_Amount >", value, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("Old_Amount >=", value, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountLessThan(Long value) {
            addCriterion("Old_Amount <", value, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountLessThanOrEqualTo(Long value) {
            addCriterion("Old_Amount <=", value, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountIn(List<Long> values) {
            addCriterion("Old_Amount in", values, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountNotIn(List<Long> values) {
            addCriterion("Old_Amount not in", values, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountBetween(Long value1, Long value2) {
            addCriterion("Old_Amount between", value1, value2, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andOldAmountNotBetween(Long value1, Long value2) {
            addCriterion("Old_Amount not between", value1, value2, "oldAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountIsNull() {
            addCriterion("Cur_Amount is null");
            return (Criteria) this;
        }

        public Criteria andCurAmountIsNotNull() {
            addCriterion("Cur_Amount is not null");
            return (Criteria) this;
        }

        public Criteria andCurAmountEqualTo(Long value) {
            addCriterion("Cur_Amount =", value, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountNotEqualTo(Long value) {
            addCriterion("Cur_Amount <>", value, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountGreaterThan(Long value) {
            addCriterion("Cur_Amount >", value, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("Cur_Amount >=", value, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountLessThan(Long value) {
            addCriterion("Cur_Amount <", value, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountLessThanOrEqualTo(Long value) {
            addCriterion("Cur_Amount <=", value, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountIn(List<Long> values) {
            addCriterion("Cur_Amount in", values, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountNotIn(List<Long> values) {
            addCriterion("Cur_Amount not in", values, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountBetween(Long value1, Long value2) {
            addCriterion("Cur_Amount between", value1, value2, "curAmount");
            return (Criteria) this;
        }

        public Criteria andCurAmountNotBetween(Long value1, Long value2) {
            addCriterion("Cur_Amount not between", value1, value2, "curAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountIsNull() {
            addCriterion("Oper_Amount is null");
            return (Criteria) this;
        }

        public Criteria andOperAmountIsNotNull() {
            addCriterion("Oper_Amount is not null");
            return (Criteria) this;
        }

        public Criteria andOperAmountEqualTo(Long value) {
            addCriterion("Oper_Amount =", value, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountNotEqualTo(Long value) {
            addCriterion("Oper_Amount <>", value, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountGreaterThan(Long value) {
            addCriterion("Oper_Amount >", value, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("Oper_Amount >=", value, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountLessThan(Long value) {
            addCriterion("Oper_Amount <", value, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountLessThanOrEqualTo(Long value) {
            addCriterion("Oper_Amount <=", value, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountIn(List<Long> values) {
            addCriterion("Oper_Amount in", values, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountNotIn(List<Long> values) {
            addCriterion("Oper_Amount not in", values, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountBetween(Long value1, Long value2) {
            addCriterion("Oper_Amount between", value1, value2, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperAmountNotBetween(Long value1, Long value2) {
            addCriterion("Oper_Amount not between", value1, value2, "operAmount");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("Oper_Type is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("Oper_Type is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(Short value) {
            addCriterion("Oper_Type =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(Short value) {
            addCriterion("Oper_Type <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(Short value) {
            addCriterion("Oper_Type >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("Oper_Type >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(Short value) {
            addCriterion("Oper_Type <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(Short value) {
            addCriterion("Oper_Type <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<Short> values) {
            addCriterion("Oper_Type in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<Short> values) {
            addCriterion("Oper_Type not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(Short value1, Short value2) {
            addCriterion("Oper_Type between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(Short value1, Short value2) {
            addCriterion("Oper_Type not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeIsNull() {
            addCriterion("Oper_Sub_Type is null");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeIsNotNull() {
            addCriterion("Oper_Sub_Type is not null");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeEqualTo(Integer value) {
            addCriterion("Oper_Sub_Type =", value, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeNotEqualTo(Integer value) {
            addCriterion("Oper_Sub_Type <>", value, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeGreaterThan(Integer value) {
            addCriterion("Oper_Sub_Type >", value, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Oper_Sub_Type >=", value, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeLessThan(Integer value) {
            addCriterion("Oper_Sub_Type <", value, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Oper_Sub_Type <=", value, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeIn(List<Integer> values) {
            addCriterion("Oper_Sub_Type in", values, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeNotIn(List<Integer> values) {
            addCriterion("Oper_Sub_Type not in", values, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeBetween(Integer value1, Integer value2) {
            addCriterion("Oper_Sub_Type between", value1, value2, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperSubTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Oper_Sub_Type not between", value1, value2, "operSubType");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNull() {
            addCriterion("Oper_Date is null");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNotNull() {
            addCriterion("Oper_Date is not null");
            return (Criteria) this;
        }

        public Criteria andOperDateEqualTo(Date value) {
            addCriterion("Oper_Date =", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotEqualTo(Date value) {
            addCriterion("Oper_Date <>", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThan(Date value) {
            addCriterion("Oper_Date >", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Oper_Date >=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThan(Date value) {
            addCriterion("Oper_Date <", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThanOrEqualTo(Date value) {
            addCriterion("Oper_Date <=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateIn(List<Date> values) {
            addCriterion("Oper_Date in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotIn(List<Date> values) {
            addCriterion("Oper_Date not in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateBetween(Date value1, Date value2) {
            addCriterion("Oper_Date between", value1, value2, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotBetween(Date value1, Date value2) {
            addCriterion("Oper_Date not between", value1, value2, "operDate");
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

        public Criteria andOperCommIsNull() {
            addCriterion("Oper_Comm is null");
            return (Criteria) this;
        }

        public Criteria andOperCommIsNotNull() {
            addCriterion("Oper_Comm is not null");
            return (Criteria) this;
        }

        public Criteria andOperCommEqualTo(String value) {
            addCriterion("Oper_Comm =", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommNotEqualTo(String value) {
            addCriterion("Oper_Comm <>", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommGreaterThan(String value) {
            addCriterion("Oper_Comm >", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommGreaterThanOrEqualTo(String value) {
            addCriterion("Oper_Comm >=", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommLessThan(String value) {
            addCriterion("Oper_Comm <", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommLessThanOrEqualTo(String value) {
            addCriterion("Oper_Comm <=", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommLike(String value) {
            addCriterion("Oper_Comm like", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommNotLike(String value) {
            addCriterion("Oper_Comm not like", value, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommIn(List<String> values) {
            addCriterion("Oper_Comm in", values, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommNotIn(List<String> values) {
            addCriterion("Oper_Comm not in", values, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommBetween(String value1, String value2) {
            addCriterion("Oper_Comm between", value1, value2, "operComm");
            return (Criteria) this;
        }

        public Criteria andOperCommNotBetween(String value1, String value2) {
            addCriterion("Oper_Comm not between", value1, value2, "operComm");
            return (Criteria) this;
        }

        public Criteria andLockValIsNull() {
            addCriterion("Lock_Val is null");
            return (Criteria) this;
        }

        public Criteria andLockValIsNotNull() {
            addCriterion("Lock_Val is not null");
            return (Criteria) this;
        }

        public Criteria andLockValEqualTo(Long value) {
            addCriterion("Lock_Val =", value, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValNotEqualTo(Long value) {
            addCriterion("Lock_Val <>", value, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValGreaterThan(Long value) {
            addCriterion("Lock_Val >", value, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValGreaterThanOrEqualTo(Long value) {
            addCriterion("Lock_Val >=", value, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValLessThan(Long value) {
            addCriterion("Lock_Val <", value, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValLessThanOrEqualTo(Long value) {
            addCriterion("Lock_Val <=", value, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValIn(List<Long> values) {
            addCriterion("Lock_Val in", values, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValNotIn(List<Long> values) {
            addCriterion("Lock_Val not in", values, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValBetween(Long value1, Long value2) {
            addCriterion("Lock_Val between", value1, value2, "lockVal");
            return (Criteria) this;
        }

        public Criteria andLockValNotBetween(Long value1, Long value2) {
            addCriterion("Lock_Val not between", value1, value2, "lockVal");
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
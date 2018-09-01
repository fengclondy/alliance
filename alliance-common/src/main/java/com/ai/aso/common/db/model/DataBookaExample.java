package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBookaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataBookaExample() {
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

        public Criteria andAcctTypeIsNull() {
            addCriterion("Acct_Type is null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNotNull() {
            addCriterion("Acct_Type is not null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeEqualTo(Integer value) {
            addCriterion("Acct_Type =", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotEqualTo(Integer value) {
            addCriterion("Acct_Type <>", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThan(Integer value) {
            addCriterion("Acct_Type >", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Acct_Type >=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThan(Integer value) {
            addCriterion("Acct_Type <", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Acct_Type <=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIn(List<Integer> values) {
            addCriterion("Acct_Type in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotIn(List<Integer> values) {
            addCriterion("Acct_Type not in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeBetween(Integer value1, Integer value2) {
            addCriterion("Acct_Type between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Acct_Type not between", value1, value2, "acctType");
            return (Criteria) this;
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

        public Criteria andBusiTypeIsNull() {
            addCriterion("Busi_Type is null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNotNull() {
            addCriterion("Busi_Type is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeEqualTo(String value) {
            addCriterion("Busi_Type =", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotEqualTo(String value) {
            addCriterion("Busi_Type <>", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThan(String value) {
            addCriterion("Busi_Type >", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Busi_Type >=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThan(String value) {
            addCriterion("Busi_Type <", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThanOrEqualTo(String value) {
            addCriterion("Busi_Type <=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLike(String value) {
            addCriterion("Busi_Type like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotLike(String value) {
            addCriterion("Busi_Type not like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIn(List<String> values) {
            addCriterion("Busi_Type in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotIn(List<String> values) {
            addCriterion("Busi_Type not in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeBetween(String value1, String value2) {
            addCriterion("Busi_Type between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotBetween(String value1, String value2) {
            addCriterion("Busi_Type not between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andEffDateIsNull() {
            addCriterion("Eff_Date is null");
            return (Criteria) this;
        }

        public Criteria andEffDateIsNotNull() {
            addCriterion("Eff_Date is not null");
            return (Criteria) this;
        }

        public Criteria andEffDateEqualTo(Date value) {
            addCriterion("Eff_Date =", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateNotEqualTo(Date value) {
            addCriterion("Eff_Date <>", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateGreaterThan(Date value) {
            addCriterion("Eff_Date >", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Eff_Date >=", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateLessThan(Date value) {
            addCriterion("Eff_Date <", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateLessThanOrEqualTo(Date value) {
            addCriterion("Eff_Date <=", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateIn(List<Date> values) {
            addCriterion("Eff_Date in", values, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateNotIn(List<Date> values) {
            addCriterion("Eff_Date not in", values, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateBetween(Date value1, Date value2) {
            addCriterion("Eff_Date between", value1, value2, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateNotBetween(Date value1, Date value2) {
            addCriterion("Eff_Date not between", value1, value2, "effDate");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNull() {
            addCriterion("Exp_Date is null");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNotNull() {
            addCriterion("Exp_Date is not null");
            return (Criteria) this;
        }

        public Criteria andExpDateEqualTo(Date value) {
            addCriterion("Exp_Date =", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotEqualTo(Date value) {
            addCriterion("Exp_Date <>", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThan(Date value) {
            addCriterion("Exp_Date >", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Exp_Date >=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThan(Date value) {
            addCriterion("Exp_Date <", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThanOrEqualTo(Date value) {
            addCriterion("Exp_Date <=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateIn(List<Date> values) {
            addCriterion("Exp_Date in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotIn(List<Date> values) {
            addCriterion("Exp_Date not in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateBetween(Date value1, Date value2) {
            addCriterion("Exp_Date between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotBetween(Date value1, Date value2) {
            addCriterion("Exp_Date not between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andBookTypeIsNull() {
            addCriterion("Book_Type is null");
            return (Criteria) this;
        }

        public Criteria andBookTypeIsNotNull() {
            addCriterion("Book_Type is not null");
            return (Criteria) this;
        }

        public Criteria andBookTypeEqualTo(Integer value) {
            addCriterion("Book_Type =", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotEqualTo(Integer value) {
            addCriterion("Book_Type <>", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeGreaterThan(Integer value) {
            addCriterion("Book_Type >", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Book_Type >=", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeLessThan(Integer value) {
            addCriterion("Book_Type <", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Book_Type <=", value, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeIn(List<Integer> values) {
            addCriterion("Book_Type in", values, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotIn(List<Integer> values) {
            addCriterion("Book_Type not in", values, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeBetween(Integer value1, Integer value2) {
            addCriterion("Book_Type between", value1, value2, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Book_Type not between", value1, value2, "bookType");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("Book_Name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("Book_Name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("Book_Name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("Book_Name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("Book_Name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("Book_Name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("Book_Name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("Book_Name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("Book_Name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("Book_Name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("Book_Name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("Book_Name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("Book_Name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("Book_Name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("Goods_Type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("Goods_Type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(Integer value) {
            addCriterion("Goods_Type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(Integer value) {
            addCriterion("Goods_Type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(Integer value) {
            addCriterion("Goods_Type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Goods_Type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(Integer value) {
            addCriterion("Goods_Type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Goods_Type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<Integer> values) {
            addCriterion("Goods_Type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<Integer> values) {
            addCriterion("Goods_Type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
            addCriterion("Goods_Type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Goods_Type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andBookStateIsNull() {
            addCriterion("Book_State is null");
            return (Criteria) this;
        }

        public Criteria andBookStateIsNotNull() {
            addCriterion("Book_State is not null");
            return (Criteria) this;
        }

        public Criteria andBookStateEqualTo(Short value) {
            addCriterion("Book_State =", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateNotEqualTo(Short value) {
            addCriterion("Book_State <>", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateGreaterThan(Short value) {
            addCriterion("Book_State >", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateGreaterThanOrEqualTo(Short value) {
            addCriterion("Book_State >=", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateLessThan(Short value) {
            addCriterion("Book_State <", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateLessThanOrEqualTo(Short value) {
            addCriterion("Book_State <=", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateIn(List<Short> values) {
            addCriterion("Book_State in", values, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateNotIn(List<Short> values) {
            addCriterion("Book_State not in", values, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateBetween(Short value1, Short value2) {
            addCriterion("Book_State between", value1, value2, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateNotBetween(Short value1, Short value2) {
            addCriterion("Book_State not between", value1, value2, "bookState");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("Region_Id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("Region_Id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Integer value) {
            addCriterion("Region_Id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Integer value) {
            addCriterion("Region_Id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Integer value) {
            addCriterion("Region_Id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Region_Id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Integer value) {
            addCriterion("Region_Id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Integer value) {
            addCriterion("Region_Id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Integer> values) {
            addCriterion("Region_Id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Integer> values) {
            addCriterion("Region_Id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Integer value1, Integer value2) {
            addCriterion("Region_Id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Region_Id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andBillRuleIsNull() {
            addCriterion("BIll_Rule is null");
            return (Criteria) this;
        }

        public Criteria andBillRuleIsNotNull() {
            addCriterion("BIll_Rule is not null");
            return (Criteria) this;
        }

        public Criteria andBillRuleEqualTo(String value) {
            addCriterion("BIll_Rule =", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleNotEqualTo(String value) {
            addCriterion("BIll_Rule <>", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleGreaterThan(String value) {
            addCriterion("BIll_Rule >", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleGreaterThanOrEqualTo(String value) {
            addCriterion("BIll_Rule >=", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleLessThan(String value) {
            addCriterion("BIll_Rule <", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleLessThanOrEqualTo(String value) {
            addCriterion("BIll_Rule <=", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleLike(String value) {
            addCriterion("BIll_Rule like", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleNotLike(String value) {
            addCriterion("BIll_Rule not like", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleIn(List<String> values) {
            addCriterion("BIll_Rule in", values, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleNotIn(List<String> values) {
            addCriterion("BIll_Rule not in", values, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleBetween(String value1, String value2) {
            addCriterion("BIll_Rule between", value1, value2, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleNotBetween(String value1, String value2) {
            addCriterion("BIll_Rule not between", value1, value2, "billRule");
            return (Criteria) this;
        }

        public Criteria andOrigTypeIsNull() {
            addCriterion("Orig_Type is null");
            return (Criteria) this;
        }

        public Criteria andOrigTypeIsNotNull() {
            addCriterion("Orig_Type is not null");
            return (Criteria) this;
        }

        public Criteria andOrigTypeEqualTo(Integer value) {
            addCriterion("Orig_Type =", value, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeNotEqualTo(Integer value) {
            addCriterion("Orig_Type <>", value, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeGreaterThan(Integer value) {
            addCriterion("Orig_Type >", value, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Orig_Type >=", value, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeLessThan(Integer value) {
            addCriterion("Orig_Type <", value, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Orig_Type <=", value, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeIn(List<Integer> values) {
            addCriterion("Orig_Type in", values, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeNotIn(List<Integer> values) {
            addCriterion("Orig_Type not in", values, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeBetween(Integer value1, Integer value2) {
            addCriterion("Orig_Type between", value1, value2, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Orig_Type not between", value1, value2, "origType");
            return (Criteria) this;
        }

        public Criteria andOrigIdIsNull() {
            addCriterion("Orig_Id is null");
            return (Criteria) this;
        }

        public Criteria andOrigIdIsNotNull() {
            addCriterion("Orig_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOrigIdEqualTo(String value) {
            addCriterion("Orig_Id =", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdNotEqualTo(String value) {
            addCriterion("Orig_Id <>", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdGreaterThan(String value) {
            addCriterion("Orig_Id >", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdGreaterThanOrEqualTo(String value) {
            addCriterion("Orig_Id >=", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdLessThan(String value) {
            addCriterion("Orig_Id <", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdLessThanOrEqualTo(String value) {
            addCriterion("Orig_Id <=", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdLike(String value) {
            addCriterion("Orig_Id like", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdNotLike(String value) {
            addCriterion("Orig_Id not like", value, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdIn(List<String> values) {
            addCriterion("Orig_Id in", values, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdNotIn(List<String> values) {
            addCriterion("Orig_Id not in", values, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdBetween(String value1, String value2) {
            addCriterion("Orig_Id between", value1, value2, "origId");
            return (Criteria) this;
        }

        public Criteria andOrigIdNotBetween(String value1, String value2) {
            addCriterion("Orig_Id not between", value1, value2, "origId");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("Note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("Note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("Note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("Note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("Note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("Note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("Note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("Note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("Note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("Note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("Note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("Note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("Note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("Note not between", value1, value2, "note");
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

        public Criteria andServiceIdIsNull() {
            addCriterion("Service_Id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("Service_Id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("Service_Id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("Service_Id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("Service_Id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("Service_Id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("Service_Id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("Service_Id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("Service_Id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("Service_Id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("Service_Id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("Service_Id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("Service_Id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("Service_Id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andTotalValIsNull() {
            addCriterion("Total_Val is null");
            return (Criteria) this;
        }

        public Criteria andTotalValIsNotNull() {
            addCriterion("Total_Val is not null");
            return (Criteria) this;
        }

        public Criteria andTotalValEqualTo(Long value) {
            addCriterion("Total_Val =", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotEqualTo(Long value) {
            addCriterion("Total_Val <>", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValGreaterThan(Long value) {
            addCriterion("Total_Val >", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValGreaterThanOrEqualTo(Long value) {
            addCriterion("Total_Val >=", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValLessThan(Long value) {
            addCriterion("Total_Val <", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValLessThanOrEqualTo(Long value) {
            addCriterion("Total_Val <=", value, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValIn(List<Long> values) {
            addCriterion("Total_Val in", values, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotIn(List<Long> values) {
            addCriterion("Total_Val not in", values, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValBetween(Long value1, Long value2) {
            addCriterion("Total_Val between", value1, value2, "totalVal");
            return (Criteria) this;
        }

        public Criteria andTotalValNotBetween(Long value1, Long value2) {
            addCriterion("Total_Val not between", value1, value2, "totalVal");
            return (Criteria) this;
        }

        public Criteria andCumuValIsNull() {
            addCriterion("Cumu_Val is null");
            return (Criteria) this;
        }

        public Criteria andCumuValIsNotNull() {
            addCriterion("Cumu_Val is not null");
            return (Criteria) this;
        }

        public Criteria andCumuValEqualTo(Long value) {
            addCriterion("Cumu_Val =", value, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValNotEqualTo(Long value) {
            addCriterion("Cumu_Val <>", value, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValGreaterThan(Long value) {
            addCriterion("Cumu_Val >", value, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValGreaterThanOrEqualTo(Long value) {
            addCriterion("Cumu_Val >=", value, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValLessThan(Long value) {
            addCriterion("Cumu_Val <", value, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValLessThanOrEqualTo(Long value) {
            addCriterion("Cumu_Val <=", value, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValIn(List<Long> values) {
            addCriterion("Cumu_Val in", values, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValNotIn(List<Long> values) {
            addCriterion("Cumu_Val not in", values, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValBetween(Long value1, Long value2) {
            addCriterion("Cumu_Val between", value1, value2, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andCumuValNotBetween(Long value1, Long value2) {
            addCriterion("Cumu_Val not between", value1, value2, "cumuVal");
            return (Criteria) this;
        }

        public Criteria andBalaValIsNull() {
            addCriterion("Bala_Val is null");
            return (Criteria) this;
        }

        public Criteria andBalaValIsNotNull() {
            addCriterion("Bala_Val is not null");
            return (Criteria) this;
        }

        public Criteria andBalaValEqualTo(Long value) {
            addCriterion("Bala_Val =", value, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValNotEqualTo(Long value) {
            addCriterion("Bala_Val <>", value, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValGreaterThan(Long value) {
            addCriterion("Bala_Val >", value, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValGreaterThanOrEqualTo(Long value) {
            addCriterion("Bala_Val >=", value, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValLessThan(Long value) {
            addCriterion("Bala_Val <", value, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValLessThanOrEqualTo(Long value) {
            addCriterion("Bala_Val <=", value, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValIn(List<Long> values) {
            addCriterion("Bala_Val in", values, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValNotIn(List<Long> values) {
            addCriterion("Bala_Val not in", values, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValBetween(Long value1, Long value2) {
            addCriterion("Bala_Val between", value1, value2, "balaVal");
            return (Criteria) this;
        }

        public Criteria andBalaValNotBetween(Long value1, Long value2) {
            addCriterion("Bala_Val not between", value1, value2, "balaVal");
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
            addCriterion("EXT1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("EXT2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("EXT2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("EXT2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("EXT2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("EXT2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("EXT2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("EXT2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("EXT2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("EXT2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("EXT2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("EXT2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("EXT2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("EXT2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("EXT2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("EXT3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("EXT3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("EXT3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("EXT3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("EXT3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("EXT3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("EXT3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("EXT3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("EXT3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("EXT3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("EXT3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("EXT3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("EXT3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("EXT3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt4IsNull() {
            addCriterion("EXT4 is null");
            return (Criteria) this;
        }

        public Criteria andExt4IsNotNull() {
            addCriterion("EXT4 is not null");
            return (Criteria) this;
        }

        public Criteria andExt4EqualTo(String value) {
            addCriterion("EXT4 =", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotEqualTo(String value) {
            addCriterion("EXT4 <>", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThan(String value) {
            addCriterion("EXT4 >", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThanOrEqualTo(String value) {
            addCriterion("EXT4 >=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThan(String value) {
            addCriterion("EXT4 <", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThanOrEqualTo(String value) {
            addCriterion("EXT4 <=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Like(String value) {
            addCriterion("EXT4 like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotLike(String value) {
            addCriterion("EXT4 not like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4In(List<String> values) {
            addCriterion("EXT4 in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotIn(List<String> values) {
            addCriterion("EXT4 not in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Between(String value1, String value2) {
            addCriterion("EXT4 between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotBetween(String value1, String value2) {
            addCriterion("EXT4 not between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt5IsNull() {
            addCriterion("EXT5 is null");
            return (Criteria) this;
        }

        public Criteria andExt5IsNotNull() {
            addCriterion("EXT5 is not null");
            return (Criteria) this;
        }

        public Criteria andExt5EqualTo(String value) {
            addCriterion("EXT5 =", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotEqualTo(String value) {
            addCriterion("EXT5 <>", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThan(String value) {
            addCriterion("EXT5 >", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThanOrEqualTo(String value) {
            addCriterion("EXT5 >=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThan(String value) {
            addCriterion("EXT5 <", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThanOrEqualTo(String value) {
            addCriterion("EXT5 <=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Like(String value) {
            addCriterion("EXT5 like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotLike(String value) {
            addCriterion("EXT5 not like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5In(List<String> values) {
            addCriterion("EXT5 in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotIn(List<String> values) {
            addCriterion("EXT5 not in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Between(String value1, String value2) {
            addCriterion("EXT5 between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotBetween(String value1, String value2) {
            addCriterion("EXT5 not between", value1, value2, "ext5");
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
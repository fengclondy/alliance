package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataRecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataRecExample() {
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

        public Criteria andRecNoIsNull() {
            addCriterion("Rec_No is null");
            return (Criteria) this;
        }

        public Criteria andRecNoIsNotNull() {
            addCriterion("Rec_No is not null");
            return (Criteria) this;
        }

        public Criteria andRecNoEqualTo(String value) {
            addCriterion("Rec_No =", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoNotEqualTo(String value) {
            addCriterion("Rec_No <>", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoGreaterThan(String value) {
            addCriterion("Rec_No >", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoGreaterThanOrEqualTo(String value) {
            addCriterion("Rec_No >=", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoLessThan(String value) {
            addCriterion("Rec_No <", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoLessThanOrEqualTo(String value) {
            addCriterion("Rec_No <=", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoLike(String value) {
            addCriterion("Rec_No like", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoNotLike(String value) {
            addCriterion("Rec_No not like", value, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoIn(List<String> values) {
            addCriterion("Rec_No in", values, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoNotIn(List<String> values) {
            addCriterion("Rec_No not in", values, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoBetween(String value1, String value2) {
            addCriterion("Rec_No between", value1, value2, "recNo");
            return (Criteria) this;
        }

        public Criteria andRecNoNotBetween(String value1, String value2) {
            addCriterion("Rec_No not between", value1, value2, "recNo");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIsNull() {
            addCriterion("Batch_Code is null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIsNotNull() {
            addCriterion("Batch_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeEqualTo(Long value) {
            addCriterion("Batch_Code =", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotEqualTo(Long value) {
            addCriterion("Batch_Code <>", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThan(Long value) {
            addCriterion("Batch_Code >", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("Batch_Code >=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThan(Long value) {
            addCriterion("Batch_Code <", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThanOrEqualTo(Long value) {
            addCriterion("Batch_Code <=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIn(List<Long> values) {
            addCriterion("Batch_Code in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotIn(List<Long> values) {
            addCriterion("Batch_Code not in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeBetween(Long value1, Long value2) {
            addCriterion("Batch_Code between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotBetween(Long value1, Long value2) {
            addCriterion("Batch_Code not between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andRecClassIsNull() {
            addCriterion("Rec_Class is null");
            return (Criteria) this;
        }

        public Criteria andRecClassIsNotNull() {
            addCriterion("Rec_Class is not null");
            return (Criteria) this;
        }

        public Criteria andRecClassEqualTo(Short value) {
            addCriterion("Rec_Class =", value, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassNotEqualTo(Short value) {
            addCriterion("Rec_Class <>", value, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassGreaterThan(Short value) {
            addCriterion("Rec_Class >", value, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassGreaterThanOrEqualTo(Short value) {
            addCriterion("Rec_Class >=", value, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassLessThan(Short value) {
            addCriterion("Rec_Class <", value, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassLessThanOrEqualTo(Short value) {
            addCriterion("Rec_Class <=", value, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassIn(List<Short> values) {
            addCriterion("Rec_Class in", values, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassNotIn(List<Short> values) {
            addCriterion("Rec_Class not in", values, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassBetween(Short value1, Short value2) {
            addCriterion("Rec_Class between", value1, value2, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecClassNotBetween(Short value1, Short value2) {
            addCriterion("Rec_Class not between", value1, value2, "recClass");
            return (Criteria) this;
        }

        public Criteria andRecModeIsNull() {
            addCriterion("Rec_Mode is null");
            return (Criteria) this;
        }

        public Criteria andRecModeIsNotNull() {
            addCriterion("Rec_Mode is not null");
            return (Criteria) this;
        }

        public Criteria andRecModeEqualTo(Integer value) {
            addCriterion("Rec_Mode =", value, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeNotEqualTo(Integer value) {
            addCriterion("Rec_Mode <>", value, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeGreaterThan(Integer value) {
            addCriterion("Rec_Mode >", value, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Rec_Mode >=", value, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeLessThan(Integer value) {
            addCriterion("Rec_Mode <", value, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeLessThanOrEqualTo(Integer value) {
            addCriterion("Rec_Mode <=", value, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeIn(List<Integer> values) {
            addCriterion("Rec_Mode in", values, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeNotIn(List<Integer> values) {
            addCriterion("Rec_Mode not in", values, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeBetween(Integer value1, Integer value2) {
            addCriterion("Rec_Mode between", value1, value2, "recMode");
            return (Criteria) this;
        }

        public Criteria andRecModeNotBetween(Integer value1, Integer value2) {
            addCriterion("Rec_Mode not between", value1, value2, "recMode");
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

        public Criteria andUserNbrIsNull() {
            addCriterion("User_Nbr is null");
            return (Criteria) this;
        }

        public Criteria andUserNbrIsNotNull() {
            addCriterion("User_Nbr is not null");
            return (Criteria) this;
        }

        public Criteria andUserNbrEqualTo(String value) {
            addCriterion("User_Nbr =", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrNotEqualTo(String value) {
            addCriterion("User_Nbr <>", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrGreaterThan(String value) {
            addCriterion("User_Nbr >", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrGreaterThanOrEqualTo(String value) {
            addCriterion("User_Nbr >=", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrLessThan(String value) {
            addCriterion("User_Nbr <", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrLessThanOrEqualTo(String value) {
            addCriterion("User_Nbr <=", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrLike(String value) {
            addCriterion("User_Nbr like", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrNotLike(String value) {
            addCriterion("User_Nbr not like", value, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrIn(List<String> values) {
            addCriterion("User_Nbr in", values, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrNotIn(List<String> values) {
            addCriterion("User_Nbr not in", values, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrBetween(String value1, String value2) {
            addCriterion("User_Nbr between", value1, value2, "userNbr");
            return (Criteria) this;
        }

        public Criteria andUserNbrNotBetween(String value1, String value2) {
            addCriterion("User_Nbr not between", value1, value2, "userNbr");
            return (Criteria) this;
        }

        public Criteria andBusiModeIsNull() {
            addCriterion("Busi_Mode is null");
            return (Criteria) this;
        }

        public Criteria andBusiModeIsNotNull() {
            addCriterion("Busi_Mode is not null");
            return (Criteria) this;
        }

        public Criteria andBusiModeEqualTo(Integer value) {
            addCriterion("Busi_Mode =", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeNotEqualTo(Integer value) {
            addCriterion("Busi_Mode <>", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeGreaterThan(Integer value) {
            addCriterion("Busi_Mode >", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Busi_Mode >=", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeLessThan(Integer value) {
            addCriterion("Busi_Mode <", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeLessThanOrEqualTo(Integer value) {
            addCriterion("Busi_Mode <=", value, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeIn(List<Integer> values) {
            addCriterion("Busi_Mode in", values, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeNotIn(List<Integer> values) {
            addCriterion("Busi_Mode not in", values, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeBetween(Integer value1, Integer value2) {
            addCriterion("Busi_Mode between", value1, value2, "busiMode");
            return (Criteria) this;
        }

        public Criteria andBusiModeNotBetween(Integer value1, Integer value2) {
            addCriterion("Busi_Mode not between", value1, value2, "busiMode");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("Goods_Id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("Goods_Id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("Goods_Id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("Goods_Id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("Goods_Id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("Goods_Id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("Goods_Id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("Goods_Id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("Goods_Id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("Goods_Id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("Goods_Id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("Goods_Id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("Goods_Id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("Goods_Id not between", value1, value2, "goodsId");
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("Goods_Name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("Goods_Name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("Goods_Name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("Goods_Name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("Goods_Name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("Goods_Name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("Goods_Name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("Goods_Name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("Goods_Name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("Goods_Name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("Goods_Name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("Goods_Name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("Goods_Name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("Goods_Name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andDataValIsNull() {
            addCriterion("Data_Val is null");
            return (Criteria) this;
        }

        public Criteria andDataValIsNotNull() {
            addCriterion("Data_Val is not null");
            return (Criteria) this;
        }

        public Criteria andDataValEqualTo(Long value) {
            addCriterion("Data_Val =", value, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValNotEqualTo(Long value) {
            addCriterion("Data_Val <>", value, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValGreaterThan(Long value) {
            addCriterion("Data_Val >", value, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValGreaterThanOrEqualTo(Long value) {
            addCriterion("Data_Val >=", value, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValLessThan(Long value) {
            addCriterion("Data_Val <", value, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValLessThanOrEqualTo(Long value) {
            addCriterion("Data_Val <=", value, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValIn(List<Long> values) {
            addCriterion("Data_Val in", values, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValNotIn(List<Long> values) {
            addCriterion("Data_Val not in", values, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValBetween(Long value1, Long value2) {
            addCriterion("Data_Val between", value1, value2, "dataVal");
            return (Criteria) this;
        }

        public Criteria andDataValNotBetween(Long value1, Long value2) {
            addCriterion("Data_Val not between", value1, value2, "dataVal");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("Total_Fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("Total_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            addCriterion("Total_Fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            addCriterion("Total_Fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            addCriterion("Total_Fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("Total_Fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            addCriterion("Total_Fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            addCriterion("Total_Fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Long> values) {
            addCriterion("Total_Fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            addCriterion("Total_Fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            addCriterion("Total_Fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            addCriterion("Total_Fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeIsNull() {
            addCriterion("Off_fee is null");
            return (Criteria) this;
        }

        public Criteria andOffFeeIsNotNull() {
            addCriterion("Off_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOffFeeEqualTo(Long value) {
            addCriterion("Off_fee =", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeNotEqualTo(Long value) {
            addCriterion("Off_fee <>", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeGreaterThan(Long value) {
            addCriterion("Off_fee >", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("Off_fee >=", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeLessThan(Long value) {
            addCriterion("Off_fee <", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeLessThanOrEqualTo(Long value) {
            addCriterion("Off_fee <=", value, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeIn(List<Long> values) {
            addCriterion("Off_fee in", values, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeNotIn(List<Long> values) {
            addCriterion("Off_fee not in", values, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeBetween(Long value1, Long value2) {
            addCriterion("Off_fee between", value1, value2, "offFee");
            return (Criteria) this;
        }

        public Criteria andOffFeeNotBetween(Long value1, Long value2) {
            addCriterion("Off_fee not between", value1, value2, "offFee");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("Discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("Discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Integer value) {
            addCriterion("Discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Integer value) {
            addCriterion("Discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Integer value) {
            addCriterion("Discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Integer value) {
            addCriterion("Discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("Discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Integer> values) {
            addCriterion("Discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Integer> values) {
            addCriterion("Discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Integer value1, Integer value2) {
            addCriterion("Discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("Discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andBillFeeIsNull() {
            addCriterion("Bill_Fee is null");
            return (Criteria) this;
        }

        public Criteria andBillFeeIsNotNull() {
            addCriterion("Bill_Fee is not null");
            return (Criteria) this;
        }

        public Criteria andBillFeeEqualTo(Long value) {
            addCriterion("Bill_Fee =", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotEqualTo(Long value) {
            addCriterion("Bill_Fee <>", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeGreaterThan(Long value) {
            addCriterion("Bill_Fee >", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("Bill_Fee >=", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeLessThan(Long value) {
            addCriterion("Bill_Fee <", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeLessThanOrEqualTo(Long value) {
            addCriterion("Bill_Fee <=", value, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeIn(List<Long> values) {
            addCriterion("Bill_Fee in", values, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotIn(List<Long> values) {
            addCriterion("Bill_Fee not in", values, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeBetween(Long value1, Long value2) {
            addCriterion("Bill_Fee between", value1, value2, "billFee");
            return (Criteria) this;
        }

        public Criteria andBillFeeNotBetween(Long value1, Long value2) {
            addCriterion("Bill_Fee not between", value1, value2, "billFee");
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

        public Criteria andBeginDateIsNull() {
            addCriterion("Begin_Date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("Begin_Date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("Begin_Date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("Begin_Date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("Begin_Date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Begin_Date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("Begin_Date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("Begin_Date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("Begin_Date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("Begin_Date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("Begin_Date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("Begin_Date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("End_Date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("End_Date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("End_Date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("End_Date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("End_Date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("End_Date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("End_Date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("End_Date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("End_Date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("End_Date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("End_Date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("End_Date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andErrMesgIsNull() {
            addCriterion("Err_Mesg is null");
            return (Criteria) this;
        }

        public Criteria andErrMesgIsNotNull() {
            addCriterion("Err_Mesg is not null");
            return (Criteria) this;
        }

        public Criteria andErrMesgEqualTo(String value) {
            addCriterion("Err_Mesg =", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgNotEqualTo(String value) {
            addCriterion("Err_Mesg <>", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgGreaterThan(String value) {
            addCriterion("Err_Mesg >", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgGreaterThanOrEqualTo(String value) {
            addCriterion("Err_Mesg >=", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgLessThan(String value) {
            addCriterion("Err_Mesg <", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgLessThanOrEqualTo(String value) {
            addCriterion("Err_Mesg <=", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgLike(String value) {
            addCriterion("Err_Mesg like", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgNotLike(String value) {
            addCriterion("Err_Mesg not like", value, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgIn(List<String> values) {
            addCriterion("Err_Mesg in", values, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgNotIn(List<String> values) {
            addCriterion("Err_Mesg not in", values, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgBetween(String value1, String value2) {
            addCriterion("Err_Mesg between", value1, value2, "errMesg");
            return (Criteria) this;
        }

        public Criteria andErrMesgNotBetween(String value1, String value2) {
            addCriterion("Err_Mesg not between", value1, value2, "errMesg");
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

        public Criteria andDealCountIsNull() {
            addCriterion("Deal_Count is null");
            return (Criteria) this;
        }

        public Criteria andDealCountIsNotNull() {
            addCriterion("Deal_Count is not null");
            return (Criteria) this;
        }

        public Criteria andDealCountEqualTo(Integer value) {
            addCriterion("Deal_Count =", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotEqualTo(Integer value) {
            addCriterion("Deal_Count <>", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountGreaterThan(Integer value) {
            addCriterion("Deal_Count >", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Deal_Count >=", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountLessThan(Integer value) {
            addCriterion("Deal_Count <", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountLessThanOrEqualTo(Integer value) {
            addCriterion("Deal_Count <=", value, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountIn(List<Integer> values) {
            addCriterion("Deal_Count in", values, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotIn(List<Integer> values) {
            addCriterion("Deal_Count not in", values, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountBetween(Integer value1, Integer value2) {
            addCriterion("Deal_Count between", value1, value2, "dealCount");
            return (Criteria) this;
        }

        public Criteria andDealCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Deal_Count not between", value1, value2, "dealCount");
            return (Criteria) this;
        }

        public Criteria andRedoFlagIsNull() {
            addCriterion("Redo_Flag is null");
            return (Criteria) this;
        }

        public Criteria andRedoFlagIsNotNull() {
            addCriterion("Redo_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andRedoFlagEqualTo(Integer value) {
            addCriterion("Redo_Flag =", value, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagNotEqualTo(Integer value) {
            addCriterion("Redo_Flag <>", value, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagGreaterThan(Integer value) {
            addCriterion("Redo_Flag >", value, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("Redo_Flag >=", value, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagLessThan(Integer value) {
            addCriterion("Redo_Flag <", value, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagLessThanOrEqualTo(Integer value) {
            addCriterion("Redo_Flag <=", value, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagIn(List<Integer> values) {
            addCriterion("Redo_Flag in", values, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagNotIn(List<Integer> values) {
            addCriterion("Redo_Flag not in", values, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Flag between", value1, value2, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andRedoFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("Redo_Flag not between", value1, value2, "redoFlag");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNull() {
            addCriterion("Oper_Id is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("Oper_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(Long value) {
            addCriterion("Oper_Id =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(Long value) {
            addCriterion("Oper_Id <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(Long value) {
            addCriterion("Oper_Id >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Oper_Id >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(Long value) {
            addCriterion("Oper_Id <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(Long value) {
            addCriterion("Oper_Id <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<Long> values) {
            addCriterion("Oper_Id in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<Long> values) {
            addCriterion("Oper_Id not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(Long value1, Long value2) {
            addCriterion("Oper_Id between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(Long value1, Long value2) {
            addCriterion("Oper_Id not between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperNameIsNull() {
            addCriterion("Oper_Name is null");
            return (Criteria) this;
        }

        public Criteria andOperNameIsNotNull() {
            addCriterion("Oper_Name is not null");
            return (Criteria) this;
        }

        public Criteria andOperNameEqualTo(String value) {
            addCriterion("Oper_Name =", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotEqualTo(String value) {
            addCriterion("Oper_Name <>", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameGreaterThan(String value) {
            addCriterion("Oper_Name >", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameGreaterThanOrEqualTo(String value) {
            addCriterion("Oper_Name >=", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLessThan(String value) {
            addCriterion("Oper_Name <", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLessThanOrEqualTo(String value) {
            addCriterion("Oper_Name <=", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLike(String value) {
            addCriterion("Oper_Name like", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotLike(String value) {
            addCriterion("Oper_Name not like", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameIn(List<String> values) {
            addCriterion("Oper_Name in", values, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotIn(List<String> values) {
            addCriterion("Oper_Name not in", values, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameBetween(String value1, String value2) {
            addCriterion("Oper_Name between", value1, value2, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotBetween(String value1, String value2) {
            addCriterion("Oper_Name not between", value1, value2, "operName");
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

        public Criteria andBillRuleIsNull() {
            addCriterion("Bill_Rule is null");
            return (Criteria) this;
        }

        public Criteria andBillRuleIsNotNull() {
            addCriterion("Bill_Rule is not null");
            return (Criteria) this;
        }

        public Criteria andBillRuleEqualTo(Integer value) {
            addCriterion("Bill_Rule =", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleNotEqualTo(Integer value) {
            addCriterion("Bill_Rule <>", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleGreaterThan(Integer value) {
            addCriterion("Bill_Rule >", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("Bill_Rule >=", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleLessThan(Integer value) {
            addCriterion("Bill_Rule <", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleLessThanOrEqualTo(Integer value) {
            addCriterion("Bill_Rule <=", value, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleIn(List<Integer> values) {
            addCriterion("Bill_Rule in", values, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleNotIn(List<Integer> values) {
            addCriterion("Bill_Rule not in", values, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleBetween(Integer value1, Integer value2) {
            addCriterion("Bill_Rule between", value1, value2, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("Bill_Rule not between", value1, value2, "billRule");
            return (Criteria) this;
        }

        public Criteria andBillSerialIsNull() {
            addCriterion("Bill_Serial is null");
            return (Criteria) this;
        }

        public Criteria andBillSerialIsNotNull() {
            addCriterion("Bill_Serial is not null");
            return (Criteria) this;
        }

        public Criteria andBillSerialEqualTo(String value) {
            addCriterion("Bill_Serial =", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialNotEqualTo(String value) {
            addCriterion("Bill_Serial <>", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialGreaterThan(String value) {
            addCriterion("Bill_Serial >", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialGreaterThanOrEqualTo(String value) {
            addCriterion("Bill_Serial >=", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialLessThan(String value) {
            addCriterion("Bill_Serial <", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialLessThanOrEqualTo(String value) {
            addCriterion("Bill_Serial <=", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialLike(String value) {
            addCriterion("Bill_Serial like", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialNotLike(String value) {
            addCriterion("Bill_Serial not like", value, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialIn(List<String> values) {
            addCriterion("Bill_Serial in", values, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialNotIn(List<String> values) {
            addCriterion("Bill_Serial not in", values, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialBetween(String value1, String value2) {
            addCriterion("Bill_Serial between", value1, value2, "billSerial");
            return (Criteria) this;
        }

        public Criteria andBillSerialNotBetween(String value1, String value2) {
            addCriterion("Bill_Serial not between", value1, value2, "billSerial");
            return (Criteria) this;
        }

        public Criteria andResultMesgIsNull() {
            addCriterion("Result_Mesg is null");
            return (Criteria) this;
        }

        public Criteria andResultMesgIsNotNull() {
            addCriterion("Result_Mesg is not null");
            return (Criteria) this;
        }

        public Criteria andResultMesgEqualTo(String value) {
            addCriterion("Result_Mesg =", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgNotEqualTo(String value) {
            addCriterion("Result_Mesg <>", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgGreaterThan(String value) {
            addCriterion("Result_Mesg >", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgGreaterThanOrEqualTo(String value) {
            addCriterion("Result_Mesg >=", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgLessThan(String value) {
            addCriterion("Result_Mesg <", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgLessThanOrEqualTo(String value) {
            addCriterion("Result_Mesg <=", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgLike(String value) {
            addCriterion("Result_Mesg like", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgNotLike(String value) {
            addCriterion("Result_Mesg not like", value, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgIn(List<String> values) {
            addCriterion("Result_Mesg in", values, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgNotIn(List<String> values) {
            addCriterion("Result_Mesg not in", values, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgBetween(String value1, String value2) {
            addCriterion("Result_Mesg between", value1, value2, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andResultMesgNotBetween(String value1, String value2) {
            addCriterion("Result_Mesg not between", value1, value2, "resultMesg");
            return (Criteria) this;
        }

        public Criteria andOfferIdIsNull() {
            addCriterion("Offer_Id is null");
            return (Criteria) this;
        }

        public Criteria andOfferIdIsNotNull() {
            addCriterion("Offer_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOfferIdEqualTo(String value) {
            addCriterion("Offer_Id =", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotEqualTo(String value) {
            addCriterion("Offer_Id <>", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThan(String value) {
            addCriterion("Offer_Id >", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThanOrEqualTo(String value) {
            addCriterion("Offer_Id >=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThan(String value) {
            addCriterion("Offer_Id <", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThanOrEqualTo(String value) {
            addCriterion("Offer_Id <=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLike(String value) {
            addCriterion("Offer_Id like", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotLike(String value) {
            addCriterion("Offer_Id not like", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdIn(List<String> values) {
            addCriterion("Offer_Id in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotIn(List<String> values) {
            addCriterion("Offer_Id not in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdBetween(String value1, String value2) {
            addCriterion("Offer_Id between", value1, value2, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotBetween(String value1, String value2) {
            addCriterion("Offer_Id not between", value1, value2, "offerId");
            return (Criteria) this;
        }

        public Criteria andServIdIsNull() {
            addCriterion("Serv_Id is null");
            return (Criteria) this;
        }

        public Criteria andServIdIsNotNull() {
            addCriterion("Serv_Id is not null");
            return (Criteria) this;
        }

        public Criteria andServIdEqualTo(String value) {
            addCriterion("Serv_Id =", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotEqualTo(String value) {
            addCriterion("Serv_Id <>", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThan(String value) {
            addCriterion("Serv_Id >", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThanOrEqualTo(String value) {
            addCriterion("Serv_Id >=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThan(String value) {
            addCriterion("Serv_Id <", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThanOrEqualTo(String value) {
            addCriterion("Serv_Id <=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLike(String value) {
            addCriterion("Serv_Id like", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotLike(String value) {
            addCriterion("Serv_Id not like", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdIn(List<String> values) {
            addCriterion("Serv_Id in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotIn(List<String> values) {
            addCriterion("Serv_Id not in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdBetween(String value1, String value2) {
            addCriterion("Serv_Id between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotBetween(String value1, String value2) {
            addCriterion("Serv_Id not between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andOfferInstIsNull() {
            addCriterion("Offer_Inst is null");
            return (Criteria) this;
        }

        public Criteria andOfferInstIsNotNull() {
            addCriterion("Offer_Inst is not null");
            return (Criteria) this;
        }

        public Criteria andOfferInstEqualTo(String value) {
            addCriterion("Offer_Inst =", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstNotEqualTo(String value) {
            addCriterion("Offer_Inst <>", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstGreaterThan(String value) {
            addCriterion("Offer_Inst >", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstGreaterThanOrEqualTo(String value) {
            addCriterion("Offer_Inst >=", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstLessThan(String value) {
            addCriterion("Offer_Inst <", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstLessThanOrEqualTo(String value) {
            addCriterion("Offer_Inst <=", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstLike(String value) {
            addCriterion("Offer_Inst like", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstNotLike(String value) {
            addCriterion("Offer_Inst not like", value, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstIn(List<String> values) {
            addCriterion("Offer_Inst in", values, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstNotIn(List<String> values) {
            addCriterion("Offer_Inst not in", values, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstBetween(String value1, String value2) {
            addCriterion("Offer_Inst between", value1, value2, "offerInst");
            return (Criteria) this;
        }

        public Criteria andOfferInstNotBetween(String value1, String value2) {
            addCriterion("Offer_Inst not between", value1, value2, "offerInst");
            return (Criteria) this;
        }

        public Criteria andTrdRecIsNull() {
            addCriterion("Trd_Rec is null");
            return (Criteria) this;
        }

        public Criteria andTrdRecIsNotNull() {
            addCriterion("Trd_Rec is not null");
            return (Criteria) this;
        }

        public Criteria andTrdRecEqualTo(String value) {
            addCriterion("Trd_Rec =", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecNotEqualTo(String value) {
            addCriterion("Trd_Rec <>", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecGreaterThan(String value) {
            addCriterion("Trd_Rec >", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecGreaterThanOrEqualTo(String value) {
            addCriterion("Trd_Rec >=", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecLessThan(String value) {
            addCriterion("Trd_Rec <", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecLessThanOrEqualTo(String value) {
            addCriterion("Trd_Rec <=", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecLike(String value) {
            addCriterion("Trd_Rec like", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecNotLike(String value) {
            addCriterion("Trd_Rec not like", value, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecIn(List<String> values) {
            addCriterion("Trd_Rec in", values, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecNotIn(List<String> values) {
            addCriterion("Trd_Rec not in", values, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecBetween(String value1, String value2) {
            addCriterion("Trd_Rec between", value1, value2, "trdRec");
            return (Criteria) this;
        }

        public Criteria andTrdRecNotBetween(String value1, String value2) {
            addCriterion("Trd_Rec not between", value1, value2, "trdRec");
            return (Criteria) this;
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

        public Criteria andCostCenterIsNull() {
            addCriterion("Cost_Center is null");
            return (Criteria) this;
        }

        public Criteria andCostCenterIsNotNull() {
            addCriterion("Cost_Center is not null");
            return (Criteria) this;
        }

        public Criteria andCostCenterEqualTo(String value) {
            addCriterion("Cost_Center =", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotEqualTo(String value) {
            addCriterion("Cost_Center <>", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterGreaterThan(String value) {
            addCriterion("Cost_Center >", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterGreaterThanOrEqualTo(String value) {
            addCriterion("Cost_Center >=", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLessThan(String value) {
            addCriterion("Cost_Center <", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLessThanOrEqualTo(String value) {
            addCriterion("Cost_Center <=", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterLike(String value) {
            addCriterion("Cost_Center like", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotLike(String value) {
            addCriterion("Cost_Center not like", value, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterIn(List<String> values) {
            addCriterion("Cost_Center in", values, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotIn(List<String> values) {
            addCriterion("Cost_Center not in", values, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterBetween(String value1, String value2) {
            addCriterion("Cost_Center between", value1, value2, "costCenter");
            return (Criteria) this;
        }

        public Criteria andCostCenterNotBetween(String value1, String value2) {
            addCriterion("Cost_Center not between", value1, value2, "costCenter");
            return (Criteria) this;
        }

        public Criteria andBillBatchIsNull() {
            addCriterion("Bill_Batch is null");
            return (Criteria) this;
        }

        public Criteria andBillBatchIsNotNull() {
            addCriterion("Bill_Batch is not null");
            return (Criteria) this;
        }

        public Criteria andBillBatchEqualTo(String value) {
            addCriterion("Bill_Batch =", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchNotEqualTo(String value) {
            addCriterion("Bill_Batch <>", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchGreaterThan(String value) {
            addCriterion("Bill_Batch >", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchGreaterThanOrEqualTo(String value) {
            addCriterion("Bill_Batch >=", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchLessThan(String value) {
            addCriterion("Bill_Batch <", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchLessThanOrEqualTo(String value) {
            addCriterion("Bill_Batch <=", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchLike(String value) {
            addCriterion("Bill_Batch like", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchNotLike(String value) {
            addCriterion("Bill_Batch not like", value, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchIn(List<String> values) {
            addCriterion("Bill_Batch in", values, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchNotIn(List<String> values) {
            addCriterion("Bill_Batch not in", values, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchBetween(String value1, String value2) {
            addCriterion("Bill_Batch between", value1, value2, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillBatchNotBetween(String value1, String value2) {
            addCriterion("Bill_Batch not between", value1, value2, "billBatch");
            return (Criteria) this;
        }

        public Criteria andBillMonthIsNull() {
            addCriterion("Bill_Month is null");
            return (Criteria) this;
        }

        public Criteria andBillMonthIsNotNull() {
            addCriterion("Bill_Month is not null");
            return (Criteria) this;
        }

        public Criteria andBillMonthEqualTo(String value) {
            addCriterion("Bill_Month =", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotEqualTo(String value) {
            addCriterion("Bill_Month <>", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthGreaterThan(String value) {
            addCriterion("Bill_Month >", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthGreaterThanOrEqualTo(String value) {
            addCriterion("Bill_Month >=", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLessThan(String value) {
            addCriterion("Bill_Month <", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLessThanOrEqualTo(String value) {
            addCriterion("Bill_Month <=", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthLike(String value) {
            addCriterion("Bill_Month like", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotLike(String value) {
            addCriterion("Bill_Month not like", value, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthIn(List<String> values) {
            addCriterion("Bill_Month in", values, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotIn(List<String> values) {
            addCriterion("Bill_Month not in", values, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthBetween(String value1, String value2) {
            addCriterion("Bill_Month between", value1, value2, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillMonthNotBetween(String value1, String value2) {
            addCriterion("Bill_Month not between", value1, value2, "billMonth");
            return (Criteria) this;
        }

        public Criteria andBillStateIsNull() {
            addCriterion("Bill_State is null");
            return (Criteria) this;
        }

        public Criteria andBillStateIsNotNull() {
            addCriterion("Bill_State is not null");
            return (Criteria) this;
        }

        public Criteria andBillStateEqualTo(Integer value) {
            addCriterion("Bill_State =", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateNotEqualTo(Integer value) {
            addCriterion("Bill_State <>", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateGreaterThan(Integer value) {
            addCriterion("Bill_State >", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Bill_State >=", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateLessThan(Integer value) {
            addCriterion("Bill_State <", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateLessThanOrEqualTo(Integer value) {
            addCriterion("Bill_State <=", value, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateIn(List<Integer> values) {
            addCriterion("Bill_State in", values, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateNotIn(List<Integer> values) {
            addCriterion("Bill_State not in", values, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateBetween(Integer value1, Integer value2) {
            addCriterion("Bill_State between", value1, value2, "billState");
            return (Criteria) this;
        }

        public Criteria andBillStateNotBetween(Integer value1, Integer value2) {
            addCriterion("Bill_State not between", value1, value2, "billState");
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

        public Criteria andResultCodeIsNull() {
            addCriterion("Result_Code is null");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNotNull() {
            addCriterion("Result_Code is not null");
            return (Criteria) this;
        }

        public Criteria andResultCodeEqualTo(String value) {
            addCriterion("Result_Code =", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotEqualTo(String value) {
            addCriterion("Result_Code <>", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThan(String value) {
            addCriterion("Result_Code >", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Result_Code >=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThan(String value) {
            addCriterion("Result_Code <", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThanOrEqualTo(String value) {
            addCriterion("Result_Code <=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLike(String value) {
            addCriterion("Result_Code like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotLike(String value) {
            addCriterion("Result_Code not like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIn(List<String> values) {
            addCriterion("Result_Code in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotIn(List<String> values) {
            addCriterion("Result_Code not in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeBetween(String value1, String value2) {
            addCriterion("Result_Code between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotBetween(String value1, String value2) {
            addCriterion("Result_Code not between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andTrdSalerIsNull() {
            addCriterion("Trd_Saler is null");
            return (Criteria) this;
        }

        public Criteria andTrdSalerIsNotNull() {
            addCriterion("Trd_Saler is not null");
            return (Criteria) this;
        }

        public Criteria andTrdSalerEqualTo(String value) {
            addCriterion("Trd_Saler =", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerNotEqualTo(String value) {
            addCriterion("Trd_Saler <>", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerGreaterThan(String value) {
            addCriterion("Trd_Saler >", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerGreaterThanOrEqualTo(String value) {
            addCriterion("Trd_Saler >=", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerLessThan(String value) {
            addCriterion("Trd_Saler <", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerLessThanOrEqualTo(String value) {
            addCriterion("Trd_Saler <=", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerLike(String value) {
            addCriterion("Trd_Saler like", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerNotLike(String value) {
            addCriterion("Trd_Saler not like", value, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerIn(List<String> values) {
            addCriterion("Trd_Saler in", values, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerNotIn(List<String> values) {
            addCriterion("Trd_Saler not in", values, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerBetween(String value1, String value2) {
            addCriterion("Trd_Saler between", value1, value2, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdSalerNotBetween(String value1, String value2) {
            addCriterion("Trd_Saler not between", value1, value2, "trdSaler");
            return (Criteria) this;
        }

        public Criteria andTrdActivityIsNull() {
            addCriterion("Trd_Activity is null");
            return (Criteria) this;
        }

        public Criteria andTrdActivityIsNotNull() {
            addCriterion("Trd_Activity is not null");
            return (Criteria) this;
        }

        public Criteria andTrdActivityEqualTo(String value) {
            addCriterion("Trd_Activity =", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityNotEqualTo(String value) {
            addCriterion("Trd_Activity <>", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityGreaterThan(String value) {
            addCriterion("Trd_Activity >", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityGreaterThanOrEqualTo(String value) {
            addCriterion("Trd_Activity >=", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityLessThan(String value) {
            addCriterion("Trd_Activity <", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityLessThanOrEqualTo(String value) {
            addCriterion("Trd_Activity <=", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityLike(String value) {
            addCriterion("Trd_Activity like", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityNotLike(String value) {
            addCriterion("Trd_Activity not like", value, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityIn(List<String> values) {
            addCriterion("Trd_Activity in", values, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityNotIn(List<String> values) {
            addCriterion("Trd_Activity not in", values, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityBetween(String value1, String value2) {
            addCriterion("Trd_Activity between", value1, value2, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andTrdActivityNotBetween(String value1, String value2) {
            addCriterion("Trd_Activity not between", value1, value2, "trdActivity");
            return (Criteria) this;
        }

        public Criteria andContNoIsNull() {
            addCriterion("Cont_No is null");
            return (Criteria) this;
        }

        public Criteria andContNoIsNotNull() {
            addCriterion("Cont_No is not null");
            return (Criteria) this;
        }

        public Criteria andContNoEqualTo(String value) {
            addCriterion("Cont_No =", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoNotEqualTo(String value) {
            addCriterion("Cont_No <>", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoGreaterThan(String value) {
            addCriterion("Cont_No >", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoGreaterThanOrEqualTo(String value) {
            addCriterion("Cont_No >=", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoLessThan(String value) {
            addCriterion("Cont_No <", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoLessThanOrEqualTo(String value) {
            addCriterion("Cont_No <=", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoLike(String value) {
            addCriterion("Cont_No like", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoNotLike(String value) {
            addCriterion("Cont_No not like", value, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoIn(List<String> values) {
            addCriterion("Cont_No in", values, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoNotIn(List<String> values) {
            addCriterion("Cont_No not in", values, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoBetween(String value1, String value2) {
            addCriterion("Cont_No between", value1, value2, "contNo");
            return (Criteria) this;
        }

        public Criteria andContNoNotBetween(String value1, String value2) {
            addCriterion("Cont_No not between", value1, value2, "contNo");
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
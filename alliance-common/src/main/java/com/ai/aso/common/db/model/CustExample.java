package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustExample() {
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

        public Criteria andOriginCustIdIsNull() {
            addCriterion("Origin_Cust_Id is null");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdIsNotNull() {
            addCriterion("Origin_Cust_Id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdEqualTo(String value) {
            addCriterion("Origin_Cust_Id =", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdNotEqualTo(String value) {
            addCriterion("Origin_Cust_Id <>", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdGreaterThan(String value) {
            addCriterion("Origin_Cust_Id >", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("Origin_Cust_Id >=", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdLessThan(String value) {
            addCriterion("Origin_Cust_Id <", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdLessThanOrEqualTo(String value) {
            addCriterion("Origin_Cust_Id <=", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdLike(String value) {
            addCriterion("Origin_Cust_Id like", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdNotLike(String value) {
            addCriterion("Origin_Cust_Id not like", value, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdIn(List<String> values) {
            addCriterion("Origin_Cust_Id in", values, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdNotIn(List<String> values) {
            addCriterion("Origin_Cust_Id not in", values, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdBetween(String value1, String value2) {
            addCriterion("Origin_Cust_Id between", value1, value2, "originCustId");
            return (Criteria) this;
        }

        public Criteria andOriginCustIdNotBetween(String value1, String value2) {
            addCriterion("Origin_Cust_Id not between", value1, value2, "originCustId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdIsNull() {
            addCriterion("Cust_Ext_Id is null");
            return (Criteria) this;
        }

        public Criteria andCustExtIdIsNotNull() {
            addCriterion("Cust_Ext_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCustExtIdEqualTo(Long value) {
            addCriterion("Cust_Ext_Id =", value, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdNotEqualTo(Long value) {
            addCriterion("Cust_Ext_Id <>", value, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdGreaterThan(Long value) {
            addCriterion("Cust_Ext_Id >", value, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Cust_Ext_Id >=", value, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdLessThan(Long value) {
            addCriterion("Cust_Ext_Id <", value, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdLessThanOrEqualTo(Long value) {
            addCriterion("Cust_Ext_Id <=", value, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdIn(List<Long> values) {
            addCriterion("Cust_Ext_Id in", values, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdNotIn(List<Long> values) {
            addCriterion("Cust_Ext_Id not in", values, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdBetween(Long value1, Long value2) {
            addCriterion("Cust_Ext_Id between", value1, value2, "custExtId");
            return (Criteria) this;
        }

        public Criteria andCustExtIdNotBetween(Long value1, Long value2) {
            addCriterion("Cust_Ext_Id not between", value1, value2, "custExtId");
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

        public Criteria andCustTypeIsNull() {
            addCriterion("Cust_Type is null");
            return (Criteria) this;
        }

        public Criteria andCustTypeIsNotNull() {
            addCriterion("Cust_Type is not null");
            return (Criteria) this;
        }

        public Criteria andCustTypeEqualTo(Short value) {
            addCriterion("Cust_Type =", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotEqualTo(Short value) {
            addCriterion("Cust_Type <>", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeGreaterThan(Short value) {
            addCriterion("Cust_Type >", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("Cust_Type >=", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeLessThan(Short value) {
            addCriterion("Cust_Type <", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeLessThanOrEqualTo(Short value) {
            addCriterion("Cust_Type <=", value, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeIn(List<Short> values) {
            addCriterion("Cust_Type in", values, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotIn(List<Short> values) {
            addCriterion("Cust_Type not in", values, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeBetween(Short value1, Short value2) {
            addCriterion("Cust_Type between", value1, value2, "custType");
            return (Criteria) this;
        }

        public Criteria andCustTypeNotBetween(Short value1, Short value2) {
            addCriterion("Cust_Type not between", value1, value2, "custType");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("Cust_Name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("Cust_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("Cust_Name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("Cust_Name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("Cust_Name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("Cust_Name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("Cust_Name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("Cust_Name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("Cust_Name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("Cust_Name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("Cust_Name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("Cust_Name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("Cust_Name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("Cust_Name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNamePyIsNull() {
            addCriterion("Cust_Name_Py is null");
            return (Criteria) this;
        }

        public Criteria andCustNamePyIsNotNull() {
            addCriterion("Cust_Name_Py is not null");
            return (Criteria) this;
        }

        public Criteria andCustNamePyEqualTo(String value) {
            addCriterion("Cust_Name_Py =", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyNotEqualTo(String value) {
            addCriterion("Cust_Name_Py <>", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyGreaterThan(String value) {
            addCriterion("Cust_Name_Py >", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyGreaterThanOrEqualTo(String value) {
            addCriterion("Cust_Name_Py >=", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyLessThan(String value) {
            addCriterion("Cust_Name_Py <", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyLessThanOrEqualTo(String value) {
            addCriterion("Cust_Name_Py <=", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyLike(String value) {
            addCriterion("Cust_Name_Py like", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyNotLike(String value) {
            addCriterion("Cust_Name_Py not like", value, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyIn(List<String> values) {
            addCriterion("Cust_Name_Py in", values, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyNotIn(List<String> values) {
            addCriterion("Cust_Name_Py not in", values, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyBetween(String value1, String value2) {
            addCriterion("Cust_Name_Py between", value1, value2, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andCustNamePyNotBetween(String value1, String value2) {
            addCriterion("Cust_Name_Py not between", value1, value2, "custNamePy");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("Short_Name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("Short_Name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("Short_Name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("Short_Name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("Short_Name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("Short_Name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("Short_Name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("Short_Name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("Short_Name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("Short_Name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("Short_Name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("Short_Name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("Short_Name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("Short_Name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("Cert_Type is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("Cert_Type is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(Short value) {
            addCriterion("Cert_Type =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(Short value) {
            addCriterion("Cert_Type <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(Short value) {
            addCriterion("Cert_Type >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("Cert_Type >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(Short value) {
            addCriterion("Cert_Type <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(Short value) {
            addCriterion("Cert_Type <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<Short> values) {
            addCriterion("Cert_Type in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<Short> values) {
            addCriterion("Cert_Type not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(Short value1, Short value2) {
            addCriterion("Cert_Type between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(Short value1, Short value2) {
            addCriterion("Cert_Type not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNbrIsNull() {
            addCriterion("Cert_Nbr is null");
            return (Criteria) this;
        }

        public Criteria andCertNbrIsNotNull() {
            addCriterion("Cert_Nbr is not null");
            return (Criteria) this;
        }

        public Criteria andCertNbrEqualTo(String value) {
            addCriterion("Cert_Nbr =", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotEqualTo(String value) {
            addCriterion("Cert_Nbr <>", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrGreaterThan(String value) {
            addCriterion("Cert_Nbr >", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrGreaterThanOrEqualTo(String value) {
            addCriterion("Cert_Nbr >=", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrLessThan(String value) {
            addCriterion("Cert_Nbr <", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrLessThanOrEqualTo(String value) {
            addCriterion("Cert_Nbr <=", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrLike(String value) {
            addCriterion("Cert_Nbr like", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotLike(String value) {
            addCriterion("Cert_Nbr not like", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrIn(List<String> values) {
            addCriterion("Cert_Nbr in", values, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotIn(List<String> values) {
            addCriterion("Cert_Nbr not in", values, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrBetween(String value1, String value2) {
            addCriterion("Cert_Nbr between", value1, value2, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotBetween(String value1, String value2) {
            addCriterion("Cert_Nbr not between", value1, value2, "certNbr");
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

        public Criteria andRegionIdEqualTo(String value) {
            addCriterion("Region_Id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(String value) {
            addCriterion("Region_Id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(String value) {
            addCriterion("Region_Id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(String value) {
            addCriterion("Region_Id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(String value) {
            addCriterion("Region_Id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(String value) {
            addCriterion("Region_Id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLike(String value) {
            addCriterion("Region_Id like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotLike(String value) {
            addCriterion("Region_Id not like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<String> values) {
            addCriterion("Region_Id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<String> values) {
            addCriterion("Region_Id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(String value1, String value2) {
            addCriterion("Region_Id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(String value1, String value2) {
            addCriterion("Region_Id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andCustAddrIsNull() {
            addCriterion("Cust_Addr is null");
            return (Criteria) this;
        }

        public Criteria andCustAddrIsNotNull() {
            addCriterion("Cust_Addr is not null");
            return (Criteria) this;
        }

        public Criteria andCustAddrEqualTo(String value) {
            addCriterion("Cust_Addr =", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotEqualTo(String value) {
            addCriterion("Cust_Addr <>", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrGreaterThan(String value) {
            addCriterion("Cust_Addr >", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrGreaterThanOrEqualTo(String value) {
            addCriterion("Cust_Addr >=", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrLessThan(String value) {
            addCriterion("Cust_Addr <", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrLessThanOrEqualTo(String value) {
            addCriterion("Cust_Addr <=", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrLike(String value) {
            addCriterion("Cust_Addr like", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotLike(String value) {
            addCriterion("Cust_Addr not like", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrIn(List<String> values) {
            addCriterion("Cust_Addr in", values, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotIn(List<String> values) {
            addCriterion("Cust_Addr not in", values, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrBetween(String value1, String value2) {
            addCriterion("Cust_Addr between", value1, value2, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotBetween(String value1, String value2) {
            addCriterion("Cust_Addr not between", value1, value2, "custAddr");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("User_Name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("User_Name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("User_Name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("User_Name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("User_Name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("User_Name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("User_Name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("User_Name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("User_Name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("User_Name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("User_Name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("User_Name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("User_Name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("User_Name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("User_Mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("User_Mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("User_Mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("User_Mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("User_Mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("User_Mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("User_Mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("User_Mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("User_Mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("User_Mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("User_Mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("User_Mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("User_Mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("User_Mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("User_Email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("User_Email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("User_Email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("User_Email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("User_Email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("User_Email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("User_Email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("User_Email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("User_Email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("User_Email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("User_Email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("User_Email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("User_Email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("User_Email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("User_Phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("User_Phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("User_Phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("User_Phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("User_Phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("User_Phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("User_Phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("User_Phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("User_Phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("User_Phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("User_Phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("User_Phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("User_Phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("User_Phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andSalsmanIsNull() {
            addCriterion("Salsman is null");
            return (Criteria) this;
        }

        public Criteria andSalsmanIsNotNull() {
            addCriterion("Salsman is not null");
            return (Criteria) this;
        }

        public Criteria andSalsmanEqualTo(String value) {
            addCriterion("Salsman =", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanNotEqualTo(String value) {
            addCriterion("Salsman <>", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanGreaterThan(String value) {
            addCriterion("Salsman >", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanGreaterThanOrEqualTo(String value) {
            addCriterion("Salsman >=", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanLessThan(String value) {
            addCriterion("Salsman <", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanLessThanOrEqualTo(String value) {
            addCriterion("Salsman <=", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanLike(String value) {
            addCriterion("Salsman like", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanNotLike(String value) {
            addCriterion("Salsman not like", value, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanIn(List<String> values) {
            addCriterion("Salsman in", values, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanNotIn(List<String> values) {
            addCriterion("Salsman not in", values, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanBetween(String value1, String value2) {
            addCriterion("Salsman between", value1, value2, "salsman");
            return (Criteria) this;
        }

        public Criteria andSalsmanNotBetween(String value1, String value2) {
            addCriterion("Salsman not between", value1, value2, "salsman");
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

        public Criteria andValidFlagIsNull() {
            addCriterion("Valid_Flag is null");
            return (Criteria) this;
        }

        public Criteria andValidFlagIsNotNull() {
            addCriterion("Valid_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andValidFlagEqualTo(Short value) {
            addCriterion("Valid_Flag =", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotEqualTo(Short value) {
            addCriterion("Valid_Flag <>", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThan(Short value) {
            addCriterion("Valid_Flag >", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("Valid_Flag >=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThan(Short value) {
            addCriterion("Valid_Flag <", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagLessThanOrEqualTo(Short value) {
            addCriterion("Valid_Flag <=", value, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagIn(List<Short> values) {
            addCriterion("Valid_Flag in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotIn(List<Short> values) {
            addCriterion("Valid_Flag not in", values, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagBetween(Short value1, Short value2) {
            addCriterion("Valid_Flag between", value1, value2, "validFlag");
            return (Criteria) this;
        }

        public Criteria andValidFlagNotBetween(Short value1, Short value2) {
            addCriterion("Valid_Flag not between", value1, value2, "validFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagIsNull() {
            addCriterion("Oper_Flag is null");
            return (Criteria) this;
        }

        public Criteria andOperFlagIsNotNull() {
            addCriterion("Oper_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andOperFlagEqualTo(Short value) {
            addCriterion("Oper_Flag =", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagNotEqualTo(Short value) {
            addCriterion("Oper_Flag <>", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagGreaterThan(Short value) {
            addCriterion("Oper_Flag >", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("Oper_Flag >=", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagLessThan(Short value) {
            addCriterion("Oper_Flag <", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagLessThanOrEqualTo(Short value) {
            addCriterion("Oper_Flag <=", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagIn(List<Short> values) {
            addCriterion("Oper_Flag in", values, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagNotIn(List<Short> values) {
            addCriterion("Oper_Flag not in", values, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagBetween(Short value1, Short value2) {
            addCriterion("Oper_Flag between", value1, value2, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagNotBetween(Short value1, Short value2) {
            addCriterion("Oper_Flag not between", value1, value2, "operFlag");
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

        public Criteria andCrmUserCodeIsNull() {
            addCriterion("Crm_User_Code is null");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeIsNotNull() {
            addCriterion("Crm_User_Code is not null");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeEqualTo(String value) {
            addCriterion("Crm_User_Code =", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeNotEqualTo(String value) {
            addCriterion("Crm_User_Code <>", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeGreaterThan(String value) {
            addCriterion("Crm_User_Code >", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Crm_User_Code >=", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeLessThan(String value) {
            addCriterion("Crm_User_Code <", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeLessThanOrEqualTo(String value) {
            addCriterion("Crm_User_Code <=", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeLike(String value) {
            addCriterion("Crm_User_Code like", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeNotLike(String value) {
            addCriterion("Crm_User_Code not like", value, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeIn(List<String> values) {
            addCriterion("Crm_User_Code in", values, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeNotIn(List<String> values) {
            addCriterion("Crm_User_Code not in", values, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeBetween(String value1, String value2) {
            addCriterion("Crm_User_Code between", value1, value2, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmUserCodeNotBetween(String value1, String value2) {
            addCriterion("Crm_User_Code not between", value1, value2, "crmUserCode");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnIsNull() {
            addCriterion("Crm_Cust_SN is null");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnIsNotNull() {
            addCriterion("Crm_Cust_SN is not null");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnEqualTo(String value) {
            addCriterion("Crm_Cust_SN =", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnNotEqualTo(String value) {
            addCriterion("Crm_Cust_SN <>", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnGreaterThan(String value) {
            addCriterion("Crm_Cust_SN >", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnGreaterThanOrEqualTo(String value) {
            addCriterion("Crm_Cust_SN >=", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnLessThan(String value) {
            addCriterion("Crm_Cust_SN <", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnLessThanOrEqualTo(String value) {
            addCriterion("Crm_Cust_SN <=", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnLike(String value) {
            addCriterion("Crm_Cust_SN like", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnNotLike(String value) {
            addCriterion("Crm_Cust_SN not like", value, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnIn(List<String> values) {
            addCriterion("Crm_Cust_SN in", values, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnNotIn(List<String> values) {
            addCriterion("Crm_Cust_SN not in", values, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnBetween(String value1, String value2) {
            addCriterion("Crm_Cust_SN between", value1, value2, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmCustSnNotBetween(String value1, String value2) {
            addCriterion("Crm_Cust_SN not between", value1, value2, "crmCustSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnIsNull() {
            addCriterion("Crm_Acct_Sn is null");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnIsNotNull() {
            addCriterion("Crm_Acct_Sn is not null");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnEqualTo(String value) {
            addCriterion("Crm_Acct_Sn =", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnNotEqualTo(String value) {
            addCriterion("Crm_Acct_Sn <>", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnGreaterThan(String value) {
            addCriterion("Crm_Acct_Sn >", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnGreaterThanOrEqualTo(String value) {
            addCriterion("Crm_Acct_Sn >=", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnLessThan(String value) {
            addCriterion("Crm_Acct_Sn <", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnLessThanOrEqualTo(String value) {
            addCriterion("Crm_Acct_Sn <=", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnLike(String value) {
            addCriterion("Crm_Acct_Sn like", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnNotLike(String value) {
            addCriterion("Crm_Acct_Sn not like", value, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnIn(List<String> values) {
            addCriterion("Crm_Acct_Sn in", values, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnNotIn(List<String> values) {
            addCriterion("Crm_Acct_Sn not in", values, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnBetween(String value1, String value2) {
            addCriterion("Crm_Acct_Sn between", value1, value2, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmAcctSnNotBetween(String value1, String value2) {
            addCriterion("Crm_Acct_Sn not between", value1, value2, "crmAcctSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnIsNull() {
            addCriterion("Crm_User_Sn is null");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnIsNotNull() {
            addCriterion("Crm_User_Sn is not null");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnEqualTo(String value) {
            addCriterion("Crm_User_Sn =", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnNotEqualTo(String value) {
            addCriterion("Crm_User_Sn <>", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnGreaterThan(String value) {
            addCriterion("Crm_User_Sn >", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnGreaterThanOrEqualTo(String value) {
            addCriterion("Crm_User_Sn >=", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnLessThan(String value) {
            addCriterion("Crm_User_Sn <", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnLessThanOrEqualTo(String value) {
            addCriterion("Crm_User_Sn <=", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnLike(String value) {
            addCriterion("Crm_User_Sn like", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnNotLike(String value) {
            addCriterion("Crm_User_Sn not like", value, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnIn(List<String> values) {
            addCriterion("Crm_User_Sn in", values, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnNotIn(List<String> values) {
            addCriterion("Crm_User_Sn not in", values, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnBetween(String value1, String value2) {
            addCriterion("Crm_User_Sn between", value1, value2, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andCrmUserSnNotBetween(String value1, String value2) {
            addCriterion("Crm_User_Sn not between", value1, value2, "crmUserSn");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNull() {
            addCriterion("Agent_Level is null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNotNull() {
            addCriterion("Agent_Level is not null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelEqualTo(Integer value) {
            addCriterion("Agent_Level =", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotEqualTo(Integer value) {
            addCriterion("Agent_Level <>", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThan(Integer value) {
            addCriterion("Agent_Level >", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("Agent_Level >=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThan(Integer value) {
            addCriterion("Agent_Level <", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("Agent_Level <=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIn(List<Integer> values) {
            addCriterion("Agent_Level in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotIn(List<Integer> values) {
            addCriterion("Agent_Level not in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelBetween(Integer value1, Integer value2) {
            addCriterion("Agent_Level between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("Agent_Level not between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("Manager_Id is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("Manager_Id is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(String value) {
            addCriterion("Manager_Id =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(String value) {
            addCriterion("Manager_Id <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(String value) {
            addCriterion("Manager_Id >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(String value) {
            addCriterion("Manager_Id >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(String value) {
            addCriterion("Manager_Id <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(String value) {
            addCriterion("Manager_Id <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLike(String value) {
            addCriterion("Manager_Id like", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotLike(String value) {
            addCriterion("Manager_Id not like", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<String> values) {
            addCriterion("Manager_Id in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<String> values) {
            addCriterion("Manager_Id not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(String value1, String value2) {
            addCriterion("Manager_Id between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(String value1, String value2) {
            addCriterion("Manager_Id not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIsNull() {
            addCriterion("Vip_Level is null");
            return (Criteria) this;
        }

        public Criteria andVipLevelIsNotNull() {
            addCriterion("Vip_Level is not null");
            return (Criteria) this;
        }

        public Criteria andVipLevelEqualTo(Short value) {
            addCriterion("Vip_Level =", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelNotEqualTo(Short value) {
            addCriterion("Vip_Level <>", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelGreaterThan(Short value) {
            addCriterion("Vip_Level >", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("Vip_Level >=", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelLessThan(Short value) {
            addCriterion("Vip_Level <", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelLessThanOrEqualTo(Short value) {
            addCriterion("Vip_Level <=", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelIn(List<Short> values) {
            addCriterion("Vip_Level in", values, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelNotIn(List<Short> values) {
            addCriterion("Vip_Level not in", values, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelBetween(Short value1, Short value2) {
            addCriterion("Vip_Level between", value1, value2, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelNotBetween(Short value1, Short value2) {
            addCriterion("Vip_Level not between", value1, value2, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andSnapFlagIsNull() {
            addCriterion("Snap_Flag is null");
            return (Criteria) this;
        }

        public Criteria andSnapFlagIsNotNull() {
            addCriterion("Snap_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andSnapFlagEqualTo(Short value) {
            addCriterion("Snap_Flag =", value, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagNotEqualTo(Short value) {
            addCriterion("Snap_Flag <>", value, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagGreaterThan(Short value) {
            addCriterion("Snap_Flag >", value, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("Snap_Flag >=", value, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagLessThan(Short value) {
            addCriterion("Snap_Flag <", value, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagLessThanOrEqualTo(Short value) {
            addCriterion("Snap_Flag <=", value, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagIn(List<Short> values) {
            addCriterion("Snap_Flag in", values, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagNotIn(List<Short> values) {
            addCriterion("Snap_Flag not in", values, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagBetween(Short value1, Short value2) {
            addCriterion("Snap_Flag between", value1, value2, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapFlagNotBetween(Short value1, Short value2) {
            addCriterion("Snap_Flag not between", value1, value2, "snapFlag");
            return (Criteria) this;
        }

        public Criteria andSnapVerIsNull() {
            addCriterion("Snap_Ver is null");
            return (Criteria) this;
        }

        public Criteria andSnapVerIsNotNull() {
            addCriterion("Snap_Ver is not null");
            return (Criteria) this;
        }

        public Criteria andSnapVerEqualTo(Short value) {
            addCriterion("Snap_Ver =", value, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerNotEqualTo(Short value) {
            addCriterion("Snap_Ver <>", value, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerGreaterThan(Short value) {
            addCriterion("Snap_Ver >", value, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerGreaterThanOrEqualTo(Short value) {
            addCriterion("Snap_Ver >=", value, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerLessThan(Short value) {
            addCriterion("Snap_Ver <", value, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerLessThanOrEqualTo(Short value) {
            addCriterion("Snap_Ver <=", value, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerIn(List<Short> values) {
            addCriterion("Snap_Ver in", values, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerNotIn(List<Short> values) {
            addCriterion("Snap_Ver not in", values, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerBetween(Short value1, Short value2) {
            addCriterion("Snap_Ver between", value1, value2, "snapVer");
            return (Criteria) this;
        }

        public Criteria andSnapVerNotBetween(Short value1, Short value2) {
            addCriterion("Snap_Ver not between", value1, value2, "snapVer");
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
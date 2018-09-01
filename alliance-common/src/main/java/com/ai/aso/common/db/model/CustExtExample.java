package com.ai.aso.common.db.model;

import java.util.ArrayList;
import java.util.List;

public class CustExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustExtExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("Company_Name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("Company_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("Company_Name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("Company_Name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("Company_Name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("Company_Name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("Company_Name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("Company_Name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("Company_Name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("Company_Name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("Company_Name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("Company_Name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("Company_Name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("Company_Name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNull() {
            addCriterion("Company_Type is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("Company_Type is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(Short value) {
            addCriterion("Company_Type =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(Short value) {
            addCriterion("Company_Type <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(Short value) {
            addCriterion("Company_Type >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("Company_Type >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(Short value) {
            addCriterion("Company_Type <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(Short value) {
            addCriterion("Company_Type <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<Short> values) {
            addCriterion("Company_Type in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<Short> values) {
            addCriterion("Company_Type not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(Short value1, Short value2) {
            addCriterion("Company_Type between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(Short value1, Short value2) {
            addCriterion("Company_Type not between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andLegelNameIsNull() {
            addCriterion("Legel_Name is null");
            return (Criteria) this;
        }

        public Criteria andLegelNameIsNotNull() {
            addCriterion("Legel_Name is not null");
            return (Criteria) this;
        }

        public Criteria andLegelNameEqualTo(String value) {
            addCriterion("Legel_Name =", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameNotEqualTo(String value) {
            addCriterion("Legel_Name <>", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameGreaterThan(String value) {
            addCriterion("Legel_Name >", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameGreaterThanOrEqualTo(String value) {
            addCriterion("Legel_Name >=", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameLessThan(String value) {
            addCriterion("Legel_Name <", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameLessThanOrEqualTo(String value) {
            addCriterion("Legel_Name <=", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameLike(String value) {
            addCriterion("Legel_Name like", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameNotLike(String value) {
            addCriterion("Legel_Name not like", value, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameIn(List<String> values) {
            addCriterion("Legel_Name in", values, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameNotIn(List<String> values) {
            addCriterion("Legel_Name not in", values, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameBetween(String value1, String value2) {
            addCriterion("Legel_Name between", value1, value2, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelNameNotBetween(String value1, String value2) {
            addCriterion("Legel_Name not between", value1, value2, "legelName");
            return (Criteria) this;
        }

        public Criteria andLegelCertIsNull() {
            addCriterion("Legel_Cert is null");
            return (Criteria) this;
        }

        public Criteria andLegelCertIsNotNull() {
            addCriterion("Legel_Cert is not null");
            return (Criteria) this;
        }

        public Criteria andLegelCertEqualTo(String value) {
            addCriterion("Legel_Cert =", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertNotEqualTo(String value) {
            addCriterion("Legel_Cert <>", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertGreaterThan(String value) {
            addCriterion("Legel_Cert >", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertGreaterThanOrEqualTo(String value) {
            addCriterion("Legel_Cert >=", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertLessThan(String value) {
            addCriterion("Legel_Cert <", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertLessThanOrEqualTo(String value) {
            addCriterion("Legel_Cert <=", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertLike(String value) {
            addCriterion("Legel_Cert like", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertNotLike(String value) {
            addCriterion("Legel_Cert not like", value, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertIn(List<String> values) {
            addCriterion("Legel_Cert in", values, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertNotIn(List<String> values) {
            addCriterion("Legel_Cert not in", values, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertBetween(String value1, String value2) {
            addCriterion("Legel_Cert between", value1, value2, "legelCert");
            return (Criteria) this;
        }

        public Criteria andLegelCertNotBetween(String value1, String value2) {
            addCriterion("Legel_Cert not between", value1, value2, "legelCert");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerIsNull() {
            addCriterion("Is_Taxpayer is null");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerIsNotNull() {
            addCriterion("Is_Taxpayer is not null");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerEqualTo(Short value) {
            addCriterion("Is_Taxpayer =", value, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerNotEqualTo(Short value) {
            addCriterion("Is_Taxpayer <>", value, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerGreaterThan(Short value) {
            addCriterion("Is_Taxpayer >", value, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerGreaterThanOrEqualTo(Short value) {
            addCriterion("Is_Taxpayer >=", value, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerLessThan(Short value) {
            addCriterion("Is_Taxpayer <", value, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerLessThanOrEqualTo(Short value) {
            addCriterion("Is_Taxpayer <=", value, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerIn(List<Short> values) {
            addCriterion("Is_Taxpayer in", values, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerNotIn(List<Short> values) {
            addCriterion("Is_Taxpayer not in", values, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerBetween(Short value1, Short value2) {
            addCriterion("Is_Taxpayer between", value1, value2, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andIsTaxpayerNotBetween(Short value1, Short value2) {
            addCriterion("Is_Taxpayer not between", value1, value2, "isTaxpayer");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNull() {
            addCriterion("Certificate is null");
            return (Criteria) this;
        }

        public Criteria andCertificateIsNotNull() {
            addCriterion("Certificate is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateEqualTo(String value) {
            addCriterion("Certificate =", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotEqualTo(String value) {
            addCriterion("Certificate <>", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThan(String value) {
            addCriterion("Certificate >", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("Certificate >=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThan(String value) {
            addCriterion("Certificate <", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLessThanOrEqualTo(String value) {
            addCriterion("Certificate <=", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateLike(String value) {
            addCriterion("Certificate like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotLike(String value) {
            addCriterion("Certificate not like", value, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateIn(List<String> values) {
            addCriterion("Certificate in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotIn(List<String> values) {
            addCriterion("Certificate not in", values, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateBetween(String value1, String value2) {
            addCriterion("Certificate between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCertificateNotBetween(String value1, String value2) {
            addCriterion("Certificate not between", value1, value2, "certificate");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNull() {
            addCriterion("Company_Addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNotNull() {
            addCriterion("Company_Addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrEqualTo(String value) {
            addCriterion("Company_Addr =", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotEqualTo(String value) {
            addCriterion("Company_Addr <>", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThan(String value) {
            addCriterion("Company_Addr >", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThanOrEqualTo(String value) {
            addCriterion("Company_Addr >=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThan(String value) {
            addCriterion("Company_Addr <", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThanOrEqualTo(String value) {
            addCriterion("Company_Addr <=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLike(String value) {
            addCriterion("Company_Addr like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotLike(String value) {
            addCriterion("Company_Addr not like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIn(List<String> values) {
            addCriterion("Company_Addr in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotIn(List<String> values) {
            addCriterion("Company_Addr not in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrBetween(String value1, String value2) {
            addCriterion("Company_Addr between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotBetween(String value1, String value2) {
            addCriterion("Company_Addr not between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIsNull() {
            addCriterion("Company_Phone is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIsNotNull() {
            addCriterion("Company_Phone is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneEqualTo(String value) {
            addCriterion("Company_Phone =", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotEqualTo(String value) {
            addCriterion("Company_Phone <>", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneGreaterThan(String value) {
            addCriterion("Company_Phone >", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Company_Phone >=", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLessThan(String value) {
            addCriterion("Company_Phone <", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLessThanOrEqualTo(String value) {
            addCriterion("Company_Phone <=", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneLike(String value) {
            addCriterion("Company_Phone like", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotLike(String value) {
            addCriterion("Company_Phone not like", value, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneIn(List<String> values) {
            addCriterion("Company_Phone in", values, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotIn(List<String> values) {
            addCriterion("Company_Phone not in", values, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneBetween(String value1, String value2) {
            addCriterion("Company_Phone between", value1, value2, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyPhoneNotBetween(String value1, String value2) {
            addCriterion("Company_Phone not between", value1, value2, "companyPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlIsNull() {
            addCriterion("Company_Url is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlIsNotNull() {
            addCriterion("Company_Url is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlEqualTo(String value) {
            addCriterion("Company_Url =", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlNotEqualTo(String value) {
            addCriterion("Company_Url <>", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlGreaterThan(String value) {
            addCriterion("Company_Url >", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("Company_Url >=", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlLessThan(String value) {
            addCriterion("Company_Url <", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlLessThanOrEqualTo(String value) {
            addCriterion("Company_Url <=", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlLike(String value) {
            addCriterion("Company_Url like", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlNotLike(String value) {
            addCriterion("Company_Url not like", value, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlIn(List<String> values) {
            addCriterion("Company_Url in", values, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlNotIn(List<String> values) {
            addCriterion("Company_Url not in", values, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlBetween(String value1, String value2) {
            addCriterion("Company_Url between", value1, value2, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyUrlNotBetween(String value1, String value2) {
            addCriterion("Company_Url not between", value1, value2, "companyUrl");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("Bank_Name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("Bank_Name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("Bank_Name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("Bank_Name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("Bank_Name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("Bank_Name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("Bank_Name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("Bank_Name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("Bank_Name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("Bank_Name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("Bank_Name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("Bank_Name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("Bank_Name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("Bank_Name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("Bank_Code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("Bank_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("Bank_Code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("Bank_Code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("Bank_Code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Bank_Code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("Bank_Code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("Bank_Code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("Bank_Code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("Bank_Code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("Bank_Code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("Bank_Code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("Bank_Code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("Bank_Code not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01IsNull() {
            addCriterion("Company_Ext01 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01IsNotNull() {
            addCriterion("Company_Ext01 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01EqualTo(String value) {
            addCriterion("Company_Ext01 =", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01NotEqualTo(String value) {
            addCriterion("Company_Ext01 <>", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01GreaterThan(String value) {
            addCriterion("Company_Ext01 >", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext01 >=", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01LessThan(String value) {
            addCriterion("Company_Ext01 <", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext01 <=", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01Like(String value) {
            addCriterion("Company_Ext01 like", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01NotLike(String value) {
            addCriterion("Company_Ext01 not like", value, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01In(List<String> values) {
            addCriterion("Company_Ext01 in", values, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01NotIn(List<String> values) {
            addCriterion("Company_Ext01 not in", values, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01Between(String value1, String value2) {
            addCriterion("Company_Ext01 between", value1, value2, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt01NotBetween(String value1, String value2) {
            addCriterion("Company_Ext01 not between", value1, value2, "companyExt01");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02IsNull() {
            addCriterion("Company_Ext02 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02IsNotNull() {
            addCriterion("Company_Ext02 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02EqualTo(String value) {
            addCriterion("Company_Ext02 =", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02NotEqualTo(String value) {
            addCriterion("Company_Ext02 <>", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02GreaterThan(String value) {
            addCriterion("Company_Ext02 >", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext02 >=", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02LessThan(String value) {
            addCriterion("Company_Ext02 <", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext02 <=", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02Like(String value) {
            addCriterion("Company_Ext02 like", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02NotLike(String value) {
            addCriterion("Company_Ext02 not like", value, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02In(List<String> values) {
            addCriterion("Company_Ext02 in", values, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02NotIn(List<String> values) {
            addCriterion("Company_Ext02 not in", values, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02Between(String value1, String value2) {
            addCriterion("Company_Ext02 between", value1, value2, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt02NotBetween(String value1, String value2) {
            addCriterion("Company_Ext02 not between", value1, value2, "companyExt02");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03IsNull() {
            addCriterion("Company_Ext03 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03IsNotNull() {
            addCriterion("Company_Ext03 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03EqualTo(String value) {
            addCriterion("Company_Ext03 =", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03NotEqualTo(String value) {
            addCriterion("Company_Ext03 <>", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03GreaterThan(String value) {
            addCriterion("Company_Ext03 >", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext03 >=", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03LessThan(String value) {
            addCriterion("Company_Ext03 <", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext03 <=", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03Like(String value) {
            addCriterion("Company_Ext03 like", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03NotLike(String value) {
            addCriterion("Company_Ext03 not like", value, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03In(List<String> values) {
            addCriterion("Company_Ext03 in", values, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03NotIn(List<String> values) {
            addCriterion("Company_Ext03 not in", values, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03Between(String value1, String value2) {
            addCriterion("Company_Ext03 between", value1, value2, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt03NotBetween(String value1, String value2) {
            addCriterion("Company_Ext03 not between", value1, value2, "companyExt03");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04IsNull() {
            addCriterion("Company_Ext04 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04IsNotNull() {
            addCriterion("Company_Ext04 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04EqualTo(String value) {
            addCriterion("Company_Ext04 =", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04NotEqualTo(String value) {
            addCriterion("Company_Ext04 <>", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04GreaterThan(String value) {
            addCriterion("Company_Ext04 >", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext04 >=", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04LessThan(String value) {
            addCriterion("Company_Ext04 <", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext04 <=", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04Like(String value) {
            addCriterion("Company_Ext04 like", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04NotLike(String value) {
            addCriterion("Company_Ext04 not like", value, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04In(List<String> values) {
            addCriterion("Company_Ext04 in", values, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04NotIn(List<String> values) {
            addCriterion("Company_Ext04 not in", values, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04Between(String value1, String value2) {
            addCriterion("Company_Ext04 between", value1, value2, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt04NotBetween(String value1, String value2) {
            addCriterion("Company_Ext04 not between", value1, value2, "companyExt04");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05IsNull() {
            addCriterion("Company_Ext05 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05IsNotNull() {
            addCriterion("Company_Ext05 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05EqualTo(String value) {
            addCriterion("Company_Ext05 =", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05NotEqualTo(String value) {
            addCriterion("Company_Ext05 <>", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05GreaterThan(String value) {
            addCriterion("Company_Ext05 >", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext05 >=", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05LessThan(String value) {
            addCriterion("Company_Ext05 <", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext05 <=", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05Like(String value) {
            addCriterion("Company_Ext05 like", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05NotLike(String value) {
            addCriterion("Company_Ext05 not like", value, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05In(List<String> values) {
            addCriterion("Company_Ext05 in", values, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05NotIn(List<String> values) {
            addCriterion("Company_Ext05 not in", values, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05Between(String value1, String value2) {
            addCriterion("Company_Ext05 between", value1, value2, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt05NotBetween(String value1, String value2) {
            addCriterion("Company_Ext05 not between", value1, value2, "companyExt05");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06IsNull() {
            addCriterion("Company_Ext06 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06IsNotNull() {
            addCriterion("Company_Ext06 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06EqualTo(String value) {
            addCriterion("Company_Ext06 =", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06NotEqualTo(String value) {
            addCriterion("Company_Ext06 <>", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06GreaterThan(String value) {
            addCriterion("Company_Ext06 >", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext06 >=", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06LessThan(String value) {
            addCriterion("Company_Ext06 <", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext06 <=", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06Like(String value) {
            addCriterion("Company_Ext06 like", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06NotLike(String value) {
            addCriterion("Company_Ext06 not like", value, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06In(List<String> values) {
            addCriterion("Company_Ext06 in", values, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06NotIn(List<String> values) {
            addCriterion("Company_Ext06 not in", values, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06Between(String value1, String value2) {
            addCriterion("Company_Ext06 between", value1, value2, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt06NotBetween(String value1, String value2) {
            addCriterion("Company_Ext06 not between", value1, value2, "companyExt06");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07IsNull() {
            addCriterion("Company_Ext07 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07IsNotNull() {
            addCriterion("Company_Ext07 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07EqualTo(String value) {
            addCriterion("Company_Ext07 =", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07NotEqualTo(String value) {
            addCriterion("Company_Ext07 <>", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07GreaterThan(String value) {
            addCriterion("Company_Ext07 >", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext07 >=", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07LessThan(String value) {
            addCriterion("Company_Ext07 <", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext07 <=", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07Like(String value) {
            addCriterion("Company_Ext07 like", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07NotLike(String value) {
            addCriterion("Company_Ext07 not like", value, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07In(List<String> values) {
            addCriterion("Company_Ext07 in", values, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07NotIn(List<String> values) {
            addCriterion("Company_Ext07 not in", values, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07Between(String value1, String value2) {
            addCriterion("Company_Ext07 between", value1, value2, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt07NotBetween(String value1, String value2) {
            addCriterion("Company_Ext07 not between", value1, value2, "companyExt07");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08IsNull() {
            addCriterion("Company_Ext08 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08IsNotNull() {
            addCriterion("Company_Ext08 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08EqualTo(String value) {
            addCriterion("Company_Ext08 =", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08NotEqualTo(String value) {
            addCriterion("Company_Ext08 <>", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08GreaterThan(String value) {
            addCriterion("Company_Ext08 >", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext08 >=", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08LessThan(String value) {
            addCriterion("Company_Ext08 <", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext08 <=", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08Like(String value) {
            addCriterion("Company_Ext08 like", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08NotLike(String value) {
            addCriterion("Company_Ext08 not like", value, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08In(List<String> values) {
            addCriterion("Company_Ext08 in", values, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08NotIn(List<String> values) {
            addCriterion("Company_Ext08 not in", values, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08Between(String value1, String value2) {
            addCriterion("Company_Ext08 between", value1, value2, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt08NotBetween(String value1, String value2) {
            addCriterion("Company_Ext08 not between", value1, value2, "companyExt08");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09IsNull() {
            addCriterion("Company_Ext09 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09IsNotNull() {
            addCriterion("Company_Ext09 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09EqualTo(String value) {
            addCriterion("Company_Ext09 =", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09NotEqualTo(String value) {
            addCriterion("Company_Ext09 <>", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09GreaterThan(String value) {
            addCriterion("Company_Ext09 >", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext09 >=", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09LessThan(String value) {
            addCriterion("Company_Ext09 <", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext09 <=", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09Like(String value) {
            addCriterion("Company_Ext09 like", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09NotLike(String value) {
            addCriterion("Company_Ext09 not like", value, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09In(List<String> values) {
            addCriterion("Company_Ext09 in", values, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09NotIn(List<String> values) {
            addCriterion("Company_Ext09 not in", values, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09Between(String value1, String value2) {
            addCriterion("Company_Ext09 between", value1, value2, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt09NotBetween(String value1, String value2) {
            addCriterion("Company_Ext09 not between", value1, value2, "companyExt09");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10IsNull() {
            addCriterion("Company_Ext10 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10IsNotNull() {
            addCriterion("Company_Ext10 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10EqualTo(String value) {
            addCriterion("Company_Ext10 =", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10NotEqualTo(String value) {
            addCriterion("Company_Ext10 <>", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10GreaterThan(String value) {
            addCriterion("Company_Ext10 >", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext10 >=", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10LessThan(String value) {
            addCriterion("Company_Ext10 <", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext10 <=", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10Like(String value) {
            addCriterion("Company_Ext10 like", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10NotLike(String value) {
            addCriterion("Company_Ext10 not like", value, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10In(List<String> values) {
            addCriterion("Company_Ext10 in", values, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10NotIn(List<String> values) {
            addCriterion("Company_Ext10 not in", values, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10Between(String value1, String value2) {
            addCriterion("Company_Ext10 between", value1, value2, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt10NotBetween(String value1, String value2) {
            addCriterion("Company_Ext10 not between", value1, value2, "companyExt10");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11IsNull() {
            addCriterion("Company_Ext11 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11IsNotNull() {
            addCriterion("Company_Ext11 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11EqualTo(String value) {
            addCriterion("Company_Ext11 =", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11NotEqualTo(String value) {
            addCriterion("Company_Ext11 <>", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11GreaterThan(String value) {
            addCriterion("Company_Ext11 >", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext11 >=", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11LessThan(String value) {
            addCriterion("Company_Ext11 <", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext11 <=", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11Like(String value) {
            addCriterion("Company_Ext11 like", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11NotLike(String value) {
            addCriterion("Company_Ext11 not like", value, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11In(List<String> values) {
            addCriterion("Company_Ext11 in", values, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11NotIn(List<String> values) {
            addCriterion("Company_Ext11 not in", values, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11Between(String value1, String value2) {
            addCriterion("Company_Ext11 between", value1, value2, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt11NotBetween(String value1, String value2) {
            addCriterion("Company_Ext11 not between", value1, value2, "companyExt11");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12IsNull() {
            addCriterion("Company_Ext12 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12IsNotNull() {
            addCriterion("Company_Ext12 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12EqualTo(String value) {
            addCriterion("Company_Ext12 =", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12NotEqualTo(String value) {
            addCriterion("Company_Ext12 <>", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12GreaterThan(String value) {
            addCriterion("Company_Ext12 >", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext12 >=", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12LessThan(String value) {
            addCriterion("Company_Ext12 <", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext12 <=", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12Like(String value) {
            addCriterion("Company_Ext12 like", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12NotLike(String value) {
            addCriterion("Company_Ext12 not like", value, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12In(List<String> values) {
            addCriterion("Company_Ext12 in", values, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12NotIn(List<String> values) {
            addCriterion("Company_Ext12 not in", values, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12Between(String value1, String value2) {
            addCriterion("Company_Ext12 between", value1, value2, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt12NotBetween(String value1, String value2) {
            addCriterion("Company_Ext12 not between", value1, value2, "companyExt12");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13IsNull() {
            addCriterion("Company_Ext13 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13IsNotNull() {
            addCriterion("Company_Ext13 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13EqualTo(String value) {
            addCriterion("Company_Ext13 =", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13NotEqualTo(String value) {
            addCriterion("Company_Ext13 <>", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13GreaterThan(String value) {
            addCriterion("Company_Ext13 >", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext13 >=", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13LessThan(String value) {
            addCriterion("Company_Ext13 <", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext13 <=", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13Like(String value) {
            addCriterion("Company_Ext13 like", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13NotLike(String value) {
            addCriterion("Company_Ext13 not like", value, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13In(List<String> values) {
            addCriterion("Company_Ext13 in", values, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13NotIn(List<String> values) {
            addCriterion("Company_Ext13 not in", values, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13Between(String value1, String value2) {
            addCriterion("Company_Ext13 between", value1, value2, "companyExt13");
            return (Criteria) this;
        }

        public Criteria andCompanyExt13NotBetween(String value1, String value2) {
            addCriterion("Company_Ext13 not between", value1, value2, "companyExt13");
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

        public Criteria andCompanyExt14IsNull() {
            addCriterion("Company_Ext14 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14IsNotNull() {
            addCriterion("Company_Ext14 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14EqualTo(String value) {
            addCriterion("Company_Ext14 =", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14NotEqualTo(String value) {
            addCriterion("Company_Ext14 <>", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14GreaterThan(String value) {
            addCriterion("Company_Ext14 >", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext14 >=", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14LessThan(String value) {
            addCriterion("Company_Ext14 <", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext14 <=", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14Like(String value) {
            addCriterion("Company_Ext14 like", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14NotLike(String value) {
            addCriterion("Company_Ext14 not like", value, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14In(List<String> values) {
            addCriterion("Company_Ext14 in", values, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14NotIn(List<String> values) {
            addCriterion("Company_Ext14 not in", values, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14Between(String value1, String value2) {
            addCriterion("Company_Ext14 between", value1, value2, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt14NotBetween(String value1, String value2) {
            addCriterion("Company_Ext14 not between", value1, value2, "companyExt14");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15IsNull() {
            addCriterion("Company_Ext15 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15IsNotNull() {
            addCriterion("Company_Ext15 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15EqualTo(String value) {
            addCriterion("Company_Ext15 =", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15NotEqualTo(String value) {
            addCriterion("Company_Ext15 <>", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15GreaterThan(String value) {
            addCriterion("Company_Ext15 >", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext15 >=", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15LessThan(String value) {
            addCriterion("Company_Ext15 <", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext15 <=", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15Like(String value) {
            addCriterion("Company_Ext15 like", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15NotLike(String value) {
            addCriterion("Company_Ext15 not like", value, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15In(List<String> values) {
            addCriterion("Company_Ext15 in", values, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15NotIn(List<String> values) {
            addCriterion("Company_Ext15 not in", values, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15Between(String value1, String value2) {
            addCriterion("Company_Ext15 between", value1, value2, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt15NotBetween(String value1, String value2) {
            addCriterion("Company_Ext15 not between", value1, value2, "companyExt15");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16IsNull() {
            addCriterion("Company_Ext16 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16IsNotNull() {
            addCriterion("Company_Ext16 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16EqualTo(String value) {
            addCriterion("Company_Ext16 =", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16NotEqualTo(String value) {
            addCriterion("Company_Ext16 <>", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16GreaterThan(String value) {
            addCriterion("Company_Ext16 >", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext16 >=", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16LessThan(String value) {
            addCriterion("Company_Ext16 <", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext16 <=", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16Like(String value) {
            addCriterion("Company_Ext16 like", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16NotLike(String value) {
            addCriterion("Company_Ext16 not like", value, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16In(List<String> values) {
            addCriterion("Company_Ext16 in", values, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16NotIn(List<String> values) {
            addCriterion("Company_Ext16 not in", values, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16Between(String value1, String value2) {
            addCriterion("Company_Ext16 between", value1, value2, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt16NotBetween(String value1, String value2) {
            addCriterion("Company_Ext16 not between", value1, value2, "companyExt16");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17IsNull() {
            addCriterion("Company_Ext17 is null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17IsNotNull() {
            addCriterion("Company_Ext17 is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17EqualTo(String value) {
            addCriterion("Company_Ext17 =", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17NotEqualTo(String value) {
            addCriterion("Company_Ext17 <>", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17GreaterThan(String value) {
            addCriterion("Company_Ext17 >", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17GreaterThanOrEqualTo(String value) {
            addCriterion("Company_Ext17 >=", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17LessThan(String value) {
            addCriterion("Company_Ext17 <", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17LessThanOrEqualTo(String value) {
            addCriterion("Company_Ext17 <=", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17Like(String value) {
            addCriterion("Company_Ext17 like", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17NotLike(String value) {
            addCriterion("Company_Ext17 not like", value, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17In(List<String> values) {
            addCriterion("Company_Ext17 in", values, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17NotIn(List<String> values) {
            addCriterion("Company_Ext17 not in", values, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17Between(String value1, String value2) {
            addCriterion("Company_Ext17 between", value1, value2, "companyExt17");
            return (Criteria) this;
        }

        public Criteria andCompanyExt17NotBetween(String value1, String value2) {
            addCriterion("Company_Ext17 not between", value1, value2, "companyExt17");
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
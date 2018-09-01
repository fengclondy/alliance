package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "B_CUST_EXT")
public class CustExt {
    private Long custExtId;

    private String companyName;

    private Short companyType;

    private String legelName;

    private String legelCert;

    private Short isTaxpayer;

    private String certificate;

    private String companyAddr;

    private String companyPhone;

    private String companyUrl;

    private String bankName;

    private String bankCode;

    private String companyExt01;

    private String companyExt02;

    private String companyExt03;

    private String companyExt04;

    private String companyExt05;

    private String companyExt06;

    private String companyExt07;

    private String companyExt08;

    private String companyExt09;

    private String companyExt10;

    private String companyExt11;

    private String companyExt12;

    private String companyExt13;

    private Short snapFlag;

    private Short snapVer;

    private String companyExt14;

    private String companyExt15;

    private String companyExt16;

    private String companyExt17;
    @Id
    public Long getCustExtId() {
        return custExtId;
    }

    public void setCustExtId(Long custExtId) {
        this.custExtId = custExtId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Short getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Short companyType) {
        this.companyType = companyType;
    }

    public String getLegelName() {
        return legelName;
    }

    public void setLegelName(String legelName) {
        this.legelName = legelName == null ? null : legelName.trim();
    }

    public String getLegelCert() {
        return legelCert;
    }

    public void setLegelCert(String legelCert) {
        this.legelCert = legelCert == null ? null : legelCert.trim();
    }

    public Short getIsTaxpayer() {
        return isTaxpayer;
    }

    public void setIsTaxpayer(Short isTaxpayer) {
        this.isTaxpayer = isTaxpayer;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl == null ? null : companyUrl.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getCompanyExt01() {
        return companyExt01;
    }

    public void setCompanyExt01(String companyExt01) {
        this.companyExt01 = companyExt01 == null ? null : companyExt01.trim();
    }

    public String getCompanyExt02() {
        return companyExt02;
    }

    public void setCompanyExt02(String companyExt02) {
        this.companyExt02 = companyExt02 == null ? null : companyExt02.trim();
    }

    public String getCompanyExt03() {
        return companyExt03;
    }

    public void setCompanyExt03(String companyExt03) {
        this.companyExt03 = companyExt03 == null ? null : companyExt03.trim();
    }

    public String getCompanyExt04() {
        return companyExt04;
    }

    public void setCompanyExt04(String companyExt04) {
        this.companyExt04 = companyExt04 == null ? null : companyExt04.trim();
    }

    public String getCompanyExt05() {
        return companyExt05;
    }

    public void setCompanyExt05(String companyExt05) {
        this.companyExt05 = companyExt05 == null ? null : companyExt05.trim();
    }

    public String getCompanyExt06() {
        return companyExt06;
    }

    public void setCompanyExt06(String companyExt06) {
        this.companyExt06 = companyExt06 == null ? null : companyExt06.trim();
    }

    public String getCompanyExt07() {
        return companyExt07;
    }

    public void setCompanyExt07(String companyExt07) {
        this.companyExt07 = companyExt07 == null ? null : companyExt07.trim();
    }

    public String getCompanyExt08() {
        return companyExt08;
    }

    public void setCompanyExt08(String companyExt08) {
        this.companyExt08 = companyExt08 == null ? null : companyExt08.trim();
    }

    public String getCompanyExt09() {
        return companyExt09;
    }

    public void setCompanyExt09(String companyExt09) {
        this.companyExt09 = companyExt09 == null ? null : companyExt09.trim();
    }

    public String getCompanyExt10() {
        return companyExt10;
    }

    public void setCompanyExt10(String companyExt10) {
        this.companyExt10 = companyExt10 == null ? null : companyExt10.trim();
    }

    public String getCompanyExt11() {
        return companyExt11;
    }

    public void setCompanyExt11(String companyExt11) {
        this.companyExt11 = companyExt11 == null ? null : companyExt11.trim();
    }

    public String getCompanyExt12() {
        return companyExt12;
    }

    public void setCompanyExt12(String companyExt12) {
        this.companyExt12 = companyExt12 == null ? null : companyExt12.trim();
    }

    public String getCompanyExt13() {
        return companyExt13;
    }

    public void setCompanyExt13(String companyExt13) {
        this.companyExt13 = companyExt13 == null ? null : companyExt13.trim();
    }

    public Short getSnapFlag() {
        return snapFlag;
    }

    public void setSnapFlag(Short snapFlag) {
        this.snapFlag = snapFlag;
    }

    public Short getSnapVer() {
        return snapVer;
    }

    public void setSnapVer(Short snapVer) {
        this.snapVer = snapVer;
    }

    public String getCompanyExt14() {
        return companyExt14;
    }

    public void setCompanyExt14(String companyExt14) {
        this.companyExt14 = companyExt14 == null ? null : companyExt14.trim();
    }

    public String getCompanyExt15() {
        return companyExt15;
    }

    public void setCompanyExt15(String companyExt15) {
        this.companyExt15 = companyExt15 == null ? null : companyExt15.trim();
    }

    public String getCompanyExt16() {
        return companyExt16;
    }

    public void setCompanyExt16(String companyExt16) {
        this.companyExt16 = companyExt16 == null ? null : companyExt16.trim();
    }

    public String getCompanyExt17() {
        return companyExt17;
    }

    public void setCompanyExt17(String companyExt17) {
        this.companyExt17 = companyExt17 == null ? null : companyExt17.trim();
    }
}
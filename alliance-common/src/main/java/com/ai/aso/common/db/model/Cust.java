package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Entity(name = "B_CUST")
public class Cust implements Serializable {

	private static final long serialVersionUID = 8453209216684842116L;

	private String custId;

    private String originCustId;

    private Long custExtId;

    private String acctId;

    private Short custType;

    private String custName;

    private String custNamePy;

    private String shortName;

    private Short certType;

    private String certNbr;

    private String regionId;

    private String custAddr;

    private String userName;

    private String userMobile;

    private String userEmail;

    private String userPhone;

    private String salsman;

    private Short state;

    private Short validFlag;

    private Short operFlag;

    private Date createDate;

    private Date modiDate;

    private String crmUserCode;

    private String crmCustSn;

    private String crmAcctSn;

    private String crmUserSn;

    private Integer agentLevel;

    private String managerId;

    private Short vipLevel;

    private Short snapFlag;

    private Short snapVer;

    private String ext1;

    private String ext2;

    private String ext3;
    @Id
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getOriginCustId() {
        return originCustId;
    }

    public void setOriginCustId(String originCustId) {
        this.originCustId = originCustId == null ? null : originCustId.trim();
    }

    public Long getCustExtId() {
        return custExtId;
    }

    public void setCustExtId(Long custExtId) {
        this.custExtId = custExtId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public Short getCustType() {
        return custType;
    }

    public void setCustType(Short custType) {
        this.custType = custType;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustNamePy() {
        return custNamePy;
    }

    public void setCustNamePy(String custNamePy) {
        this.custNamePy = custNamePy == null ? null : custNamePy.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public Short getCertType() {
        return certType;
    }

    public void setCertType(Short certType) {
        this.certType = certType;
    }

    public String getCertNbr() {
        return certNbr;
    }

    public void setCertNbr(String certNbr) {
        this.certNbr = certNbr == null ? null : certNbr.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr == null ? null : custAddr.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getSalsman() {
        return salsman;
    }

    public void setSalsman(String salsman) {
        this.salsman = salsman == null ? null : salsman.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Short getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Short validFlag) {
        this.validFlag = validFlag;
    }

    public Short getOperFlag() {
        return operFlag;
    }

    public void setOperFlag(Short operFlag) {
        this.operFlag = operFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    public String getCrmUserCode() {
        return crmUserCode;
    }

    public void setCrmUserCode(String crmUserCode) {
        this.crmUserCode = crmUserCode == null ? null : crmUserCode.trim();
    }

    public String getCrmCustSn() {
        return crmCustSn;
    }

    public void setCrmCustSn(String crmCustSn) {
        this.crmCustSn = crmCustSn == null ? null : crmCustSn.trim();
    }

    public String getCrmAcctSn() {
        return crmAcctSn;
    }

    public void setCrmAcctSn(String crmAcctSn) {
        this.crmAcctSn = crmAcctSn == null ? null : crmAcctSn.trim();
    }

    public String getCrmUserSn() {
        return crmUserSn;
    }

    public void setCrmUserSn(String crmUserSn) {
        this.crmUserSn = crmUserSn == null ? null : crmUserSn.trim();
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public Short getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Short vipLevel) {
        this.vipLevel = vipLevel;
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

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }
}
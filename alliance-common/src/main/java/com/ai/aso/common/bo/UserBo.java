package com.ai.aso.common.bo;

import com.ai.aso.common.db.model.User;

import java.util.Date;

/**
 * Created by wuqiang6 on 2016/9/20.
 */
public class UserBo {

    private String userId;

    private String acctId;

    private String username;

    private String mobile;

    private String email;

    private String phone;

    private String regionId;

    private String orgId;

    private Short state;

    private Date createDate;

    private Date modiDate;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;

    public UserBo() {

    }

    public UserBo(User user) {
        this.userId = user.getUserId();
        this.acctId = user.getAcctId();
        this.username = user.getUserName();
        this.mobile = user.getMobile();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.regionId = user.getRegionId();
        this.orgId = user.getOrgId();
        this.state = user.getState();
        this.createDate = user.getCreateDate();
        this.modiDate = user.getModiDate();
        this.ext1 = user.getExt1();
        this.ext2 = user.getExt2();
        this.ext3 = user.getExt3();
        this.ext4 = user.getExt4();
        this.ext5 = user.getExt5();

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
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

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }
}

package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity(name = "B_RESOURCES")
public class Resources {
    private Integer sourceId;

    private Integer parentId;

    private String menuName;

    private String menuIcon;

    private String sourName;

    private String sourDesc;

    private Integer sourType;

    private Integer showSeq;

    private String methodName;

    private String sourUrl;

    private String systemCode;

    private String modelCode;

    private Short isAuthen;

    private String accessAuthc;

    private String accessRole;

    private String accessPerm;

    private Integer accessInterval;

    private String accessFreque;

    private Short state;

    private Date createDate;

    private Date modiDate;

    private String hostGroups;

    private String ext1;

    private String ext2;
    @Id
    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getSourName() {
        return sourName;
    }

    public void setSourName(String sourName) {
        this.sourName = sourName == null ? null : sourName.trim();
    }

    public String getSourDesc() {
        return sourDesc;
    }

    public void setSourDesc(String sourDesc) {
        this.sourDesc = sourDesc == null ? null : sourDesc.trim();
    }

    public Integer getSourType() {
        return sourType;
    }

    public void setSourType(Integer sourType) {
        this.sourType = sourType;
    }

    public Integer getShowSeq() {
        return showSeq;
    }

    public void setShowSeq(Integer showSeq) {
        this.showSeq = showSeq;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getSourUrl() {
        return sourUrl;
    }

    public void setSourUrl(String sourUrl) {
        this.sourUrl = sourUrl == null ? null : sourUrl.trim();
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public Short getIsAuthen() {
        return isAuthen;
    }

    public void setIsAuthen(Short isAuthen) {
        this.isAuthen = isAuthen;
    }

    public String getAccessAuthc() {
        return accessAuthc;
    }

    public void setAccessAuthc(String accessAuthc) {
        this.accessAuthc = accessAuthc == null ? null : accessAuthc.trim();
    }

    public String getAccessRole() {
        return accessRole;
    }

    public void setAccessRole(String accessRole) {
        this.accessRole = accessRole == null ? null : accessRole.trim();
    }

    public String getAccessPerm() {
        return accessPerm;
    }

    public void setAccessPerm(String accessPerm) {
        this.accessPerm = accessPerm == null ? null : accessPerm.trim();
    }

    public Integer getAccessInterval() {
        return accessInterval;
    }

    public void setAccessInterval(Integer accessInterval) {
        this.accessInterval = accessInterval;
    }

    public String getAccessFreque() {
        return accessFreque;
    }

    public void setAccessFreque(String accessFreque) {
        this.accessFreque = accessFreque == null ? null : accessFreque.trim();
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

    public String getHostGroups() {
        return hostGroups;
    }

    public void setHostGroups(String hostGroups) {
        this.hostGroups = hostGroups == null ? null : hostGroups.trim();
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
}
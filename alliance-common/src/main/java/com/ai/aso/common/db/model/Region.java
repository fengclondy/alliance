package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "B_REGION")
public class Region {
    private Integer regionId;

    private Integer pRegionId;

    private String regionName;

    private String abbrName;

    private Short regionLevel;

    private Integer seqId;

    private Short state;

    private String regionCode;

    private String crmRegionCode;

    private String billRegionCode;

    private String fpsRegionCode;
    @Id
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getpRegionId() {
        return pRegionId;
    }

    public void setpRegionId(Integer pRegionId) {
        this.pRegionId = pRegionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName == null ? null : abbrName.trim();
    }

    public Short getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Short regionLevel) {
        this.regionLevel = regionLevel;
    }

    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    public String getCrmRegionCode() {
        return crmRegionCode;
    }

    public void setCrmRegionCode(String crmRegionCode) {
        this.crmRegionCode = crmRegionCode == null ? null : crmRegionCode.trim();
    }

    public String getBillRegionCode() {
        return billRegionCode;
    }

    public void setBillRegionCode(String billRegionCode) {
        this.billRegionCode = billRegionCode == null ? null : billRegionCode.trim();
    }

    public String getFpsRegionCode() {
        return fpsRegionCode;
    }

    public void setFpsRegionCode(String fpsRegionCode) {
        this.fpsRegionCode = fpsRegionCode == null ? null : fpsRegionCode.trim();
    }
}
package com.ai.aso.common.db.model;

public class AttrDef {
    private Integer attrId;

    private String attrPkgCode;

    private String attrCode;

    private String attrName;

    private String attrDesc;

    private Short attrSeq;

    private Short state;

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrPkgCode() {
        return attrPkgCode;
    }

    public void setAttrPkgCode(String attrPkgCode) {
        this.attrPkgCode = attrPkgCode == null ? null : attrPkgCode.trim();
    }

    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc == null ? null : attrDesc.trim();
    }

    public Short getAttrSeq() {
        return attrSeq;
    }

    public void setAttrSeq(Short attrSeq) {
        this.attrSeq = attrSeq;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}
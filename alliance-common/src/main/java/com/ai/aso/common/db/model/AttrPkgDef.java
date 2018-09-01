package com.ai.aso.common.db.model;

public class AttrPkgDef {
    private String attrPkgCode;

    private String attrPkgName;

    private Short isReload;

    private String reloadClass;

    private Integer ver;

    public String getAttrPkgCode() {
        return attrPkgCode;
    }

    public void setAttrPkgCode(String attrPkgCode) {
        this.attrPkgCode = attrPkgCode == null ? null : attrPkgCode.trim();
    }

    public String getAttrPkgName() {
        return attrPkgName;
    }

    public void setAttrPkgName(String attrPkgName) {
        this.attrPkgName = attrPkgName == null ? null : attrPkgName.trim();
    }

    public Short getIsReload() {
        return isReload;
    }

    public void setIsReload(Short isReload) {
        this.isReload = isReload;
    }

    public String getReloadClass() {
        return reloadClass;
    }

    public void setReloadClass(String reloadClass) {
        this.reloadClass = reloadClass == null ? null : reloadClass.trim();
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
package com.ai.aso.common.db.model;

public class GlobalParam {
    private String paramKey;

    private String paramVal;

    private String paramDesc;

    private Short isReload;

    private Integer ver;

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    public String getParamVal() {
        return paramVal;
    }

    public void setParamVal(String paramVal) {
        this.paramVal = paramVal == null ? null : paramVal.trim();
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc == null ? null : paramDesc.trim();
    }

    public Short getIsReload() {
        return isReload;
    }

    public void setIsReload(Short isReload) {
        this.isReload = isReload;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
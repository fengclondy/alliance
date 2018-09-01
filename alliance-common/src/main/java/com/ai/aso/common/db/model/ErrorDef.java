package com.ai.aso.common.db.model;

import java.util.Date;

public class ErrorDef {
    private String errCode;

    private String errDesc;

    private String errTip;

    private Date createDate;

    private Short isReload;

    private String modelCode;

    private Integer ver;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode == null ? null : errCode.trim();
    }

    public String getErrDesc() {
        return errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc == null ? null : errDesc.trim();
    }

    public String getErrTip() {
        return errTip;
    }

    public void setErrTip(String errTip) {
        this.errTip = errTip == null ? null : errTip.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Short getIsReload() {
        return isReload;
    }

    public void setIsReload(Short isReload) {
        this.isReload = isReload;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
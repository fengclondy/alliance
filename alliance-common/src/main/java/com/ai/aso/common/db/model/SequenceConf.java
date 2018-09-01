package com.ai.aso.common.db.model;

public class SequenceConf {
    private String seqKey;

    private Long currentVal;

    private Integer increment;

    private String prefix;

    private String dateFormat;

    private Short randomLen;

    private String suffix;

    private Integer ver;

    private Integer numberLen;

    public String getSeqKey() {
        return seqKey;
    }

    public void setSeqKey(String seqKey) {
        this.seqKey = seqKey == null ? null : seqKey.trim();
    }

    public Long getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(Long currentVal) {
        this.currentVal = currentVal;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat == null ? null : dateFormat.trim();
    }

    public Short getRandomLen() {
        return randomLen;
    }

    public void setRandomLen(Short randomLen) {
        this.randomLen = randomLen;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public Integer getNumberLen() {
        return numberLen;
    }

    public void setNumberLen(Integer numberLen) {
        this.numberLen = numberLen;
    }
}
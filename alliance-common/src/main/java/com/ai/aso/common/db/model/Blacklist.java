package com.ai.aso.common.db.model;

import javax.persistence.Entity;

@Entity(name = "B_BLACK_LIST")
public class Blacklist {
    private String blacklistKey;

    private String blacklistName;

    private String blacklistValue;

    private Integer ver;

    public String getBlacklistKey() {
        return blacklistKey;
    }

    public void setBlacklistKey(String blacklistKey) {
        this.blacklistKey = blacklistKey == null ? null : blacklistKey.trim();
    }

    public String getBlacklistName() {
        return blacklistName;
    }

    public void setBlacklistName(String blacklistName) {
        this.blacklistName = blacklistName == null ? null : blacklistName.trim();
    }

    public String getBlacklistValue() {
        return blacklistValue;
    }

    public void setBlacklistValue(String blacklistValue) {
        this.blacklistValue = blacklistValue == null ? null : blacklistValue.trim();
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
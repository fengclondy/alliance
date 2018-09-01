package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "B_CONTRACT_OFF")
public class ContractOff {
    private String contId;

    private Integer dataType;

    private Integer offRate;
    @Id
    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getOffRate() {
        return offRate;
    }

    public void setOffRate(Integer offRate) {
        this.offRate = offRate;
    }
}
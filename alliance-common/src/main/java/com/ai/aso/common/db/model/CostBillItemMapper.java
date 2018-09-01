package com.ai.aso.common.db.model;

public class CostBillItemMapper {
    private Integer costRegion;

    private String billItemId;

    private String billItemDesc;

    public Integer getCostRegion() {
        return costRegion;
    }

    public void setCostRegion(Integer costRegion) {
        this.costRegion = costRegion;
    }

    public String getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(String billItemId) {
        this.billItemId = billItemId == null ? null : billItemId.trim();
    }

    public String getBillItemDesc() {
        return billItemDesc;
    }

    public void setBillItemDesc(String billItemDesc) {
        this.billItemDesc = billItemDesc == null ? null : billItemDesc.trim();
    }
}
package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "B_COST_BILL_ITEM_MAPPER")
public class CostBillItemMapper {
    private Integer costRegion;

    private String billItemId;

    private String billItemDesc;
    @Id
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
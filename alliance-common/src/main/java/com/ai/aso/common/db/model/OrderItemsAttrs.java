package com.ai.aso.common.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "B_ORDER_ITEM_ATTRS")
public class OrderItemsAttrs {
    private String attrCode;

    private Long itemId;

    private String attrValue;
    @Id
    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }
}
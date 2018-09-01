package com.ai.aso.common.db.model;

public class GoodsCatalog {
    private String catalogId;

    private String pCatalogId;

    private String catalogName;

    private Short catalogState;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    public String getpCatalogId() {
        return pCatalogId;
    }

    public void setpCatalogId(String pCatalogId) {
        this.pCatalogId = pCatalogId == null ? null : pCatalogId.trim();
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public Short getCatalogState() {
        return catalogState;
    }

    public void setCatalogState(Short catalogState) {
        this.catalogState = catalogState;
    }
}
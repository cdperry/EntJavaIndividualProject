package com.cdperry.brewday.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by cdperry on 3/6/16.
 */
public class ComponentHopEntity {
    private int compHopId;
    private String name;
    private Integer originId;
    private Integer supplierId;
    private BigDecimal alphaPct;
    private BigDecimal betaPct;
    private Integer hopTypeId;
    private Integer hopFormId;
    private String notes;
    private Date updateDate;
    private Date createDate;

    public int getCompHopId() {
        return compHopId;
    }

    public void setCompHopId(int compHopId) {
        this.compHopId = compHopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getAlphaPct() {
        return alphaPct;
    }

    public void setAlphaPct(BigDecimal alphaPct) {
        this.alphaPct = alphaPct;
    }

    public BigDecimal getBetaPct() {
        return betaPct;
    }

    public void setBetaPct(BigDecimal betaPct) {
        this.betaPct = betaPct;
    }

    public Integer getHopTypeId() {
        return hopTypeId;
    }

    public void setHopTypeId(Integer hopTypeId) {
        this.hopTypeId = hopTypeId;
    }

    public Integer getHopFormId() {
        return hopFormId;
    }

    public void setHopFormId(Integer hopFormId) {
        this.hopFormId = hopFormId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComponentHopEntity that = (ComponentHopEntity) o;

        if (compHopId != that.compHopId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (originId != null ? !originId.equals(that.originId) : that.originId != null) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (alphaPct != null ? !alphaPct.equals(that.alphaPct) : that.alphaPct != null) return false;
        if (betaPct != null ? !betaPct.equals(that.betaPct) : that.betaPct != null) return false;
        if (hopTypeId != null ? !hopTypeId.equals(that.hopTypeId) : that.hopTypeId != null) return false;
        if (hopFormId != null ? !hopFormId.equals(that.hopFormId) : that.hopFormId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compHopId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (originId != null ? originId.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (alphaPct != null ? alphaPct.hashCode() : 0);
        result = 31 * result + (betaPct != null ? betaPct.hashCode() : 0);
        result = 31 * result + (hopTypeId != null ? hopTypeId.hashCode() : 0);
        result = 31 * result + (hopFormId != null ? hopFormId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

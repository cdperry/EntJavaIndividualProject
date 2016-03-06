package com.cdperry.brewday.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by cdperry on 3/6/16.
 */
public class ComponentYeastEntity {
    private int compYeastId;
    private String name;
    private Integer labId;
    private Integer supplierId;
    private Integer yeastTypeId;
    private Integer yeastFormId;
    private Integer yeastFlocTypeId;
    private BigDecimal attenuationMin;
    private BigDecimal attenuationMax;
    private BigDecimal temperatureMin;
    private BigDecimal temperatureMax;
    private BigDecimal cellsPerPack;
    private String notes;
    private Date updateDate;
    private Date createDate;

    public int getCompYeastId() {
        return compYeastId;
    }

    public void setCompYeastId(int compYeastId) {
        this.compYeastId = compYeastId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getYeastTypeId() {
        return yeastTypeId;
    }

    public void setYeastTypeId(Integer yeastTypeId) {
        this.yeastTypeId = yeastTypeId;
    }

    public Integer getYeastFormId() {
        return yeastFormId;
    }

    public void setYeastFormId(Integer yeastFormId) {
        this.yeastFormId = yeastFormId;
    }

    public Integer getYeastFlocTypeId() {
        return yeastFlocTypeId;
    }

    public void setYeastFlocTypeId(Integer yeastFlocTypeId) {
        this.yeastFlocTypeId = yeastFlocTypeId;
    }

    public BigDecimal getAttenuationMin() {
        return attenuationMin;
    }

    public void setAttenuationMin(BigDecimal attenuationMin) {
        this.attenuationMin = attenuationMin;
    }

    public BigDecimal getAttenuationMax() {
        return attenuationMax;
    }

    public void setAttenuationMax(BigDecimal attenuationMax) {
        this.attenuationMax = attenuationMax;
    }

    public BigDecimal getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(BigDecimal temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public BigDecimal getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(BigDecimal temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public BigDecimal getCellsPerPack() {
        return cellsPerPack;
    }

    public void setCellsPerPack(BigDecimal cellsPerPack) {
        this.cellsPerPack = cellsPerPack;
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

        ComponentYeastEntity that = (ComponentYeastEntity) o;

        if (compYeastId != that.compYeastId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (labId != null ? !labId.equals(that.labId) : that.labId != null) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (yeastTypeId != null ? !yeastTypeId.equals(that.yeastTypeId) : that.yeastTypeId != null) return false;
        if (yeastFormId != null ? !yeastFormId.equals(that.yeastFormId) : that.yeastFormId != null) return false;
        if (yeastFlocTypeId != null ? !yeastFlocTypeId.equals(that.yeastFlocTypeId) : that.yeastFlocTypeId != null)
            return false;
        if (attenuationMin != null ? !attenuationMin.equals(that.attenuationMin) : that.attenuationMin != null)
            return false;
        if (attenuationMax != null ? !attenuationMax.equals(that.attenuationMax) : that.attenuationMax != null)
            return false;
        if (temperatureMin != null ? !temperatureMin.equals(that.temperatureMin) : that.temperatureMin != null)
            return false;
        if (temperatureMax != null ? !temperatureMax.equals(that.temperatureMax) : that.temperatureMax != null)
            return false;
        if (cellsPerPack != null ? !cellsPerPack.equals(that.cellsPerPack) : that.cellsPerPack != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compYeastId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (labId != null ? labId.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (yeastTypeId != null ? yeastTypeId.hashCode() : 0);
        result = 31 * result + (yeastFormId != null ? yeastFormId.hashCode() : 0);
        result = 31 * result + (yeastFlocTypeId != null ? yeastFlocTypeId.hashCode() : 0);
        result = 31 * result + (attenuationMin != null ? attenuationMin.hashCode() : 0);
        result = 31 * result + (attenuationMax != null ? attenuationMax.hashCode() : 0);
        result = 31 * result + (temperatureMin != null ? temperatureMin.hashCode() : 0);
        result = 31 * result + (temperatureMax != null ? temperatureMax.hashCode() : 0);
        result = 31 * result + (cellsPerPack != null ? cellsPerPack.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

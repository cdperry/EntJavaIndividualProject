package com.cdperry.brewday.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by cdperry on 3/6/16.
 */
public class ComponentGrainEntity {
    private int compGrainId;
    private ComponentEntity componentEntity;
    private Integer componentId;
    private String name;
//    private Integer originId;
//    private Integer supplierId;
//    private Integer grainTypeId;
    private OriginEntity origin;
    private SupplierEntity supplier;
    private GrainTypeEntity grainType;
    private BigDecimal color;
    private BigDecimal potential;
    private String notes;
    private Timestamp updateDate;
    private Timestamp createDate;

    public ComponentGrainEntity() {}

    public ComponentGrainEntity(Timestamp createDate, Timestamp updateDate) {
        this.componentId = componentId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getCompGrainId() {
        return compGrainId;
    }

    public void setCompGrainId(int compGrainId) {
        this.compGrainId = compGrainId;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public ComponentEntity getComponentEntity() {
        return componentEntity;
    }

    public void setComponentEntity(ComponentEntity componentEntity) {
        this.componentEntity = componentEntity;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
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

    public Integer getGrainTypeId() {
        return grainTypeId;
    }

    public void setGrainTypeId(Integer grainTypeId) {
        this.grainTypeId = grainTypeId;
    }
    */

    public OriginEntity getOrigin() {
        return origin;
    }

    public void setOrigin(OriginEntity origin) {
        this.origin = origin;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public GrainTypeEntity getGrainType() {
        return grainType;
    }

    public void setGrainType(GrainTypeEntity grainType) {
        this.grainType = grainType;
    }

    public BigDecimal getColor() {
        return color;
    }

    public void setColor(BigDecimal color) {
        this.color = color;
    }

    public BigDecimal getPotential() {
        return potential;
    }

    public void setPotential(BigDecimal potential) {
        this.potential = potential;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComponentGrainEntity that = (ComponentGrainEntity) o;

        if (compGrainId != that.compGrainId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (originId != null ? !originId.equals(that.originId) : that.originId != null) return false;
//        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
//        if (grainTypeId != null ? !grainTypeId.equals(that.grainTypeId) : that.grainTypeId != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (potential != null ? !potential.equals(that.potential) : that.potential != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compGrainId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (originId != null ? originId.hashCode() : 0);
//        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
//        result = 31 * result + (grainTypeId != null ? grainTypeId.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (potential != null ? potential.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

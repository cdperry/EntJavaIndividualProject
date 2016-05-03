package com.cdperry.brewday.entity;

import java.sql.Timestamp;

/**
 * Created by cdperry on 3/6/16.
 */
public class ComponentEntity {
    private int componentId;
    private String name;
    //private Integer componentTypeId;
    //private Integer compHopId;
    //private Integer compGrainId;
    //private Integer compYeastId;
    //private Integer compWaterId;
    //private Integer compOtherId;
    private ComponentTypeEntity componentType;
    private ComponentHopEntity componentHop;
    private ComponentGrainEntity componentGrain;
    private ComponentYeastEntity componentYeast;
    private ComponentWaterEntity componentWater;
    private ComponentOtherEntity componentOther;
    private Timestamp updateDate;
    private Timestamp createDate;

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public Integer getComponentTypeId() {
        return componentTypeId;
    }

    public void setComponentTypeId(Integer componentTypeId) {
        this.componentTypeId = componentTypeId;
    }

    public Integer getCompHopId() {
        return compHopId;
    }

    public void setCompHopId(Integer compHopId) {
        this.compHopId = compHopId;
    }

    public Integer getCompGrainId() {
        return compGrainId;
    }

    public void setCompGrainId(Integer compGrainId) {
        this.compGrainId = compGrainId;
    }

    public Integer getCompYeastId() {
        return compYeastId;
    }

    public void setCompYeastId(Integer compYeastId) {
        this.compYeastId = compYeastId;
    }

    public Integer getCompWaterId() {
        return compWaterId;
    }

    public void setCompWaterId(Integer compWaterId) {
        this.compWaterId = compWaterId;
    }

    public Integer getCompOtherId() {
        return compOtherId;
    }

    public void setCompOtherId(Integer compOtherId) {
        this.compOtherId = compOtherId;
    }
    */

    public ComponentTypeEntity getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentTypeEntity componentType) {
        this.componentType = componentType;
    }

    public ComponentHopEntity getComponentHop() {
        return componentHop;
    }

    public void setComponentHop(ComponentHopEntity compHop) {
        this.componentHop = compHop;
    }

    public ComponentGrainEntity getComponentGrain() {
        return componentGrain;
    }

    public void setComponentGrain(ComponentGrainEntity compGrain) {
        this.componentGrain = compGrain;
    }

    public ComponentYeastEntity getComponentYeast() {
        return componentYeast;
    }

    public void setComponentYeast(ComponentYeastEntity compYeast) {
        this.componentYeast = compYeast;
    }

    public ComponentWaterEntity getComponentWater() {
        return componentWater;
    }

    public void setComponentWater(ComponentWaterEntity compWater) {
        this.componentWater = compWater;
    }

    public ComponentOtherEntity getComponentOther() {
        return componentOther;
    }

    public void setComponentOther(ComponentOtherEntity compOther) {
        this.componentOther = compOther;
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

        ComponentEntity that = (ComponentEntity) o;

        if (componentId != that.componentId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        //if (componentTypeId != null ? !componentTypeId.equals(that.componentTypeId) : that.componentTypeId != null)
        //    return false;
        //if (compHopId != null ? !compHopId.equals(that.compHopId) : that.compHopId != null) return false;
        //if (compGrainId != null ? !compGrainId.equals(that.compGrainId) : that.compGrainId != null) return false;
        //if (compYeastId != null ? !compYeastId.equals(that.compYeastId) : that.compYeastId != null) return false;
        //if (compWaterId != null ? !compWaterId.equals(that.compWaterId) : that.compWaterId != null) return false;
        //if (compOtherId != null ? !compOtherId.equals(that.compOtherId) : that.compOtherId != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = componentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        //result = 31 * result + (componentTypeId != null ? componentTypeId.hashCode() : 0);
        //result = 31 * result + (compHopId != null ? compHopId.hashCode() : 0);
        //result = 31 * result + (compGrainId != null ? compGrainId.hashCode() : 0);
        //result = 31 * result + (compYeastId != null ? compYeastId.hashCode() : 0);
        //result = 31 * result + (compWaterId != null ? compWaterId.hashCode() : 0);
        //result = 31 * result + (compOtherId != null ? compOtherId.hashCode() : 0);
        //result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        //result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

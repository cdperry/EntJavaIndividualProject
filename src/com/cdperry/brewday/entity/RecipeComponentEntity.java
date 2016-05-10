package com.cdperry.brewday.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by cdperry on 3/6/16.
 */
public class RecipeComponentEntity {

    private int recipeComponentId;
    private Integer recipeId;
    //private Integer componentId;
    private BigDecimal amount;
    private BigDecimal time;
    //private Integer amountUomId;
    private Timestamp updateDate;
    private Timestamp createDate;

    // a many-to-one relationship; many RecipeComponentEntity objects can be related to a single
    // UomTypeEntity object
    private UomTypeEntity amountUom;

    // a many-to-one relationship; many RecipeComponentEntity objects can be related to a single
    // UomTypeEntity object
    private UomTypeEntity timeUom;

    // a many-to-one relationship; many RecipeComponentEntity objects can be related to a single
    // ComponentEntity object
    private ComponentEntity component;

    // a many-to-one relationship; many RecipeComponentEntity objects can be related to a single
    // RecipeEntity object
    private RecipeEntity recipeEntity;

    public RecipeComponentEntity() {}

    public RecipeComponentEntity(Timestamp createDate, Timestamp updateDate) {
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getRecipeComponentId() {
        return recipeComponentId;
    }

    public void setRecipeComponentId(int recipeComponentId) {
        this.recipeComponentId = recipeComponentId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    /*
    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }
    */

    public ComponentEntity getComponent() {
        return component;
    }

    public void setComponent(ComponentEntity component) {
        this.component = component;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /*
    public Integer getAmountUomId() {
        return amountUomId;
    }

    public void setAmountUomId(Integer amountUomId) {
        this.amountUomId = amountUomId;
    }
    */
    public UomTypeEntity getAmountUom() {
        return amountUom;
    }

    public void setAmountUom(UomTypeEntity amountUom) {
        this.amountUom = amountUom;
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public UomTypeEntity getTimeUom() {
        return timeUom;
    }

    public void setTimeUom(UomTypeEntity timeUom) {
        this.timeUom = timeUom;
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

    public RecipeEntity getRecipeEntity() {
        return recipeEntity;
    }

    public void setRecipeEntity(RecipeEntity recipeEntity) {
        this.recipeEntity = recipeEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeComponentEntity that = (RecipeComponentEntity) o;

        if (recipeComponentId != that.recipeComponentId) return false;
        if (recipeId != null ? !recipeId.equals(that.recipeId) : that.recipeId != null) return false;
        //if (componentId != null ? !componentId.equals(that.componentId) : that.componentId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        //if (amountUomId != null ? !amountUomId.equals(that.amountUomId) : that.amountUomId != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recipeComponentId;
        result = 31 * result + (recipeId != null ? recipeId.hashCode() : 0);
        //result = 31 * result + (componentId != null ? componentId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        //result = 31 * result + (amountUomId != null ? amountUomId.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }


}

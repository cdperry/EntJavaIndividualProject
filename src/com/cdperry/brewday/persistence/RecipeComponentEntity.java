package com.cdperry.brewday.persistence;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by cdperry on 3/6/16.
 */
public class RecipeComponentEntity {
    private int recipeComponentId;
    private Integer recipeId;
    private Integer componentId;
    private BigDecimal amount;
    private Integer amountUomId;
    private Date updateDate;
    private Date createDate;

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

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getAmountUomId() {
        return amountUomId;
    }

    public void setAmountUomId(Integer amountUomId) {
        this.amountUomId = amountUomId;
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

        RecipeComponentEntity that = (RecipeComponentEntity) o;

        if (recipeComponentId != that.recipeComponentId) return false;
        if (recipeId != null ? !recipeId.equals(that.recipeId) : that.recipeId != null) return false;
        if (componentId != null ? !componentId.equals(that.componentId) : that.componentId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (amountUomId != null ? !amountUomId.equals(that.amountUomId) : that.amountUomId != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recipeComponentId;
        result = 31 * result + (recipeId != null ? recipeId.hashCode() : 0);
        result = 31 * result + (componentId != null ? componentId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (amountUomId != null ? amountUomId.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

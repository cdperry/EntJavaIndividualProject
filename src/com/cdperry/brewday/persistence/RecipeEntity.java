package com.cdperry.brewday.persistence;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by cdperry on 3/6/16.
 */
public class RecipeEntity {
    private int recipeId;
    private String recipeName;
    private String brewerName;
    private Integer recipeTypeId;
    private BigDecimal batchSize;
    private Integer batchSizeUomId;
    private Integer equipmentProfileId;
    private Date updateDate;
    private Date createDate;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getBrewerName() {
        return brewerName;
    }

    public void setBrewerName(String brewerName) {
        this.brewerName = brewerName;
    }

    public Integer getRecipeTypeId() {
        return recipeTypeId;
    }

    public void setRecipeTypeId(Integer recipeTypeId) {
        this.recipeTypeId = recipeTypeId;
    }

    public BigDecimal getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(BigDecimal batchSize) {
        this.batchSize = batchSize;
    }

    public Integer getBatchSizeUomId() {
        return batchSizeUomId;
    }

    public void setBatchSizeUomId(Integer batchSizeUomId) {
        this.batchSizeUomId = batchSizeUomId;
    }

    public Integer getEquipmentProfileId() {
        return equipmentProfileId;
    }

    public void setEquipmentProfileId(Integer equipmentProfileId) {
        this.equipmentProfileId = equipmentProfileId;
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

        RecipeEntity that = (RecipeEntity) o;

        if (recipeId != that.recipeId) return false;
        if (recipeName != null ? !recipeName.equals(that.recipeName) : that.recipeName != null) return false;
        if (brewerName != null ? !brewerName.equals(that.brewerName) : that.brewerName != null) return false;
        if (recipeTypeId != null ? !recipeTypeId.equals(that.recipeTypeId) : that.recipeTypeId != null) return false;
        if (batchSize != null ? !batchSize.equals(that.batchSize) : that.batchSize != null) return false;
        if (batchSizeUomId != null ? !batchSizeUomId.equals(that.batchSizeUomId) : that.batchSizeUomId != null)
            return false;
        if (equipmentProfileId != null ? !equipmentProfileId.equals(that.equipmentProfileId) : that.equipmentProfileId != null)
            return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recipeId;
        result = 31 * result + (recipeName != null ? recipeName.hashCode() : 0);
        result = 31 * result + (brewerName != null ? brewerName.hashCode() : 0);
        result = 31 * result + (recipeTypeId != null ? recipeTypeId.hashCode() : 0);
        result = 31 * result + (batchSize != null ? batchSize.hashCode() : 0);
        result = 31 * result + (batchSizeUomId != null ? batchSizeUomId.hashCode() : 0);
        result = 31 * result + (equipmentProfileId != null ? equipmentProfileId.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

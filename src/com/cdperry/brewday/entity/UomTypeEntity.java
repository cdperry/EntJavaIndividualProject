package com.cdperry.brewday.entity;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by cdperry on 3/6/16.
 *
 * TODO: Add one-to-many relationship to various types of objects that can have a relationship with this object?
 */
public class UomTypeEntity {
    private int uomId;
    private String name;
    private Timestamp updateDate;
    private Timestamp createDate;
    private Set recipeBatchSizes;
    private Set recipeComponentAmountUoms;
    private Set otherComponentBatchSizeUoms;
    private Set otherComponentAmountUoms;
    private Set otherComponentTimeUoms;
    private Set waterComponentBatchSizeUoms;
    private Set equipmentProfileBatchVolUoms;
    private Set equipmentProfileMashTunVolUoms;
    private Set equipmentProfileBoilVolUoms;
    private Set equipmentProfileBoilTimeUoms;
    private Set equipmentProfileBoilOffPerHrUoms;
    private Set equipmentProfileBoilTotalBoilOffUoms;
    private Set equipmentProfileBoilPostBoilVolUoms;
    private Set equipmentProfileFermLossUoms;
    private Set equipmentProfileFermTopUpUoms;
    private Set equipmentProfileFermLossTrubLossChillUoms;
    private Set equipmentProfileBottlingVolUoms;

    public UomTypeEntity() {
        this.recipeBatchSizes = new HashSet<RecipeEntity>(0);
    }

    public int getUomId() {
        return uomId;
    }

    public void setUomId(int uomId) {
        this.uomId = uomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set getRecipeBatchSizes() {
        return recipeBatchSizes;
    }

    public void setRecipeBatchSizes(Set recipeBatchSizes) {
        this.recipeBatchSizes = recipeBatchSizes;
    }

    public Set getRecipeComponentAmountUoms() {
        return recipeComponentAmountUoms;
    }

    public void setRecipeComponentAmountUoms(Set recipeComponentAmountUoms) {
        this.recipeComponentAmountUoms = recipeComponentAmountUoms;
    }

    public Set getOtherComponentBatchSizeUoms() {
        return otherComponentBatchSizeUoms;
    }

    public void setOtherComponentBatchSizeUoms(Set otherComponentBatchSizeUoms) {
        this.otherComponentBatchSizeUoms = otherComponentBatchSizeUoms;
    }

    public Set getOtherComponentAmountUoms() {
        return otherComponentAmountUoms;
    }

    public void setOtherComponentAmountUoms(Set otherComponentAmountUoms) {
        this.otherComponentAmountUoms = otherComponentAmountUoms;
    }

    public Set getOtherComponentTimeUoms() {
        return otherComponentTimeUoms;
    }

    public void setOtherComponentTimeUoms(Set otherComponentTimeUoms) {
        this.otherComponentTimeUoms = otherComponentTimeUoms;
    }

    public Set getWaterComponentBatchSizeUoms() {
        return waterComponentBatchSizeUoms;
    }

    public void setWaterComponentBatchSizeUoms(Set waterComponentBatchSizeUoms) {
        this.waterComponentBatchSizeUoms = waterComponentBatchSizeUoms;
    }

    public Set getEquipmentProfileBatchVolUoms() {
        return equipmentProfileBatchVolUoms;
    }

    public void setEquipmentProfileBatchVolUoms(Set equipmentProfileBatchVolUoms) {
        this.equipmentProfileBatchVolUoms = equipmentProfileBatchVolUoms;
    }

    public Set getEquipmentProfileMashTunVolUoms() {
        return equipmentProfileMashTunVolUoms;
    }

    public void setEquipmentProfileMashTunVolUoms(Set equipmentProfileMashTunVolUoms) {
        this.equipmentProfileMashTunVolUoms = equipmentProfileMashTunVolUoms;
    }

    public Set getEquipmentProfileBoilVolUoms() {
        return equipmentProfileBoilVolUoms;
    }

    public void setEquipmentProfileBoilVolUoms(Set equipmentProfileBoilVolUoms) {
        this.equipmentProfileBoilVolUoms = equipmentProfileBoilVolUoms;
    }

    public Set getEquipmentProfileBoilTimeUoms() {
        return equipmentProfileBoilTimeUoms;
    }

    public void setEquipmentProfileBoilTimeUoms(Set equipmentProfileBoilTimeUoms) {
        this.equipmentProfileBoilTimeUoms = equipmentProfileBoilTimeUoms;
    }

    public Set getEquipmentProfileBoilOffPerHrUoms() {
        return equipmentProfileBoilOffPerHrUoms;
    }

    public void setEquipmentProfileBoilOffPerHrUoms(Set equipmentProfileBoilOffPerHrUoms) {
        this.equipmentProfileBoilOffPerHrUoms = equipmentProfileBoilOffPerHrUoms;
    }

    public Set getEquipmentProfileBoilTotalBoilOffUoms() {
        return equipmentProfileBoilTotalBoilOffUoms;
    }

    public void setEquipmentProfileBoilTotalBoilOffUoms(Set equipmentProfileBoilTotalBoilOffUoms) {
        this.equipmentProfileBoilTotalBoilOffUoms = equipmentProfileBoilTotalBoilOffUoms;
    }

    public Set getEquipmentProfileBoilPostBoilVolUoms() {
        return equipmentProfileBoilPostBoilVolUoms;
    }

    public void setEquipmentProfileBoilPostBoilVolUoms(Set equipmentProfileBoilPostBoilVolUoms) {
        this.equipmentProfileBoilPostBoilVolUoms = equipmentProfileBoilPostBoilVolUoms;
    }

    public Set getEquipmentProfileFermLossUoms() {
        return equipmentProfileFermLossUoms;
    }

    public void setEquipmentProfileFermLossUoms(Set equipmentProfileFermLossUoms) {
        this.equipmentProfileFermLossUoms = equipmentProfileFermLossUoms;
    }

    public Set getEquipmentProfileFermTopUpUoms() {
        return equipmentProfileFermTopUpUoms;
    }

    public void setEquipmentProfileFermTopUpUoms(Set equipmentProfileFermTopUpUoms) {
        this.equipmentProfileFermTopUpUoms = equipmentProfileFermTopUpUoms;
    }

    public Set getEquipmentProfileFermLossTrubLossChillUoms() {
        return equipmentProfileFermLossTrubLossChillUoms;
    }

    public void setEquipmentProfileFermLossTrubLossChillUoms(Set equipmentProfileFermLossTrubLossChillUoms) {
        this.equipmentProfileFermLossTrubLossChillUoms = equipmentProfileFermLossTrubLossChillUoms;
    }

    public Set getEquipmentProfileBottlingVolUoms() {
        return equipmentProfileBottlingVolUoms;
    }

    public void setEquipmentProfileBottlingVolUoms(Set equipmentProfileBottlingVolUoms) {
        this.equipmentProfileBottlingVolUoms = equipmentProfileBottlingVolUoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UomTypeEntity that = (UomTypeEntity) o;

        if (uomId != that.uomId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uomId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

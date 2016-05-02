package com.cdperry.brewday.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by cdperry on 3/6/16.
 *
 * TODO: Make sure when an equipment profile is deleted that other objects that reference it have their
 * profiles set to null; make sure that things that reference non-existant profiles ignore nulls
 */
public class ProfileEquipmentEntity {
    private int profileEquipmentId;
    private String name;
    private BigDecimal efficiency;
    private BigDecimal fermBatchVol;
    private Integer batchVolUomId;
    private BigDecimal mashTunVol;
    private Integer mashTunUomId;
    private BigDecimal boilVol;
    private Integer boilVolUomId;
    private BigDecimal boilTime;
    private Integer boilTimeUomId;
    private BigDecimal boilOffPerHrVol;
    private Integer boilOffPerHrUomId;
    private BigDecimal boilShrinkage;
    private BigDecimal boilTotalBoilOff;
    private Integer boilTotalBoilOffUomId;
    private BigDecimal boilPostBoilVol;
    private Integer boilPostBoilVolUomId;
    private BigDecimal fermLoss;
    private Integer fermLossUomId;
    private BigDecimal fermTopUp;
    private Integer fermTopUpUomId;
    private BigDecimal fermLossTrubChill;
    private Integer fermLossTrubChillUomId;
    private BigDecimal bottlingVol;
    private Integer bottlingVolUomId;
    private String notes;
    private Timestamp updateDate;
    private Timestamp createDate;

    public int getProfileEquipmentId() {
        return profileEquipmentId;
    }

    public void setProfileEquipmentId(int profileEquipmentId) {
        this.profileEquipmentId = profileEquipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(BigDecimal efficiency) {
        this.efficiency = efficiency;
    }

    public BigDecimal getFermBatchVol() {
        return fermBatchVol;
    }

    public void setFermBatchVol(BigDecimal fermBatchVol) {
        this.fermBatchVol = fermBatchVol;
    }

    public Integer getBatchVolUomId() {
        return batchVolUomId;
    }

    public void setBatchVolUomId(Integer batchVolUomId) {
        this.batchVolUomId = batchVolUomId;
    }

    public BigDecimal getMashTunVol() {
        return mashTunVol;
    }

    public void setMashTunVol(BigDecimal mashTunVol) {
        this.mashTunVol = mashTunVol;
    }

    public Integer getMashTunUomId() {
        return mashTunUomId;
    }

    public void setMashTunUomId(Integer mashTunUomId) {
        this.mashTunUomId = mashTunUomId;
    }

    public BigDecimal getBoilVol() {
        return boilVol;
    }

    public void setBoilVol(BigDecimal boilVol) {
        this.boilVol = boilVol;
    }

    public Integer getBoilVolUomId() {
        return boilVolUomId;
    }

    public void setBoilVolUomId(Integer boilVolUomId) {
        this.boilVolUomId = boilVolUomId;
    }

    public BigDecimal getBoilTime() {
        return boilTime;
    }

    public void setBoilTime(BigDecimal boilTime) {
        this.boilTime = boilTime;
    }

    public Integer getBoilTimeUomId() {
        return boilTimeUomId;
    }

    public void setBoilTimeUomId(Integer boilTimeUomId) {
        this.boilTimeUomId = boilTimeUomId;
    }

    public BigDecimal getBoilOffPerHrVol() {
        return boilOffPerHrVol;
    }

    public void setBoilOffPerHrVol(BigDecimal boilOffPerHrVol) {
        this.boilOffPerHrVol = boilOffPerHrVol;
    }

    public Integer getBoilOffPerHrUomId() {
        return boilOffPerHrUomId;
    }

    public void setBoilOffPerHrUomId(Integer boilOffPerHrUomId) {
        this.boilOffPerHrUomId = boilOffPerHrUomId;
    }

    public BigDecimal getBoilShrinkage() {
        return boilShrinkage;
    }

    public void setBoilShrinkage(BigDecimal boilShrinkage) {
        this.boilShrinkage = boilShrinkage;
    }

    public BigDecimal getBoilTotalBoilOff() {
        return boilTotalBoilOff;
    }

    public void setBoilTotalBoilOff(BigDecimal boilTotalBoilOff) {
        this.boilTotalBoilOff = boilTotalBoilOff;
    }

    public Integer getBoilTotalBoilOffUomId() {
        return boilTotalBoilOffUomId;
    }

    public void setBoilTotalBoilOffUomId(Integer boilTotalBoilOffUomId) {
        this.boilTotalBoilOffUomId = boilTotalBoilOffUomId;
    }

    public BigDecimal getBoilPostBoilVol() {
        return boilPostBoilVol;
    }

    public void setBoilPostBoilVol(BigDecimal boilPostBoilVol) {
        this.boilPostBoilVol = boilPostBoilVol;
    }

    public Integer getBoilPostBoilVolUomId() {
        return boilPostBoilVolUomId;
    }

    public void setBoilPostBoilVolUomId(Integer boilPostBoilVolUomId) {
        this.boilPostBoilVolUomId = boilPostBoilVolUomId;
    }

    public BigDecimal getFermLoss() {
        return fermLoss;
    }

    public void setFermLoss(BigDecimal fermLoss) {
        this.fermLoss = fermLoss;
    }

    public Integer getFermLossUomId() {
        return fermLossUomId;
    }

    public void setFermLossUomId(Integer fermLossUomId) {
        this.fermLossUomId = fermLossUomId;
    }

    public BigDecimal getFermTopUp() {
        return fermTopUp;
    }

    public void setFermTopUp(BigDecimal fermTopUp) {
        this.fermTopUp = fermTopUp;
    }

    public Integer getFermTopUpUomId() {
        return fermTopUpUomId;
    }

    public void setFermTopUpUomId(Integer fermTopUpUomId) {
        this.fermTopUpUomId = fermTopUpUomId;
    }

    public BigDecimal getFermLossTrubChill() {
        return fermLossTrubChill;
    }

    public void setFermLossTrubChill(BigDecimal fermLossTrubChill) {
        this.fermLossTrubChill = fermLossTrubChill;
    }

    public Integer getFermLossTrubChillUomId() {
        return fermLossTrubChillUomId;
    }

    public void setFermLossTrubChillUomId(Integer fermLossTrubChillUomId) {
        this.fermLossTrubChillUomId = fermLossTrubChillUomId;
    }

    public BigDecimal getBottlingVol() {
        return bottlingVol;
    }

    public void setBottlingVol(BigDecimal bottlingVol) {
        this.bottlingVol = bottlingVol;
    }

    public Integer getBottlingVolUomId() {
        return bottlingVolUomId;
    }

    public void setBottlingVolUomId(Integer bottlingVolUomId) {
        this.bottlingVolUomId = bottlingVolUomId;
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

        ProfileEquipmentEntity that = (ProfileEquipmentEntity) o;

        if (profileEquipmentId != that.profileEquipmentId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (efficiency != null ? !efficiency.equals(that.efficiency) : that.efficiency != null) return false;
        if (fermBatchVol != null ? !fermBatchVol.equals(that.fermBatchVol) : that.fermBatchVol != null) return false;
        if (batchVolUomId != null ? !batchVolUomId.equals(that.batchVolUomId) : that.batchVolUomId != null)
            return false;
        if (mashTunVol != null ? !mashTunVol.equals(that.mashTunVol) : that.mashTunVol != null) return false;
        if (mashTunUomId != null ? !mashTunUomId.equals(that.mashTunUomId) : that.mashTunUomId != null) return false;
        if (boilVol != null ? !boilVol.equals(that.boilVol) : that.boilVol != null) return false;
        if (boilVolUomId != null ? !boilVolUomId.equals(that.boilVolUomId) : that.boilVolUomId != null) return false;
        if (boilTime != null ? !boilTime.equals(that.boilTime) : that.boilTime != null) return false;
        if (boilTimeUomId != null ? !boilTimeUomId.equals(that.boilTimeUomId) : that.boilTimeUomId != null)
            return false;
        if (boilOffPerHrVol != null ? !boilOffPerHrVol.equals(that.boilOffPerHrVol) : that.boilOffPerHrVol != null)
            return false;
        if (boilOffPerHrUomId != null ? !boilOffPerHrUomId.equals(that.boilOffPerHrUomId) : that.boilOffPerHrUomId != null)
            return false;
        if (boilShrinkage != null ? !boilShrinkage.equals(that.boilShrinkage) : that.boilShrinkage != null)
            return false;
        if (boilTotalBoilOff != null ? !boilTotalBoilOff.equals(that.boilTotalBoilOff) : that.boilTotalBoilOff != null)
            return false;
        if (boilTotalBoilOffUomId != null ? !boilTotalBoilOffUomId.equals(that.boilTotalBoilOffUomId) : that.boilTotalBoilOffUomId != null)
            return false;
        if (boilPostBoilVol != null ? !boilPostBoilVol.equals(that.boilPostBoilVol) : that.boilPostBoilVol != null)
            return false;
        if (boilPostBoilVolUomId != null ? !boilPostBoilVolUomId.equals(that.boilPostBoilVolUomId) : that.boilPostBoilVolUomId != null)
            return false;
        if (fermLoss != null ? !fermLoss.equals(that.fermLoss) : that.fermLoss != null) return false;
        if (fermLossUomId != null ? !fermLossUomId.equals(that.fermLossUomId) : that.fermLossUomId != null)
            return false;
        if (fermTopUp != null ? !fermTopUp.equals(that.fermTopUp) : that.fermTopUp != null) return false;
        if (fermTopUpUomId != null ? !fermTopUpUomId.equals(that.fermTopUpUomId) : that.fermTopUpUomId != null)
            return false;
        if (fermLossTrubChill != null ? !fermLossTrubChill.equals(that.fermLossTrubChill) : that.fermLossTrubChill != null)
            return false;
        if (fermLossTrubChillUomId != null ? !fermLossTrubChillUomId.equals(that.fermLossTrubChillUomId) : that.fermLossTrubChillUomId != null)
            return false;
        if (bottlingVol != null ? !bottlingVol.equals(that.bottlingVol) : that.bottlingVol != null) return false;
        if (bottlingVolUomId != null ? !bottlingVolUomId.equals(that.bottlingVolUomId) : that.bottlingVolUomId != null)
            return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = profileEquipmentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (efficiency != null ? efficiency.hashCode() : 0);
        result = 31 * result + (fermBatchVol != null ? fermBatchVol.hashCode() : 0);
        result = 31 * result + (batchVolUomId != null ? batchVolUomId.hashCode() : 0);
        result = 31 * result + (mashTunVol != null ? mashTunVol.hashCode() : 0);
        result = 31 * result + (mashTunUomId != null ? mashTunUomId.hashCode() : 0);
        result = 31 * result + (boilVol != null ? boilVol.hashCode() : 0);
        result = 31 * result + (boilVolUomId != null ? boilVolUomId.hashCode() : 0);
        result = 31 * result + (boilTime != null ? boilTime.hashCode() : 0);
        result = 31 * result + (boilTimeUomId != null ? boilTimeUomId.hashCode() : 0);
        result = 31 * result + (boilOffPerHrVol != null ? boilOffPerHrVol.hashCode() : 0);
        result = 31 * result + (boilOffPerHrUomId != null ? boilOffPerHrUomId.hashCode() : 0);
        result = 31 * result + (boilShrinkage != null ? boilShrinkage.hashCode() : 0);
        result = 31 * result + (boilTotalBoilOff != null ? boilTotalBoilOff.hashCode() : 0);
        result = 31 * result + (boilTotalBoilOffUomId != null ? boilTotalBoilOffUomId.hashCode() : 0);
        result = 31 * result + (boilPostBoilVol != null ? boilPostBoilVol.hashCode() : 0);
        result = 31 * result + (boilPostBoilVolUomId != null ? boilPostBoilVolUomId.hashCode() : 0);
        result = 31 * result + (fermLoss != null ? fermLoss.hashCode() : 0);
        result = 31 * result + (fermLossUomId != null ? fermLossUomId.hashCode() : 0);
        result = 31 * result + (fermTopUp != null ? fermTopUp.hashCode() : 0);
        result = 31 * result + (fermTopUpUomId != null ? fermTopUpUomId.hashCode() : 0);
        result = 31 * result + (fermLossTrubChill != null ? fermLossTrubChill.hashCode() : 0);
        result = 31 * result + (fermLossTrubChillUomId != null ? fermLossTrubChillUomId.hashCode() : 0);
        result = 31 * result + (bottlingVol != null ? bottlingVol.hashCode() : 0);
        result = 31 * result + (bottlingVolUomId != null ? bottlingVolUomId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

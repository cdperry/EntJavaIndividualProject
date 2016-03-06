package com.cdperry.brewday.persistence;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by cdperry on 3/6/16.
 */
public class ComponentWaterEntity {
    private int compWaterId;
    private String name;
    private BigDecimal ph;
    private BigDecimal caPpm;
    private BigDecimal mgPpm;
    private BigDecimal naPpm;
    private BigDecimal so4Ppm;
    private BigDecimal clPpm;
    private BigDecimal hco3Ppm;
    private BigDecimal caso4G;
    private BigDecimal naclG;
    private BigDecimal mgso4G;
    private BigDecimal caclG;
    private BigDecimal nahco3G;
    private BigDecimal caco3G;
    private BigDecimal batchSize;
    private Integer batchSizeUomId;
    private String notes;
    private Date updateDate;
    private Date createDate;

    public int getCompWaterId() {
        return compWaterId;
    }

    public void setCompWaterId(int compWaterId) {
        this.compWaterId = compWaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPh() {
        return ph;
    }

    public void setPh(BigDecimal ph) {
        this.ph = ph;
    }

    public BigDecimal getCaPpm() {
        return caPpm;
    }

    public void setCaPpm(BigDecimal caPpm) {
        this.caPpm = caPpm;
    }

    public BigDecimal getMgPpm() {
        return mgPpm;
    }

    public void setMgPpm(BigDecimal mgPpm) {
        this.mgPpm = mgPpm;
    }

    public BigDecimal getNaPpm() {
        return naPpm;
    }

    public void setNaPpm(BigDecimal naPpm) {
        this.naPpm = naPpm;
    }

    public BigDecimal getSo4Ppm() {
        return so4Ppm;
    }

    public void setSo4Ppm(BigDecimal so4Ppm) {
        this.so4Ppm = so4Ppm;
    }

    public BigDecimal getClPpm() {
        return clPpm;
    }

    public void setClPpm(BigDecimal clPpm) {
        this.clPpm = clPpm;
    }

    public BigDecimal getHco3Ppm() {
        return hco3Ppm;
    }

    public void setHco3Ppm(BigDecimal hco3Ppm) {
        this.hco3Ppm = hco3Ppm;
    }

    public BigDecimal getCaso4G() {
        return caso4G;
    }

    public void setCaso4G(BigDecimal caso4G) {
        this.caso4G = caso4G;
    }

    public BigDecimal getNaclG() {
        return naclG;
    }

    public void setNaclG(BigDecimal naclG) {
        this.naclG = naclG;
    }

    public BigDecimal getMgso4G() {
        return mgso4G;
    }

    public void setMgso4G(BigDecimal mgso4G) {
        this.mgso4G = mgso4G;
    }

    public BigDecimal getCaclG() {
        return caclG;
    }

    public void setCaclG(BigDecimal caclG) {
        this.caclG = caclG;
    }

    public BigDecimal getNahco3G() {
        return nahco3G;
    }

    public void setNahco3G(BigDecimal nahco3G) {
        this.nahco3G = nahco3G;
    }

    public BigDecimal getCaco3G() {
        return caco3G;
    }

    public void setCaco3G(BigDecimal caco3G) {
        this.caco3G = caco3G;
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

        ComponentWaterEntity that = (ComponentWaterEntity) o;

        if (compWaterId != that.compWaterId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ph != null ? !ph.equals(that.ph) : that.ph != null) return false;
        if (caPpm != null ? !caPpm.equals(that.caPpm) : that.caPpm != null) return false;
        if (mgPpm != null ? !mgPpm.equals(that.mgPpm) : that.mgPpm != null) return false;
        if (naPpm != null ? !naPpm.equals(that.naPpm) : that.naPpm != null) return false;
        if (so4Ppm != null ? !so4Ppm.equals(that.so4Ppm) : that.so4Ppm != null) return false;
        if (clPpm != null ? !clPpm.equals(that.clPpm) : that.clPpm != null) return false;
        if (hco3Ppm != null ? !hco3Ppm.equals(that.hco3Ppm) : that.hco3Ppm != null) return false;
        if (caso4G != null ? !caso4G.equals(that.caso4G) : that.caso4G != null) return false;
        if (naclG != null ? !naclG.equals(that.naclG) : that.naclG != null) return false;
        if (mgso4G != null ? !mgso4G.equals(that.mgso4G) : that.mgso4G != null) return false;
        if (caclG != null ? !caclG.equals(that.caclG) : that.caclG != null) return false;
        if (nahco3G != null ? !nahco3G.equals(that.nahco3G) : that.nahco3G != null) return false;
        if (caco3G != null ? !caco3G.equals(that.caco3G) : that.caco3G != null) return false;
        if (batchSize != null ? !batchSize.equals(that.batchSize) : that.batchSize != null) return false;
        if (batchSizeUomId != null ? !batchSizeUomId.equals(that.batchSizeUomId) : that.batchSizeUomId != null)
            return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compWaterId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ph != null ? ph.hashCode() : 0);
        result = 31 * result + (caPpm != null ? caPpm.hashCode() : 0);
        result = 31 * result + (mgPpm != null ? mgPpm.hashCode() : 0);
        result = 31 * result + (naPpm != null ? naPpm.hashCode() : 0);
        result = 31 * result + (so4Ppm != null ? so4Ppm.hashCode() : 0);
        result = 31 * result + (clPpm != null ? clPpm.hashCode() : 0);
        result = 31 * result + (hco3Ppm != null ? hco3Ppm.hashCode() : 0);
        result = 31 * result + (caso4G != null ? caso4G.hashCode() : 0);
        result = 31 * result + (naclG != null ? naclG.hashCode() : 0);
        result = 31 * result + (mgso4G != null ? mgso4G.hashCode() : 0);
        result = 31 * result + (caclG != null ? caclG.hashCode() : 0);
        result = 31 * result + (nahco3G != null ? nahco3G.hashCode() : 0);
        result = 31 * result + (caco3G != null ? caco3G.hashCode() : 0);
        result = 31 * result + (batchSize != null ? batchSize.hashCode() : 0);
        result = 31 * result + (batchSizeUomId != null ? batchSizeUomId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

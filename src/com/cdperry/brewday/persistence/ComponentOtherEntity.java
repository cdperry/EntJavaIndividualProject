package com.cdperry.brewday.persistence;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by cdperry on 3/6/16.
 */
public class ComponentOtherEntity {
    private int compOtherId;
    private String name;
    private String useFor;
    private Integer useTypeId;
    private BigDecimal time;
    private Integer timeUomId;
    private BigDecimal amount;
    private Integer amountUomId;
    private BigDecimal batchSize;
    private Integer batchSizeUomId;
    private String notes;
    private Date updateDate;
    private Date createDate;

    public int getCompOtherId() {
        return compOtherId;
    }

    public void setCompOtherId(int compOtherId) {
        this.compOtherId = compOtherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUseFor() {
        return useFor;
    }

    public void setUseFor(String useFor) {
        this.useFor = useFor;
    }

    public Integer getUseTypeId() {
        return useTypeId;
    }

    public void setUseTypeId(Integer useTypeId) {
        this.useTypeId = useTypeId;
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public Integer getTimeUomId() {
        return timeUomId;
    }

    public void setTimeUomId(Integer timeUomId) {
        this.timeUomId = timeUomId;
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

        ComponentOtherEntity that = (ComponentOtherEntity) o;

        if (compOtherId != that.compOtherId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (useFor != null ? !useFor.equals(that.useFor) : that.useFor != null) return false;
        if (useTypeId != null ? !useTypeId.equals(that.useTypeId) : that.useTypeId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (timeUomId != null ? !timeUomId.equals(that.timeUomId) : that.timeUomId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (amountUomId != null ? !amountUomId.equals(that.amountUomId) : that.amountUomId != null) return false;
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
        int result = compOtherId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (useFor != null ? useFor.hashCode() : 0);
        result = 31 * result + (useTypeId != null ? useTypeId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (timeUomId != null ? timeUomId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (amountUomId != null ? amountUomId.hashCode() : 0);
        result = 31 * result + (batchSize != null ? batchSize.hashCode() : 0);
        result = 31 * result + (batchSizeUomId != null ? batchSizeUomId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
package com.cdperry.brewday.entity;

import java.sql.Timestamp;

/**
 * Created by cdperry on 3/6/16.
 */
public class HopFormTypeEntity {
    private int hopFormId;
    private String name;
    private Timestamp updateDate;
    private Timestamp createDate;

    public int getHopFormId() {
        return hopFormId;
    }

    public void setHopFormId(int hopFormId) {
        this.hopFormId = hopFormId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HopFormTypeEntity that = (HopFormTypeEntity) o;

        if (hopFormId != that.hopFormId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hopFormId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

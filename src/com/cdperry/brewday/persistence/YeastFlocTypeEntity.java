package com.cdperry.brewday.persistence;

import java.sql.Date;

/**
 * Created by cdperry on 3/6/16.
 */
public class YeastFlocTypeEntity {
    private int yeastFlocTypeId;
    private String name;
    private Date updateDate;
    private Date createDate;

    public int getYeastFlocTypeId() {
        return yeastFlocTypeId;
    }

    public void setYeastFlocTypeId(int yeastFlocTypeId) {
        this.yeastFlocTypeId = yeastFlocTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        YeastFlocTypeEntity that = (YeastFlocTypeEntity) o;

        if (yeastFlocTypeId != that.yeastFlocTypeId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = yeastFlocTypeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}

package com.androidapp.yanx.lan_gtd.toggl.entity;

import java.io.Serializable;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 11:59 AM.
 * Description ${TODO}
 */
public class ProjectEntity implements Serializable{
    //    "id":90123,
    public int id;
    //                "wid":777,
    public int wid;
    //                "name":"Our best project",
    public String name;
    //                "billable":true,
    public boolean billable;
    //                "active":true,
    public boolean active;
    //                "at":"2013-02-12T09:47:57+00:00",
    public String at;
    //                "color":"5"
    public int color;

    public ProjectEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

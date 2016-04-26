package com.androidapp.yanx.lan_gtd.toggl.entity;

import java.io.Serializable;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 12:07 PM.
 * Description ${TODO}
 */
public class TaskEntity implements Serializable {

    public String name;

    public int id;

    public int wid;

    public int pid;

    public boolean active;

    public int estimated_seconds;

    public TaskEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEstimated_seconds() {
        return estimated_seconds;
    }

    public void setEstimated_seconds(int estimated_seconds) {
        this.estimated_seconds = estimated_seconds;
    }
}

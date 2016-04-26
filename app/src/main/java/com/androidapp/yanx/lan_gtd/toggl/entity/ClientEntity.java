package com.androidapp.yanx.lan_gtd.toggl.entity;

import java.io.Serializable;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 12:08 PM.
 * Description ${TODO}
 */
public class ClientEntity implements Serializable {
    public int id ;

    public int wid ;

    public String name ;

    public String notes ;

    public String at ;

    public ClientEntity() {
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }
}

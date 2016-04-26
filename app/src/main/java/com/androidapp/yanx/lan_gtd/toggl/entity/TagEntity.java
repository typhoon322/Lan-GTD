package com.androidapp.yanx.lan_gtd.toggl.entity;

import java.io.Serializable;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 12:02 PM.
 * Description ${TODO}
 */
public class TagEntity implements Serializable{
//    "id":238526,
//                "wid":777,
//                "name":"billed"
    public int id ;

    public int wid ;

    public String name ;

    public TagEntity() {
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
}

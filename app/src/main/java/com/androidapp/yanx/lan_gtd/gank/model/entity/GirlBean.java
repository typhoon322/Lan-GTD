package com.androidapp.yanx.lan_gtd.gank.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * com.androidapp.yanx.lan_gtd.gank
 * Created by yanx on 4/23/16 5:08 PM.
 * Description ${TODO}
 */
public class GirlBean implements Serializable{

    public String _id;

    public Date createdAt;

    public String desc;

    public Date publishedAt;

    public String type;

    public String url;

    public boolean used;

    public String who;

    public GirlBean() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}

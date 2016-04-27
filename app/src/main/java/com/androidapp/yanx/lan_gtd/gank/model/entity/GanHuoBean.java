package com.androidapp.yanx.lan_gtd.gank.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * com.androidapp.yanx.lan_gtd.gank.model.entity
 * Created by yanx on 4/26/16 6:13 PM.
 * Description ${TODO}
 */
public class GanHuoBean implements Serializable{

    public String _id;

    public Date createdAt;

    public String desc;

    public Date publishedAt;

    public String source;

    public String type;

    public String url;

    public boolean used;

    public String who;

    public GanHuoBean() {
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

package com.androidapp.yanx.lan_gtd.toggl.entity;

import java.io.Serializable;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 12:52 PM.
 * Description ${TODO}
 */
public class BlogEntity implements Serializable{
    public String category ;

    public String pub_date ;

    public String title ;

    public String url ;

    public BlogEntity() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

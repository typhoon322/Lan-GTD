package com.androidapp.yanx.lan_gtd;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/22/16 10:36 AM.
 * Description ${TODO}
 */
public class MenuEntity {
    public String title;

    public Class clazz;

    public MenuEntity() {
    }

    public MenuEntity(String title, Class clazz) {
        this.title = title;
        this.clazz = clazz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}

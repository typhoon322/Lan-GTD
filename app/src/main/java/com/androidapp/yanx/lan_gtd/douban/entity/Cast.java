package com.androidapp.yanx.lan_gtd.douban.entity;

/**
 * com.androidapp.yanx.lan_gtd.douban
 * Created by yanx on 4/14/16 9:44 PM.
 * Description ${TODO}
 */
public class Cast {

    public String alt ;

    public Image avatars;

    public int id ;

    public String name ;

    public Cast() {
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Image getAvatars() {
        return avatars;
    }

    public void setAvatars(Image avatars) {
        this.avatars = avatars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars.toString() +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

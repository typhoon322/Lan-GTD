package com.androidapp.yanx.lan_gtd.douban;

import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd.douban
 * Created by yanx on 4/14/16 9:52 PM.
 * Description ${TODO}
 */
public class MovieRespInfo {
    public int count ;

    public int start ;

    public int total ;

    public String title ;

    public List<MovieItem> subjects ;

    public MovieRespInfo() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieItem> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieItem> subjects) {
        this.subjects = subjects;
    }
}

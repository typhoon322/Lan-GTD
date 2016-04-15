package com.androidapp.yanx.lan_gtd.douban.entity;

/**
 * com.androidapp.yanx.lan_gtd.douban
 * Created by yanx on 4/14/16 9:48 PM.
 * Description ${TODO}
 */
public class Rating {
    public float average ;

    public int max ;

    public int min ;

    public int stars ;

    public Rating() {
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}

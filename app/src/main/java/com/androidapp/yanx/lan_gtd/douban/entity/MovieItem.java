package com.androidapp.yanx.lan_gtd.douban.entity;

import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd.douban
 * Created by yanx on 4/14/16 9:15 PM.
 * Description ${TODO}
 */
public class MovieItem {

    public String alt ;

    public List<Cast> casts ;

    public int collect_count ;

    public List<Director> directors ;

    public List<String> genres ;

    public int id ;

    public Image images ;

    public String original_title ;

    public Rating rating ;

    public String subtype ;

    public String title ;

    public String year ;

    public MovieItem() {
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MovieItem{" +
                "alt='" + alt + '\'' +
                ", casts=" + casts.toString() +
                ", collect_count=" + collect_count +
                ", directors=" + directors.toString() +
                ", genres=" + genres +
                ", id=" + id +
                ", images=" + images.toString() +
                ", original_title='" + original_title + '\'' +
                ", rating=" + rating +
                ", subtype='" + subtype + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

package com.androidapp.yanx.lan_gtd.toggl.entity;

import java.io.Serializable;
import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 11:42 AM.
 * Description ${TODO}
 */
public class AuthDataEntity implements Serializable{

    public int id;
    public boolean achievements_enabled ;
    public String created_at;
    public boolean manual_mode ;
    public String api_token;
    public int default_wid;
    public String email;
    public String fullname;
    public String jquery_timeofday_format;
    public String jquery_date_format;
    public String timeofday_format;
    public String date_format;
    public boolean store_start_and_stop_time;
    public int beginning_of_week;
    public String language;
    public String duration_format;
    public String image_url;
    public String at;
    public String timezone;
    public int retention;
    public BlogEntity new_blog_post;
    public List<ProjectEntity> projects;
    public List<TagEntity> tags;
    public List<TaskEntity> tasks;
    public List<ClientEntity> clients;

    public boolean openid_enabled ;
    public boolean record_timeline ;
    public boolean render_timeline ;
    public boolean send_product_emails ;
    public boolean send_timer_notifications ;
    public boolean send_weekly_report ;
    public boolean should_upgrade ;
    public boolean sidebar_piechart ;
    public boolean timeline_enabled ;
    public boolean timeline_experiment ;

    public AuthDataEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public int getDefault_wid() {
        return default_wid;
    }

    public void setDefault_wid(int default_wid) {
        this.default_wid = default_wid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJquery_timeofday_format() {
        return jquery_timeofday_format;
    }

    public void setJquery_timeofday_format(String jquery_timeofday_format) {
        this.jquery_timeofday_format = jquery_timeofday_format;
    }

    public String getJquery_date_format() {
        return jquery_date_format;
    }

    public void setJquery_date_format(String jquery_date_format) {
        this.jquery_date_format = jquery_date_format;
    }

    public String getTimeofday_format() {
        return timeofday_format;
    }

    public void setTimeofday_format(String timeofday_format) {
        this.timeofday_format = timeofday_format;
    }

    public String getDate_format() {
        return date_format;
    }

    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }

    public boolean isStore_start_and_stop_time() {
        return store_start_and_stop_time;
    }

    public void setStore_start_and_stop_time(boolean store_start_and_stop_time) {
        this.store_start_and_stop_time = store_start_and_stop_time;
    }

    public int getBeginning_of_week() {
        return beginning_of_week;
    }

    public void setBeginning_of_week(int beginning_of_week) {
        this.beginning_of_week = beginning_of_week;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDuration_format() {
        return duration_format;
    }

    public void setDuration_format(String duration_format) {
        this.duration_format = duration_format;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getRetention() {
        return retention;
    }

    public void setRetention(int retention) {
        this.retention = retention;
    }

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    public List<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }

    public BlogEntity getNew_blog_post() {
        return new_blog_post;
    }

    public void setNew_blog_post(BlogEntity new_blog_post) {
        this.new_blog_post = new_blog_post;
    }
}

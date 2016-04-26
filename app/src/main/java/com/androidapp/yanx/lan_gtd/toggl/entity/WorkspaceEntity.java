package com.androidapp.yanx.lan_gtd.toggl.entity;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 12:04 PM.
 * Description ${TODO}
 */
public class WorkspaceEntity {
//    "admin": true,
//            "api_token": "e43d306f27f0dd596e875ed779273577",
//            "at": "2016-04-13T05:36:28+00:00",
//            "business_tester": false,
//            "campaign": false,
//            "default_currency": "USD",
//            "default_hourly_rate": 0,
//            "ical_enabled": true,
//            "id": 1423893,
//            "name": "Typhoon322's workspace",
//            "only_admins_may_create_projects": false,
//            "only_admins_see_billable_rates": false,
//            "only_admins_see_team_dashboard": false,
//            "premium": false,
//            "profile": 0,
//            "projects_billable_by_default": true,
//            "rounding": 1,
//            "rounding_minutes": 0,

    public boolean admin ;

    public boolean campaign ;

    public boolean business_tester ;

    public boolean ical_enabled ;

    public boolean only_admins_may_create_projects ;

    public boolean only_admins_see_billable_rates ;

    public boolean only_admins_see_team_dashboard ;

    public boolean premium ;

    public int profile ;


    public int id;

    public String name;

    public String at;

    public int default_houly_rate;

    public String default_currency;

    public boolean projects_billable_by_default;

    public int rounding;

    public int rounding_mimutes;

    public String api_token;

    public WorkspaceEntity() {
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isCampaign() {
        return campaign;
    }

    public void setCampaign(boolean campaign) {
        this.campaign = campaign;
    }

    public boolean isBusiness_tester() {
        return business_tester;
    }

    public void setBusiness_tester(boolean business_tester) {
        this.business_tester = business_tester;
    }

    public boolean isIcal_enabled() {
        return ical_enabled;
    }

    public void setIcal_enabled(boolean ical_enabled) {
        this.ical_enabled = ical_enabled;
    }

    public boolean isOnly_admins_may_create_projects() {
        return only_admins_may_create_projects;
    }

    public void setOnly_admins_may_create_projects(boolean only_admins_may_create_projects) {
        this.only_admins_may_create_projects = only_admins_may_create_projects;
    }

    public boolean isOnly_admins_see_billable_rates() {
        return only_admins_see_billable_rates;
    }

    public void setOnly_admins_see_billable_rates(boolean only_admins_see_billable_rates) {
        this.only_admins_see_billable_rates = only_admins_see_billable_rates;
    }

    public boolean isOnly_admins_see_team_dashboard() {
        return only_admins_see_team_dashboard;
    }

    public void setOnly_admins_see_team_dashboard(boolean only_admins_see_team_dashboard) {
        this.only_admins_see_team_dashboard = only_admins_see_team_dashboard;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
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

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public int getDefault_houly_rate() {
        return default_houly_rate;
    }

    public void setDefault_houly_rate(int default_houly_rate) {
        this.default_houly_rate = default_houly_rate;
    }

    public String getDefault_currency() {
        return default_currency;
    }

    public void setDefault_currency(String default_currency) {
        this.default_currency = default_currency;
    }

    public boolean isProjects_billable_by_default() {
        return projects_billable_by_default;
    }

    public void setProjects_billable_by_default(boolean projects_billable_by_default) {
        this.projects_billable_by_default = projects_billable_by_default;
    }

    public int getRounding() {
        return rounding;
    }

    public void setRounding(int rounding) {
        this.rounding = rounding;
    }

    public int getRounding_mimutes() {
        return rounding_mimutes;
    }

    public void setRounding_mimutes(int rounding_mimutes) {
        this.rounding_mimutes = rounding_mimutes;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}

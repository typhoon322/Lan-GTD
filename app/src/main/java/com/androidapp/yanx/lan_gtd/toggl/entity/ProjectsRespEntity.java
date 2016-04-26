package com.androidapp.yanx.lan_gtd.toggl.entity;

import java.io.Serializable;
import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/19/16 2:15 PM.
 * Description ${TODO}
 */
public class ProjectsRespEntity implements Serializable {
    List<ProjectEntity> projects;

    public ProjectsRespEntity() {
    }

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }
}

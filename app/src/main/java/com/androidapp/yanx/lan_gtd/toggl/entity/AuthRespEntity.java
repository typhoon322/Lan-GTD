package com.androidapp.yanx.lan_gtd.toggl.entity;

/**
 * com.androidapp.yanx.lan_gtd.toggl.entity
 * Created by yanx on 4/17/16 12:10 PM.
 * Description ${TODO}
 */
public class AuthRespEntity {
    private long since;

    private AuthDataEntity data;

    public AuthRespEntity() {
    }

    public long getSince() {
        return since;
    }

    public void setSince(long since) {
        this.since = since;
    }

    public AuthDataEntity getData() {
        return data;
    }

    public void setData(AuthDataEntity data) {
        this.data = data;
    }
}

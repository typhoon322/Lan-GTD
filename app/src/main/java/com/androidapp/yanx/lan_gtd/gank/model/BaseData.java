package com.androidapp.yanx.lan_gtd.gank.model;

import java.io.Serializable;

/**
 * com.androidapp.yanx.lan_gtd.gank.model
 * Created by yanx on 4/23/16 5:50 PM.
 * Description ${TODO}
 */
public class BaseData implements Serializable {

    boolean isError;

    @Override
    public String toString() {
        return "BaseData{isError = " + isError + "}";
    }
}

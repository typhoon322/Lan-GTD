package com.androidapp.yanx.lan_gtd.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.androidapp.yanx.lan_gtd.LanApplication;

/**
 * com.androidapp.yanx.lan_gtd.utils
 * Created by yanx on 4/19/16 3:32 PM.
 * Description ${TODO}
 */
public class LanSharedPreference {
    private static LanSharedPreference mInstance;

    private final String NAME = "TogglPref";

    private SharedPreferences preferences;

    private LanSharedPreference() {
        preferences = LanApplication.getInstance().getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public static LanSharedPreference getInstance() {
        if (mInstance == null) {
            mInstance = new LanSharedPreference();
        }
        return mInstance;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }
}

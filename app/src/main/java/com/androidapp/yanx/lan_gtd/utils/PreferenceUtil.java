package com.androidapp.yanx.lan_gtd.utils;

/**
 * com.androidapp.yanx.lan_gtd.utils
 * Created by yanx on 4/19/16 3:37 PM.
 * Description ${TODO}
 */
public class PreferenceUtil {
    public static final String PREF_KEY_CLIENT_ID = "client_id";
    public static final String PREF_KEY_TOKEN = "api_token";

    public static void updateClientId(int id) {
        LanSharedPreference.getInstance().getPreferences().edit().putInt(PREF_KEY_CLIENT_ID, id).commit();
    }

    public static int getClientId() {
        return LanSharedPreference.getInstance().getPreferences().getInt(PREF_KEY_CLIENT_ID, 0);
    }

    public static void updateToken(String token) {
        LanSharedPreference.getInstance().getPreferences().edit().putString(PREF_KEY_TOKEN, token).commit();
    }

    public static String getToken() {
        return LanSharedPreference.getInstance().getPreferences().getString(PREF_KEY_TOKEN, "");
    }
}

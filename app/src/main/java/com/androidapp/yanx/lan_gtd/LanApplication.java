package com.androidapp.yanx.lan_gtd;

import android.app.Application;

import com.androidapp.yanx.lan_gtd.utils.PreferenceUtil;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/19/16 1:39 PM.
 * Description ${TODO}
 */
public class LanApplication extends Application {
    private static LanApplication mInstance;
    private static String apiToken;
    private static int clientId;

    public LanApplication() {
    }

    public static LanApplication getInstance() {
        return mInstance;
    }

    public static String getApiToken() {
        if (null == apiToken || apiToken.equals("")) {
            apiToken = PreferenceUtil.getToken();
        }
        return apiToken;
    }

    public static void setApiToken(String apiToken) {
        LanApplication.apiToken = apiToken;
        PreferenceUtil.updateToken(apiToken);
    }

    public static int getClientId() {
        if (clientId == 0) {
            clientId = PreferenceUtil.getClientId();
        }
        return clientId;
    }

    public static void setClientId(int clientId) {
        LanApplication.clientId = clientId;
        PreferenceUtil.updateClientId(clientId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}

package com.androidapp.yanx.lan_gtd;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/22/16 11:00 AM.
 * Description ${TODO}
 */
public class StringUtil {
    public static boolean isEmpty(String string) {
        if (null == string) return true;
        if ("".equals(string.trim())) return true;
        return false;
    }
}

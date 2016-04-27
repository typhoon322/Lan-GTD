package com.androidapp.yanx.lan_gtd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.androidapp.yanx.lan_gtd.utils
 * Created by yanx on 4/27/16 11:28 AM.
 * Description ${TODO}
 */
public class FormatUtil {

    public static final SimpleDateFormat FORMAT_1 = new SimpleDateFormat("yyyy/MM/dd");

    public static final SimpleDateFormat FORMAT_2 = new SimpleDateFormat("MM/dd");

    public static final SimpleDateFormat FORMAT_3 = new SimpleDateFormat("MM月dd日");

    public static String formatDate(Date date, SimpleDateFormat sdf) {
        return sdf.format(date);
    }
}

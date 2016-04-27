package com.androidapp.yanx.lan_gtd.utils;

import com.androidapp.yanx.lan_gtd.R;

import java.util.Random;

/**
 * com.androidapp.yanx.lan_gtd.utils
 * Created by yanx on 4/27/16 5:08 PM.
 * Description ${TODO}
 */
public class Tools {
    public static int[] colors = new int[]{
            R.color.color_type_1,
            R.color.color_type_2,
            R.color.color_type_3,
            R.color.color_type_4,
            R.color.color_type_5,
            R.color.color_type_6,
            R.color.color_type_7,
            R.color.color_type_8
    };

    static Random random = new Random();

    public static int getRandomColorFromArray(int[] colorResArray) {
        if (colorResArray == null || colorResArray.length == 0) {
            return 0;
        }
        return colorResArray[random.nextInt(colorResArray.length - 1)];
    }

    public static int getRandomColorFromAppColor() {
        return getRandomColorFromArray(colors);
    }
}

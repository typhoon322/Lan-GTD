package com.androidapp.yanx.lan_gtd.toggl;

import android.content.Context;

import com.androidapp.yanx.lan_gtd.R;

/**
 * com.androidapp.yanx.lan_gtd.toggl
 * Created by yanx on 4/21/16 9:06 PM.
 * Description ${TODO}
 */
public class TogglTools {

    public static int getColorById(Context context, int colorId) {
        switch (colorId) {
            case 1:
                return context.getResources().getColor(R.color.color_type_1);
            case 2:
                return context.getResources().getColor(R.color.color_type_2);
            case 3:
                return context.getResources().getColor(R.color.color_type_3);
            case 4:
                return context.getResources().getColor(R.color.color_type_4);
            case 5:
                return context.getResources().getColor(R.color.color_type_5);
            case 6:
                return context.getResources().getColor(R.color.color_type_6);
            case 7:
                return context.getResources().getColor(R.color.color_type_7);
            case 8:
                return context.getResources().getColor(R.color.color_type_8);
            default:
                return context.getResources().getColor(R.color.color_transparent);

        }

    }
}

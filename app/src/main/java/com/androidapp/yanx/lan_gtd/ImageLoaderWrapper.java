package com.androidapp.yanx.lan_gtd;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/24/16 3:54 PM.
 * Description ${TODO}
 */
public class ImageLoaderWrapper {

    public static void showImage(Context context, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(imageView);
    }
}

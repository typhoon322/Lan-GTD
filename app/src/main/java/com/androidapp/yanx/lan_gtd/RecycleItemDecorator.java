package com.androidapp.yanx.lan_gtd;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * com.androidapp.yanx.testfloating.widget
 * Created by yanx on 12/10/15 11:43 PM.
 * Description ${TODO}
 */
public class RecycleItemDecorator extends RecyclerView.ItemDecoration {

    private int space;

    public RecycleItemDecorator(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


        outRect.bottom = space;
        outRect.top = space;

    }
}

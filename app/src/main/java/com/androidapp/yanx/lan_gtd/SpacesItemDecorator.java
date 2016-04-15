package com.androidapp.yanx.lan_gtd;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * com.androidapp.yanx.testfloating.widget
 * Created by yanx on 12/10/15 11:43 PM.
 * Description ${TODO}
 */
public class SpacesItemDecorator extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecorator(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


        outRect.bottom = space;
        outRect.top = space;
        if (parent.getChildAdapterPosition(view) % 2 == 0) {
            outRect.left = space;
            outRect.right = space / 2;
        } else {
            outRect.left = space / 2;
            outRect.right = space;
        }
    }
}

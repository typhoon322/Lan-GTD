package com.androidapp.yanx.lan_gtd.gank.presenters;

import android.content.Context;

import com.androidapp.yanx.lan_gtd.gank.ui.iview.IViewBase;

/**
 * com.androidapp.yanx.lan_gtd.gank.presenters
 * Created by yanx on 4/26/16 8:57 PM.
 * Description ${TODO}
 */
public class CategoryActPresenter extends BasePresenter<IViewBase> {

    public CategoryActPresenter(Context context, IViewBase iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        if (subscription != null)
            subscription.unsubscribe();
    }
}

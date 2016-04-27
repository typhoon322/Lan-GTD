package com.androidapp.yanx.lan_gtd.home;

import android.content.Context;
import android.content.Intent;

import com.androidapp.yanx.lan_gtd.gank.presenters.BasePresenter;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.IViewBase;

/**
 * com.androidapp.yanx.lan_gtd.home
 * Created by yanx on 4/27/16 5:01 PM.
 * Description ${TODO}
 */
public class HomePresenter extends BasePresenter<IViewBase> {
    public HomePresenter(Context context, IViewBase iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void goPage(Class clazz) {
        context.startActivity(new Intent(context, clazz));
    }
}

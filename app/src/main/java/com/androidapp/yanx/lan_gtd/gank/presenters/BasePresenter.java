package com.androidapp.yanx.lan_gtd.gank.presenters;

import android.content.Context;

import com.androidapp.yanx.lan_gtd.gank.ui.iview.IViewBase;

import rx.Subscription;

/**
 * com.androidapp.yanx.lan_gtd.gank
 * Created by yanx on 4/23/16 5:42 PM.
 * Description ${TODO}
 */
public abstract class BasePresenter<T extends IViewBase> {

    protected Subscription subscription;
    protected T iView;
    protected Context context;

    public BasePresenter(Context context, T iView) {
        this.context = context;
        this.iView = iView;
    }

    public void init() {
        iView.initView();
    }

    public abstract void release();

}

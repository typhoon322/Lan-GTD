package com.androidapp.yanx.lan_gtd.gank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.animation.DecelerateInterpolator;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.gank.presenters.BasePresenter;

import butterknife.Bind;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui
 * Created by yanx on 4/24/16 2:30 PM.
 * Description ${TODO}
 */
public abstract class ToolBarBaseActivity<T extends BasePresenter> extends BaseActivity {

    protected boolean isToolBarHiding = false;

    protected ActionBar actionBar;

    protected T presenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.app_bar)
    AppBarLayout appBarLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
    }

    protected boolean canBack() {
        return true;
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayShowHomeEnabled(canBack());
    }

    protected void hideOrShowToolBar() {
        appBarLayout.animate()
                .translationY(isToolBarHiding ? 0 : -appBarLayout.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        isToolBarHiding = !isToolBarHiding;
    }
}

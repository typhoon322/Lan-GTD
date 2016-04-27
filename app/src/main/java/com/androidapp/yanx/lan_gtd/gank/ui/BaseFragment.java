package com.androidapp.yanx.lan_gtd.gank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapp.yanx.lan_gtd.gank.presenters.BasePresenter;

import butterknife.ButterKnife;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui
 * Created by yanx on 4/26/16 8:30 PM.
 * Description ${TODO}
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {


    protected T presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        return view;
    }

    public abstract int getLayoutId();

    public abstract void initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}

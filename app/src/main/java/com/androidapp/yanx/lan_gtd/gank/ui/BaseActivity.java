package com.androidapp.yanx.lan_gtd.gank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.androidapp.yanx.lan_gtd.gank.presenters.BasePresenter;

import butterknife.ButterKnife;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui
 * Created by yanx on 4/24/16 2:07 PM.
 * Description ${TODO}
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    protected T presenter;

    public abstract int getLayoutId();

    public abstract void initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initPresenter();
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        Log.i(TAG, "onDestroy: ");
    }
}

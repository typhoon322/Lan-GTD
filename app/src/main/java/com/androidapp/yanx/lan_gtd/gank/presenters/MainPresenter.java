package com.androidapp.yanx.lan_gtd.gank.presenters;

import android.content.Context;
import android.util.Log;

import com.androidapp.yanx.lan_gtd.gank.http.GankClient;
import com.androidapp.yanx.lan_gtd.gank.model.GirlsData;
import com.androidapp.yanx.lan_gtd.gank.ui.IView.IMainView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * com.androidapp.yanx.lan_gtd.gank.presenters
 * Created by yanx on 4/23/16 6:13 PM.
 * Description ${TODO}
 */
public class MainPresenter extends BasePresenter<IMainView> {

    private static final String TAG = "MainPresenter";

    public MainPresenter(Context context, IMainView iView) {
        super(context, iView);
    }

    public void fetchData(int count) {
        iView.showProgress();
        subscription = GankClient.getGankService().getGirls(count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GirlsData>() {
                    @Override
                    public void call(GirlsData data) {
                        Log.i(TAG, "call: " + data);
                        iView.hideProgress();
                        iView.showData(data.results);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        iView.hideProgress();
                        iView.showErrorView();
                        throwable.printStackTrace();
                        Log.w(TAG, "call: ", throwable);
                    }
                });
    }

    @Override
    public void release() {
        subscription.unsubscribe();
    }
}

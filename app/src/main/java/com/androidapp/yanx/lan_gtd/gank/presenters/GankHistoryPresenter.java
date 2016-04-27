package com.androidapp.yanx.lan_gtd.gank.presenters;

import android.content.Context;
import android.util.Log;

import com.androidapp.yanx.lan_gtd.gank.http.GankClient;
import com.androidapp.yanx.lan_gtd.gank.model.HistoryData;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.IHistoryView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * com.androidapp.yanx.lan_gtd.gank.presenters
 * Created by yanx on 4/27/16 5:43 PM.
 * Description ${TODO}
 */
public class GankHistoryPresenter extends BasePresenter<IHistoryView> {

    private static final String TAG = "GankHistoryPresenter";

    public GankHistoryPresenter(Context context, IHistoryView iView) {
        super(context, iView);
    }

    public void fetchData() {
        iView.showProgress();
        subscription = GankClient.getGankService().getHistoryDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HistoryData>() {
                    @Override
                    public void call(HistoryData historyData) {
                        Log.i(TAG, "call: success " + historyData);
                        iView.hideProgress();
                        iView.showData(historyData.results);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.w(TAG, "call: error ", throwable);
                        iView.hideProgress();
                        iView.showErrorView();
                    }
                });
    }

    @Override
    public void release() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}

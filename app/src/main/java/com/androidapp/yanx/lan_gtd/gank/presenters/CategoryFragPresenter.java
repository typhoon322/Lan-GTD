package com.androidapp.yanx.lan_gtd.gank.presenters;

import android.content.Context;
import android.util.Log;

import com.androidapp.yanx.lan_gtd.gank.http.GankClient;
import com.androidapp.yanx.lan_gtd.gank.http.GankService;
import com.androidapp.yanx.lan_gtd.gank.model.GanhuoData;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.ICategoryView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * com.androidapp.yanx.lan_gtd.gank.presenters
 * Created by yanx on 4/26/16 5:43 PM.
 * Description ${TODO}
 */
public class CategoryFragPresenter extends BasePresenter<ICategoryView> {

    private static final String TAG = "CategoryFragPresenter";

    public CategoryFragPresenter(Context context, ICategoryView iView) {
        super(context, iView);
    }

    public void fetchData(String type, int pageIndex) {
        if (pageIndex == 1) {
            iView.showProgress();
        }
        subscription = GankClient.getGankService()
                .getGanHuoList(type, pageIndex, GankService.PAGE_VOLUME)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GanhuoData>() {
                    @Override
                    public void call(GanhuoData ganhuoData) {
                        Log.i(TAG, "call: ");
                        iView.hideProgress();
                        if (ganhuoData != null) {
                            iView.showData(ganhuoData.results);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.w(TAG, "call: ", throwable);
                        iView.hideProgress();
                        iView.showErrorView();
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    public void release() {
        if (subscription != null)
            subscription.unsubscribe();
    }
}

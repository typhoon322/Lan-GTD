package com.androidapp.yanx.lan_gtd.gank.ui.IView;

import com.androidapp.yanx.lan_gtd.gank.model.entity.GirlBean;

import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui.IView
 * Created by yanx on 4/23/16 5:55 PM.
 * Description ${TODO}
 */
public interface IMainView extends IViewBase {

    void showProgress();

    void hideProgress();

    void showData(List<GirlBean> dataList);

    void showErrorView();

    void showNoMoreData();

}

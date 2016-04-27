package com.androidapp.yanx.lan_gtd.gank.ui.iview;

import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui.iview
 * Created by yanx on 4/26/16 5:44 PM.
 * Description ${TODO}
 */
public interface IHistoryView extends IViewBase {
    void showProgress();

    void hideProgress();

    void showErrorView();

    void showNoMoreData();

    void showData(List<String> dateList);
}

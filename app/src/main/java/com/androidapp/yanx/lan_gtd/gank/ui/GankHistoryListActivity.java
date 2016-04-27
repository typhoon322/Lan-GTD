package com.androidapp.yanx.lan_gtd.gank.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.RecycleOnItemClickListener;
import com.androidapp.yanx.lan_gtd.SpacesItemDecorator;
import com.androidapp.yanx.lan_gtd.gank.adapter.HistoryDateAdapter;
import com.androidapp.yanx.lan_gtd.gank.presenters.GankHistoryPresenter;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.IHistoryView;
import com.androidapp.yanx.lan_gtd.utils.DeviceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui
 * Created by yanx on 4/27/16 5:41 PM.
 * Description ${TODO}
 */
public class GankHistoryListActivity extends ToolBarBaseActivity<GankHistoryPresenter> implements SwipeRefreshLayout.OnRefreshListener, IHistoryView, RecycleOnItemClickListener {


    public HistoryDateAdapter adapter;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;
    private List<String> datalist = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_gank_history;
    }

    @Override
    public void initPresenter() {
        presenter = new GankHistoryPresenter(this, this);
        presenter.init();
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showData(List<String> dateList) {
        if (dateList == null || dateList.size() == 0) {
            Log.i(TAG, "showData: no data");
            return;
        }
        datalist.clear();
        datalist.addAll(dateList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initView() {
        swipeRefreshLayout.setColorSchemeResources(R.color.color_type_1, R.color.color_type_5, R.color.color_type_4);
        swipeRefreshLayout.setDistanceToTriggerSync(DeviceUtil.dp2px(50));
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacesItemDecorator(DeviceUtil.dp2px(15)));
        adapter = new HistoryDateAdapter(this, datalist);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
        requestData();
    }

    private void requestData() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                presenter.fetchData();
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void OnItemClick(View view, Object data) {
        String date = (String) data;
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        requestData();
    }
}

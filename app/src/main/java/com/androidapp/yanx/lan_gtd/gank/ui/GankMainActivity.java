package com.androidapp.yanx.lan_gtd.gank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.RecycleItemDecorator;
import com.androidapp.yanx.lan_gtd.gank.adapter.GankMainAdapter;
import com.androidapp.yanx.lan_gtd.gank.model.entity.GirlBean;
import com.androidapp.yanx.lan_gtd.gank.presenters.MainPresenter;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.IMainView;
import com.androidapp.yanx.lan_gtd.utils.DeviceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * com.androidapp.yanx.lan_gtd.gank
 * Created by yanx on 4/19/16 9:41 PM.
 * Description ${TODO}
 */
public class GankMainActivity extends ToolBarBaseActivity<MainPresenter> implements IMainView, SwipeRefreshLayout.OnRefreshListener {

    static final int page = 20;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    List<GirlBean> dataList;
    GankMainAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_gank;
    }

    @Override
    public void initPresenter() {
        presenter = new MainPresenter(this, this);
        presenter.init();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }

    private void requestData() {
        Log.i(TAG, "requestData: " + page);
        presenter.fetchData(page);
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
    public void showData(List<GirlBean> datalist) {
        Log.i(TAG, "showData: ");
        if (datalist == null || datalist.size() == 0) {
            showNoMoreData();
            return;
        }
        dataList.addAll(datalist);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorView() {
        Log.i(TAG, "showErrorView: ");
    }

    @Override
    public void showNoMoreData() {
        Log.i(TAG, "showNoMoreData: ");
    }

    @Override
    public void initView() {
        dataList = new ArrayList<>();
        adapter = new GankMainAdapter(this, dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecycleItemDecorator(DeviceUtil.dp2px(10)));
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(R.color.blue, R.color.md_deep_orange_400, R.color.green);
        swipeRefreshLayout.setDistanceToTriggerSync(DeviceUtil.dp2px(24));
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                requestData();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isToBottom = dy > 0;
                if (isToBottom) {
                    if (fab.isShown()) {
                        fab.hide();
                    }
                } else {
                    if (!fab.isShown()) {
                        fab.show();
                    }

                }
            }
        });
    }

    @Override
    public void onRefresh() {
        requestData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.release();
    }

    @Override
    protected boolean canBack() {
        return false;
    }

    @OnClick(R.id.fab)
    void onActionButtonClick() {
        presenter.toCategoryActivity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gank, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_today:

                break;

            case R.id.menu_history:
                presenter.toHistoryActivity();
                break;

            case R.id.menu_about:

                break;
        }
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


}

package com.androidapp.yanx.lan_gtd.gank.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidapp.yanx.lan_gtd.utils.DeviceUtil;
import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.RecycleOnItemClickListener;
import com.androidapp.yanx.lan_gtd.gank.adapter.GanhuoListAdapter;
import com.androidapp.yanx.lan_gtd.gank.model.entity.GanHuoBean;
import com.androidapp.yanx.lan_gtd.gank.presenters.CategoryFragPresenter;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.ICategoryView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui
 * Created by yanx on 4/26/16 8:36 PM.
 * Description ${TODO}
 */
public class GanhuoFragment extends BaseFragment<CategoryFragPresenter> implements ICategoryView, SwipeRefreshLayout.OnRefreshListener, RecycleOnItemClickListener {

    public static final String TYPE = "type";
    private static final String TAG = "GanhuoFragment";
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;
    private String type;

    private int pageIndex = 1;
    private GanhuoListAdapter adapter;
    private List<GanHuoBean> dataList = new ArrayList<>();

    public static GanhuoFragment newInstance(String type) {
        GanhuoFragment fragment = new GanhuoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(TYPE);
        }
    }

    private void requestData() {
        Log.i(TAG, "requestData: " + type + " " + pageIndex);
        presenter.fetchData(type, pageIndex);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ganhuo;
    }

    @Override
    public void initPresenter() {
        presenter = new CategoryFragPresenter(getActivity(), this);
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
        Toast.makeText(getActivity(), "Get Data Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoMoreData() {
        Toast.makeText(getActivity(), "No More Data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(List<GanHuoBean> GanhuoList) {

        if (pageIndex == 1) {
            dataList.clear();
        }
        if (GanhuoList.size() > 0) {
            dataList.addAll(GanhuoList);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void initView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                requestData();
            }
        });
        swipeRefreshLayout.setColorSchemeResources(R.color.color_type_1, R.color.color_type_5, R.color.color_type_4);
        swipeRefreshLayout.setDistanceToTriggerSync(DeviceUtil.dp2px(50));
        adapter = new GanhuoListAdapter(getActivity(), dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        requestData();
    }

    @Override
    public void OnItemClick(View view, Object data) {
        if (data != null && data instanceof GanHuoBean) {
            GanHuoBean itemData = (GanHuoBean) data;
            Toast.makeText(getContext(), itemData.get_id() + "", Toast.LENGTH_SHORT).show();
        }
    }
}

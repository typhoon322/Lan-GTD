package com.androidapp.yanx.lan_gtd.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.RecycleOnItemClickListener;
import com.androidapp.yanx.lan_gtd.douban.DoubanActivity;
import com.androidapp.yanx.lan_gtd.gank.presenters.BasePresenter;
import com.androidapp.yanx.lan_gtd.gank.ui.GankMainActivity;
import com.androidapp.yanx.lan_gtd.gank.ui.ToolBarBaseActivity;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.IViewBase;
import com.androidapp.yanx.lan_gtd.toggl.TogglMainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/15/16 9:50 AM.
 * Description ${TODO}
 */
public class HomeActivity extends ToolBarBaseActivity<BasePresenter> implements IViewBase, RecycleOnItemClickListener {


    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;
    long lastClickTime;
    private List<MenuEntity> activityList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initPresenter() {
        presenter = new HomePresenter(this, this);
        presenter.init();
    }


    @Override
    public void OnItemClick(View view, Object data) {
        ((HomePresenter) presenter).goPage((Class<?>) data);
    }

    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - lastClickTime < 600) {
            super.onBackPressed();
        } else {
            lastClickTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityList.add(new MenuEntity("豆瓣", DoubanActivity.class));
        activityList.add(new MenuEntity("Toggl", TogglMainActivity.class));
        activityList.add(new MenuEntity("Gank", GankMainActivity.class));
        HomeAdapter adapter = new HomeAdapter(this, activityList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();
    }
}

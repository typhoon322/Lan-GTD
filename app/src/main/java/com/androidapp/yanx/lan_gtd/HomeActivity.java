package com.androidapp.yanx.lan_gtd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidapp.yanx.lan_gtd.douban.DoubanActivity;
import com.androidapp.yanx.lan_gtd.gank.ui.GankMainActivity;
import com.androidapp.yanx.lan_gtd.toggl.TogglMainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/15/16 9:50 AM.
 * Description ${TODO}
 */
public class HomeActivity extends AppCompatActivity implements RecycleOnItemClickListener {


    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;
    private List<MenuEntity> activityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityList.add(new MenuEntity("豆瓣", DoubanActivity.class));
        activityList.add(new MenuEntity("Toggl", TogglMainActivity.class));
        activityList.add(new MenuEntity("Gank", GankMainActivity.class));
        HomeAdapter adapter = new HomeAdapter(this, activityList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnItemClick(View view, int position) {
        startActivity(new Intent(this, activityList.get(position).clazz));
    }
}

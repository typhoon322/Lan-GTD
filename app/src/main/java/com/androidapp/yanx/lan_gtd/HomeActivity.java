package com.androidapp.yanx.lan_gtd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidapp.yanx.lan_gtd.douban.DoubanActivity;
import com.androidapp.yanx.lan_gtd.toggl.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/15/16 9:50 AM.
 * Description ${TODO}
 */
public class HomeActivity extends AppCompatActivity implements RecycleOnItemClickListener {


    private List<Class> activityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityList.add(DoubanActivity.class);
        activityList.add(LoginActivity.class);
        HomeAdapter adapter = new HomeAdapter(this, activityList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnItemClick(View view, int position) {
        startActivity(new Intent(this, activityList.get(position)));
    }
}

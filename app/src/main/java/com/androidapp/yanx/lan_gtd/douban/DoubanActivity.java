package com.androidapp.yanx.lan_gtd.douban;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidapp.yanx.lan_gtd.utils.DeviceUtil;
import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.SpacesItemDecorator;
import com.androidapp.yanx.lan_gtd.douban.entity.MovieItem;
import com.androidapp.yanx.lan_gtd.douban.entity.MovieRespInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/14/16 8:53 PM.
 * Description ${TODO}
 */
public class DoubanActivity extends Activity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "DoubanActivity";
    final int pageSize = 10;
    int lastVisibleItemPos;
    boolean isLoading = false;
    int index = 0;
    SwipeRefreshLayout swipeRefreshLayout;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager layoutManager;
    private List<MovieItem> movieList = new ArrayList<>();
    private MovieAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        initView();
        requestData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initView() {
        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        swipeRefreshLayout.setDistanceToTriggerSync(DeviceUtil.dp2px(24));
        swipeRefreshLayout.setOnRefreshListener(this);
        layoutManager = new GridLayoutManager(this, 2);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new SpacesItemDecorator(DeviceUtil.dp2px(10)));
        mRecyclerView.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!isLoading && newState == RecyclerView.SCROLL_STATE_IDLE && !swipeRefreshLayout.isRefreshing() && adapter.getItemCount() == lastVisibleItemPos + 1) {
                    isLoading = true;
                    Toast.makeText(getApplicationContext(), "onLoadMore", Toast.LENGTH_SHORT).show();
                    requestData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPos = layoutManager.findLastVisibleItemPosition();
            }
        });

        adapter = new MovieAdapter(this, movieList);
        mRecyclerView.setAdapter(adapter);
    }


    private void requestData() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Log.v(TAG, "requestData: " + index);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        movieService.getTopMovie(index, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieRespInfo>() {
                    @Override
                    public void onCompleted() {
                        Log.v(TAG, "onCompleted: ");
                        isLoading = false;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        isLoading = false;
                        Log.v(TAG, "onError: ", e);
                    }

                    @Override
                    public void onNext(MovieRespInfo movieRespInfo) {
                        Log.v(TAG, "onNext: " + movieRespInfo.count);
                        isLoading = false;
                        showData(movieRespInfo);
                    }
                });

    }

    private void showData(MovieRespInfo respInfo) {
        if (index == 0) {
            swipeRefreshLayout.setRefreshing(false);
            movieList.clear();
        }
        List<MovieItem> tempList = respInfo.getSubjects();
        if (tempList != null) {
            movieList.addAll(tempList);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "load " + tempList.size() + " items complete!!", Toast.LENGTH_SHORT).show();
            index += tempList.size();
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {
        index = 0;
        requestData();
    }


    public interface MovieService {
        @GET("top250")
        Observable<MovieRespInfo> getTopMovie(@Query("start") int start, @Query("count") int count);
    }
}

package com.androidapp.yanx.lan_gtd.toggl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;

import com.androidapp.yanx.lan_gtd.utils.DeviceUtil;
import com.androidapp.yanx.lan_gtd.LanApplication;
import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.SpacesItemDecorator;
import com.androidapp.yanx.lan_gtd.utils.StringUtil;
import com.androidapp.yanx.lan_gtd.toggl.adapter.TogglMainAdapter;
import com.androidapp.yanx.lan_gtd.toggl.entity.ProjectEntity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * com.androidapp.yanx.lan_gtd.toggl
 * Created by yanx on 4/19/16 10:19 AM.
 * Description ${TODO}
 */
public class TogglMainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    public static final String KEY_CLIENT_ID = "client_id";
    private static final String TAG = "TogglMainActivity";
    final int REQUEST_CODE_LOGIN = 1100;
    @Bind(R.id.recycle_view)
    RecyclerView recyclerView;

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
//    int lastVisibleItemPos;
    boolean isLoading;
    Gson gson = new Gson();
    private TogglMainAdapter mAdapter;
    private List<ProjectEntity> projectList;
    private int clientId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            clientId = bundle.getInt(KEY_CLIENT_ID);
        }
        init();
        if (StringUtil.isEmpty(LanApplication.getApiToken())) {
            toLogin();
            return;
        }
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        requestData();
    }

    private void toLogin() {
        startActivityForResult(new Intent(this, LoginActivity.class), REQUEST_CODE_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_LOGIN:
                if (resultCode == RESULT_OK) {
                    if (data != null && data.getExtras() != null) {
                        Bundle bundle = data.getExtras();
                        clientId = bundle.getInt(KEY_CLIENT_ID);
                    }
                    requestData();
                }
                break;
        }
    }

    private void init() {
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        mSwipeRefreshLayout.setDistanceToTriggerSync(DeviceUtil.dp2px(24));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TogglMainAdapter(projectList, this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecorator(5));
        recyclerView.setAdapter(mAdapter);

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (!isLoading && newState == RecyclerView.SCROLL_STATE_IDLE && !mSwipeRefreshLayout.isRefreshing() && mAdapter.getItemCount() == lastVisibleItemPos + 1) {
//                    isLoading = true;
//                    Toast.makeText(getApplicationContext(), "onLoadMore", Toast.LENGTH_SHORT).show();
//                    requestData();
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                lastVisibleItemPos = linearLayoutManager.findLastVisibleItemPosition();
//            }
//        });
    }

    private void requestData() {
        if (clientId == 0) {
            clientId = LanApplication.getClientId();
        }
        if (clientId == 0) {
            toLogin();
            Log.i(TAG, "requestData: client_id == 0");
            return;
        }

        String tokenStr = LanApplication.getApiToken() + ":api_token";
        final String credential = "Basic " + new String(Base64.encode(tokenStr.getBytes(), Base64.DEFAULT)).replace("\n", "");

        Interceptor networkInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.i(TAG, "intercept: " + request.toString());
                Log.i(TAG, "intercept: headers == " + request.headers().toString());
                return chain.proceed(request);
            }
        };


        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(networkInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        TogglService togglService = retrofit.create(TogglService.class);
        togglService
                .getClientProjects(ApiManager.CONTENT_TYPE_JSON, credential, clientId, "both")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonArray>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted: ");
                        isLoading = false;
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.w(TAG, "onError: ", e);
                        isLoading = false;
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onNext(JsonArray jsonArray) {
                        Log.i(TAG, "onNext: " + jsonArray.toString());
                        isLoading = false;
                        mSwipeRefreshLayout.setRefreshing(false);
                        Type listType = new TypeToken<ProjectEntity>() {
                        }.getType();
                        List<ProjectEntity> tempList = new ArrayList<>();

                        for (int i = 0; i < jsonArray.size(); i++) {
                            ProjectEntity temp = gson.fromJson(jsonArray.get(i), listType);
                            tempList.add(temp);
                        }
                        showData(tempList);

                    }
                });
    }

    private void showData(List<ProjectEntity> list) {
        if (list == null) {
            return;
        }
        if (projectList == null) {
            projectList = new ArrayList<>();
            mAdapter.setDatalist(projectList);
        }
        projectList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        projectList.clear();
        requestData();
    }
}

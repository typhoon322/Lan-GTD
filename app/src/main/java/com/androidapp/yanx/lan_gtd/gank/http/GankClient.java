package com.androidapp.yanx.lan_gtd.gank.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * com.androidapp.yanx.lan_gtd.gank.http
 * Created by yanx on 4/23/16 6:38 PM.
 * Description ${TODO}
 */
public class GankClient {
    public final static String BASE_URL = "http://gank.io/api/";
    protected final static Object lock = new Object();
    private static Retrofit retrofit;
    private static GankService gankService;

    static {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
        OkHttpClient client = new OkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)

                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static GankService getGankService() {
        if (gankService == null) {
            synchronized (lock) {
                gankService = retrofit.create(GankService.class);
            }
        }

        return gankService;
    }
}

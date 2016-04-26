package com.androidapp.yanx.lan_gtd.toggl;

import android.util.Base64;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * com.androidapp.yanx.lan_gtd.toggl
 * Created by yanx on 4/17/16 11:37 AM.
 * Description ${TODO}
 */
public class ApiManager {
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String TAG = "ApiManager";
    public final static String BASE_URL = "https://www.toggl.com/api/v8/";

    private static Retrofit mRetrofit;

    public static Retrofit getRetrofit() {
        if (mRetrofit == null) {

//            String tokenStr = LanApplication.getApiToken() + ":api_token";
            String tokenStr = "typhoon322@qq.com:19880322";
            final String credential = "Basic " + new String(Base64.encode(tokenStr.getBytes(), Base64.DEFAULT)).replace("\n", "");

            Interceptor mNetworkInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    request.newBuilder()
                            .header("Content-Type", CONTENT_TYPE_JSON)
                            .header("Authorization", credential)
                            .build();
                    Log.i(TAG, "intercept: " + request.toString());
                    Log.i(TAG, "intercept: headers == " + request.headers().toString());
                    return chain.proceed(request);
                }
            };

            OkHttpClient client = new OkHttpClient.Builder()
                    .addNetworkInterceptor(mNetworkInterceptor)
                    .build();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }


}

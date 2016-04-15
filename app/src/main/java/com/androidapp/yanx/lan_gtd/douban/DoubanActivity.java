package com.androidapp.yanx.lan_gtd.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.androidapp.yanx.lan_gtd.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/14/16 8:53 PM.
 * Description ${TODO}
 */
public class DoubanActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DoubanActivity";

    private RecyclerView mRecyclerView;

    //https://api.douban.com/v2/movie/top250?start=0&count=10



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douban);
        initView();
        requestData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
    }



    private void requestData(){
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;

        MovieService movieService = retrofit.create(MovieService.class) ;
        Call<MovieRespInfo> call = movieService.getTopMovie(0,15) ;
        call.enqueue(new Callback<MovieRespInfo>() {
            @Override
            public void onResponse(Call<MovieRespInfo> call, Response<MovieRespInfo> response) {
                Log.i(TAG, "onResponse: " + response.body().getTitle());
            }

            @Override
            public void onFailure(Call<MovieRespInfo> call, Throwable t) {
                    t.printStackTrace();
            }
        });
    }

    public interface MovieService{
        @GET("top250")
            Call<MovieRespInfo> getTopMovie(@Query("start")int start,@Query("count") int count) ;
    }



    @Override
    public void onClick(View view) {

    }
}

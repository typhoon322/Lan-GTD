package com.androidapp.yanx.lan_gtd.gank.http;

import com.androidapp.yanx.lan_gtd.gank.model.GirlsData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * com.androidapp.yanx.lan_gtd.gank
 * Created by yanx on 4/19/16 9:51 PM.
 * Description ${TODO}
 */
public interface GankService {


    @GET("random/data/福利/" + "{count}")
    Observable<GirlsData> getGirls(@Path("count") int pageIndex);

}

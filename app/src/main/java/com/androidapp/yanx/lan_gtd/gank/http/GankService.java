package com.androidapp.yanx.lan_gtd.gank.http;

import com.androidapp.yanx.lan_gtd.gank.model.GanhuoData;
import com.androidapp.yanx.lan_gtd.gank.model.GirlsData;
import com.androidapp.yanx.lan_gtd.gank.model.HistoryData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * com.androidapp.yanx.lan_gtd.gank
 * Created by yanx on 4/19/16 9:51 PM.
 * Description ${TODO}
 */
public interface GankService {

    int PAGE_VOLUME = 10;


    @GET("random/data/福利/" + "{count}")
    Observable<GirlsData> getGirls(@Path("count") int pageIndex);

    @GET("data/{type}/{pageSize}/{pageIndex}")
    Observable<GanhuoData> getGanHuoList(@Path("type") String type,
                                         @Path("pageIndex") int pageIndex,
                                         @Path("pageSize") int PageSize);

    @GET("day/history")
    Observable<HistoryData> getHistoryDate();

}

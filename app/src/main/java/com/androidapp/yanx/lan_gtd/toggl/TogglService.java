package com.androidapp.yanx.lan_gtd.toggl;

import com.androidapp.yanx.lan_gtd.toggl.entity.AuthRespEntity;
import com.google.gson.JsonArray;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * com.androidapp.yanx.lan_gtd.toggl
 * Created by yanx on 4/17/16 11:39 AM.
 * Description ${TODO}
 */
public interface TogglService {

    /**
     * 用户名密码登录
     *
     * @param contentType
     * @param token
     * @param getConnectedInfo
     * @return
     */
    @GET("me")
    Observable<AuthRespEntity> auth(@Header("Content-Type") String contentType,
                                    @Header("Authorization") String token,
                                    @Query("with_related_data") boolean getConnectedInfo);

    /**
     * token登录
     *
     * @param getConnectedInfo
     * @return
     */
    @GET("me")
    Observable<AuthRespEntity> auth(@Query("with_related_data") boolean getConnectedInfo);

//    @GET("clients/{client_id}/projects")
//    Observable<List<ProjectEntity>> getClientProjects(@Header("Content-Type") String contentType,
//                                                      @Header("Authorization") String token,
//                                                      @Path("client_id") int clientId);

//    @GET("clients/{client_id}/projects")
//    Call<ResponseBody> getClientProjects(@Header("Content-Type") String contentType,
//                                         @Header("Authorization") String token,
//                                         @Path("client_id") int clientId,
//                                         @Query("active") String active);

    @GET("clients/{client_id}/projects")
    Observable<JsonArray> getClientProjects(@Header("Content-Type") String contentType,
                                            @Header("Authorization") String token,
                                            @Path("client_id") int clientId,
                                            @Query("active") String active);
}

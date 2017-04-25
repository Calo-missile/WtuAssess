package com.hsc.wtuassess.net.procomments.imp;

import com.hsc.wtuassess.net.procomments.ProComModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 15827 on 2017/4/24.
 */

public interface ProCommentsImpl {
    //firstResult=0&maxResult=5
    @GET("productComments.do?productCommentsListById")
    Call<ProComModel> getProComments(@Query("id") String id, @Query("firstResult") String firstResult,
                                     @Query("maxResult") String maxResult);
}

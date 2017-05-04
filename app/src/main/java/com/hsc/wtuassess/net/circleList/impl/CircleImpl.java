package com.hsc.wtuassess.net.circleList.impl;

import com.hsc.wtuassess.net.circleList.CircleModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 15827 on 2017/5/4.
 */

public interface CircleImpl {

    //firstResult=0&maxResult=3
    @GET("mood.do?moodList")
    Call<CircleModel> getCircleList(@Query("firstResult") String firstResult, @Query("maxResult") String maxResult);
}

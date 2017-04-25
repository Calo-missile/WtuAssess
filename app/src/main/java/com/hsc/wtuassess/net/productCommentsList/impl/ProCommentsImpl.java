package com.hsc.wtuassess.net.productCommentsList.impl;

import com.hsc.wtuassess.net.productCommentsList.ProCommentsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 15827 on 2017/4/18.
 */

public interface ProCommentsImpl {
    //商品评价impl   firstResult=0&maxResult
    @GET("productComments.do?productCommentsListById")
    Call<ProCommentsModel> getProComments(@Query("id") String id, @Query("firstResult") String firstResult,
                                          @Query("maxResult") String maxResult);
}

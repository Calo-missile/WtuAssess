package com.hsc.wtuassess.net.productList.impl;

import com.hsc.wtuassess.net.productList.ProductListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 15827 on 2017/4/12.
 */

public interface ProductListImpl {
    //firstResult=0&maxResult=10
    @GET("product.do?productListByHitCount")
    Call<ProductListModel> getProductList(@Query("firstResult") String firstResult, @Query("maxResult") String maxResult) ;
    
}

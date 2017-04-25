package com.hsc.wtuassess.net.retrofitProductDetail.impl;

import com.hsc.wtuassess.net.retrofitProductDetail.ProductDetailModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 15827 on 2017/4/17.
 */

public interface ProductDetailmpl {
    
    //product.do?productById
    @GET("product.do?productById")
    Call<ProductDetailModel> getProductDetail(@Query("id") String id);
}

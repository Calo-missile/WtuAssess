package com.hsc.wtuassess.net.userDetail.imp;

import com.hsc.wtuassess.net.userDetail.UserDetailModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 15827 on 2017/5/5.
 */

public interface UserDetailImpl {

    @GET("member.do?memberById")
    Call<UserDetailModel> getUserDetail(@Query("id") String id);
}

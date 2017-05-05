package com.hsc.wtuassess.net.userDetail.service;

import android.os.Handler;
import android.util.Log;

import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.net.userDetail.UserDetailModel;
import com.hsc.wtuassess.net.userDetail.imp.UserDetailImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by 15827 on 2017/5/5.
 */

public class UserDetailService {

    public final static int MESSAGE_SUCCESS = 0x0001;
    public final static int MESSAGE_FAIL = 0x0002;
    public final static int MESSAGE_ERROR = 0x0003;
    public final static int MESSAGE_INIT = 0x0004;

    public void getUserDetail(Handler handler, String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserDetailImpl api = retrofit.create(UserDetailImpl.class);
        Call<UserDetailModel> call = api.getUserDetail(id);
        call.enqueue(new Callback<UserDetailModel>() {
            @Override
            public void onResponse(Call<UserDetailModel> call, Response<UserDetailModel> response) {
                Log.i(TAG, "onResponse: " + response.body().getMsg());
            }

            @Override
            public void onFailure(Call<UserDetailModel> call, Throwable t) {
                Log.i(TAG, "onFailure"+ t.toString());
            }
        });
    }
}

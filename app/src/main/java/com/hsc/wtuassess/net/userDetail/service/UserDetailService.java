package com.hsc.wtuassess.net.userDetail.service;

import android.os.Handler;
import android.os.Message;
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

    public void getUserDetail(final Handler handler, String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserDetailImpl api = retrofit.create(UserDetailImpl.class);
        Call<UserDetailModel> call = api.getUserDetail(id);
        call.enqueue(new Callback<UserDetailModel>() {
            @Override
            public void onResponse(Call<UserDetailModel> call, Response<UserDetailModel> response) {
                Message message = Message.obtain();
                boolean flag = false;
                if (response.body() != null) {
                    flag = response.body().isSuccess();
                    if (flag) {
                        message.what = MESSAGE_SUCCESS;
                        message.obj = response.body().getData0();
                    } else {
                        message.what = MESSAGE_FAIL;
                        message.obj = response.body().getData0();
                    }
                } else {
                    message.what = MESSAGE_ERROR;
                    message.obj = "is null";
                }
                handler.sendMessage(message);
            }

            @Override
            public void onFailure(Call<UserDetailModel> call, Throwable t) {
                Message message = Message.obtain();
                message.what = MESSAGE_ERROR;
                message.obj = t.toString();
                handler.sendMessage(message);
                Log.i(TAG, "onFailure"+ t.toString());
            }
        });
    }
}

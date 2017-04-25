package com.hsc.wtuassess.net.procomments.service;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.net.procomments.ProComModel;
import com.hsc.wtuassess.net.procomments.imp.ProCommentsImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by 15827 on 2017/4/24.
 */

public class ProCommentsService {

    public final static int MESSAGE_SUCCESS = 0x0001;
    public final static int MESSAGE_FAIL = 0x0002;
    public final static int MESSAGE_ERROR = 0x0003;
    public final static int MESSAGE_INIT = 0x0004;

    public void getProComments(final Handler handler,String id, String[] params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProCommentsImpl api = retrofit.create(ProCommentsImpl.class);
        Call<ProComModel> call = api.getProComments(id, params[0], params[1]);
        call.enqueue(new Callback<ProComModel>() {
            @Override
            public void onResponse(Call<ProComModel> call, Response<ProComModel> response) {
                Message message = Message.obtain();
                boolean flag = false;
                //Log.i("info", "getProComments: "+String.valueOf(response.body().getSuccess()));
                Log.i("info", "status: "+response.code());
                if (response.body() != null) {
                    flag = response.body().getSuccess();
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
            public void onFailure(Call<ProComModel> call, Throwable t) {
                Message message = Message.obtain();
                message.what = MESSAGE_ERROR;
                message.obj = t.toString();
                handler.sendMessage(message);
                Log.i("info", "onFailure: " + t.toString());
            }
        });
    }
}

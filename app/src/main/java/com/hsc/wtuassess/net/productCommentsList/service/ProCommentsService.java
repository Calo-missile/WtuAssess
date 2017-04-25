package com.hsc.wtuassess.net.productCommentsList.service;

import android.util.Log;

import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.net.productCommentsList.ProCommentsModel;
import com.hsc.wtuassess.net.productCommentsList.impl.ProCommentsImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 15827 on 2017/4/18.
 */

public class ProCommentsService {

    public final static int MESSAGE_SUCCESS = 0x0001;
    public final static int MESSAGE_FAIL = 0x0002;
    public final static int MESSAGE_ERROR = 0x0003;
    public final static int MESSAGE_INIT = 0x0004;

    public void getProComments(String[] parmas) {
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProCommentsImpl api = retrofit.create(ProCommentsImpl.class);
        Call<ProCommentsModel> call = api.getProComments(parmas[0], parmas[1],parmas[2]);
        call.enqueue(new Callback<ProCommentsModel>() {
            @Override
            public void onResponse(Call<ProCommentsModel> call, Response<ProCommentsModel> response) {
                Log.i("info", "onResponse: onResponse");
                /*ProCommentsModel commentsModel = response.body();
                Log.i("info", "onResponse: commentsModel+msg" + commentsModel.getMsg());*/
            }

            @Override
            public void onFailure(Call<ProCommentsModel> call, Throwable t) {
                Log.i("info", "onFailure: is fail");
            }
        });
    }
}

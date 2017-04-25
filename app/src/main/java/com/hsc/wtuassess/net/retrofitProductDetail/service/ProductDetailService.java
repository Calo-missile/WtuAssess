package com.hsc.wtuassess.net.retrofitProductDetail.service;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.net.retrofitProductDetail.ProductDetailModel;
import com.hsc.wtuassess.net.retrofitProductDetail.impl.ProductDetailmpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by 15827 on 2017/4/17.
 */

public class ProductDetailService {

    public final static int MESSAGE_SUCCESS = 0x0001;
    public final static int MESSAGE_FAIL = 0x0002;
    public final static int MESSAGE_ERROR = 0x0003;
    public final static int MESSAGE_INIT = 0x0004;

    public void getProductDetail(final Handler handler, String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductDetailmpl api = retrofit.create(ProductDetailmpl.class);
        Call<ProductDetailModel> call = api.getProductDetail(id);
        call.enqueue(new Callback<ProductDetailModel>() {
            @Override
            public void onResponse(Call<ProductDetailModel> call, Response<ProductDetailModel> response) {
                Message message = Message.obtain();
                boolean flag = false;
                if (response.body() != null) {
                    flag = response.body().getSuccess();
                    /*ProductDetailModel model = null;
                    model = response.body();
                    Log.i("info", "onResponse: response.body()Service"+model.getMsg());*/
                    
                    if (flag) {
                        message.what = MESSAGE_SUCCESS;
                        message.obj = response.body().getData0();
                        Log.i("info", "onResponse: ");
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
            public void onFailure(Call<ProductDetailModel> call, Throwable t) {
                Message message = Message.obtain();
                message.what = MESSAGE_ERROR;
                message.obj = t.toString();
                handler.sendMessage(message);
                Log.i("info", t.toString());
            }
        });
    }
}

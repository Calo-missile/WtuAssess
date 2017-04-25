package com.hsc.wtuassess.net.productList.service;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.net.productList.ProductListModel;
import com.hsc.wtuassess.net.productList.impl.ProductListImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 15827 on 2017/4/12.
 */

public class ProductListService {
    
    public final static int MESSAGE_SUCCESS = 0x0001;
    public final static int MESSAGE_FAIL = 0x0002;
    public final static int MESSAGE_ERROR = 0x0003;
    public final static int MESSAGE_INIT = 0x0004;
    public String contextMsg;

    public void getProductList(final Handler handler, String[] params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductListImpl api = retrofit.create(ProductListImpl.class);
        Call<ProductListModel> call = api.getProductList(params[0], params[1]);
        call.enqueue(new Callback<ProductListModel>() {
            @Override
            public void onResponse(Call<ProductListModel> call, Response<ProductListModel> response) {
                Message message = Message.obtain();
                boolean flag = false;
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
                //Log.i("info", "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<ProductListModel> call, Throwable t) {
                Message message = Message.obtain();
                message.what = MESSAGE_ERROR;
                message.obj = t.toString();
                handler.sendMessage(message);
                Log.i("info", "onFailure: " + t.toString());
            }
        });
    }
}

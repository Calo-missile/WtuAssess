package com.hsc.wtuassess.net.retrofitProductDetail;

/**
 * Created by 15827 on 2017/4/16.
 */

public class ProductDetailModel {

    private boolean success;

    private String msg;

    private DataDetail data0;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDetail getData0() {
        return data0;
    }

    public void setData0(DataDetail data0) {
        this.data0 = data0;
    }
}

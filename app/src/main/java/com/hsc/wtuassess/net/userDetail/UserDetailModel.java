package com.hsc.wtuassess.net.userDetail;

/**
 * Created by 15827 on 2017/5/5.
 */

public class UserDetailModel {

    private boolean success;

    private String msg;

    private UserDetailData0 data0;

    public boolean isSuccess() {
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

    public UserDetailData0 getData0() {
        return data0;
    }

    public void setData0(UserDetailData0 data0) {
        this.data0 = data0;
    }
}

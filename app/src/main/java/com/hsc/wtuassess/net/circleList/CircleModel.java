package com.hsc.wtuassess.net.circleList;

import java.util.List;

/**
 * Created by 15827 on 2017/5/4.
 */

public class CircleModel {

    private boolean success;

    private String msg;

    private List<CircleData0> data0 ;

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

    public List<CircleData0> getData0() {
        return data0;
    }

    public void setData0(List<CircleData0> data0) {
        this.data0 = data0;
    }
}

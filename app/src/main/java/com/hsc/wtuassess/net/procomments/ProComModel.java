package com.hsc.wtuassess.net.procomments;

import java.util.List;

/**
 * Created by 15827 on 2017/4/24.
 */

public class ProComModel {

    private boolean success;

    private String msg;

    private List<ProComData0> data0;

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

    public List<ProComData0> getData0() {
        return data0;
    }

    public void setData0(List<ProComData0> data0) {
        this.data0 = data0;
    }
}

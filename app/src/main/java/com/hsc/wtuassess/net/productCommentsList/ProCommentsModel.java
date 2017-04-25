package com.hsc.wtuassess.net.productCommentsList;

import java.util.List;

/**
 * Created by 15827 on 2017/4/18.
 */

public class ProCommentsModel {
    private boolean success;

    private String msg;

    private List<CommentsData0> data0 ;

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

    public List<CommentsData0> getData0() {
        return data0;
    }

    public void setData0(List<CommentsData0> data0) {
        this.data0 = data0;
    }
}

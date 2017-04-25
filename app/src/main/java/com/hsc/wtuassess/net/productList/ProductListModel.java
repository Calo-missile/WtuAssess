package com.hsc.wtuassess.net.productList;

import java.util.List;

/**
 * Created by 15827 on 2017/4/12.
 */

public class ProductListModel {
    
    private boolean success;

    private String msg;

    private List<Data0> data0 ;

    public void setSuccess(boolean success){
        this.success = success;
    }
    public boolean getSuccess(){
        return this.success;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setData0(List<Data0> data0){
        this.data0 = data0;
    }
    public List<Data0> getData0(){
        return this.data0;
    }
}

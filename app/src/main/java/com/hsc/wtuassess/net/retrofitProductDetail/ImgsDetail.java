package com.hsc.wtuassess.net.retrofitProductDetail;

/**
 * Created by 15827 on 2017/4/16.
 */

public class ImgsDetail {
    private String id;

    private String setOrder;

    private String source;

    private String large;

    private String medium;

    private String thumbnail;

    private String extend;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setSetOrder(String setOrder){
        this.setOrder = setOrder;
    }
    public String getSetOrder(){
        return this.setOrder;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }
    public void setLarge(String large){
        this.large = large;
    }
    public String getLarge(){
        return this.large;
    }
    public void setMedium(String medium){
        this.medium = medium;
    }
    public String getMedium(){
        return this.medium;
    }
    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }
    public String getThumbnail(){
        return this.thumbnail;
    }
    public void setExtend(String extend){
        this.extend = extend;
    }
    public String getExtend(){
        return this.extend;
    }
}

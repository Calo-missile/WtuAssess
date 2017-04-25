package com.hsc.wtuassess.net.productList;

/**
 * Created by 15827 on 2017/4/12.
 */

public class Data0 {
    private String id;

    private String name;

    private String image;

    private int hitCount;

    private int commentCount;

    private long createDate;

    private String summary;

    private Category category;

    private Brand brand;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return this.image;
    }
    public void setHitCount(int hitCount){
        this.hitCount = hitCount;
    }
    public int getHitCount(){
        return this.hitCount;
    }
    public void setCommentCount(int commentCount){
        this.commentCount = commentCount;
    }
    public int getCommentCount(){
        return this.commentCount;
    }
    public void setCreateDate(long createDate){
        this.createDate = createDate;
    }
    public long getCreateDate(){
        return this.createDate;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }
    public String getSummary(){
        return this.summary;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public Category getCategory(){
        return this.category;
    }
    public void setBrand(Brand brand){
        this.brand = brand;
    }
    public Brand getBrand(){
        return this.brand;
    }

}

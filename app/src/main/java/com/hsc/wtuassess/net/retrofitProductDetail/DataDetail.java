package com.hsc.wtuassess.net.retrofitProductDetail;

import java.util.List;

/**
 * Created by 15827 on 2017/4/16.
 */

public class DataDetail {
    private String id;

    private String name;

    private String image;

    private int hitCount;

    private int commentCount;

    private long createDate;

    private String content;

    private String summary;

    private CategoryPDetail category;

    private List<ImgsDetail> imgs ;

    private List<CommentsDetail> comments ;

    private BrandDetail brand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public CategoryPDetail getCategory() {
        return category;
    }

    public void setCategory(CategoryPDetail category) {
        this.category = category;
    }

    public List<ImgsDetail> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgsDetail> imgs) {
        this.imgs = imgs;
    }

    public List<CommentsDetail> getComments() {
        return comments;
    }

    public void setComments(List<CommentsDetail> comments) {
        this.comments = comments;
    }

    public BrandDetail getBrand() {
        return brand;
    }

    public void setBrand(BrandDetail brand) {
        this.brand = brand;
    }
}

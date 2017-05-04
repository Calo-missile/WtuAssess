package com.hsc.wtuassess.net.circleList;

/**
 * Created by 15827 on 2017/5/4.
 */

public class CircleData0 {

    private String id;

    private int browseCount;

    private int hitCount;

    private int reviewCount;

    private boolean isShow;

    private long createDate;

    private String content;

    private CircleMember member;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
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

    public CircleMember getMember() {
        return member;
    }

    public void setMember(CircleMember member) {
        this.member = member;
    }
}

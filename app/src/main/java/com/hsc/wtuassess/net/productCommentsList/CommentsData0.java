package com.hsc.wtuassess.net.productCommentsList;

/**
 * Created by 15827 on 2017/4/18.
 */

public class CommentsData0 {
    private String id;

    private int score;

    private boolean isShow;

    private long createDate;

    private String content;

    private CommentsMember member;

    private CommentsProduct product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public CommentsMember getMember() {
        return member;
    }

    public void setMember(CommentsMember member) {
        this.member = member;
    }

    public CommentsProduct getProduct() {
        return product;
    }

    public void setProduct(CommentsProduct product) {
        this.product = product;
    }
}

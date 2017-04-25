package com.hsc.wtuassess.net.retrofitProductDetail;

/**
 * Created by 15827 on 2017/4/16.
 */

public class CommentsDetail {
    private String id;

    private String content;

    private MemberDetail member;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setMember(MemberDetail member){
        this.member = member;
    }

    public MemberDetail getMember() {
        return member;
    }
}

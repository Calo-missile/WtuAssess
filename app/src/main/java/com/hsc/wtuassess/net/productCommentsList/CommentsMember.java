package com.hsc.wtuassess.net.productCommentsList;

/**
 * Created by 15827 on 2017/4/18.
 */

public class CommentsMember {
    private String id;

    private String username;

    private boolean isEnabled;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setIsEnabled(boolean isEnabled){
        this.isEnabled = isEnabled;
    }
    public boolean getIsEnabled(){
        return this.isEnabled;
    }
}

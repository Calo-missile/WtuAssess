package com.hsc.wtuassess.context;

/**
 * Created by 15827 on 2017/4/12.
 */

public class AppConfig {

    public final static String PROTOCOL = "http";

    public final static String IP = "120.77.34.145";

    public final static String PORT = "8080";

    public final static String PATH_BASE = "WTU";

    public final static String PATH_API = "api";

    public final static String API = PROTOCOL+"://"+IP+":"+PORT+"/"+PATH_BASE+"/"+PATH_API+"/";

    public final static String PROJECT = PROTOCOL+"://"+IP+":"+PORT+"/"+PATH_BASE+"/";
}

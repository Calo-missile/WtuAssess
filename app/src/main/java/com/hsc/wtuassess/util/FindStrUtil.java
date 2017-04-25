package com.hsc.wtuassess.util;

/**
 * Created by 15827 on 2017/4/20.
 */

public class FindStrUtil {
    
    public static String findString(String str) {
        //<p>欢迎使用武汉纺织大学数学与计算机学院后台系统!</p>
        //String.substring(int beginIndex, int endIndex)
        /*String s = "abcdefgabcdefg";
        int i = s.indexOf("cd");// out 2*/
        int endIndex = str.indexOf("</p>");
        String panduan = str.substring(3, 4);
        String s1 = new String("<");
        if (panduan.equals(s1)) {//.equals是比较两个对象
            return "抱歉 哈！服务器出错了！";
        } else {
            String contents = str.substring(3, endIndex);
            /*Log.i("info", "findString: contents:" + panduan);

            Log.i("info", "findString: contents:" + contents);*/
            return contents;
        }
    }
}

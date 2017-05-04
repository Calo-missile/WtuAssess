package com.hsc.wtuassess.acti;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.net.circleList.CircleData0;
import com.hsc.wtuassess.net.circleList.service.CircleListService;
import com.hsc.wtuassess.net.procomments.service.ProCommentsService;

import java.util.ArrayList;
import java.util.List;


public class TestActivity extends BaseActivity{

    private static final String TAG = "TestActivity";

    private TextView testNet;

    private ProCommentsService mCommentsService;

    private int pFirstPage = 0;

    private int pPageMax = 3;

    public int getpFirstPage() {
        return pFirstPage;
    }

    public int getpPageMax() {
        return pPageMax;
    }

    public void setpFirstPage(int pFirstPage) {
        this.pFirstPage = pFirstPage;
    }

    public void setpPageMax(int pPageMax) {
        this.pPageMax = pPageMax;
    }

    private List<CircleData0> datas = new ArrayList<>();
    
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case CircleListService.MESSAGE_SUCCESS:
                    datas = (List<CircleData0>) msg.obj;
                    Log.i(TAG, "handleMessage: " + datas.get(0).getContent());
                    break;
                case CircleListService.MESSAGE_ERROR:
                    Log.i(TAG, "handleMessage: fail");
            }
        }
    };

    @Override
    protected int returnLayoutRes() {
        return R.layout.activity_recycler;
    }
    
    @Override
    protected void initComponent() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {
        String [] params = {String.valueOf(getpFirstPage()*getpPageMax()),String.valueOf(getpPageMax())};
        new CircleListService().getCircleList(handler,params);
    }
    
}

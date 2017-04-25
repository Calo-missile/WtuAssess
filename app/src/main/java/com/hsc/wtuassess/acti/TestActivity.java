package com.hsc.wtuassess.acti;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.net.productCommentsList.service.ProCommentsService;

public class TestActivity extends BaseActivity{

    private TextView testNet;

    private ProCommentsService mCommentsService;

    private int pFirstPage = 0;

    private int pPageMax = 5;

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
    
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(returnLayoutRes());
        String id = "297ed7be5ad6a40b015ad6b7ab72000b";
        String[] parmas = new String[]{id, String.valueOf(getpFirstPage() * getpPageMax()), String.valueOf(getpPageMax())};
        mCommentsService.getProComments(parmas);
    }

    public void loadData(String[] params) {
        //发送网络请求数据
        //new ProductListService().getProductList(handler,params);
    }
}

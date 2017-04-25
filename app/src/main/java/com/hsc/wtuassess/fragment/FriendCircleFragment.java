package com.hsc.wtuassess.fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hsc.wtuassess.R;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 15827 on 2017/4/12.
 */

public class FriendCircleFragment extends BaseFragment{
    
    private final int NOTIFY_MESSAGE = 0x123;//handler空内容
    
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case NOTIFY_MESSAGE:
                    //三秒后将下拉刷新的状态变为刷新完成
                    mPullToRefreshView.setRefreshing(false);
                    try {
                        List<String> d = (List<String>) msg.obj;
                        for (int i = 0; d != null && i < d.size(); i++) {
                            datas.add(d.get(i));
                        }
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
            }
        }
    };
    
    private PullToRefreshView mPullToRefreshView;
    
    private ListView listView;
    
    private ArrayAdapter<String> adapter;

    private List<String> datas;
    
    
    
    @Override
    protected int returnLayoutRes() {
        return R.layout.fragment_friend_circle;
    }

    @Override
    protected void initComp(View root) {
        mPullToRefreshView = (PullToRefreshView) root.findViewById(R.id.pull_to_refresh);
        listView = (ListView) root.findViewById(R.id.list_view);
    }

    @Override
    protected void bindEvent() {
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.post(new Runnable() {
                    @Override
                    public void run() {
                        loadData(new String[]{});
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {
        Log.i("info", "setUserVisibleHint: one initData ");
        datas = getDatas("default");
        for (int i = 0; i < datas.size(); i++) {
            Log.i("info", "initData: " + datas.get(i));
        }
        Log.i("info", "initData: ");
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }

    //为ListView添加数据
    public List<String> getDatas(String aDefault) {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("测试数据tab2" + i + "-" + aDefault);
        }
        return datas;
    }

    @Override
    public void loadData(String[] params) {
        //发送网络请求数据
        Message message = Message.obtain();
        message.what = NOTIFY_MESSAGE;
        message.obj = getDatas(String.valueOf("data" + (new Random().nextInt(100))));
        handler.sendMessage(message);
    }
}

package com.hsc.wtuassess.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.fragment.adapter.ProductListAdapter;
import com.hsc.wtuassess.net.productList.Data0;
import com.hsc.wtuassess.net.productList.service.ProductListService;
import com.hsc.wtuassess.util.ToastUtil;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class IndexFragment extends BaseFragment {
    
    private ToastUtil toastUtil;

    private final int NOTIFY_MESSAGE = 0x123;

    private PullToRefreshView mPullToRefreshView;

    private ListView listView;

    private List<Data0> datas = new ArrayList<>();

    private ProductListAdapter adapter = null;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //三秒后将下拉刷新的状态变为刷新完成
            mPullToRefreshView.setRefreshing(false);
            switch (msg.what){

                case ProductListService.MESSAGE_SUCCESS:
                {
                    List<Data0> list = (List<Data0>) msg.obj;
                    if(adapter != null){
                        datas.addAll(0,list);
                        adapter.notifyDataSetChanged();
                    }else{
                        datas = list;
                        adapter = new ProductListAdapter(getContext(),datas);
                        listView.setAdapter(adapter);
                    }
                    if(list!=null&&list.size()!=0){
                        setpFirstPage(getpFirstPage()+1);
                        toastUtil.showToast(getContext(), "加载成功" + datas.size(), Toast.LENGTH_SHORT);
                    }else{
                        toastUtil.showToast(getContext(), "没有更多数据了" + datas.size(), Toast.LENGTH_SHORT);
                    }

                }
                break;


                case ProductListService.MESSAGE_ERROR:
                {
                    Toast.makeText(getContext(), msg.obj+"", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    };

    @Override
    protected int returnLayoutRes() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initComp(View root) {
        mPullToRefreshView = (PullToRefreshView) root.findViewById(R.id.pull_to_refresh);
        listView = (ListView) root.findViewById(R.id.list_view);
    }

    @Override
    protected void bindEvent() {
        //下拉监听
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.post(new Runnable() {
                    @Override
                    public void run() {
                        loadData(new String[]{String.valueOf(getpFirstPage()*getpPageMax()),String.valueOf(getpPageMax())});
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {
        //初始化数据

    }

    @Override
    public void loadData(String[] params) {
        //发送网络请求数据
        new ProductListService().getProductList(handler,params);
    }


}
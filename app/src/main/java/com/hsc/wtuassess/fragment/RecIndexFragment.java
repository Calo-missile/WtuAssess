package com.hsc.wtuassess.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.fragment.adapter.ProductRecyclerAdapter;
import com.hsc.wtuassess.net.productList.Data0;
import com.hsc.wtuassess.net.productList.service.ProductListService;
import com.hsc.wtuassess.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15827 on 2017/4/15.
 */

public class RecIndexFragment extends BaseFragment {

    private ToastUtil toastUtil;

    //private final int NOTIFY_MESSAGE = 0x123;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case ProductListService.MESSAGE_SUCCESS:
                {
                    List<Data0> list = (List<Data0>) msg.obj;
                    if(mRecyclerAdapter != null){
                        datas.addAll(0,list);
                        mRecyclerAdapter.notifyDataSetChanged();
                    }else{
                        datas = list;
                        mRecyclerAdapter = new ProductRecyclerAdapter(getContext(),datas);
                        recyclerView.setAdapter(mRecyclerAdapter);
                    }
                    if (list != null && list.size() != 0) {
                        setpFirstPage(getpFirstPage() + 1);
                        toastUtil.showToast(getContext(), "加载成功" + datas.size(), Toast.LENGTH_SHORT);
                    } else {
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
    private SwipeRefreshLayout swipeRefresh;
    
    private RecyclerView recyclerView;

    private List<Data0> datas = new ArrayList<>();

    private ProductRecyclerAdapter mRecyclerAdapter = null;
    //private LinearLayout mainBottom;

    //private ArrayAdapter<String> adapter = null;

    @Override
    protected int returnLayoutRes() {
        return R.layout.activity_recycler;
    }

    @Override
    protected void initComp(View root) {
        swipeRefresh = (SwipeRefreshLayout) root.findViewById(R.id.swipe_refresh);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        //mainBottom = (LinearLayout) root.findViewById(R.id.main_bottom);
        //listView = (ListView) root.findViewById(R.id.list_view);
    }

    @Override
    protected void bindEvent() {
        //loadData(new String[]{});
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.post(new Runnable() {
                    @Override
                    public void run() {
                        loadData(new String[]{String.valueOf(getpFirstPage() * getpPageMax()), String.valueOf(getpPageMax())});
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {
        //初始化数据
        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int mScrollThreshold;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isSignificantDelta = Math.abs(dy) > mScrollThreshold;
                if (isSignificantDelta) {
                    if (dy > 0) {
                        mainBottom.setVisibility(View.VISIBLE);
                    } else {
                        mainBottom.setVisibility(View.GONE);
                    }
                }
            }
        });*/
    }

    @Override
    public void loadData(String[] params) {
        //发送网络请求数据
        new ProductListService().getProductList(handler,params);
    }
}

package com.hsc.wtuassess.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.fragment.adapter.CircleRecyclerAdapter;
import com.hsc.wtuassess.net.circleList.CircleData0;
import com.hsc.wtuassess.net.circleList.service.CircleListService;
import com.hsc.wtuassess.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15827 on 2017/5/4.
 */

public class RecCircleFragment extends BaseFragment {
    
    

    private List<CircleData0> datas = new ArrayList<>();
    
    private CircleRecyclerAdapter mCircleAdapter;
    
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case CircleListService.MESSAGE_SUCCESS:
                    List<CircleData0> list = (List<CircleData0>) msg.obj;
                    if (mCircleAdapter != null) {
                        datas.addAll(0, list);
                        mCircleAdapter.notifyDataSetChanged();
                    } else {
                        datas = list;
                        mCircleAdapter = new CircleRecyclerAdapter(getContext(), datas);
                        recyclCircle.setAdapter(mCircleAdapter);
                    }
                    if (list != null && list.size() != 0) {
                        setpFirstPage(getpFirstPage() + 1);
                        ToastUtil.showToast(getContext(), "加载成功" + datas.size(), Toast.LENGTH_SHORT);
                    } else {
                        ToastUtil.showToast(getContext(), "没有更多数据了" + datas.size(), Toast.LENGTH_SHORT);
                    }
                    break;
                case CircleListService.MESSAGE_ERROR:
                    ToastUtil.showToast(getContext(), "网络错误！", Toast.LENGTH_SHORT);
                    break;
                default:
                    break;
            }
        }
    };
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclCircle;

    @Override
    protected int returnLayoutRes() {
        return R.layout.fragment_circle;
    }

    @Override
    protected void initComp(View root) {
        swipeRefresh = (SwipeRefreshLayout) root.findViewById(R.id.swipe_refresh_circle);
        recyclCircle = (RecyclerView) root.findViewById(R.id.recycler_circle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclCircle.setLayoutManager(layoutManager);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
    }

    @Override
    protected void bindEvent() {
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

    }

    @Override
    public void loadData(String[] params) {
        //发送
        new CircleListService().getCircleList(handler, params);
    }
}

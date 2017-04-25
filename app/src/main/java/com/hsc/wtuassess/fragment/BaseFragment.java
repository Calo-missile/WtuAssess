package com.hsc.wtuassess.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 15827 on 2017/4/12.
 */

public abstract class BaseFragment extends Fragment {
    
    private int pFirstPage = 0;
    
    private int pPageMax = 2;

    public int getpFirstPage() {
        return pFirstPage;
    }

    public void setpFirstPage(int pFirstPage) {
        this.pFirstPage = pFirstPage;
    }

    public int getpPageMax() {
        return pPageMax;
    }

    public void setpPageMax(int pPageMax) {
        this.pPageMax = pPageMax;
    }
    
    protected abstract int returnLayoutRes();
    
    protected abstract void initComp(View root);
    
    protected abstract void bindEvent();
    
    protected abstract void initData();
    
    //加载网络数据
    public abstract void loadData(String[] params);

    
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, 
                             Bundle savedInstanceState) {
        View root = inflater.inflate(returnLayoutRes(), container, false);
        initComp(root);
        bindEvent();
        initData();
        return root;
    }

    //该方法用于告诉系统，这个Fragment的UI是否是可见的
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //判断该Fragment时候赢正在前台显示,就可以知道什么时候去加载数据
        if (isVisibleToUser) {
            loadData(new String[]{String.valueOf(getpFirstPage() * getpPageMax()), String.valueOf(getpPageMax())});
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}

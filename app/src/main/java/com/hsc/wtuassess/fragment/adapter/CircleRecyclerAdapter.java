package com.hsc.wtuassess.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.net.circleList.CircleData0;

import java.util.List;

/**
 * Created by 15827 on 2017/5/4.
 */

public class CircleRecyclerAdapter extends RecyclerView.Adapter<CircleRecyclerAdapter.ViewHolder> {
    
    private Context mContext;

    private List<CircleData0> mCircleDatas;
    static class ViewHolder extends RecyclerView.ViewHolder{
        
        TextView tvCirHit;
        TextView tvCirComment;
        TextView tvCirLike;
        TextView cirContent;
        TextView cirTime;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//创建实例，加载布局
        if (mCircleDatas != null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_circle, parent, false);
        
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//赋值，点击事件

    }

    @Override
    public int getItemCount() {//返回子项长度
        return mCircleDatas.size();
    }
}

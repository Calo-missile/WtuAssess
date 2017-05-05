package com.hsc.wtuassess.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.acti.UserDetailActivity;
import com.hsc.wtuassess.net.circleList.CircleData0;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

/**
 * Created by 15827 on 2017/5/4.
 */

public class CircleRecyclerAdapter extends RecyclerView.Adapter<CircleRecyclerAdapter.ViewHolder>  {
    
    private Context mContext;

    private List<CircleData0> mCircleDatas;
    

    public CircleRecyclerAdapter(Context context, List<CircleData0> circleDatas) {
        mContext = context;
        mCircleDatas = circleDatas;
    }
    

    static class ViewHolder extends RecyclerView.ViewHolder{
        
        LinearLayout mLinearLayout;
        
        TextView tvUserName;//人名
        TextView tvCirHit;
        TextView tvCirComment; //评论次数
        TextView tvCirLike;//点赞数量
        TextView cirContent; //内容
        TextView cirTime;  //发布时间
        TextView likePeople;//点赞人名
        CircleImageView userImg;//头像
        public ViewHolder(View itemView) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll_circle_parent); 
            tvUserName = (TextView) itemView.findViewById(R.id.tv_ciruser_name);
            tvCirHit = (TextView) itemView.findViewById(R.id.tv_hitcir_count);
            tvCirComment = (TextView) itemView.findViewById(R.id.tv_commentcir_count);
            tvCirLike = (TextView)itemView.findViewById(R.id.tv_like_cir);
            cirContent = (TextView) itemView.findViewById(R.id.tv_circle_content);
            cirTime = (TextView) itemView.findViewById(R.id.tv_cir_time);
            likePeople = (TextView) itemView.findViewById(R.id.tv_like_people);
            userImg = (CircleImageView) itemView.findViewById(R.id.circle_user_img);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//创建实例，加载布局,点击事件
        if (mCircleDatas != null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_circle, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        //Log.i(TAG, "onCreateViewHolder: "+data0.getId());
        holder.tvUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                CircleData0 data = mCircleDatas.get(position);
                Intent intent = new Intent(mContext, UserDetailActivity.class);
                intent.putExtra("user_id", data.getMember().getId());
                Log.i(TAG, "onCreateViewHolder: id传递：" + data.getMember().getId());
                mContext.startActivity(intent);
            }
        });
        holder.userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                CircleData0 data = mCircleDatas.get(position);
                Intent intent = new Intent(mContext, UserDetailActivity.class);
                intent.putExtra("user_id", data.getMember().getId());
                Log.i(TAG, "onCreateViewHolder: id传递：" + data.getMember().getId());
                mContext.startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//赋值
        CircleData0 datas = mCircleDatas.get(position);
        holder.tvUserName.setText(datas.getMember().getUsername());
        holder.tvCirHit.setText(String.valueOf(datas.getHitCount()));
        holder.cirContent.setText(String.valueOf(datas.getContent()));
        holder.tvCirLike.setText(String.valueOf(datas.getReviewCount()));
        
    }

    @Override
    public int getItemCount() {//返回子项长度
        return mCircleDatas.size();
    }
}

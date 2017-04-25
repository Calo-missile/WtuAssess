package com.hsc.wtuassess.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hsc.wtuassess.R;
import com.hsc.wtuassess.acti.ProductDetailActivity;
import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.context.AppContext;
import com.hsc.wtuassess.net.productList.Data0;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by 15827 on 2017/4/15.
 */

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder> {

    private Context mContext;
    
    private List<Data0> mdList;

    private DisplayImageOptions options; //设置图片显示相关参数
    
    static class ViewHolder extends RecyclerView.ViewHolder{
        
        View productView;

        LinearLayout itemLayout;
        ImageView ivImg;
        TextView tvName;
        TextView tvCategoryName;
        TextView tvBrandName;
        TextView tvHitCount;
        TextView tvCommentCount;
        TextView tvFavorite;
        
        public ViewHolder(View itemView) {
            super(itemView);
            productView = itemView;
            itemLayout = (LinearLayout) itemView.findViewById(R.id.product_detail); 
            ivImg = (ImageView) itemView.findViewById(R.id.iv_product_img);
            tvName = (TextView) itemView.findViewById(R.id.tv_product_name);
            tvCategoryName = (TextView) itemView.findViewById(R.id.tv_category_name);
            tvBrandName = (TextView) itemView.findViewById(R.id.tv_brand_name);
            tvHitCount = (TextView) itemView.findViewById(R.id.tv_hit_count);
            tvCommentCount = (TextView) itemView.findViewById(R.id.tv_comment_count);
            tvFavorite = (TextView) itemView.findViewById(R.id.tv_favorite);
        }
    }

    public ProductRecyclerAdapter(Context context, List<Data0> mdList) {
        this.mContext = context;
        this.mdList = mdList;
        //使用DisplayImageOptions.Builder()创建DisplayImageOptions
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_stub)//设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.ic_empty)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.ic_error)//设置图片加载或是解码过程中发生错误显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡
                .displayer(new RoundedBitmapDisplayer(50))//设置成圆角图片
                .build();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_index, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Data0 data = mdList.get(position);
                //Log.i("info", "onClick: id" + data.getId());
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("pro_id", data.getId());
                Log.i("info", "onClick: id" + data.getId()+"我传了");
                mContext.startActivity(intent);
                //ToastUtil.showToast(mContext,"item onclick", Toast.LENGTH_SHORT);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data0 datas = mdList.get(position);
        Log.i("info", "onBindViewHolder: datas"+this.mdList.get(position).getImage());
        Glide.with(AppContext.getAppContext()).load(AppConfig.PROJECT + this.mdList.get(position).getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivImg);
        /*AppContext.getAppContext().getImageLoader().displayImage(
                AppConfig.PROJECT + this.mdList.get(position).getImage(), holder.ivImg, options);*/
        holder.tvName.setText(datas.getName());
        holder.tvCategoryName.setText(datas.getCategory().getName());
        holder.tvBrandName.setText(datas.getBrand().getName());
        holder.tvHitCount.setText(String.valueOf(datas.getHitCount()));
        holder.tvCommentCount.setText(String.valueOf(datas.getCommentCount()));
    }

    @Override
    public int getItemCount() {
        return mdList.size();
    }
}

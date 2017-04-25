package com.hsc.wtuassess.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.context.AppContext;
import com.hsc.wtuassess.net.productList.Data0;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by 15827 on 2017/4/12.
 */

public class ProductListAdapter extends BaseAdapter{
    
    private Context mContext;
    private List<Data0> modelList;
    
    private DisplayImageOptions options; //设置图片显示相关参数

    public ProductListAdapter(Context context, List<Data0> list) {
        mContext = context;
        this.modelList = list;
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
    public int getCount() {
        return this.modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = View.inflate(mContext, R.layout.layout_item_index, null);
            holder.ivImg = (ImageView) convertView.findViewById(R.id.iv_product_img);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_product_name);
            holder.tvCategoryName = (TextView) convertView.findViewById(R.id.tv_category_name);
            holder.tvBrandName = (TextView) convertView.findViewById(R.id.tv_brand_name);
            holder.tvHitCount = (TextView) convertView.findViewById(R.id.tv_hit_count);
            holder.tvCommentCount = (TextView) convertView.findViewById(R.id.tv_comment_count);
            holder.tvFavorite = (TextView) convertView.findViewById(R.id.tv_favorite);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        /**
         * imageUrl 图片的Url地址 imageView 承载图片的ImageView控件 options
         * DisplayImageOptions配置文件
         * 
         * ImageLoader.getInstance().displayImage(imageUrl, imageView，options); imageUrl代表图片的URL地址，
         * imageView代表承载图片的IMAGEVIEW控件 ， options代表DisplayImageOptions配置文件
         * 
         */
        AppContext.getAppContext().getImageLoader().displayImage(
                AppConfig.PROJECT + this.modelList.get(position).getImage(), holder.ivImg, options);
        holder.tvName.setText(this.modelList.get(position).getName());
        holder.tvCategoryName.setText(this.modelList.get(position).getCategory().getName());
        holder.tvBrandName.setText(this.modelList.get(position).getBrand().getName());
        holder.tvHitCount.setText(String.valueOf("浏览量" + this.modelList.get(position).getHitCount()));
        holder.tvCommentCount.setText(String.valueOf("评价" + this.modelList.get(position).getCommentCount()));
        return convertView;
    }

    class Holder {
        public ImageView ivImg;
        public TextView tvName;
        public TextView tvCategoryName;
        public TextView tvBrandName;
        public TextView tvHitCount;
        public TextView tvCommentCount;
        public TextView tvFavorite;
    }
}

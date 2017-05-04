package com.hsc.wtuassess.acti;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hsc.wtuassess.R;
import com.hsc.wtuassess.context.AppConfig;
import com.hsc.wtuassess.net.retrofitProductDetail.DataDetail;
import com.hsc.wtuassess.net.retrofitProductDetail.service.ProductDetailService;
import com.hsc.wtuassess.util.FindStrUtil;
import com.hsc.wtuassess.util.banner.BannerView;

import java.util.ArrayList;

public class ProductDetailActivity extends BaseActivity {
    

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private ActionBar actionBar;
    
    private DataDetail mDetail;
    
    private TextView detCategory;
    private TextView detBrand;
    private TextView detContent;

    ArrayList<Object> list=new ArrayList<>();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ProductDetailService.MESSAGE_SUCCESS:
                    mDetail = (DataDetail) msg.obj;
                    final String detTitle = mDetail.getName();
                    final String dCategory = mDetail.getCategory().getName();
                    final String dBrand = mDetail.getBrand().getName();
                    final String dHitCount = String.valueOf(mDetail.getHitCount());
                    final String dCommentCount = String.valueOf(mDetail.getCommentCount());
                    final String content = FindStrUtil.findString(mDetail.getContent());

                    list.add(AppConfig.PROJECT + mDetail.getImage());
                    list.add(AppConfig.PROJECT + mDetail.getImgs().get(0).getLarge());
                    list.add(AppConfig.PROJECT + mDetail.getImgs().get(1).getLarge());
                    bannerImg.setImageResources(list, new BannerView.ImageCycleViewListener() {
                        @Override
                        public void displayImage(Object imageURL, ImageView imageView) {
                            Glide.with(getBaseContext()).load((String) imageURL).placeholder(R.drawable.ic_empty).error(R.drawable.ic_empty).into(imageView);
                            //Log.i("info", "handleMessage: 1" + mDetail.getImage());
                        }

                        @Override
                        public void onImageClick(int position, View imageView) {

                        }
                    });
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            collapsingToolbar.setTitle(detTitle);//标题
                            detCategory.setText(dCategory);
                            detBrand.setText(dBrand);
                            detailHit.setText(dHitCount);
                            detailComment.setText(dCommentCount);
                            detContent.setText("    介绍："+content);
                        }
                    });
                    break;

                case ProductDetailService.MESSAGE_ERROR:
                    Log.i("info", "handleMessage: net fail");
            }
        }
    };
    
    /*private ImageView detailImg;*/
    private TextView detailHit;
    private TextView detailComment;
    private BannerView bannerImg;


    @Override
    protected int returnLayoutRes() {
        return R.layout.activity_product_detail;
    }
    
    @Override
    protected void initComponent() {
        toolbar = (Toolbar) findViewById(R.id.tlb_detail);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        
       /* detailImg = (ImageView) findViewById(R.id.iv_prodet_view);*/
        detCategory = (TextView) findViewById(R.id.tv_det_category);
        detBrand = (TextView) findViewById(R.id.tv_det_brand);
        detailHit = (TextView) findViewById(R.id.tv_hit_detail);
        detailComment = (TextView) findViewById(R.id.tv_comment_detail);
        detContent = (TextView) findViewById(R.id.tv_det_content);
        bannerImg = (BannerView) findViewById(R.id.banner_view);
        
    }

    @Override
    protected void bindEvent() {
        //toolbar.setTitle("");
        collapsingToolbar.setTitle("");
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
    }

    @Override
    protected void initData() {
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        String pro_id = intent.getStringExtra("pro_id");
        //Log.i("info", "initComponent:接收 pro_id"+pro_id);
        loadData(pro_id);
        //Log.i("info", "initComponent: 请求成功");
        //Log.i("info", "initData: " + mDetail.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadData(String id) {
        //发送网络请求数据
        new ProductDetailService().getProductDetail(handler, id);
    }
    
}

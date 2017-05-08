package com.hsc.wtuassess.acti;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.net.userDetail.UserDetailData0;
import com.hsc.wtuassess.net.userDetail.service.UserDetailService;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetailActivity extends BaseActivity {


    private CircleImageView userImage;
    private TextView userName;
    private ImageView sexImage;
    private TextView phone;
    private TextView address;
    
    private UserDetailData0 detailData;
    
    private Toolbar toolbar;
    
    
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UserDetailService.MESSAGE_SUCCESS:
                    detailData = (UserDetailData0) msg.obj;
                    //性别判断
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //toolbar.setTitle(detailData.getName() + "个人信息");
                            titleUser.setText(detailData.getName() + "个人信息");
                            userName.setText(detailData.getName());
                            phone.setText(detailData.getPhone());
                            address.setText(detailData.getAddress());
                        }
                    });
            }
        }
    };
    private TextView titleUser;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected int returnLayoutRes() {
        return R.layout.activity_user_detail;
    }
    
    @Override
    protected void initComponent() {
        userImage = (CircleImageView) findViewById(R.id.icon_user_image);
        userName = (TextView) findViewById(R.id.tv_detail_username);
        sexImage = (ImageView) findViewById(R.id.img_sex);
        phone = (TextView) findViewById(R.id.tv_phone);
        address = (TextView) findViewById(R.id.tv_address);
        toolbar = (Toolbar) findViewById(R.id.userDetail_toolbar);
        titleUser = (TextView) findViewById(R.id.tv_title_detail);
        
    }

    @Override
    protected void bindEvent() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String user_id = intent.getStringExtra("user_id");
        Log.i("info", "initData: " + user_id);
        loadData(user_id);
    }

    public void loadData(String id) {
        new UserDetailService().getUserDetail(handler, id);
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
}

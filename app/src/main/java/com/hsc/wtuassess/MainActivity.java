package com.hsc.wtuassess;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hsc.wtuassess.acti.BaseActivity;
import com.hsc.wtuassess.fragment.FriendCircleFragment;
import com.hsc.wtuassess.fragment.RecIndexFragment;
import com.hsc.wtuassess.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    
    private ToastUtil toastUtil;

    private Button tab1,tab2;
    
    private LinearLayout tvTab1,tvTab2;
    
    private ViewPager vp;
    
    private FragmentPagerAdapter pagerAdapter;
    List<Fragment> fragments = new ArrayList<>();
    private Toolbar toolbar;
    private TextView titleText;
    private DrawerLayout mDrawerLayout;
    private NavigationView navView;


    @Override
    protected int returnLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent() {
        /*tab1 = (Button) findViewById(R.id.btn_product);
        tab2 = (Button) findViewById(R.id.btn_friend_circle);*/
        tvTab1 = (LinearLayout) findViewById(R.id.tab1);
        tvTab2 = (LinearLayout) findViewById(R.id.tab2);
        toolbar = (Toolbar) findViewById(R.id.tb_bar);
        titleText = (TextView) findViewById(R.id.tv_title);
        vp = (ViewPager) findViewById(R.id.vp);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
    }

    @Override
    protected void bindEvent() {
        tvTab1.setOnClickListener(MainActivity.this);
        tvTab2.setOnClickListener(MainActivity.this);
        /*tab1.setOnClickListener(MainActivity.this);
        tab2.setOnClickListener(MainActivity.this);*/
        
    }

    @Override
    protected void initData() {
        FriendCircleFragment  friendCircleFragment= new FriendCircleFragment();
        //IndexFragment  indexFragment= new IndexFragment();
        RecIndexFragment recIndexFragment = new RecIndexFragment();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        //fragments.add(indexFragment);

        fragments.add(recIndexFragment);
        fragments.add(friendCircleFragment);
        
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        vp.setAdapter(pagerAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /*position-点击滑动的界面位置（viewpager界面排序为0.1.2.3....）
            positionOffset-点击页面便宜整个屏幕的百分比
            positionOffsetPixels-屏幕像素位置*/
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    titleText.setText("朋友圈");
                } else {
                    titleText.setText("首 页");
                } 
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                toastUtil.showToast(MainActivity.this, "tab1", Toast.LENGTH_SHORT);
                vp.setCurrentItem(0);
                break;
            case R.id.tab2:
                toastUtil.showToast(MainActivity.this, "tab2", Toast.LENGTH_SHORT);
                vp.setCurrentItem(1);
                break;
            default:
                break;
        }
    }
}

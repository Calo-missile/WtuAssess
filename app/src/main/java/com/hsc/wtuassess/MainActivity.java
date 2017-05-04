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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsc.wtuassess.acti.BaseActivity;
import com.hsc.wtuassess.fragment.RecCircleFragment;
import com.hsc.wtuassess.fragment.RecIndexFragment;
import com.hsc.wtuassess.util.BottomNavUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    
    private ViewPager vp;
    
    private FragmentPagerAdapter pagerAdapter;
    List<Fragment> fragments = new ArrayList<>();
    private Toolbar toolbar;
    private TextView titleText;
    private DrawerLayout mDrawerLayout;
    private NavigationView navView;
    private LinearLayout bottomBar;

    private BottomNavUtil mBottomNavUtil;
    private String[] bottomTitle = {"美食", "朋友圈"};
    private int[] iconArr = {R.drawable.select_food, R.drawable.select_friends};

    @Override
    protected int returnLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent() {
        toolbar = (Toolbar) findViewById(R.id.tb_bar);
        titleText = (TextView) findViewById(R.id.tv_title);
        vp = (ViewPager) findViewById(R.id.vp);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        bottomBar = (LinearLayout) findViewById(R.id.ll_bottom);
    }

    @Override
    protected void bindEvent() {
        mBottomNavUtil = new BottomNavUtil();
        mBottomNavUtil.createBottom(bottomBar, bottomTitle, iconArr);
        mBottomNavUtil.changeColor(0);
        
        
    }

    @Override
    protected void initData() {
        //FriendCircleFragment  friendCircleFragment= new FriendCircleFragment();
        //IndexFragment  indexFragment= new IndexFragment();
        RecCircleFragment circleFragment = new RecCircleFragment();
        RecIndexFragment recIndexFragment = new RecIndexFragment();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_home);
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
        fragments.add(circleFragment);
        
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
                mBottomNavUtil.changeColor(position);
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
        
        mBottomNavUtil.setBottomClickListener(new BottomNavUtil.onBottomClickListener() {
            @Override
            public void onBottomClick(int position) {
                vp.setCurrentItem(position);
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
        
    }

    /*@Override
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
    }*/
}

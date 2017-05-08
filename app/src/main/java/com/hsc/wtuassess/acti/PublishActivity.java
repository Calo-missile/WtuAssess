package com.hsc.wtuassess.acti;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hsc.wtuassess.R;
import com.hsc.wtuassess.util.ToastUtil;

public class PublishActivity extends BaseActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected int returnLayoutRes() {
        return R.layout.activity_publish;
    }
    
    @Override
    protected void initComponent() {
        toolbar = (Toolbar) findViewById(R.id.title_publish);
    }

    @Override
    protected void bindEvent() {
        toolbar.setTitle("发表说说");
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
            
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.publish_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_send:
                ToastUtil.showToast(getBaseContext(), "发送", Toast.LENGTH_SHORT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

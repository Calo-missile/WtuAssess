package com.hsc.wtuassess.acti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int returnLayoutRes();
    
    protected abstract void initComponent();
    
    protected abstract void bindEvent();
    
    protected abstract void initData();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(returnLayoutRes());
        initComponent();
        bindEvent();
        initData();
    }
}

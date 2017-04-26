package com.hsc.wtuassess.util;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsc.wtuassess.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15827 on 2017/4/26.
 */

public class BottomNavUtil {

    private List<TextView> mTextViews = new ArrayList<>();

    public void createBottom(LinearLayout mBotoom, String[] bottomTitleArr, int[] iconArr){
        
        for (int i = 0; i < bottomTitleArr.length; i++) {
            
            TextView tv = (TextView) View.inflate(mBotoom.getContext(), R.layout.activit_main_bottom, null);
            tv.setText(bottomTitleArr[i]);
            tv.setCompoundDrawablesWithIntrinsicBounds(0, iconArr[i], 0, 0);
            
            int width = 0;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            params.weight = 1;
            mBotoom.addView(tv, params);
            mTextViews.add(tv);
            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBottomClickListener.onBottomClick(finalI);
                }
            });
        }
    }

    public void changeColor(int position) {
        for (TextView tv : mTextViews) {
            tv.setSelected(false);
        }
        mTextViews.get(position).setSelected(true);
    }

    //定义一个接口
    public interface onBottomClickListener{
        void onBottomClick(int position);
    }

    //接口变量
    onBottomClickListener mBottomClickListener;
    
    //提供一个公共方法给外部使用
    public void setBottomClickListener(onBottomClickListener bottomClickListener) {
        mBottomClickListener = bottomClickListener;
    }
}

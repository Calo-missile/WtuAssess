package com.hsc.wtuassess.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 15827 on 2017/4/14.
 */

public class ToastUtil {
    private static Toast mToast = null;
    public static void showToast(Context context, String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
}

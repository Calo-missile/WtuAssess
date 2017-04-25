package com.hsc.wtuassess.context.glideLoader;

import android.content.Context;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

import java.io.InputStream;

import static android.R.attr.maxHeight;
import static android.R.attr.maxWidth;

/**
 * Created by 15827 on 2017/4/23.
 */

public class MyUrlLoader extends BaseGlideUrlLoader<MydataModer> {
    public MyUrlLoader(Context context) {
        super(context);
    }

    public MyUrlLoader(Context context, ModelCache<MydataModer, GlideUrl> modelCache) {
        super(context, modelCache);
    }

    public MyUrlLoader(ModelLoader<GlideUrl, InputStream> concreteLoader) {
        super(concreteLoader);
    }

    public MyUrlLoader(ModelLoader<GlideUrl, InputStream> concreteLoader, ModelCache<MydataModer, GlideUrl> modelCache) {
        super(concreteLoader, modelCache);
    }

    @Override
    protected String getUrl(MydataModer model, int width, int height) {
        return model.buildUrl(maxWidth,maxHeight);
    }
}

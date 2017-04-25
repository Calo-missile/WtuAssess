package com.hsc.wtuassess.context;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hsc.wtuassess.bean.dao.DaoMaster;
import com.hsc.wtuassess.bean.dao.DaoSession;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by 15827 on 2017/4/12.
 */

public class AppContext extends Application {
    
    private static AppContext appContext;
    
    private DaoSession daoSession;
    
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(getApplicationContext());
        appContext = this;
        initDB();
        //使用ImageLoader进行图片加载的时候，先要实例化ImageLoader  --之后进行显示的图片的各种格式DisplayImageOptions的设置
        imageLoader = ImageLoader.getInstance();
    }
    
    private void initDB(){//设置greendao
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "db_test", null);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static AppContext getAppContext() {
        return appContext;
    }
    
    public DaoSession getDaoSession(){
        return daoSession;
    }
    
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void initImageLoader(Context context) {
        //缓存文件目录
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "imageloader/Cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480,800)//max width, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
                .memoryCache(new UsingFreqLimitedMemoryCache(2*1024*1024))//你可以通过自己的内存缓存实现
                .memoryCacheSize(2*1024*1024)//内存缓存的最大值
                .diskCacheSize(50*1024*1024) //50Mb sd卡（本地）缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                //由原先的discCache - > diskCache
                .diskCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径
                .imageDownloader(new BaseImageDownloader(context,5*1000,30*1000))// connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() //Remove for release app
                .build();
        //全局初始化此配置
        ImageLoader.getInstance().init(config);
    }
}

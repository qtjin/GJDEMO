package com.gj.android.gjdemo;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.view.Display;
import android.view.WindowManager;

import com.gj.android.commonlibrary.base.BaseLibApplication;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/**
 * Created by guojing on 2015/12/28.
 * 全局Application
 * 打包的命令 E:\AndroidDemo\GJDemo2017>gradle assembleRelease
 */
public class AppContext extends BaseLibApplication {

    public static AppContext appContext;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static float DENSITY; //像素密度

    private Display display;

    public static AppContext getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        init();
    }

    /**
     * 初始化  选择多张图片的辅助工具类
     */
    private void init() {
        initImageLoader(this);
        if (display == null) {
            WindowManager windowManager = (WindowManager)
                    getSystemService(Context.WINDOW_SERVICE);
            display = windowManager.getDefaultDisplay();
        }
    }

    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY);
        config.denyCacheImageMultipleSizesInMemory();
        config.memoryCacheSize((int) Runtime.getRuntime().maxMemory() / 4);
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(100 * 1024 * 1024); // 100 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        //修改连接超时时间5秒，下载超时时间5秒
        config.imageDownloader(new BaseImageDownloader(appContext, 5 * 1000, 5 * 1000));
        //		config.writeDebugLogs(); // Remove for release app
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

    /***************** 分包 ********************/
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }
    /***************** 分包 ********************/


}

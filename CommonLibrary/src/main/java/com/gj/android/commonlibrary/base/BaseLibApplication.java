package com.gj.android.commonlibrary.base;

import android.app.Application;

import com.gj.android.commonlibrary.util.AbAppUtils;
import com.gj.android.commonlibrary.util.ImageLoaderHelper;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Author:      qiyunfeng
 * Email:       510568444@qq.com | qiyunfeng0618@163.com
 * Date:        15/9/28 下午3:55
 * Description: EasyFrame
 */
public abstract class BaseLibApplication extends Application {

    private static BaseLibApplication instance;

    /**
     * 获得当前app运行的AppContext
     *
     * @return BaseLibApplication
     */
    public static BaseLibApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        AbAppUtils.init(getInstance());
        //initImageLoader(true);
    }




    protected void initImageLoader(boolean isNeed) {
        if (!isNeed) {
            return;
        }
        // 初始化ImageLoader
        //ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this); 默认的方式每次都会下载图片
        ImageLoaderConfiguration configuration= ImageLoaderHelper.getInstance(this).getImageLoaderConfiguration();
        ImageLoader.getInstance().init(configuration);
    }


}

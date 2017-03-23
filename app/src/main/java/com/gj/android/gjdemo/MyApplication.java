package com.gj.android.gjdemo;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.gj.android.commonlibrary.base.BaseLibApplication;

/**
 * Created by guojing on 2015/12/28.
 * 全局Application
 * 打包的命令 E:\AndroidDemo\GJDemo2017>gradle assembleRelease
 */
public class MyApplication extends BaseLibApplication {

    public static MyApplication myApplication;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static float DENSITY; //像素密度

    //private Display display;

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        init();
    }

    /**
     * 初始化  选择多张图片的辅助工具类
     */
    private void init() {
//        if (display == null) {
//            WindowManager windowManager = (WindowManager)
//                    getSystemService(Context.WINDOW_SERVICE);
//            display = windowManager.getDefaultDisplay();
//        }
    }



    /***************** 分包 ********************/
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }
    /***************** 分包 ********************/


}

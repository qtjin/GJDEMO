package com.gj.android.gjdemo.ui.activity;

import android.os.Bundle;

import com.gj.android.commonlibrary.base.BaseActivity;
import com.gj.android.commonlibrary.widget.GlideImageLoader;
import com.gj.android.gjdemo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BannerActivity extends BaseActivity {

    @BindView(R.id.banner)
    Banner banner;

    @BindView(R.id.banner2)
    Banner banner2;

    List titles;
    List images;

//    //资源文件
//    Integer[] images={R.drawable.a,R.mipmap.b,R.mipmap.c};
//    //Uri
//    Uri uri = resourceIdToUri(context, R.mipmap.ic_launcher);
//    Uri[] images={uri};
//    //文件对象
//    File[] images={"文件对象","文件对象"};
//    //raw 两种方式
//    String[] images={"Android.resource://com.frank.glide/raw/raw_1"};
//    String[] images={"android.resource://com.frank.glide/raw/"+R.raw.raw_1"};
//    //ContentProvider
//    String[] images={"content://media/external/images/media/139469"};
//    //assets
//    String[] images={"file:///android_asset/f003.gif"};
//    //sd卡资源
//    String[] images={"file://"+ Environment.getExternalStorageDirectory().getPath()+"/test.jpg"};

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_banner;
    }

    @Override
    protected void initListener() {
        titles = new ArrayList();
        titles.add("title1");
        titles.add("title2");
        titles.add("title3");
        titles.add("title4");
        titles.add("title5");
        titles.add("title6");
        titles.add("title7");

        images = new ArrayList();
        images.add("http://fdfs.xmcdn.com/group27/M04/6F/19/wKgJW1jSRfWRjY8IAANcGy2lIlg411_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group26/M03/72/74/wKgJWFjSNRixLtfpAALI_ao_WUI918_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group26/M06/73/5C/wKgJWFjSRqCRtMU0AAJAS1Nc8Qk463_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group26/M05/73/5D/wKgJRljSRwugukA7AAI2I3x9Hf8482_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group27/M09/6F/2B/wKgJW1jSR0HR4JGCAAJqkNNrfmw977_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group27/M0B/6E/CD/wKgJW1jSQD2hdHVQAAEI37_VSsY209_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group24/M06/D3/BE/wKgJMFi74t2g5FWLAAFG4rZ-hbI011_android_large.jpg");

        //设置banner样式
        //banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE); //显示在标题栏里面
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);

        //banner设置方法全部调用完毕时最后调用
        banner.start();

        //设置banner样式
        banner2.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner2.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner2.setImages(images);
        //设置banner动画效果
        banner2.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        banner2.isAutoPlay(true);
        //设置轮播时间
        banner2.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner2.setIndicatorGravity(BannerConfig.CENTER);

        //banner设置方法全部调用完毕时最后调用
        banner2.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
        banner2.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
        banner2.stopAutoPlay();
    }

    @Override
    public void pressData(Object obj) {

    }

    @Override
    public void errorData(int type) {

    }

    @Override
    protected void initData() {

    }

    /**
     * 页面加载完成之后回调该函数，可以在该函数里获取到控件的宽高以及位置
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
    }

}

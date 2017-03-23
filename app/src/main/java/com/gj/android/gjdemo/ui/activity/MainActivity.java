package com.gj.android.gjdemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.DisplayMetrics;

import com.gj.android.gjdemo.MyApplication;
import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.widget.adapter.MainFragmentPagerAdapter;
import com.gj.android.commonlibrary.base.BaseActivity;
import com.gj.android.commonlibrary.widget.HQViewPager;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.hq_view_pager)
    HQViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    private MainFragmentPagerAdapter mMainFragmentPagerAdapter;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {

        DisplayMetrics metric = new DisplayMetrics();
        MainActivity.this.getWindowManager().getDefaultDisplay()
                .getMetrics(metric);
        MyApplication.SCREEN_WIDTH = metric.widthPixels; // 屏幕宽度（像素）
        MyApplication.SCREEN_HEIGHT = metric.heightPixels; // 屏幕宽度（像素）
        MyApplication.DENSITY = metric.density; // 像素密度

        hideTopLeft();


        mMainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(),this);
        mViewPager.setAdapter(mMainFragmentPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            //获得到对应位置的Tab
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            //设置自定义的标题
            if (tab != null) {
                tab.setCustomView(mMainFragmentPagerAdapter.getTabView(i));
            }
        }

    }



    @Override
    public void pressData(Object obj) {

    }

    @Override
    public void errorData(int type) {

    }

    @Override
    protected void initData() {
        setTitle("GJDemo2017");


    }

}

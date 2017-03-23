package com.gj.android.gjdemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gj.android.gjdemo.AppContext;
import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.widget.adapter.MyFragmentPagerAdapter;
import com.gj.android.commonlibrary.base.BaseActivity;

import butterknife.BindView;

public class TabLayoutExampleActivity extends BaseActivity {


    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_tab_layout_example;
    }

    @Override
    protected void initListener() {
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(2).select();
        //重新设置每个tab的间距，这样就能动态改变tab底部横线的宽度
        ViewGroup viewGroup = (ViewGroup) mTabLayout.getChildAt(0);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            ViewGroup view = (ViewGroup) viewGroup.getChildAt(i);
            view.setPadding(0,0,0,0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            TextView textView = (TextView) view.getChildAt(1);
            textView.setTextSize(14);
            textView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            int width = textView.getMeasuredWidth();
            int margin = (AppContext.SCREEN_WIDTH / 5 - width) / 2 - 30;
            layoutParams.setMargins(margin, 0, margin, 0);
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
        setTitle("TabLayoutExample");
    }


}

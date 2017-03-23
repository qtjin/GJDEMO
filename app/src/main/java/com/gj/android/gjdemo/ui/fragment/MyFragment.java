package com.gj.android.gjdemo.ui.fragment;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.widget.adapter.MyFragmentPagerAdapter;
import com.gj.android.commonlibrary.base.BaseFragment;

import butterknife.BindView;

public class MyFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.root_view)
    FrameLayout mRootView;

    private int currentPage;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initListener() {
        Bundle args = getArguments();
        if(null!=args){
            currentPage = args.getInt(MyFragmentPagerAdapter.ARGS_PAGE);
        }
        tv_title.setText("page: "+currentPage);
        switch (currentPage){
            case 0:
                mRootView.setBackgroundColor(getResources().getColor(R.color.pink));
                break;
            case 1:
                mRootView.setBackgroundColor(getResources().getColor(R.color.app_bg_green));
                break;
            case 2:
                mRootView.setBackgroundColor(getResources().getColor(R.color.app_blue));
                break;
            case 3:
                mRootView.setBackgroundColor(getResources().getColor(R.color.app_yellow_light));
                break;
            case 4:
                mRootView.setBackgroundColor(getResources().getColor(R.color.app_orange));
                break;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void pressData(Object obj) {

    }

    @Override
    public void errorData(int type) {

    }


}

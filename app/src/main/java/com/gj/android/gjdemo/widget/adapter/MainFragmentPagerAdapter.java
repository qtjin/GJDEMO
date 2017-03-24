package com.gj.android.gjdemo.widget.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.ui.fragment.HomeFragment;
import com.gj.android.gjdemo.ui.fragment.MyFragment;
import com.gj.android.gjdemo.ui.fragment.OneRecycleFragment;

/**
 * Created by guojing on 16/7/22.
 * 首页
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    private HomeFragment myFragment1; //fragment
    private OneRecycleFragment myFragment2; //fragment
    private MyFragment myFragment3; //fragment
    private MyFragment myFragment4; //fragment
    private MyFragment myFragment5; //fragment

    private static final String[] mTitles = new String[]{"首页","档案", "医生","购药", "我的"};

    private static final int[] mImgIds = new int[]{
            R.drawable.rb_home_selector,
            R.drawable.rb_dangan_selector,
            R.drawable.rb_doctor_selector,
            R.drawable.rb_gouyao_selector,
            R.drawable.rb_me_selector};

    public static final String ARGS_PAGE = "args_page";

    public MainFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE,position);
        if (position == 1) {
            myFragment2 = OneRecycleFragment.newInstance();
            myFragment2.setArguments(args);
            return myFragment2;
        } else if (position == 2) {
            if(null==myFragment3){
                myFragment3 = new MyFragment();
                myFragment3.setArguments(args);
            }
            return myFragment3;
        }else if (position==3){
            if(null==myFragment4){
                myFragment4 = new MyFragment();
                myFragment4.setArguments(args);
            }
            return myFragment4;
        }else if (position==4){
            if(null==myFragment5){
                myFragment5 = new MyFragment();
                myFragment5.setArguments(args);
            }
            return myFragment5;
        }else{
            if(null==myFragment1){
                myFragment1 = new HomeFragment();
                myFragment1.setArguments(args);
            }
            return myFragment1;
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_tab, null);
        ImageView iv_tab = (ImageView) view.findViewById(R.id.iv_tab);
        TextView tv_tab = (TextView) view.findViewById(R.id.tv_tab);
        iv_tab.setImageResource(mImgIds[position]);
        tv_tab.setText(mTitles[position]);
        return view;
    }
}

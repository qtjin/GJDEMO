package com.gj.android.gjdemo.widget.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gj.android.gjdemo.ui.fragment.MyFragment;

/**
 * Created by guojing on 16/7/22.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private MyFragment myFragment1; //fragment
    private MyFragment myFragment2; //fragment
    private MyFragment myFragment3; //fragment
    private MyFragment myFragment4; //fragment
    private MyFragment myFragment5; //fragment

    private String[] mTitles = new String[]{"全部","病历", "体检","报告单", "处方"};

    public static final String ARGS_PAGE = "args_page";

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE,position);
        if (position == 1) {
            if(null==myFragment2){
                myFragment2 = new MyFragment();
                myFragment2.setArguments(args);
            }
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
                myFragment1 = new MyFragment();
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

}

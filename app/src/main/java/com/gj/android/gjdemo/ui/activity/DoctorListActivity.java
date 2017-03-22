package com.gj.android.gjdemo.ui.activity;

import android.support.v4.app.Fragment;

import com.gj.android.gjdemo.ui.fragment.DoctorListFragment;
import com.gj.android.commonlibrary.base.SingleFragmentActivity;

/**
 * 医生列表
 */
public class DoctorListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return DoctorListFragment.newInstance();
    }
}

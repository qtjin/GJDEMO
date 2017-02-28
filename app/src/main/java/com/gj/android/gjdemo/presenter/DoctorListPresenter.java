package com.gj.android.gjdemo.presenter;


import com.gj.android.gjdemo.bean.DoctorListBean;
import com.gj.android.gjdemo.network.Network;
import com.gj.android.gjdemo.ui.activity.DoctorListActivity;
import com.gj.gjlibrary.api.URLs;
import com.gj.gjlibrary.base.BaseActivity;
import com.gj.gjlibrary.base.BasePresenter;
import com.gj.gjlibrary.util.rxjava.ProgressSubscriber;

import rx.Observable;

/**
 * Created by guojing on 2017/2/27.
 */

public class DoctorListPresenter extends BasePresenter {

    private BaseActivity mDoctorListActivity;

    public DoctorListPresenter(DoctorListActivity mDoctorListActivity) {
        super(mDoctorListActivity);
        this.mDoctorListActivity = mDoctorListActivity;
    }

    public void getDoctorList(){
        ProgressSubscriber subscriber = new ProgressSubscriber<DoctorListBean.DataBean>(baseActivity) { //带进度条的订阅者
            @Override
            public void onNext(DoctorListBean.DataBean DataBean) {
                mDoctorListActivity.pressData(DataBean); //刷新数据
            }
        };

        Network.setBaseURL(URLs.GET_WYS_DOCTOR_LIST); //设置URL

        Observable<DoctorListBean.DataBean> observable = Network.getApi()
                .getDoctorList(String.valueOf(1),String.valueOf(1),String.valueOf(1),"","").map(new HttpResultFunc<DoctorListBean.DataBean>()); //被订阅者

        toSubscribe(observable,subscriber);  //订阅
    }

}

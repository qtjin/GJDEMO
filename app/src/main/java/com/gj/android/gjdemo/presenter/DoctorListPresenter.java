package com.gj.android.gjdemo.presenter;


import com.gj.android.bean.DoctorListBean;
import com.gj.android.gjlibrary.api.Network;
import com.gj.android.gjlibrary.api.URLs;
import com.gj.android.gjlibrary.base.BaseAutoRecylerListActivity;
import com.gj.android.gjlibrary.base.BasePresenter;
import com.gj.android.gjlibrary.util.rxjava.MySubscriber;
import com.gj.android.gjlibrary.util.rxjava.ProgressSubscriber;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by guojing on 2017/2/27.
 */

public class DoctorListPresenter extends BasePresenter {

    private BaseAutoRecylerListActivity mBaseAutoRecylerListActivity;

    public DoctorListPresenter(BaseAutoRecylerListActivity mBaseAutoRecylerListActivity) {
        super(mBaseAutoRecylerListActivity);
        this.mBaseAutoRecylerListActivity = mBaseAutoRecylerListActivity;
    }

    public void getDoctorList(String seqType,String drType,String SearchStr,String sectionsName,String curPage){

        Subscriber subscriber = null;

        if(mBaseAutoRecylerListActivity.loadType== BaseAutoRecylerListActivity.LoadType.INIT){
             subscriber = new ProgressSubscriber<DoctorListBean.DataBean>(baseActivity) { //带进度条的订阅者
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    baseActivity.pressData(DataBean); //刷新数据
                }
            };
        }else{
            subscriber = new MySubscriber<DoctorListBean.DataBean>(baseActivity) { //下拉刷新上拉加载更多自带进度条
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    baseActivity.pressData(DataBean); //刷新数据
                }
            };
        }


        Network.setBaseURL(URLs.GET_WYS_DOCTOR_LIST); //设置URL

        Observable<DoctorListBean.DataBean> observable = Network.getApi()
                .getDoctorList(seqType,drType,SearchStr,sectionsName,curPage).map(new HttpResultFunc<DoctorListBean.DataBean>()); //被订阅者

        toSubscribe(observable,subscriber);  //订阅
    }

}

package com.gj.android.gjdemo.presenter;


import com.gj.android.bean.DoctorListBean;
import com.gj.android.commonlibrary.api.Network;
import com.gj.android.commonlibrary.base.BaseAutoRecylerListFragment;
import com.gj.android.commonlibrary.base.BaseFragmentPresenter;
import com.gj.android.commonlibrary.util.rxjava.MySubscriber;
import com.gj.android.commonlibrary.util.rxjava.ProgressSubscriber;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by guojing on 2017/2/27.
 */

public class DoctorListFragmentPresenter extends BaseFragmentPresenter {

    private BaseAutoRecylerListFragment mBaseAutoRecylerListFragment;

    public DoctorListFragmentPresenter(BaseAutoRecylerListFragment mBaseAutoRecylerListFragment) {
        super(mBaseAutoRecylerListFragment);
        this.mBaseAutoRecylerListFragment = mBaseAutoRecylerListFragment;
    }

    public void getDoctorList(String seqType,String drType,String SearchStr,String sectionsName,String curPage){

        Subscriber subscriber = null;

        if(mBaseAutoRecylerListFragment.loadType== BaseAutoRecylerListFragment.LoadType.INIT){
             subscriber = new ProgressSubscriber<DoctorListBean.DataBean>(baseFragment.getActivity()) { //带进度条的订阅者
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    baseFragment.pressData(DataBean); //刷新数据
                }

                 @Override
                 public void onError(Throwable e) {
                     super.onError(e);
                     baseFragment.errorData(1);
                 }
             };
        }else{
            subscriber = new MySubscriber<DoctorListBean.DataBean>(baseFragment.getActivity()) { //下拉刷新上拉加载更多自带进度条
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    baseFragment.pressData(DataBean); //刷新数据
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    baseFragment.errorData(1);
                }
            };
        }

        Observable<DoctorListBean.DataBean> observable = Network.getInstance().getApi()
                .getDoctorList(seqType,drType,SearchStr,sectionsName,curPage).map(new HttpResultFunc<DoctorListBean.DataBean>()); //被订阅者

        toSubscribe(observable,subscriber);  //订阅
    }

}

package com.gj.android.gjdemo.presenter;


import android.util.Log;

import com.gj.android.bean.DoctorListBean;
import com.gj.android.commonlibrary.api.Network;
import com.gj.android.commonlibrary.api.URLs;
import com.gj.android.commonlibrary.base.BaseFragmentPresenter;
import com.gj.android.commonlibrary.util.AbGsonUtil;
import com.gj.android.commonlibrary.util.CacheUtil;
import com.gj.android.commonlibrary.util.ToastUtils;
import com.gj.android.commonlibrary.util.rxjava.MySubscriber;
import com.gj.android.commonlibrary.util.rxjava.ProgressSubscriber;
import com.gj.android.gjdemo.ui.fragment.DoctorListFragment;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by guojing on 2017/2/27.
 */

public class DoctorListFragmentPresenter extends BaseFragmentPresenter {

    private DoctorListFragment mDoctorListFragment;

    public DoctorListFragmentPresenter(DoctorListFragment mDoctorListFragment) {
        super(mDoctorListFragment);
        this.mDoctorListFragment = mDoctorListFragment;
    }

    public void getDoctorList(String seqType,String drType,String SearchStr,String sectionsName,final String curPage){

        Log.d("getDoctorList","curPage: "+ curPage);
        Log.d("getDoctorList","ThreadName: "+ Thread.currentThread().getName());

        Subscriber subscriber = null;

        if(mDoctorListFragment.loadType== DoctorListFragment.LoadType.INIT){
             subscriber = new ProgressSubscriber<DoctorListBean.DataBean>(mDoctorListFragment.getActivity()) { //带进度条的订阅者
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    Network.getCacheListener().setLocalCache(DataBean); //缓存数据
                    mDoctorListFragment.pressData(DataBean); //刷新数据
                }

                 @Override
                 public void onError(Throwable e) {
                     super.onError(e);
                     retrofit2.adapter.rxjava.HttpException e2 = (HttpException) e;
                     if(null!=e2&&e2.code()==504){//缓存
                     }else{
                         e.printStackTrace();
                         mDoctorListFragment.errorData(1);
                     }
                 }
             };
        }else{
            subscriber = new MySubscriber<DoctorListBean.DataBean>(mDoctorListFragment.getActivity()) { //下拉刷新上拉加载更多自带进度条
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    if(mDoctorListFragment.loadType== DoctorListFragment.LoadType.REFERSH){
                        Network.getCacheListener().setLocalCache(DataBean); //缓存数据
                    }
                    mDoctorListFragment.pressData(DataBean); //刷新数据
                }

                @Override
                public void onError(Throwable e) {
                    retrofit2.adapter.rxjava.HttpException e2 = (HttpException) e;
                    if(null!=e2&&e2.code()==504){//缓存
                    }else{
                        e.printStackTrace();
                        mDoctorListFragment.errorData(1);
                    }
                }
            };
        }

        Observable<DoctorListBean.DataBean> observable = Network.getInstance()
                .setCacheListener(new Network.CacheListener() { //需要缓存的时候可以设置
                    @Override
                    public void getLocalCache(String url) {
                        //CacheUtil.saveCacheData();
                        Log.d("getDoctorList","getLocalCache ThreadName: "+ Thread.currentThread().getName());
                        String dataStr = CacheUtil.getCacheData(URLs.METHOD_DOCTOR_LIST+String.valueOf(curPage));
                        final DoctorListBean.DataBean DataBean = AbGsonUtil.json2Bean(dataStr,DoctorListBean.DataBean.class);
                        mDoctorListFragment.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtils.show(mDoctorListFragment.getActivity(),"从缓存获取 curPage: "+curPage);
                                mDoctorListFragment.cacheData(DataBean); //刷新数据
                            }
                        });
                    }

                    @Override
                    public void setLocalCache(Object obj) {
                        Log.d("getDoctorList","setLocalCache ThreadName: "+ Thread.currentThread().getName());
                        DoctorListBean.DataBean DataBean = (DoctorListBean.DataBean) obj;
                        String dataStr = AbGsonUtil.bean2Json(DataBean);
                        CacheUtil.saveCacheData(URLs.METHOD_DOCTOR_LIST+String.valueOf(curPage),dataStr);
                    }
                }).getApi().getDoctorList(seqType,drType,SearchStr,sectionsName,curPage).map(new HttpResultFunc<DoctorListBean.DataBean>()); //被订阅者

        toSubscribe(observable,subscriber);  //订阅

    }

}

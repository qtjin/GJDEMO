package com.gj.android.gjdemo.presenter;


import android.util.Log;

import com.gj.android.bean.DepartBean;
import com.gj.android.commonlibrary.api.Network;
import com.gj.android.commonlibrary.api.URLs;
import com.gj.android.commonlibrary.base.BaseFragmentPresenter;
import com.gj.android.commonlibrary.util.AbGsonUtil;
import com.gj.android.commonlibrary.util.CacheUtil;
import com.gj.android.commonlibrary.util.rxjava.MySubscriber;
import com.gj.android.commonlibrary.util.rxjava.ProgressSubscriber;
import com.gj.android.gjdemo.ui.fragment.DepartListFragment;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by guojing on 2017/2/27.
 */

public class DepartListFragmentPresenter extends BaseFragmentPresenter {

    private DepartListFragment mDepartListFragment;

    public DepartListFragmentPresenter(DepartListFragment mDepartListFragment) {
        super(mDepartListFragment);
        this.mDepartListFragment = mDepartListFragment;
    }

    public void getDepartList(){

        Observable<DepartBean> observable = Network.getInstance()
                .setCacheListener(new Network.CacheListener() { //需要缓存的时候可以设置
                    @Override
                    public void getLocalCache(String url) {
                        //CacheUtil.saveCacheData();
                        Log.d("getDepartList","getLocalCache ThreadName: "+ Thread.currentThread().getName());
                        String dataStr = CacheUtil.getCacheData(URLs.METHOD_DOCTOR_LIST);
                        final DepartBean dataBean = AbGsonUtil.json2Bean(dataStr,DepartBean.class);
                        mDepartListFragment.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mDepartListFragment.cacheData(dataBean); //刷新数据
                            }
                        });
                    }

                    @Override
                    public void setLocalCache(Object obj) {
                        Log.d("getDepartList","setLocalCache ThreadName: "+ Thread.currentThread().getName());
                        DepartBean dataBean = (DepartBean) obj;
                        String dataStr = AbGsonUtil.bean2Json(dataBean);
                        CacheUtil.saveCacheData(URLs.DEPART_LIST,dataStr);
                    }
                }).getApi().getDepartList(); //被订阅者

        Subscriber subscriber = null;

        if(mDepartListFragment.loadType== DepartListFragment.LoadType.INIT){
            subscriber = new ProgressSubscriber<DepartBean>(mDepartListFragment.getActivity()) { //带进度条的订阅者
                @Override
                public void onNext(DepartBean baseBean) {
                    Network.getCacheListener().setLocalCache(baseBean); //缓存数据
                    mDepartListFragment.pressData(baseBean); //刷新数据
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    retrofit2.adapter.rxjava.HttpException e2 = (HttpException) e;
                    if(null!=e2&&e2.code()==504){//缓存
                    }else{
                        e.printStackTrace();
                        mDepartListFragment.errorData(1);
                    }
                }
            };
        }else{
            subscriber = new MySubscriber<DepartBean>(mDepartListFragment.getActivity()) { //下拉刷新上拉加载更多自带进度条
                @Override
                public void onNext(DepartBean baseBean) {
                    if(mDepartListFragment.loadType== DepartListFragment.LoadType.REFERSH){
                        Network.getCacheListener().setLocalCache(baseBean); //缓存数据
                    }
                    mDepartListFragment.pressData(baseBean); //刷新数据
                }

                @Override
                public void onError(Throwable e) {
                    retrofit2.adapter.rxjava.HttpException e2 = (HttpException) e;
                    if(null!=e2&&e2.code()==504){//缓存
                    }else{
                        e.printStackTrace();
                        mDepartListFragment.errorData(1);
                    }
                }
            };
        }


        toSubscribe(observable,subscriber);  //订阅

    }

}

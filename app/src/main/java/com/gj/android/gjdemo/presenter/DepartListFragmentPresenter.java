package com.gj.android.gjdemo.presenter;


import com.gj.android.bean.DepartBean;
import com.gj.android.commonlibrary.api.Network;
import com.gj.android.commonlibrary.api.URLs;
import com.gj.android.commonlibrary.base.BaseFragmentPresenter;
import com.gj.android.commonlibrary.util.AbGsonUtil;
import com.gj.android.commonlibrary.util.CacheUtil;
import com.gj.android.commonlibrary.util.rxjava.MySubscriber;
import com.gj.android.commonlibrary.util.rxjava.ProgressSubscriber;
import com.gj.android.gjdemo.ui.fragment.DepartListFragment;
import com.gj.android.gjdemo.ui.fragment.DoctorListFragment;

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
                .getApi().getDepartList(); //被订阅者

        Subscriber subscriber = null;

        if(mDepartListFragment.loadType== DepartListFragment.LoadType.INIT){
            subscriber = new ProgressSubscriber<DepartBean>(mDepartListFragment.getActivity()) { //带进度条的订阅者
                @Override
                public void onNext(DepartBean baseBean) {
                    saveCacheData(baseBean);
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    getCacheData(e);
                }
            };
        }else{
            subscriber = new MySubscriber<DepartBean>(mDepartListFragment.getActivity()) { //下拉刷新上拉加载更多自带进度条
                @Override
                public void onNext(DepartBean baseBean) {
                    saveCacheData(baseBean);
                }

                @Override
                public void onError(Throwable e) {
                    getCacheData(e);
                }
            };
        }


        toSubscribe(observable,subscriber);  //订阅

    }


    /**
     * 存缓存数据
     * @param
     */
    private void saveCacheData(DepartBean departBean){
        if(mDepartListFragment.loadType== DoctorListFragment.LoadType.INIT||mDepartListFragment.loadType== DoctorListFragment.LoadType.REFERSH){
            String dataStr = AbGsonUtil.bean2Json(departBean);
            CacheUtil.saveCacheData(URLs.HOST_JKDA+URLs.DEPART_LIST,dataStr);
        }
        mDepartListFragment.cacheData(departBean); //刷新数据
    }

    /**
     * 取缓存数据
     * @param e
     */
    private void getCacheData(Throwable e){
        retrofit2.adapter.rxjava.HttpException e2 = (HttpException) e;
        if(null!=e2&&e2.code()==504){//从缓存里取
            String url = URLs.HOST_JKDA+URLs.DEPART_LIST;
            boolean isContainsKey = Network.getCacheMap().containsKey(url);
            if(isContainsKey){
                String dataStr = CacheUtil.getCacheData(url);
                final DepartBean departBean = AbGsonUtil.json2Bean(dataStr,DepartBean.class);
                mDepartListFragment.cacheData(departBean); //刷新数据
            }else{
                mDepartListFragment.errorData(1);
            }
        }else{
            e.printStackTrace();
            mDepartListFragment.errorData(1);
        }
    }
}

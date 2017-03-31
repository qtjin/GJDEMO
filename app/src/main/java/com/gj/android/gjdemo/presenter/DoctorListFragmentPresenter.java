package com.gj.android.gjdemo.presenter;


import com.gj.android.bean.DoctorListBean;
import com.gj.android.commonlibrary.api.Network;
import com.gj.android.commonlibrary.api.URLs;
import com.gj.android.commonlibrary.base.BaseFragmentPresenter;
import com.gj.android.commonlibrary.util.AbGsonUtil;
import com.gj.android.commonlibrary.util.CacheUtil;
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

    public void getDoctorList(String seqType,String drType,String SearchStr,String sectionsName,String curPage){

        Subscriber subscriber = null;

        if(mDoctorListFragment.loadType== DoctorListFragment.LoadType.INIT){
             subscriber = new ProgressSubscriber<DoctorListBean.DataBean>(mDoctorListFragment.getActivity()) { //带进度条的订阅者
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    saveCacheData(DataBean);
                }

                 @Override
                 public void onError(Throwable e) {
                     super.onError(e);
                     getCacheData(e);
                 }
             };
        }else{
            subscriber = new MySubscriber<DoctorListBean.DataBean>(mDoctorListFragment.getActivity()) { //下拉刷新上拉加载更多自带进度条
                @Override
                public void onNext(DoctorListBean.DataBean DataBean) {
                    saveCacheData(DataBean);
                }

                @Override
                public void onError(Throwable e) {
                    getCacheData(e);
                }
            };
        }

        Observable<DoctorListBean.DataBean> observable = Network.getInstance()
               .getApi().getDoctorList(seqType,drType,SearchStr,sectionsName,curPage).map(new HttpResultFunc<DoctorListBean.DataBean>()); //被订阅者

        toSubscribe(observable,subscriber);  //订阅

    }

    /**
     * 存缓存数据
     * @param
     */
    private void saveCacheData(DoctorListBean.DataBean dataBean){
        if(mDoctorListFragment.loadType== DoctorListFragment.LoadType.INIT||mDoctorListFragment.loadType== DoctorListFragment.LoadType.REFERSH){
            String dataStr = AbGsonUtil.bean2Json(dataBean);
            CacheUtil.saveCacheData(URLs.HOST_JKDA+URLs.DOCTOR_LIST,dataStr);
        }
        mDoctorListFragment.pressData(dataBean); //刷新数据
    }

    /**
     * 取缓存数据
     * @param e
     */
    private void getCacheData(Throwable e){
        retrofit2.adapter.rxjava.HttpException e2 = (HttpException) e;
        if(null!=e2&&e2.code()==504){//从缓存里取
            String url = URLs.HOST_JKDA+URLs.DOCTOR_LIST;
            boolean isContainsKey = Network.getCacheMap().containsKey(url);
            if(isContainsKey){
                String dataStr = CacheUtil.getCacheData(url);
                final DoctorListBean.DataBean dataBean = AbGsonUtil.json2Bean(dataStr,DoctorListBean.DataBean.class);
                mDoctorListFragment.cacheData(dataBean); //刷新数据
            }else{
                mDoctorListFragment.errorData(1);
            }
        }else{
            e.printStackTrace();
            mDoctorListFragment.errorData(1);
        }
    }

}

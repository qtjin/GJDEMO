package com.gj.android.gjlibrary.base;

import com.gj.android.bean.BaseBean;
import com.gj.android.gjlibrary.util.rxjava.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by guojing on 2016/11/25.
 * 业务模块模型基类
 */

public abstract class BasePresenter<T> {

    protected BaseActivity baseActivity;

    protected String SUCCESS_STR;

    protected String ERROR_STR;

    public BasePresenter(BaseActivity baseActivity){
        this.baseActivity = baseActivity;
    }


    /**
     * 订阅
     * @param o 被订阅者
     * @param s 订阅者
     * @param <T>
     */
    protected  <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    public static class HttpResultFunc<T> implements Func1<BaseBean<T>, T> {

        @Override
        public T call(BaseBean<T> baseBean) {
            if (baseBean.success!=1) {
                throw new ApiException(baseBean.error);
            }else if(null== baseBean.data){
                throw new ApiException("暂无数据");
            }
            return baseBean.data;
        }
    }

    /**
     * flatMap
     * 在有序二次请求的时候可以用到，第一次请求返回的Observable对象通过flatMap转换
     * 在其构造方法中传入下一次请求要访问接口的返回值类型来作为call方法的返回值类型
     * 最后给subscriber订阅
     */
    public static class HttpResultFlatFunc<E,F> implements Func1<BaseBean<E>, Observable<BaseBean<F>>> {

        public Observable<BaseBean<F>> observable;

        public HttpResultFlatFunc(Observable<BaseBean<F>> observable){
            this.observable = observable;
        }

        @Override
        public Observable<BaseBean<F>> call(BaseBean<E> baseBean) {
            if (baseBean.success!=1) {
                throw new ApiException(baseBean.error);
            }else if(null== baseBean.data){
                throw new ApiException("暂无数据");
            }
            return observable;
        }
    }

    /**
     * 过滤 如果Boolean=false就停止后面链式方法的执行
     */
    public static class HttpResultFilterFunc implements Func1<BaseBean, Boolean> {

        @Override
        public Boolean call(BaseBean baseBean) {
            if (baseBean.success!=1) {
                throw new ApiException(baseBean.error);
            }else if(null== baseBean.data){
                throw new ApiException("暂无数据");
            }
            return baseBean.success==1;
        }
    }

}

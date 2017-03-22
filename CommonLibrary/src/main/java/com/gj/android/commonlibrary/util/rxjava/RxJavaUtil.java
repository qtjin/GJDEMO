package com.gj.android.commonlibrary.util.rxjava;

import android.view.View;
import android.widget.EditText;

import com.gj.android.commonlibrary.R;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by guojing on 2017/3/16 0016.
 * RxJava工具类，将RxJava的使用的一些场景进行了封装
 */

public class RxJavaUtil<T> {

    public interface CallbackInter<C>{
        public void call(C c);
    }

    /**
     * 使用timer做定时操作。当有“x秒后执行y操作”类似的需求的时候，想到使用timer
     */
    public Subscription timer(Long seconds, final CallbackInter callbackInter) {
        return Observable.timer(seconds, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Long seconds) {
                        callbackInter.call(seconds);
                    }
                });
    }

    /**
     * 使用interval做周期性操作。当有“每隔xx秒后执行yy操作”类似的需求的时候，想到使用interval
     */
    public Subscription interval(Long seconds, final CallbackInter callbackInter) {
        return Observable.interval(seconds, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Long seconds) {
                        callbackInter.call(seconds);
                    }
                });
    }

    /**
     * RxJava进行数组、list的遍历
     */
    public Subscription from(List<T> list, final CallbackInter callbackInter){
        return Observable
                .from(list)
                .subscribe(new Action1<T>() {
                    @Override
                    public void call(T elem) {
                        callbackInter.call(elem);
                    }
                });
    }

    /**
     * 解决嵌套回调（callback hell）问题
     */
    public Subscription flatMap(Observable<T> observable, final Observable<R> observableResult, final CallbackInter callbackInter){
        return observable
                .flatMap(new Func1<T, Observable<R>>() {
                    @Override
                    public Observable<R> call(T t) {
                        return observableResult;
                    }
                })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Subscriber<R>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(R data) {
                        callbackInter.call(data);
                    }
                });
    }

    /**
     * Scheduler线程简单切换
     * 后台线程取数据，主线程展示
     */
    public Subscription just(T getElemMethod,final CallbackInter callbackInter){
            return Observable.just(getElemMethod)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<T>() {
                    @Override
                    public void call(T t) {
                        callbackInter.call(t);
                    }
                });
    }


    /**
     * 使用merge合并两个数据源
     * 例如一组数据来自网络，一组数据来自文件，需要合并两组数据一起展示。
     */
    public Subscription merge(Observable<T> elem,Observable<T> elem2,final CallbackInter callbackInter){
        return Observable.merge(elem,elem2)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(T data) {
                        callbackInter.call(data);
                    }});
    }

    /**
     * 使用concat和first做缓存
     * 依次检查memory、disk和network中是否存在数据，任何一步一旦发现数据后面的操作都不执行。
     */
    public Subscription concat(Observable<T> elem, Observable<T> elem2, Observable<T> elem3, final CallbackInter callbackInter){
       return Observable.concat(elem, elem2, elem3)
                .first()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(T data) {
                        callbackInter.call(data);
                    }
                });
    }


    /**
     * 使用throttleFirst防止按钮重复点击 建议seconds的值为1秒
     */
    public Subscription throttleFirst(View view, Long seconds,final CallbackInter callbackInter) {
        return RxView.clicks(view)
                .throttleFirst(seconds, TimeUnit.SECONDS)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Object o) {
                        callbackInter.call(o);
                    }
                });
    }

    /**
     * 使用debounce做textSearch
     * 用简单的话讲就是当N个结点发生的时间太靠近（即发生的时间差小于设定的值T），debounce就会自动过滤掉前N-1个结点。
     比如在做百度地址联想的时候，可以使用debounce减少频繁的网络请求。避免每输入（删除）一个字就做一次联想
     * @param inputEditText
     * @param callbackInter
     */
    public Subscription textChangeEvents(EditText inputEditText, final CallbackInter callbackInter){
        return RxTextView.textChangeEvents(inputEditText)
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextViewTextChangeEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TextViewTextChangeEvent onTextChangeEvent) {
                        callbackInter.call(onTextChangeEvent.text().toString());
                    }
                });
    }


    /**
     * 使用schedulePeriodically做轮询请求
     * Long initial_delay 初始延迟
     * Long polling_interval polling延迟
     */
    public Subscription schedulePeriodically(final T elem,final Long initial_delay,final Long polling_interval,final CallbackInter callbackInter) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(final Subscriber<? super T> observer) {
                Schedulers.newThread().createWorker()
                        .schedulePeriodically(new Action0() {
                            @Override
                            public void call() {
                                observer.onNext(elem);
                            }
                        }, initial_delay, polling_interval, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Action1<T>() {
            @Override
            public void call(T t) {
                callbackInter.call(t);
            }
        });
    }

}

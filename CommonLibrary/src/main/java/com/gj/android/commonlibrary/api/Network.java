// (c)2016 Flipboard Inc, All Rights Reserved.

package com.gj.android.commonlibrary.api;

import android.text.TextUtils;
import android.util.Log;

import com.gj.android.commonlibrary.util.AbAppUtils;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class Network {

    private Retrofit retrofit;

    public static final String BASE_URL = URLs.HOST_JKDA;

    private static final int DEFAULT_TIMEOUT = 5; //超时5秒

    private static final String TAG = "Network";

    private static Api api;

    private static HashMap<String,String> cacheMap = new HashMap<>(); //保存请求URL的MAP来处理并发的情况

    public static HashMap<String,String> getCacheMap(){
        return cacheMap;
    }

    /**
     * 构造方法私有
     */
    private Network(){
        File cacheDir = StorageUtils.getCacheDirectory(AbAppUtils.getContext());
        Cache myCache = new Cache(cacheDir, 10 * 1024 * 1024);

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG,"message--->"+message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS) //设置超时时间
                .addInterceptor(httpLoggingInterceptor) //添加拦截器
                .addInterceptor(new BaseInterceptor())
                .addNetworkInterceptor(new NetworkBaseInterceptor())
                .cache(myCache)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL) //填写自己服务器IP
                .addConverterFactory(GsonConverterFactory.create()) //添加json转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //添加 RxJava 适配器
                .build();
        api = retrofit.create(Api.class);
    }


    public Api getApi() {
        return api;
    }

    private static class NetworkHolder{
        private static final Network network = new Network();
    }

    public static Network getInstance(){
        return NetworkHolder.network;
    }


    static class BaseInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            // 一些公共参数 在这里处理...

            if (!AbAppUtils.isNetworkAvailable(AbAppUtils.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                String url = request.url().toString();
                Log.d("Network","intercept url"+url);
                cacheMap.put(url,"");
//                synchronized (mCacheListener) {
//                    // 没有网络走缓存
//                    if (null != mCacheListener) {
//                        mCacheListener.getLocalCache(request.url().toString());
//                    }
//                }
            }
            return chain.proceed(request);
        }
    }

   private static class NetworkBaseInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String uid = "0";

            Request request = chain.request();
            Response originalResponse = chain.proceed(request);

            String serverCache = originalResponse.header("Cache-Control");
            if (TextUtils.isEmpty(serverCache)) {
                // 如果服务端设置相应的缓存策略那么遵从服务端的不做修改

                String cacheControl = request.cacheControl().toString();
                Response res = originalResponse.newBuilder()
                        .addHeader("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
                return res;
            } else {
                return originalResponse;
            }
        }
    }
}

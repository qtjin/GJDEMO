// (c)2016 Flipboard Inc, All Rights Reserved.

package com.gj.android.gjlibrary.api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class Network {

    private Retrofit retrofit;

    public static final String BASE_URL = URLs.HTTPS_URL;

    private static final int DEFAULT_TIMEOUT = 5; //超时5秒

    private static final String TAG = "Network";

    /**
     * 构造方法私有
     */
    private Network(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG,"message--->"+message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public Api getApi() {
        return retrofit.create(Api.class);
    }

    private static class NetworkHolder{
        private static final Network network = new Network();
    }

    public static Network getInstance(){
        return NetworkHolder.network;
    }

}

package com.gj.android.gjlibrary.api;


/**
 * 访问请求路径
 */
public class URLs {

    private final static IHostFetcher sIHostFetcher = ApiConfig.getInstance();

    public final static String HOST_JKDA = sIHostFetcher.getHOST_JKDA(); //以后可能会有多个HOST


}

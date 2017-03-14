package com.gj.android.gjlibrary.api;


/**
 * 访问请求路径
 */
public class URLs {

    private final static IHostFetcher sIHostFetcher = ApiConfig.getInstance();

    public final static String HTTP = "http://";
    public final static String HTTPS = "https://";
    public final static String URL_SPLITTER = "/";
    public final static String HOST_JKDA = sIHostFetcher.getHOST_JKDA();



    public final static String HTTP_URL = HTTP + HOST_JKDA + URL_SPLITTER;

    public final static String HTTPS_URL = HTTPS + HOST_JKDA + URL_SPLITTER;


}

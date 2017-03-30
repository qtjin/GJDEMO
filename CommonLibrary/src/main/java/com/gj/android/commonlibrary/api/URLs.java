package com.gj.android.commonlibrary.api;


/**
 * 访问请求路径
 */
public class URLs {

    private final static IHostFetcher sIHostFetcher = ApiConfig.getInstance();

    public final static String HOST_JKDA = sIHostFetcher.getHOST_JKDA(); //以后可能会有多个HOST

    public static final String METHOD_DOCTOR_LIST = "mobile/wys/getDoctorListV29.json";

    public static final String DEPART_LIST = "/jkda/mobile/wys/allChunYuDepart?appversion=3.3.0&healthAccount=2000398050&os=android&version=6.0.1 HTTP/1.1";

}

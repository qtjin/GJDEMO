package com.gj.android.gjlibrary.api;


/**
 * 访问请求路径
 */
public class URLs {

    public final static String HTTP = "http://";
    public final static String URL_SPLITTER = "/";
    public final static String HOST_JKDA = ConfigUtils.HOST_JKDA;



    //问医生——获取医生药师列表
    public final static String GET_WYS_DOCTOR_LIST = HTTP + HOST_JKDA + URL_SPLITTER /*+ "mobile/wys/getDoctorListV29.json"*/;


}

package com.gj.gjlibrary.api;

public class ConfigUtils {

    private static IHostFetcher sIHostFetcher = ApiConfig.getInstance();


    /**
     * 访问环境路径
     */
    public static final String HOST_OLD = sIHostFetcher.getHost_OLD();
    public static final String HOST_JKDA = sIHostFetcher.getHOST_JKDA();
    public static final String HOST_JKDA_H5 = sIHostFetcher.getfHOST_JKDA_S_H5();
    public static final String MDS_HOST = sIHostFetcher.getHOST_MDS();
    public static final String MDS_IMG = sIHostFetcher.getHOST_MDS_IMG();
    /**
     * 静态访问路径
     */
    public static final String ANCHOR_HORST = sIHostFetcher.getHOST_ANCHOR();
    /**
     * APK跟新路径
     */
    public static final String APKHOST = sIHostFetcher.getHOST_APK();

    /***
     * BOPS地址BOPS_HOST
     */
    public static final String BOPS_HOST = sIHostFetcher.getHOST_BOPS();
    public static final String BOPS_HOST_H5 = sIHostFetcher.getfHOST_BOPS_S_H5();

    public static final String CHANNEL = "Jzt";

    /***
     * 示范体检的BOPS地址DEMONSTRINE_BOPS_HOST
     */
    public static final String DEMONSTRINE_BOPS_HOST = sIHostFetcher.getHOST_BOPS_DEMONSTRINE();

    /**
     * h5静态
     */
    public static final String HTML5_HEAD = sIHostFetcher.getH5_HEAD();

    /**
     * h5静态
     */
    public static final String SEARCH_HTML5 = sIHostFetcher.getH5_SEARCH();

    /**
     * 挂号bops地址
     */
    public static final String REGISTERING_BOPS = sIHostFetcher.getHOST_BOPS();
    /**
     * 挂号地址
     */
    public static final String REGISTERING = sIHostFetcher.getHOST_BOPS_REGISTERED();
    /**
     * 好大夫 挂号地址
     */
    public static final String HDF_REGISTERING = sIHostFetcher.getHDF_REGISTERING();

    /**
     * 医生资讯
     */
    public static final String DOCTOR_INFORMATION = sIHostFetcher.getHOST_CMS();

    /**
     * ANYCHAT服务器IP
     */
    public static final String ANYCHAT = sIHostFetcher.getANYCHAT();
    /**
     * 环信IM接口
     */
    public static final String HUANXINIM = sIHostFetcher.getHUANXINIM();

    /**
     * 视频查看处方
     */
    public static final String BOPSHOST_PHOTO = sIHostFetcher.getfHOST_BOPS_S_H5();

    /**
     * 热门文章
     */
    public static final String HOT_ARTICLES_HOST = sIHostFetcher.getHOST_CMS();

    /**
     * 热门文章 h5
     */
    public static final String HOT_ARTICLES_HOST_H5 = sIHostFetcher.getHOST_CMS_H5();
    /**
     * 陪诊
     */
    public static final String HOST_PEIZHEN = sIHostFetcher.getHOST_PZ_HOME();
    /**
    *美年
    */
    public static final String HOST_MEINIAN = sIHostFetcher.getHOST_PE();


    //好大夫挂号上传图片
    public static final String HDF_UPLOAD = sIHostFetcher.getHDF_UPLOAD();

    public static final String HOST_ANALYZER = sIHostFetcher.getHOST_ANALYZER();

    public static final String HOST_MSG = sIHostFetcher.getfHOST_MSG();
}

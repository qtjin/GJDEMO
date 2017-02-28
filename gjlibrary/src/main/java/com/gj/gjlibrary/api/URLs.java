package com.gj.gjlibrary.api;


/**
 * 访问请求路径
 */
public class URLs {

    public final static String HTTP = "http://";
    public final static String URL_SPLITTER = "/";

    public final static String HOST_OLD = ConfigUtils.HOST_OLD;
    public final static String HOST_JKDA = ConfigUtils.HOST_JKDA;
    public final static String HOST_JKDA_H5 = ConfigUtils.HOST_JKDA_H5;
    public final static String MDS_HOST = ConfigUtils.MDS_HOST;
    public final static String MDS_IMG = ConfigUtils.MDS_IMG;
    public final static String HOST_MEINIAN = HTTP + ConfigUtils.HOST_MEINIAN;
    public final static String HOST_MSG = HTTP + ConfigUtils.HOST_MSG;

    public final static String HOST_ANALYZER = ConfigUtils.HOST_ANALYZER;
    //     public final static String HOST_JKDA_H5                                = "10.3.5.21:8083";
    //  public final static String HOST_JKDA_H5                                = "10.0.27.38:8086";
    //public final static String HOST_JKDA_H5                                = "10.0.27.107:8080";
    //  public final static String HOST_JKDA_H5                                = "10.0.27.93:8080";
    //  public final static String HOST_JKDA_H5                                = "10.0.27.93:8080";
//    public final static String HOST_JKDA_H5                                = "10.0.27.222:10086";
//   public final static String HOST_JKDA_H5                                = "10.0.27.216:8086";
//    public final static String HOST_JKDA_H5                                = "10.0.27.123:8086";
    // public final static String HOST_JKDA_H5 ="test-jkda.998jk.com";
    public final static String SEARCH_HTML_HOST = ConfigUtils.SEARCH_HTML5; //详情html5
    // public final static String SEARCH_HTML_HOST                        = "test-jkss-knowledge.998jk.com/jkss";
    public final static String ANCHOR_HORST = ConfigUtils.ANCHOR_HORST;
    public final static String APKHOST = ConfigUtils.APKHOST;
    //public final static String DOWN_IMAGE                         = "10.3.5.42";
    public final static String DOWN_IMAGE = HOST_JKDA_H5;
    //    public final static String DOCTOR_IMAGE                       = "10.3.5.38";
    public final static String DEMONSTRINE_BOPS_HOST = ConfigUtils.DEMONSTRINE_BOPS_HOST;
    //     public final static String HOST_JKDA_H5 = "test-jkda.998jk.com";http://test-bops.998jk.com
    public final static String BOPS_HOST = ConfigUtils.BOPS_HOST;
    public final static String BOPS_HOST_H5 = ConfigUtils.BOPS_HOST_H5;
//     public final static String BOPS_HOST                           = ConfigUtils.BOPS_HOST;
    //public final static String BOPS_HOST                           = "http://test-bops.998jk.com/cs/bops2/preview/report.htm";

    public final static String IS_SECURITY = "v2/";
    //    private final static String REGISTERING_BOPS = "10.0.27.70:8080";
//    private final static String REGISTERING = "10.0.27.70:8080";
    private final static String REGISTERING_BOPS = ConfigUtils.REGISTERING_BOPS;
    private final static String REGISTERING = ConfigUtils.REGISTERING;
    private final static String HDF_REGISTERING = ConfigUtils.HDF_REGISTERING;

    public final static String ANYCHAT = ConfigUtils.ANYCHAT;
    private final static String HUANXINIM = ConfigUtils.HUANXINIM;

    public final static String BOPSHOST_PHOTO = HTTP + ConfigUtils.BOPSHOST_PHOTO;
    public final static String HOT_ARTICLES_HOST = HTTP + ConfigUtils.HOT_ARTICLES_HOST;
    public final static String HOT_ARTICLES_HOST_H5 = HTTP + ConfigUtils.HOT_ARTICLES_HOST_H5;
    public final static String HOST_PEIZHEN = ConfigUtils.HOST_PEIZHEN;

//     public final static String ANCHOR_HORST = "test-jkda.998jk.com";
//     public final static String APKHOST = "test.jkda.998jk.com"; // 下载apk地址
////
    // 正式
    //   public final static String HOST_JKDA_H5 = "jkda.998jk.com";

    //html5静态
//    public final static String HTML5_HEAD = "test-static.998jk.com/static/";
    public final static String HTML5_HEAD = ConfigUtils.HTML5_HEAD;
    public final static String HTML5_HEAD_BASE = HTTP + ConfigUtils.HTML5_HEAD;
    //    public final static String HEALTHASSESSMENT_IMAGE = HTTP + ConfigUtils.ANCHOR_HORST;
    // 成功list测试
    public final static String SUCCESS_LIST = HTTP + HOST_JKDA_H5 + URL_SPLITTER + "successlist.htm";
    // 失败list测试
    public final static String ERR_LIST = HTTP + HOST_JKDA_H5 + URL_SPLITTER + "errlist.htm";

//    // 成功OBJ测试
//    public final static String SUCCESS_OBJ = HTTP + HOST_JKDA_H5 + URL_SPLITTER + "successobj.htm";
//    // 失败OBJ测试
//    public final static String ERR_OBJ = HTTP + HOST_JKDA_H5 + URL_SPLITTER + "errobj.htm";
//
//    // 成功INFO测试
//    public final static String SUCCESS_INFO = HTTP + HOST_JKDA_H5 + URL_SPLITTER + "successinfo.htm";
//    // 失败INFO测试
//    public final static String ERR_INFO = HTTP + HOST_JKDA_H5 + URL_SPLITTER + "errinfo.htm";

    // 上传测试
    public final static String UP_FILE = HTTP + HOST_JKDA_H5 + URL_SPLITTER + "upFile.htm";


    // 获取结构化json数据
    public final static String GET_JGHDATA = HTTP + HOST_JKDA + URL_SPLITTER + "getjgh.json";


    //问医生——获取医生药师列表
    public final static String GET_WYS_DOCTOR_LIST = HTTP + HOST_JKDA + URL_SPLITTER /*+ "mobile/wys/getDoctorListV29.json"*/;


}

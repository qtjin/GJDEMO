package com.gj.android.commonlibrary.api;


/**
 * Created by tangkun on 16/9/3.
 */
public class ApiConfig implements IHostFetcher {

    public final static String HTTP = "http://";
    public final static String HTTPS = "https://";
    public final static String URL_SPLITTER = "/";

    private IHostFetcher iHostFetcher;

    private ApiConfig(){
        int type = BuildConfigUtils.getBuildConfigValue("HOST_TYPE", Integer.valueOf(-1));
        switch (type) {
            //release
            case 1:
                iHostFetcher = new HostRelease();
                break;
            //debug
            case 2:
                iHostFetcher = new HostDebug();
                break;
            //prepare
            case 3:
                iHostFetcher = new HostPrepare();
                break;
            //默认为release
            default:
                iHostFetcher = new HostRelease();
        }
    }

    private static class ApiConfigHolder{
        private static final ApiConfig apiConfig = new ApiConfig();
    }

    public static ApiConfig getInstance() {
        return ApiConfigHolder.apiConfig;
    }

    @Override
    public String getHOST_JKDA() {
        return addSchemeToUrl(iHostFetcher.getHOST_JKDA());
    }


    public String addSchemeToUrl(String hostname) {
        if (hostname == null) {
            return null;
        }
        if (!hostname.contains(HTTPS)) {
            hostname = HTTPS + hostname;
        }
        if (!hostname.endsWith(URL_SPLITTER)) {
            hostname += URL_SPLITTER;
        }
        return hostname;
    }
}

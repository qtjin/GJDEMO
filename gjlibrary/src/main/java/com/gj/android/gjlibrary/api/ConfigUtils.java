package com.gj.android.gjlibrary.api;

public class ConfigUtils {

    private static IHostFetcher sIHostFetcher = ApiConfig.getInstance();


    public static final String HOST_JKDA = sIHostFetcher.getHOST_JKDA();

}

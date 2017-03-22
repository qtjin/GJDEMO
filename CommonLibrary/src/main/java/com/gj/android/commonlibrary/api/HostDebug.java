package com.gj.android.commonlibrary.api;

/**
 * Created by tangkun on 16/9/3.
 * 测试环境HOST对象
 */
public final class HostDebug implements IHostFetcher {
    private final String fHOST = "api.998jk.com";
    private final String fHOST_JKDA = fHOST + "/jkda";


    @Override
    public String getHOST_JKDA() {
        return fHOST_JKDA;
    }

}

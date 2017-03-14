package com.gj.android.gjlibrary.api;

/**
 * Created by tangkun on 16/9/3.
 * 预发布环境HOST对象
 */
public final class HostPrepare implements IHostFetcher {
    private final String fHOST = "api.998jk.com";

    private final String fHOST_JKDA = fHOST + "/jkda";


    @Override
    public String getHOST_JKDA() {
        return fHOST_JKDA;
    }

}

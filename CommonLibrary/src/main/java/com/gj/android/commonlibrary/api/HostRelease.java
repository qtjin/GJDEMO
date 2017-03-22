package com.gj.android.commonlibrary.api;

/**
 * Created by tangkun on 16/9/3.
 * 正式环境HOST对象
 */
public final class HostRelease implements IHostFetcher {
    private final String fHOST = "api.998jk.cn" + S_PORT;

    private final String fHOST_JKDA = fHOST + "/jkda";

    @Override
    public String getHOST_JKDA() {
        return fHOST_JKDA;
    }

}

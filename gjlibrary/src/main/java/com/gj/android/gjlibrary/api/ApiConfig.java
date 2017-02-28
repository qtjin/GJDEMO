package com.gj.android.gjlibrary.api;


/**
 * Created by tangkun on 16/9/3.
 */
public class ApiConfig implements IHostFetcher {

    private IHostFetcher iHostFetcher;

    private ApiConfig() {
        throw new IllegalArgumentException("单例模式不能创建实例");
    }

    private ApiConfig(IHostFetcher iHostFetcher) {
        this.iHostFetcher = iHostFetcher;
    }

    private static final IHostFetcher sApiConfig;

    static {
        int type = BuildConfigUtils.getBuildConfigValue("HOST_TYPE", Integer.valueOf(-1));

        IHostFetcher iHostFetcher;
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
        sApiConfig = new ApiConfig(iHostFetcher);
    }

    public static IHostFetcher getInstance() {
        return sApiConfig;
    }

    @Override
    public String getHOST_JKDA() {
        return iHostFetcher.getHOST_JKDA();
    }
}

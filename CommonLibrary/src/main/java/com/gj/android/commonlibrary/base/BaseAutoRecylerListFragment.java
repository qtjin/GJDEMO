package com.gj.android.commonlibrary.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.gj.android.commonlibrary.widget.LoadMoreRecyclerView;

/**
 * Created by guojing on 15/11/6.
 */
public abstract class BaseAutoRecylerListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        LoadMoreRecyclerView.LoadMoreListener {

    /**
     * 定义加载的枚举类型
     */
    public enum LoadType {
        INIT, //第一次加载
        REFERSH, //刷新
        LOADMORE; //查看更多
    }

    public int curPage=1;
    public int pageSize=10;

    public LoadType loadType =  LoadType.INIT;

    protected abstract void getModelData()
            ;
    protected abstract void initAdapter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        initAdapter();
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onLoadMore() {
        loadType = LoadType.LOADMORE;
        curPage++;
        getModelData();
    }

    @Override
    public void onRefresh() {
        loadType = LoadType.REFERSH;
        curPage=1;
        getModelData();
    }

    @Override
    public void onResume() {
        super.onResume();
        getModelData();
    }

}

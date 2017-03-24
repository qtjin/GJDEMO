package com.gj.android.gjdemo.ui.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gj.android.commonlibrary.base.BaseFragment;
import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.util.SpacesItemDecoration;
import com.gj.android.gjdemo.widget.adapter.OneRecycleAdapter;

import butterknife.BindView;

public class OneRecycleFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.lay_refresh)
    SwipeRefreshLayout layRefresh;


    private OneRecycleAdapter adapter;

    public static OneRecycleFragment newInstance() {
        return new OneRecycleFragment();
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.fragment_recycle;
    }

    @Override
    protected void initListener() {
        initBase();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void pressData(Object obj) {

    }

    @Override
    public void errorData(int type) {

    }

    private void initBase() {
        layRefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        layRefresh.setOnRefreshListener(this);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp_6);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels)); //列间距

//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 6, GridLayoutManager.VERTICAL, false));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

//        List<Cheese> results = new ArrayList<Cheese>();
//        results.add(new Cheese("", "my titles develop by random1"));
//        results.add(new Cheese("", "my titles develop by random2"));
//        results.add(new Cheese("", "my titles develop by random3"));
//        results.add(new Cheese("", "my titles develop by moremoremoremoremoremoremoremore random4"));
//        results.add(new Cheese("", "my titles develop by random5"));
//        results.add(new Cheese("", "my titles develop by moremoremoremoremoremoremoremore random6"));
//        results.add(new Cheese("", "my titles develop by random7"));
//        results.add(new Cheese("", "my titles develop by moremoremoremoremoremoremoremore random8"));
//        results.add(new Cheese("", "my titles develop by moremoremoremoremoremoremoremore random9"));
//        results.add(new Cheese("", "my titles develop by random10"));
//        results.add(new Cheese("", "my titles develop by moremoremoremoremoremoremoremore random11"));
//        results.add(new Cheese("", "my titles develop by moremoremoremoremoremoremoremore random12"));
//        results.add(new Cheese("", "my titles develop by random13"));
//        results.add(new Cheese("", "my titles develop by random14"));
//        results.add(new Cheese("", "my titles develop by random15"));
        mRecyclerView.setAdapter(adapter = new OneRecycleAdapter(getActivity()));
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                layRefresh.setRefreshing(false);
                adapter.notifyDataSetChanged();
            }
        }, 1000);
    }

}

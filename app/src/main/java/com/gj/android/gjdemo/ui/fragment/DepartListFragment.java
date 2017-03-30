package com.gj.android.gjdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gj.android.bean.DepartBean;
import com.gj.android.commonlibrary.adapter.CommonRecyclerAdapter;
import com.gj.android.commonlibrary.adapter.CommonRecyclerAdapterHelper;
import com.gj.android.commonlibrary.base.BaseAutoRecylerListFragment;
import com.gj.android.commonlibrary.widget.LoadMoreRecyclerView;
import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.presenter.DepartListFragmentPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 类型列表
 */
public class DepartListFragment extends BaseAutoRecylerListFragment {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.rv_doctor_list)
    LoadMoreRecyclerView mRecyclerView;

    @BindView(R.id.ll_no_data)
    LinearLayout ll_no_data;

    @BindView(R.id.tv_refresh)
    TextView tv_refresh;

    public List<DepartBean.DataBean> mDatas;

    private CommonRecyclerAdapter<DepartBean.DataBean> mAdapter;

    private DepartListFragmentPresenter mPresenter;


    /**
     * Fragment内部实例化，封装起来
     *
     * @return
     */
    public static DepartListFragment newInstance(int pageStr) {
        DepartListFragment departListFragment =  new DepartListFragment();
        Bundle args = new Bundle();
        args.putInt("pageStr",pageStr);
        departListFragment.setArguments(args);
        return departListFragment;
    }


    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_doctor_list;
    }

    @Override
    protected void initListener() {
        pageSize = 10;
        mRecyclerView.setPageSize(pageSize);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setLoadMoreListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void pressData(Object obj) {
        if(null!=obj){
            mRefreshLayout.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
            ll_no_data.setVisibility(View.GONE);
            mRefreshLayout.setRefreshing(false);
            DepartBean mDataBean = (DepartBean) obj;
            if (null != mDataBean && null != mDataBean.data) {
                mDatas = mDataBean.data;
                if (null != mDatas) {
                    if (loadType == LoadType.LOADMORE) {
                        mAdapter.addAll(mDatas);
                    } else {
                        mAdapter.replaceAll(mDatas);
                    }
                    mRecyclerView.setResultSize(mDatas.size());
                }
            }
        }else{
            errorData(1);
        }
    }

    public void cacheData(Object obj) {
        if(null!=obj){
            mRefreshLayout.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
            ll_no_data.setVisibility(View.GONE);
            mRefreshLayout.setRefreshing(false);
            DepartBean mDataBean = (DepartBean) obj;
            if (null != mDataBean && null != mDataBean.data) {
                mDatas = mDataBean.data;
                if (null != mDatas) {
                    mAdapter.replaceAll(mDatas);
                    mRecyclerView.setResultSize(mDatas.size());
                }
            }
        }else{
            errorData(1);
        }
    }


    @Override
    public void errorData(int type) {
        mRefreshLayout.setRefreshing(false);
        mRefreshLayout.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.GONE);
        ll_no_data.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initData() {
        setTitle("科室列表Fragment");
    }

    @Override
    protected void getModelData() {
        curPage = (int) getArguments().get("pageStr");
        if (null == mPresenter) {
            mPresenter = new DepartListFragmentPresenter(this);
        }
        mPresenter.getDepartList();
    }

    @Override
    protected void initAdapter() {
        if (null == mAdapter) {
            mAdapter = new CommonRecyclerAdapter<DepartBean.DataBean>(getActivity(), mDatas, R.layout.item_main) {
                @Override
                public void convert(CommonRecyclerAdapterHelper helper, DepartBean.DataBean bean) {
                    helper.setText(R.id.tv_title, bean.departName);
                    //helper.setImageUrl(R.id.iv_img, bean.getHeadImgUrl());
                    Glide.with(getActivity()).load(bean.imgUrl).placeholder(R.drawable.ic_picture_loading)
                            .error(R.drawable.ic_picture_loadfailed).into((ImageView) helper.getView(R.id.iv_img));
                }
            };
        }
//        mAdapter.setOnItemClickListener(new CommonRecyclerAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View itemView, int position) {
//            }
//
//            @Override
//            public void onItemLongClick(View itemView, int position) {
//
//            }
//        });
    }

    @OnClick(R.id.tv_refresh)
    public void onClick(View view){
        loadType = LoadType.REFERSH;
        curPage=1;
        getModelData();
    }
}

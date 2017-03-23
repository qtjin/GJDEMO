package com.gj.android.gjdemo.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gj.android.bean.DoctorListBean;
import com.gj.android.commonlibrary.adapter.CommonRecyclerAdapter;
import com.gj.android.commonlibrary.adapter.CommonRecyclerAdapterHelper;
import com.gj.android.commonlibrary.base.BaseAutoRecylerListFragment;
import com.gj.android.commonlibrary.widget.LoadMoreRecyclerView;
import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.presenter.DoctorListFragmentPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 医生列表
 */
public class DoctorListFragment extends BaseAutoRecylerListFragment {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.rv_doctor_list)
    LoadMoreRecyclerView mRecyclerView;

    @BindView(R.id.ll_no_data)
    LinearLayout ll_no_data;

    @BindView(R.id.tv_refresh)
    TextView tv_refresh;

    public List<DoctorListBean.DataBean.ListBean> mDatas;

    private CommonRecyclerAdapter<DoctorListBean.DataBean.ListBean> mAdapter;

    private DoctorListFragmentPresenter mPresenter;


    /**
     * Fragment内部实例化，封装起来
     *
     * @return
     */
    public static DoctorListFragment newInstance() {
        return new DoctorListFragment();
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
        mRefreshLayout.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
        ll_no_data.setVisibility(View.GONE);

        mRefreshLayout.setRefreshing(false);
        DoctorListBean.DataBean mDataBean = (DoctorListBean.DataBean) obj;
        if (null != mDataBean && null != mDataBean.getList()) {
            mDatas = mDataBean.getList();
            if (null != mDatas) {
                if (loadType == LoadType.LOADMORE) {
                    mAdapter.addAll(mDatas);
                } else {
                    mAdapter.replaceAll(mDatas);
                }
                mRecyclerView.setResultSize(mDatas.size());
            }
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
        setTitle("医生列表Fragment");
    }

    @Override
    protected void getModelData() {
        if (null == mPresenter) {
            mPresenter = new DoctorListFragmentPresenter(this);
        }
        mPresenter.getDoctorList("1", "1", "", "", String.valueOf(curPage));
    }

    @Override
    protected void initAdapter() {
        if (null == mAdapter) {
            mAdapter = new CommonRecyclerAdapter<DoctorListBean.DataBean.ListBean>(getActivity(), mDatas, R.layout.item_main) {
                @Override
                public void convert(CommonRecyclerAdapterHelper helper, DoctorListBean.DataBean.ListBean bean) {
                    helper.setText(R.id.tv_title, bean.getName());
                    helper.setImageUrl(R.id.iv_img, bean.getHeadImgUrl());
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

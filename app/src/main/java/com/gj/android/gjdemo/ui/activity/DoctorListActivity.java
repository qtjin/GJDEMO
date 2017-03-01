package com.gj.android.gjdemo.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.gj.android.bean.DoctorListBean;
import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.presenter.DoctorListPresenter;
import com.gj.android.gjlibrary.adapter.CommonRecyclerAdapter;
import com.gj.android.gjlibrary.adapter.CommonRecyclerAdapterHelper;
import com.gj.android.gjlibrary.base.BaseAutoRecylerListActivity;
import com.gj.android.gjlibrary.widget.LoadMoreRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * 医生列表
 */
public class DoctorListActivity extends BaseAutoRecylerListActivity {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.rv_doctor_list)
    LoadMoreRecyclerView mRecyclerView;

    public List<DoctorListBean.DataBean.ListBean> mDatas;

    private CommonRecyclerAdapter<DoctorListBean.DataBean.ListBean> mAdapter;

    private DoctorListPresenter mPresenter;

    @Override
    protected void getBundleExtras(Bundle extras) {

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setLoadMoreListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void pressData(Object obj) {
        mRefreshLayout.setRefreshing(false);
            DoctorListBean.DataBean mDataBean = (DoctorListBean.DataBean) obj;
            if(null!=mDataBean&&null!=mDataBean.getList()){
                mDatas = mDataBean.getList();
                if(null!=mDatas){
                    if(loadType==LoadType.LOADMORE){
                        mAdapter.addAll(mDatas);
                    }else{
                        mAdapter.replaceAll(mDatas);
                    }
                    mRecyclerView.setResultSize(mDatas.size());
                }
        }
    }

    @Override
    protected void initData() {
        setTitle("医生列表");
    }

    @Override
    protected void getModelData() {
        if(null==mPresenter){
            mPresenter = new DoctorListPresenter(this);
        }
        mPresenter.getDoctorList("1","1","","",String.valueOf(curPage));
    }

    @Override
    protected void initAdapter() {
        if(null==mAdapter){
            mAdapter = new CommonRecyclerAdapter<DoctorListBean.DataBean.ListBean>(DoctorListActivity.this, mDatas, R.layout.item_main) {
                @Override
                public void convert(CommonRecyclerAdapterHelper helper, DoctorListBean.DataBean.ListBean bean) {
                    helper.setText(R.id.tv_title, bean.getName());
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
}

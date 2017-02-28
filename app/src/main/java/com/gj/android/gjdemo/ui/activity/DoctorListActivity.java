package com.gj.android.gjdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.bean.DoctorListBean;
import com.gj.android.gjdemo.presenter.DoctorListPresenter;
import com.gj.gjlibrary.adapter.CommonRecyclerAdapter;
import com.gj.gjlibrary.adapter.CommonRecyclerAdapterHelper;
import com.gj.gjlibrary.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

/**
 * 医生列表
 */
public class DoctorListActivity extends BaseActivity {


    @BindView(R.id.rv_doctor_list)
    RecyclerView mRecyclerView;

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

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //设置分隔线
        //mRecyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        //设置增加或删除条目的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        mAdapter = new CommonRecyclerAdapter<DoctorListBean.DataBean.ListBean>(DoctorListActivity.this, mDatas, R.layout.item_main) {
            @Override
            public void convert(CommonRecyclerAdapterHelper helper, DoctorListBean.DataBean.ListBean bean) {
                helper.setText(R.id.tv_title, bean.getName());
            }
        };

        mAdapter.setOnItemClickListener(new CommonRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
            }

            @Override
            public void onItemLongClick(View itemView, int position) {

            }
        });
    }

    @Override
    public void pressData(Object obj) {
        DoctorListBean.DataBean mDataBean = (DoctorListBean.DataBean) obj;
        if(null!=mDataBean&&null!=mDataBean.getList()){
            mDatas = mDataBean.getList();
        }
        mAdapter.replaceAll(mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        setTitle("医生列表");
        if(null==mPresenter){
            mPresenter = new DoctorListPresenter(this);
        }
        mPresenter.getDoctorList();
    }
}

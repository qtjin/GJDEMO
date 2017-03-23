package com.gj.android.gjdemo.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gj.android.commonlibrary.adapter.CommonRecyclerAdapter;
import com.gj.android.commonlibrary.adapter.CommonRecyclerAdapterHelper;
import com.gj.android.commonlibrary.base.BaseFragment;
import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.ui.activity.BannerActivity;
import com.gj.android.gjdemo.ui.activity.DoctorListActivity;
import com.gj.android.gjdemo.ui.activity.DoctorListActivity2;
import com.gj.android.gjdemo.ui.activity.FileActivity;
import com.gj.android.gjdemo.ui.activity.SQLiteActivity;
import com.gj.android.gjdemo.ui.activity.TabLayoutExampleActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.rv)
    RecyclerView mRecyclerView;

    public List<String> mDatas;

    private CommonRecyclerAdapter<String> adapter;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initListener() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

/*        //设置分隔线
        //mRecyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        //设置增加或删除条目的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));*/

        adapter = new CommonRecyclerAdapter<String>(getActivity(),mDatas,R.layout.item_main) {
            @Override
            public void convert(CommonRecyclerAdapterHelper helper, String str) {
                helper.setText(R.id.tv_title,str);
            }
        };

        adapter.setOnItemClickListener(new CommonRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                go(position);
            }

            @Override
            public void onItemLongClick(View itemView, int position) {

            }
        });
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("文件读写");
        mDatas.add("SQLite");
        mDatas.add("TabLayout");
        mDatas.add("医生列表Fragment实现");
        mDatas.add("医生列表Activity实现");
        mDatas.add("banner");
        adapter.replaceAll(mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void pressData(Object obj) {

    }

    @Override
    public void errorData(int type) {

    }

    private void go(int position){
        switch (position) {
            case 0:
                readyGo(FileActivity.class);
                break;
            case 1:
                readyGo(SQLiteActivity.class);
                break;
            case 2:
                readyGo(TabLayoutExampleActivity.class);
                break;
            case 3:
                readyGo(DoctorListActivity.class);
                break;
            case 4:
                readyGo(DoctorListActivity2.class);
                break;
            case 5:
                readyGo(BannerActivity.class);
                break;
        }
    }
}

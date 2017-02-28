package com.gj.android.gjdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

import com.gj.android.gjdemo.AppContext;
import com.gj.android.gjdemo.R;
import com.gj.gjlibrary.adapter.CommonRecyclerAdapter;
import com.gj.gjlibrary.adapter.CommonRecyclerAdapterHelper;
import com.gj.gjlibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.rv)
    RecyclerView mRecyclerView;

    public List<String> mDatas;

    private CommonRecyclerAdapter<String> adapter;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {

        DisplayMetrics metric = new DisplayMetrics();
        MainActivity.this.getWindowManager().getDefaultDisplay()
                .getMetrics(metric);
        AppContext.SCREEN_WIDTH = metric.widthPixels; // 屏幕宽度（像素）
        AppContext.SCREEN_HEIGHT = metric.heightPixels; // 屏幕宽度（像素）
        AppContext.DENSITY = metric.density; // 像素密度

        hideTopLeft();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //设置分隔线
        //mRecyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        //设置增加或删除条目的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        adapter = new CommonRecyclerAdapter<String>(MainActivity.this,mDatas,R.layout.item_main) {
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
        }
    }

    @Override
    public void pressData(Object obj) {

    }

    @Override
    protected void initData() {
        setTitle("GJDemo");
        mDatas = new ArrayList<>();
        mDatas.add("文件读写");
        mDatas.add("SQLite");
        mDatas.add("TabLayout");
        mDatas.add("医生列表");
        adapter.replaceAll(mDatas);
        mRecyclerView.setAdapter(adapter);
    }

}

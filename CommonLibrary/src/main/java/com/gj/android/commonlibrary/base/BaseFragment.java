package com.gj.android.commonlibrary.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gj.android.commonlibrary.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;


/**
 * Created by guojing on 15/11/6.
 */
public abstract class BaseFragment extends Fragment {

    public Subscription subscription;

    protected abstract int getContentViewLayoutId();

    protected abstract void initListener();

    protected abstract void initData();

    public abstract void pressData(Object obj);

    public abstract void errorData(int type); //type 1无网络 2超时

    protected View mRootView;

    protected ImageView mIvLeft;

    protected TextView mTvRight;

    protected TextView mTvTitle;

    protected Unbinder unbinder;

    protected void onTopLeftOnClick(){ //左边返回键
        getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentViewLayoutId() != 0) {
            mRootView = inflater.inflate(getContentViewLayoutId(), container, false);
        } else {
            mRootView = super.onCreateView(inflater, container, savedInstanceState);
        }

        mTvRight = (TextView) mRootView.findViewById(R.id.tv_right);
        mIvLeft = (ImageView) mRootView.findViewById(R.id.iv_left);
        mTvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
        if(null!=mIvLeft){
            mIvLeft.setOnClickListener(new View.OnClickListener() { //设置左边的返回按钮的监听
                @Override
                public void onClick(View v) {
                    onTopLeftOnClick();
                }
            });
        }
        unbinder = ButterKnife.bind(this, mRootView);
        initListener();
        initData();
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
        if(null!=unbinder){
            unbinder.unbind();
        }
        //ButterKnife.unbind(this);//解绑
    }


    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * startActivity
     *
     * @param clazz class
     */
    public void readyGo(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz  class
     * @param bundle bundle
     */
    public void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**
     * startActivityForResult
     *
     * @param clazz       class
     * @param requestCode requestCode
     */
    public void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz       clazz
     * @param requestCode requestCode
     * @param bundle      bundle
     */
    public void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 进度条
     */
    private ProgressDialog mProgressDialog;
    /**
     * 界面是否可见
     */
    protected boolean mIsVisible;

    public ProgressDialog showProgressDialog() {
        return showProgressDialog(getString(R.string.loading), true);
    }

    public ProgressDialog showProgressDialog(String text) {
        return showProgressDialog(text, true);
    }
    public ProgressDialog showProgressDialog(String text, boolean isCancelable) {
        if (mIsVisible) {
            if (mProgressDialog == null) {
                mProgressDialog = new ProgressDialog(getActivity());
            }
            mProgressDialog.setMessage(text);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(isCancelable);
            mProgressDialog.show();
            return mProgressDialog;
        }
        return null;
    }

    public void hideProgressDialog() {
        if (mIsVisible && mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * 显示返回按钮
     */
    protected void hideTopLeft() {
        if (mIvLeft != null) {
            mIvLeft.setVisibility(View.GONE);
        }
    }

    /**
     * 显示返回按钮
     */
    protected void showTopLeft() {
        if (mIvLeft != null) {
            mIvLeft.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 显示TOP 右边按钮
     */
    protected void showTopRight() {
        if (mTvRight != null) {
            mTvRight.setVisibility(View.VISIBLE);
        }
    }
    /**
     * 隐藏TOP 右边按钮
     */
    protected void hideTopRight() {
        if (mTvRight != null) {
            mTvRight.setVisibility(View.GONE);
        }
    }

    /**
     * 设置标题
     */
    protected void setTitle(String title) {
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        }
    }
    /**
     * 设置右边内容
     */
    protected void setRightText(String rightText) {
        if (mTvRight != null) {
            mTvRight.setText(rightText);
        }
    }
}

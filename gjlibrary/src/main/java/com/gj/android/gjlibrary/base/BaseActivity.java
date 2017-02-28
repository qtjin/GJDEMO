package com.gj.android.gjlibrary.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gj.android.gjlibrary.R;
import com.gj.android.gjlibrary.util.AbAppManager;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by guojing on 2016/11/25.
 */

public abstract class BaseActivity extends AppCompatActivity {


    public Subscription subscription;

    protected abstract void getBundleExtras(Bundle extras);

    protected abstract int getContentViewLayoutId();

    protected abstract void initListener();

    protected void onTopLeftOnClick(){ //左边返回键
        finish();
    }

    public abstract void pressData(Object obj);

    protected abstract void initData();

    protected ImageView mIvLeft;

    protected TextView mTvRight;

    protected TextView mTvTitle;

    protected Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewLayoutId() != 0) {
            setContentView(getContentViewLayoutId()); //设置布局
        }

        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }

        mToolbar = (Toolbar) findViewById(R.id.topToolbar);
        if(null!=mToolbar){
            mTvRight = (TextView) mToolbar.findViewById(R.id.tv_right);
            mIvLeft = (ImageView) mToolbar.findViewById(R.id.iv_left);
            mTvTitle = (TextView) mToolbar.findViewById(R.id.tv_title);
            if(null!=mIvLeft){
                mIvLeft.setOnClickListener(new View.OnClickListener() { //设置左边的返回按钮的监听
                    @Override
                    public void onClick(View v) {
                        onTopLeftOnClick();
                    }
                });
            }
        }
        ButterKnife.bind(this);
        AbAppManager.getAbAppManager().addActivity(this);
        initListener();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
        //ButterKnife.unbind(this);
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
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz  class
     * @param bundle bundle
     */
    public void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz class
     */
    public void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz  class
     * @param bundle bundle
     */
    public void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       class
     * @param requestCode requestCode
     */
    public void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
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
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void finish() {
        super.finish();
        AbAppManager.getAbAppManager().finishActivity(this);
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
     * 设置标题
     */
    protected void setTitle(String title) {
        if (mTvTitle != null) {
            mTvTitle.setText(title);
        }
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
                mProgressDialog = new ProgressDialog(this);
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
}

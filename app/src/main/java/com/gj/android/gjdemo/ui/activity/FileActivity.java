package com.gj.android.gjdemo.ui.activity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.util.FileHelper;
import com.gj.gjlibrary.base.BaseActivity;
import com.gj.gjlibrary.util.PermissionGrantUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

public class FileActivity extends BaseActivity {

    @BindView(R.id.editname)
    EditText editname;

    @BindView(R.id.editdetail)
    EditText editdetail;

    @BindView(R.id.btnsave)
    Button btnsave;

    @BindView(R.id.btnclean)
    Button btnclean;

    @BindView(R.id.btnread)
    Button btnread;

    @BindView(R.id.btnsaveSD)
    Button btnsaveSD;

    @BindView(R.id.btnreadSD)
    Button btnreadSD;

    private View mLayout;

    @OnClick({ R.id.btnsave,R.id.btnclean,R.id.btnread,R.id.btnsaveSD,R.id.btnreadSD})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnclean:
                editdetail.setText("");
                editname.setText("");
                break;
            case R.id.btnsave:
                saveFile();
                break;
            case R.id.btnread:
                readFile();
                break;
            case R.id.btnsaveSD:
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                    boolean isGrantPermission = PermissionGrantUtil.getInstance(FileActivity.this,mLayout).checkPermissionActivity(Manifest.permission.READ_EXTERNAL_STORAGE,PermissionGrantUtil.READ_EXTERNAL_STORAGE);
                    if(isGrantPermission){
                        saveFileSD();
                    }
                }else{
                    saveFileSD();
                }
                break;
            case R.id.btnreadSD:
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                    boolean isGrantPermission = PermissionGrantUtil.getInstance(FileActivity.this,mLayout).checkPermissionActivity(Manifest.permission.READ_EXTERNAL_STORAGE,PermissionGrantUtil.READ_EXTERNAL_STORAGE);
                    if(isGrantPermission){
                        readFileSD();
                    }
                }else{
                    readFileSD();
                }
                break;
        }
    }

    public void saveFile(){
        FileHelper fHelper = new FileHelper(this);
        String filename = editname.getText().toString();
        String filedetail = editdetail.getText().toString();
        try {
            fHelper.save(filename, filedetail);
            Toast.makeText(this, "数据写入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "数据写入失败", Toast.LENGTH_SHORT).show();
        }
    }
    public void saveFileSD(){
        String filenameSD = editname.getText().toString();
        String filedetailSD = editdetail.getText().toString();
        FileHelper sdHelper = new FileHelper(this);
        try
        {
            sdHelper.savaFileToSD(filenameSD, filedetailSD);
            Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
        }
    }
    public void readFile(){
        String detail = "";
        FileHelper fHelper2 = new FileHelper(this);
        try {
            String fname = editname.getText().toString();
            detail = fHelper2.read(fname);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, detail, Toast.LENGTH_SHORT).show();
    }
    public void readFileSD(){
        String detailSD = "";
        FileHelper sdHelper2 = new FileHelper(this);
        try
        {
            String filename2 = editname.getText().toString();
            detailSD = sdHelper2.readFromSD(filename2);
        }
        catch(IOException e){e.printStackTrace();}
        Toast.makeText(getApplicationContext(), detailSD, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_file;
    }

    @Override
    protected void initListener() {
            showTopLeft();
    }

    @Override
    public void pressData(Object obj) {

    }

    @Override
    protected void initData() {
        setTitle("文件处理");
    }

}

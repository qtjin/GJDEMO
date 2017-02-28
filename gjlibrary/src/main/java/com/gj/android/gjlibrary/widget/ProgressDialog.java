package com.gj.android.gjlibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.gj.android.gjlibrary.R;


/*
 * 全屏Dialog
 */
public class ProgressDialog extends Dialog {

	private Context context;
	private String loadingTxt;
	public ProgressDialog(Context context , String loadingTxt) {
		this(context, R.style.DialogFullscreen);
		this.context = context;
		this.loadingTxt = loadingTxt;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	public ProgressDialog(Context context, int theme) {
		super(context, R.style.DialogFullscreen);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_loading);
		TextView loadingTextView = (TextView)findViewById(R.id.dialogLoadingTxt);
		loadingTextView.setText(loadingTxt);
	}

}

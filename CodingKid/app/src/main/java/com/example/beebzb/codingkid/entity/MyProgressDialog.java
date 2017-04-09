package com.example.beebzb.codingkid.entity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.StringRes;

import com.example.beebzb.codingkid.R;

public class MyProgressDialog extends ProgressDialog {
    public MyProgressDialog(Context context) {
        super(context);
        setTitle(R.string.progress_dialog_title);
        setCancelable(false);
    }

    public void setMessage(@StringRes int messageStringId){
        setMessage(getContext().getResources().getString(messageStringId));
    }
}
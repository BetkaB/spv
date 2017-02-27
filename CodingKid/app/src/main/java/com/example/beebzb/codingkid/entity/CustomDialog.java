package com.example.beebzb.codingkid.entity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context);
        setCancelable(true);
        Window window = this.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}

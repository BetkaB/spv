package com.example.beebzb.codingkid;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class AfterWinDialog extends Dialog {
    interface AfterWinDialogCallback {
        void onActionButtonClicked(int highestLevelDone);
    }

    private int mHighestLevelDone;

    private AfterWinDialogCallback callback;

    public AfterWinDialog(Context context, AfterWinDialogCallback callback, int highestLevel) {
        super(context);
        View view = View.inflate(getContext(), R.layout.dialog_next_level, null);
        ButterKnife.bind(this, view);

        Window window = getWindow();
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        setContentView(view);

        this.callback = callback;
        this.mHighestLevelDone = highestLevel;
    }

    @OnClick(R.id.dialog_action_button)
    public void onActionButtonClicked() {
        callback.onActionButtonClicked(mHighestLevelDone);
    }
}

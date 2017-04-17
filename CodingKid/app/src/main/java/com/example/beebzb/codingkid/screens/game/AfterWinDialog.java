package com.example.beebzb.codingkid.screens.game;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.beebzb.codingkid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AfterWinDialog extends Dialog {

    interface AfterWinDialogCallback {
        void onActionButtonClicked(int highestLevelDone);
    }

    @BindView(R.id.dialog_action_button)
    ImageButton button;

    private int mHighestLevelDone = -1;

    private AfterWinDialogCallback callback;

    public AfterWinDialog(Context context, AfterWinDialogCallback callback, int highestLevel) {
        super(context);
        init();
        this.callback = callback;
        this.mHighestLevelDone = highestLevel;
    }

    public AfterWinDialog(Context context, AfterWinDialogCallback callback) {
        super(context);
        init();
        this.callback = callback;
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.dialog_next_level, null);
        ButterKnife.bind(this, view);

        Window window = getWindow();
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        setContentView(view);
    }

    @OnClick(R.id.dialog_action_button)
    public void onActionButtonClicked() {
        callback.onActionButtonClicked(mHighestLevelDone);
    }

    public void setReturningType() {
        button.setImageResource(R.drawable.ic_button_back);
    }
}
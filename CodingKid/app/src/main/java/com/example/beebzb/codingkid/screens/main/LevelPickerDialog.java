package com.example.beebzb.codingkid.screens.main;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.entity.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LevelPickerDialog extends CustomDialog {
    interface LevelPickerDialogCallback {
        void onPlayButtonClicked();

        void onEditButtonClicked();

        void onDeleteButtonClicked();

        void onShareButtonClicked();
    }

    @BindView(R.id.dialog_level_picker_share)
    ImageButton shareImageButton;

    private final String TAG = "LevelPickerDialog";

    private LevelPickerDialogCallback callback;

    public LevelPickerDialog(Context context, LevelPickerDialogCallback callback, boolean isUserStudent) {
        super(context);
        if (callback != null) {
            this.callback = callback;
        } else {
            Log.e(TAG, "Callback for level picker is null");
        }

        init(isUserStudent);
    }

    private void init(boolean isUserStudent) {
        View view = View.inflate(getContext(), R.layout.dialog_level_picker, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        if (isUserStudent){
            shareImageButton.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.dialog_level_picker_play)
    public void onPlayButtonClicked() {
        dismiss();
        callback.onPlayButtonClicked();
    }

    @OnClick(R.id.dialog_level_picker_share)
    public void onShareButtonClicked() {
        dismiss();
        callback.onShareButtonClicked();
    }

    @OnClick(R.id.dialog_level_picker_delete)
    public void onDeleteButtonClicked() {
        dismiss();
        callback.onDeleteButtonClicked();
    }

    @OnClick(R.id.dialog_level_picker_edit)
    public void onEditButtonClicked() {
        dismiss();
        callback.onEditButtonClicked();
    }
}

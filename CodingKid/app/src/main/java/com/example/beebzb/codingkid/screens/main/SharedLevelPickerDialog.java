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

public class SharedLevelPickerDialog extends CustomDialog {
    interface SharedLevelPickerDialogCallback {
        void onPlayButtonClicked();

        void onDeleteButtonClicked();
    }

    @BindView(R.id.dialog_level_picker_edit)
    ImageButton editImageButton;

    @BindView(R.id.dialog_level_picker_share)
    ImageButton shareImageButton;

    private final String TAG = "SharedLevelPickerDialog";

    private SharedLevelPickerDialog.SharedLevelPickerDialogCallback callback;

    public SharedLevelPickerDialog(Context context, SharedLevelPickerDialog.SharedLevelPickerDialogCallback callback) {
        super(context);
        if (callback != null) {
            this.callback = callback;
        } else {
            Log.e(TAG, "Callback for level picker is null");
        }
        init();
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.dialog_level_picker, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        shareImageButton.setVisibility(View.GONE);
        editImageButton.setVisibility(View.GONE);
    }

    @OnClick(R.id.dialog_level_picker_play)
    public void onPlayButtonClicked() {
        dismiss();
        callback.onPlayButtonClicked();
    }

    @OnClick(R.id.dialog_level_picker_delete)
    public void onDeleteButtonClicked() {
        dismiss();
        callback.onDeleteButtonClicked();
    }
}
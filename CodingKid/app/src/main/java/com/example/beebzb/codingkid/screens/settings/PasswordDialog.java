package com.example.beebzb.codingkid.screens.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.EditText;

import com.example.beebzb.codingkid.R;

public class PasswordDialog extends Dialog {

    interface Callback {
        void onPasswordConfirmed(boolean isCorrect);

        void onDialogCanceled();
    }

    private Callback mCallback;

    private final String PASSWORD = "fmfi2017";

    public PasswordDialog(Context context, Callback callback) {
        super(context);
        mCallback = callback;
        setCancelable(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.settings_activity_dialog_password_title));

        // Set up the input
        final EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton(R.string.settings_activity_alert_with_input_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String inputText = input.getText().toString();
                boolean isCorrect = inputText.equals(PASSWORD);
                if (isCorrect) {
                    dialog.cancel();
                }
                mCallback.onPasswordConfirmed(isCorrect);
            }
        });
        builder.setNegativeButton(R.string.settings_activity_alert_with_input_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                mCallback.onDialogCanceled();
            }
        });

        builder.show();
    }
}

package com.example.beebzb.codingkid.screens.editor;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.beebzb.codingkid.R;

import java.util.ArrayList;
import java.util.Arrays;


public class EditorDialog extends Dialog {

    private ImageButton boxIb;
    private ImageButton hearIb;
    private ImageButton playerIb;
    private ImageButton houseIb;

    private int chosenObject = -1;

    private ArrayList<ImageButton> buttons;

    public EditorDialog(Context context) {
        super(context);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.show();
        this.setContentView(R.layout.dialog_editor);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        this.setCancelable(false);
        init();
        setUpListeners();

    }

    private void setUpListeners() {
        for (ImageButton button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosenObject = v.getId();
                    cancel();
                }
            });
        }
    }


    private void init() {
        playerIb = (ImageButton) findViewById(R.id.playerIb);
        hearIb = (ImageButton) findViewById(R.id.heartIb);
        boxIb = (ImageButton) findViewById(R.id.boxIb);
        houseIb = (ImageButton) findViewById(R.id.houseIb);

        buttons = new ArrayList<>(Arrays.asList(playerIb, hearIb, houseIb, boxIb));

    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public int getChosenObject() {
        return chosenObject;
    }
}


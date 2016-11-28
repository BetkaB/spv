package com.example.beebzb.codingkid.entity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.example.beebzb.codingkid.R;


public class EditorButton extends Button {

    public enum GameObjectType {
        HEART(R.drawable.bheart),
        PLAYER(R.drawable.bplayer),
        HOUSE(R.drawable.bhouse),
        BOX(R.drawable.box);

        private final int drawableId;

        GameObjectType(int drawableId) {
            this.drawableId = drawableId;
        }
    }

    private Context context;
    private boolean checked = false;

    private Drawable drawableBox;
    private Drawable drawableEmptyBox;
    private Position position = new Position();

    private GameObjectType got = GameObjectType.BOX;

    public EditorButton(Context context, int row, int column) {
        super(context);
        this.context = context;
        drawableBox = ContextCompat.getDrawable(context, R.drawable.box);
        drawableEmptyBox = ContextCompat.getDrawable(context, R.drawable.empty);
        position.x = row;
        position.y = column;

        this.setBackgroundDrawable(drawableEmptyBox);
       // this.setBackgroundResource(R.drawable.empty)

        final Context con = context;
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checked = !checked;
                changeLayout();
            }
        });

        this.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                createDialog();
                return true;
            }
        });
    }

    private void createDialog() {
        final EditorDialog editorDialog = new EditorDialog(context);
        editorDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                changeType(editorDialog.getChosenObject());
            }
        });
    }

    private void changeType(int chosenObjectId) {
        switch (chosenObjectId) {
            case R.id.heartIb:
                got = GameObjectType.HEART;
                break;
            case R.id.houseIb:
                got = GameObjectType.HOUSE;
                break;
            case R.id.playerIb:
                got = GameObjectType.PLAYER;
                break;
            default:
                got = GameObjectType.BOX;
                break;

        }
        Drawable temp = ContextCompat.getDrawable(context, got.drawableId);
        this.setBackgroundDrawable(temp);

    }


    private void changeLayout() {
        if (checked) {
            setBackgroundDrawable(drawableBox);
        } else {
            setBackgroundDrawable(drawableEmptyBox);
        }
    }

    public boolean isChecked() {
        return checked;
    }

    public Position getPosition() {
        return position;
    }

    public GameObjectType getGot() {
        return got;
    }
}

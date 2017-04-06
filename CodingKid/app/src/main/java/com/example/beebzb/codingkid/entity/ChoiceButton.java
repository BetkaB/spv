package com.example.beebzb.codingkid.entity;

import android.content.Context;
import android.widget.Button;

import com.example.beebzb.codingkid.R;

public class ChoiceButton extends Button {
    public enum Type {
            UNLOCKED(R.drawable.button_unlocked),
            CURRENT(R.drawable.button_current),
            LOCKED(R.drawable.button_locked);

            private final int drawableId;

            Type(int drawableId) {
                this.drawableId = drawableId;
            }
        }

    private Type type = Type.LOCKED;
    private int id;


    public ChoiceButton(Context context, int id) {
        super(context);
        this.id = id;
        this.setText(String.valueOf(id+1));
    }

    public void setType(Type type) {
        this.type = type;
        this.setBackgroundResource(type.drawableId);
    }

    public Type getType() {
        return type;
    }

    @Override
    public int getId() {
        return id;
    }
}

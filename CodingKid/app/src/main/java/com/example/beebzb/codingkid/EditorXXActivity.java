package com.example.beebzb.codingkid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.beebzb.codingkid.entity.EditorButton;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.entity.Position;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditorXXActivity extends AppCompatActivity {

    @BindView(R.id.grid)
    GridLayout grid;

    private boolean onFirstWindowMeasured = true;

    private ArrayList<EditorButton> buttons = new ArrayList<>();

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, EditorXXActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_xx);
        ButterKnife.bind(this);


    }

    private void initGrid() {
        Toast.makeText(this, "initGrid",Toast.LENGTH_SHORT).show();

        final int rows = 8;
        final int columns = 15;

        int partHeight = grid.getHeight() / rows;
        int partWidth = grid.getWidth() / columns;

        EditorButton ib;
        for (int i = 0;  i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ib = new EditorButton(this, i, j);
                GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                param.height = partHeight;
                param.width = partWidth;
                param.setGravity(Gravity.CENTER);
                param.columnSpec = GridLayout.spec(j);
                param.rowSpec = GridLayout.spec(i);
                ib.setLayoutParams(param);
                grid.addView(ib);
                buttons.add(ib);
            }

        }
    }

    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        // the height will be set at this point

        if (onFirstWindowMeasured){
            initGrid();
            onFirstWindowMeasured = false;
        }
    }

    // call this method when saving level
    private Level getLevel(){

        parseObjectsFromGameSurface();
        return null;
    }

    private void parseObjectsFromGameSurface() {
        ArrayList<Position> boxPositions = new ArrayList<>();

        for (EditorButton eb : buttons){

        }
    }


}

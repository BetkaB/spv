package com.example.beebzb.codingkid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.beebzb.codingkid.entity.EditorButton;
import com.example.beebzb.codingkid.entity.GameConstants;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.entity.Position;
import com.example.beebzb.codingkid.module_preferences.Preferences;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditorActivity extends AppCompatActivity {
    @BindView(R.id.inputName)
    EditText inputLevelName;

    @BindView(R.id.inputHearts)
    EditText inputHearts;

    @BindView(R.id.inputCommands)
    EditText inputCommands;

    @BindView(R.id.grid)
    GridLayout grid;

    @Inject
    Preferences preferences;

    private boolean onFirstWindowMeasured = true;

    private ArrayList<EditorButton> buttons = new ArrayList<>();

    private Level level;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, EditorActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        ButterKnife.bind(this);
        ((MainApplication) getApplication()).getComponent().injectEditorActivity(this);
        hideSoftKeyboard();
        init();
    }

    private void init() {
        level = new Level();
    }

    private void initGrid() {
        int partHeight = grid.getHeight() / GameConstants.rows;
        int partWidth = grid.getWidth() / GameConstants.columns;

        EditorButton ib;
        for (int i = 0;  i < GameConstants.rows; i++) {
            for (int j = 0; j < GameConstants.columns; j++) {
                ib = new EditorButton(this, j, i);
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

    private Level getLevel(){
        parseObjectsFromGameSurface();
        if (isInputFieldEmpty(inputLevelName)){
            level.setName(preferences.getUserName() + " level " + preferences.getUserLevelCount());
        }
        else {
            level.setName(inputLevelName.getText().toString());
        }
        if (!isInputFieldEmpty(inputCommands)){
            level.setCommands(Integer.parseInt(inputCommands.getText().toString()));
        }
        if (!isInputFieldEmpty(inputHearts)){
            level.setHearts(Integer.parseInt(inputHearts.getText().toString()));
        }
        return level;
    }

    private boolean isInputFieldEmpty(EditText inputField){
        return inputField.getText().toString().trim().length() == 0;
    }

    private void parseObjectsFromGameSurface() {
        ArrayList<Position> boxPositions = new ArrayList<>();
        ArrayList<Position> heartsPositions = new ArrayList<>();
        Position startPosition = null;
        Position housePosition = null;

        for (EditorButton eb : buttons){
            if (eb.isChecked()){
                switch (eb.getGot()){
                    case HOUSE:
                        housePosition = eb.getPosition();
                        boxPositions.add(eb.getPosition());
                        break;
                    case PLAYER:
                        startPosition = eb.getPosition();
                        boxPositions.add(eb.getPosition());
                        break;
                    case HEART:
                        heartsPositions.add(eb.getPosition());
                        boxPositions.add(eb.getPosition());
                        break;
                    default:
                        boxPositions.add(eb.getPosition());
                        break;
                }
            }
        }

        level.setStartPosition(startPosition);
        level.setHousePosition(housePosition);
        level.setHeartsPositions(heartsPositions);
        level.setBoxPositions(boxPositions);
    }

    @OnClick(R.id.button_save)
    public void saveLevel(){
        Level createdLevel = getLevel();
        if (createdLevel.isValid()){
            preferences.saveCustomLevel(Utils.getLevelInString(createdLevel));
            preferences.incrementUserLevelCount();
            finish();
            Utils.shortToast(this, "Level bol uložený");
        }
        else {
            Utils.shortToast(this, "Nemožno uložiť level, chýba domček alebo panáčik");
        }
    }

    private void hideSoftKeyboard() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    /**
     * Shows the soft keyboard
     */
    @OnClick ({R.id.inputHearts, R.id.inputCommands, R.id.inputName})
    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }
}
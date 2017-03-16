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
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.beebzb.codingkid.entity.EditorButton;
import com.example.beebzb.codingkid.entity.GameConstants;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.entity.Position;
import com.example.beebzb.codingkid.module_preferences.Preferences;

import java.util.ArrayList;
import java.util.Set;

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

    @BindView(R.id.button_save)
    Button buttonSave;

    @Inject
    Preferences preferences;

    private static final String TAG = "EditorActivity";

    private boolean onFirstWindowMeasured = true;

    private EditorButton[][] buttons = new EditorButton[GameConstants.rows][GameConstants.columns];

    private Level level;

    private static Level levelToEdit;

    public static void startActivity(Context context) {
        levelToEdit = null;
        Intent intent = new Intent(context, EditorActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Level level) {
        Log.d(TAG, "start Activity with level");
        Intent intent = new Intent(context, EditorActivity.class);
        levelToEdit = level;
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
        if (levelToEdit == null) {
            level = new Level();
            buttonSave.setText(R.string.editor_activity_button_save);
        } else {
            Log.d(TAG, "level to edit: " + levelToEdit.toString());
            level = levelToEdit;
            buttonSave.setText(R.string.editor_activity_button_update);
        }
    }

    private void initGrid() {
        int partHeight = grid.getHeight() / GameConstants.rows;
        int partWidth = grid.getWidth() / GameConstants.columns;

        EditorButton ib;
        for (int i = 0; i < GameConstants.rows; i++) {
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
                buttons[i][j] = ib;
            }
        }

        if (levelToEdit != null) {
            initSurface(levelToEdit);
        }
    }

    private void initSurface(Level level) {
        Log.i(TAG, "init surface:" + level.toString());
        inputLevelName.setText(level.getName());
        inputCommands.setText(String.valueOf(level.getCommands()));
        inputHearts.setText(String.valueOf(level.getHearts()));
        ArrayList<Position> boxPositions = level.getBoxPositions();
        for (Position boxPos : boxPositions) {
            buttons[boxPos.y][boxPos.x].setGot(EditorButton.GameObjectType.BOX);
        }
        ArrayList<Position> heartPositions = level.getHeartsPositions();
        for (Position heartPos : heartPositions) {
            buttons[heartPos.y][heartPos.x].setGot(EditorButton.GameObjectType.HEART);
        }

        ArrayList<Position> housesPositions = level.getHousesPositions();
        for (Position housePos : housesPositions) {
            buttons[housePos.y][housePos.x].setGot(EditorButton.GameObjectType.HOUSE);
        }
        Position startPos = level.getStartPosition();
        buttons[startPos.y][startPos.x].setGot(EditorButton.GameObjectType.PLAYER);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // the height will be set at this point
        if (onFirstWindowMeasured) {
            initGrid();
            onFirstWindowMeasured = false;
        }
    }

    private Level getLevel() {
        parseObjectsFromGameSurface();
        if (isInputFieldEmpty(inputLevelName)) {
            String defaultName = getResources().getString(R.string.editor_activity_level_default);
            level.setName(preferences.getUserName() + defaultName + preferences.getUserLevelCount());
        } else {
            level.setName(inputLevelName.getText().toString());
        }
        if (!isInputFieldEmpty(inputCommands)) {
            level.setCommands(Integer.parseInt(inputCommands.getText().toString()));
        }
        if (!isInputFieldEmpty(inputHearts)) {
            level.setHearts(Integer.parseInt(inputHearts.getText().toString()));
        }
        return level;
    }

    private boolean isInputFieldEmpty(EditText inputField) {
        return inputField.getText().toString().trim().length() == 0;
    }

    private void parseObjectsFromGameSurface() {
        ArrayList<Position> boxPositions = new ArrayList<>();
        ArrayList<Position> heartsPositions = new ArrayList<>();
        ArrayList<Position> housesPositions = new ArrayList<>();
        Position startPosition = null;

        for (EditorButton[] rowButton : buttons) {
            for (EditorButton eb : rowButton) {
                if (eb.isChecked()) {
                    switch (eb.getGot()) {
                        case HOUSE:
                            housesPositions.add(eb.getPosition());
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
        }

        level.setStartPosition(startPosition);
        level.setHousesPositions(housesPositions);
        level.setHeartsPositions(heartsPositions);
        level.setBoxPositions(boxPositions);
    }

    @OnClick(R.id.button_save)
    public void saveLevel() {
        Level createdLevel = getLevel();
        if (createdLevel.isValid()) {
            if (levelToEdit == null) {
                createdLevel.setId(preferences.getLevelId());
                preferences.incrementLevelId();
                preferences.saveCustomLevel(Utils.getLevelInString(createdLevel));
                preferences.incrementUserLevelCount();
            } else {
                // removing current level from custom levels
                int updatedLevelId = levelToEdit.getId();
                Set<String> customLevels = preferences.getCustomLevels();
                for (String levelInString : customLevels) {
                    Level savedLevel = Utils.stringToLevel(levelInString);
                    if (savedLevel.getId() == updatedLevelId) {
                        customLevels.remove(levelInString);
                        return;
                    }
                }
                createdLevel.setId(updatedLevelId);
                customLevels.add(Utils.getLevelInString(createdLevel));
                preferences.setCustomLevels(customLevels);
            }

            finish();
            Utils.shortToast(this, R.string.editor_activity_level_was_saved);
        } else {
            Utils.shortToast(this, R.string.editor_activity_cannot_be_saved);
        }
    }

    private void hideSoftKeyboard() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    /**
     * Shows the soft keyboard
     */
    @OnClick({R.id.inputHearts, R.id.inputCommands, R.id.inputName})
    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        levelToEdit = null;
    }
}
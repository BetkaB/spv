package com.example.beebzb.codingkid.screens.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beebzb.codingkid.MainApplication;
import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.Utils;
import com.example.beebzb.codingkid.entity.Command;
import com.example.beebzb.codingkid.entity.CommandType;
import com.example.beebzb.codingkid.entity.DefaultLevels;
import com.example.beebzb.codingkid.entity.GameConstants;
import com.example.beebzb.codingkid.entity.Interpreter;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.entity.MyActivity;
import com.example.beebzb.codingkid.module_preferences.MySharedPreferences;
import com.example.beebzb.codingkid.screens.main.LevelChoiceFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends MyActivity implements CommandAdapter.AdapterCallbacks, GameGrid.GameCallback, AfterWinDialog.AfterWinDialogCallback {

    @Inject
    MySharedPreferences mPreferences;

    @BindView(R.id.code_list_view)
    ListView codeListView;

    @BindView(R.id.label_remaining_commands)
    TextView remainingCommandsLabel;

    @BindView(R.id.label_remaining_hearts)
    TextView remainingHeartsLabel;

    @BindView(R.id.button_play)
    Button playButton;

    GameGrid gameGrid;

    private Level level;

    private enum ButtonMode {PLAY, RESET}

    private Toast runOutOfCommandsToast;

    private int remainingCommands;

    private ArrayList<Command> mCommandTypes;
    private CommandAdapter mCommandAdapter;

    private ButtonMode buttonMode = ButtonMode.PLAY;

    public static Level levelFromMainActivity;

    private static final String TAG = "GameActivity";

    private Interpreter mInterpreter;

    public static void startActivity(Context context, Level level) {
        Intent intent = new Intent(context, GameActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        levelFromMainActivity = level;
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        ((MainApplication) getApplication()).getComponent().injectGameActivity(this);

        if (levelFromMainActivity != null) {
            Log.d(LevelChoiceFragment.TAG, "onCreate level: " + levelFromMainActivity.getId());
            initNewGame(levelFromMainActivity);
        } else {
            Log.e(TAG, "Level is null");
        }

    }

    private void init() {
        mCommandTypes = new ArrayList<Command>();
        mCommandAdapter = new CommandAdapter(this, mCommandTypes, this);
        codeListView.setAdapter(mCommandAdapter);

        gameGrid = (GameGrid) findViewById(R.id.canvas);
        if (gameGrid != null) {
            gameGrid.setLevel(level);
        }

        remainingCommands = level.getCommands();
        setRemainingCommandsLabel(remainingCommands);
        remainingHeartsLabel.setText(String.valueOf(level.getHearts()));

    }

    private void setRemainingCommandsLabel(int remainingCommands) {
        remainingCommandsLabel.setText(String.valueOf(remainingCommands));
    }

    @OnClick(R.id.button_loop_start)
    public void loopStart() {
        if (decreasedRemainingCommands()) {
            mCommandTypes.add(new Command(CommandType.LOOP_START));
            mCommandAdapter.setData(mCommandTypes);
        }
    }

    @OnClick(R.id.button_loop_end)
    public void loopEnd() {
        if (decreasedRemainingCommands()) {
            mCommandTypes.add(new Command(CommandType.LOOP_END));
            mCommandAdapter.setData(mCommandTypes);
        }
    }

    @OnClick(R.id.button_left)
    public void commandLeft() {
        if (decreasedRemainingCommands()) {
            mCommandTypes.add(new Command(CommandType.LEFT));
            mCommandAdapter.setData(mCommandTypes);
        }
    }

    @OnClick(R.id.button_down)
    public void commandDown() {
        if (decreasedRemainingCommands()) {
            mCommandTypes.add(new Command(CommandType.DOWN));
            mCommandAdapter.setData(mCommandTypes);
        }
    }

    @OnClick(R.id.button_up)
    public void commandUp() {
        if (decreasedRemainingCommands()) {
            mCommandTypes.add(new Command(CommandType.UP));
            mCommandAdapter.setData(mCommandTypes);
        }
    }

    @OnClick(R.id.button_right)
    public void commandRight() {
        if (decreasedRemainingCommands()) {
            mCommandTypes.add(new Command(CommandType.RIGHT));
            mCommandAdapter.setData(mCommandTypes);
        }
    }

    @OnClick(R.id.button_play)
    public void play() {
        if (buttonMode == ButtonMode.PLAY) {
            if (mCommandTypes.size() > 0) {
                if (isValidCode()) {
                    buttonMode = ButtonMode.RESET;
                    playButton.setEnabled(false);
                    mInterpreter = new Interpreter(mCommandTypes);
                    gameGrid.startMoving(mInterpreter.getResultCommandTypes(), this);
                } else {
                    Utils.longToast(this, R.string.game_activity_toast_invalid_code);
                }
            }
        } else {
            gameGrid.reset();
            buttonMode = ButtonMode.PLAY;
            playButton.setEnabled(true);
            playButton.setText(R.string.game_activity_button_play);
            remainingHeartsLabel.setText(String.valueOf(level.getHearts()));
        }
    }

    private boolean isValidCode() {
        int loopStarts = 0;
        int loopEnds = 0;
        for (Command command : mCommandTypes) {
            if (command.getCommandType() == CommandType.LOOP_START) {
                loopStarts++;
            } else if (command.getCommandType() == CommandType.LOOP_END) {
                loopEnds++;
            }
        }
        return loopStarts == loopEnds && mCommandTypes.size() > 0;
    }

    @Override
    public void onCommandCanceled(int position) {
        mCommandTypes.remove(position);
        mCommandAdapter.setData(mCommandTypes);
        increaseRemainingCommands();
    }

    @Override
    public void onLoopIterationChange(int position, int newValue) {
        mCommandTypes.get(position).setCount(newValue);
        mCommandAdapter.setData(mCommandTypes);
    }

    private boolean decreasedRemainingCommands() {
        if (remainingCommands > 0) {
            remainingCommands--;
            setRemainingCommandsLabel(remainingCommands);
            return true;
        } else {
            if (runOutOfCommandsToast == null || !runOutOfCommandsToast.getView().isShown()) {
                runOutOfCommandsToast = Toast.makeText(this, getString(R.string.game_activity_toast_run_out_of_commands), Toast.LENGTH_SHORT);
                runOutOfCommandsToast.show();
            }
            return false;
        }
    }

    private void increaseRemainingCommands() {
        remainingCommands++;
        setRemainingCommandsLabel(remainingCommands);
    }

    @Override
    public void onLastMove() {
        playButton.setText(R.string.game_activity_button_reset);
        playButton.setEnabled(true);
    }

    @Override
    public void onHeartGathered(int gatheredHearts) {
        if (gatheredHearts <= level.getHearts()) {
            int remainHearts = level.getHearts() - gatheredHearts;
            remainingHeartsLabel.setText(String.valueOf(remainHearts));
        }
    }

    @Override
    public void onLost() {
        playButton.setText(R.string.game_activity_button_reset);
        playButton.setEnabled(true);
    }

    @Override
    public void onWin() {
        playButton.setText(R.string.game_activity_button_reset);
        playButton.setEnabled(true);
        int levelId = this.level.getId();
        Log.d(LevelChoiceFragment.TAG, "onWin levelId " + levelId);
        Log.d(LevelChoiceFragment.TAG, "highest " + mPreferences.getHighestLevel());
        Log.d(LevelChoiceFragment.TAG, "default levels " + GameConstants.DEFAULT_LEVELS_COUNT);

        if (levelId < GameConstants.DEFAULT_LEVELS_COUNT && levelId >= mPreferences.getHighestLevel()) {
            int highestLevel = levelId + 1;
            mPreferences.setHighestLevel(highestLevel);
            new AfterWinDialog(this, this, highestLevel).show();
        }
    }

    @OnClick({R.id.button_loop_end, R.id.button_loop_start, R.id.button_down, R.id.button_up, R.id.button_left, R.id.button_right})
    public void scrollMyListViewToBottom() {
        codeListView.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                codeListView.setSelection(mCommandAdapter.getCount() - 1);
            }
        });
    }

    @Override
    public void onActionButtonClicked(int nextLevelId) {
        if (nextLevelId < DefaultLevels.DEFAULT_LEVELS.length) {
            finish();
            GameActivity.startActivity(this, DefaultLevels.DEFAULT_LEVELS[nextLevelId]);
        } else {
            finish();
        }
    }

    private void initNewGame(Level level) {
        this.level = level;
        init();
    }

}
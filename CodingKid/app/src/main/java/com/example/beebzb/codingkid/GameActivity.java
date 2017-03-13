package com.example.beebzb.codingkid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beebzb.codingkid.entity.Command;
import com.example.beebzb.codingkid.entity.CommandAdapter;
import com.example.beebzb.codingkid.entity.CommandType;
import com.example.beebzb.codingkid.entity.GameView;
import com.example.beebzb.codingkid.entity.Interpreter;
import com.example.beebzb.codingkid.entity.Level;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends AppCompatActivity implements CommandAdapter.AdapterCallbacks {

    @BindView(R.id.code_list_view)
    ListView codeListView;

    @BindView(R.id.label_remaining_commands)
    TextView remainingCommandsLabel;

    @BindView(R.id.label_remaining_hearts)
    TextView remainingHeartsLabel;

    GameView gameView;

    GameGrid gameGrid;

    private Level level;

    private Toast runOutOfCommandsToast;

    private int remainingCommands;

    private ArrayList<Command> mCommandTypes;
    private CommandAdapter mCommandAdapter;

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


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        if (levelFromMainActivity != null) {
            this.level = levelFromMainActivity;
            init();
        } else {
            Log.e(TAG, "Level is null");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
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
        if (isValidCode()){
            mInterpreter = new Interpreter(mCommandTypes);
            gameGrid.startMoving(mInterpreter.getResultCommandTypes());
        }
        else {
            Utils.longToast(this,R.string.game_activity_toast_invalid_code)
            ;
        }
    }

    private boolean isValidCode(){
        int loopStarts = 0;
        int loopEnds=0;
        for (Command command : mCommandTypes){
            if (command.getmCommandType() == CommandType.LOOP_START){
                loopStarts++;
            }
            else if (command.getmCommandType() == CommandType.LOOP_END){
                loopEnds++;
            }
        }
        return loopStarts == loopEnds;
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

}

package com.example.beebzb.codingkid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.beebzb.codingkid.entity.Command;
import com.example.beebzb.codingkid.entity.CommandAdapter;
import com.example.beebzb.codingkid.entity.CommandType;
import com.example.beebzb.codingkid.entity.GameView;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.entity.Position;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.beebzb.codingkid.LevelChoiceFragment.KEY_EXTRA_LEVEL;

public class GameActivity extends AppCompatActivity implements CommandAdapter.AdapterCallbacks {

    @BindView(R.id.code_list_view)
    ListView codeListView;

    @BindView(R.id.label_remaining_commands)
    TextView remainingCommandsLabel;

    @BindView(R.id.label_remaining_hearts)
    TextView remainingHeartsLabel;

    GameView gameView;

    private Level level;

    private ArrayList<Command> mCommandTypes;
    private CommandAdapter mCommandAdapter;

    // TODO remove
    public static Level level2;

    public static void startActivity(Context context, Level level) {
        Intent intent = new Intent(context, GameActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //intent.putExtra(KEY_EXTRA_LEVEL, level);
        }
        context.startActivity(intent);
        level2 = level;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        ButterKnife.bind(this);
        ((MainApplication) getApplication()).getComponent().injectGameActivity(this);


        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // TODO level set up
        ArrayList<Position> heartsPosition = new ArrayList<Position>(){};
        heartsPosition.add(new Position(4,1)); heartsPosition.add(new Position(3,1));
        ArrayList<Position> boxPosition = new ArrayList<Position>(){};
        boxPosition.add(new Position(1,1)); boxPosition.add(new Position(2,1));
        boxPosition.add(new Position(3,1)); boxPosition.add(new Position(4,1));
        boxPosition.add(new Position(4,2)); boxPosition.add(new Position(3,2));

        this.level = new Level(4,2, new Position(4,2), new Position(1,1),heartsPosition, boxPosition, "Level 1", "Betka" );
       // this.level = getLevelFromExtra(savedInstanceState);
        this.level = level2;
        Log.e("EDITOR FROM EXTRA",level.toString());
        init();

    }

    private Level getLevelFromExtra(Bundle savedInstanceState){
        String levelFromExtra;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                levelFromExtra= null;
            } else {
                levelFromExtra= extras.getString(KEY_EXTRA_LEVEL);
            }
        } else {
            levelFromExtra= (String) savedInstanceState.getSerializable(KEY_EXTRA_LEVEL);
        }
        return Utils.stringToLevel(levelFromExtra);
    }

    private void init() {
        mCommandTypes = new ArrayList<Command>();
        mCommandAdapter = new CommandAdapter(this, mCommandTypes, this);
        codeListView.setAdapter(mCommandAdapter);
        gameView = (GameView) findViewById(R.id.canvas);
        gameView.init(this);
        gameView.setLevel(level);

        remainingCommandsLabel.setText(String.valueOf(level.getCommands()));
        remainingHeartsLabel.setText(String.valueOf(level.getHearts()));

    }

    @OnClick(R.id.button_loop_start)
    public void loopStart() {
        mCommandTypes.add(new Command(CommandType.LOOP_START));
        mCommandAdapter.setData(mCommandTypes);
    }

    @OnClick(R.id.button_loop_end)
    public void loopEnd() {
        mCommandTypes.add(new Command(CommandType.LOOP_END));
        mCommandAdapter.setData(mCommandTypes);
    }

    @OnClick(R.id.button_left)
    public void commandLeft() {
        mCommandTypes.add(new Command(CommandType.LEFT));
        mCommandAdapter.setData(mCommandTypes);
    }

    @OnClick(R.id.button_down)
    public void commandDown() {
        mCommandTypes.add(new Command(CommandType.DOWN));
        mCommandAdapter.setData(mCommandTypes);
    }

    @OnClick(R.id.button_up)
    public void commandUp() {
        mCommandTypes.add(new Command(CommandType.UP));
        mCommandAdapter.setData(mCommandTypes);
    }

    @OnClick(R.id.button_right)
    public void commandRight() {
        mCommandTypes.add(new Command(CommandType.RIGHT));
        mCommandAdapter.setData(mCommandTypes);
    }

    @OnClick(R.id.button_play)
    public void play() {

    }

    @Override
    public void onCommandCanceled(int position) {
        mCommandTypes.remove(position);
        mCommandAdapter.setData(mCommandTypes);
    }

    @Override
    public void onLoopIterationChange(int position, int newValue) {
        mCommandTypes.get(position).setCount(newValue);
        mCommandAdapter.setData(mCommandTypes);
    }

}

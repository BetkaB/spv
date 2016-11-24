package com.example.beebzb.codingkid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends AppCompatActivity implements CommandAdapter.AdapterCallbacks{

    @BindView(R.id.code_list_view)
    ListView codeListView;

    private ArrayList<Command> mCommandTypes;
    private CommandAdapter mCommandAdapter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, GameActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        init();

    }

    private void init(){
        mCommandTypes = new ArrayList<Command>();
        mCommandAdapter = new CommandAdapter(this, mCommandTypes, this);
        codeListView.setAdapter(mCommandAdapter);
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

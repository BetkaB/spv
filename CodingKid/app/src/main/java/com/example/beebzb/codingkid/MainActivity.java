package com.example.beebzb.codingkid;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beebzb.codingkid.module_preferences.Preferences;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.welcome)
    TextView title;

    @Inject
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MainApplication) getApplication()).getComponent().injectMainActivity(this);
        init();

    }

    private void init() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.buttons_layout,new LevelChoiceFragment(), LevelChoiceFragment.TAG)
                .disallowAddToBackStack()
                .commit();
    }

    @OnClick(R.id.play_button)
    public void openLevelsActivity() {
        title.setAllCaps(true);
        title.setText(preferences.getLevel(5));
    }

    @OnClick(R.id.editor_button)
    public void openEditorActivity() {
        title.setAllCaps(false);
    }

    @OnClick(R.id.settings_button)
    public void openSettingsActivity() {
        EditorXXActivity.startActivity(this);

    }

    @OnClick(R.id.game_button)
    public void openGameActivity() {
        GameActivity.startActivity(this);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Toast.makeText(this,"MENU CREATED",Toast.LENGTH_SHORT).show();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu.getItem(0).setVisible(true);
        return super.onCreateOptionsMenu(menu);

    }
}
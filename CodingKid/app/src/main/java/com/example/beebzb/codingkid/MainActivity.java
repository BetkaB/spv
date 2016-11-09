package com.example.beebzb.codingkid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.welcome)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick (R.id.play_button)
    public void openLevelsActivity(){
    title.setAllCaps(true);
    }

    @OnClick (R.id.editor_button)
    public void openEditorActivity(){
    title.setAllCaps(false);
    }

    @OnClick (R.id.settings_button)
    public void openSettingsActivity(){

    }
}

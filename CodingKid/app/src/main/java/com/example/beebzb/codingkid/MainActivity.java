package com.example.beebzb.codingkid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick (R.id.play_button)
    public void openLevelsActivity(){

    }

    @OnClick (R.id.editor_button)
    public void openEditorActivity(){

    }

    @OnClick (R.id.settings_button)
    public void openSettingsActivity(){

    }
}

package com.example.beebzb.codingkid;

//import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditorActivity extends AppCompatActivity {
    @BindView(R.id.levelName)
    EditText inputLevelName;

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
        disableKeyboard();
    }

    public void save(View v){
        levelName();
    }


    public void levelName(){
        Toast.makeText(getApplicationContext(), inputLevelName.getText(), Toast.LENGTH_SHORT).show();
    }

    private void disableKeyboard() {
        // TODO text
    }
}



package com.example.beebzb.codingkid;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.beebzb.codingkid.entity.ChoiceButton;
import com.example.beebzb.codingkid.module_preferences.Preferences;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LevelChoiceFragment extends Fragment {

    private ArrayList<ChoiceButton> buttons;
    public static String TAG = "LevelChoice";

    @BindView(R.id.level_choices_layout)
    LinearLayout layout;

    @Inject
    Preferences preferences;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((MainApplication) getActivity().getApplication()).getComponent().injectLevelChoiceFragment(this);

        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_level_choice, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init();
    }

    private void init() {
        // TODO remove setting highest level
        preferences.setHighestLevel(4);
        buttons = new ArrayList<>();
        final int countButtons = 10;
        Toast.makeText(getContext(), "init Buttons", Toast.LENGTH_SHORT).show();
        ChoiceButton button;
        int highestLevel = preferences.getHighestLevel();
        for (int i = 0; i < countButtons; i++) {
            button = new ChoiceButton(getContext(), i + 1);
            TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, 1f);
            button.setLayoutParams(params);
            button.setType(getType(highestLevel,i));
            layout.addView(button);
            buttons.add(button);
        }
    }

    private ChoiceButton.Type getType(int highest, int i ){
        if (i > highest){
            return ChoiceButton.Type.LOCKED;
        }
        else if (i < highest){
            return ChoiceButton.Type.UNLOCKED;
        }
        return ChoiceButton.Type.CURRENT;
    }

}

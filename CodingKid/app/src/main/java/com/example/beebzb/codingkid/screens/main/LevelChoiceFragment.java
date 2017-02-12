package com.example.beebzb.codingkid.screens.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.beebzb.codingkid.GameActivity;
import com.example.beebzb.codingkid.MainApplication;
import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.Utils;
import com.example.beebzb.codingkid.entity.ChoiceButton;
import com.example.beebzb.codingkid.module_preferences.Preferences;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LevelChoiceFragment extends Fragment {

    public static String KEY_EXTRA_LEVEL = "KEY_EXTRA_LEVEL";

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
        initListeners();
    }

    private void initListeners() {
        for (final ChoiceButton button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button.getType() != ChoiceButton.Type.LOCKED) {
                        openGame(button.getId());
                    }
                }
            });
        }
    }

    private void openGame(int id) {
        // TODO get level based on id
        String levelInString = preferences.getLevel1();
        GameActivity.startActivity(getContext(), Utils.stringToLevel(levelInString));

    }

    private void init() {
        // TODO remove setting highest level
        preferences.setHighestLevel(4);
        buttons = new ArrayList<>();
        final int countButtons = 10;
        ChoiceButton button;
        int highestLevel = preferences.getHighestLevel();
        for (int i = 0; i < countButtons; i++) {
            button = new ChoiceButton(getContext(), i + 1);
            TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, 1f);
            button.setLayoutParams(params);
            button.setType(getType(highestLevel, i));
            layout.addView(button);
            buttons.add(button);
        }
    }

    private ChoiceButton.Type getType(int highest, int i) {
        if (i > highest) {
            return ChoiceButton.Type.LOCKED;
        } else if (i < highest) {
            return ChoiceButton.Type.UNLOCKED;
        }
        return ChoiceButton.Type.CURRENT;
    }

}

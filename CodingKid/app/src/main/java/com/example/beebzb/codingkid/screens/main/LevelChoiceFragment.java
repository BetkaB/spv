package com.example.beebzb.codingkid.screens.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.beebzb.codingkid.GameActivity;
import com.example.beebzb.codingkid.MainApplication;
import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.entity.ChoiceButton;
import com.example.beebzb.codingkid.entity.DefaultLevels;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LevelChoiceFragment extends Fragment {

    private ArrayList<ChoiceButton> buttons;
    public static String TAG = "LevelChoice";

    @BindView(R.id.horizontalScrollView1)
    HorizontalScrollView horizontalScrollView;

    @BindView(R.id.shapeLayout)
    LinearLayout shapeLayout;

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

    // TODO  checking highest won level ? in onResume


    private void openGame(int id) {
        //TODO remove
        preferences.setHighestLevel(14);
        Level level = DefaultLevels.DEFAULT_LEVELS[id];
        GameActivity.startActivity(getContext(), level);
    }

    private void init() {
        buttons = new ArrayList<>();
        final int countButtons = 20;
        ChoiceButton button;
        int width = 200;
        final int y = 0;
        int highestLevel = preferences.getHighestLevel();
        final int x = width * highestLevel;

        for (int i = 0; i < countButtons; i++) {
            button = new ChoiceButton(getContext(), i);
            TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableLayout.LayoutParams.WRAP_CONTENT, 1f);
            button.setLayoutParams(params);
            ChoiceButton.Type type = getType(highestLevel, i);
            button.setType(type);
            params.width = width;
            shapeLayout.addView(button);
            buttons.add(button);
        }

        horizontalScrollView.post(new Runnable() {
            @Override
            public void run() {
                horizontalScrollView.scrollTo(x, y);
            }
        });

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
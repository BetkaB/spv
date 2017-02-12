package com.example.beebzb.codingkid.screens.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.beebzb.codingkid.EditorActivity;
import com.example.beebzb.codingkid.MainApplication;
import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.Utils;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CustomLevelChoiceFragment extends Fragment implements LevelAdapter.AdapterCallbacks {
    private final String TAG = "CustomLevelsFragment";

    @Inject
    Preferences mPreferences;

    @BindView(R.id.custom_levels_listview)
    ListView customLevelsListView;

    private ArrayList<Level> customLevelData;
    private LevelAdapter levelsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_level_choice, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((MainApplication) getActivity().getApplication()).getComponent().injectCustomLevelChoiceFragment(this);
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.add_new_level_button)
    public void onAddLevelButtonClicked() {
        EditorActivity.startActivity(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init();
    }

    private void init() {
        Log.e(TAG, "init");
        customLevelData = Utils.getLevels(mPreferences);
        Log.e(TAG, "data size: "+ customLevelData.size());
        levelsAdapter = new LevelAdapter(getContext(), customLevelData, this);
        customLevelsListView.setAdapter(levelsAdapter);
    }

    @Override
    public void onLevelDeleted(int position) {
        //  TODO
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }
}
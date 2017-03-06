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
import com.example.beebzb.codingkid.GameActivity;
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
import butterknife.OnItemClick;


public class CustomLevelChoiceFragment extends Fragment implements LevelPickerDialog.LevelPickerDialogCallback {
    private final String TAG = "CustomLevelsFragment";

    @Inject
    Preferences mPreferences;

    @BindView(R.id.custom_levels_listview)
    ListView customLevelsListView;

    private LevelAdapter levelsAdapter;

    ArrayList<Level> customLevelData;

    private Level chosenLevel = null;

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

    @OnItemClick(R.id.custom_levels_listview)
    public void onItemClicked(int position) {
        chosenLevel = levelsAdapter.getItem(position);
        LevelPickerDialog levelPickerDialog = new LevelPickerDialog(getContext(), this);
        levelPickerDialog.show();
    }

    private void init() {
        Log.i(TAG, "init");
        customLevelData = Utils.getLevels(mPreferences);
        Log.i(TAG, "data size: " + customLevelData.size());
        levelsAdapter = new LevelAdapter(getContext(), customLevelData);
        customLevelsListView.setAdapter(levelsAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    @Override
    public void onPlayButtonClicked() {
        if (chosenLevel != null) {
            GameActivity.startActivity(getContext(), chosenLevel);
        }
    }

    @Override
    public void onEditButtonClicked() {
        if (chosenLevel != null) {
            EditorActivity.startActivity(getContext(), chosenLevel);
        }
    }

    @Override
    public void onDeleteButtonClicked() {
        if (chosenLevel != null) {
            levelsAdapter.remove(chosenLevel);
            customLevelData.remove(chosenLevel);
            mPreferences.setCustomLevels(customLevelData);
            levelsAdapter.setData(customLevelData);
        }
    }

    @Override
    public void onShareButtonClicked() {

    }
}
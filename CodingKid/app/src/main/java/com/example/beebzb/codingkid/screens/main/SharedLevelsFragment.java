package com.example.beebzb.codingkid.screens.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.beebzb.codingkid.MainApplication;
import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.ServerTransaction;
import com.example.beebzb.codingkid.Utils;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;
import com.example.beebzb.codingkid.screens.game.GameActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class SharedLevelsFragment extends Fragment implements SharedLevelPickerDialog.SharedLevelPickerDialogCallback {
    private final String TAG = "SharedLevelsFragment";

    @Inject
    Preferences mPreferences;

    @BindView(R.id.shared_levels_listview)
    ListView sharedLevelsListView;

    private LevelAdapter levelsAdapter;

    ArrayList<Level> sharedLevelData = new ArrayList<>();

    private Level chosenLevel = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shared_levels, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((MainApplication) getActivity().getApplication()).getComponent().injectSharedLevelsFragment(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init();
    }

    private void init(){
        sendSharedLevelsRequest();
    }

    @OnItemClick(R.id.shared_levels_listview)
    public void onItemClicked(int position) {
        chosenLevel = levelsAdapter.getItem(position);
        if (mPreferences.isUserStudent()){
            GameActivity.startActivity(getContext(), chosenLevel);
        }
        else {
            SharedLevelPickerDialog levelPickerDialog = new SharedLevelPickerDialog(getContext(), this);
            levelPickerDialog.show();
        }
    }

    private void initLayout() {
        levelsAdapter = new LevelAdapter(getContext(), sharedLevelData);
        sharedLevelsListView.setAdapter(levelsAdapter);
    }

    @OnClick(R.id.update_button)
    public void onUpdateButtonClicked(){

    }

    private void sendSharedLevelsRequest() {
        DatabaseReference ref = ServerTransaction.getReference(mPreferences);

        Log.d(TAG, "ref: " + ref);
        // listener
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String post = postSnapshot.getValue(String.class);
                    Level newLevel = Utils.stringToLevel(post);
                    sharedLevelData.add(newLevel);
                }
                initLayout();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "loadPost: onCancelled", databaseError.toException());
            }
        };
        ref.addValueEventListener(postListener);
    }

    @Override
    public void onPlayButtonClicked() {
        GameActivity.startActivity(getContext(), chosenLevel);
    }

    @Override
    public void onDeleteButtonClicked() {
        //TODO delete remote level
    }
}
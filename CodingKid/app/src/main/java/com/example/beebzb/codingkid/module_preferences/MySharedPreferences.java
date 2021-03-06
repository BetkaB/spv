package com.example.beebzb.codingkid.module_preferences;

import android.content.SharedPreferences;

import com.example.beebzb.codingkid.Utils;
import com.example.beebzb.codingkid.entity.GameConstants;
import com.example.beebzb.codingkid.entity.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MySharedPreferences implements Preferences {

    private final String KEY_HIGHEST_LEVEL = "KEY_HIGHEST_LEVEL";
    private final String KEY_CUSTOM_LEVELS = "KEY_CUSTOM_LEVELS";
    private final String KEY_USER_NAME = "KEY_USER_NAME";
    private final String KEY_USER_LEVEL_COUNT = "KEY_USER_LEVEL_COUNT";
    private final String KEY_USER_LEVEL_ID = "KEY_USER_LEVEL_ID";
    private final String KEY_USER_EMAIL = "KEY_USER_EMAIL";
    private final String KEY_USER_STUDENT = "KEY_USER_STUDENT";
    private final String KEY_TEACHERS_ID = "KEY_TEACHERS_ID";
    private final String KEY_MINE_ID = "KEY_MINE_ID";


    private final SharedPreferences mSharedPreferences;

    private static final String TAG = "MySharedPreferences";

    @Inject
    public MySharedPreferences(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public void setHighestLevel(int id) {
        /*SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.putInt(KEY_HIGHEST_LEVEL, id).apply();
        */
        mSharedPreferences.edit().putInt(KEY_HIGHEST_LEVEL, id).apply();
    }

    @Override
    public int getHighestLevel() {
        return mSharedPreferences.getInt(KEY_HIGHEST_LEVEL, 0);
    }

    @Override
    public void saveCustomLevel(String level) {
        Set<String> allUsersLevels = getCustomLevels();
        allUsersLevels.add(level);
        mSharedPreferences.edit().putStringSet(KEY_CUSTOM_LEVELS, allUsersLevels).apply();
    }

    @Override
    public Set<String> getCustomLevels() {
        return mSharedPreferences.getStringSet(KEY_CUSTOM_LEVELS, new HashSet<String>());
    }

    @Override
    public void setCustomLevels(ArrayList<Level> levels) {
        HashSet<String> newLevels = new HashSet<>();
        for (Level level : levels) {
            newLevels.add(Utils.getLevelInString(level));
        }
        mSharedPreferences.edit().putStringSet(KEY_CUSTOM_LEVELS, newLevels).apply();
    }

    @Override
    public void setCustomLevels(Set<String> newLevels) {
        /*SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.putStringSet(KEY_CUSTOM_LEVELS, newLevels).apply();*/
        mSharedPreferences.edit().putStringSet(KEY_CUSTOM_LEVELS, newLevels).apply();
    }

    @Override
    public void setUserName(String name) {
        mSharedPreferences.edit().putString(KEY_USER_NAME, name).apply();
    }

    @Override
    public String getUserName() {
        return mSharedPreferences.getString(KEY_USER_NAME, "Coding Kid ");
    }

    @Override
    public void incrementUserLevelCount() {
        int currentLevelCount = getUserLevelCount();
        currentLevelCount++;
        mSharedPreferences.edit().putInt(KEY_USER_LEVEL_COUNT, currentLevelCount).apply();
    }

    @Override
    public int getUserLevelCount() {
        return mSharedPreferences.getInt(KEY_USER_LEVEL_COUNT, 1);
    }

    @Override
    public void incrementLevelId() {
        int currentLevelId = getLevelId();
        currentLevelId++;
        mSharedPreferences.edit().putInt(KEY_USER_LEVEL_ID, currentLevelId).apply();
    }

    @Override
    public int getLevelId() {
        return mSharedPreferences.getInt(KEY_USER_LEVEL_ID, GameConstants.DEFAULT_LEVELS_COUNT);
    }

    @Override
    public void setUserEmail(String email) {
        mSharedPreferences.edit().putString(KEY_USER_EMAIL, email).apply();
    }

    @Override
    public String getUserEmail() {
        return mSharedPreferences.getString(KEY_USER_EMAIL, null);
    }

    @Override
    public boolean isUserStudent() {
        return mSharedPreferences.getBoolean(KEY_USER_STUDENT, true);
    }

    @Override
    public void setUserStudent(boolean value) {
        mSharedPreferences.edit().putBoolean(KEY_USER_STUDENT, value).apply();
    }

    @Override
    public void setTeachersId(String teachersId) {
        mSharedPreferences.edit().putString(KEY_TEACHERS_ID, teachersId).apply();
    }

    @Override
    public String getTeachersId() {
        return mSharedPreferences.getString(KEY_TEACHERS_ID, null);
    }

    @Override
    public void setMineId(String mineId) {
        mSharedPreferences.edit().putString(KEY_MINE_ID, mineId).apply();
    }

    @Override
    public String getMineId() {
        return mSharedPreferences.getString(KEY_MINE_ID, null);
    }

}
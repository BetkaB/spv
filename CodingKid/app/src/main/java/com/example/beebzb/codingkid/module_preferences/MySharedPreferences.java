package com.example.beebzb.codingkid.module_preferences;

import android.content.SharedPreferences;

import com.example.beebzb.codingkid.Utils;
import com.example.beebzb.codingkid.entity.Level;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MySharedPreferences implements Preferences {

    private final String KEY_HIGHEST_LEVEL = "KEY_HIGHEST_LEVEL";
    private final String KEY_USERS_LEVELS = "KEY_USERS_LEVELS";

    //TODO refactor - save to database
    private final String KEY_LEVEL_1 = "KEY_LEVEL_1";


    private final SharedPreferences mSharedPreferences;

    @Inject
    public MySharedPreferences(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public void setHighestLevel(int id) {
        mSharedPreferences.edit().putInt(KEY_HIGHEST_LEVEL, id).apply();
    }

    @Override
    public int getHighestLevel() {
        return mSharedPreferences.getInt(KEY_HIGHEST_LEVEL, 0);
    }

    @Override
    public void saveLevelToUsersLevels(String level) {
        Set<String> allUsersLevels = getAllUsersLevels();
        allUsersLevels.add(level);
        mSharedPreferences.edit().putStringSet(KEY_USERS_LEVELS, allUsersLevels).apply();
    }

    @Override
    public Set<String> getAllUsersLevels() {
        return mSharedPreferences.getStringSet(KEY_USERS_LEVELS, new HashSet<String>());
    }

    @Override
    public void setLevel1(Level level) {
        String levelInString = Utils.getLevelInString(level);
        mSharedPreferences.edit().putString(KEY_LEVEL_1,levelInString).apply();
    }

    @Override
    public String getLevel1() {
        return mSharedPreferences.getString(KEY_LEVEL_1, "");
    }

}
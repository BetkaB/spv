package com.example.beebzb.codingkid.module_preferences;

import android.content.SharedPreferences;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MySharedPreferences implements Preferences {

    private final String KEY_LEVELS = "KEY_LEVELS";
    private final String KEY_HIGHEST_LEVEL = "KEY_HIGHEST_LEVEL";


    private final SharedPreferences mSharedPreferences;

    @Inject
    public MySharedPreferences(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public Set<String> getDefaultLevels() {
        return mSharedPreferences.getStringSet(KEY_LEVELS, null);
    }

    @Override
    public void setHighestLevel(int id) {
        mSharedPreferences.edit().putInt(KEY_HIGHEST_LEVEL,id).apply();
    }

    @Override
    public int getHighestLevel() {
        return mSharedPreferences.getInt(KEY_HIGHEST_LEVEL,0);
    }

    @Override
    public void setLevel(int index, String level) {

    }

    @Override
    public String getLevel(int index) {
        return "";
    }
}
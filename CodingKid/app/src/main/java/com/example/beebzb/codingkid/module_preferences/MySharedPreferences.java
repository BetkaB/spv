package com.example.beebzb.codingkid.module_preferences;

import android.content.SharedPreferences;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MySharedPreferences implements Preferences {

    private final String KEY_LEVELS = "KEY_LEVELS";

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
    public void setLevel(int index, String level) {

    }

    @Override
    public String getLevel(int index) {
        return "Hola chicas y chicos!";
    }
}
package com.example.beebzb.codingkid.module_preferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {

    private static final String SHARED_PREFERENCES_FILE = "attendance";

    @Provides
    public Preferences provideSettings(MySharedPreferences preferences) {
        return preferences;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE);
    }
}
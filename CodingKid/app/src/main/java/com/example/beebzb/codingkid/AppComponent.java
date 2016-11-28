package com.example.beebzb.codingkid;


import com.example.beebzb.codingkid.module_preferences.PreferencesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PreferencesModule.class})
public interface AppComponent {
    //injecting actvities and fragments
    void injectMainActivity(MainActivity mainActivity);
}

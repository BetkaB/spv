package com.example.beebzb.codingkid;


import com.example.beebzb.codingkid.module_preferences.PreferencesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PreferencesModule.class})
public interface AppComponent {
    void injectMainActivity(MainActivity mainActivity);

    void injectLevelChoiceFragment(LevelChoiceFragment levelChoiceFragment);

    void injectGameActivity(GameActivity gameActivity);

    void injectEditorActivity(EditorActivity editorActivity);
}

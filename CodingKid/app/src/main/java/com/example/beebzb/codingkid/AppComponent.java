package com.example.beebzb.codingkid;


import com.example.beebzb.codingkid.screens.game.GameActivity;
import com.example.beebzb.codingkid.screens.editor.EditorActivity;
import com.example.beebzb.codingkid.module_preferences.PreferencesModule;
import com.example.beebzb.codingkid.screens.main.CustomLevelChoiceFragment;
import com.example.beebzb.codingkid.screens.main.LevelChoiceFragment;
import com.example.beebzb.codingkid.screens.main.MainActivity;
import com.example.beebzb.codingkid.screens.main.SharedLevelsFragment;
import com.example.beebzb.codingkid.screens.settings.SettingsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PreferencesModule.class})
public interface AppComponent {
    void injectMainActivity(MainActivity mainActivity);

    void injectLevelChoiceFragment(LevelChoiceFragment levelChoiceFragment);

    void injectGameActivity(GameActivity gameActivity);

    void injectEditorActivity(EditorActivity editorActivity);

    void injectCustomLevelChoiceFragment(CustomLevelChoiceFragment customLevelChoiceFragment);

    void injectSettingsActivity(SettingsActivity settingsActivity);

    void injectSharedLevelsFragment(SharedLevelsFragment sharedLevelsFragment);
}

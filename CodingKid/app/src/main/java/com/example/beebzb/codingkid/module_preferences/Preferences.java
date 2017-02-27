package com.example.beebzb.codingkid.module_preferences;


import com.example.beebzb.codingkid.entity.Level;

import java.util.ArrayList;
import java.util.Set;

public interface Preferences {
    void setLevel1(Level level);

    String getLevel1 ();

    void setHighestLevel(int id);

    int getHighestLevel();

    void saveCustomLevel(String string);

    Set<String> getCustomLevels();

    void setCustomLevels(ArrayList<Level> levels);

    void setUserName(String name);

    String getUserName();

    void incrementUserLevelCount();

    int getUserLevelCount();
}

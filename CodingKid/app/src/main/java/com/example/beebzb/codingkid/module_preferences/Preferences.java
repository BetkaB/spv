package com.example.beebzb.codingkid.module_preferences;


import com.example.beebzb.codingkid.entity.Level;

import java.util.ArrayList;
import java.util.Set;

public interface Preferences {

    void setHighestLevel(int id);

    int getHighestLevel();

    void saveCustomLevel(String string);

    Set<String> getCustomLevels();

    void setCustomLevels(ArrayList<Level> levels);

    void setCustomLevels(Set<String> levels);

    void setUserName(String name);

    String getUserName();

    void incrementUserLevelCount();

    int getUserLevelCount();

    void incrementLevelId();

    int getLevelId();

}

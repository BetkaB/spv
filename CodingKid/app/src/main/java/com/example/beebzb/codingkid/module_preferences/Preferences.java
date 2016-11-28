package com.example.beebzb.codingkid.module_preferences;


import java.util.Set;

public interface Preferences {
    void setLevel(int index, String level);

    String getLevel (int index);

    Set<String> getDefaultLevels();

    void setHighestLevel(int id);

    int getHighestLevel();
}

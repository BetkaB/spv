package com.example.beebzb.codingkid;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.Log;
import android.widget.Toast;

import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Set;

public class Utils {
    private static final String TAG = "Utils";
    public static String getLevelInString(Level level) {
        Gson gson = new Gson();
        return gson.toJson(level);
    }

    public static Level stringToLevel(String strLevel) {
        Gson gson = new Gson();
        return gson.fromJson(strLevel, Level.class);
    }

    public static void shortToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void shortToast(Context context, @StringRes int stringId) {
        Toast.makeText(context,context.getString(stringId), Toast.LENGTH_SHORT).show();
    }

    public static ArrayList<Level> getLevels(Preferences preferences) {
        Set<String> savedLevels = preferences.getCustomLevels();
        ArrayList<Level> levels = new ArrayList<>();
        for (String levelRepre : savedLevels) {
            Level newLevel = stringToLevel(levelRepre);
            levels.add(newLevel);
        }
        return levels;
    }
}

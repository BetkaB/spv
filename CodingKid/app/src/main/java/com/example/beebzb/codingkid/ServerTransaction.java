package com.example.beebzb.codingkid;

import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServerTransaction {
    private static final String TAG = "ServerTransaction";

    private static final String FIELD_LEVELS = "levels";

    private static DatabaseReference mDatabase;

    public static void writeData(Level level, String userId) {
        DatabaseReference ref = getReference(userId);
        if (ref != null) {
            String levelRepre = Utils.getLevelInString(level);
            ref.child(level.getName()).setValue(levelRepre);
        }
    }

    public static DatabaseReference getReference(String id) {
        if (id != null) {
            String teacherId = Utils.getChangedStringForFirebase(id);
            mDatabase = FirebaseDatabase.getInstance().getReference();
            return mDatabase.child(FIELD_LEVELS).child(teacherId);
        }
        return null;
    }

    public static void removeLevel(String userId, String levelName){
        DatabaseReference ref = getReference(userId);
        if (ref != null) {
            ref.child(levelName).removeValue();
        }
    }
}

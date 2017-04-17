package com.example.beebzb.codingkid;

import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServerTransaction {
    private static final String TAG = "ServerTransaction";

    private static final String FIELD_LEVELS = "levels";

    private static DatabaseReference mDatabase;

    public static void writeData(Level level, Preferences preferences) {
        DatabaseReference ref = getReference(preferences);
        if (ref != null) {
            String levelRepre = Utils.getLevelInString(level);
            ref.child(level.getName()).setValue(levelRepre);
        }
    }

    public static DatabaseReference getReference(Preferences preferences) {
        String mail = preferences.getUserEmail();
        if (mail != null) {
            String teacherId = Utils.getChangedStringForFirebase(mail);
            mDatabase = FirebaseDatabase.getInstance().getReference();
            return mDatabase.child(FIELD_LEVELS).child(teacherId);
        }
        return null;
    }
}

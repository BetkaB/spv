package com.example.beebzb.codingkid;

import android.util.Log;

import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServerTransaction {
    private static final String TAG = "ServerTransaction";

    private static final String FIELD_LEVELS = "levels";

    private static DatabaseReference mDatabase;

    public static void writeData(Level level, Preferences preferences) {
        DatabaseReference ref = getReference(preferences);
        String levelRepre = Utils.getLevelInString(level);
        ref.child(level.getName()).setValue(levelRepre);
    }

    public static DatabaseReference getReference(Preferences preferences) {
        String teacherId = Utils.getChangedStringForFirebase(preferences.getUserEmail());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        return mDatabase.child(FIELD_LEVELS).child(teacherId);
    }




}

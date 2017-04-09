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

    public static void writeData(Level level) {
        String levelRepre = Utils.getLevelInString(level);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("levels").child("a*bachronikova@gmail*com").child("seriousLevel").setValue(levelRepre);
    }

    public static DatabaseReference getReference(Preferences preferences) {
        String teacherId = Utils.getChangedStringForFirebase("a.bachronikova@gmail.com");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        return mDatabase.child(FIELD_LEVELS).child(teacherId);
    }

    public static void getLevels(Preferences preferences) {
        DatabaseReference ref = getReference(preferences);

        Log.d(TAG, "ref: " + ref);
        // listener
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String post = postSnapshot.getValue(String.class);
                    Log.d(TAG, post);
                    String key = postSnapshot.getKey();
                    if (key.equals("seriousLevel")) {
                        Level newLevel = Utils.stringToLevel(post);
                        Log.d(TAG, "saved level: " + newLevel.toString());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "loadPost: onCancelled", databaseError.toException());
            }
        };
        ref.addValueEventListener(postListener);
    }


}

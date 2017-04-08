package com.example.beebzb.codingkid;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServerTransaction {
    private static final String TAG = "ServerTransaction";

    private static DatabaseReference mDatabase;


    public static void writeData(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("levels").child("abachronikova").child("level1").setValue("level 1 strign repre");
    }



}

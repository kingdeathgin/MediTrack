package com.example.meditrack;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;

    private com.example.meditrack.AppDatabase appDatabase;

    private DatabaseClient(Context mCtx){
        this.mCtx = mCtx;
        appDatabase = Room.databaseBuilder(mCtx, com.example.meditrack.AppDatabase.class,"Task.db").fallbackToDestructiveMigration().build();

    }

    public static synchronized DatabaseClient getInstance(Context mCtx){
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public com.example.meditrack.AppDatabase getAppDatabase() {
        return appDatabase;
    }
}

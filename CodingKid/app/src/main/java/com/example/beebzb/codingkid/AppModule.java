package com.example.beebzb.codingkid;


import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final MainApplication mApplication;

    public AppModule(MainApplication application) {
        mApplication = application;
    }

    @Provides
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    Context providesApplicationContext() {
        return mApplication;
    }

}
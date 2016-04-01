package com.toidiu.starter.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by toidiu on 1/13/16.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return context;
    }
}

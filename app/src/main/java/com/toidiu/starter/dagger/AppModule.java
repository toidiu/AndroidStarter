package com.toidiu.starter.dagger;

import android.content.Context;

import com.toidiu.starter.utils.Prefs;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by toidiu on 1/13/16.
 */
@Module()
public class AppModule {
    //~=~=~=~=~=~=~=~=~=~=~=~=CONSTANTS

    @Provides
    @Singleton
    Prefs providesPrefs(Context context) {
        return new Prefs(context);
    }

}

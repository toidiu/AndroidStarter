package com.toidiu.starter;

import android.app.Application;
import android.content.Context;

import com.edisonwang.ps.lib.EventService;
import com.edisonwang.ps.lib.PennStation;
import com.toidiu.starter.dagger.ApiModules;
import com.toidiu.starter.dagger.AppModule;
import com.toidiu.starter.dagger.ApplicationComponent;
import com.toidiu.starter.dagger.ContextModule;
import com.toidiu.starter.dagger.DaggerApplicationComponent;


/**
 * Created by toidiu on 3/28/16.
 */
public class StarterApplication extends Application {

    public static Context appContext;
    ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this.getApplicationContext();

        PennStation.init(this, new PennStation.PennStationOptions(EventService.class)); //or extended class.

        appComponent = DaggerApplicationComponent.builder()
                .apiModules(new ApiModules())
                .contextModule(new ContextModule(this.getApplicationContext()))
                .appModule(new AppModule())
                .build();

    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}

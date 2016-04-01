package com.toidiu.starter.dagger;

import com.toidiu.starter.actions.BaseAction;
import com.toidiu.starter.ui.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by toidiu on 12/9/15.
 */
@Singleton
@Component(modules = {ApiModules.class, AppModule.class, ContextModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity obj);

    void inject(BaseAction obj);
}

package com.toidiu.starter.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.toidiu.starter.StarterApplication;
import com.toidiu.starter.utils.Prefs;

import javax.inject.Inject;


public class BaseActivity extends AppCompatActivity {

    @Inject
    Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((StarterApplication) getApplication()).getAppComponent().inject(this);
    }


}
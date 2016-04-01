package com.toidiu.starter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

/**
 * Created by toidiu on 1/13/16.
 */

public class Prefs {

    //~=~=~=~=~=~=~=~=~=~=~=~=USER
    public static final String USER = "USER";

    //~=~=~=~=~=~=~=~=~=~=~=~=Fields
    private SharedPreferences prefs;

    public Prefs(Context context) {
        this.prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Nullable
    public String getUser() {
        return prefs.getString(USER, null);
    }

    //-~-~--~-~--~-~--~-~--~-~--~-~--~-~--~-~--~-~-USER
    public void setUser(String user) {
        prefs.edit().putString(USER, user).apply();
    }


}


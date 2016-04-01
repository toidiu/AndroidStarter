package com.toidiu.starter.actions;

import android.content.Context;
import android.os.Bundle;

import com.edisonwang.ps.annotations.RequestAction;
import com.edisonwang.ps.lib.Action;
import com.edisonwang.ps.lib.ActionRequest;
import com.edisonwang.ps.lib.ActionResult;
import com.edisonwang.ps.lib.EventServiceImpl;
import com.toidiu.starter.StarterApplication;
import com.toidiu.starter.utils.Prefs;

import javax.inject.Inject;


/**
 * Created by toidiu on 3/28/16.
 */
@RequestAction
public class BaseAction implements Action {

    @Inject
    Context context;
    @Inject
    Prefs prefs;

    @Override
    public ActionResult processRequest(EventServiceImpl service, ActionRequest actionRequest, Bundle bundle) {
        ((StarterApplication) StarterApplication.appContext).getAppComponent().inject(this);

        return null;
    }

}

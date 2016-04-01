package com.toidiu.starter.actions;

import android.os.Bundle;

import com.edisonwang.ps.annotations.EventClass;
import com.edisonwang.ps.annotations.EventProducer;
import com.edisonwang.ps.annotations.RequestAction;
import com.edisonwang.ps.annotations.RequestActionHelper;
import com.edisonwang.ps.lib.ActionRequest;
import com.edisonwang.ps.lib.ActionResult;
import com.edisonwang.ps.lib.EventServiceImpl;


/**
 * Created by toidiu on 3/28/16.
 */
@RequestAction
@EventProducer(generated = {
        @EventClass(classPostFix = "Success"),
        @EventClass(classPostFix = "Failure")
})
@RequestActionHelper()
//variables = {
//        @ClassField(name = "tag", kind = @Kind(clazz = String.class), required = true)
//})
//@EventProducer(generated = {
//        @EventClass(classPostFix = "Success", fields = {
//                @ParcelableClassField(name = "results", kind = @Kind(clazz = Tumblr.Post[].class))
//        }),
//        @EventClass(classPostFix = "Failure", fields = {
//                @ParcelableClassField(name = "message", kind = @Kind(clazz = String.class))
//        })
//})
public class TestAction extends BaseAction {
    @Override
    public ActionResult processRequest(EventServiceImpl service, ActionRequest actionRequest, Bundle bundle) {
        super.processRequest(service, actionRequest, bundle);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TestActionEventSuccess();
    }

}

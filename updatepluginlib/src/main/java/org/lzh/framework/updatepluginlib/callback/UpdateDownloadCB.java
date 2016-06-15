package org.lzh.framework.updatepluginlib.callback;

import android.app.Activity;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.UpdateConfig;
import org.lzh.framework.updatepluginlib.model.Update;

import java.io.File;
import java.lang.ref.WeakReference;

/**
 * @author Administrator
 */
public abstract class UpdateDownloadCB {
    private WeakReference<Activity> actRef = null;
    private UpdateBuilder builder;
    private Update update;

    public UpdateDownloadCB() {
    }

    public abstract void onUpdateStart();

    public abstract void onUpdateComplete(File file);

    public abstract void onUpdateProgress(long current, long total);

    public abstract   void onUpdateError(int code, String errorMsg);


    public WeakReference<Activity> getActRef() {
        if(actRef==null){
            actRef=UpdateConfig.getConfig().getActRef();
        }
        return actRef;
    }

    public UpdateBuilder getBuilder() {
        if(builder==null){
            builder=UpdateConfig.getConfig().getBuilder();
        }
        return builder;
    }

    public Update getUpdate() {
        if(update==null){
            update=UpdateConfig.getConfig().getUpdate();
        }
        return update;
    }
}

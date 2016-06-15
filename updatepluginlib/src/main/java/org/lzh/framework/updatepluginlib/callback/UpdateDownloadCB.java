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
    protected WeakReference<Activity> actRef = null;
    protected UpdateBuilder builder;
    protected Update update;

    public UpdateDownloadCB() {
        this.actRef = UpdateConfig.getConfig().getActRef();
        this.builder = UpdateConfig.getConfig().getBuilder();
        this.update=UpdateConfig.getConfig().getUpdate();
    }

    public abstract void onUpdateStart();

    public abstract void onUpdateComplete(File file);

    public abstract void onUpdateProgress(long current, long total);

    public abstract   void onUpdateError(int code, String errorMsg);


}

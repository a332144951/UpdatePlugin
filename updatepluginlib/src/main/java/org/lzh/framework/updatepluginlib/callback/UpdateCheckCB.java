package org.lzh.framework.updatepluginlib.callback;

import android.app.Activity;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.UpdateConfig;
import org.lzh.framework.updatepluginlib.model.Update;

import java.lang.ref.WeakReference;

/**
 * The update check callback
 */
public abstract class UpdateCheckCB {

    protected WeakReference<Activity> actRef = null;
    protected UpdateBuilder builder;

    public UpdateCheckCB() {
        this.actRef = UpdateConfig.getConfig().getActRef();
        this.builder = UpdateConfig.getConfig().getBuilder();
    }

    /**
     * There are a new version of APK on network
     */
    public abstract void hasUpdate(Update update);

    /**
     * There are no new version for update
     */
    public abstract   void noUpdate();

    /**
     * http check error,
     * @param code http code
     * @param errorMsg http error msg
     */
    public abstract   void onCheckError(int code, String errorMsg);

    /**
     * to be invoked by user press cancel button.
     */
  public abstract void onUserCancel();
}

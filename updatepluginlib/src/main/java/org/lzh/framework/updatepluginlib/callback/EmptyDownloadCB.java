package org.lzh.framework.updatepluginlib.callback;

import android.app.Activity;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.model.Update;

import java.io.File;

/**
 * @author Administrator
 */
public class EmptyDownloadCB extends UpdateDownloadCB {
    public EmptyDownloadCB() {
        super();
    }

    @Override
    public void onUpdateStart() {

    }

    @Override
    public void onUpdateComplete(File file) {

    }

    @Override
    public void onUpdateProgress(long current, long total) {

    }

    @Override
    public void onUpdateError(int code, String errorMsg) {

    }

}

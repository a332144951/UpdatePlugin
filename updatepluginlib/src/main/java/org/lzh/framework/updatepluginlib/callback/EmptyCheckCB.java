package org.lzh.framework.updatepluginlib.callback;

import android.app.Activity;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.model.Update;

/**
 * @author Administrator
 */
public class EmptyCheckCB extends UpdateCheckCB {

    public EmptyCheckCB() {
        super();
    }

    @Override
    public void hasUpdate(Update update) {

    }

    @Override
    public void noUpdate() {

    }

    @Override
    public void onCheckError(int code, String errorMsg) {

    }

    @Override
    public void onUserCancel() {

    }
}

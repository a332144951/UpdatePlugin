package org.lzh.framework.updatepluginlib.callback;

import android.app.Activity;
import android.app.Dialog;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.UpdateConfig;
import org.lzh.framework.updatepluginlib.creator.InstallCreator;
import org.lzh.framework.updatepluginlib.model.Update;
import org.lzh.framework.updatepluginlib.util.InstallUtil;
import org.lzh.framework.updatepluginlib.util.SafeDialogOper;

import java.io.File;
import java.lang.ref.WeakReference;

/**
 * @author Administrator
 */
public class DefaultDownloadCB extends UpdateDownloadCB {

    private UpdateDownloadCB downloadCB;
    private UpdateDownloadCB innerCB;

    public DefaultDownloadCB() {
        super();
//        downloadCB=getBuilder().getDownloadCB();
    }


    public UpdateDownloadCB getDownloadCB() {
        if(downloadCB==null){
            downloadCB=getBuilder().getDownloadCB();
        }
        return downloadCB;
    }

    public void setDownloadCB(UpdateDownloadCB downloadCB) {
        this.downloadCB = downloadCB;
    }


    @Override
    public void onUpdateStart() {
        if (downloadCB != null) {
            downloadCB.onUpdateStart();
        }

        if (getInnerCB() != null) {
            innerCB.onUpdateStart();
        }
    }

    public UpdateDownloadCB getInnerCB() {
        if (innerCB == null && getBuilder().getStrategy().isShowDownloadDialog()) {
            innerCB = getBuilder().getDownloadDialogCreator().create(getUpdate(),getActRef().get(),getBuilder());
        }
        return innerCB;
    }

    @Override
    public void onUpdateComplete(File file) {
        if (downloadCB != null) {
            downloadCB.onUpdateComplete(file);
        }

        if (getInnerCB() != null) {
            innerCB.onUpdateComplete(file);
        }

        if (getBuilder().getStrategy().isShowInstallDialog()) {
            InstallCreator creator = getBuilder().getInstallDialogCreator();
            creator.setCheckCB(getBuilder().getCheckCB());
            Dialog dialog = creator.create(getUpdate(), file.getAbsolutePath(),getActRef().get());
            SafeDialogOper.safeShowDialog(dialog);
        }else if (getBuilder().getStrategy().isAutoInstall()) {
            InstallUtil.installApk(UpdateConfig.getConfig().getContext(),file.getAbsolutePath());
        }
    }

    @Override
    public void onUpdateProgress(long current,long total) {
        if (downloadCB != null) {
            downloadCB.onUpdateProgress(current,total);
        }

        if (getInnerCB() != null) {
            innerCB.onUpdateProgress(current,total);
        }
    }

    @Override
    public void onUpdateError(int code,String errorMsg) {
        if (downloadCB != null) {
            downloadCB.onUpdateError(code,errorMsg);
        }

        if (getInnerCB() != null) {
            innerCB.onUpdateError(code,errorMsg);
        }
    }
}

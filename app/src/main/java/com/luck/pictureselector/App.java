package com.luck.pictureselector;

import android.app.Application;
import android.content.Context;

import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraXConfig;

import com.luck.picture.lib.app.IApp;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.engine.PictureSelectorEngine;


/**
 * @author：luck
 * @date：2019-12-03 22:53
 * @describe：Application
 */

public class App extends Application implements IApp, CameraXConfig.Provider {
    private static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        PictureAppMaster.getInstance().setApp(this);
        PictureSelectionConfig.defaultOutPutCameraPath = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        PictureSelectionConfig.defaultSandboxFolderPath = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        PictureSelectionConfig.defaultCompressSavePath = getExternalCacheDir().getAbsolutePath();
    }

    @Override
    public Context getAppContext() {
        return this;
    }

    @Override
    public PictureSelectorEngine getPictureSelectorEngine() {
        return new PictureSelectorEngineImp();
    }

    @NonNull
    @Override
    public CameraXConfig getCameraXConfig() {
        return Camera2Config.defaultConfig();
    }
}

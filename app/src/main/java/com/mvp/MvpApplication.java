package com.mvp;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;
import com.mvp.utils.AppUtils;

import java.io.IOException;

/**
 * Created by cfp on 16-5-3.
 */
public class MvpApplication extends Application {

    private static final String TAG = "euler";

    private static final String APATCH_PATH = "/out.apatch";

    private PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();


        initPatch();


    }

    /**
     * 初始化热修复配置
     */
    private void initPatch() {
        patchManager = new PatchManager(getApplicationContext());
        patchManager.init(AppUtils.getAppVersionName(getApplicationContext()));
        Log.d(TAG, "init patch");


        patchManager.loadPatch();
        Log.d(TAG, "apatch loaded");

        // add patch at runtime
        try {
            // .apatch file path
            String patchFileString = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + APATCH_PATH;
            patchManager.addPatch(patchFileString);
            Log.d(TAG, "apatch:" + patchFileString + " added.");
        } catch (IOException e) {
            Log.e(TAG, "", e);
        }

    }
}

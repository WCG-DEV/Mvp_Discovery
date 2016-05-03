package com.mvp.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by cfp on 16-5-3.
 */
public class AppUtils {

    /**
     * 获取版本名称
     *
     * @return
     */
    public static String getAppVersionName(Context context) {

        String versionName = null;

        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } finally {

            return versionName;
        }

    }
}

package sample.kiscode.tinker;

import android.content.Context;
import android.util.Log;

import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;


/**
 * Description:
 * Author: keno
 * Date : 2020/11/4 13:34
 * 根据这篇文章进行配置  https://www.jianshu.com/p/9a107ee09006
 **/
public class TinkerManager {
    private static final String TAG = "TinkerManager";
    //标记是否安装过Tinker
    private static boolean isInstalled = false;

    private static ApplicationLike mAppLike;

    /**
     * 完成tinker的初始化
     *
     * @param applicationLike
     */
    public static void installTinker(SampleApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }

        //完成Tinker的初始化
        TinkerInstaller.install(mAppLike);
        isInstalled = true;
    }

    /**
     * 完成patch文件的加载
     *
     * @param path
     */
    public static void loadPatch(String path) {
        Log.i(TAG, "loadPatch:" + Tinker.isTinkerInstalled());
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    private static Context getApplicationContext() {
        if (mAppLike != null) {
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }
}

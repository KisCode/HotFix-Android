package demo.kiscode.andfix;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 * Author: kanjianxiong
 * Date : 2020/11/3 11:03
 **/
public class AndFixApplication extends Application {
    private static final String TAG = "AndFixApplication";
    private static final String APATCH_FILE_NAME = "out.apatch";
    private PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initAndFix();
    }

    private void initAndFix() {
        //初始化
        patchManager = new PatchManager(this);
        patchManager.init("1.0");

        //load
        patchManager.loadPatch();

        // add patch at runtime
        try {
            // .apatch file path
            String patchFileString = getCacheDir().getAbsolutePath() + File.separator + APATCH_FILE_NAME;
            Log.d(TAG, "apatch:" + patchFileString + " added.");
            patchManager.addPatch(patchFileString);
            Log.d(TAG, "apatch:" + patchFileString + " added.");
        } catch (IOException e) {
            Log.e(TAG, "", e);
        }
    }
}
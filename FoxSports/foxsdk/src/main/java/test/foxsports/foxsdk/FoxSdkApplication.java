package test.foxsports.foxsdk;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.AppLaunchChecker;

/**
 * Created by don.chummar on 15/11/17.
 */

public abstract class FoxSdkApplication extends Application {

    private static FoxSdkApplication instance;

    public static FoxSdkApplication singleton() {
        return instance;
    }

    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}

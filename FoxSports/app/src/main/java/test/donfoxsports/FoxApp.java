package test.donfoxsports;

import android.app.Application;
import android.content.Context;

import test.foxsports.foxsdk.FoxSdkApplication;

/**
 * Created by don.chummar on 15/11/17.
 */

public class FoxApp extends FoxSdkApplication {


    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public static FoxApp singleton()
    {
        // NOTE: The instance is created by the system.
        return (FoxApp) FoxSdkApplication.singleton();
    }
}

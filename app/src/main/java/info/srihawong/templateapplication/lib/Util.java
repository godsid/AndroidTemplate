package info.srihawong.templateapplication.lib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * Created by Banpot.S on 8/22/14 AD.
 */
public class Util  {

    // The gesture threshold expressed in dp
    private static final float GESTURE_THRESHOLD_DP = 16.0f;

    // Get the screen's density scale
   // private static final float scale  ;

    public Util() {
        //context.getResources().getDisplayMetrics().density;
    }

    public static int px2dp(){
        return 0;
    }

    public static int dp2px(){
        // Convert the dps to pixels, based on density scale
        //return (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);
        return 0;
    }

    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public static String getAppVersionName(Context context){
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            //throw new RuntimeException("Could not get package name: " + e);
            return "";
        }
    }

    public static void dial(Context context ,String phoneNumber){
        Intent callActivity = new Intent(Intent.ACTION_CALL);
        callActivity.setData(Uri.parse(phoneNumber));
        callActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(callActivity);
    }
}

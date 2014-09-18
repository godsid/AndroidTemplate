package info.srihawong.templateapplication.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

import info.srihawong.templateapplication.Config;

/**
 * Created by Banpot.S on 9/18/14 AD.
 */
public class FacebookAuth extends Activity{

    public UiLifecycleHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiHelper = new UiLifecycleHelper(this, statusCallback);
        uiHelper.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    public void onSessionStateChange(Session session, SessionState state, Exception exception) {
        Log.d("tui", "session state change:" + state.name());
        if(session.isOpened()){
            String[] permission = Config.facebookPermission.split(",");
            for(int i=0,j=permission.length;i<j;i++){
                if(session.isPermissionGranted(permission[i])){
                }else{
                    Log.d("tui","Request permission");
                    session.requestNewPublishPermissions(new Session.NewPermissionsRequest(this,Config.facebookPermission));
                    break;
                }
            }
        }
    }

    public Session.StatusCallback statusCallback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };
}



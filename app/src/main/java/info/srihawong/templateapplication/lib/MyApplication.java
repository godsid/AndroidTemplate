package info.srihawong.templateapplication.lib;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.facebook.Session;
import com.facebook.model.GraphUser;

import org.json.JSONObject;

import info.srihawong.templateapplication.object.Member;


/**
 * Created by Banpot.S on 9/17/14 AD.
 */
public class MyApplication extends Application{
    public Member member;
    public String versionName,packageName;
    public int versionCode;
    private static final String MEMBER_PREFERENCES = "member";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("tui", "Application Create");

        try {
            PackageInfo packageInfo = getPackageManager()
                    .getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
            packageName = packageInfo.packageName;

        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
        getSharedPreferencesData();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    private void getSharedPreferencesData(){
            SharedPreferences sharedpreferences = getSharedPreferences(MEMBER_PREFERENCES, Context.MODE_PRIVATE);
            if(!sharedpreferences.getString("username","").equals("")){
                member = new Member();

                member.setEmail(sharedpreferences.getString("email",""));
                member.setNickname(sharedpreferences.getString("nickname",""));
                member.setAvatar(sharedpreferences.getString("avatar",""));
                member.setMember_id(sharedpreferences.getInt("member_id",0));
                member.setUsername(sharedpreferences.getString("username",""));
                member.setFirstname(sharedpreferences.getString("firstname", ""));
                member.setLastname(sharedpreferences.getString("lastname",""));
            }
    }
    public void setMemberLogin(int member_id,String email,String username,String nickname,String avatar,String firstname,String lastname){
        member = new Member();
        member.setEmail(email);
        member.setNickname(nickname);
        member.setAvatar(avatar);
        member.setMember_id(member_id);
        member.setUsername(username);
        member.setFirstname(firstname);
        member.setLastname(lastname);
        setSharedPreferencesData();
    }

    public void setSharedPreferencesData(){
        SharedPreferences sharedpreferences = getSharedPreferences(MEMBER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("email",member.getEmail());
        editor.putString("nickname",member.getNickname());
        editor.putString("avatar",member.getAvatar());
        editor.putInt("member_id",member.getMember_id());
        editor.putString("username",member.getUsername());
        editor.putString("firstname",member.getFirstname());
        editor.putString("lastname",member.getLastname());
        editor.commit();
    }

    public void setFacebookMember(GraphUser user){
        //member.setEmail(user.getProperty("email").toString());
        //member.setNickname(user.getUsername());
        //member.setAvatar(user.get);
        //member.setMember_id(user.getInt("member_id",0));
        //member.setUsername(sharedpreferences.getString("username",""));
        //member.setFirstname(sharedpreferences.getString("firstname", ""));
        //member.setLastname(sharedpreferences.getString("lastname",""));
    }
}

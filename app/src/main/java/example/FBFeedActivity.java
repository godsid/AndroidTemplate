package example;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.androidquery.AQuery;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import info.srihawong.templateapplication.R;


public class FBFeedActivity extends FragmentActivity {
    AQuery aq;
    LinearLayout feedLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbfeed);
        feedLayout =  (LinearLayout)findViewById(R.id.feedLayout);

        aq = new AQuery(getApplicationContext());

        Session.openActiveSession(this, true, new Session.StatusCallback() {
            @Override
            public void call(Session session, SessionState state, Exception exception) {

                /* make the API call */
                new Request(
                        session,
                        "/UnseenThailand/photos",
                        null,
                        HttpMethod.GET,
                        new Request.Callback() {
                            public void onCompleted(Response response) {
                                /* handle the result */
                                JSONObject respdata = response.getGraphObject().getInnerJSONObject();

                                try {
                                    JSONArray data = respdata.getJSONArray("data");
                                    JSONObject pageing = respdata.getJSONObject("paging");
                                    for(int i=0,j=data.length();i<j;i++){
                                        ImageView imageView = new ImageView(getApplicationContext());
                                        String picture = data.getJSONObject(i).getString("picture");
                                        aq.id(imageView)
                                                .image(picture,true,true,0,0,null,AQuery.FADE_IN_NETWORK,AQuery.RATIO_PRESERVE);
                                        imageView.setImageURI(Uri.parse(data.getJSONObject(i).getString("picture")));
                                        feedLayout.addView(imageView);

                                    }

                                    //Log.d("tui", response.getGraphObject().toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                ).executeAsync();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }

}

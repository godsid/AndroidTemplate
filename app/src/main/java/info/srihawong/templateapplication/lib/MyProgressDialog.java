package info.srihawong.templateapplication.lib;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import info.srihawong.templateapplication.R;

/**
 * Created by Banpot.S on 9/19/14 AD.
 */
public class MyProgressDialog extends ProgressDialog{
    private AnimationDrawable animation;
    public MyProgressDialog(Context context) {
        super(context);
    }

    public MyProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_progress_dialog);
        ImageView la = (ImageView) findViewById(R.id.animation);
        la.setBackgroundResource(R.drawable.my_progress_dialog_animate);
        animation = (AnimationDrawable) la.getBackground();
    }

    @Override
    public void show() {
        super.show();
        animation.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        animation.stop();
    }
}

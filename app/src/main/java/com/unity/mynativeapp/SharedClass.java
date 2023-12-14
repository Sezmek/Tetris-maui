package com.unity.mynativeapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import com.unity3d.player.IUnityPlayerSupport;
import com.unity3d.player.UnityPlayer;

public class SharedClass {

    public static void showMainActivity(String setToColor) {
        showMainActivity(UnityPlayer.currentActivity, setToColor);
    }

    public static void showMainActivity(Activity activity, String setToColor) {
        Intent intent = new Intent((Context) activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("setColor", setToColor);
        activity.startActivity(intent);
    }

    public static void addControlsToUnityFrame(Activity activity) {
        UnityPlayer unityPlayer = ((IUnityPlayerSupport) UnityPlayer.currentActivity).getUnityPlayerConnection();
        FrameLayout layout = unityPlayer.getFrameLayout();

        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        Button finishButton = new Button(activity);
        finishButton.setText("Quit");
        finishButton.setX(100);
        finishButton.setY(100);
        finishButton.setBackgroundColor(Color.BLACK);
        finishButton.setTextColor(Color.RED);

        finishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activity.finish();
            }
        });
        layout.addView(finishButton, 300, 200);
    }


}

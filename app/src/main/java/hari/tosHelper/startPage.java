package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import hotchemi.android.rate.AppRate;

public class startPage extends Activity {
    protected static String mode;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        AppRate.with(this).setInstallDays(1).setLaunchTimes(2).setRemindInterval(2).setShowLaterButton(true).monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
    }



    public void goToTips(View view) {
        startActivity(new Intent(this, tipsPage.class));
    }

    public void goToAbout(View view) {
        startActivity(new Intent(this, aboutPage.class));
    }

    public void goToClassicModes(View view) {
        startActivity(new Intent(this, classicModesPage.class));
    }

    public void goToCovenModes(View view) {
        startActivity(new Intent(this, covenModesPage.class));
    }
}

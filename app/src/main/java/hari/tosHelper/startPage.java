package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class startPage extends Activity {

    protected static String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }

    public void goToRanked(View view) {
        mode = "Ranked";
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }

    public void goToClassic(View view) {
        mode = "Classic";
        Intent intent = new Intent(this, classicPage.class);
        startActivity(intent);
    }

    public void goToRainbow(View view) {
        mode = "Rainbow";
        Intent intent = new Intent(this, rainbowPage.class);
        startActivity(intent);
    }

    public void goToTips(View view) {
        Intent intent = new Intent(this, tipsPage.class);
        startActivity(intent);
    }

    public void goToAbout(View view) {
        Intent intent = new Intent(this, aboutPage.class);
        startActivity(intent);
    }

}

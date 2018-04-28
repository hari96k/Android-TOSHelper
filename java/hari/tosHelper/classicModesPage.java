package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class classicModesPage extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_modes_page);
    }

//    public void goToRanked(View view) {
//        startPage.mode = "Ranked";
//        alignmentsTab.setModeLayout(R.layout.new_alignments_layout);
//        startActivity(new Intent(this, mainPage.class));
//    }

    public void goToClassic(View view) {
        startPage.mode = "Classic";
        startActivity(new Intent(this, classicPage.class));
    }

    public void goToRainbow(View view) {
        startPage.mode = "Rainbow";
        startActivity(new Intent(this, rainbowPage.class));
    }

    public void goToRanked(View view) {
        template.roles = new String[]{"Jailor", "Town Investigative", "Town Support", "Town Protective", "Town Killing", "Random Town", "Random Town", "Random Town", "Random Town", "Godfather", "Mafioso", "Random Mafia", "Random Mafia", "Neutral Killing", "Neutral Evil"};
        startPage.mode = "Ranked";
        alignmentsTab.setModeLayout(R.layout.ranked_roles_tab);
        startActivity(new Intent(this, template.class));
    }

    public void goToCustom(View view) {
        startPage.mode = "Custom";
        startActivity(new Intent(this, customPresets.class));
    }
}

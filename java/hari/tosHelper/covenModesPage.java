package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class covenModesPage extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coven_modes_page);
    }

    public void goToRanked(View view) {
        template.roles = new String[]{"Jailor", "Town Investigative", "Town Investigative", "Town Support", "Town Protective", "Town Killing", "Random Town", "Random Town", "Random Town", "Coven Leader", "Medusa", "Coven Evil", "Coven Evil", "Neutral Evil", "Neutral Killing"};
        startPage.mode = "Coven Ranked";
        startPage.modeCoven = true;
        alignmentsTab.setModeLayout(R.layout.coven_ranked_roles_tab);
        startActivity(new Intent(this, template.class));
    }

    public void goToCustom(View view) {
        // Careful with renaming this mode, its format is reused elsewhere
        startPage.mode = "Coven Custom";
        startPage.modeCoven = true;
        startActivity(new Intent(this, customPresets.class));
    }
}

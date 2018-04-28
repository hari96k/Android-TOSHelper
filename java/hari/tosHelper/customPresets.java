package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import hotchemi.android.rate.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;

public class customPresets extends Activity {
    static int presetNumber;
    static SharedPreferences settings;
    static int[] setups = new int[]{R.id.setup1, R.id.setup2, R.id.setup3, R.id.setup4, R.id.setup5};
    boolean setupNamesUpdated;
    Toast toast;
    static String conditional;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_presets_page);
        settings = PreferenceManager.getDefaultSharedPreferences(this);
        this.toast = Toast.makeText(getBaseContext(), BuildConfig.VERSION_NAME, Toast.LENGTH_LONG);
        this.setupNamesUpdated = false;
        conditional = startPage.mode.equals("Coven Custom")? "Coven" : "";
    }

    public void goToCustom(View view) {
        switch (view.getId()) {
            case R.id.selectPreset1 /*2131558520*/:
                presetNumber = 1;
                break;
            case R.id.selectPreset2 /*2131558523*/:
                presetNumber = 2;
                break;
            case R.id.selectPreset3 /*2131558526*/:
                presetNumber = 3;
                break;
            case R.id.selectPreset4 /*2131558529*/:
                presetNumber = 4;
                break;
            case R.id.selectPreset5 /*2131558532*/:
                presetNumber = 5;
                break;
        }
        startActivity(new Intent(this, customTemplate.class));
    }

    public void deletePreset(View view) {
        EditText setupName;
        Editor editor = settings.edit();
        switch (view.getId()) {
            case R.id.deletePreset1 /*2131558521*/:
                setupName = findViewById(R.id.setup1);
                editor.putString(conditional + "1", new JSONArray().toString());
                break;
            case R.id.deletePreset2 /*2131558524*/:
                setupName = findViewById(R.id.setup2);
                editor.putString(conditional + "2", new JSONArray().toString());
                break;
            case R.id.deletePreset3 /*2131558527*/:
                setupName = findViewById(R.id.setup3);
                editor.putString(conditional + "3", new JSONArray().toString());
                break;
            case R.id.deletePreset4 /*2131558530*/:
                setupName = findViewById(R.id.setup4);
                editor.putString(conditional + "4", new JSONArray().toString());
                break;
            default:
                setupName = findViewById(R.id.setup5);
                editor.putString(conditional + "5", new JSONArray().toString());
                break;
        }
        displayToast(setupName.getText().toString() + " reset!");
        editor.apply();
    }

    protected void onResume() {
        super.onResume();
        if (!this.setupNamesUpdated) {
            this.setupNamesUpdated = true;
            try {
                JSONArray jsonArray = new JSONArray(settings.getString(conditional + "setups", "[]"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    ((EditText) findViewById(setups[i])).setText((String) jsonArray.get(i));
                }
            } catch (JSONException ignored) {
            }
        }
        if (customTemplate.customStatesSaved) {
            EditText setupName;
            customTemplate.customStatesSaved = false;
            switch (presetNumber) {
                case 1 /*1*/:
                    setupName = findViewById(R.id.setup1);
                    break;
                case 2 /*2*/:
                    setupName = findViewById(R.id.setup2);
                    break;
                case 3 /*3*/:
                    setupName = findViewById(R.id.setup3);
                    break;
                case 4 /*4*/:
                    setupName = findViewById(R.id.setup4);
                    break;
                default:
                    setupName = findViewById(R.id.setup5);
                    break;
            }
            displayToast(setupName.getText().toString() + " saved!");
        }
    }

    void displayToast(String message) {
        this.toast.setText(message);
        TextView look = this.toast.getView().findViewById(android.R.id.message);
        if (look != null) {
            look.setGravity(17);
        }
        this.toast.show();
    }

    public void onBackPressed() {
        this.toast.cancel();
        super.onBackPressed();
    }

    protected void onStop() {
        settings = PreferenceManager.getDefaultSharedPreferences(this);
        JSONArray jsonArray = new JSONArray();
        int i = 0;
        while (i < setups.length) {
            try {
                jsonArray.put(i, ((EditText) findViewById(setups[i])).getText().toString());
                i++;
            } catch (JSONException ignored) {
            }
        }
        Editor editor = settings.edit();
        editor.putString(conditional + "setups", jsonArray.toString());
        editor.apply();
        super.onStop();
    }
}

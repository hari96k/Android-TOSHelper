package hari.tosHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import hari.tosHelper.rainbowInfoTab.OnInfoTabListener;
import hotchemi.android.rate.BuildConfig;

public class rainbowPage extends AppCompatActivity implements OnInfoTabListener {
    private static final int AMNE_POS_1 = 5;
    private static final int AMNE_POS_2 = 11;
    private static final int ANY_POS = 8;
    private static final int ANY_REQUEST = 16;
    private static final int ARSO_POS_1 = 2;
    private static final int ARSO_POS_2 = 14;
    private static final int GF_POS = 1;
    private static final int JAILOR_POS = 4;
    private static final int MAF_POS = 15;
    private static final int SK_POS_1 = 6;
    private static final int SK_POS_2 = 10;
    private static final int SURV_POS_1 = 3;
    private static final int SURV_POS_2 = 13;
    private static final int VET_POS = 12;
    private static final int WITCH_POS_1 = 7;
    private static final int WITCH_POS_2 = 9;
    protected static HashMap<String, Integer> confirmedRoles = new HashMap<String, Integer>() {
        {
            put("Sheriff", 0);
            put("Doctor", 0);
            put("Investigator", 0);
            put("Jailor", 0);
            put("Medium", 0);
            put("Executioner", 0);
            put("Escort", 0);
            put("Lookout", 0);
            put("Serial Killer", 0);
            put("Veteran", 0);
            put("Vigilante", 0);
            put("Jester", 0);
            put("Bodyguard", 0);
            put("Mayor", 0);
            put("Retributionist", 0);
            put("Spy", 0);
            put("Transporter", 0);
            put("Vampire Hunter", 0);
            put("Blackmailer", 0);
            put("Consigliere", 0);
            put("Consort", 0);
            put("Disguiser", 0);
            put("Forger", 0);
            put("Framer", 0);
            put("Godfather", 0);
            put("Janitor", 0);
            put("Mafioso", 0);
            put("Arsonist", 0);
            put("Werewolf", 0);
            put("Executioner", 0);
            put("Jester", 0);
            put("Witch", 0);
            put("Amnesiac", 0);
            put("Survivor", 0);
            put("Vampire", 0);
        }
    };
    protected static HashMap<String, Integer> realizedRainbowRoles = new HashMap<String, Integer>() {
        {
            put("Sheriff", 0);
            put("Doctor", 0);
            put("Investigator", 0);
            put("Jailor", 0);
            put("Medium", 0);
            put("Executioner", 0);
            put("Escort", 0);
            put("Lookout", 0);
            put("Serial Killer", 0);
            put("Veteran", 0);
            put("Vigilante", 0);
            put("Jester", 0);
            put("Bodyguard", 0);
            put("Mayor", 0);
            put("Retributionist", 0);
            put("Spy", 0);
            put("Transporter", 0);
            put("Vampire Hunter", 0);
            put("Blackmailer", 0);
            put("Consigliere", 0);
            put("Consort", 0);
            put("Disguiser", 0);
            put("Forger", 0);
            put("Framer", 0);
            put("Godfather", 0);
            put("Janitor", 0);
            put("Mafioso", 0);
            put("Arsonist", 0);
            put("Werewolf", 0);
            put("Executioner", 0);
            put("Jester", 0);
            put("Witch", 0);
            put("Amnesiac", 0);
            put("Survivor", 0);
            put("Vampire", 0);
        }
    };
    protected static ArrayList<Integer> remainingPositions = new ArrayList<>();
    private static boolean confTipShown = false;
    protected CustomAdapter adapter;
    Toast toast;
    private boolean doubleBackToExitPressedOnce = false;
    private rainbowInfoTab infoTab;
    private ViewPager viewPager;

    protected static void updateRealizedRole(String role, boolean status) {
        if (status) {
            realizedRainbowRoles.put(role, realizedRainbowRoles.get(role) + 1);
        } else {
            realizedRainbowRoles.put(role, realizedRainbowRoles.get(role) - 1);
        }
    }

    protected static void updateConfirmedRole(String role, boolean status) {
        if (status) {
            confirmedRoles.put(role, confirmedRoles.get(role) + 1);
        } else {
            confirmedRoles.put(role, confirmedRoles.get(role) - 1);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_page);
        resetStates();
        this.viewPager = findViewById(R.id.viewPager);
        this.adapter = new CustomAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.adapter);
        TabLayout tablayout = findViewById(R.id.tabLayout);
        tablayout.setupWithViewPager(this.viewPager);
        tablayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            public void onTabSelected(Tab tab) {
                rainbowPage.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(Tab tab) {
                rainbowPage.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabReselected(Tab tab) {
                rainbowPage.this.viewPager.setCurrentItem(tab.getPosition());
            }
        });
        this.toast = Toast.makeText(getBaseContext(), BuildConfig.VERSION_NAME, Toast.LENGTH_LONG);
        displayToast("Don't forget to input your role!");
    }

    public void fetchRole(View view) {
        startActivityForResult(new Intent(this, Any_rainbow.class), ANY_REQUEST);
    }

    public void deleteRole(View view) {
        EditText editText = findViewById(R.id.rainbowAnyField);
        EditText positionText = findViewById(R.id.AnyPos);
        Button button = findViewById(R.id.rainbowButtonAnyField);
        View status = findViewById(R.id.AnyStatus);
        String role = editText.getText().toString();
        if (status.getVisibility() == View.VISIBLE && positionText.getText().toString().length() == 0) {
            status.setVisibility(View.INVISIBLE);
        }
        updateRealizedRole(role, false);
        updateConfirmedRole(role, false);
        this.infoTab.updateListView();
        LayoutParams params = (LayoutParams) editText.getLayoutParams();
        params.addRule(0, 0);
        editText.setLayoutParams(params);
        editText.setText(BuildConfig.VERSION_NAME);
        button.setVisibility(View.INVISIBLE);
    }

    public void onClickedChkBox(View view) {
        CheckBox checkBox = (CheckBox) view;
        this.infoTab.updateListView();
        if (checkBox.isChecked()) {
            switch (view.getId()) {
                case R.id.chkJailor /*2131558586*/:
                    updateRealizedRole("Jailor", true);
                    return;
                case R.id.chkGF /*2131558588*/:
                    updateRealizedRole("Godfather", true);
                    return;
                case R.id.chkMafioso /*2131558592*/:
                    updateRealizedRole("Mafioso", true);
                    return;
                case R.id.chkArso1 /*2131558880*/:
                    updateRealizedRole("Arsonist", true);
                    return;
                case R.id.chkSurv1 /*2131558881*/:
                    updateRealizedRole("Survivor", true);
                    return;
                case R.id.chkAmne1 /*2131558882*/:
                    updateRealizedRole("Amnesiac", true);
                    return;
                case R.id.chkSK1 /*2131558883*/:
                    updateRealizedRole("Serial Killer", true);
                    return;
                case R.id.chkWitch1 /*2131558884*/:
                    updateRealizedRole("Witch", true);
                    return;
                case R.id.chkWitch2 /*2131558887*/:
                    updateRealizedRole("Witch", true);
                    return;
                case R.id.chkSK2 /*2131558888*/:
                    updateRealizedRole("Serial Killer", true);
                    return;
                case R.id.chkAmne2 /*2131558889*/:
                    updateRealizedRole("Amnesiac", true);
                    return;
                case R.id.chkVet /*2131558890*/:
                    updateRealizedRole("Veteran", true);
                    return;
                case R.id.chkSurv2 /*2131558891*/:
                    updateRealizedRole("Survivor", true);
                    return;
                case R.id.chkArso2 /*2131558892*/:
                    updateRealizedRole("Arsonist", true);
                    return;
                default:
                    return;
            }
        }
        switch (view.getId()) {
            case R.id.chkJailor /*2131558586*/:
                updateRealizedRole("Jailor", false);
                return;
            case R.id.chkGF /*2131558588*/:
                updateRealizedRole("Godfather", false);
                return;
            case R.id.chkMafioso /*2131558592*/:
                updateRealizedRole("Mafioso", false);
                return;
            case R.id.chkArso1 /*2131558880*/:
                updateRealizedRole("Arsonist", false);
                return;
            case R.id.chkSurv1 /*2131558881*/:
                updateRealizedRole("Survivor", false);
                return;
            case R.id.chkAmne1 /*2131558882*/:
                updateRealizedRole("Amnesiac", false);
                return;
            case R.id.chkSK1 /*2131558883*/:
                updateRealizedRole("Serial Killer", false);
                return;
            case R.id.chkWitch1 /*2131558884*/:
                updateRealizedRole("Witch", false);
                return;
            case R.id.chkWitch2 /*2131558887*/:
                updateRealizedRole("Witch", false);
                return;
            case R.id.chkSK2 /*2131558888*/:
                updateRealizedRole("Serial Killer", false);
                return;
            case R.id.chkAmne2 /*2131558889*/:
                updateRealizedRole("Amnesiac", false);
                return;
            case R.id.chkVet /*2131558890*/:
                updateRealizedRole("Veteran", false);
                return;
            case R.id.chkSurv2 /*2131558891*/:
                updateRealizedRole("Survivor", false);
                return;
            case R.id.chkArso2 /*2131558892*/:
                updateRealizedRole("Arsonist", false);
                return;
            default:
        }
    }

    public void setPosition(View view) {
        int posID;
        String alignment;
        String role;
        int constant;
        Intent intent = new Intent(this, selectPos.class);
        String position = BuildConfig.VERSION_NAME;
        switch (view.getId()) {
            case R.id.jailorPos /*2131558766*/:
                posID = R.id.jailorPos;
                alignment = "Town Killing";
                role = "Jailor";
                constant = JAILOR_POS;
                break;
            case R.id.GFPos /*2131558774*/:
                posID = R.id.GFPos;
                alignment = "Mafia Killing";
                role = "Godfather";
                constant = GF_POS;
                break;
            case R.id.AnyPos /*2131558780*/:
                posID = R.id.AnyPos;
                alignment = "Any";
                role = ((EditText) findViewById(R.id.rainbowAnyField)).getText().toString();
                constant = ANY_POS;
                break;
            case R.id.arsoPos1 /*2131558869*/:
                posID = R.id.arsoPos1;
                alignment = "Neutral Killing";
                role = "Arsonist";
                constant = ARSO_POS_1;
                break;
            case R.id.survPos1 /*2131558870*/:
                posID = R.id.survPos1;
                alignment = "Neutral Benign";
                role = "Survivor";
                constant = SURV_POS_1;
                break;
            case R.id.amnePos1 /*2131558871*/:
                posID = R.id.amnePos1;
                alignment = "Neutral Benign";
                role = "Amnesiac";
                constant = AMNE_POS_1;
                break;
            case R.id.SKPos1 /*2131558872*/:
                posID = R.id.SKPos1;
                alignment = "Neutral Killing";
                role = "Serial Killer";
                constant = SK_POS_1;
                break;
            case R.id.witchPos1 /*2131558873*/:
                posID = R.id.witchPos1;
                alignment = "Neutral Evil";
                role = "Witch";
                constant = WITCH_POS_1;
                break;
            case R.id.witchPos2 /*2131558874*/:
                posID = R.id.witchPos2;
                alignment = "Neutral Evil";
                role = "Witch";
                constant = WITCH_POS_2;
                break;
            case R.id.SKPos2 /*2131558875*/:
                posID = R.id.SKPos2;
                alignment = "Neutral Killing";
                role = "Serial Killer";
                constant = SK_POS_2;
                break;
            case R.id.amnePos2 /*2131558876*/:
                posID = R.id.amnePos2;
                alignment = "Neutral Benign";
                role = "Amnesiac";
                constant = AMNE_POS_2;
                break;
            case R.id.vetPos /*2131558877*/:
                posID = R.id.vetPos;
                alignment = "Town Killing";
                role = "Veteran";
                constant = VET_POS;
                break;
            case R.id.survPos2 /*2131558878*/:
                posID = R.id.survPos2;
                alignment = "Neutral Benign";
                role = "Survivor";
                constant = SURV_POS_2;
                break;
            case R.id.arsoPos2 /*2131558879*/:
                posID = R.id.arsoPos2;
                alignment = "Neutral Killing";
                role = "Arsonist";
                constant = ARSO_POS_2;
                break;
            default:
                posID = R.id.MafPos;
                alignment = "Mafia Killing";
                role = "Mafioso";
                constant = MAF_POS;
                break;
        }
        EditText positionField = findViewById(posID);
        if (positionField.getText().toString().length() > 0) {
            position = positionField.getText().toString();
        }
        String[] player = new String[SURV_POS_1];
        player[0] = alignment;
        player[1] = position;
        player[2] = role;
        intent.putExtra("player", player);
        startActivityForResult(intent, constant);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String role = null;
        String roleText = BuildConfig.VERSION_NAME;
        if (data != null) {
            role = data.getStringExtra("selection");
        }
        if (resultCode == -1 && role != null) {
            int positionID = -1;
            int statusID = -1;
            if (!confTipShown) {
                confTipShown = true;
                displayToast("Tap the alignment to confirm this Player / Role!");
            }
            EditText textField;
            String prevRole;
            if (requestCode == ANY_REQUEST) {
                textField = findViewById(R.id.rainbowAnyField);
                Button button = findViewById(R.id.rainbowButtonAnyField);
                prevRole = textField.getText().toString();
                View anyStatus = findViewById(R.id.AnyStatus);
                if (prevRole.length() != 0) {
                    updateRealizedRole(prevRole, false);
                    if (anyStatus.getVisibility() == View.VISIBLE) {
                        updateConfirmedRole(prevRole, false);
                    }
                }
                mainPage.resizeText(textField, role);
                LayoutParams params = (LayoutParams) textField.getLayoutParams();
                params.addRule(0, R.id.rainbowButtonAnyField);
                textField.setLayoutParams(params);
                textField.setText(role);
                textField.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(role)));
                button.setVisibility(View.VISIBLE);
                updateRealizedRole(role, true);
                if (anyStatus.getVisibility() == View.VISIBLE) {
                    updateConfirmedRole(role, true);
                }
                this.infoTab.updateListView();
                return;
            }
            switch (requestCode) {
                case 1 /*1*/:
                    positionID = R.id.GFPos;
                    statusID = R.id.GFStatus;
                    roleText = "Godfather";
                    break;
                case 2 /*2*/:
                    positionID = R.id.arsoPos1;
                    statusID = R.id.arsoStatus1;
                    roleText = "Arsonist";
                    break;
                case 3 /*3*/:
                    positionID = R.id.survPos1;
                    statusID = R.id.survStatus1;
                    roleText = "Survivor";
                    break;
                case 4 /*4*/:
                    positionID = R.id.jailorPos;
                    statusID = R.id.jailorStatus;
                    roleText = "Jailor";
                    break;
                case 5 /*5*/:
                    positionID = R.id.amnePos1;
                    statusID = R.id.amneStatus1;
                    roleText = "Amnesiac";
                    break;
                case 6 /*6*/:
                    positionID = R.id.SKPos1;
                    statusID = R.id.SKStatus1;
                    roleText = "Serial Killer";
                    break;
                case 7 /*7*/:
                    positionID = R.id.witchPos1;
                    statusID = R.id.witchStatus1;
                    roleText = "Witch";
                    break;
                case 8 /*8*/:
                    positionID = R.id.AnyPos;
                    statusID = R.id.AnyStatus;
                    break;
                case 9 /*9*/:
                    positionID = R.id.witchPos2;
                    statusID = R.id.witchStatus2;
                    roleText = "Witch";
                    break;
                case 10 /*10*/:
                    positionID = R.id.SKPos2;
                    statusID = R.id.SKStatus2;
                    roleText = "Serial Killer";
                    break;
                case 11 /*11*/:
                    positionID = R.id.amnePos2;
                    statusID = R.id.amneStatus2;
                    roleText = "Amnesiac";
                    break;
                case 12 /*12*/:
                    positionID = R.id.vetPos;
                    statusID = R.id.vetStatus;
                    roleText = "Veteran";
                    break;
                case 13 /*13*/:
                    positionID = R.id.survPos2;
                    statusID = R.id.survStatus2;
                    roleText = "Survivor";
                    break;
                case 14 /*14*/:
                    positionID = R.id.arsoPos2;
                    statusID = R.id.arsoStatus2;
                    roleText = "Arsonist";
                    break;
                case 15 /*15*/:
                    positionID = R.id.MafPos;
                    statusID = R.id.MafStatus;
                    roleText = "Mafioso";
                    break;
            }
            textField = findViewById(positionID);
            prevRole = textField.getText().toString();
            if (prevRole.length() != 0) {
                updateRemainingPos(prevRole, false);
            }
            if (role.equals("delete")) {
                textField.setText(BuildConfig.VERSION_NAME);
                View status = findViewById(statusID);
                if (requestCode == ANY_POS) {
                    TextView anyField = findViewById(R.id.rainbowAnyField);
                    if (status.getVisibility() == View.VISIBLE && anyField.getText().toString().length() == 0) {
                        status.setVisibility(View.INVISIBLE);
                        return;
                    }
                    return;
                } else if (status.getVisibility() == View.VISIBLE) {
                    updateConfirmedRole(roleText, false);
                    status.setVisibility(View.INVISIBLE);
                    this.infoTab.updateListView();
                    return;
                } else {
                    return;
                }
            }
            textField.setText(role);
            updateRemainingPos(role, true);
        }
    }

    public void toggleStatus(View view) {
        int statusID = -1;
        int posID = -1;
        int fieldID = -1;
        String roleText = BuildConfig.VERSION_NAME;
        switch (view.getId()) {
            case R.id.jailorTitleGroup /*2131558722*/:
                statusID = R.id.jailorStatus;
                posID = R.id.jailorPos;
                roleText = "Jailor";
                break;
            case R.id.GFTitleGroup /*2131558745*/:
                statusID = R.id.GFStatus;
                posID = R.id.GFPos;
                roleText = "Godfather";
                break;
            case R.id.MafTitleGroup /*2131558748*/:
                statusID = R.id.MafStatus;
                posID = R.id.MafPos;
                roleText = "Mafioso";
                break;
            case R.id.AnyTitleGroup /*2131558764*/:
                statusID = R.id.AnyStatus;
                posID = R.id.AnyPos;
                fieldID = R.id.rainbowAnyField;
                break;
            case R.id.arsoTitleGroup1 /*2131558834*/:
                statusID = R.id.arsoStatus1;
                posID = R.id.arsoPos1;
                roleText = "Arsonist";
                break;
            case R.id.survTitleGroup1 /*2131558837*/:
                statusID = R.id.survStatus1;
                posID = R.id.survPos1;
                roleText = "Survivor";
                break;
            case R.id.amneTitleGroup1 /*2131558841*/:
                statusID = R.id.amneStatus1;
                posID = R.id.amnePos1;
                roleText = "Amnesiac";
                break;
            case R.id.SKTitleGroup1 /*2131558844*/:
                statusID = R.id.SKStatus1;
                posID = R.id.SKPos1;
                roleText = "Serial Killer";
                break;
            case R.id.witchTitleGroup1 /*2131558847*/:
                statusID = R.id.witchStatus1;
                posID = R.id.witchPos1;
                roleText = "Witch";
                break;
            case R.id.witchTitleGroup2 /*2131558851*/:
                statusID = R.id.witchStatus2;
                posID = R.id.witchPos2;
                roleText = "Witch";
                break;
            case R.id.SKTitleGroup2 /*2131558854*/:
                statusID = R.id.SKStatus2;
                posID = R.id.SKPos2;
                roleText = "Serial Killer";
                break;
            case R.id.amneTitleGroup2 /*2131558857*/:
                statusID = R.id.amneStatus2;
                posID = R.id.amnePos2;
                roleText = "Amnesiac";
                break;
            case R.id.vetTitleGroup /*2131558860*/:
                statusID = R.id.vetStatus;
                posID = R.id.vetPos;
                roleText = "Veteran";
                break;
            case R.id.survTitleGroup2 /*2131558863*/:
                statusID = R.id.survStatus2;
                posID = R.id.survPos2;
                roleText = "Survivor";
                break;
            case R.id.arsoTitleGroup2 /*2131558866*/:
                statusID = R.id.arsoStatus2;
                posID = R.id.arsoPos2;
                roleText = "Arsonist";
                break;
        }
        EditText position = findViewById(posID);
        EditText role = findViewById(fieldID);
        View statusBox = findViewById(statusID);
        String pos = position.getText().toString();
        if (posID == R.id.AnyPos) {
            roleText = role.getText().toString();
            if (pos.length() == 0 && roleText.length() == 0) {
                displayToast("Please select the Position / Role before you confirm!");
                return;
            }
        } else if (pos.length() == 0) {
            displayToast("Please select the Position before you confirm a guaranteed role!");
            return;
        }
        if (statusBox.getVisibility() != View.VISIBLE) {
            statusBox.setVisibility(View.VISIBLE);
            switch (statusID) {
                case R.id.AnyStatus /*2131558765*/:
                    roleText = role.getText().toString();
                    if (roleText.length() != 0) {
                        updateConfirmedRole(roleText, true);
                        break;
                    }
                    break;
                default:
                    updateConfirmedRole(roleText, true);
                    break;
            }
        }
        statusBox.setVisibility(View.INVISIBLE);
        switch (statusID) {
            case R.id.AnyStatus /*2131558765*/:
                roleText = role.getText().toString();
                if (roleText.length() != 0) {
                    updateConfirmedRole(roleText, false);
                    break;
                }
                break;
            default:
                updateConfirmedRole(roleText, false);
                break;
        }
        this.infoTab.updateListView();
    }

    public void onRoleSelected(String role, int position) {
        Intent intent = new Intent(this, Role_Information.class);
        intent.putExtra("selection", role);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    public void onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            this.toast.cancel();
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        displayToast("Please press BACK again to exit Rainbow Mode");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                rainbowPage.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void updateRemainingPos(String position, boolean status) {
        Integer pos = Integer.parseInt(position);
        if (status) {
            remainingPositions.remove(pos);
            return;
        }
        remainingPositions.add(pos);
        Collections.sort(remainingPositions);
    }

    private void resetStates() {
        confTipShown = false;
        remainingPositions.clear();
        for (int i = GF_POS; i <= MAF_POS; i += GF_POS) {
            remainingPositions.add(i);
        }
        for (Entry<String, Integer> entry : realizedRainbowRoles.entrySet()) {
            realizedRainbowRoles.put(entry.getKey(), 0);
            confirmedRoles.put(entry.getKey(), 0);
        }
    }

    private void displayToast(String message) {
        this.toast.setText(message);
        TextView look = this.toast.getView().findViewById(android.R.id.message);
        if (look != null) {
            look.setGravity(17);
        }
        this.toast.show();
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        private final String[] fragments;

        CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
            String[] strArr = new String[rainbowPage.ARSO_POS_1];
            strArr[0] = "Roles";
            strArr[rainbowPage.GF_POS] = "Info";
            this.fragments = strArr;
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0 /*0*/:
                    return new rainbowRolesTab();
                case 1 /*1*/:
                    rainbowPage.this.infoTab = new rainbowInfoTab();
                    return rainbowPage.this.infoTab;
                default:
                    return null;
            }
        }

        public int getCount() {
            return this.fragments.length;
        }

        public CharSequence getPageTitle(int position) {
            return this.fragments[position];
        }
    }
}

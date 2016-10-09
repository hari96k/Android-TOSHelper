package hari.tosHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class rainbowPage extends AppCompatActivity implements rainbowInfoTab.OnInfoTabListener {

    private static boolean confTipShown = false;

    private ViewPager viewPager;
    protected CustomAdapter adapter;
    private rainbowInfoTab infoTab;

    private static final int GF_POS = 1;
    private static final int ARSO_POS_1 = 2;
    private static final int SURV_POS_1 = 3;
    private static final int JAILOR_POS = 4;
    private static final int AMNE_POS_1 = 5;
    private static final int SK_POS_1 = 6;
    private static final int WITCH_POS_1 = 7;
    private static final int ANY_POS = 8;
    private static final int WITCH_POS_2 = 9;
    private static final int SK_POS_2 = 10;
    private static final int AMNE_POS_2 = 11;
    private static final int VET_POS = 12;
    private static final int SURV_POS_2 = 13;
    private static final int ARSO_POS_2 = 14;
    private static final int MAF_POS = 15;

    private static final int ANY_REQUEST = 16;

    protected static HashMap<String, Integer> realizedRainbowRoles = new HashMap<String, Integer>() {{
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
    }};

    protected static HashMap<String, Integer> confirmedRoles = new HashMap<String, Integer>() {{
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
    }};

    protected static ArrayList<Integer> remainingPositions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow_page);

        displayToast("Don't forget to input your role!");
        resetStates();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new CustomAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tablayout = (TabLayout) findViewById(R.id.tabLayout);
        tablayout.setupWithViewPager(viewPager);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }


    private class CustomAdapter extends FragmentPagerAdapter {

        private final String[] fragments = {"Roles", "Info"};

        public CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new rainbowRolesTab();
                case 1:
                    infoTab = new rainbowInfoTab();
                    return infoTab;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }

    }

    public void fetchRole(View view) {
        Intent intent;
        intent = new Intent(this, Any_rainbow.class);
        startActivityForResult(intent, ANY_REQUEST);
    }

    public void deleteRole(View view) {
        EditText editText;
        EditText positionText;
        Button button;
        View status;
        String role;

        editText = (EditText) findViewById(R.id.rainbowAnyField);
        positionText = (EditText) findViewById(R.id.AnyPos);
        button = (Button) findViewById(R.id.rainbowButtonAnyField);
        status = findViewById(R.id.AnyStatus);
        role = editText.getText().toString();

        if (status.getVisibility() == View.VISIBLE && positionText.getText().toString().length() == 0)
            status.setVisibility(View.INVISIBLE);

        updateRealizedRole(role, false);
        updateConfirmedRole(role, false);
        infoTab.updateListView();

        // Adjusting to the right of the delete button
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) findViewById(R.id.rainbowAnyField).getLayoutParams();
        params.addRule(RelativeLayout.LEFT_OF, 0);
        editText.setLayoutParams(params);

        editText.setText("");
        button.setVisibility(View.INVISIBLE);
    }

    public void onClickedChkBox(View view) {
        CheckBox checkBox = (CheckBox) view;
        infoTab.updateListView();

        if (checkBox.isChecked()) {
            switch (view.getId()) {
                case R.id.chkGF:
                    updateRealizedRole("Godfather", true);
                    break;
                case R.id.chkArso1:
                    updateRealizedRole("Arsonist", true);
                    break;
                case R.id.chkSurv1:
                    updateRealizedRole("Survivor", true);
                    break;
                case R.id.chkJailor:
                    updateRealizedRole("Jailor", true);
                    break;
                case R.id.chkAmne1:
                    updateRealizedRole("Amnesiac", true);
                    break;
                case R.id.chkSK1:
                    updateRealizedRole("Serial Killer", true);
                    break;
                case R.id.chkWitch1:
                    updateRealizedRole("Witch", true);
                    break;
                case R.id.chkWitch2:
                    updateRealizedRole("Witch", true);
                    break;
                case R.id.chkSK2:
                    updateRealizedRole("Serial Killer", true);
                    break;
                case R.id.chkAmne2:
                    updateRealizedRole("Amnesiac", true);
                    break;
                case R.id.chkVet:
                    updateRealizedRole("Veteran", true);
                    break;
                case R.id.chkSurv2:
                    updateRealizedRole("Survivor", true);
                    break;
                case R.id.chkArso2:
                    updateRealizedRole("Arsonist", true);
                    break;
                case R.id.chkMafioso:
                    updateRealizedRole("Mafioso", true);
                    break;
            }

        } else {
            switch (view.getId()) {
                case R.id.chkGF:
                    updateRealizedRole("Godfather", false);
                    break;
                case R.id.chkArso1:
                    updateRealizedRole("Arsonist", false);
                    break;
                case R.id.chkSurv1:
                    updateRealizedRole("Survivor", false);
                    break;
                case R.id.chkJailor:
                    updateRealizedRole("Jailor", false);
                    break;
                case R.id.chkAmne1:
                    updateRealizedRole("Amnesiac", false);
                    break;
                case R.id.chkSK1:
                    updateRealizedRole("Serial Killer", false);
                    break;
                case R.id.chkWitch1:
                    updateRealizedRole("Witch", false);
                    break;
                case R.id.chkWitch2:
                    updateRealizedRole("Witch", false);
                    break;
                case R.id.chkSK2:
                    updateRealizedRole("Serial Killer", false);
                    break;
                case R.id.chkAmne2:
                    updateRealizedRole("Amnesiac", false);
                    break;
                case R.id.chkVet:
                    updateRealizedRole("Veteran", false);
                    break;
                case R.id.chkSurv2:
                    updateRealizedRole("Survivor", false);
                    break;
                case R.id.chkArso2:
                    updateRealizedRole("Arsonist", false);
                    break;
                case R.id.chkMafioso:
                    updateRealizedRole("Mafioso", false);
                    break;
            }
        }
    }

    public void setPosition(View view) {
        Intent intent = new Intent(this, selectPos.class);
        EditText positionField;
        EditText roleField;
        String position = "";
        String role;
        int posID;
        String alignment;
        int constant;
        String[] player;

        switch (view.getId()) {
            case R.id.GFPos:
                posID = R.id.GFPos;
                alignment = "Mafia Killing";
                role = "Godfather";
                constant = GF_POS;
                break;
            case R.id.arsoPos1:
                posID = R.id.arsoPos1;
                alignment = "Neutral Killing";
                role = "Arsonist";
                constant = ARSO_POS_1;
                break;
            case R.id.survPos1:
                posID = R.id.survPos1;
                alignment = "Neutral Benign";
                role = "Survivor";
                constant = SURV_POS_1;
                break;
            case R.id.jailorPos:
                posID = R.id.jailorPos;
                alignment = "Town Killing";
                role = "Jailor";
                constant = JAILOR_POS;
                break;
            case R.id.amnePos1:
                posID = R.id.amnePos1;
                alignment = "Neutral Benign";
                role = "Amnesiac";
                constant = AMNE_POS_1;
                break;
            case R.id.SKPos1:
                posID = R.id.SKPos1;
                alignment = "Neutral Killing";
                role = "Serial Killer";
                constant = SK_POS_1;
                break;
            case R.id.witchPos1:
                posID = R.id.witchPos1;
                alignment = "Neutral Evil";
                role = "Witch";
                constant = WITCH_POS_1;
                break;
            case R.id.AnyPos:
                posID = R.id.AnyPos;
                alignment = "Any";
                roleField = (EditText) findViewById(R.id.rainbowAnyField);
                role = roleField.getText().toString();
                constant = ANY_POS;
                break;
            case R.id.witchPos2:
                posID = R.id.witchPos2;
                alignment = "Neutral Evil";
                role = "Witch";
                constant = WITCH_POS_2;
                break;
            case R.id.SKPos2:
                posID = R.id.SKPos2;
                alignment = "Neutral Killing";
                role = "Serial Killer";
                constant = SK_POS_2;
                break;
            case R.id.amnePos2:
                posID = R.id.amnePos2;
                alignment = "Neutral Benign";
                role = "Amnesiac";
                constant = AMNE_POS_2;
                break;
            case R.id.vetPos:
                posID = R.id.vetPos;
                alignment = "Town Killing";
                role = "Veteran";
                constant = VET_POS;
                break;
            case R.id.survPos2:
                posID = R.id.survPos2;
                alignment = "Neutral Benign";
                role = "Survivor";
                constant = SURV_POS_2;
                break;
            case R.id.arsoPos2:
                posID = R.id.arsoPos2;
                alignment = "Neutral Killing";
                role = "Arsonist";
                constant = ARSO_POS_2;
                break;
            default:// R.id.MafPos:
                posID = R.id.MafPos;
                alignment = "Mafia Killing";
                role = "Mafioso";
                constant = MAF_POS;
                break;
        }
        positionField = (EditText) findViewById(posID);
        if (positionField.getText().toString().length() > 0)
            position = positionField.getText().toString();
        player = new String[]{alignment, position, role};
        intent.putExtra("player", player);
        startActivityForResult(intent, constant);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String role = null;
        String prevRole;
        String roleText = "";
        if (data != null)
            role = data.getStringExtra("selection");
        if (resultCode == RESULT_OK && role != null) {
            // Check which request we're responding to
            EditText textField;
            Button button;
            int positionID = -1;
            int statusID = -1;

            if (!confTipShown) {
                confTipShown = true;
                displayToast("Tap the alignment to confirm this Player / Role!");
            }

            if (requestCode == ANY_REQUEST) {
                // There is only the Any field in rainbow mode
                textField = (EditText) findViewById(R.id.rainbowAnyField);
                button = (Button) findViewById(R.id.rainbowButtonAnyField);

                // If there is a previous role, reset its availability status
                prevRole = textField.getText().toString();

                View anyStatus = findViewById(R.id.AnyStatus);
                if (prevRole.length() != 0) {
                    // Delete previous role
                    updateRealizedRole(prevRole, false);

                    if (anyStatus.getVisibility() == View.VISIBLE)
                        updateConfirmedRole(prevRole, false);
                }

                mainPage.resizeText(textField, role);

                // Adjusting to the left of the delete button
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) findViewById(R.id.rainbowAnyField).getLayoutParams();
                params.addRule(RelativeLayout.LEFT_OF, R.id.rainbowButtonAnyField);
                textField.setLayoutParams(params);

                textField.setText(role);
                textField.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(role)));
                button.setVisibility(View.VISIBLE);

                // Role is taken
                updateRealizedRole(role, true);

                // If Status is confirmed (bc of pos input) and there is a field input, then update confirmed role

                if (anyStatus.getVisibility() == View.VISIBLE)
                    updateConfirmedRole(role, true);
                infoTab.updateListView();
            } else {
                switch (requestCode) {
                    case GF_POS:
                        positionID = R.id.GFPos;
                        statusID = R.id.GFStatus;
                        roleText = "Godfather";
                        break;
                    case ARSO_POS_1:
                        positionID = R.id.arsoPos1;
                        statusID = R.id.arsoStatus1;
                        roleText = "Arsonist";
                        break;
                    case SURV_POS_1:
                        positionID = R.id.survPos1;
                        statusID = R.id.survStatus1;
                        roleText = "Survivor";
                        break;
                    case JAILOR_POS:
                        positionID = R.id.jailorPos;
                        statusID = R.id.jailorStatus;
                        roleText = "Jailor";
                        break;
                    case AMNE_POS_1:
                        positionID = R.id.amnePos1;
                        statusID = R.id.amneStatus1;
                        roleText = "Amnesiac";
                        break;
                    case SK_POS_1:
                        positionID = R.id.SKPos1;
                        statusID = R.id.SKStatus1;
                        roleText = "Serial Killer";
                        break;
                    case WITCH_POS_1:
                        positionID = R.id.witchPos1;
                        statusID = R.id.witchStatus1;
                        roleText = "Witch";
                        break;
                    case ANY_POS:
                        positionID = R.id.AnyPos;
                        statusID = R.id.AnyStatus;
                        break;
                    case WITCH_POS_2:
                        positionID = R.id.witchPos2;
                        statusID = R.id.witchStatus2;
                        roleText = "Witch";
                        break;
                    case SK_POS_2:
                        positionID = R.id.SKPos2;
                        statusID = R.id.SKStatus2;
                        roleText = "Serial Killer";
                        break;
                    case AMNE_POS_2:
                        positionID = R.id.amnePos2;
                        statusID = R.id.amneStatus2;
                        roleText = "Amnesiac";
                        break;
                    case VET_POS:
                        positionID = R.id.vetPos;
                        statusID = R.id.vetStatus;
                        roleText = "Veteran";
                        break;
                    case SURV_POS_2:
                        positionID = R.id.survPos2;
                        statusID = R.id.survStatus2;
                        roleText = "Survivor";
                        break;
                    case ARSO_POS_2:
                        positionID = R.id.arsoPos2;
                        statusID = R.id.arsoStatus2;
                        roleText = "Arsonist";
                        break;
                    case MAF_POS:
                        positionID = R.id.MafPos;
                        statusID = R.id.MafStatus;
                        roleText = "Mafioso";
                        break;
                }

                textField = (EditText) findViewById(positionID);
                prevRole = textField.getText().toString();

                if (prevRole.length() != 0) {
                    updateRemainingPos(prevRole, false);
                }

                if (role.equals("delete")) {
                    textField.setText("");

                    View status = findViewById(statusID);

                    // If it is a delete any position
                    if (requestCode == ANY_POS) {
                        TextView anyField = (TextView) findViewById(R.id.rainbowAnyField);
                        if (status.getVisibility() == View.VISIBLE && anyField.getText().toString().length() == 0)
                            status.setVisibility(View.INVISIBLE);
                    } else {
                        if (status.getVisibility() == View.VISIBLE) {
                            updateConfirmedRole(roleText, false);
                            status.setVisibility(View.INVISIBLE);
                            infoTab.updateListView();
                        }
                    }
                } else {
                    textField.setText(role);
                    updateRemainingPos(role, true);
                }
            }
        }
    }


    public void toggleStatus(View view) {
        EditText position;
        EditText role;
        View statusBox;
        int statusID = -1;
        int posID = -1;
        int fieldID = -1;
        String pos;
        String roleText = "";

        switch (view.getId()) {
            case (R.id.GFTitleGroup):
                statusID = R.id.GFStatus;
                posID = R.id.GFPos;
                roleText = "Godfather";
                break;
            case (R.id.arsoTitleGroup1):
                statusID = R.id.arsoStatus1;
                posID = R.id.arsoPos1;
                roleText = "Arsonist";
                break;
            case (R.id.survTitleGroup1):
                statusID = R.id.survStatus1;
                posID = R.id.survPos1;
                roleText = "Survivor";
                break;
            case (R.id.jailorTitleGroup):
                statusID = R.id.jailorStatus;
                posID = R.id.jailorPos;
                roleText = "Jailor";
                break;
            case (R.id.amneTitleGroup1):
                statusID = R.id.amneStatus1;
                posID = R.id.amnePos1;
                roleText = "Amnesiac";
                break;
            case (R.id.SKTitleGroup1):
                statusID = R.id.SKStatus1;
                posID = R.id.SKPos1;
                roleText = "Serial Killer";
                break;
            case (R.id.witchTitleGroup1):
                statusID = R.id.witchStatus1;
                posID = R.id.witchPos1;
                roleText = "Witch";
                break;
            case (R.id.AnyTitleGroup):
                statusID = R.id.AnyStatus;
                posID = R.id.AnyPos;
                fieldID = R.id.rainbowAnyField;
                break;
            case (R.id.witchTitleGroup2):
                statusID = R.id.witchStatus2;
                posID = R.id.witchPos2;
                roleText = "Witch";
                break;
            case (R.id.SKTitleGroup2):
                statusID = R.id.SKStatus2;
                posID = R.id.SKPos2;
                roleText = "Serial Killer";
                break;
            case (R.id.amneTitleGroup2):
                statusID = R.id.amneStatus2;
                posID = R.id.amnePos2;
                roleText = "Amnesiac";
                break;
            case (R.id.vetTitleGroup):
                statusID = R.id.vetStatus;
                posID = R.id.vetPos;
                roleText = "Veteran";
                break;
            case (R.id.survTitleGroup2):
                statusID = R.id.survStatus2;
                posID = R.id.survPos2;
                roleText = "Survivor";
                break;
            case (R.id.arsoTitleGroup2):
                statusID = R.id.arsoStatus2;
                posID = R.id.arsoPos2;
                roleText = "Arsonist";
                break;
            case (R.id.MafTitleGroup):
                statusID = R.id.MafStatus;
                posID = R.id.MafPos;
                roleText = "Mafioso";
                break;
        }
        position = (EditText) findViewById(posID);
        role = (EditText) findViewById(fieldID);
        statusBox = findViewById(statusID);

        pos = position.getText().toString();

        // If not guaranteed role and there is no position and field
        if (posID == R.id.AnyPos) {
            // If there is no position or role
            roleText = role.getText().toString();
            if (pos.length() == 0 && roleText.length() == 0) {
                displayToast("Please select the Position / Role before you confirm!");
                return;
            }
        } else {
            if (pos.length() == 0) {
                displayToast("Please select the Position before you confirm a guaranteed role!");
                return;
            }
        }


        // Toggle to not confirmed
        if (statusBox.getVisibility() == View.VISIBLE) {
            statusBox.setVisibility(View.INVISIBLE);

            switch (statusID) {
                case R.id.AnyStatus:
                    roleText = role.getText().toString();
                    if (roleText.length() != 0)
                        updateConfirmedRole(roleText, false);
                    break;
                default:
                    updateConfirmedRole(roleText, false);
                    break;
            }
        }
        // Toggle to confirmed
        else {
            statusBox.setVisibility(View.VISIBLE);

            switch (statusID) {
                case R.id.AnyStatus:
                    roleText = role.getText().toString();
                    if (roleText.length() != 0)
                        updateConfirmedRole(roleText, true);
                    break;
                default:
                    updateConfirmedRole(roleText, true);
                    break;
            }
        }
        infoTab.updateListView();
    }

    @Override
    public void onRoleSelected(String role, int position) {
        Intent intent = new Intent(rainbowPage.this, Role_Information.class);
        intent.putExtra("selection", role);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        String message = "Please press BACK again to exit Rainbow Mode";
        Toast toast = Toast.makeText(rainbowPage.this, message, Toast.LENGTH_LONG);
        TextView view = (TextView) toast.getView().findViewById(android.R.id.message);
        if (view != null) {
            view.setGravity(Gravity.CENTER);
        }
        toast.show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    protected static void updateRealizedRole(String role, boolean status) {
        if (status)
            realizedRainbowRoles.put(role, realizedRainbowRoles.get(role) + 1);
        else
            realizedRainbowRoles.put(role, realizedRainbowRoles.get(role) - 1);
    }

    private void updateRemainingPos(String position, boolean status) {
        Integer pos = Integer.parseInt(position);
        if (status)
            remainingPositions.remove(pos);
        else {
            remainingPositions.add(pos);
            Collections.sort(remainingPositions);
        }
    }

    protected static void updateConfirmedRole(String role, boolean status) {
        if (status)
            confirmedRoles.put(role, confirmedRoles.get(role) + 1);
        else
            confirmedRoles.put(role, confirmedRoles.get(role) - 1);
    }

    private void resetStates() {
        confTipShown = false;
        remainingPositions.clear();
        for (int i = 1; i <= 15; i++) {
            remainingPositions.add(i);
        }

        for (Map.Entry<String, Integer> entry : realizedRainbowRoles.entrySet()) {
            realizedRainbowRoles.put(entry.getKey(), 0);
            confirmedRoles.put(entry.getKey(), 0);
        }
    }

    private void displayToast(String message) {
        Toast toast = Toast.makeText(rainbowPage.this, message, Toast.LENGTH_LONG);
        TextView look = (TextView) toast.getView().findViewById(android.R.id.message);
        if (look != null) {
            look.setGravity(Gravity.CENTER);
        }
        toast.show();
    }
}

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
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class mainPage extends AppCompatActivity implements infoTab.OnInfoTabListener {

    private ViewPager viewPager;
    private static final int TI_REQUEST_1 = 1;
    private static final int TI_REQUEST_2 = 2;
    private static final int TS_REQUEST_1 = 3;
    private static final int TS_REQUEST_2 = 4;
    private static final int TP_REQUEST = 5;
    private static final int TK_REQUEST = 6;
    private static final int RT_REQUEST = 7;
    private static final int RM_REQUEST = 8;
    private static final int NK_REQUEST = 9;
    private static final int NE_REQUEST = 10;
    private static final int NB_REQUEST = 11;
    private static final int ANY_REQUEST = 12;
    private static final int TI_POS_1 = 13;
    private static final int TI_POS_2 = 14;
    private static final int TS_POS_1 = 15;
    private static final int TS_POS_2 = 16;
    private static final int TP_POS = 17;
    private static final int TK_POS = 18;
    private static final int RT_POS = 19;
    private static final int GF_POS = 20;
    private static final int MAF_POS = 21;
    private static final int RM_POS = 22;
    private static final int NK_POS = 23;
    private static final int NE_POS = 24;
    private static final int NB_POS = 25;
    private static final int ANY_POS = 26;
    private static final int JAILOR_POS = 27;

    private static boolean confTipShown = false;

    protected CustomAdapter adapter;
    private infoTab InfoTab;
    private overviewTab OverviewTab;


    protected static HashMap<String, Integer> realizedRoles = new HashMap<String, Integer>() {{
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

    protected static final HashMap<String, Integer> roleColors = new HashMap<String, Integer>() {{
        put("Jailor", R.color.townText);
        put("Investigator", R.color.townText);
        put("Lookout", R.color.townText);
        put("Sheriff", R.color.townText);
        put("Spy", R.color.townText);
        put("Escort", R.color.townText);
        put("Mayor", R.color.townText);
        put("Medium", R.color.townText);
        put("Retributionist", R.color.townText);
        put("Transporter", R.color.townText);
        put("Bodyguard", R.color.townText);
        put("Doctor", R.color.townText);
        put("Vampire Hunter", R.color.townText);
        put("Veteran", R.color.townText);
        put("Vigilante", R.color.townText);
        put("Godfather", R.color.mafiaText);
        put("Mafioso", R.color.mafiaText);
        put("Blackmailer", R.color.mafiaText);
        put("Consigliere", R.color.mafiaText);
        put("Consort", R.color.mafiaText);
        put("Disguiser", R.color.mafiaText);
        put("Forger", R.color.mafiaText);
        put("Framer", R.color.mafiaText);
        put("Janitor", R.color.mafiaText);
        put("Arsonist", R.color.arsonistText);
        put("Serial Killer", R.color.skText);
        put("Werewolf", R.color.wwText);
        put("Executioner", R.color.exeText);
        put("Jester", R.color.jesterText);
        put("Witch", R.color.witchText);
        put("Amnesiac", R.color.amneText);
        put("Survivor", R.color.survivorText);
        put("Vampire", R.color.exeText);
    }};

    protected static final HashMap<String, Integer> alignmentColors = new HashMap<String, Integer>() {{
        put("Town Investigative", R.color.townText);
        put("Town Support", R.color.townText);
        put("Town Protective", R.color.townText);
        put("Town Killing", R.color.townText);
        put("Jailor", R.color.townText);
        put("Random Town", R.color.townText);
        put("Mafia Killing", R.color.mafiaText);
        put("Godfather", R.color.mafiaText);
        put("Mafioso", R.color.mafiaText);
        put("Random Mafia", R.color.mafiaText);
        put("Mafia Support", R.color.mafiaText);
        put("Mafia Deception", R.color.mafiaText);
        put("Neutral Killing", R.color.exeText);
        put("Neutral Evil", R.color.exeText);
        put("Neutral Benign", R.color.exeText);
        put("Any", R.color.black);
        put("Neutral Chaos", R.color.exeText);
    }};

    protected static ArrayList<Integer> remainingPositions = new ArrayList<>();

    protected static SparseBooleanArray confirmedPlayers = new SparseBooleanArray() {{
        put(1, false);
        put(2, false);
        put(3, false);
        put(4, false);
        put(5, false);
        put(6, false);
        put(7, false);
        put(8, false);
        put(9, false);
        put(10, false);
        put(11, false);
        put(12, false);
        put(13, false);
        put(14, false);
        put(15, false);
    }};

    protected static HashMap<String, Boolean> confirmedAlignments = new HashMap<String, Boolean>() {{
        put("jailor", false);
        put("TI1", false);
        put("TI2", false);
        put("TS1", false);
        put("TS2", false);
        put("TP", false);
        put("TK", false);
        put("RT", false);
        put("GF", false);
        put("Maf", false);
        put("RM", false);
        put("NK", false);
        put("NE", false);
        put("NB", false);
        put("Any", false);
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        displayToast("Don't forget to input your role!");
        setContentView(R.layout.activity_main_page);
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


    @Override
    public void onRoleSelected(String role, int position) {
        Intent intent = new Intent(mainPage.this, Role_Information.class);
        intent.putExtra("selection", role);
        intent.putExtra("position", position);
        startActivity(intent);
    }


    private class CustomAdapter extends FragmentPagerAdapter {

        private final String[] fragments = {"Overview", "Alignments", "Info"};

        public CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OverviewTab = new overviewTab();
                    return OverviewTab;
                case 1:
                    return new alignmentsTab();
                case 2:
                    InfoTab = new infoTab();
                    return InfoTab;
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
        switch (view.getId()) {
            case R.id.TIField1:
                intent = new Intent(this, TI.class);
                startActivityForResult(intent, TI_REQUEST_1);
                break;
            case R.id.TIField2:
                intent = new Intent(this, TI.class);
                startActivityForResult(intent, TI_REQUEST_2);
                break;
            case R.id.TSField1:
                intent = new Intent(this, TS.class);
                startActivityForResult(intent, TS_REQUEST_1);
                break;
            case R.id.TSField2:
                intent = new Intent(this, TS.class);
                startActivityForResult(intent, TS_REQUEST_2);
                break;
            case R.id.TPField:
                intent = new Intent(this, TP.class);
                startActivityForResult(intent, TP_REQUEST);
                break;
            case R.id.TKField:
                intent = new Intent(this, TK.class);
                startActivityForResult(intent, TK_REQUEST);
                break;
            case R.id.RTField:
                intent = new Intent(this, RT.class);
                startActivityForResult(intent, RT_REQUEST);
                break;
            case R.id.RMField:
                intent = new Intent(this, RM.class);
                startActivityForResult(intent, RM_REQUEST);
                break;
            case R.id.NKField:
                intent = new Intent(this, NK.class);
                startActivityForResult(intent, NK_REQUEST);
                break;
            case R.id.NEField:
                intent = new Intent(this, NE.class);
                startActivityForResult(intent, NE_REQUEST);
                break;
            case R.id.NBField:
                intent = new Intent(this, NB.class);
                startActivityForResult(intent, NB_REQUEST);
                break;
            case R.id.AnyField:
                intent = new Intent(this, Any.class);
                startActivityForResult(intent, ANY_REQUEST);
                break;
        }
    }

    public void deleteRole(View view) {
        EditText editText;
        EditText posText;
        Button button;
        View statusBox;
        String role;
        String pos;
        int fieldID = -1;
        int buttonID = -1;
        int statusID = -1;
        int posID = -1;

        switch (view.getId()) {
            case R.id.buttonTIField1:
                posID = R.id.TIPos1;
                statusID = R.id.TIStatus1;
                fieldID = (R.id.TIField1);
                buttonID = (R.id.buttonTIField1);
                break;

            case R.id.buttonTIField2:
                posID = R.id.TIPos2;
                statusID = R.id.TIStatus2;
                fieldID = (R.id.TIField2);
                buttonID = (R.id.buttonTIField2);
                break;

            case R.id.buttonTSField1:
                posID = R.id.TSPos1;
                statusID = R.id.TSStatus1;
                fieldID = (R.id.TSField1);
                buttonID = (R.id.buttonTSField1);
                break;

            case R.id.buttonTSField2:
                posID = R.id.TSPos2;
                statusID = R.id.TSStatus2;
                fieldID = (R.id.TSField2);
                buttonID = (R.id.buttonTSField2);
                break;

            case R.id.buttonTPField:
                posID = R.id.TPPos;
                statusID = R.id.TPStatus;
                fieldID = (R.id.TPField);
                buttonID = (R.id.buttonTPField);
                break;

            case R.id.buttonTKField:
                posID = R.id.TKPos;
                statusID = R.id.TKStatus;
                fieldID = (R.id.TKField);
                buttonID = (R.id.buttonTKField);
                break;

            case R.id.buttonRTField:
                posID = R.id.RTPos;
                statusID = R.id.RTStatus;
                fieldID = (R.id.RTField);
                buttonID = (R.id.buttonRTField);
                break;

            case R.id.buttonRMField:
                posID = R.id.RMPos;
                statusID = R.id.RMStatus;
                fieldID = (R.id.RMField);
                buttonID = (R.id.buttonRMField);
                break;

            case R.id.buttonNKField:
                posID = R.id.NKPos;
                statusID = R.id.NKStatus;
                fieldID = (R.id.NKField);
                buttonID = (R.id.buttonNKField);
                break;

            case R.id.buttonNEField:
                posID = R.id.NEPos;
                statusID = R.id.NEStatus;
                fieldID = (R.id.NEField);
                buttonID = (R.id.buttonNEField);
                break;

            case R.id.buttonNBField:
                posID = R.id.NBPos;
                statusID = R.id.NBStatus;
                fieldID = (R.id.NBField);
                buttonID = (R.id.buttonNBField);
                break;

            case R.id.buttonAnyField: //(Any Field)
                posID = R.id.AnyPos;
                statusID = R.id.AnyStatus;
                fieldID = (R.id.AnyField);
                buttonID = (R.id.buttonAnyField);
                break;
        }

        editText = (EditText) findViewById(fieldID);
        posText = (EditText) findViewById(posID);
        button = (Button) findViewById(buttonID);

        pos = posText.getText().toString();
        role = decodeRole(editText.getText().toString());
        statusBox = findViewById(statusID);


        if (statusBox.getVisibility() == View.VISIBLE) {
            updateConfirmedRole(role, false);
            // If there is no position
            if (pos.length() == 0) {
                statusBox.setVisibility(View.INVISIBLE);
            }
            InfoTab.updateListView();
        }


        // Adjusting to the right of the delete button
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) findViewById(fieldID).getLayoutParams();
        params.addRule(RelativeLayout.LEFT_OF, 0);
        editText.setLayoutParams(params);


        editText.setText("");

        updateRealizedRole(role, false);
        InfoTab.updateListView();

        button.setVisibility(View.INVISIBLE);
    }

    public void setPosition(View view) {
        Intent intent = new Intent(this, selectPos.class);
        EditText positionField;
        TextView roleField;
        String position = "";
        String role;
        int posID;
        int roleID;
        String alignment;
        int constant;
        String[] player;

        switch (view.getId()) {
            case R.id.TIPos1:
                posID = R.id.TIPos1;
                alignment = "Town Investigative";
                roleID = R.id.TIField1;
                constant = TI_POS_1;
                break;
            case R.id.TIPos2:
                posID = R.id.TIPos2;
                alignment = "Town Investigative";
                roleID = R.id.TIField2;
                constant = TI_POS_2;
                break;
            case R.id.TSPos1:
                posID = R.id.TSPos1;
                alignment = "Town Support";
                roleID = R.id.TSField1;
                constant = TS_POS_1;
                break;
            case R.id.TSPos2:
                posID = R.id.TSPos2;
                alignment = "Town Support";
                roleID = R.id.TSField2;
                constant = TS_POS_2;
                break;
            case R.id.TPPos:
                posID = R.id.TPPos;
                alignment = "Town Protective";
                roleID = R.id.TPField;
                constant = TP_POS;
                break;
            case R.id.TKPos:
                posID = R.id.TKPos;
                alignment = "Town Killing";
                roleID = R.id.TKField;
                constant = TK_POS;
                break;
            case R.id.RTPos:
                posID = R.id.RTPos;
                alignment = "Random Town";
                roleID = R.id.RTField;
                constant = RT_POS;
                break;
            case R.id.GFPos:
                posID = R.id.GFPos;
                alignment = "Mafia Killing";
                roleID = R.id.GFTitle;
                constant = GF_POS;
                break;
            case R.id.MafPos:
                posID = R.id.MafPos;
                alignment = "Mafia Killing";
                roleID = R.id.MafTitle;
                constant = MAF_POS;
                break;
            case R.id.RMPos:
                posID = R.id.RMPos;
                alignment = "Random Mafia";
                roleID = R.id.RMField;
                constant = RM_POS;
                break;
            case R.id.NKPos:
                posID = R.id.NKPos;
                alignment = "Neutral Killing";
                roleID = R.id.NKField;
                constant = NK_POS;
                break;
            case R.id.NEPos:
                posID = R.id.NEPos;
                alignment = "Neutral Evil";
                roleID = R.id.NEField;
                constant = NE_POS;
                break;
            case R.id.NBPos:
                posID = R.id.NBPos;
                alignment = "Neutral Benign";
                roleID = R.id.NBField;
                constant = NB_POS;
                break;
            case R.id.AnyPos:
                posID = R.id.AnyPos;
                alignment = "Any";
                roleID = R.id.AnyField;
                constant = ANY_POS;
                break;
            default:// R.id.jailorPos:
                posID = R.id.jailorPos;
                alignment = "Town Killing";
                roleID = R.id.jailorTitle;
                constant = JAILOR_POS;
                break;
        }
        positionField = (EditText) findViewById(posID);
        roleField = (TextView) findViewById(roleID);
        if (positionField.getText().toString().length() > 0)
            position = positionField.getText().toString();
        role = decodeRole(roleField.getText().toString());
        player = new String[]{alignment, position, role};
        intent.putExtra("player", player);
        startActivityForResult(intent, constant);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String roleOrPosition = null;
        String prevRole;
        String prevPos;
        if (data != null)
            roleOrPosition = data.getStringExtra("selection");
        if (resultCode == RESULT_OK && roleOrPosition != null) {
            EditText textField;
            EditText positionField;
            View statusBox;
            Button button;
            int fieldID = -1;
            int buttonID = -1;
            int positionID = -1;
            int statusID = -1;
            boolean guaranteedRole = false;

            if (!confTipShown) {
                confTipShown = true;
                displayToast("Tap the alignment to confirm this Player / Role!");
            }

            switch (requestCode) {
                case TI_REQUEST_1:
                case TI_POS_1:
                    statusID = R.id.TIStatus1;
                    positionID = R.id.TIPos1;
                    fieldID = (R.id.TIField1);
                    buttonID = (R.id.buttonTIField1);
                    break;
                case TI_REQUEST_2:
                case TI_POS_2:
                    statusID = R.id.TIStatus2;
                    positionID = R.id.TIPos2;
                    fieldID = (R.id.TIField2);
                    buttonID = (R.id.buttonTIField2);
                    break;
                case TS_REQUEST_1:
                case TS_POS_1:
                    statusID = R.id.TSStatus1;
                    positionID = R.id.TSPos1;
                    fieldID = (R.id.TSField1);
                    buttonID = (R.id.buttonTSField1);
                    break;
                case TS_REQUEST_2:
                case TS_POS_2:
                    statusID = R.id.TSStatus2;
                    positionID = R.id.TSPos2;
                    fieldID = (R.id.TSField2);
                    buttonID = (R.id.buttonTSField2);
                    break;
                case TP_REQUEST:
                case TP_POS:
                    statusID = R.id.TPStatus;
                    positionID = R.id.TPPos;
                    fieldID = (R.id.TPField);
                    buttonID = (R.id.buttonTPField);
                    break;
                case TK_REQUEST:
                case TK_POS:
                    statusID = R.id.TKStatus;
                    positionID = R.id.TKPos;
                    fieldID = (R.id.TKField);
                    buttonID = (R.id.buttonTKField);
                    break;
                case RT_REQUEST:
                case RT_POS:
                    statusID = R.id.RTStatus;
                    positionID = R.id.RTPos;
                    fieldID = (R.id.RTField);
                    buttonID = (R.id.buttonRTField);
                    break;
                case RM_REQUEST:
                case RM_POS:
                    statusID = R.id.RMStatus;
                    positionID = R.id.RMPos;
                    fieldID = (R.id.RMField);
                    buttonID = (R.id.buttonRMField);
                    break;
                case NK_REQUEST:
                case NK_POS:
                    statusID = R.id.NKStatus;
                    positionID = R.id.NKPos;
                    fieldID = (R.id.NKField);
                    buttonID = (R.id.buttonNKField);
                    break;
                case NE_REQUEST:
                case NE_POS:
                    statusID = R.id.NEStatus;
                    positionID = R.id.NEPos;
                    fieldID = (R.id.NEField);
                    buttonID = (R.id.buttonNEField);
                    break;
                case NB_REQUEST:
                case NB_POS:
                    statusID = R.id.NBStatus;
                    positionID = R.id.NBPos;
                    fieldID = (R.id.NBField);
                    buttonID = (R.id.buttonNBField);
                    break;
                case ANY_REQUEST: // ANY_REQUEST
                case ANY_POS:
                    statusID = R.id.AnyStatus;
                    positionID = R.id.AnyPos;
                    fieldID = (R.id.AnyField);
                    buttonID = (R.id.buttonAnyField);
                    break;
                case GF_POS:
                    statusID = R.id.GFStatus;
                    positionID = R.id.GFPos;
                    guaranteedRole = true;
                    break;
                case MAF_POS:
                    statusID = R.id.MafStatus;
                    positionID = R.id.MafPos;
                    guaranteedRole = true;
                    break;
                case JAILOR_POS:
                    statusID = R.id.jailorStatus;
                    positionID = R.id.jailorPos;
                    guaranteedRole = true;
                    break;
            }

            positionField = (EditText) findViewById(positionID);

            // If it is a role request
            if (requestCode <= 12 && !guaranteedRole) {
                textField = (EditText) findViewById(fieldID);
                button = (Button) findViewById(buttonID);

                prevRole = decodeRole(textField.getText().toString());

                // If selection is a unique role that is not already present
                if (isUnique(roleOrPosition) && !prevRole.equals(roleOrPosition)) {
                    if (!isAvailableUnique(roleOrPosition)) {
                        String message = "The " + roleOrPosition + " is a unique role and is already present!";
                        Toast toast = Toast.makeText(mainPage.this, message, Toast.LENGTH_LONG);
                        TextView view = (TextView) toast.getView().findViewById(android.R.id.message);
                        if (view != null) {
                            view.setGravity(Gravity.CENTER);
                        }
                        toast.show();
                        return;
                    }
                }

                statusBox = findViewById(statusID);
                if (prevRole.length() != 0) {
                    updateRealizedRole(prevRole, false);

                    // If player is confirmed but a role was swapped
                    if (statusBox.getVisibility() == View.VISIBLE) {
                        updateConfirmedRole(prevRole, false);
                        updateConfirmedRole(roleOrPosition, true);
                    }

                } else {
                    // If player is confirmed but a role was just entered
                    if (statusBox.getVisibility() == View.VISIBLE)
                        updateConfirmedRole(roleOrPosition, true);
                }

                resizeText(textField, roleOrPosition);

                // Adjusting to the left of the delete button
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) findViewById(fieldID).getLayoutParams();
                params.addRule(RelativeLayout.LEFT_OF, buttonID);
                textField.setLayoutParams(params);

                // Increment role's count
                updateRealizedRole(roleOrPosition, true);

                InfoTab.updateListView();

                roleOrPosition = encodeRole(roleOrPosition);
                textField.setText(roleOrPosition);
                textField.setTextColor(ContextCompat.getColor(getApplicationContext(), roleColors.get(decodeRole(roleOrPosition))));
                button.setVisibility(View.VISIBLE);
            } else { // If it is a position request{
                prevPos = positionField.getText().toString();

                // If delete request
                if (roleOrPosition.equals("delete")) {
                    // Update confirmed status
                    if (guaranteedRole) {
                        statusBox = findViewById(statusID);
                        statusBox.setVisibility(View.INVISIBLE);
                        switch (statusID) {
                            case R.id.jailorStatus:
                                updateConfirmedRole("Jailor", false);
                                break;
                            case R.id.GFStatus:
                                updateConfirmedRole("Godfather", false);
                                break;
                            case R.id.MafStatus:
                                updateConfirmedRole("Mafioso", false);
                                break;
                        }
                        InfoTab.updateListView();

                    } else {
                        textField = (EditText) findViewById(fieldID);
                        String role = decodeRole(textField.getText().toString());
                        if (role.length() == 0) {
                            statusBox = findViewById(statusID);
                            statusBox.setVisibility(View.INVISIBLE);
                        }
                    }
                    positionField.setText("");
                    updateRemainingPos(prevPos, false);
                } else {
                    if (prevPos.length() != 0) {
                        // Reset previous position
                        updateRemainingPos(prevPos, false);
                    }
                    positionField.setText(roleOrPosition);
                    updateRemainingPos(roleOrPosition, true);
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
        String alignment = "";
        String pos;
        String roleText;

        switch (view.getId()) {
            case (R.id.jailorTitleGroup):
                statusID = R.id.jailorStatus;
                posID = R.id.jailorPos;
                alignment = "jailor";
                break;
            case (R.id.TITitleGroup1):
                statusID = R.id.TIStatus1;
                posID = R.id.TIPos1;
                fieldID = R.id.TIField1;
                alignment = "TI1";
                break;
            case (R.id.TITitleGroup2):
                statusID = R.id.TIStatus2;
                posID = R.id.TIPos2;
                fieldID = R.id.TIField2;
                alignment = "TI2";
                break;
            case (R.id.TSTitleGroup1):
                statusID = R.id.TSStatus1;
                posID = R.id.TSPos1;
                fieldID = R.id.TSField1;
                alignment = "TS1";
                break;
            case (R.id.TSTitleGroup2):
                statusID = R.id.TSStatus2;
                posID = R.id.TSPos2;
                fieldID = R.id.TSField2;
                alignment = "TS2";
                break;
            case (R.id.TPTitleGroup):
                statusID = R.id.TPStatus;
                posID = R.id.TPPos;
                fieldID = R.id.TPField;
                alignment = "TP";
                break;
            case (R.id.TKTitleGroup):
                statusID = R.id.TKStatus;
                posID = R.id.TKPos;
                fieldID = R.id.TKField;
                alignment = "TK";
                break;
            case (R.id.RTTitleGroup):
                statusID = R.id.RTStatus;
                posID = R.id.RTPos;
                fieldID = R.id.RTField;
                alignment = "RT";
                break;
            case (R.id.GFTitleGroup):
                statusID = R.id.GFStatus;
                posID = R.id.GFPos;
                alignment = "GF";
                break;
            case (R.id.MafTitleGroup):
                statusID = R.id.MafStatus;
                posID = R.id.MafPos;
                alignment = "Maf";
                break;
            case (R.id.RMTitleGroup):
                statusID = R.id.RMStatus;
                posID = R.id.RMPos;
                fieldID = R.id.RMField;
                alignment = "RM";
                break;
            case (R.id.NKTitleGroup):
                statusID = R.id.NKStatus;
                posID = R.id.NKPos;
                fieldID = R.id.NKField;
                alignment = "NK";
                break;
            case (R.id.NETitleGroup):
                statusID = R.id.NEStatus;
                posID = R.id.NEPos;
                fieldID = R.id.NEField;
                alignment = "NE";
                break;
            case (R.id.NBTitleGroup):
                statusID = R.id.NBStatus;
                posID = R.id.NBPos;
                fieldID = R.id.NBField;
                alignment = "NB";
                break;
            case (R.id.AnyTitleGroup):
                statusID = R.id.AnyStatus;
                posID = R.id.AnyPos;
                fieldID = R.id.AnyField;
                alignment = "Any";
                break;
        }
        position = (EditText) findViewById(posID);
        role = (EditText) findViewById(fieldID);
        statusBox = findViewById(statusID);

        pos = position.getText().toString();

        // If guaranteed role and there is no position
        if (alignment.equals("jailor") || alignment.equals("GF") || alignment.equals("Maf")) {
            if (pos.length() == 0) {
                displayToast("Please select the Position before you confirm a guaranteed role!");
                return;
            }
        } else {
            // If there is no position or role
            roleText = decodeRole(role.getText().toString());
            if (pos.length() == 0 && roleText.length() == 0) {
                displayToast("Please select the Position / Role before you confirm!");
                return;
            }
        }

        // Toggle status
        confirmedAlignments.put(alignment, !confirmedAlignments.get(alignment));

        // Toggle to not confirmed
        if (statusBox.getVisibility() == View.VISIBLE) {
            statusBox.setVisibility(View.INVISIBLE);

            switch (statusID) {
                case R.id.jailorStatus:
                    updateConfirmedRole("Jailor", false);
                    break;
                case R.id.GFStatus:
                    updateConfirmedRole("Godfather", false);
                    break;
                case R.id.MafStatus:
                    updateConfirmedRole("Mafioso", false);
                    break;
                default:
                    roleText = decodeRole(role.getText().toString());
                    if (roleText.length() != 0)
                        updateConfirmedRole(roleText, false);
            }

            if (pos.length() > 0)
                updatePlayerPos(pos, false);
        }
        // Toggle to confirmed
        else {
            statusBox.setVisibility(View.VISIBLE);

            switch (statusID) {
                case R.id.jailorStatus:
                    updateConfirmedRole("Jailor", true);
                    break;
                case R.id.GFStatus:
                    updateConfirmedRole("Godfather", true);
                    break;
                case R.id.MafStatus:
                    updateConfirmedRole("Mafioso", true);
                    break;
                default:
                    roleText = decodeRole(role.getText().toString());
                    if (roleText.length() != 0)
                        updateConfirmedRole(roleText, true);
            }

            if (pos.length() > 0)
                updatePlayerPos(pos, true);
        }
        InfoTab.updateListView();
    }


    private String encodeRole(String role) {
        switch (role) {
            case "Vampire Hunter":
                return "Vamp Hunter";
            default:
                return role;
        }
    }

    private String decodeRole(String role) {
        switch (role) {
            case "Vamp Hunter":
                return "Vampire Hunter";
            default:
                return role;
        }
    }

    protected static void resizeText(EditText field, String role) {
        if (role.length() >= 10)
            field.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        else
            field.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
    }


    private boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        String message = "Please press BACK again to exit Ranked Mode";
        Toast toast = Toast.makeText(mainPage.this, message, Toast.LENGTH_LONG);
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

    protected static boolean isUnique(String role) {
        return role.equals("Mayor") || role.equals("Retributionist") || role.equals("Veteran") || role.equals("Werewolf");
    }

    protected static boolean isAvailableUnique(String role) {
        return realizedRoles.get(role) == 0;
    }

    protected static void updateRealizedRole(String role, boolean status) {
        if (status)
            realizedRoles.put(role, realizedRoles.get(role) + 1);
        else
            realizedRoles.put(role, realizedRoles.get(role) - 1);
    }

    protected static void updateConfirmedRole(String role, boolean status) {
        if (status)
            confirmedRoles.put(role, confirmedRoles.get(role) + 1);
        else
            confirmedRoles.put(role, confirmedRoles.get(role) - 1);
    }

    private void updatePlayerPos(String pos, boolean status) {
        int position = Integer.parseInt(pos);
        confirmedPlayers.put(position, status);
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


    private void displayToast(String message) {
        Toast toast = Toast.makeText(mainPage.this, message, Toast.LENGTH_LONG);
        TextView look = (TextView) toast.getView().findViewById(android.R.id.message);
        if (look != null) {
            look.setGravity(Gravity.CENTER);
        }
        toast.show();
    }

    private void resetStates() {
        confTipShown = false;
        remainingPositions.clear();
        for (int i = 1; i <= 15; i++) {
            remainingPositions.add(i);
        }

        for (Map.Entry<String, Integer> entry : realizedRoles.entrySet()) {
            realizedRoles.put(entry.getKey(), 0);
            confirmedRoles.put(entry.getKey(), 0);
        }
    }

}

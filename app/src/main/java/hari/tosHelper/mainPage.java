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
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import hari.tosHelper.infoTab.OnInfoTabListener;
import hotchemi.android.rate.BuildConfig;

public class mainPage extends AppCompatActivity implements OnInfoTabListener {
    protected static final HashMap<String, Integer> alignmentBackground = new HashMap<String, Integer>() {
        {
            put("Town Investigative", R.color.town);
            put("Town Support", R.color.town);
            put("Town Protective", R.color.town);
            put("Town Killing", R.color.town);
            put("Random Town", R.color.town);
            put("Mafia Killing", R.color.mafia);
            put("Random Mafia", R.color.mafia);
            put("Mafia Support", R.color.mafia);
            put("Mafia Deception", R.color.mafia);
            put("Neutral Killing", R.color.neutral);
            put("Neutral Evil", R.color.neutral);
            put("Neutral Benign", R.color.neutral);
            put("Any", R.color.white);
            put("Neutral Chaos", R.color.neutral);
            put("Random Neutral", R.color.neutral);
            put("Coven Evil", R.color.coven);
            put("Random Coven", R.color.coven);
        }
    };
    protected static final HashMap<String, Integer> alignmentColors = new HashMap<String, Integer>() {
        {
            put("Town Investigative", R.color.townText);
            put("Town Support", R.color.townText);
            put("Town Protective", R.color.townText);
            put("Town Killing", R.color.townText);
            put("Random Town", R.color.townText);
            put("Mafia Killing", R.color.mafiaText);
            put("Random Mafia", R.color.mafiaText);
            put("Mafia Support", R.color.mafiaText);
            put("Mafia Deception", R.color.mafiaText);
            put("Neutral Killing", R.color.exeText);
            put("Neutral Evil", R.color.exeText);
            put("Neutral Benign", R.color.exeText);
            put("Any", R.color.black);
            put("Neutral Chaos", R.color.exeText);
            put("Random Neutral", R.color.exeText);
        }
    };
    protected static final HashMap<String, Integer> roleBackground = new HashMap<String, Integer>() {
        {
            put("Jailor", R.color.town);
            put("Investigator", R.color.town);
            put("Lookout", R.color.town);
            put("Sheriff", R.color.town);
            put("Spy", R.color.town);
            put("Escort", R.color.town);
            put("Mayor", R.color.town);
            put("Medium", R.color.town);
            put("Retributionist", R.color.town);
            put("Transporter", R.color.town);
            put("Bodyguard", R.color.town);
            put("Doctor", R.color.town);
            put("Vampire Hunter", R.color.town);
            put("Veteran", R.color.town);
            put("Vigilante", R.color.town);
            put("Godfather", R.color.mafia);
            put("Mafioso", R.color.mafia);
            put("Blackmailer", R.color.mafia);
            put("Consigliere", R.color.mafia);
            put("Consort", R.color.mafia);
            put("Disguiser", R.color.mafia);
            put("Forger", R.color.mafia);
            put("Framer", R.color.mafia);
            put("Janitor", R.color.mafia);
            put("Arsonist", R.color.neutral);
            put("Serial Killer", R.color.neutral);
            put("Werewolf", R.color.neutral);
            put("Executioner", R.color.neutral);
            put("Jester", R.color.neutral);
            put("Witch", R.color.neutral);
            put("Amnesiac", R.color.neutral);
            put("Survivor", R.color.neutral);
            put("Vampire", R.color.neutral);

            put("Coven Leader", R.color.coven);
            put("Hex Master", R.color.coven);
            put("Poisoner", R.color.coven);
            put("Potion Master", R.color.coven);
            put("Medusa", R.color.coven);
            put("Necromancer", R.color.coven);
            put("Ambusher", R.color.mafia);
            put("Hypnotist", R.color.mafia);
            put("Guardian Angel", R.color.neutral);
            put("Pirate", R.color.neutral);
            put("Psychic", R.color.town);
            put("Crusader", R.color.town);
            put("Tracker", R.color.town);
            put("Trapper", R.color.town);
            put("Plaguebearer", R.color.neutral);
            put("Pestilence", R.color.neutral);
            put("Juggernaut", R.color.neutral);
        }
    };
    protected static final HashMap<String, Integer> roleColors = new HashMap<String, Integer>() {
        {
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

            put("Psychic", R.color.townText);
            put("Tracker", R.color.townText);
            put("Crusader", R.color.townText);
            put("Trapper", R.color.townText);

            put("Godfather", R.color.mafiaText);
            put("Mafioso", R.color.mafiaText);
            put("Mafia", R.color.mafiaText);
            put("Blackmailer", R.color.mafiaText);
            put("Consigliere", R.color.mafiaText);
            put("Consort", R.color.mafiaText);
            put("Disguiser", R.color.mafiaText);
            put("Forger", R.color.mafiaText);
            put("Framer", R.color.mafiaText);
            put("Janitor", R.color.mafiaText);

            put("Coven Leader", R.color.covenText);
            put("Hex Master", R.color.covenText);
            put("Poisoner", R.color.covenText);
            put("Potion Master", R.color.covenText);
            put("Medusa", R.color.covenText);
            put("Necromancer", R.color.covenText);
            put("Arsonist", R.color.arsonistText);
            put("Serial Killer", R.color.skText);
            put("Werewolf", R.color.wwText);
            put("Executioner", R.color.exeText);
            put("Jester", R.color.jesterText);
            put("Witch", R.color.witchText);
            put("Amnesiac", R.color.amneText);
            put("Survivor", R.color.survivorText);
            put("Vampire", R.color.exeText);

            put("Ambusher", R.color.mafiaText);
            put("Hypnotist", R.color.mafiaText);
            put("Guardian Angel", R.color.white);
            put("Pirate", R.color.pirateText);
            put("Crusader", R.color.townText);
            put("Tracker", R.color.townText);
            put("Trapper", R.color.townText);
            put("Plaguebearer", R.color.plaguebearerText);
            put("Pestilence", R.color.pestilenceText);
            put("Juggernaut", R.color.juggernautText);
        }
    };
    private static final int ANY_POS = 26;
    private static final int ANY_REQUEST = 12;
    private static final int GF_POS = 20;
    private static final int JAILOR_POS = 27;
    private static final int MAF_POS = 21;
    private static final int NB_POS = 25;
    private static final int NB_REQUEST = 11;
    private static final int NE_POS = 24;
    private static final int NE_REQUEST = 10;
    private static final int NK_POS = 23;
    private static final int NK_REQUEST = 9;
    private static final int RM_POS = 22;
    private static final int RM_REQUEST = 8;
    private static final int RT_POS = 19;
    private static final int RT_REQUEST = 7;
    private static final int TI_POS_1 = 13;
    private static final int TI_POS_2 = 14;
    private static final int TI_REQUEST_1 = 1;
    private static final int TI_REQUEST_2 = 2;
    private static final int TK_POS = 18;
    private static final int TK_REQUEST = 6;
    private static final int TP_POS = 17;
    private static final int TP_REQUEST = 5;
    private static final int TS_POS_1 = 15;
    private static final int TS_POS_2 = 16;
    private static final int TS_REQUEST_1 = 3;
    private static final int TS_REQUEST_2 = 4;
    protected static HashMap<String, Boolean> confirmedAlignments = new HashMap<String, Boolean>() {
        {
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
        }
    };
    protected static SparseBooleanArray confirmedPlayers = new SparseBooleanArray() {
        {
            put(mainPage.TI_REQUEST_1, false);
            put(mainPage.TI_REQUEST_2, false);
            put(mainPage.TS_REQUEST_1, false);
            put(mainPage.TS_REQUEST_2, false);
            put(mainPage.TP_REQUEST, false);
            put(mainPage.TK_REQUEST, false);
            put(mainPage.RT_REQUEST, false);
            put(mainPage.RM_REQUEST, false);
            put(mainPage.NK_REQUEST, false);
            put(mainPage.NE_REQUEST, false);
            put(mainPage.NB_REQUEST, false);
            put(mainPage.ANY_REQUEST, false);
            put(mainPage.TI_POS_1, false);
            put(mainPage.TI_POS_2, false);
            put(mainPage.TS_POS_1, false);
        }
    };
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
            put("Witch", 0);
            put("Amnesiac", 0);
            put("Survivor", 0);
            put("Vampire", 0);
        }
    };
    protected static HashMap<String, String> correspondingAllignment = new HashMap<String, String>() {
        {
            put("Sheriff", "Town Investigative");
            put("Doctor", "Town Protective");
            put("Investigator", "Town Investigative");
            put("Jailor", "Town Killing");
            put("Medium", "Town Support");
            put("Executioner", "Neutral Evil");
            put("Escort", "Town Support");
            put("Lookout", "Town Investigative");
            put("Serial Killer", "Neutral Killing");
            put("Veteran", "Town Killing");
            put("Vigilante", "Town Killing");
            put("Jester", "Neutral Evil");
            put("Bodyguard", "Town Protective");
            put("Mayor", "Town Support");
            put("Retributionist", "Town Support");
            put("Spy", "Town Investigative");
            put("Transporter", "Town Support");
            put("Vampire Hunter", "Town Killing");
            put("Blackmailer", "Mafia Support");
            put("Consigliere", "Mafia Support");
            put("Consort", "Mafia Support");
            put("Disguiser", "Mafia Deception");
            put("Forger", "Mafia Deception");
            put("Framer", "Mafia Deception");
            put("Godfather", "Mafia Killing");
            put("Janitor", "Mafia Deception");
            put("Mafioso", "Mafia Killing");
            put("Arsonist", "Neutral Killing");
            put("Werewolf", "Neutral Killing");
            put("Witch", "Neutral Evil");
            put("Amnesiac", "Neutral Benign");
            put("Survivor", "Neutral Benign");
            put("Vampire", "Neutral Chaos");

            put("Coven Leader", "Coven Evil");
            put("Hex Master", "Coven Evil");
            put("Poisoner", "Coven Evil");
            put("Potion Master", "Coven Evil");
            put("Medusa", "Coven Evil");
            put("Necromancer", "Coven Evil");
            put("Ambusher", "Mafia Killing");
            put("Hypnotist", "Mafia Deception");
            put("Guardian Angel", "Neutral Bening");
            put("Pirate", "Neutral Chaos");
            put("Crusader", "Town Protective");
            put("Tracker", "Town Investigative");
            put("Trapper", "Town Protective");
            put("Plaguebearer", "Neutral Chaos");
            put("Pestilence", "Neutral Chaos");
            put("Juggernaut", "Neutral Killing");
        }
    };
    protected static HashMap<String, Integer> realizedRoles = new HashMap<String, Integer>() {
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
    static int standardHeight;
    static int standardTitleHeight;
    private static boolean confTipShown = false;
    protected CustomAdapter adapter;
    overviewTab OverviewTab;
    Toast toast;
    private infoTab InfoTab;
    private boolean doubleBackToExitPressedOnce = false;
    private ViewPager viewPager;

    static String decodeRole(String role) {
        switch (role) {
            case "Vamp Hunter" /*0*/:
                return "Vampire Hunter";
            default:
                return role;
        }
    }

    protected static void resizeText(EditText field, String role) {
        if (role.length() >= NE_REQUEST) {
            field.setTextSize(TI_REQUEST_2, 18.0f);
        } else {
            field.setTextSize(TI_REQUEST_2, 20.0f);
        }
    }

    protected static boolean isUnique(String role) {
        return role.equals("Mayor") || role.equals("Retributionist") || role.equals("Veteran") || role.equals("Werewolf");
    }

    protected static boolean isAvailableUnique(String role) {
        return realizedRoles.get(role) == 0;
    }

    protected static void updateRealizedRole(String role, boolean status) {
        if (status) {
            realizedRoles.put(role, realizedRoles.get(role) + 1);
        } else {
            realizedRoles.put(role, realizedRoles.get(role) - 1);
        }
    }

    protected static void updateConfirmedRole(String role, boolean status) {
        if (status) {
            confirmedRoles.put(role, confirmedRoles.get(role) + 1);
        } else {
            confirmedRoles.put(role, confirmedRoles.get(role) - 1);
        }
    }

    protected static void updatePlayerRole(int position, String role) {
        overviewTab.allPlayerRoles[position - 1] = decodeRole(role);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.toast = Toast.makeText(getBaseContext(), BuildConfig.VERSION_NAME, Toast.LENGTH_LONG);
        displayToast("Don't forget to input your role!");
        setContentView(R.layout.activity_main_page);
        resetStates();
        this.viewPager = findViewById(R.id.viewPager);
        this.viewPager.setOffscreenPageLimit(TI_REQUEST_2);
        this.adapter = new CustomAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageSelected(int position) {
            }

            public void onPageScrollStateChanged(int state) {
                if (state == 0 && mainPage.this.viewPager.getCurrentItem() != 0) {
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mainPage.this.viewPager.getWindowToken(), 0);
                    View current = mainPage.this.getCurrentFocus();
                    if (current != null) {
                        current.clearFocus();
                    }
                }
            }

            public void onPageScrolled(int position, float offset, int offsetPixels) {
            }
        });
        TabLayout tablayout = findViewById(R.id.tabLayout);
        tablayout.setupWithViewPager(this.viewPager);
        tablayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            public void onTabSelected(Tab tab) {
                mainPage.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(Tab tab) {
                mainPage.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabReselected(Tab tab) {
                mainPage.this.viewPager.setCurrentItem(tab.getPosition());
            }
        });
        this.viewPager.setCurrentItem(TI_REQUEST_1);
    }

    public void onRoleSelected(String role, int position) {
        Intent intent = new Intent(this, Role_Information.class);
        intent.putExtra("selection", role);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    public void fetchRole(View view) {
        switch (view.getId()) {
            case R.id.TIField1 /*2131558783*/:
                startActivityForResult(new Intent(this, TI.class), TI_REQUEST_1);
                return;
            case R.id.TIField2 /*2131558785*/:
                startActivityForResult(new Intent(this, TI.class), TI_REQUEST_2);
                return;
            case R.id.TSField1 /*2131558788*/:
                startActivityForResult(new Intent(this, TS.class), TS_REQUEST_1);
                return;
            case R.id.TSField2 /*2131558790*/:
                startActivityForResult(new Intent(this, TS.class), TS_REQUEST_2);
                return;
            case R.id.TPField /*2131558792*/:
                startActivityForResult(new Intent(this, TP.class), TP_REQUEST);
                return;
            case R.id.TKField /*2131558794*/:
                startActivityForResult(new Intent(this, TK.class), TK_REQUEST);
                return;
            case R.id.RTField /*2131558796*/:
                startActivityForResult(new Intent(this, RT.class), RT_REQUEST);
                return;
            case R.id.RMField /*2131558798*/:
                startActivityForResult(new Intent(this, RM.class), RM_REQUEST);
                return;
            case R.id.NKField /*2131558800*/:
                startActivityForResult(new Intent(this, NK.class), NK_REQUEST);
                return;
            case R.id.NEField /*2131558802*/:
                startActivityForResult(new Intent(this, NE.class), NE_REQUEST);
                return;
            case R.id.NBField /*2131558804*/:
                startActivityForResult(new Intent(this, NB.class), NB_REQUEST);
                return;
            case R.id.AnyField /*2131558806*/:
                startActivityForResult(new Intent(this, Any.class), ANY_REQUEST);
                return;
            default:
        }
    }

    public void deleteRole(View view) {
        int fieldID = -1;
        int buttonID = -1;
        int statusID = -1;
        int posID = -1;
        switch (view.getId()) {
            case R.id.buttonTIField1 /*2131558782*/:
                posID = R.id.TIPos1;
                statusID = R.id.TIStatus1;
                fieldID = R.id.TIField1;
                buttonID = R.id.buttonTIField1;
                break;
            case R.id.buttonTIField2 /*2131558784*/:
                posID = R.id.TIPos2;
                statusID = R.id.TIStatus2;
                fieldID = R.id.TIField2;
                buttonID = R.id.buttonTIField2;
                break;
            case R.id.buttonTSField1 /*2131558787*/:
                posID = R.id.TSPos1;
                statusID = R.id.TSStatus1;
                fieldID = R.id.TSField1;
                buttonID = R.id.buttonTSField1;
                break;
            case R.id.buttonTSField2 /*2131558789*/:
                posID = R.id.TSPos2;
                statusID = R.id.TSStatus2;
                fieldID = R.id.TSField2;
                buttonID = R.id.buttonTSField2;
                break;
            case R.id.buttonTPField /*2131558791*/:
                posID = R.id.TPPos;
                statusID = R.id.TPStatus;
                fieldID = R.id.TPField;
                buttonID = R.id.buttonTPField;
                break;
            case R.id.buttonTKField /*2131558793*/:
                posID = R.id.TKPos;
                statusID = R.id.TKStatus;
                fieldID = R.id.TKField;
                buttonID = R.id.buttonTKField;
                break;
            case R.id.buttonRTField /*2131558795*/:
                posID = R.id.RTPos;
                statusID = R.id.RTStatus;
                fieldID = R.id.RTField;
                buttonID = R.id.buttonRTField;
                break;
            case R.id.buttonRMField /*2131558797*/:
                posID = R.id.RMPos;
                statusID = R.id.RMStatus;
                fieldID = R.id.RMField;
                buttonID = R.id.buttonRMField;
                break;
            case R.id.buttonNKField /*2131558799*/:
                posID = R.id.NKPos;
                statusID = R.id.NKStatus;
                fieldID = R.id.NKField;
                buttonID = R.id.buttonNKField;
                break;
            case R.id.buttonNEField /*2131558801*/:
                posID = R.id.NEPos;
                statusID = R.id.NEStatus;
                fieldID = R.id.NEField;
                buttonID = R.id.buttonNEField;
                break;
            case R.id.buttonNBField /*2131558803*/:
                posID = R.id.NBPos;
                statusID = R.id.NBStatus;
                fieldID = R.id.NBField;
                buttonID = R.id.buttonNBField;
                break;
            case R.id.buttonAnyField /*2131558805*/:
                posID = R.id.AnyPos;
                statusID = R.id.AnyStatus;
                fieldID = R.id.AnyField;
                buttonID = R.id.buttonAnyField;
                break;
        }
        EditText editText = findViewById(fieldID);
        Button button = findViewById(buttonID);
        String pos = ((EditText) findViewById(posID)).getText().toString();
        String role = decodeRole(editText.getText().toString());
        View statusBox = findViewById(statusID);
        if (statusBox.getVisibility() == View.VISIBLE) {
            updateConfirmedRole(role, false);
            if (pos.length() == 0) {
                statusBox.setVisibility(View.INVISIBLE);
            }
            this.InfoTab.updateListView();
        }
        LayoutParams params = (LayoutParams) findViewById(fieldID).getLayoutParams();
        params.addRule(0, 0);
        editText.setLayoutParams(params);
        editText.setText(BuildConfig.VERSION_NAME);
        updateRealizedRole(role, false);
        this.InfoTab.updateListView();
        button.setVisibility(View.INVISIBLE);
        if (pos.length() != 0) {
            updatePlayerRole(Integer.parseInt(pos), BuildConfig.VERSION_NAME);
            this.OverviewTab.updateListView();
        }
    }

    public void setPosition(View view) {
        int posID;
        String alignment;
        int roleID;
        int constant;
        Intent intent = new Intent(this, selectPos.class);
        String position = BuildConfig.VERSION_NAME;
        switch (view.getId()) {
            case R.id.TIPos1 /*2131558767*/:
                posID = R.id.TIPos1;
                alignment = "Town Investigative";
                roleID = R.id.TIField1;
                constant = TI_POS_1;
                break;
            case R.id.TIPos2 /*2131558768*/:
                posID = R.id.TIPos2;
                alignment = "Town Investigative";
                roleID = R.id.TIField2;
                constant = TI_POS_2;
                break;
            case R.id.TSPos1 /*2131558769*/:
                posID = R.id.TSPos1;
                alignment = "Town Support";
                roleID = R.id.TSField1;
                constant = TS_POS_1;
                break;
            case R.id.TSPos2 /*2131558770*/:
                posID = R.id.TSPos2;
                alignment = "Town Support";
                roleID = R.id.TSField2;
                constant = TS_POS_2;
                break;
            case R.id.TPPos /*2131558771*/:
                posID = R.id.TPPos;
                alignment = "Town Protective";
                roleID = R.id.TPField;
                constant = TP_POS;
                break;
            case R.id.TKPos /*2131558772*/:
                posID = R.id.TKPos;
                alignment = "Town Killing";
                roleID = R.id.TKField;
                constant = TK_POS;
                break;
            case R.id.RTPos /*2131558773*/:
                posID = R.id.RTPos;
                alignment = "Random Town";
                roleID = R.id.RTField;
                constant = RT_POS;
                break;
            case R.id.GFPos /*2131558774*/:
                posID = R.id.GFPos;
                alignment = "Mafia Killing";
                roleID = R.id.GFTitle;
                constant = GF_POS;
                break;
            case R.id.MafPos /*2131558775*/:
                posID = R.id.MafPos;
                alignment = "Mafia Killing";
                roleID = R.id.MafTitle;
                constant = MAF_POS;
                break;
            case R.id.RMPos /*2131558776*/:
                posID = R.id.RMPos;
                alignment = "Random Mafia";
                roleID = R.id.RMField;
                constant = RM_POS;
                break;
            case R.id.NKPos /*2131558777*/:
                posID = R.id.NKPos;
                alignment = "Neutral Killing";
                roleID = R.id.NKField;
                constant = NK_POS;
                break;
            case R.id.NEPos /*2131558778*/:
                posID = R.id.NEPos;
                alignment = "Neutral Evil";
                roleID = R.id.NEField;
                constant = NE_POS;
                break;
            case R.id.NBPos /*2131558779*/:
                posID = R.id.NBPos;
                alignment = "Neutral Benign";
                roleID = R.id.NBField;
                constant = NB_POS;
                break;
            case R.id.AnyPos /*2131558780*/:
                posID = R.id.AnyPos;
                alignment = "Any";
                roleID = R.id.AnyField;
                constant = ANY_POS;
                break;
            default:
                posID = R.id.jailorPos;
                alignment = "Town Killing";
                roleID = R.id.jailorTitle;
                constant = JAILOR_POS;
                break;
        }
        EditText positionField = findViewById(posID);
        TextView roleField = findViewById(roleID);
        if (positionField.getText().toString().length() > 0) {
            position = positionField.getText().toString();
        }
        String role = decodeRole(roleField.getText().toString());
        String[] player = new String[TS_REQUEST_1];
        player[0] = alignment;
        player[TI_REQUEST_1] = position;
        player[TI_REQUEST_2] = role;
        intent.putExtra("player", player);
        startActivityForResult(intent, constant);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String roleOrPosition = null;
        if (data != null) {
            roleOrPosition = data.getStringExtra("selection");
        }
        if (resultCode == -1 && roleOrPosition != null) {
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
                case TI_REQUEST_1 /*1*/:
                case TI_POS_1 /*13*/:
                    statusID = R.id.TIStatus1;
                    positionID = R.id.TIPos1;
                    fieldID = R.id.TIField1;
                    buttonID = R.id.buttonTIField1;
                    break;
                case TI_REQUEST_2 /*2*/:
                case TI_POS_2 /*14*/:
                    statusID = R.id.TIStatus2;
                    positionID = R.id.TIPos2;
                    fieldID = R.id.TIField2;
                    buttonID = R.id.buttonTIField2;
                    break;
                case TS_REQUEST_1 /*3*/:
                case TS_POS_1 /*15*/:
                    statusID = R.id.TSStatus1;
                    positionID = R.id.TSPos1;
                    fieldID = R.id.TSField1;
                    buttonID = R.id.buttonTSField1;
                    break;
                case TS_REQUEST_2 /*4*/:
                case TS_POS_2 /*16*/:
                    statusID = R.id.TSStatus2;
                    positionID = R.id.TSPos2;
                    fieldID = R.id.TSField2;
                    buttonID = R.id.buttonTSField2;
                    break;
                case TP_REQUEST /*5*/:
                case TP_POS /*17*/:
                    statusID = R.id.TPStatus;
                    positionID = R.id.TPPos;
                    fieldID = R.id.TPField;
                    buttonID = R.id.buttonTPField;
                    break;
                case TK_REQUEST /*6*/:
                case TK_POS /*18*/:
                    statusID = R.id.TKStatus;
                    positionID = R.id.TKPos;
                    fieldID = R.id.TKField;
                    buttonID = R.id.buttonTKField;
                    break;
                case RT_REQUEST /*7*/:
                case RT_POS /*19*/:
                    statusID = R.id.RTStatus;
                    positionID = R.id.RTPos;
                    fieldID = R.id.RTField;
                    buttonID = R.id.buttonRTField;
                    break;
                case RM_REQUEST /*8*/:
                case RM_POS /*22*/:
                    statusID = R.id.RMStatus;
                    positionID = R.id.RMPos;
                    fieldID = R.id.RMField;
                    buttonID = R.id.buttonRMField;
                    break;
                case NK_REQUEST /*9*/:
                case NK_POS /*23*/:
                    statusID = R.id.NKStatus;
                    positionID = R.id.NKPos;
                    fieldID = R.id.NKField;
                    buttonID = R.id.buttonNKField;
                    break;
                case NE_REQUEST /*10*/:
                case NE_POS /*24*/:
                    statusID = R.id.NEStatus;
                    positionID = R.id.NEPos;
                    fieldID = R.id.NEField;
                    buttonID = R.id.buttonNEField;
                    break;
                case NB_REQUEST /*11*/:
                case NB_POS /*25*/:
                    statusID = R.id.NBStatus;
                    positionID = R.id.NBPos;
                    fieldID = R.id.NBField;
                    buttonID = R.id.buttonNBField;
                    break;
                case ANY_REQUEST /*12*/:
                case ANY_POS /*26*/:
                    statusID = R.id.AnyStatus;
                    positionID = R.id.AnyPos;
                    fieldID = R.id.AnyField;
                    buttonID = R.id.buttonAnyField;
                    break;
                case GF_POS /*20*/:
                    statusID = R.id.GFStatus;
                    positionID = R.id.GFPos;
                    guaranteedRole = true;
                    break;
                case MAF_POS /*21*/:
                    statusID = R.id.MafStatus;
                    positionID = R.id.MafPos;
                    guaranteedRole = true;
                    break;
                case JAILOR_POS /*27*/:
                    statusID = R.id.jailorStatus;
                    positionID = R.id.jailorPos;
                    guaranteedRole = true;
                    break;
            }
            EditText positionField = findViewById(positionID);
            if (requestCode <= ANY_REQUEST) {
                EditText textField = findViewById(fieldID);
                Button button = findViewById(buttonID);
                String prevRole = decodeRole(textField.getText().toString());
                if (!isUnique(roleOrPosition) || prevRole.equals(roleOrPosition) || isAvailableUnique(roleOrPosition)) {
                    View statusBox = findViewById(statusID);
                    if (prevRole.length() != 0) {
                        updateRealizedRole(prevRole, false);
                        if (statusBox.getVisibility() == View.VISIBLE) {
                            updateConfirmedRole(prevRole, false);
                            updateConfirmedRole(roleOrPosition, true);
                        }
                    } else if (statusBox.getVisibility() == View.VISIBLE) {
                        updateConfirmedRole(roleOrPosition, true);
                    }
                    if (positionField.getText().toString().length() != 0) {
                        updatePlayerRole(Integer.parseInt(positionField.getText().toString()), roleOrPosition);
                        this.OverviewTab.updateListView();
                    }
                    resizeText(textField, roleOrPosition);
                    LayoutParams params = (LayoutParams) findViewById(fieldID).getLayoutParams();
                    params.addRule(0, buttonID);
                    textField.setLayoutParams(params);
                    updateRealizedRole(roleOrPosition, true);
                    this.InfoTab.updateListView();
                    roleOrPosition = encodeRole(roleOrPosition);
                    textField.setText(roleOrPosition);
                    textField.setTextColor(ContextCompat.getColor(getApplicationContext(), roleColors.get(decodeRole(roleOrPosition))));
                    button.setVisibility(View.VISIBLE);
                    return;
                }
                this.toast = Toast.makeText(this, "The " + roleOrPosition + " is a unique role and is already present!", Toast.LENGTH_LONG);
                TextView view = toast.getView().findViewById(android.R.id.message);
                if (view != null) {
                    view.setGravity(Gravity.CENTER);
                }
                toast.show();
                return;
            }
            String prevPos = positionField.getText().toString();
            if (roleOrPosition.equals("delete")) {
                int position = Integer.parseInt(prevPos);
                if (guaranteedRole) {
                    findViewById(statusID).setVisibility(View.INVISIBLE);
                    switch (statusID) {
                        case R.id.jailorStatus /*2131558724*/:
                            updateConfirmedRole("Jailor", false);
                            break;
                        case R.id.GFStatus /*2131558747*/:
                            updateConfirmedRole("Godfather", false);
                            break;
                        case R.id.MafStatus /*2131558750*/:
                            updateConfirmedRole("Mafioso", false);
                            break;
                    }
                    this.InfoTab.updateListView();
                    updatePlayerRole(position, BuildConfig.VERSION_NAME);
                    this.OverviewTab.updateListView();
                } else if (decodeRole(((EditText) findViewById(fieldID)).getText().toString()).length() == 0) {
                    findViewById(statusID).setVisibility(View.INVISIBLE);
                }
                positionField.setText(BuildConfig.VERSION_NAME);
                updateRemainingPos(prevPos, false);
                updatePlayerRole(Integer.parseInt(prevPos), BuildConfig.VERSION_NAME);
                this.OverviewTab.updateListView();
                return;
            }
            String role;
            if (roleOrPosition.length() != TI_REQUEST_1) {
                if (roleOrPosition.charAt(TI_REQUEST_1) < '0' || roleOrPosition.charAt(TI_REQUEST_1) > '9') {
                    roleOrPosition = roleOrPosition.substring(0, TI_REQUEST_1);
                } else {
                    roleOrPosition = roleOrPosition.substring(0, TI_REQUEST_2);
                }
            }
            switch (statusID) {
                case R.id.jailorStatus /*2131558724*/:
                    role = "Jailor";
                    break;
                case R.id.GFStatus /*2131558747*/:
                    role = "Godfather";
                    break;
                case R.id.MafStatus /*2131558750*/:
                    role = "Mafioso";
                    break;
                default:
                    role = ((EditText) findViewById(fieldID)).getText().toString();
                    break;
            }
            if (prevPos.length() != 0) {
                updateRemainingPos(prevPos, false);
                updatePlayerRole(Integer.parseInt(prevPos), BuildConfig.VERSION_NAME);
            }
            positionField.setText(roleOrPosition);
            updateRemainingPos(roleOrPosition, true);
            updatePlayerRole(Integer.parseInt(roleOrPosition), role);
            this.OverviewTab.updateListView();
        }
    }

    public void toggleStatus(View view) {
        int statusID = -1;
        int posID = -1;
        int fieldID = -1;
        String alignment = BuildConfig.VERSION_NAME;
        switch (view.getId()) {
            case R.id.jailorTitleGroup /*2131558722*/:
                statusID = R.id.jailorStatus;
                posID = R.id.jailorPos;
                alignment = "jailor";
                break;
            case R.id.TITitleGroup1 /*2131558726*/:
                statusID = R.id.TIStatus1;
                posID = R.id.TIPos1;
                fieldID = R.id.TIField1;
                alignment = "TI1";
                break;
            case R.id.TITitleGroup2 /*2131558728*/:
                statusID = R.id.TIStatus2;
                posID = R.id.TIPos2;
                fieldID = R.id.TIField2;
                alignment = "TI2";
                break;
            case R.id.TSTitleGroup1 /*2131558731*/:
                statusID = R.id.TSStatus1;
                posID = R.id.TSPos1;
                fieldID = R.id.TSField1;
                alignment = "TS1";
                break;
            case R.id.TSTitleGroup2 /*2131558733*/:
                statusID = R.id.TSStatus2;
                posID = R.id.TSPos2;
                fieldID = R.id.TSField2;
                alignment = "TS2";
                break;
            case R.id.TPTitleGroup /*2131558736*/:
                statusID = R.id.TPStatus;
                posID = R.id.TPPos;
                fieldID = R.id.TPField;
                alignment = "TP";
                break;
            case R.id.TKTitleGroup /*2131558739*/:
                statusID = R.id.TKStatus;
                posID = R.id.TKPos;
                fieldID = R.id.TKField;
                alignment = "TK";
                break;
            case R.id.RTTitleGroup /*2131558742*/:
                statusID = R.id.RTStatus;
                posID = R.id.RTPos;
                fieldID = R.id.RTField;
                alignment = "RT";
                break;
            case R.id.GFTitleGroup /*2131558745*/:
                statusID = R.id.GFStatus;
                posID = R.id.GFPos;
                alignment = "GF";
                break;
            case R.id.MafTitleGroup /*2131558748*/:
                statusID = R.id.MafStatus;
                posID = R.id.MafPos;
                alignment = "Maf";
                break;
            case R.id.RMTitleGroup /*2131558752*/:
                statusID = R.id.RMStatus;
                posID = R.id.RMPos;
                fieldID = R.id.RMField;
                alignment = "RM";
                break;
            case R.id.NKTitleGroup /*2131558755*/:
                statusID = R.id.NKStatus;
                posID = R.id.NKPos;
                fieldID = R.id.NKField;
                alignment = "NK";
                break;
            case R.id.NETitleGroup /*2131558758*/:
                statusID = R.id.NEStatus;
                posID = R.id.NEPos;
                fieldID = R.id.NEField;
                alignment = "NE";
                break;
            case R.id.NBTitleGroup /*2131558761*/:
                statusID = R.id.NBStatus;
                posID = R.id.NBPos;
                fieldID = R.id.NBField;
                alignment = "NB";
                break;
            case R.id.AnyTitleGroup /*2131558764*/:
                statusID = R.id.AnyStatus;
                posID = R.id.AnyPos;
                fieldID = R.id.AnyField;
                alignment = "Any";
                break;
        }
        EditText position = findViewById(posID);
        EditText role = findViewById(fieldID);
        View statusBox = findViewById(statusID);
        String pos = position.getText().toString();
        if (!alignment.equals("jailor") && !alignment.equals("GF") && !alignment.equals("Maf")) {
            String roleText = decodeRole(role.getText().toString());
            if (pos.length() == 0 && roleText.length() == 0) {
                displayToast("Please select the Position / Role before you confirm!");
                return;
            }
        } else if (pos.length() == 0) {
            displayToast("Please select the Position before you confirm a guaranteed role!");
            return;
        }
        confirmedAlignments.put(alignment, !confirmedAlignments.get(alignment));
        String roleText;
        if (statusBox.getVisibility() == View.VISIBLE) {
            statusBox.setVisibility(View.INVISIBLE);
            switch (statusID) {
                case R.id.jailorStatus /*2131558724*/:
                    updateConfirmedRole("Jailor", false);
                    break;
                case R.id.GFStatus /*2131558747*/:
                    updateConfirmedRole("Godfather", false);
                    break;
                case R.id.MafStatus /*2131558750*/:
                    updateConfirmedRole("Mafioso", false);
                    break;
                default:
                    roleText = decodeRole(role.getText().toString());
                    if (roleText.length() != 0) {
                        updateConfirmedRole(roleText, false);
                        break;
                    }
                    break;
            }
            if (pos.length() > 0) {
                updatePlayerPos(pos, false);
            }
        } else {
            statusBox.setVisibility(View.VISIBLE);
            switch (statusID) {
                case R.id.jailorStatus /*2131558724*/:
                    updateConfirmedRole("Jailor", true);
                    break;
                case R.id.GFStatus /*2131558747*/:
                    updateConfirmedRole("Godfather", true);
                    break;
                case R.id.MafStatus /*2131558750*/:
                    updateConfirmedRole("Mafioso", true);
                    break;
                default:
                    roleText = decodeRole(role.getText().toString());
                    if (roleText.length() != 0) {
                        updateConfirmedRole(roleText, true);
                        break;
                    }
                    break;
            }
            if (pos.length() > 0) {
                updatePlayerPos(pos, true);
            }
        }
        this.InfoTab.updateListView();
    }

    private String encodeRole(String role) {
        switch (role) {
            case "Vampire Hunter" /*0*/:
                return "Vamp Hunter";
            default:
                return role;
        }
    }

    public void onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            this.toast.cancel();
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        displayToast("Please press BACK again to exit Ranked Mode");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mainPage.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void updatePlayerPos(String pos, boolean status) {
        confirmedPlayers.put(Integer.parseInt(pos), status);
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

    private void displayToast(String message) {
        Toast toast = Toast.makeText(mainPage.this, message, Toast.LENGTH_LONG);
        TextView look = toast.getView().findViewById(android.R.id.message);
        if (look != null) {
            look.setGravity(Gravity.CENTER);
        }
        toast.show();
    }

    private void resetStates() {
        confTipShown = false;
        overviewTab.allPlayerNames = new String[TS_POS_1];
        overviewTab.allPlayerRoles = new String[TS_POS_1];
        remainingPositions.clear();
        for (int i = TI_REQUEST_1; i <= TS_POS_1; i += TI_REQUEST_1) {
            remainingPositions.add(i);
        }
        for (Entry<String, Integer> entry : realizedRoles.entrySet()) {
            realizedRoles.put(entry.getKey(), 0);
            confirmedRoles.put(entry.getKey(), 0);
        }
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        private final String[] fragments;

        CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
            String[] strArr = new String[mainPage.TS_REQUEST_1];
            strArr[0] = "Overview";
            strArr[mainPage.TI_REQUEST_1] = "Alignments";
            strArr[mainPage.TI_REQUEST_2] = "Info";
            this.fragments = strArr;
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0 /*0*/:
                    mainPage.this.OverviewTab = new overviewTab();
                    return mainPage.this.OverviewTab;
                case 1 /*1*/:
                    return new alignmentsTab();
                case 2 /*2*/:
                    mainPage.this.InfoTab = new infoTab();
                    return mainPage.this.InfoTab;
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

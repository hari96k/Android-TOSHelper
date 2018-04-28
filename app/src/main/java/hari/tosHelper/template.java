package hari.tosHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
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
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import hari.tosHelper.customAlignmentsTab.OnCustomRolesTabListener;
import hari.tosHelper.infoTab.OnInfoTabListener;

public class template extends AppCompatActivity implements OnCustomRolesTabListener, OnInfoTabListener {
    private static final int POS_0 = 29;
    private static final int POS_1 = 15;
    private static final int POS_10 = 24;
    private static final int POS_11 = 25;
    private static final int POS_12 = 26;
    private static final int POS_13 = 27;
    private static final int POS_14 = 28;
    private static final int POS_2 = 16;
    private static final int POS_3 = 17;
    private static final int POS_4 = 18;
    private static final int POS_5 = 19;
    private static final int POS_6 = 20;
    private static final int POS_7 = 21;
    private static final int POS_8 = 22;
    private static final int POS_9 = 23;
    private static final int REQUEST_0 = 0;
    private static final int REQUEST_1 = 1;
    private static final int REQUEST_10 = 10;
    private static final int REQUEST_11 = 11;
    private static final int REQUEST_12 = 12;
    private static final int REQUEST_13 = 13;
    private static final int REQUEST_14 = 14;
    private static final int REQUEST_2 = 2;
    private static final int REQUEST_3 = 3;
    private static final int REQUEST_4 = 4;
    private static final int REQUEST_5 = 5;
    private static final int REQUEST_6 = 6;
    private static final int REQUEST_7 = 7;
    private static final int REQUEST_8 = 8;
    private static final int REQUEST_9 = 9;
    protected static SparseBooleanArray confirmedPlayers = new SparseBooleanArray() {
        {
            put(template.REQUEST_1, false);
            put(template.REQUEST_2, false);
            put(template.REQUEST_3, false);
            put(template.REQUEST_4, false);
            put(template.REQUEST_5, false);
            put(template.REQUEST_6, false);
            put(template.REQUEST_7, false);
            put(template.REQUEST_8, false);
            put(template.REQUEST_9, false);
            put(template.REQUEST_10, false);
            put(template.REQUEST_11, false);
            put(template.REQUEST_12, false);
            put(template.REQUEST_13, false);
            put(template.REQUEST_14, false);
            put(template.POS_1, false);
        }
    };
    protected static String[] roles;
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

            put("Psychic", 0);

            put("Coven Leader", 0);
            put("Hex Master", 0);
            put("Poisoner", 0);
            put("Potion Master", 0);
            put("Medusa", 0);
            put("Necromancer", 0);
            put("Ambusher", 0);
            put("Hypnotist", 0);
            put("Guardian Angel", 0);
            put("Pirate", 0);
            put("Crusader", 0);
            put("Tracker", 0);
            put("Trapper", 0);
            put("Plaguebearer", 0);
            put("Pestilence", 0);
            put("Juggernaut", 0);
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
            put("Witch", 0);
            put("Amnesiac", 0);
            put("Survivor", 0);
            put("Vampire", 0);

            put("Psychic", 0);

            put("Coven Leader", 0);
            put("Hex Master", 0);
            put("Poisoner", 0);
            put("Potion Master", 0);
            put("Medusa", 0);
            put("Necromancer", 0);
            put("Ambusher", 0);
            put("Hypnotist", 0);
            put("Guardian Angel", 0);
            put("Pirate", 0);
            put("Crusader", 0);
            put("Tracker", 0);
            put("Trapper", 0);
            put("Plaguebearer", 0);
            put("Pestilence", 0);
            put("Juggernaut", 0);
        }
    };
    protected static ArrayList<Integer> remainingPositions = new ArrayList<>();
    static boolean customStatesSaved;
    static int[] fields = new int[]{R.id.field0, R.id.field1, R.id.field2, R.id.field3, R.id.field4, R.id.field5, R.id.field6, R.id.field7, R.id.field8, R.id.field9, R.id.field10, R.id.field11, R.id.field12, R.id.field13, R.id.field14};
    static int[] positions = new int[]{R.id.pos0, R.id.pos1, R.id.pos2, R.id.pos3, R.id.pos4, R.id.pos5, R.id.pos6, R.id.pos7, R.id.pos8, R.id.pos9, R.id.pos10, R.id.pos11, R.id.pos12, R.id.pos13, R.id.pos14};
    static int[] titles = new int[]{R.id.title0, R.id.title1, R.id.title2, R.id.title3, R.id.title4, R.id.title5, R.id.title6, R.id.title7, R.id.title8, R.id.title9, R.id.title10, R.id.title11, R.id.title12, R.id.title13, R.id.title14};
    private static boolean confTipShown = false;
    protected CustomAdapter adapter;
    overviewTab OverviewTab;
    String alignment;
    Intent intent;
    Toast toast;
    private infoTab InfoTab;
    private boolean doubleBackToExitPressedOnce = false;
    private ViewPager viewPager;

    private static String decodeRole(String role) {
        switch (role) {
            case "Vamp Hunter" /*0*/:
                return "Vampire Hunter";
            default:
                return role;
        }
    }

    protected static void resizeText(EditText field, String role) {
        if (role.length() >= 12) {
            field.setTextSize(2, 17.0f);
        } else {
            if (role.length() >= 9) {
                field.setTextSize(2, 18.0f);
            } else {
                field.setTextSize(2, 20.0f);
            }
        }
    }

    protected static boolean isUnique(String role) {
        return role.equals("Jailor") || role.equals("Mayor") || role.equals("Retributionist") || role.equals("Veteran") || role.equals("Werewolf") || role.equals("Godfather") || role.equals("Mafioso") || role.equals("Ambusher") || role.equals("Coven Leader") || role.equals("Necromancer") || role.equals("Potion Master") || role.equals("Poisoner") || role.equals("Hex Master") || role.equals("Medusa") || role.equals("Juggernaut") || role.equals("Plaguebearer") || role.equals("Pestilence") || role.equals("Pirate");
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

    @SuppressLint({"ShowToast"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_page);
        resetStates();
        this.viewPager = findViewById(R.id.viewPager);
        this.viewPager.setOffscreenPageLimit(2);
        this.adapter = new CustomAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageSelected(int position) {
            }

            public void onPageScrollStateChanged(int state) {
                if (state == 0 && template.this.viewPager.getCurrentItem() != 0) {
                    ((InputMethodManager) template.this.getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(template.this.viewPager.getWindowToken(), 0);
                    View current = template.this.getCurrentFocus();
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
                template.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(Tab tab) {
                template.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabReselected(Tab tab) {
                template.this.viewPager.setCurrentItem(tab.getPosition());
            }
        });
        this.viewPager.setCurrentItem(1);
        customStatesSaved = false;
        this.toast = Toast.makeText(getBaseContext(), "", Toast.LENGTH_LONG);

        displayToast("Don't forget to input your role!");
    }

    public void onRoleSelected(String role, int position) {
        Intent intent;
        if (startPage.mode.split(" ")[0].equals("Coven")) {
            intent = new Intent(this, Role_Info_Coven.class);
        } else {
            intent = new Intent(this, Role_Info_Classic.class);
        }
        intent.putExtra("selection", role);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    public void onPageInflated() {
        int i;
        String[] savedCategories = roles;

        for (i = 0; i < titles.length; i += 1) {
            TextView title = findViewById(titles[i]);
            title.setText(savedCategories[i]);
            int color;
            try {
                color = ContextCompat.getColor(getApplicationContext(), mainPage.alignmentBackground.get(mainPage.decodeRole(savedCategories[i])));
            } catch (NullPointerException e2) {
                color = ContextCompat.getColor(getApplicationContext(), mainPage.roleBackground.get(mainPage.decodeRole(savedCategories[i])));
            }

            title.setBackgroundColor(color);
            ((ViewGroup) findViewById(positions[i]).getParent()).setBackgroundColor(color);
            ((ViewGroup) findViewById(fields[i]).getParent()).setBackgroundColor(color);
        }
    }

    public void fetchRole(View view) {
        int titleID;
        int request;
        switch (view.getId()) {
            case R.id.field0 /*2131558678*/:
                titleID = R.id.title0;
                request = REQUEST_0;
                break;
            case R.id.field1 /*2131558680*/:
                titleID = R.id.title1;
                request = REQUEST_1;
                break;
            case R.id.field2 /*2131558682*/:
                titleID = R.id.title2;
                request = REQUEST_2;
                break;
            case R.id.field3 /*2131558684*/:
                titleID = R.id.title3;
                request = REQUEST_3;
                break;
            case R.id.field4 /*2131558686*/:
                titleID = R.id.title4;
                request = REQUEST_4;
                break;
            case R.id.field5 /*2131558688*/:
                titleID = R.id.title5;
                request = REQUEST_5;
                break;
            case R.id.field6 /*2131558690*/:
                titleID = R.id.title6;
                request = REQUEST_6;
                break;
            case R.id.field7 /*2131558692*/:
                titleID = R.id.title7;
                request = REQUEST_7;
                break;
            case R.id.field8 /*2131558694*/:
                titleID = R.id.title8;
                request = REQUEST_8;
                break;
            case R.id.field9 /*2131558696*/:
                titleID = R.id.title9;
                request = REQUEST_9;
                break;
            case R.id.field10 /*2131558698*/:
                titleID = R.id.title10;
                request = REQUEST_10;
                break;
            case R.id.field11 /*2131558700*/:
                titleID = R.id.title11;
                request = REQUEST_11;
                break;
            case R.id.field12 /*2131558702*/:
                titleID = R.id.title12;
                request = REQUEST_12;
                break;
            case R.id.field13 /*2131558704*/:
                titleID = R.id.title13;
                request = REQUEST_13;
                break;
            default:
                titleID = R.id.title14;
                request = REQUEST_14;
                break;
        }
        if (((TextView) findViewById(titleID)).getText().toString().equals(getResources().getString(R.string.select))) {
            displayToast("Select a category first!");
        } else {
            startActivityForResult(generateIntent(titleID), request);
        }
    }

    public void deleteRole(View view) {
        int fieldID = -1;
        int buttonID = -1;
        int statusID = -1;
        int posID = -1;
        switch (view.getId()) {
            case R.id.buttonfield0 /*2131558677*/:
                posID = R.id.pos0;
                statusID = R.id.status0;
                fieldID = R.id.field0;
                buttonID = R.id.buttonfield0;
                break;
            case R.id.buttonfield1 /*2131558679*/:
                posID = R.id.pos1;
                statusID = R.id.status1;
                fieldID = R.id.field1;
                buttonID = R.id.buttonfield1;
                break;
            case R.id.buttonfield2 /*2131558681*/:
                posID = R.id.pos2;
                statusID = R.id.status2;
                fieldID = R.id.field2;
                buttonID = R.id.buttonfield2;
                break;
            case R.id.buttonfield3 /*2131558683*/:
                posID = R.id.pos3;
                statusID = R.id.status3;
                fieldID = R.id.field3;
                buttonID = R.id.buttonfield3;
                break;
            case R.id.buttonfield4 /*2131558685*/:
                posID = R.id.pos4;
                statusID = R.id.status4;
                fieldID = R.id.field4;
                buttonID = R.id.buttonfield4;
                break;
            case R.id.buttonfield5 /*2131558687*/:
                posID = R.id.pos5;
                statusID = R.id.status5;
                fieldID = R.id.field5;
                buttonID = R.id.buttonfield5;
                break;
            case R.id.buttonfield6 /*2131558689*/:
                posID = R.id.pos6;
                statusID = R.id.status6;
                fieldID = R.id.field6;
                buttonID = R.id.buttonfield6;
                break;
            case R.id.buttonfield7 /*2131558691*/:
                posID = R.id.pos7;
                statusID = R.id.status7;
                fieldID = R.id.field7;
                buttonID = R.id.buttonfield7;
                break;
            case R.id.buttonfield8 /*2131558693*/:
                posID = R.id.pos8;
                statusID = R.id.status8;
                fieldID = R.id.field8;
                buttonID = R.id.buttonfield8;
                break;
            case R.id.buttonfield9 /*2131558695*/:
                posID = R.id.pos9;
                statusID = R.id.status9;
                fieldID = R.id.field9;
                buttonID = R.id.buttonfield9;
                break;
            case R.id.buttonfield10 /*2131558697*/:
                posID = R.id.pos10;
                statusID = R.id.status10;
                fieldID = R.id.field10;
                buttonID = R.id.buttonfield10;
                break;
            case R.id.buttonfield11 /*2131558699*/:
                posID = R.id.pos11;
                statusID = R.id.status11;
                fieldID = R.id.field11;
                buttonID = R.id.buttonfield11;
                break;
            case R.id.buttonfield12 /*2131558701*/:
                posID = R.id.pos12;
                statusID = R.id.status12;
                fieldID = R.id.field12;
                buttonID = R.id.buttonfield12;
                break;
            case R.id.buttonfield13 /*2131558703*/:
                posID = R.id.pos13;
                statusID = R.id.status13;
                fieldID = R.id.field13;
                buttonID = R.id.buttonfield13;
                break;
            case R.id.buttonfield14 /*2131558705*/:
                posID = R.id.pos14;
                statusID = R.id.status14;
                fieldID = R.id.field14;
                buttonID = R.id.buttonfield14;
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
        }
        LayoutParams params = (LayoutParams) findViewById(fieldID).getLayoutParams();
        params.addRule(0, 0);
        editText.setLayoutParams(params);
        editText.setText("");
        updateRealizedRole(role, false);
        this.InfoTab.updateListView();
        button.setVisibility(View.INVISIBLE);
        if (pos.length() != 0) {
            updatePlayerRole(Integer.parseInt(pos), "");
            this.OverviewTab.updateListView();
        }
    }

    public void setPosition(View view) {
        int posID;
        String alignment;
        int roleID;
        int constant;
        Intent intent = new Intent(this, selectPos.class);
        String position = "";
        switch (view.getId()) {
            case R.id.pos1 /*2131558662*/:
                posID = R.id.pos1;
                alignment = getAlignment(R.id.title1);
                roleID = R.id.field1;
                constant = POS_1;
                break;
            case R.id.pos2 /*2131558663*/:
                posID = R.id.pos2;
                alignment = getAlignment(R.id.title2);
                roleID = R.id.field2;
                constant = POS_2;
                break;
            case R.id.pos3 /*2131558664*/:
                posID = R.id.pos3;
                alignment = getAlignment(R.id.title3);
                roleID = R.id.field3;
                constant = POS_3;
                break;
            case R.id.pos4 /*2131558665*/:
                posID = R.id.pos4;
                alignment = getAlignment(R.id.title4);
                roleID = R.id.field4;
                constant = POS_4;
                break;
            case R.id.pos5 /*2131558666*/:
                posID = R.id.pos5;
                alignment = getAlignment(R.id.title5);
                roleID = R.id.field5;
                constant = POS_5;
                break;
            case R.id.pos6 /*2131558667*/:
                posID = R.id.pos6;
                alignment = getAlignment(R.id.title6);
                roleID = R.id.field6;
                constant = POS_6;
                break;
            case R.id.pos7 /*2131558668*/:
                posID = R.id.pos7;
                alignment = getAlignment(R.id.title7);
                roleID = R.id.field7;
                constant = POS_7;
                break;
            case R.id.pos8 /*2131558669*/:
                posID = R.id.pos8;
                alignment = getAlignment(R.id.title8);
                roleID = R.id.field8;
                constant = POS_8;
                break;
            case R.id.pos9 /*2131558670*/:
                posID = R.id.pos9;
                alignment = getAlignment(R.id.title9);
                roleID = R.id.field9;
                constant = POS_9;
                break;
            case R.id.pos10 /*2131558671*/:
                posID = R.id.pos10;
                alignment = getAlignment(R.id.title10);
                roleID = R.id.field10;
                constant = POS_10;
                break;
            case R.id.pos11 /*2131558672*/:
                posID = R.id.pos11;
                alignment = getAlignment(R.id.title11);
                roleID = R.id.field11;
                constant = POS_11;
                break;
            case R.id.pos12 /*2131558673*/:
                posID = R.id.pos12;
                alignment = getAlignment(R.id.title12);
                roleID = R.id.field12;
                constant = POS_12;
                break;
            case R.id.pos13 /*2131558674*/:
                posID = R.id.pos13;
                alignment = getAlignment(R.id.title13);
                roleID = R.id.field13;
                constant = POS_13;
                break;
            case R.id.pos14 /*2131558675*/:
                posID = R.id.pos14;
                alignment = getAlignment(R.id.title14);
                roleID = R.id.field14;
                constant = POS_14;
                break;
            default:
                posID = R.id.pos0;
                alignment = getAlignment(R.id.title0);
                roleID = R.id.field0;
                constant = POS_0;
                break;
        }
        EditText positionField = findViewById(posID);
        TextView roleField = findViewById(roleID);
        if (positionField.getText().toString().length() > 0) {
            position = positionField.getText().toString();
        }
        String role = decodeRole(roleField.getText().toString());
        if (alignment.equals(getResources().getString(R.string.select))) {
            displayToast("Select a category first!");
            return;
        }
        String[] player = new String[3];
        player[0] = alignment;
        player[1] = position;
        player[2] = role;
        intent.putExtra("player", player);
        startActivityForResult(intent, constant);
    }

    public void onClickedChkBox(View view) {
        int posID;
        int statusID;
        CheckBox checkBox = (CheckBox) view;
        this.InfoTab.updateListView();
        switch (view.getId()) {
            case R.id.field0 /*2131558678*/:
                posID = R.id.pos0;
                statusID = R.id.status0;
                break;
            case R.id.field1 /*2131558680*/:
                posID = R.id.pos1;
                statusID = R.id.status1;
                break;
            case R.id.field2 /*2131558682*/:
                posID = R.id.pos2;
                statusID = R.id.status2;
                break;
            case R.id.field3 /*2131558684*/:
                posID = R.id.pos3;
                statusID = R.id.status3;
                break;
            case R.id.field4 /*2131558686*/:
                posID = R.id.pos4;
                statusID = R.id.status4;
                break;
            case R.id.field5 /*2131558688*/:
                posID = R.id.pos5;
                statusID = R.id.status5;
                break;
            case R.id.field6 /*2131558690*/:
                posID = R.id.pos6;
                statusID = R.id.status6;
                break;
            case R.id.field7 /*2131558692*/:
                posID = R.id.pos7;
                statusID = R.id.status7;
                break;
            case R.id.field8 /*2131558694*/:
                posID = R.id.pos8;
                statusID = R.id.status8;
                break;
            case R.id.field9 /*2131558696*/:
                posID = R.id.pos9;
                statusID = R.id.status9;
                break;
            case R.id.field10 /*2131558698*/:
                posID = R.id.pos10;
                statusID = R.id.status10;
                break;
            case R.id.field11 /*2131558700*/:
                posID = R.id.pos11;
                statusID = R.id.status11;
                break;
            case R.id.field12 /*2131558702*/:
                posID = R.id.pos12;
                statusID = R.id.status12;
                break;
            case R.id.field13 /*2131558704*/:
                posID = R.id.pos13;
                statusID = R.id.status13;
                break;
            default:
                posID = R.id.pos14;
                statusID = R.id.status14;
                break;
        }
        if (((EditText) findViewById(posID)).getText().toString().length() == 0 && !checkBox.isChecked()) {
            findViewById(statusID).setVisibility(View.INVISIBLE);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int titleID;
        String roleOrPosition = null;
        boolean category_align = false;
        boolean category_role = false;
        if (data != null) {
            roleOrPosition = data.getStringExtra("selection");
            if (roleOrPosition == null) {
                roleOrPosition = data.getStringExtra("alignment");
                category_align = true;
            }
            if (roleOrPosition == null) {
                roleOrPosition = data.getStringExtra("role");
                category_align = false;
                category_role = true;
            }
        }
        if (resultCode == -1 && roleOrPosition != null) {
            int statusID;
            int positionID;
            int fieldID;
            int buttonID;
            if (!confTipShown) {
                confTipShown = true;
                String[] m = startPage.mode.split(" ");
                if (m[0].equals("Custom")) {
                    displayToast("*Hold* the alignment to confirm this Player / Role!");
                } else {
                    displayToast("Tap the alignment to confirm this Player / Role!");
                }
            }
            switch (requestCode) {
                case REQUEST_1 /*1*/:
                case POS_1 /*15*/:
                    titleID = R.id.title1;
                    statusID = R.id.status1;
                    positionID = R.id.pos1;
                    fieldID = R.id.field1;
                    buttonID = R.id.buttonfield1;
                    break;
                case REQUEST_2 /*2*/:
                case POS_2 /*16*/:
                    titleID = R.id.title2;
                    statusID = R.id.status2;
                    positionID = R.id.pos2;
                    fieldID = R.id.field2;
                    buttonID = R.id.buttonfield2;
                    break;
                case REQUEST_3 /*3*/:
                case POS_3 /*17*/:
                    titleID = R.id.title3;
                    statusID = R.id.status3;
                    positionID = R.id.pos3;
                    fieldID = R.id.field3;
                    buttonID = R.id.buttonfield3;
                    break;
                case REQUEST_4 /*4*/:
                case POS_4 /*18*/:
                    titleID = R.id.title4;
                    statusID = R.id.status4;
                    positionID = R.id.pos4;
                    fieldID = R.id.field4;
                    buttonID = R.id.buttonfield4;
                    break;
                case REQUEST_5 /*5*/:
                case POS_5 /*19*/:
                    titleID = R.id.title5;
                    statusID = R.id.status5;
                    positionID = R.id.pos5;
                    fieldID = R.id.field5;
                    buttonID = R.id.buttonfield5;
                    break;
                case REQUEST_6 /*6*/:
                case POS_6 /*20*/:
                    titleID = R.id.title6;
                    statusID = R.id.status6;
                    positionID = R.id.pos6;
                    fieldID = R.id.field6;
                    buttonID = R.id.buttonfield6;
                    break;
                case REQUEST_7 /*7*/:
                case POS_7 /*21*/:
                    titleID = R.id.title7;
                    statusID = R.id.status7;
                    positionID = R.id.pos7;
                    fieldID = R.id.field7;
                    buttonID = R.id.buttonfield7;
                    break;
                case REQUEST_8 /*8*/:
                case POS_8 /*22*/:
                    titleID = R.id.title8;
                    statusID = R.id.status8;
                    positionID = R.id.pos8;
                    fieldID = R.id.field8;
                    buttonID = R.id.buttonfield8;
                    break;
                case REQUEST_9 /*9*/:
                case POS_9 /*23*/:
                    titleID = R.id.title9;
                    statusID = R.id.status9;
                    positionID = R.id.pos9;
                    fieldID = R.id.field9;
                    buttonID = R.id.buttonfield9;
                    break;
                case REQUEST_10 /*10*/:
                case POS_10 /*24*/:
                    titleID = R.id.title10;
                    statusID = R.id.status10;
                    positionID = R.id.pos10;
                    fieldID = R.id.field10;
                    buttonID = R.id.buttonfield10;
                    break;
                case REQUEST_11 /*11*/:
                case POS_11 /*25*/:
                    titleID = R.id.title11;
                    statusID = R.id.status11;
                    positionID = R.id.pos11;
                    fieldID = R.id.field11;
                    buttonID = R.id.buttonfield11;
                    break;
                case REQUEST_12 /*12*/:
                case POS_12 /*26*/:
                    titleID = R.id.title12;
                    statusID = R.id.status12;
                    positionID = R.id.pos12;
                    fieldID = R.id.field12;
                    buttonID = R.id.buttonfield12;
                    break;
                case REQUEST_13 /*13*/:
                case POS_13 /*27*/:
                    titleID = R.id.title13;
                    statusID = R.id.status13;
                    positionID = R.id.pos13;
                    fieldID = R.id.field13;
                    buttonID = R.id.buttonfield13;
                    break;
                case REQUEST_14 /*14*/:
                case POS_14 /*28*/:
                    titleID = R.id.title14;
                    statusID = R.id.status14;
                    positionID = R.id.pos14;
                    fieldID = R.id.field14;
                    buttonID = R.id.buttonfield14;
                    break;
                default:
                    titleID = R.id.title0;
                    statusID = R.id.status0;
                    positionID = R.id.pos0;
                    fieldID = R.id.field0;
                    buttonID = R.id.buttonfield0;
                    break;
            }
            EditText positionField = findViewById(positionID);
            String role;
            TextView titleField;
            int color;
            ViewGroup parent;
            String pos;
            View statusBox;
            if (category_align) {
                try {
                    role = decodeRole(((EditText) findViewById(fieldID)).getText().toString());
                } catch (ClassCastException e) {
                    role = ((TextView) findViewById(titleID)).getText().toString();
                }
                titleField = findViewById(titleID);
                titleField.setText(roleOrPosition);
                color = ContextCompat.getColor(getApplicationContext(), mainPage.alignmentBackground.get(decodeRole(roleOrPosition)));
                titleField.setBackgroundColor(color);
                ((ViewGroup) positionField.getParent()).setBackgroundColor(color);
                parent = (ViewGroup) findViewById(fieldID).getParent();
                parent.removeAllViews();
                View role_field = getLayoutInflater().inflate(R.layout.role_field, parent, false);
                role_field.setId(fieldID);
                titleField.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        template.this.toggleStatus(view);
                    }
                });
                pos = positionField.getText().toString();
                if (!(role == null || role.length() == 0)) {
                    updateRealizedRole(role, false);
                    this.InfoTab.updateListView();
                }
                if (pos.length() != 0) {
                    updatePlayerRole(Integer.parseInt(pos), "");
                    this.OverviewTab.updateListView();
                }
                statusBox = findViewById(statusID);
                if (statusBox.getVisibility() == View.VISIBLE && role != null) {
                    updateConfirmedRole(role, false);
                    statusBox.setVisibility(View.INVISIBLE);
                }
                positionField.setText("");
                parent.setBackgroundColor(color);
                Button delete_button = (Button) getLayoutInflater().inflate(R.layout.delete_button, parent, false);
                delete_button.setId(buttonID);
                parent.addView(role_field);
                parent.addView(delete_button);
            } else if (category_role) {
                parent = (ViewGroup) findViewById(fieldID).getParent();
                pos = positionField.getText().toString();
                statusBox = findViewById(statusID);
                try {
                    role = decodeRole(((EditText) findViewById(fieldID)).getText().toString());
                } catch (ClassCastException e2) {
                    role = ((TextView) findViewById(titleID)).getText().toString();
                }
                titleField = findViewById(titleID);
                if (!isUnique(roleOrPosition) || role.equals(roleOrPosition) || isAvailableUnique(roleOrPosition)) {
                    titleField.setText(roleOrPosition);
                    color = ContextCompat.getColor(getApplicationContext(), mainPage.roleBackground.get(decodeRole(roleOrPosition)));
                    titleField.setBackgroundColor(color);
                    ((ViewGroup) positionField.getParent()).setBackgroundColor(color);
                    titleField.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            template.this.toggleStatus(view);
                        }
                    });
                    if (statusBox.getVisibility() == View.VISIBLE && role != null) {
                        updateConfirmedRole(role, false);
                    }
                    if (!(role == null || role.length() == 0)) {
                        updateRealizedRole(role, false);
                    }
                    updateRealizedRole(roleOrPosition, true);
                    this.InfoTab.updateListView();
                    if (pos.length() != 0) {
                        updatePlayerRole(Integer.parseInt(pos), "");
                        this.OverviewTab.updateListView();
                        positionField.setText("");
                    }
                    parent.setBackgroundColor(color);
                    findViewById(statusID).setVisibility(View.VISIBLE);
                    parent.removeAllViews();
                    CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(R.layout.check_box, parent, false);
                    checkBox.setId(fieldID);
                    parent.addView(checkBox);
                    return;
                }
                displayToast("The " + roleOrPosition + " is a unique role and is already present!");
            } else if (requestCode <= REQUEST_14) {
                EditText textField = findViewById(fieldID);
                Button button = findViewById(buttonID);
                String prevRole = decodeRole(textField.getText().toString());
                if (!isUnique(roleOrPosition) || prevRole.equals(roleOrPosition) || isAvailableUnique(roleOrPosition)) {
                    statusBox = findViewById(statusID);
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
                    textField.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(decodeRole(roleOrPosition))));
                    button.setVisibility(View.VISIBLE);
                    return;
                }
                displayToast("The " + roleOrPosition + " is a unique role and is already present!");
            } else {
                String prevPos = positionField.getText().toString();
                if (roleOrPosition.equals("delete")) {
                    try {
                        role = ((EditText) findViewById(fieldID)).getText().toString();
                    } catch (ClassCastException e3) {
                        role = ((TextView) findViewById(titleID)).getText().toString();
                    }
                    if (role.length() == 0) {
                        findViewById(statusID).setVisibility(View.INVISIBLE);
                    }
                    positionField.setText("");
                    updateRemainingPos(prevPos, false);
                    updatePlayerRole(Integer.parseInt(prevPos), "");
                    this.OverviewTab.updateListView();
                    return;
                }
                if (roleOrPosition.length() != 1) {
                    if (roleOrPosition.charAt(1) < '0' || roleOrPosition.charAt(1) > '9') {
                        roleOrPosition = roleOrPosition.substring(0, 1);
                    } else {
                        roleOrPosition = roleOrPosition.substring(0, 2);
                    }
                }
                try {
                    role = ((EditText) findViewById(fieldID)).getText().toString();
                } catch (ClassCastException e4) {
                    role = ((TextView) findViewById(titleID)).getText().toString();
                }
                if (prevPos.length() != 0) {
                    updateRemainingPos(prevPos, false);
                    updatePlayerRole(Integer.parseInt(prevPos), "");
                }
                positionField.setText(roleOrPosition);
                updateRemainingPos(roleOrPosition, true);
                updatePlayerRole(Integer.parseInt(roleOrPosition), role);
                this.OverviewTab.updateListView();
            }
        }
    }

    public void toggleStatus(View view) {
        String roleText;
        Type type;
        int statusID = -1;
        int posID = -1;
        int fieldID = -1;
        switch (view.getId()) {
            case R.id.title0 /*2131558603*/:
                statusID = R.id.status0;
                fieldID = R.id.field0;
                posID = R.id.pos0;
                break;
            case R.id.title1 /*2131558607*/:
                statusID = R.id.status1;
                fieldID = R.id.field1;
                posID = R.id.pos1;
                break;
            case R.id.title2 /*2131558611*/:
                statusID = R.id.status2;
                fieldID = R.id.field2;
                posID = R.id.pos2;
                break;
            case R.id.title3 /*2131558615*/:
                statusID = R.id.status3;
                fieldID = R.id.field3;
                posID = R.id.pos3;
                break;
            case R.id.title4 /*2131558619*/:
                statusID = R.id.status4;
                fieldID = R.id.field4;
                posID = R.id.pos4;
                break;
            case R.id.title5 /*2131558623*/:
                statusID = R.id.status5;
                fieldID = R.id.field5;
                posID = R.id.pos5;
                break;
            case R.id.title6 /*2131558627*/:
                statusID = R.id.status6;
                fieldID = R.id.field6;
                posID = R.id.pos6;
                break;
            case R.id.title7 /*2131558631*/:
                statusID = R.id.status7;
                fieldID = R.id.field7;
                posID = R.id.pos7;
                break;
            case R.id.title8 /*2131558635*/:
                statusID = R.id.status8;
                fieldID = R.id.field8;
                posID = R.id.pos8;
                break;
            case R.id.title9 /*2131558639*/:
                statusID = R.id.status9;
                fieldID = R.id.field9;
                posID = R.id.pos9;
                break;
            case R.id.title10 /*2131558643*/:
                statusID = R.id.status10;
                fieldID = R.id.field10;
                posID = R.id.pos10;
                break;
            case R.id.title11 /*2131558647*/:
                statusID = R.id.status11;
                fieldID = R.id.field11;
                posID = R.id.pos11;
                break;
            case R.id.title12 /*2131558651*/:
                statusID = R.id.status12;
                fieldID = R.id.field12;
                posID = R.id.pos12;
                break;
            case R.id.title13 /*2131558655*/:
                statusID = R.id.status13;
                fieldID = R.id.field13;
                posID = R.id.pos13;
                break;
            case R.id.title14 /*2131558658*/:
                statusID = R.id.status14;
                fieldID = R.id.field14;
                posID = R.id.pos14;
                break;
        }
        EditText position = findViewById(posID);
        try {
            roleText = decodeRole(((EditText) findViewById(fieldID)).getText().toString());
            type = Type.ALIGN_TYPE;
        } catch (ClassCastException e) {
            roleText = ((TextView) findViewById(view.getId())).getText().toString();
            type = Type.ROLE_TYPE;
        }
        View statusBox = findViewById(statusID);
        String pos = position.getText().toString();
        if (pos.length() == 0) {
            try {
                if (roleText.length() == 0) {
                    displayToast("Please select the Position or Role before you confirm!");
                    return;
                } else if (!(type != Type.ROLE_TYPE || ((CheckBox) findViewById(fieldID)).isChecked() || statusBox.getVisibility() == View.VISIBLE)) {
                    displayToast("Please select the Position or Role before you confirm!");
                    return;
                }
            } catch (ClassCastException cce) {
                displayToast("Please select the Position before you confirm a guaranteed role!");
                return;
            }
        }
        if (statusBox.getVisibility() == View.INVISIBLE) {
            statusBox.setVisibility(View.VISIBLE);
            if (roleText.length() != 0) {
                updateConfirmedRole(roleText, false);
            }
            if (pos.length() > 0) {
                updatePlayerPos(pos, false);
            }
        } else {
            statusBox.setVisibility(View.INVISIBLE);
            if (roleText.length() != 0) {
                updateConfirmedRole(roleText, true);
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
            customStatesSaved = true;
            this.toast.cancel();
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        displayToast("Please press BACK again to exit " + startPage.mode + " mode");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                template.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void saveCustomState() {
        if (!startPage.mode.equals("Custom")) {
            return;
        }

        customPresets.settings = PreferenceManager.getDefaultSharedPreferences(this);
        JSONArray jsonArray = new JSONArray();
        int i = 0;
        while (i < titles.length) {
            try {
                jsonArray.put(i, ((TextView) findViewById(titles[i])).getText().toString());
                i += 1;
            } catch (JSONException ignored) {
            }
        }
        Editor editor = customPresets.settings.edit();
        editor.putString(Integer.valueOf(customPresets.presetNumber).toString(), jsonArray.toString());
        editor.apply();
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

    protected void onStop() {
        saveCustomState();
        super.onStop();
    }

    private Intent generateIntent(int viewID) {
        alignment = ((TextView) findViewById(viewID)).getText().toString();

        switch (alignment) {
            case "Town Investigative" /*0*/:
                return new Intent(this, TI.class);
            case "Town Support" /*1*/:
                return new Intent(this, TS.class);
            case "Town Protective" /*2*/:
                return new Intent(this, TP.class);
            case "Town Killing" /*3*/:
                return new Intent(this, TK.class);
            case "Random Town" /*4*/:
                return new Intent(this, RT.class);
            case "Mafia Killing" /*5*/:
                return new Intent(this, MK.class);
            case "Mafia Deception" /*6*/:
                return new Intent(this, MD.class);
            case "Mafia Support" /*7*/:
                return new Intent(this, MS.class);
            case "Random Mafia" /*8*/:
                return new Intent(this, RM.class);
            case "Neutral Killing" /*9*/:
                return new Intent(this, NK.class);
            case "Neutral Evil" /*10*/:
                return new Intent(this, NE.class);
            case "Neutral Benign" /*11*/:
                return new Intent(this, NB.class);
            case "Neutral Chaos" /*11*/:
                return new Intent(this, NC.class);
            case "Random Neutral" /*12*/:
                return new Intent(this, RN.class);
            case "Coven Evil" /*13*/:
                return new Intent(this, CE.class);
            default:
                return new Intent(this, Any.class);
        }
    }

    private String getAlignment(int viewID) {
        return ((TextView) findViewById(viewID)).getText().toString();
    }

    private void displayToast(String message) {
        Toast toast = Toast.makeText(template.this, message, Toast.LENGTH_LONG);
        TextView look = toast.getView().findViewById(android.R.id.message);
        if (look != null) {
            look.setGravity(Gravity.CENTER);
        }
        toast.show();
    }

    private void resetStates() {
        confTipShown = false;
        overviewTab.allPlayerNames = new String[15];
        overviewTab.allPlayerRoles = new String[15];
        remainingPositions.clear();
        for (int i = 1; i <= 15; i += 1) {
            remainingPositions.add(i);
        }
        for (Entry<String, Integer> entry : realizedRoles.entrySet()) {
            realizedRoles.put(entry.getKey(), 0);
            confirmedRoles.put(entry.getKey(), 0);
        }
    }

    private enum Type {
        ALIGN_TYPE,
        ROLE_TYPE
    }

    private class CustomAdapter extends FragmentPagerAdapter {
        private final String[] fragments;

        CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
            String[] strArr = new String[3];
            strArr[0] = "Overview";
            strArr[1] = "Alignments";
            strArr[2] = "Info";
            this.fragments = strArr;
        }


        public Fragment getItem(int position) {
            switch (position) {
                case 0 /*0*/:
                    template.this.OverviewTab = new overviewTab();
                    return template.this.OverviewTab;
                case 1 /*1*/:
                    return new alignmentsTab();
                case 2 /*2*/:
                    template.this.InfoTab = new infoTab();
                    return template.this.InfoTab;
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

package hari.tosHelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
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
import android.view.View.OnLongClickListener;
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
import hari.tosHelper.InfoTab.OnInfoTabListener;

import static hari.tosHelper.template.RequestCode.*;
import static hari.tosHelper.template.decodeRole;

public class customTemplate extends AppCompatActivity implements OnCustomRolesTabListener, OnInfoTabListener {

    private static boolean confTipShown = false;
    protected static SparseBooleanArray confirmedPlayers = new SparseBooleanArray() {
        {
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

            put("Psychic", 0);
            put("Tracker", 0);
            put("Crusader", 0);
            put("Trapper", 0);

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
            put("Escort", 0);
            put("Lookout", 0);
            put("Serial Killer", 0);
            put("Veteran", 0);
            put("Vigilante", 0);
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

            put("Psychic", 0);
            put("Tracker", 0);
            put("Crusader", 0);
            put("Trapper", 0);

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
            put("Plaguebearer", 0);
            put("Pestilence", 0);
            put("Juggernaut", 0);
        }
    };

    static boolean customStatesSaved;
    static int[] fields = new int[]{R.id.field0, R.id.field1, R.id.field2, R.id.field3, R.id.field4, R.id.field5, R.id.field6, R.id.field7, R.id.field8, R.id.field9, R.id.field10, R.id.field11, R.id.field12, R.id.field13, R.id.field14};
    static int[] positions = new int[]{R.id.pos0, R.id.pos1, R.id.pos2, R.id.pos3, R.id.pos4, R.id.pos5, R.id.pos6, R.id.pos7, R.id.pos8, R.id.pos9, R.id.pos10, R.id.pos11, R.id.pos12, R.id.pos13, R.id.pos14};

    protected static ArrayList<Integer> remainingPositions = new ArrayList<>();
    static int[] titles = new int[]{R.id.title0, R.id.title1, R.id.title2, R.id.title3, R.id.title4, R.id.title5, R.id.title6, R.id.title7, R.id.title8, R.id.title9, R.id.title10, R.id.title11, R.id.title12, R.id.title13, R.id.title14};
    Row[] rows;
    private hari.tosHelper.InfoTab infoTab;
    overviewTab OverviewTab;
    protected CustomAdapter adapter;
    String alignment;
    private boolean doubleBackToExitPressedOnce = false;
    Toast toast;
    private ViewPager viewPager;


    private class CustomAdapter extends FragmentPagerAdapter {
        private final String[] fragments;

        CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
            String[] strArr = new String[3];
            strArr[0] = "Overview";
            strArr[1] = "Alignments";
            strArr[2] = "Wiki";
            this.fragments = strArr;
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0 /*0*/:
                    customTemplate.this.OverviewTab = new overviewTab();
                    return customTemplate.this.OverviewTab;
                case 1 /*1*/:
                    return new customAlignmentsTab();
                case 2 /*2*/:
                    customTemplate.this.infoTab = new InfoTab();
                    return customTemplate.this.infoTab;
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

    private enum Type {
        ALIGN_TYPE,
        ROLE_TYPE
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
                if (state == 0 && customTemplate.this.viewPager.getCurrentItem() != 0) {
                    ((InputMethodManager) customTemplate.this.getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(customTemplate.this.viewPager.getWindowToken(), 0);
                    View current = customTemplate.this.getCurrentFocus();
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
//        tablayout.addOnTabSelectedListener(new OnTabSelectedListener() {
//            public void onTabSelected(Tab tab) {
//                customTemplate.this.viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            public void onTabUnselected(Tab tab) {
//                customTemplate.this.viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            public void onTabReselected(Tab tab) {
//                customTemplate.this.viewPager.setCurrentItem(tab.getPosition());
//            }
//        });
        this.viewPager.setCurrentItem(1);
        rows = new Row[15];
        for(int i = 0; i < rows.length; i++){
            rows[i] = new Row(i);
        }


        customStatesSaved = false;
        this.toast = Toast.makeText(getBaseContext(), "", Toast.LENGTH_LONG);
        displayToast("Don't forget to input your role!");
    }

    public void onRoleSelected(String role, int position) {
        Intent intent;
        if(startPage.modeCoven) {
            intent = new Intent(this, Role_Info_Coven.class);
        }else{
            intent = new Intent(this, Role_Info_Classic.class);
        }
        Bundle b = new Bundle();
        b.putIntArray("colors", this.infoTab.adapter.textColor);

        intent.putExtra("selection", role);
        intent.putExtra("position", position);
        intent.putExtras(b);
        startActivity(intent);
    }

    String[] savedCategories = new String[15];

    public void onPageInflated() {
        loadCustomState();
        this.infoTab.updateListView();
    }

    public void fetchAlignment(View view) {
        Intent intent = new Intent(this, selectAlign.class);
        Row row = new Row();
        for(Row r : rows){
            if(r.titleID == view.getId()){
                row = r;
            }
        }

        startActivityForResult(intent, row.requestCode.ordinal());
    }

    public void fetchRole(View view) {
        Row row = new Row();
        for(Row r : rows){
            if(r.fieldID == view.getId()){
                row = r;
            }
        }

        int titleID = row.titleID;
        template.RequestCode request = row.requestCode;

        if (((TextView) findViewById(titleID)).getText().toString().equals(getResources().getString(R.string.select))) {
            displayToast("Select a category first!");
        } else {
            alignment = ((TextView) findViewById(titleID)).getText().toString();
            Intent intent = new Intent(this, roleSelectionPage.class);
            intent.putExtra("alignment", alignment);
            startActivityForResult(intent, request.ordinal());        }
    }

    public void deleteRole(View view) {
        Row row = new Row();
        for(Row r : rows){
            if(r.buttonID == view.getId()){
                row = r;
            }
        }
        int fieldID = row.fieldID;
        int buttonID = row.buttonID;
        int statusID = row.statusID;
        int posID = row.positionID;

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
        this.infoTab.updateListView();
        button.setVisibility(View.INVISIBLE);
        if (pos.length() != 0) {
            updatePlayerRole(Integer.parseInt(pos), "");
            this.OverviewTab.updateListView();
        }
    }

    public void setPosition(View view) {
        Intent intent = new Intent(this, selectPos.class);
        String position = "";

        Row row = new Row();
        for(Row r : rows){
            if(r.positionID == view.getId()){
                row = r;
            }
        }
        int posID = row.positionID;
        String alignment = getAlignment(row.titleID);
        int roleID = row.fieldID;
        template.RequestCode constant = row.posCode;

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
        startActivityForResult(intent, constant.ordinal());
    }

    public void onClickedChkBox(View view) {
        CheckBox checkBox = (CheckBox) view;
        this.infoTab.updateListView();

        Row row = new Row();
        for(Row r : rows){
            if(r.fieldID == view.getId()){
                row = r;
            }
        }

        int posID = row.positionID;
        int statusID = row.statusID;

        if (((EditText) findViewById(posID)).getText().toString().length() == 0 && !checkBox.isChecked()) {
            findViewById(statusID).setVisibility(View.INVISIBLE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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

            if (!confTipShown) {
                confTipShown = true;
                displayToast("*Hold* the alignment to confirm this Player / Role!");
            }

            template.RequestCode rc = template.RequestCode.values()[requestCode];

            Row row = new Row();
            for(Row r : rows){
                if(r.requestCode == rc || r.posCode == rc){
                    row = r;
                }
            }

            int titleID = row.titleID;
            int statusID = row.statusID;
            int positionID = row.positionID;
            int fieldID = row.fieldID;
            int buttonID = row.buttonID;

            EditText positionField = findViewById(positionID);
            String role;
            TextView titleField;
            int color;
            ViewGroup parent;
            String pos;
            View statusBox;

            // If is an alignment/category
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
                titleField.setOnLongClickListener(new OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        customTemplate.this.toggleStatus(view);
                        return true;
                    }
                });
                pos = positionField.getText().toString();
                if (!(role == null || role.length() == 0)) {
                    updateRealizedRole(role, false);
                    this.infoTab.updateListView();
                }
                if (pos.length() != 0) {
                    updatePlayerRole(Integer.parseInt(pos), "");
                    updateRemainingPos(pos, false);
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
                if (!template.isUnique(roleOrPosition) || role.equals(roleOrPosition) || isAvailableUnique(roleOrPosition)) {
                    titleField.setText(roleOrPosition);
                    color = ContextCompat.getColor(getApplicationContext(), mainPage.roleBackground.get(decodeRole(roleOrPosition)));
                    titleField.setBackgroundColor(color);
                    ((ViewGroup) positionField.getParent()).setBackgroundColor(color);
                    titleField.setOnLongClickListener(new OnLongClickListener() {
                        public boolean onLongClick(View view) {
                            customTemplate.this.toggleStatus(view);
                            return true;
                        }
                    });
                    if (statusBox.getVisibility() == View.VISIBLE && role != null) {
                        updateConfirmedRole(role, false);
                        findViewById(statusID).setVisibility(View.INVISIBLE);
                    }
                    if (!(role == null || role.length() == 0)) {
                        updateRealizedRole(role, false);
                    }
                    updateRealizedRole(roleOrPosition, true);
                    this.infoTab.updateListView();
                    if (pos.length() != 0) {
                        updatePlayerRole(Integer.parseInt(pos), "");
                        updateRemainingPos(pos, false);
                        this.OverviewTab.updateListView();
                        positionField.setText("");
                    }
                    parent.setBackgroundColor(color);
                    parent.removeAllViews();
                    CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(R.layout.check_box, parent, false);
                    checkBox.setId(fieldID);
                    parent.addView(checkBox);
                    return;
                }
                displayToast("The " + roleOrPosition + " is a unique role and is already present!");
            } else if (requestCode <= REQUEST_14.ordinal()) {
                EditText textField = findViewById(fieldID);
                Button button = findViewById(buttonID);
                String prevRole = decodeRole(textField.getText().toString());
                if (!template.isUnique(roleOrPosition) || prevRole.equals(roleOrPosition) || isAvailableUnique(roleOrPosition)) {
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
                    template.resizeText(textField, roleOrPosition);
                    LayoutParams params = (LayoutParams) findViewById(fieldID).getLayoutParams();
                    params.addRule(0, buttonID);
                    textField.setLayoutParams(params);
                    updateRealizedRole(roleOrPosition, true);
                    this.infoTab.updateListView();
                    roleOrPosition = template.encodeRole(roleOrPosition);
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

        Row row = new Row();
        for(Row r : rows){
            if(r.titleID == view.getId()){
                row = r;
            }
        }

        int statusID = row.statusID;
        int posID = row.positionID;
        int fieldID = row.fieldID;

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
            if (roleText.length() == 0) {
                displayToast("Please select the Position or Role before you confirm!");
                return;
            } else if (!(type != Type.ROLE_TYPE || ((CheckBox) findViewById(fieldID)).isChecked() || statusBox.getVisibility() == View.VISIBLE)) {
                displayToast("Please select the Position or Role before you confirm!");
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
        this.infoTab.updateListView();
    }

    public void onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            customStatesSaved = true;
            this.toast.cancel();
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        displayToast("Please press BACK again to exit " + startPage.mode + " Mode");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                customTemplate.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void saveCustomState() {
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
        editor.putString(customPresets.conditional + Integer.valueOf(customPresets.presetNumber).toString(), jsonArray.toString());
        editor.apply();
    }


    private void loadCustomState() {
        int i;
        try {
            JSONArray jsonArray = new JSONArray(customPresets.settings.getString(customPresets.conditional + Integer.valueOf(customPresets.presetNumber).toString(), "[]"));
            for (i = 0; i < jsonArray.length(); i++) {
                savedCategories[i] = (String) jsonArray.get(i);
            }
        } catch (JSONException ignored) {
        }
        if (savedCategories[0] != null) {
            for (i = 0; i < titles.length; i++) {
                TextView title = findViewById(titles[i]);
                title.setText(savedCategories[i]);
                if (!savedCategories[i].equals(getResources().getString(R.string.select))) {
                    int color;
                    try {
                        color = ContextCompat.getColor(getApplicationContext(), mainPage.alignmentBackground.get(mainPage.decodeRole(savedCategories[i])));
                    } catch (NullPointerException e2) {
                        color = ContextCompat.getColor(getApplicationContext(), mainPage.roleBackground.get(mainPage.decodeRole(savedCategories[i])));
                        ViewGroup parent = (ViewGroup) findViewById(fields[i]).getParent();
                        parent.removeAllViews();
                        CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(R.layout.check_box, parent, false);
                        checkBox.setId(fields[i]);
                        parent.addView(checkBox);
                        updateRealizedRole(savedCategories[i], true);
                    }
                    title.setBackgroundColor(color);
                    ((ViewGroup) findViewById(positions[i]).getParent()).setBackgroundColor(color);
                    ((ViewGroup) findViewById(fields[i]).getParent()).setBackgroundColor(color);
                    title.setOnLongClickListener(new OnLongClickListener() {
                        public boolean onLongClick(View view) {
                            customTemplate.this.toggleStatus(view);
                            return true;
                        }
                    });
                }
            }
        }
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


    private String getAlignment(int viewID) {
        return ((TextView) findViewById(viewID)).getText().toString();
    }

    private void displayToast(String message) {
        Toast toast = Toast.makeText(customTemplate.this, message, Toast.LENGTH_LONG);
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
}
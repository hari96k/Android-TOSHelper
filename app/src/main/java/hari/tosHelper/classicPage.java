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
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map.Entry;

import hari.tosHelper.infoTab.OnInfoTabListener;
import hotchemi.android.rate.BuildConfig;

public class classicPage extends AppCompatActivity implements OnInfoTabListener {
    private static final int RT_REQUEST = 2;
    private static final int TK_REQUEST = 1;
    protected static HashMap<String, Integer> realizedClassicRoles = new HashMap<String, Integer>() {
        {
            put("Sheriff", 0);
            put("Doctor", 0);
            put("Investigator", 0);
            put("Jailor", 0);
            put("Medium", 0);
            put("Godfather", 0);
            put("Framer", 0);
            put("Executioner", 0);
            put("Escort", 0);
            put("Mafioso", 0);
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
        }
    };
    protected CustomAdapter adapter;
    private classicInfoTab ClassicInfoTab;
    private boolean doubleBackToExitPressedOnce = false;
    private Toast toast;
    private ViewPager viewPager;

    protected static void updateRealizedRole(String role, boolean status) {
        if (status) {
            realizedClassicRoles.put(role, realizedClassicRoles.get(role) + 1);
        } else {
            realizedClassicRoles.put(role, realizedClassicRoles.get(role) - 1);
        }
    }

    protected static boolean veteranIsAvailable() {
        return realizedClassicRoles.get("Veteran") == 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_page);
        resetRealizedRoles();
        this.viewPager = findViewById(R.id.viewPager);
        this.adapter = new CustomAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.adapter);
        TabLayout tablayout = findViewById(R.id.tabLayout);
        tablayout.setupWithViewPager(this.viewPager);
        tablayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            public void onTabSelected(Tab tab) {
                classicPage.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(Tab tab) {
                classicPage.this.viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabReselected(Tab tab) {
                classicPage.this.viewPager.setCurrentItem(tab.getPosition());
            }
        });
        this.toast = Toast.makeText(getBaseContext(), BuildConfig.VERSION_NAME, Toast.LENGTH_LONG);
        displayToast("Don't forget to input your role!");
    }

    public void fetchRole(View view) {
        switch (view.getId()) {
            case 0 /*2131558596*/:
                startActivityForResult(new Intent(this, TK_classic.class), TK_REQUEST);
                return;
            case 1 /*2131558599*/:
                startActivityForResult(new Intent(this, RT_classic.class), RT_REQUEST);
                return;
            default:
        }
    }

    public void deleteRole(View view) {
        EditText editText;
        Button button;
        switch (view.getId()) {
            case R.id.classicButtonTKField /*2131558595*/:
                editText = findViewById(R.id.classicTKField);
                button = findViewById(R.id.classicButtonTKField);
                break;
            default:
                editText = findViewById(R.id.classicRTField);
                button = findViewById(R.id.classicButtonRTField);
                break;
        }
        updateRealizedRole(editText.getText().toString(), false);
        this.ClassicInfoTab.updateListView();
        editText.setText(BuildConfig.VERSION_NAME);
        button.setVisibility(View.INVISIBLE);
    }

    public void onClickedChkBox(View view) {
        CheckBox checkBox = (CheckBox) view;
        this.ClassicInfoTab.updateListView();
        if (checkBox.isChecked()) {
            switch (view.getId()) {
                case R.id.chkSheriff /*2131558552*/:
                    updateRealizedRole("Sheriff", true);
                    return;
                case R.id.chkDoctor /*2131558584*/:
                    updateRealizedRole("Doctor", true);
                    return;
                case R.id.chkInvest /*2131558585*/:
                    updateRealizedRole("Investigator", true);
                    return;
                case R.id.chkJailor /*2131558586*/:
                    updateRealizedRole("Jailor", true);
                    return;
                case R.id.chkMedium /*2131558587*/:
                    updateRealizedRole("Medium", true);
                    return;
                case R.id.chkGF /*2131558588*/:
                    updateRealizedRole("Godfather", true);
                    return;
                case R.id.chkFramer /*2131558589*/:
                    updateRealizedRole("Framer", true);
                    return;
                case R.id.chkExe /*2131558590*/:
                    updateRealizedRole("Executioner", true);
                    return;
                case R.id.chkEscort /*2131558591*/:
                    updateRealizedRole("Escort", true);
                    return;
                case R.id.chkMafioso /*2131558592*/:
                    updateRealizedRole("Mafioso", true);
                    return;
                case R.id.chkLookout /*2131558593*/:
                    updateRealizedRole("Lookout", true);
                    return;
                case R.id.chkSK /*2131558594*/:
                    updateRealizedRole("Serial Killer", true);
                    return;
                case R.id.chkJester /*2131558597*/:
                    updateRealizedRole("Jester", true);
                    return;
                default:
                    return;
            }
        }
        switch (view.getId()) {
            case R.id.chkSheriff /*2131558552*/:
                updateRealizedRole("Sheriff", false);
                return;
            case R.id.chkDoctor /*2131558584*/:
                updateRealizedRole("Doctor", false);
                return;
            case R.id.chkInvest /*2131558585*/:
                updateRealizedRole("Investigator", false);
                return;
            case R.id.chkJailor /*2131558586*/:
                updateRealizedRole("Jailor", false);
                return;
            case R.id.chkMedium /*2131558587*/:
                updateRealizedRole("Medium", false);
                return;
            case R.id.chkGF /*2131558588*/:
                updateRealizedRole("Godfather", false);
                return;
            case R.id.chkFramer /*2131558589*/:
                updateRealizedRole("Framer", false);
                return;
            case R.id.chkExe /*2131558590*/:
                updateRealizedRole("Executioner", false);
                return;
            case R.id.chkEscort /*2131558591*/:
                updateRealizedRole("Escort", false);
                return;
            case R.id.chkMafioso /*2131558592*/:
                updateRealizedRole("Mafioso", false);
                return;
            case R.id.chkLookout /*2131558593*/:
                updateRealizedRole("Lookout", false);
                return;
            case R.id.chkSK /*2131558594*/:
                updateRealizedRole("Serial Killer", false);
                return;
            case R.id.chkJester /*2131558597*/:
                updateRealizedRole("Jester", false);
                return;
            default:
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String role = null;
        if (data != null) {
            role = data.getStringExtra("selection");
        }
        if (resultCode == -1 && role != null) {
            EditText textField;
            Button button;
            switch (requestCode) {
                case TK_REQUEST /*1*/:
                    textField = findViewById(R.id.classicTKField);
                    button = findViewById(R.id.classicButtonTKField);
                    break;
                default:
                    textField = findViewById(R.id.classicRTField);
                    button = findViewById(R.id.classicButtonRTField);
                    break;
            }
            String prevRole = textField.getText().toString();
            if (prevRole.length() != 0) {
                updateRealizedRole(prevRole, false);
            }
            if (!role.equals("Veteran") || prevRole.equals("Veteran") || veteranIsAvailable()) {
                updateRealizedRole(role, true);
                this.ClassicInfoTab.updateListView();
                textField.setText(role);
                textField.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(role)));
                button.setVisibility(View.VISIBLE);
                return;
            }
            Toast toast = Toast.makeText(this, "The Veteran is a unique role and is already present!", Toast.LENGTH_LONG);
            TextView view = toast.getView().findViewById(android.R.id.message);
            if (view != null) {
                view.setGravity(17);
            }
            toast.show();
        }
    }

    public void onRoleSelected(String role, int position) {
        Intent intent = new Intent(this, Role_Info_Classic.class);
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
        displayToast("Please press BACK again to exit Classic Mode");
        new Handler().postDelayed(new Runnable() {
            public void run() {
                classicPage.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void resetRealizedRoles() {
        for (Entry<String, Integer> entry : realizedClassicRoles.entrySet()) {
            realizedClassicRoles.put(entry.getKey(), 0);
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
            String[] strArr = new String[2];
            strArr[0] = "Roles";
            strArr[1] = "Info";
            this.fragments = strArr;
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0 /*0*/:
                    return new classicAlignmentsTab();
                case 1 /*1*/:
                    classicPage.this.ClassicInfoTab = new classicInfoTab();
                    return classicPage.this.ClassicInfoTab;
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

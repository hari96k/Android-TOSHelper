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
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class classicPage extends AppCompatActivity implements infoTab.OnInfoTabListener {

    private ViewPager viewPager;
    private static final int TK_REQUEST = 1;
    private static final int RT_REQUEST = 2;
    protected CustomAdapter adapter;
    private classicInfoTab ClassicInfoTab;

    protected static HashMap<String, Integer> realizedClassicRoles = new HashMap<String, Integer>() {{
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
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_page);

        displayToast("Don't forget to input your role!");
        resetRealizedRoles();

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
                    return new classicRolesTab();
                case 1:
                    ClassicInfoTab = new classicInfoTab();
                    return ClassicInfoTab;
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
            case R.id.classicTKField:
                intent = new Intent(this, TK_classic.class);
                startActivityForResult(intent, TK_REQUEST);
                break;
            case R.id.classicRTField:
                intent = new Intent(this, RT_classic.class);
                startActivityForResult(intent, RT_REQUEST);
                break;
        }
    }

    public void deleteRole(View view) {
        EditText editText;
        Button button;
        String role;
        switch (view.getId()) {
            case R.id.classicButtonTKField:
                editText = (EditText) findViewById(R.id.classicTKField);
                button = (Button) findViewById(R.id.classicButtonTKField);
                break;

            default: // R.id.classicButtonRTField: (RT Field)
                editText = (EditText) findViewById(R.id.classicRTField);
                button = (Button) findViewById(R.id.classicButtonRTField);
                break;
        }

        role = editText.getText().toString();

        updateRealizedRole(role, false);
        ClassicInfoTab.updateListView();

        editText.setText("");
        button.setVisibility(View.INVISIBLE);
    }

    public void onClickedChkBox(View view) {
        CheckBox checkBox = (CheckBox) view;
        ClassicInfoTab.updateListView();

        if (checkBox.isChecked()) {
            switch (view.getId()) {
                case R.id.chkSheriff:
                    updateRealizedRole("Sheriff", true);
                    break;
                case R.id.chkDoctor:
                    updateRealizedRole("Doctor", true);
                    break;
                case R.id.chkInvest:
                    updateRealizedRole("Investigator", true);
                    break;
                case R.id.chkJailor:
                    updateRealizedRole("Jailor", true);
                    break;
                case R.id.chkMedium:
                    updateRealizedRole("Medium", true);
                    break;
                case R.id.chkGF:
                    updateRealizedRole("Godfather", true);
                    break;
                case R.id.chkFramer:
                    updateRealizedRole("Framer", true);
                    break;
                case R.id.chkExe:
                    updateRealizedRole("Executioner", true);
                    break;
                case R.id.chkEscort:
                    updateRealizedRole("Escort", true);
                    break;
                case R.id.chkMafioso:
                    updateRealizedRole("Mafioso", true);
                    break;
                case R.id.chkLookout:
                    updateRealizedRole("Lookout", true);
                    break;
                case R.id.chkSK:
                    updateRealizedRole("Serial Killer", true);
                    break;
                case R.id.chkJester:
                    updateRealizedRole("Jester", true);
                    break;
            }

        } else {
            switch (view.getId()) {
                case R.id.chkSheriff:
                    updateRealizedRole("Sheriff", false);
                    break;
                case R.id.chkDoctor:
                    updateRealizedRole("Doctor", false);
                    break;
                case R.id.chkInvest:
                    updateRealizedRole("Investigator", false);
                    break;
                case R.id.chkJailor:
                    updateRealizedRole("Jailor", false);
                    break;
                case R.id.chkMedium:
                    updateRealizedRole("Medium", false);
                    break;
                case R.id.chkGF:
                    updateRealizedRole("Godfather", false);
                    break;
                case R.id.chkFramer:
                    updateRealizedRole("Framer", false);
                    break;
                case R.id.chkExe:
                    updateRealizedRole("Executioner", false);
                    break;
                case R.id.chkEscort:
                    updateRealizedRole("Escort", false);
                    break;
                case R.id.chkMafioso:
                    updateRealizedRole("Mafioso", false);
                    break;
                case R.id.chkLookout:
                    updateRealizedRole("Lookout", false);
                    break;
                case R.id.chkSK:
                    updateRealizedRole("Serial Killer", false);
                    break;
                case R.id.chkJester:
                    updateRealizedRole("Jester", false);
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String role = null;
        String prevRole;
        if (data != null)
            role = data.getStringExtra("selection");
        if (resultCode == RESULT_OK && role != null) {
            // Check which request we're responding to
            EditText textField;
            Button button;
            switch (requestCode) {
                case TK_REQUEST:
                    textField = (EditText) findViewById(R.id.classicTKField);
                    button = (Button) findViewById(R.id.classicButtonTKField);
                    break;
                default: // RT_REQUEST
                    textField = (EditText) findViewById(R.id.classicRTField);
                    button = (Button) findViewById(R.id.classicButtonRTField);
                    break;
            }

            // If there is a previous role, reset its availability status
            prevRole = textField.getText().toString();
            if (prevRole.length() != 0) {
                // Delete previous role
                updateRealizedRole(prevRole, false);
            }

            // If selection is a unique role and prevRole isn't that unique role
            if (role.equals("Veteran") && !prevRole.equals("Veteran")) {
                if (!veteranIsAvailable()) {
                    // The Vet is the only possible Unique Duplicate in Classic
                    String message = "The Veteran is a unique role and is already present!";
                    Toast toast = Toast.makeText(classicPage.this, message, Toast.LENGTH_LONG);
                    TextView view = (TextView) toast.getView().findViewById(android.R.id.message);
                    if (view != null) {
                        view.setGravity(Gravity.CENTER);
                    }
                    toast.show();
                    return;
                }
            }

            // Role is taken
            updateRealizedRole(role, true);
            ClassicInfoTab.updateListView();


            textField.setText(role);
            textField.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(role)));
            button.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRoleSelected(String role, int position) {
        Intent intent = new Intent(classicPage.this, Role_Information.class);
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
        String message = "Please press BACK again to exit Classic Mode";
        Toast toast = Toast.makeText(classicPage.this, message, Toast.LENGTH_LONG);
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
            realizedClassicRoles.put(role, realizedClassicRoles.get(role) + 1);
        else
            realizedClassicRoles.put(role, realizedClassicRoles.get(role) - 1);
    }

    private void resetRealizedRoles() {
        for (Map.Entry<String, Integer> entry : realizedClassicRoles.entrySet()) {
            realizedClassicRoles.put(entry.getKey(), 0);
        }
    }

    protected static boolean veteranIsAvailable() {
        return realizedClassicRoles.get("Veteran") == 0;
    }

    private void displayToast(String message) {
        Toast toast = Toast.makeText(classicPage.this, message, Toast.LENGTH_LONG);
        TextView look = (TextView) toast.getView().findViewById(android.R.id.message);
        if (look != null) {
            look.setGravity(Gravity.CENTER);
        }
        toast.show();
    }
}

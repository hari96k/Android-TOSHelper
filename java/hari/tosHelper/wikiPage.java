package hari.tosHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class wikiPage extends AppCompatActivity implements InfoTab.OnInfoTabListener {


    ViewPager viewPager;
    WikiFragAdapeter adapter;
    InfoTab infoTab0;
    InfoTab infoTab1;

    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        startPage.mode = "Wiki";
        setContentView(R.layout.activity_custom_page);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(1);
        this.adapter = new WikiFragAdapeter(getSupportFragmentManager());
        viewPager.setAdapter(this.adapter);
        TabLayout tablayout = findViewById(R.id.tabLayout);
        tablayout.setupWithViewPager(this.viewPager);
        this.viewPager.setCurrentItem(1);
    }

    @Override
    public void onRoleSelected(String role, int position) {
        Intent intent;
        Bundle b = new Bundle();
        if( viewPager.getCurrentItem() == 0) {
            b.putIntArray("colors", this.infoTab0.adapter.textColor);
            intent = new Intent(this, Role_Info_Classic.class);
        }else{
            b.putIntArray("colors", this.infoTab1.adapter.textColor);
            intent = new Intent(this, Role_Info_Coven.class);
        }
        intent.putExtra("selection", role);
        intent.putExtra("position", position);
        intent.putExtras(b);
        startActivity(intent);
    }

    private class WikiFragAdapeter extends FragmentPagerAdapter {
        private final String[] fragments;

        WikiFragAdapeter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
            String[] strArr = new String[2];
            strArr[0] = "Classic";
            strArr[1] = "Coven";
            this.fragments = strArr;
        }

        public Fragment getItem(int position) {
            // This factory mechanism of instantiation allows to pass and save position as a parameter
            if(position == 0) {
                infoTab0 = InfoTab.newInstance(position);
                return infoTab0;
            }else{
                infoTab1 = InfoTab.newInstance(position);
                return infoTab1;
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

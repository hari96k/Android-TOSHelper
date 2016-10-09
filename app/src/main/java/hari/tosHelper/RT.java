package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RT extends Activity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_rt);

        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] TownRoles = {"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, TownRoles);
        list = (ListView) findViewById(R.id.listViewRT);
        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                String selection = textView.getText().toString();

                Intent intent = new Intent(RT.this,rainbowPage.class);
                intent.putExtra("selection", selection );
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

}
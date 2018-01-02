package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RT_classic extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_rt);
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Veteran", "Vigilante"});
        this.list = findViewById(R.id.listViewRT);
        this.list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(RT_classic.this, rainbowPage.class);
                intent.putExtra("selection", selection);
                RT_classic.this.setResult(-1, intent);
                RT_classic.this.finish();
            }
        });
    }
}

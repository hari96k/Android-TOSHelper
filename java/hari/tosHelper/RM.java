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

public class RM extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_rm);
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, startPage.mode.equals("Ranked") ? new String[]{"Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor"} : new String[]{"Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Janitor", "Mafioso"});
        this.list = findViewById(R.id.listViewRM);
        this.list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(RM.this, rainbowPage.class);
                intent.putExtra("selection", selection);
                RM.this.setResult(-1, intent);
                RM.this.finish();
            }
        });
    }
}

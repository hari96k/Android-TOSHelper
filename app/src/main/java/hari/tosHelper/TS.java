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

public class TS extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_ts);
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, new String[]{"Escort", "Mayor", "Medium", "Retributionist", "Transporter"});
        this.list = findViewById(R.id.listViewTS);
        this.list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(TS.this, rainbowPage.class);
                intent.putExtra("selection", selection);
                TS.this.setResult(-1, intent);
                TS.this.finish();
            }
        });
    }
}

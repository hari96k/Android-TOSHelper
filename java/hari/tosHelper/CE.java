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

public class CE extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_ce);
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] roles;
        if (startPage.mode.equals("Coven Ranked")) {
            roles = new String[]{"Hex Master", "Poisoner", "Potion Master", "Necromancer"};
        } else {
            roles = new String[]{"Coven Leader", "Hex Master", "Poisoner", "Potion Master", "Medusa", "Necromancer"};
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, roles);
        this.list = findViewById(R.id.listViewCE);
        this.list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(CE.this, rainbowPage.class);
                intent.putExtra("selection", selection);
                CE.this.setResult(-1, intent);
                CE.this.finish();
            }
        });
    }
}

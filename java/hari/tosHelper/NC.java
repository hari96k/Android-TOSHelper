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

public class NC extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_nc);
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] roles;
        roles = startPage.mode.split(" ");
        switch (roles[0]) {
            case "Coven":
                roles = new String[]{"Pirate", "Plaguebearer", "Vampire"};
                break;
            default:
                roles = new String[]{"Vampire"};
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, roles);
        this.list = findViewById(R.id.listViewNC);
        this.list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(NC.this, rainbowPage.class);
                intent.putExtra("selection", selection);
                NC.this.setResult(-1, intent);
                NC.this.finish();
            }
        });
    }
}

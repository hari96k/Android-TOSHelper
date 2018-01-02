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

public class NB extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_nb);
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] roles;
        roles = startPage.mode.split(" ");
        switch (roles[0]) {
            case "Coven":
                roles = new String[]{"Amnesiac", "Survivor"};
                break;
            default:
                roles = new String[]{"Amnesiac", "Guardian Angel", "Survivor"};
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, roles);
        this.list = findViewById(R.id.listViewNB);
        this.list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(NB.this, rainbowPage.class);
                intent.putExtra("selection", selection);
                NB.this.setResult(-1, intent);
                NB.this.finish();
            }
        });
    }
}

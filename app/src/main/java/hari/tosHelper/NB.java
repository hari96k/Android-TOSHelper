package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NB extends Activity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_nb);

        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] NBRoles = {"Amnesiac", "Survivor"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, NBRoles);
        list = (ListView) findViewById(R.id.listViewNB);
        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                String selection = textView.getText().toString();

                Intent intent = new Intent(NB.this,rainbowPage.class);
                intent.putExtra("selection", selection);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

}
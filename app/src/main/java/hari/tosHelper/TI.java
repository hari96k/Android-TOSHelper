package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TI extends Activity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_ti);
        
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] TIRoles = {"Investigator", "Lookout", "Sheriff", "Spy"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, TIRoles);
        list = (ListView) findViewById(R.id.listViewTI);
        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                String selection = textView.getText().toString();

                Intent intent = new Intent(TI.this,rainbowPage.class);
                intent.putExtra("selection", selection );
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

}
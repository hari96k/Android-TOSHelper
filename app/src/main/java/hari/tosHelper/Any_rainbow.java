package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Any_rainbow extends Activity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_any);

        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] AnyRoles = {"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, AnyRoles);
        list = (ListView) findViewById(R.id.listViewANY);

//        View item = adapter.getView(0, null, list);
//        item.measure(0, 0);
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (5.5 * item.getMeasuredHeight()));
//        list.setLayoutParams(params);

        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                String selection = textView.getText().toString();

                Intent intent = new Intent(Any_rainbow.this,rainbowPage.class);
                intent.putExtra("selection", selection );
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

}
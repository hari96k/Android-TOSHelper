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

public class Any extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_any);
        populateListView();
        registerClickCallBack();
    }

    private void populateListView() {
        String[] roles;
        roles = startPage.mode.split(" ");
        switch (roles[0]) {
            case "Coven":
                roles = new String[]{"Investigator", "Lookout", "Psychic", "Sheriff", "Spy", "Tracker", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Crusader", "Trapper", "Vampire Hunter", "Jailor", "Veteran", "Vigilante", "Ambusher", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Hypnotist", "Janitor", "Mafioso", "Coven Leader", "Hex Master", "Poisoner", "Potion Master", "Medusa", "Necromancer", "Arsonist", "Juggernaut", "Serial Killer", "Werewolf", "Executioner", "Jester", "Amnesiac", "Guardian Angel", "Survivor", "Pirate", "Plaguebearer", "Vampire"};
                break;
            case "Ranked":
                roles = new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
                break;
            default:
                roles = new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Jailor", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Janitor", "Mafioso", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, roles);
        this.list = findViewById(R.id.listViewANY);
        this.list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(Any.this, rainbowPage.class);
                intent.putExtra("selection", selection);
                Any.this.setResult(-1, intent);
                Any.this.finish();
            }
        });
    }
}

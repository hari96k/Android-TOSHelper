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

public class roleSelectionPage extends Activity {
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int view_id;

        Bundle b = getIntent().getExtras();
        String alignment = "";
        if (b != null) {
            alignment = (String) b.get("alignment");
        }
        String[] roles;

        switch (alignment) {
            case "Town Investigative" /*0*/:
                view_id = R.layout.selection_ti;
                roles = startPage.modeCoven ? new String[]{"Investigator", "Lookout", "Psychic", "Sheriff", "Spy", "Tracker"} : new String[]{"Investigator", "Lookout", "Sheriff", "Spy"};
                break;
            case "Town Support" /*1*/:
                view_id = R.layout.selection_ts;
                roles = new String[]{"Escort", "Mayor", "Medium", "Retributionist", "Transporter"};
                break;
            case "Town Protective" /*2*/:
                view_id = R.layout.selection_tp;
                roles = startPage.modeCoven ? new String[]{"Bodyguard", "Doctor", "Crusader", "Trapper"} : new String[]{"Bodyguard", "Doctor"};
                break;
            case "Town Killing" /*3*/:
                view_id = R.layout.selection_tk;
                switch (startPage.mode) {
                    case "Ranked":
                        roles = new String[]{"Vampire Hunter", "Veteran", "Vigilante"};
                        break;
                    case "Classic":
                        roles = new String[]{"Veteran", "Vigilante"};
                        break;
                    default:
                        roles = new String[]{"Jailor", "Vampire Hunter", "Veteran", "Vigilante"};
                        break;
                }
                break;
            case "Random Town" /*4*/:
                view_id = R.layout.selection_rt;
                switch (startPage.mode) {
                    case "Ranked":
                        roles = new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante"};
                        break;
                    case "Classic":
                        roles = new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Veteran", "Vigilante"};
                        break;
                    case "Coven Ranked":
                        roles = new String[]{"Investigator", "Lookout", "Psychic", "Sheriff", "Spy", "Tracker", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Crusader", "Doctor", "Trapper", "Jailor", "Vampire Hunter", "Veteran", "Vigilante"};
                        break;
                    default:
                        roles = new String[]{"Investigator", "Lookout", "Psychic", "Sheriff", "Spy", "Tracker", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Crusader", "Doctor", "Trapper", "Vampire Hunter", "Veteran", "Vigilante"};
                        break;
                }
                break;
            case "Mafia Killing" /*5*/:
                view_id = R.layout.selection_mk;
                roles = startPage.modeCoven ? new String[]{"Ambusher", "Godfather", "Mafioso"} : new String[]{"Godfather", "Mafioso"};
                break;
            case "Mafia Deception" /*6*/:
                view_id = R.layout.selection_md;
                roles = startPage.modeCoven ? new String[]{"Disguiser", "Forger", "Framer", "Hypnotist", "Janitor"} : new String[]{"Disguiser", "Forger", "Framer", "Janitor"};
                break;
            case "Mafia Support" /*7*/:
                view_id = R.layout.selection_ms;
                roles = new String[]{"Blackmailer", "Consigliere", "Consort"};
                break;
            case "Random Mafia" /*8*/:
                view_id = R.layout.selection_rm;
                roles = startPage.mode.equals("Ranked") ? new String[]{"Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor"} : new String[]{"Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Janitor", "Mafioso"};
                break;
            case "Neutral Killing" /*9*/:
                view_id = R.layout.selection_nk;
                roles = startPage.modeCoven ? new String[]{"Arsonist", "Juggernaut", "Serial Killer", "Werewolf"} : new String[]{"Arsonist", "Serial Killer", "Werewolf"};
                break;
            case "Neutral Evil" /*10*/:
                view_id = R.layout.selection_ne;
                roles = new String[]{"Executioner", "Jester", "Witch"};
                break;
            case "Neutral Benign" /*11*/:
                view_id = R.layout.selection_nb;
                roles = startPage.modeCoven ? new String[]{"Amnesiac", "Survivor"} : new String[]{"Amnesiac", "Guardian Angel", "Survivor"};
                break;
            case "Neutral Chaos" /*11*/:
                view_id = R.layout.selection_nc;
                roles = startPage.modeCoven ? new String[]{"Pirate", "Plaguebearer", "Vampire"} : new String[]{"Vampire"};
                break;
            case "Random Neutral" /*12*/:
                view_id = R.layout.selection_rn;
                roles = new String[]{"Amnesiac", "Arsonist", "Executioner", "Jester", "Serial Killer", "Survivor", "Vampire", "Werewolf", "Witch"};
                break;
            case "Coven Evil" /*13*/:
                view_id = R.layout.selection_ce;
                roles = startPage.mode.equals("Coven Ranked") ? new String[]{"Hex Master", "Poisoner", "Potion Master", "Necromancer"} : new String[]{"Coven Leader", "Hex Master", "Poisoner", "Potion Master", "Medusa", "Necromancer"};
                break;
            case "Any":
            default:
                view_id = R.layout.selection_any;
                switch (startPage.mode) {
                    case "Coven Custom":
                        roles = new String[]{"Investigator", "Lookout", "Psychic", "Sheriff", "Spy", "Tracker", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Crusader", "Trapper", "Vampire Hunter", "Jailor", "Veteran", "Vigilante", "Ambusher", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Hypnotist", "Janitor", "Mafioso", "Coven Leader", "Hex Master", "Poisoner", "Potion Master", "Medusa", "Necromancer", "Arsonist", "Juggernaut", "Serial Killer", "Werewolf", "Executioner", "Jester", "Amnesiac", "Guardian Angel", "Survivor", "Pirate", "Plaguebearer", "Vampire"};
                        break;
                    case "Rainbow":
                        roles = new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
                        break;
                    case "Ranked":
                        roles = new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
                        break;
                    case "Custom":
                    default:
                        roles = new String[]{"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Jailor", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Janitor", "Mafioso", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
                        break;
                }
        }
        setContentView(view_id);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, roles);
        this.list = findViewById(R.id.listView);
        this.list.setAdapter(adapter);
        registerClickCallBack();
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                //TODO: This template.class used to be rainbow.class, weirdly still worked?
                Intent intent = new Intent(roleSelectionPage.this, template.class);
                intent.putExtra("selection", selection);
                roleSelectionPage.this.setResult(-1, intent);
                roleSelectionPage.this.finish();
            }
        });
    }
}

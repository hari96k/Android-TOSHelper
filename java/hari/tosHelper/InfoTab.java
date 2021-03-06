package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

public class InfoTab extends ListFragment {
    protected static String[] AllAlignments;
    protected static String[] AllRoles;
    private Activity activity;
    InfoTabAdapter adapter;
    int tabPosition = 0;

    public static InfoTab newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);

        InfoTab fragment = new InfoTab();
        fragment.setArguments(bundle);

        return fragment;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] modeNameParsed = startPage.mode.split(" ");
        if(modeNameParsed[0].equals("Wiki")){
            if (this.getArguments() != null) {
                tabPosition = this.getArguments().getInt("position");
            }
        }

        if (modeNameParsed[0].equals("Classic")){
            AllRoles = new String[]{"Bodyguard", "Doctor", "Escort", "Investigator", "Jailor", "Lookout", "Mayor", "Medium", "Retributionist", "Sheriff", "Spy", "Transporter", "Veteran", "Vigilante", "Framer", "Godfather", "Mafioso", "Serial Killer", "Executioner", "Jester"};
        }else if (modeNameParsed[0].equals("Rainbow")) {
            AllRoles = new String[]{"Bodyguard", "Doctor", "Escort", "Investigator", "Jailor", "Lookout", "Mayor", "Medium", "Retributionist", "Sheriff", "Spy", "Transporter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Janitor", "Mafioso", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
        }else if ((!modeNameParsed[0].equals("Coven") && !modeNameParsed[0].equals("Wiki") ) || (modeNameParsed[0].equals("Wiki") && tabPosition == 0)) {
            AllAlignments = new String[]{"Town Investigative", "Town Killing", "Town Protective", "Town Support", "Random Town", "Mafia Deception", "Mafia Killing", "Mafia Support", "Random Mafia", "Neutral Benign", "Neutral Evil", "Neutral Killing", "Random Neutral", "Any"};
            AllRoles = new String[]{"Bodyguard", "Doctor", "Escort", "Investigator", "Jailor", "Lookout", "Mayor", "Medium", "Retributionist", "Sheriff", "Spy", "Transporter", "Vampire Hunter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Janitor", "Mafioso", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
        }else{
            // If Coven Custom
            if ((modeNameParsed.length == 2 && modeNameParsed[1].equals("Custom")) || (modeNameParsed[0].equals("Wiki") && tabPosition == 1) ) {
                AllAlignments = new String[]{"Town Investigative", "Town Killing", "Town Protective", "Town Support", "Random Town", "Mafia Deception", "Mafia Killing", "Mafia Support", "Random Mafia", "Neutral Benign", "Neutral Evil", "Neutral Killing", "Random Neutral", "Coven Evil", "Any"};
                AllRoles = new String[]{"Bodyguard", "Crusader", "Doctor", "Escort", "Investigator", "Jailor", "Lookout", "Mayor", "Medium", "Psychic", "Retributionist", "Sheriff", "Spy", "Tracker", "Transporter", "Trapper", "Vampire Hunter", "Veteran", "Vigilante", "Ambusher", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Hypnotist", "Janitor", "Mafioso", "Coven Leader", "Hex Master", "Medusa", "Necromancer", "Poisoner", "Potion Master", "Arsonist", "Juggernaut", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Guardian Angel", "Survivor", "Pirate", "Plaguebearer", "Pestilence", "Vampire"};
            } else {
                AllAlignments = new String[]{"Town Investigative", "Town Killing", "Town Protective", "Town Support", "Random Town", "Neutral Benign", "Neutral Evil", "Neutral Killing", "Random Neutral", "Coven Evil", "Any"};
                AllRoles = new String[]{"Bodyguard", "Crusader", "Doctor", "Escort", "Investigator", "Jailor", "Lookout", "Mayor", "Medium", "Psychic", "Retributionist", "Sheriff", "Spy", "Tracker", "Transporter", "Trapper", "Vampire Hunter", "Veteran", "Vigilante", "Coven Leader", "Hex Master", "Medusa", "Necromancer", "Poisoner", "Potion Master", "Arsonist", "Juggernaut", "Serial Killer", "Werewolf", "Executioner", "Jester", "Amnesiac", "Guardian Angel", "Survivor", "Pirate", "Plaguebearer", "Pestilence", "Vampire"};
            }
        }

        this.adapter = new InfoTabAdapter(getActivity(), AllRoles, tabPosition);
        setListAdapter(this.adapter);
        ListView listView = getListView();
        if (listView != null) {
            listView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
        }
    }

    public void onListItemClick(ListView l, View view, int position, long id) {
        try {
            ((OnInfoTabListener) this.activity).onRoleSelected((String) l.getItemAtPosition(position), position);
        } catch (ClassCastException ignored) {
        }
    }

    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }

    public void updateListView() {
        if (this.adapter != null) {
            this.adapter.notifyDataSetChanged();
        }
    }

    interface OnInfoTabListener {
        void onRoleSelected(String str, int i);
    }
}

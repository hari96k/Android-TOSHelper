package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

import java.util.Arrays;

public class classicInfoTab extends ListFragment {

    private Activity activity;
    private customAdapter adapter;

    private final String[] TownRoles = {"Jailor", "Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Veteran", "Vigilante"};
    private final String[] MafRoles = {"Godfather", "Mafioso", "Framer"};
    private final String[] NeutralRoles = {"Serial Killer", "Executioner", "Jester"};


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //View rootView = inflater.inflate(R.layout.players_layout, container, false);

        Arrays.sort(TownRoles);

        String[] AllRoles = infoTab.concat(TownRoles, MafRoles);
        AllRoles = infoTab.concat(AllRoles, NeutralRoles);

        //String[] AnyRoles = {"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
        adapter = new customAdapter(getActivity(), AllRoles, "Classic");

        setListAdapter(adapter);
        ListView listView = getListView();

        if (listView != null) {
            listView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));

//        for(int i = 10; i <=13; i++) {
//            listView.getChildAt(i).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
//        }
        }
    }

    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {

        String selection = (String) l.getItemAtPosition(position);
        try {
            ((infoTab.OnInfoTabListener) activity).onRoleSelected(selection, position);
        } catch (ClassCastException ignored) {
        }
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }

    public void updateListView(){
        if (adapter != null){
            adapter.notifyDataSetChanged();
        }
    }
}

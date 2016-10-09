package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

public class overviewTab extends ListFragment {

    private Activity activity;
    private overviewAdapter adapter;

    protected String[] allPlayers = new String[15];

    public interface OnInfoTabListener{
        void onRoleSelected(String role, int position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //View rootView = inflater.inflate(R.layout.players_layout, container, false);

        //String[] AnyRoles = {"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
        adapter = new overviewAdapter(getActivity(), allPlayers);

        setListAdapter(adapter);
        ListView listView = getListView();

        if(listView != null) {
            listView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        }
    }


    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {

        String selection = (String) l.getItemAtPosition(position);
        try{
            ((OnInfoTabListener) activity).onRoleSelected(selection, position);
        }catch (ClassCastException ignored){}

    }

    @Override
    public void onAttach(Context activity){
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }

    public void updateListView(){
        if (adapter != null){
            adapter.notifyDataSetChanged();
        }
    }

}

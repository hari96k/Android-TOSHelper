package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

import java.util.Arrays;

public class infoTab extends ListFragment {

    private Activity activity;
    private customAdapter adapter;

    protected static final String[] TownRoles = {"Jailor", "Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante"};
    protected static final String[] MafRoles = {"Godfather", "Mafioso", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor"};
    protected static final String[] NeutralRoles = {"Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};

    public interface OnInfoTabListener{
        void onRoleSelected(String role, int position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //View rootView = inflater.inflate(R.layout.players_layout, container, false);

        Arrays.sort(TownRoles);
        Arrays.sort(MafRoles);

        String[] AllRoles = concat(TownRoles,MafRoles);
        AllRoles = concat(AllRoles,NeutralRoles);

        //String[] AnyRoles = {"Investigator", "Lookout", "Sheriff", "Spy", "Escort", "Mayor", "Medium", "Retributionist", "Transporter", "Bodyguard", "Doctor", "Vampire Hunter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Janitor", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
        adapter = new customAdapter(getActivity(), AllRoles, "Ranked");

        setListAdapter(adapter);
        ListView listView = getListView();

        if(listView != null) {
            listView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));

//        for(int i = 10; i <=13; i++) {
//            listView.getChildAt(i).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
//        }
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

    protected static String[] concat(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c= new String[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    public void updateListView(){
        if (adapter != null){
            adapter.notifyDataSetChanged();
        }
    }

}

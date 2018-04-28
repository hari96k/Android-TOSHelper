package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

public class rainbowInfoTab extends ListFragment {
    protected static final String[] AllRoles = new String[]{"Bodyguard", "Doctor", "Escort", "Investigator", "Jailor", "Lookout", "Mayor", "Medium", "Retributionist", "Sheriff", "Spy", "Transporter", "Veteran", "Vigilante", "Blackmailer", "Consigliere", "Consort", "Disguiser", "Forger", "Framer", "Godfather", "Janitor", "Mafioso", "Arsonist", "Serial Killer", "Werewolf", "Executioner", "Jester", "Witch", "Amnesiac", "Survivor", "Vampire"};
    private Activity activity;
    private infoTabAdapter adapter;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.adapter = new infoTabAdapter(getActivity(), AllRoles);
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

    public interface OnInfoTabListener {
        void onRoleSelected(String str, int i);
    }
}

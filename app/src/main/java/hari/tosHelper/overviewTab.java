package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class overviewTab extends ListFragment {
    protected static String[] allPlayerNames = new String[15];
    protected static String[] allPlayerRoles = new String[15];
    View header;
    View view;
    private Activity activity;
    private overviewAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.overview_listview, null);
        this.header = this.view.findViewById(R.id.header);
        this.view.post(new Runnable() {
            public void run() {
                overviewTab.this.header.getLayoutParams().height = mainPage.standardTitleHeight;
            }
        });
        return this.view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.adapter = new overviewAdapter(getActivity(), allPlayerNames, this.header);
        ListView listView = getListView();
        setListAdapter(this.adapter);
        listView.setEnabled(false);
        listView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
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

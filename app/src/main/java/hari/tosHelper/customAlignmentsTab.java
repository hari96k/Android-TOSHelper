package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class customAlignmentsTab extends Fragment {
    private Activity activity;
    View view;

    interface OnCustomRolesTabListener {
        void onPageInflated();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.custom_roles_tab, container, false);
        this.view.post(new Runnable() {
            public void run() {
                mainPage.standardHeight = customAlignmentsTab.this.view.findViewById(R.id.title0).getHeight();
                mainPage.standardTitleHeight = customAlignmentsTab.this.view.findViewById(R.id.alignmentsTitle).getHeight();
                try {
                    ((OnCustomRolesTabListener) customAlignmentsTab.this.activity).onPageInflated();
                } catch (ClassCastException ignored) {
                }
            }
        });
        return this.view;
    }

    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }
}

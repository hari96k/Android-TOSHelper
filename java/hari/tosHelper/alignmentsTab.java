package hari.tosHelper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class alignmentsTab extends Fragment {
    public static int mode_layout;
    static int roleHeight;
    static int titleHeight;
    View view;
    private Activity activity;

    public static void setModeLayout(int modeLayout) {
        roleHeight = R.id.title0;
        titleHeight = R.id.alignmentsTitle;
        mode_layout = modeLayout;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(mode_layout, container, false);
        this.view.post(new Runnable() {
            public void run() {
                mainPage.standardHeight = alignmentsTab.this.view.findViewById(roleHeight).getHeight();
                mainPage.standardTitleHeight = alignmentsTab.this.view.findViewById(titleHeight).getHeight();
            }
        });

        if (startPage.mode.split(" ")[0].equals("Custom"))
            try {
                ((alignmentsTab.OnCustomRolesTabListener) alignmentsTab.this.activity).onPageInflated();
            } catch (ClassCastException ignored) {
            }

        return this.view;
    }

    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }

    interface OnCustomRolesTabListener {
        void onPageInflated();
    }
}

package hari.tosHelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

class alignAdapter1 extends ArrayAdapter<String> {
    private static int[] textColor;
    private final Context context;
    private final String[] roles;

    alignAdapter1(Context context, String[] roles) {
        super(context, R.layout.list_view_element, roles);
        this.context = context;
        this.roles = roles;
        if (startPage.modeCoven) {
            initializeCovenTextColors();
        } else {
            initializeTextColors();
        }
    }

    private void initializeCovenTextColors() {
        textColor = new int[]{
                // 0-18 town
                R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText,
                // 19 - 29 mafia
                R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText,
                // 30 - 35 coven
                R.color.covenText, R.color.covenText, R.color.covenText, R.color.covenText, R.color.covenText, R.color.covenText,
                R.color.arsonistText,
                R.color.juggernautText,
                R.color.skText,
                R.color.wwText,
                R.color.exeText,
                R.color.jesterText,
                R.color.witchText,
                R.color.amneText,
                R.color.gaText,
                R.color.survivorText,
                R.color.pirateText,
                R.color.plaguebearerText,
                R.color.pestilenceText,
                R.color.exeText
        };
    }

    private void initializeTextColors() {
        textColor = new int[]{
                // 0-14 town
                R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText,
                // 15 - 23 mafia
                R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText, R.color.mafiaText,
                R.color.arsonistText,
                R.color.skText,
                R.color.wwText,
                R.color.exeText,
                R.color.jesterText,
                R.color.witchText,
                R.color.amneText,
                R.color.survivorText,
                R.color.exeText
        };
    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            rowView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_view_element_3, parent, false);
            ViewHolder3 holder = new ViewHolder3();
            holder.textView = rowView.findViewById(R.id.listViewElement);
            holder.textView.setText(this.roles[position]);
            holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
            rowView.setTag(holder);
            return rowView;
        }
        ViewHolder3 holder = (ViewHolder3) rowView.getTag();
        holder.textView = rowView.findViewById(R.id.listViewElement);
        holder.textView.setText(this.roles[position]);
        holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
        return rowView;
    }
}


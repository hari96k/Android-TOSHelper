package hari.tosHelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class alignAdapter0 extends ArrayAdapter<String> {
    private static int[] textColor;
    private final Context context;
    private final String[] roles;

    alignAdapter0(Context context, String[] roles) {
        super(context, R.layout.list_view_element, roles);
        this.context = context;
        this.roles = roles;
        if(startPage.modeCoven){
            initializeCovenAlignColors();
        }else{
            initializeAlignColors();
        }
    }

    private void initializeCovenAlignColors() {
        textColor = new int[15];
        for (int i = 0; i < textColor.length; i++) {
            if (i < 5) {
                textColor[i] = R.color.townText;
            } else if (i < 9) {
                textColor[i] = R.color.mafiaText;
            } else if (i < 13) {
                textColor[i] = R.color.exeText;
            } else if (i < 14 ) {
                textColor[i] = R.color.covenText;
            } else {
                textColor[i] = R.color.black;
            }
        }
    }

    private void initializeAlignColors() {
        textColor = new int[14];
        for (int i = 0; i < textColor.length; i++) {
            if (i < 5) {
                textColor[i] = R.color.townText;
            } else if (i < 9) {
                textColor[i] = R.color.mafiaText;
            } else if (i < 13) {
                textColor[i] = R.color.exeText;
            } else {
                textColor[i] = R.color.black;
            }
        }
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            if (this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) != null) {
                rowView = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) != null ? ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_view_element_3, parent, false) : null;
            }
            ViewHolder3 holder = new ViewHolder3();
            holder.textView = rowView.findViewById(R.id.listViewElement);
            holder.textView.setText(this.roles[position]);
            holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
            rowView.setTag(holder);
            return rowView;
        }
        ViewHolder3 holder1 = (ViewHolder3) rowView.getTag();
        holder1.textView = rowView.findViewById(R.id.listViewElement);
        holder1.textView.setText(this.roles[position]);
        holder1.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
        return rowView;
    }
}

class ViewHolder3 {
    View confirmedFlag;
    View presentFlag;
    TextView textView;
}

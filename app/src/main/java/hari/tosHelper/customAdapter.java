package hari.tosHelper;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class ViewHolder {
    protected TextView textView;
    protected View presentFlag;
    public View confirmedFlag;
}


class customAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] roles;
    private String mode;
    public static int[] textColor;


    public customAdapter(Context context, String[] roles, String mode) {
        super(context, R.layout.list_view_element_2, roles);
        this.context = context;
        this.roles = roles;
        this.mode = mode;
        switch (mode) {
            case "Ranked":
                initializeTextColors(); // For Ranked
                break;
            case "Classic":
                initializeClassicTextColors();
                break;
            default:
                initializeRainbowTextColors();
                break;
        }
    }

    private void initializeRainbowTextColors() {
        textColor = new int[32];
        for (int i = 0; i < textColor.length; i++) {
            if (i < 14)
                textColor[i] = R.color.townText;
            else if (i < 23)
                textColor[i] = R.color.mafiaText;
            else
                switch (i) {
                    case 23:
                        textColor[i] = R.color.arsonistText;
                        break;
                    case 24:
                        textColor[i] = R.color.skText;
                        break;
                    case 25:
                        textColor[i] = R.color.wwText;
                        break;
                    case 26:
                        textColor[i] = R.color.exeText;
                        break;
                    case 27:
                        textColor[i] = R.color.jesterText;
                        break;
                    case 28:
                        textColor[i] = R.color.witchText;
                        break;
                    case 29:
                        textColor[i] = R.color.amneText;
                        break;
                    case 30:
                        textColor[i] = R.color.survivorText;
                        break;
                    case 31:
                        textColor[i] = R.color.exeText;
                        break;
                }
        }
    }

    private void initializeTextColors() {
        textColor = new int[33];
        for (int i = 0; i < textColor.length; i++) {
            if (i < 15)
                textColor[i] = R.color.townText;
            else if (i < 24)
                textColor[i] = R.color.mafiaText;
            else
                switch (i) {
                    case 24:
                        textColor[i] = R.color.arsonistText;
                        break;
                    case 25:
                        textColor[i] = R.color.skText;
                        break;
                    case 26:
                        textColor[i] = R.color.wwText;
                        break;
                    case 27:
                        textColor[i] = R.color.exeText;
                        break;
                    case 28:
                        textColor[i] = R.color.jesterText;
                        break;
                    case 29:
                        textColor[i] = R.color.witchText;
                        break;
                    case 30:
                        textColor[i] = R.color.amneText;
                        break;
                    case 31:
                        textColor[i] = R.color.survivorText;
                        break;
                    case 32:
                        textColor[i] = R.color.exeText;
                        break;
                }
        }
    }

    private void initializeClassicTextColors() {
        textColor = new int[20];
        for (int i = 0; i < textColor.length; i++) {
            if (i < 14)
                textColor[i] = R.color.townText;
            else if (i < 17)
                textColor[i] = R.color.mafiaText;
            else
                switch (i) {
                    case 17:
                        textColor[i] = R.color.skText;
                        break;
                    case 18:
                        textColor[i] = R.color.exeText;
                        break;
                    case 19:
                        textColor[i] = R.color.jesterText;
                        break;
                }
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_view_element_2, parent, false);

            holder = new ViewHolder();
            holder.textView = (TextView) rowView.findViewById(R.id.listViewElement);
            holder.textView.setText(roles[position]);
            holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
            holder.presentFlag = rowView.findViewById(R.id.presentFlag);
            holder.confirmedFlag = rowView.findViewById(R.id.confirmedFlag);
            fixVisuals(position, rowView, holder);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
            holder.textView = (TextView) rowView.findViewById(R.id.listViewElement);
            holder.textView.setText(roles[position]);
            holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
            fixVisuals(position, rowView, holder);
        }
        return rowView;
    }


    private void fixVisuals(int position, View rowView, ViewHolder holder) {
        switch (mode) {
            case "Ranked":
                if (mainPage.realizedRoles.get(roles[position]) >= 1 || roles[position].equals("Jailor") || roles[position].equals("Godfather") || roles[position].equals("Mafioso"))
                    holder.presentFlag.setVisibility(View.VISIBLE);
                else
                    holder.presentFlag.setVisibility(View.INVISIBLE);

                if (mainPage.confirmedRoles.get(roles[position]) >= 1)
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                else
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);


                if (position < 15) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 24)
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                else
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                break;
            case "Classic": // For Classic

                if (classicPage.realizedClassicRoles.get(roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else
                    holder.presentFlag.setVisibility(View.INVISIBLE);

                if (position < 14) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 17)
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                else
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                break;
            default:  // For Rainbow

                if (rainbowPage.realizedRainbowRoles.get(roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else
                    holder.presentFlag.setVisibility(View.INVISIBLE);

                if (rainbowPage.confirmedRoles.get(roles[position]) >= 1)
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                else
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);

                if (position < 14) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 23)
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                else
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));

                break;
        }
    }
}



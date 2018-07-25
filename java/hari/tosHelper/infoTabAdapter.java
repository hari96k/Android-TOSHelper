package hari.tosHelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class infoTabAdapter extends ArrayAdapter<String> {
    static int[] textColor;
    private final Context context;
    private String mode = startPage.mode;
    private final String[] roles;

    infoTabAdapter(Context context, String[] roles) {
        super(context, R.layout.list_view_element_2, roles);
        this.context = context;
        this.roles = roles;

        switch (mode) {
            case "Ranked" /*1*/:
                initializeTextColors();
                return;
            case "Classic" /*2*/:
                initializeClassicTextColors();
                return;
            case "Rainbow":
                initializeRainbowTextColors();
                return;
            case "Coven Ranked":
                initializeCovenRankedTextColors();
                return;
            case "Coven Custom":
                initializeCovenCustomTextColors();
                return;
            default:
                initializeTextColors();
        }
    }

    private void initializeCovenCustomTextColors() {

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

    private void initializeCovenRankedTextColors() {
        textColor = new int[]{
                // 0-18 town
                R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText,
                // 19 - 24 coven
                R.color.covenText, R.color.covenText, R.color.covenText, R.color.covenText, R.color.covenText, R.color.covenText,
                R.color.arsonistText,
                R.color.juggernautText,
                R.color.skText,
                R.color.wwText,
                R.color.exeText,
                R.color.jesterText,
                R.color.amneText,
                R.color.gaText,
                R.color.survivorText,
                R.color.pirateText,
                R.color.plaguebearerText,
                R.color.pestilenceText,
                R.color.exeText
        };
    }

    private void initializeRainbowTextColors() {
        textColor = new int[]{
                // 0-13 town
                R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText,
                // 14 - 22 mafia
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

    private void initializeClassicTextColors() {
        textColor = new int[]{
                // 0-13 town
                R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText, R.color.townText,
                // 14 - 16 mafia
                R.color.mafiaText, R.color.mafiaText, R.color.mafiaText,
                R.color.skText,
                R.color.exeText,
                R.color.jesterText,
        };
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            rowView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_view_element_2, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.textView = rowView.findViewById(R.id.listViewElement);
            holder.textView.setText(this.roles[position]);
            holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
            holder.presentFlag = rowView.findViewById(R.id.presentFlag);
            holder.confirmedFlag = rowView.findViewById(R.id.confirmedFlag);
            fixVisuals(position, rowView, holder);
            rowView.setTag(holder);
            return rowView;
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.textView = rowView.findViewById(R.id.listViewElement);
        holder.textView.setText(this.roles[position]);
        holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
        fixVisuals(position, rowView, holder);
        return rowView;
    }

    private void fixVisuals(int position, View rowView, ViewHolder holder) {
        switch (mode) {
            case "Ranked" /*0*/:
                if (template.realizedRoles.get(this.roles[position]) >= 1 || this.roles[position].equals("Jailor") || this.roles[position].equals("Godfather") || this.roles[position].equals("Mafioso")) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (template.confirmedRoles.get(this.roles[position]) >= 1) {
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);
                }


                if (position < 15) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 24) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Classic" /*1*/:
                if (classicPage.realizedClassicRoles.get(this.roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (position < 14) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 17) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Custom" /*2*/:
                if (template.realizedRoles.get(this.roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (template.confirmedRoles.get(this.roles[position]) >= 1) {
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);
                }
                if (position < 15) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 24) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Rainbow":
                if (rainbowPage.realizedRainbowRoles.get(this.roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (rainbowPage.confirmedRoles.get(this.roles[position]) >= 1) {
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);
                }
                if (position < 14) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 23) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;

            case "Coven Custom":
                if (customTemplate.realizedRoles.get(this.roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (customTemplate.confirmedRoles.get(this.roles[position]) >= 1) {
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);
                }


                if (position < 19) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 30) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else if (position < 36) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.coven));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Coven Ranked":
                if (template.realizedRoles.get(this.roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (template.confirmedRoles.get(this.roles[position]) >= 1) {
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);
                }
                if (position < 19) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 25) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.coven));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            default:
                if (template.realizedRoles.get(this.roles[position]) >= 1) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (template.confirmedRoles.get(this.roles[position]) >= 1) {
                    holder.confirmedFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.confirmedFlag.setVisibility(View.INVISIBLE);
                }
                if (position < 19) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 25) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.coven));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
        }
    }
}

class ViewHolder {
    View confirmedFlag;
    View presentFlag;
    TextView textView;
}

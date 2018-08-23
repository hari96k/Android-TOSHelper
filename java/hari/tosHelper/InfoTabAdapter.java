package hari.tosHelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class InfoTabAdapter extends ArrayAdapter<String> {
    int[] textColor;
    private final Context context;
    private String mode = startPage.mode;
    private final String[] roles;
    int tabPosition;

    InfoTabAdapter(Context context, String[] roles, int tabPosition) {
        super(context, R.layout.list_view_element_2, roles);
        this.context = context;
        this.roles = roles;
        this.tabPosition = tabPosition;

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
            case "Wiki":
                if(tabPosition == 0){
                    initializeTextColors();
                }else{
                    initializeCovenCustomTextColors();
                }
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
            case "Custom" /*2*/:
                if (position < 15) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 24) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Classic" /*1*/:
                if (position < 14) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 17) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Rainbow":
                if (position < 14) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 23) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Coven Ranked":
                if (position < 19) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                } else if (position < 25) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.coven));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Coven Custom":
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
            case "Wiki":
                // If left tab (Classic Game Mode)
                if(tabPosition == 0) {
                    if (position < 15) {
                        rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                    } else if (position < 24) {
                        rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                    } else {
                        rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                    }
                }
                // If right tab (Coven Game Mode)
                else{
                    if (position < 19) {
                        rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.town));
                    } else if (position < 30) {
                        rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                    } else if (position < 36) {
                        rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.coven));
                    } else {
                        rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                    }
                }
                break;
            default:
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
    TextView textView;
}

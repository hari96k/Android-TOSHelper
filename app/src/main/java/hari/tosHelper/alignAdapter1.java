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
        String[] modeNameParsed = startPage.mode.split(" ");
        if (modeNameParsed[0].equals("Coven")) {
            initializeCovenTextColors();
        } else {
            initializeTextColors();
        }
    }

    private void initializeCovenTextColors() {
        textColor = new int[50];
        for (int i = 0; i < textColor.length; i++) {
            if (i >= 19) {
                if (i >= 30) {
                    if (i >= 36) {
                        textColor[i] = R.color.skText;
                        switch (i) {
                            case 36 /*24*/:
                                textColor[i] = R.color.arsonistText;
                                break;
                            case 37 /*25*/:
                                textColor[i] = R.color.juggernautText;
                                break;
                            case 38 /*25*/:
                                textColor[i] = R.color.skText;
                                break;
                            case 39 /*26*/:
                                textColor[i] = R.color.wwText;
                                break;
                            case 40 /*27*/:
                                textColor[i] = R.color.exeText;
                                break;
                            case 41   /*28*/:
                                textColor[i] = R.color.jesterText;
                                break;
                            case 42 /*29*/:
                                textColor[i] = R.color.witchText;
                                break;
                            case 43 /*30*/:
                                textColor[i] = R.color.amneText;
                                break;
                            case 44 /*32*/:
                                textColor[i] = R.color.gaText;
                                break;
                            case 45 /*31*/:
                                textColor[i] = R.color.survivorText;
                                break;
                            case 46 /*32*/:
                                textColor[i] = R.color.pirateText;
                                break;
                            case 47 /*32*/:
                                textColor[i] = R.color.plaguebearerText;
                                break;
                            case 48 /*32*/:
                                textColor[i] = R.color.pestilenceText;
                                break;
                            case 49 /*32*/:
                                textColor[i] = R.color.exeText;
                                break;
                            default:
                                break;
                        }
                    } else {
                        textColor[i] = R.color.covenText;
                    }
                } else {
                    textColor[i] = R.color.mafiaText;
                }
            } else {
                textColor[i] = R.color.townText;
            }
        }
    }

    private void initializeTextColors() {
        textColor = new int[33];
        for (int i = 0; i < textColor.length; i++) {
            if (i >= 15) {
                if (i >= 24) {
                    switch (i) {
                        case 24 /*24*/:
                            textColor[i] = R.color.arsonistText;
                            break;
                        case 25 /*25*/:
                            textColor[i] = R.color.skText;
                            break;
                        case 26 /*26*/:
                            textColor[i] = R.color.wwText;
                            break;
                        case 27 /*27*/:
                            textColor[i] = R.color.exeText;
                            break;
                        case 28 /*28*/:
                            textColor[i] = R.color.jesterText;
                            break;
                        case 29 /*29*/:
                            textColor[i] = R.color.witchText;
                            break;
                        case 30 /*30*/:
                            textColor[i] = R.color.amneText;
                            break;
                        case 31 /*31*/:
                            textColor[i] = R.color.survivorText;
                            break;
                        case 32 /*32*/:
                            textColor[i] = R.color.exeText;
                            break;
                        default:
                            break;
                    }
                } else {
                    textColor[i] = R.color.mafiaText;
                }
            } else {
                textColor[i] = R.color.townText;
            }
        }
    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            rowView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_view_element_3, parent, false);
            ViewHolder4 holder = new ViewHolder4();
            holder.textView = rowView.findViewById(R.id.listViewElement);
            holder.textView.setText(this.roles[position]);
            holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
            holder.presentFlag = rowView.findViewById(R.id.presentFlag);
            holder.confirmedFlag = rowView.findViewById(R.id.confirmedFlag);
            rowView.setTag(holder);
            return rowView;
        }
        ViewHolder4 holder = (ViewHolder4) rowView.getTag();
        holder.textView = rowView.findViewById(R.id.listViewElement);
        holder.textView.setText(this.roles[position]);
        holder.textView.setTextColor(ContextCompat.getColor(getContext(), textColor[position]));
        return rowView;
    }
}

package hari.tosHelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

class infoTabAdapter extends ArrayAdapter<String> {
    static int[] textColor;
    private final Context context;
    private final String[] roles;
    private String mode = startPage.mode;

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

        textColor = new int[49];
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
                                textColor[i] = R.color.skText;
                                break;
                            case 38 /*26*/:
                                textColor[i] = R.color.wwText;
                                break;
                            case 39 /*27*/:
                                textColor[i] = R.color.exeText;
                                break;
                            case 40   /*28*/:
                                textColor[i] = R.color.jesterText;
                                break;
                            case 41 /*29*/:
                                textColor[i] = R.color.witchText;
                                break;
                            case 42 /*30*/:
                                textColor[i] = R.color.amneText;
                                break;
                            case 43 /*32*/:
                                textColor[i] = R.color.offWhite;
                                break;
                            case 44 /*31*/:
                                textColor[i] = R.color.survivorText;
                                break;
                            case 45 /*32*/:
                                textColor[i] = R.color.pirateText;
                                break;
                            case 46 /*32*/:
                                textColor[i] = R.color.plaguebearerText;
                                break;
                            case 47 /*32*/:
                                textColor[i] = R.color.pestilenceText;
                                break;
                            case 48 /*32*/:
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

    private void initializeCovenRankedTextColors() {
        textColor = new int[39];
        for (int i = 0; i < textColor.length; i++) {
            if (i >= 19) {
                if (i >= 27) {
                    switch (i) {
                        case 27 /*24*/:
                            textColor[i] = R.color.arsonistText;
                            break;
                        case 28 /*25*/:
                            textColor[i] = R.color.skText;
                            break;
                        case 29 /*26*/:
                            textColor[i] = R.color.wwText;
                            break;
                        case 30 /*27*/:
                            textColor[i] = R.color.exeText;
                            break;
                        case 31   /*28*/:
                            textColor[i] = R.color.jesterText;
                            break;
                        case 32 /*30*/:
                            textColor[i] = R.color.amneText;
                            break;
                        case 33 /*32*/:
                            textColor[i] = R.color.offWhite;
                            break;
                        case 34 /*31*/:
                            textColor[i] = R.color.survivorText;
                            break;
                        case 35 /*32*/:
                            textColor[i] = R.color.pirateText;
                            break;
                        case 36 /*32*/:
                            textColor[i] = R.color.plaguebearerText;
                            break;
                        case 37 /*32*/:
                            textColor[i] = R.color.pestilenceText;
                            break;
                        case 38 /*32*/:
                            textColor[i] = R.color.exeText;
                            break;
                        default:
                            break;
                    }
                } else {
                    textColor[i] = R.color.covenText;
                }
            } else {
                textColor[i] = R.color.townText;
            }
        }
    }

    private void initializeRainbowTextColors() {
        textColor = new int[32];
        for (int i = 0; i < textColor.length; i++) {
            if (i >= 14) {
                if (i >= 23) {
                    switch (i) {
                        case 23 /*23*/:
                            textColor[i] = R.color.arsonistText;
                            break;
                        case 24 /*24*/:
                            textColor[i] = R.color.skText;
                            break;
                        case 25 /*25*/:
                            textColor[i] = R.color.wwText;
                            break;
                        case 26 /*26*/:
                            textColor[i] = R.color.exeText;
                            break;
                        case 27 /*27*/:
                            textColor[i] = R.color.jesterText;
                            break;
                        case 28 /*28*/:
                            textColor[i] = R.color.witchText;
                            break;
                        case 29 /*29*/:
                            textColor[i] = R.color.amneText;
                            break;
                        case 30 /*30*/:
                            textColor[i] = R.color.survivorText;
                            break;
                        case 31 /*31*/:
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

    private void initializeClassicTextColors() {
        textColor = new int[20];
        for (int i = 0; i < textColor.length; i++) {
            if (i >= 14) {
                if (i >= 17) {
                    switch (i) {
                        case 17 /*17*/:
                            textColor[i] = R.color.skText;
                            break;
                        case 18 /*18*/:
                            textColor[i] = R.color.exeText;
                            break;
                        case 19 /*19*/:
                            textColor[i] = R.color.jesterText;
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
                if (mainPage.realizedRoles.get(this.roles[position]) >= 1 || this.roles[position].equals("Jailor") || this.roles[position].equals("Godfather") || this.roles[position].equals("Mafioso")) {
                    holder.presentFlag.setVisibility(View.VISIBLE);
                } else {
                    holder.presentFlag.setVisibility(View.INVISIBLE);
                }
                if (mainPage.confirmedRoles.get(this.roles[position]) >= 1) {
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
                } else if (position < 30) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mafia));
                } else if (position < 36) {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.coven));
                } else {
                    rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.neutral));
                }
                break;
            case "Coven Ranked":
                System.out.println(this.roles[position]);
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
                System.out.println(this.roles[position]);
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

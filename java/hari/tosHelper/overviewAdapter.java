package hari.tosHelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;

class overviewAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] names;
    private View header;

    overviewAdapter(Context context, String[] names, View header) {
        super(context, R.layout.overview_element, names);
        this.context = context;
        this.names = names;
        this.header = header;
    }

    @NonNull
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        LayoutParams hparams = this.header.getLayoutParams();
        if (hparams != null) {
            hparams.height = mainPage.standardTitleHeight;
        }
        LayoutParams params;
        ViewHolder2 holder;
        if (rowView == null) {
            rowView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.overview_element, parent, false);
            params = rowView.getLayoutParams();
            if (params != null) {
                params.height = mainPage.standardHeight;
            }
            holder = new ViewHolder2();
            holder.name = rowView.findViewById(R.id.playerContainer);
            holder.name.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    overviewAdapter.this.names[position] = s.toString();
                }
            });
            holder.position = rowView.findViewById(R.id.positionTitle);
            holder.role = rowView.findViewById(R.id.playerRole);
            holder.name.setText(this.names[position]);
            holder.position.setText(Integer.toString(position + 1));
            holder.name.setHorizontallyScrolling(false);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder2) rowView.getTag();
            holder.role.setText(overviewTab.allPlayerRoles[position]);
            params = rowView.getLayoutParams();
            if (params != null) {
                params.height = mainPage.standardHeight;
            }
            if (overviewTab.allPlayerRoles[position] == null || overviewTab.allPlayerRoles[position].length() == 0) {
                rowView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
            } else {
                int color;
                color = mainPage.roleBackground.get(overviewTab.allPlayerRoles[position]);
                holder.role.setTextColor(ContextCompat.getColor(getContext(), mainPage.roleColors.get(overviewTab.allPlayerRoles[position])));
                rowView.setBackgroundColor(ContextCompat.getColor(getContext(), color));
            }
        }
        return rowView;
    }
}

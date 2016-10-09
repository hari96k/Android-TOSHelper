package hari.tosHelper;

import android.content.Context;
import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

class ViewHolder2 {
    protected View nameView;
    protected View presentFlag;
    public View confirmedFlag;
}


class overviewAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] names;


    public overviewAdapter(Context context, String[] names) {
        super(context, R.layout.overview_element, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder2 holder;
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.overview_element, parent, false);

            holder = new ViewHolder2();
            holder.nameView = rowView.findViewById(R.id.player);
            holder.presentFlag = rowView.findViewById(R.id.presentFlag);
            holder.confirmedFlag = rowView.findViewById(R.id.confirmedFlag);

            if (position >= 1) {
                ((EditText) holder.nameView).setText(names[position]);
            }
            else{
                PercentRelativeLayout.LayoutParams params = (PercentRelativeLayout.LayoutParams) holder.nameView.getLayoutParams();
                ViewGroup layout = (ViewGroup) holder.nameView.getParent();
                layout.removeView(holder.nameView);
                TextView title = new TextView(context);
                title.setText(R.string.players);
                title.setId(R.id.player);
                holder.nameView = title;

                PercentLayoutHelper.PercentLayoutInfo info = params.getPercentLayoutInfo();
                info.heightPercent = 0.08f;
                holder.nameView.requestLayout();
            }
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder2) rowView.getTag();

            if (position >= 1) {
                ((EditText) holder.nameView).setText(names[position]);
            }
            else{
                PercentRelativeLayout.LayoutParams params = (PercentRelativeLayout.LayoutParams) holder.nameView.getLayoutParams();
                PercentLayoutHelper.PercentLayoutInfo info = params.getPercentLayoutInfo();
                info.heightPercent = 0.08f;
                holder.nameView.requestLayout();
            }
        }
        return rowView;
    }

}



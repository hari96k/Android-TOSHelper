package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class selectPos extends Activity {
    private ListView list;
    private LayoutParams params;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_pos);
        this.list = findViewById(R.id.listViewPos);
        this.params = (LayoutParams) this.list.getLayoutParams();
        setDynamicText(getIntent().getStringArrayExtra("player"));
        populateListView();
        registerClickCallBack();
    }

    protected void onRestart() {
        super.onRestart();
        populateListView();
    }

    private void setDynamicText(String[] array) {
        TextView currentPosition = findViewById(R.id.currentPos);
        Button deleteButton = findViewById(R.id.buttonPosField);
        TextView alignmentText = findViewById(R.id.alignmentDescrip);
        alignmentText.setText(array[0]);
        try {
            alignmentText.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.alignmentColors.get(array[0])));
        } catch (NullPointerException e) {
            alignmentText.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(array[0])));
        }
        if (array[2].length() == 0 || array[0].equals(array[2])) {
            View slash = findViewById(R.id.slash);
            View role = findViewById(R.id.roleDescrip);
            ((ViewGroup) slash.getParent()).removeView(slash);
            ((ViewGroup) role.getParent()).removeView(role);
        } else {
            TextView roleText = findViewById(R.id.roleDescrip);
            roleText.setText(array[2]);
            roleText.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(array[2])));
        }
        if (array[1].length() != 0) {
            String playerName = overviewTab.allPlayerNames[Integer.parseInt(array[1]) - 1];
            if (!(playerName == null || playerName.isEmpty())) {
                playerName = "(" + playerName + ")";
            }
            currentPosition.setText("Current Position: " + array[1] + " " + playerName + " ");
            currentPosition.setVisibility(View.VISIBLE);
            deleteButton.setVisibility(View.VISIBLE);
            this.params.addRule(3, R.id.prevRoleGroup);
            this.list.setLayoutParams(this.params);
            findViewById(R.id.prevRoleGroup).setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.tint, null));
            return;
        }
        currentPosition.setVisibility(View.INVISIBLE);
        deleteButton.setVisibility(View.INVISIBLE);
        this.params.addRule(3, R.id.posDescripGroup);
        this.list.setLayoutParams(this.params);
    }

    private void populateListView() {
        String[] positions;
        int i2;
        int posNumber;
        String playerName;
        switch (startPage.mode) {
            case "Ranked" /*0*/:
            case "Rainbow":
                positions = new String[template.remainingPositions.size()];
                for (i2 = 0; i2 < positions.length; i2++) {
                    positions[i2] = (template.remainingPositions.get(i2)).toString();
                    if (positions[i2].length() <= 1) {
                        posNumber = Integer.parseInt(positions[i2]);
                    } else if (positions[i2].charAt(1) == '.') {
                        posNumber = Character.getNumericValue(positions[i2].charAt(0));
                    } else {
                        posNumber = Integer.parseInt(positions[i2].substring(0, 2));
                    }
                    playerName = overviewTab.allPlayerNames[posNumber - 1];
                    if (!(playerName == null || playerName.length() == 0)) {
                        positions[i2] = positions[i2] + ". " + playerName;
                    }
                }
                break;
            case "Custom" /*1*/:
            case "Coven Custom":
                positions = new String[customTemplate.remainingPositions.size()];
                for (i2 = 0; i2 < positions.length; i2++) {
                    positions[i2] = (customTemplate.remainingPositions.get(i2)).toString();
                    if (positions[i2].length() <= 1) {
                        posNumber = Integer.parseInt(positions[i2]);
                    } else if (positions[i2].charAt(1) == '.') {
                        posNumber = Character.getNumericValue(positions[i2].charAt(0));
                    } else {
                        posNumber = Integer.parseInt(positions[i2].substring(0, 2));
                    }
                    playerName = overviewTab.allPlayerNames[posNumber - 1];
                    if (!(playerName == null || playerName.length() == 0)) {
                        positions[i2] = positions[i2] + ". " + playerName;
                    }
                }
                break;
            default:
                positions = new String[template.remainingPositions.size()];
                for (i2 = 0; i2 < positions.length; i2++) {
                    positions[i2] = (template.remainingPositions.get(i2)).toString();
                    if (positions[i2].length() <= 1) {
                        posNumber = Integer.parseInt(positions[i2]);
                    } else if (positions[i2].charAt(1) == '.') {
                        posNumber = Character.getNumericValue(positions[i2].charAt(0));
                    } else {
                        posNumber = Integer.parseInt(positions[i2].substring(0, 2));
                    }
                    playerName = overviewTab.allPlayerNames[posNumber - 1];
                    if (!(playerName == null || playerName.length() == 0)) {
                        positions[i2] = positions[i2] + ". " + playerName;
                    }
                }
                break;
        }
        this.list.setAdapter(new ArrayAdapter<>(this, R.layout.list_view_element, positions));
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                String selection = ((TextView) view).getText().toString();
                intent = new Intent(selectPos.this, template.class);
                intent.putExtra("selection", selection);
                selectPos.this.setResult(-1, intent);
                selectPos.this.finish();
            }
        });
    }

    public void deletePos(View view) {
        Intent intent;
        intent = new Intent(this, template.class);
        intent.putExtra("selection", "delete");
        setResult(-1, intent);
        finish();
    }
}

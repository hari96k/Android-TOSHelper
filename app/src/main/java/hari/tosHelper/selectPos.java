package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class selectPos extends Activity {

    private ListView list;
    private RelativeLayout.LayoutParams params;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_pos);
        list = (ListView) findViewById(R.id.listViewPos);
        params = (RelativeLayout.LayoutParams) list.getLayoutParams();

        String[] player = getIntent().getStringArrayExtra("player");
        setDynamicText(player);
        populateListView();
        registerClickCallBack();
    }

    private void setDynamicText(String[] array) {
        TextView currentPosition = (TextView) findViewById(R.id.currentPos);
        Button deleteButton = (Button) findViewById(R.id.buttonPosField);
        String curPos;

        // Set alignment color and text
        TextView alignmentText = (TextView) findViewById(R.id.alignmentDescrip);
        alignmentText.setText(array[0]);

        alignmentText.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.alignmentColors.get(array[0])));

        // If there is no role for this position

        if (array[2].length() == 0) {
            View slash = findViewById(R.id.slash);
            View role = findViewById(R.id.roleDescrip);
            ((ViewGroup) slash.getParent()).removeView(slash);
            ((ViewGroup) role.getParent()).removeView(role);
        }

        // If there is a role for this position
        else {
            // Set role color and text
            TextView roleText = (TextView) findViewById(R.id.roleDescrip);
            roleText.setText(array[2]);
            roleText.setTextColor(ContextCompat.getColor(getApplicationContext(), mainPage.roleColors.get(array[2])));
        }

        // If position exists
        if (array[1].length() != 0) {
            curPos = "Current Position: " + array[1] + " ";
            currentPosition.setText(curPos);
            currentPosition.setVisibility(View.VISIBLE);
            deleteButton.setVisibility(View.VISIBLE);
            params.addRule(RelativeLayout.BELOW, R.id.prevRoleGroup);
            list.setLayoutParams(params);
        } else {
            currentPosition.setVisibility(View.INVISIBLE);
            deleteButton.setVisibility(View.INVISIBLE);
            params.addRule(RelativeLayout.BELOW, R.id.posDescripGroup);
            list.setLayoutParams(params);
        }


    }

    private void populateListView() {
        String[] positions;
        if (startPage.mode.equals("Ranked")) {
            positions = new String[mainPage.remainingPositions.size()];
            for (int i = 0; i < positions.length; i++) {
                positions[i] = mainPage.remainingPositions.get(i).toString();
            }
        } else {// if (startPage.mode.equals("Rainbow"))
            positions = new String[rainbowPage.remainingPositions.size()];
            for (int i = 0; i < positions.length; i++) {
                positions[i] = rainbowPage.remainingPositions.get(i).toString();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_element, positions);
        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                String selection = textView.getText().toString();

                Intent intent;
                if (startPage.mode.equals("Ranked"))
                    intent = new Intent(selectPos.this, mainPage.class);
                else
                    intent = new Intent(selectPos.this, rainbowPage.class);

                intent.putExtra("selection", selection);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    public void deletePos(View view) {

        Intent intent;
        if (startPage.mode.equals("Ranked"))
            intent = new Intent(selectPos.this, mainPage.class);
        else
            intent = new Intent(selectPos.this, rainbowPage.class);

        intent.putExtra("selection", "delete");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
package hari.tosHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class selectAlign extends Activity {
    private ListView list;
    private ListView list2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_align);
        this.list = findViewById(R.id.alignmentsList);
        this.list2 = findViewById(R.id.rolesList);
        populateListViews();
        registerClickCallBack();
    }

    protected void onRestart() {
        super.onRestart();
        populateListViews();
    }

    private void populateListViews() {
//        if(startPage.mode.equals("Custom")) {
            this.list.setAdapter(new alignAdapter0(this, InfoTab.AllAlignments));
            this.list2.setAdapter(new alignAdapter1(this, InfoTab.AllRoles));
//        }else{
//            this.list.setAdapter(new alignAdapter0(this, InfoTab.AllAlignments, false));
//            this.list2.setAdapter(new alignAdapter1(this, InfoTab.AllRoles, false));
//        }
    }

    private void registerClickCallBack() {
        this.list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(selectAlign.this, customTemplate.class);
                intent.putExtra("alignment", selection);
                selectAlign.this.setResult(-1, intent);
                selectAlign.this.finish();
            }
        });
        this.list2.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                Intent intent = new Intent(selectAlign.this, customTemplate.class);
                intent.putExtra("role", selection);
                selectAlign.this.setResult(-1, intent);
                selectAlign.this.finish();
            }
        });
    }
}

package com.example.pj0412;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    String page = "http://192.168.56.1:8887/language.json";
    int type = 1;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch toggle = findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if(ischecked) {
                    toggle.setText("Glide 사용");
                    flag = true;
                } else {
                    toggle.setText("Glide 사용안함");
                    flag = false;
                }
            }
        });
        ListView listView = findViewById(R.id.listview);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type ==1) {
                    JSONVolly volly = new JSONVolly(MainActivity.this);
                    volly.request(page, listView, type, flag);
                } else {
                    JSONFastNetwork fastNetwork = new JSONFastNetwork(MainActivity.this);
                    fastNetwork.request(page, listView, type, flag);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                type = 1;
                break;
            case R.id.item2:
                type = 2;
                break;
        }
        item.setChecked(true);
        return true;
    }
}
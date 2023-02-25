package com.example.formprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivityShow extends AppCompatActivity {
ListView lvshowitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_show);
        lvshowitem = findViewById(R.id.lvshow);
        Intent intent = getIntent();
        String showprofileitem [] = intent.getStringArrayExtra("showprofile");
        ArrayAdapter<String> adapter= new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, showprofileitem);
        lvshowitem.setAdapter(adapter);
    }
}
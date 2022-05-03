package com.example.pr_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    String[] subs = {"ETI","EDE","MAD","PWP","WPB","MGT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,subs);

        AutoCompleteTextView auto = findViewById(R.id.auto);
        auto.setThreshold(1);
        auto.setAdapter(adapter);
    }
}
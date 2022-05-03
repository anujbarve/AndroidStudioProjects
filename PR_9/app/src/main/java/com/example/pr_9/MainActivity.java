package com.example.pr_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton tb = findViewById(R.id.tb);
        TextView txt = findViewById(R.id.txt);

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb.isChecked()) {
                    txt.setVisibility(View.VISIBLE);
                } else {
                    txt.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
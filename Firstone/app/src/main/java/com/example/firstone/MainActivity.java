package com.blogspot.codingatharva.manualprograms;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private ToggleButton tb1;
    private ImageButton img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb1 = findViewById(R.id.tb1);
        img = findViewById(R.id.img);
        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb1.isChecked())
                {
                    img.setVisibility(View.VISIBLE);
                }
                else
                {
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
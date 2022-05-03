package com.example.pr_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rb1,rb2,rgb;
    RadioGroup rg;
    Button b;
    StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = new StringBuffer("You Selected");
        b = findViewById(R.id.btn);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rg = findViewById(R.id.rg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rgb = findViewById(rg.getCheckedRadioButtonId());
                if(rb1.isChecked()){
                    sb.append("\n" + rb1.getText());
                }
                if(rb2.isChecked()){
                    sb.append("\n" + rb2.getText());
                }
                if (rgb.isChecked()) {
                    sb.append("\n" + rgb.getText());
                }
                Toast.makeText(MainActivity.this, sb, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
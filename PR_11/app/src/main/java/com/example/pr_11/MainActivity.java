package com.example.pr_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1,cb2,cb3,cb4,cb5;
    Button btn;
    StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = new StringBuffer("You Selected ");
        btn = findViewById(R.id.btn);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked()){sb.append(" Android ");};
                if(cb2.isChecked()){sb.append(" Python ");};
                if(cb3.isChecked()){sb.append(" PHP ");};
                if(cb4.isChecked()){sb.append(" C ");};
                if(cb5.isChecked()){sb.append(" Java ");};

                Toast.makeText(MainActivity.this, sb, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
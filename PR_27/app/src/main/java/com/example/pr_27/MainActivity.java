package com.example.pr_27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.button);
        name = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n = name.getText().toString();
                String p = password.getText().toString();

                if(n.equals("admin") && p.equals("password")){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
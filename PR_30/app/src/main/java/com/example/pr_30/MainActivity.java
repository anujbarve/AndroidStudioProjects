package com.example.pr_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // define objects for edit text and button
    Button button;
    EditText sendto, subject, body;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendto = findViewById(R.id.editText1);
        subject = findViewById(R.id.editText2);
        body = findViewById(R.id.editText3);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                String emailsend = sendto.getText().toString();
                String emailsubject = subject.getText().toString();
                String emailbody = body.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[] { emailsend });
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose an Email client :"));
            }
        });
    }
}
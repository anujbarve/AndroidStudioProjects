package com.example.pr_26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;

public class MainActivity extends AppCompatActivity {
    EditText ename,eroll_no,emarks;
    Button add,view,viewall,Show1,delete,modify;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename=(EditText)findViewById(R.id.name);
        eroll_no=(EditText)findViewById(R.id.roll_no);
        emarks=(EditText)findViewById(R.id.marks);
        add=(Button)findViewById(R.id.addbtn);
        viewall=(Button)findViewById(R.id.viewallbtn);
        delete=(Button)findViewById(R.id.deletebtn);

        db=openOrCreateDatabase("Student_manage", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno INTEGER,name VARCHAR,marks INTEGER);");


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(eroll_no.getText().toString().trim().length()==0||
                        ename.getText().toString().trim().length()==0||
                        emarks.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO student VALUES('"+eroll_no.getText()+"','"+ename.getText()+
                        "','"+emarks.getText()+"');");
                showMessage("Success", "Record added successfully");
                clearText();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(eroll_no.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter Rollno");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+eroll_no.getText()+"'", null);
                if(c.moveToFirst())
                {
                    db.execSQL("DELETE FROM student WHERE rollno='"+eroll_no.getText()+"'");
                    showMessage("Success", "Record Deleted");
                }
                else
                {
                    showMessage("Error", "Invalid Rollno");
                }
                clearText();
            }
        });
        viewall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Cursor c=db.rawQuery("SELECT * FROM student", null);
                if(c.getCount()==0)
                {
                    showMessage("Error", "No records found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(c.moveToNext())
                {
                    buffer.append("Rollno: "+c.getString(0)+"\n");
                    buffer.append("Name: "+c.getString(1)+"\n");
                    buffer.append("Marks: "+c.getString(2)+"\n\n");
                }
                showMessage("Student Details", buffer.toString());
            }
        });

    }
    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        eroll_no.setText("");
        ename.setText("");
        emarks.setText("");
        eroll_no.requestFocus();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.student_main, menu);
        return true;
    }
}
package com.example.tangdwx.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class personsActivity extends AppCompatActivity {

    private float totalprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        Intent intent=new Intent();
        Bundle b=new Bundle();
        totalprice=getIntent().getExtras().getFloat("total");
    }
    public void compute(View view) {
        int persons;
        EditText dName = (EditText) findViewById(R.id.persons);
        String temp = dName.getText().toString();
        if(temp.length() == 0)
            Toast.makeText(this, "Hey, how many guys you are?", Toast.LENGTH_LONG).show();
        else{
            persons = Integer.parseInt(temp);
            if(persons == 0)
                Toast.makeText(this, "Man, nobody means infinity", Toast.LENGTH_LONG).show();
            else {
                float per = totalprice / persons;
                Toast.makeText(this, "OK, everyone should pay $"+ per, Toast.LENGTH_LONG).show();
            }
        }
    }
}

package com.example.tangdwx.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private float totalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialation();
    }
    private void Initialation() {
        totalPrice = 0;
    }
    public void myClick(View view) {
    }
    public void add(View view) {
        String dishName;
        float dishPrice;
        EditText dName = (EditText) findViewById(R.id.newDish);
        EditText dPrice = (EditText) findViewById(R.id.dishprice);
        dishName = dName.getText().toString();
        if(dishName.length() == 0) {
            //no name
            Toast.makeText(this,"Well, you didn't write what the dish called yet...",Toast.LENGTH_LONG).show();
        }
        else  {
            String temp = dPrice.getText().toString();
            if(temp.length() == 0)
                // no price
                Toast.makeText(this,"Next, you didn't write how much it is...",Toast.LENGTH_LONG).show();
            else {
                //Finally everything is Ready here
                dishPrice = Float.parseFloat(temp);
                totalPrice = totalPrice + dishPrice;
                Toast.makeText(this,"OK, this dish is $"+dishPrice+", then total is $"+totalPrice,Toast.LENGTH_LONG).show();
                Toast.makeText(this,"Is that all?",Toast.LENGTH_LONG).show();
            }
        }
    }
    public void goPersons(View view) {
        Intent it = new Intent(this,personsActivity.class);
        Bundle bd = new Bundle();
        bd.putFloat("total",totalPrice);
        it.putExtras(bd);
        startActivity(it);
    }
}


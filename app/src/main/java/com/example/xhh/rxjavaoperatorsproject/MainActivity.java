package com.example.xhh.rxjavaoperatorsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button01);
        button1 = findViewById(R.id.button02);
        button2 = findViewById(R.id.button03);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button01:
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
                break;
            case R.id.button02:
                Intent intent1 = new Intent(MainActivity.this, ZipActivity.class);
                startActivity(intent1);
                break;
            case R.id.button03:
                Intent intent2 = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent2);
                break;


        }
    }
}

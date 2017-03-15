package com.guowei.weather.widgettest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String UPDATE="zcj";
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.add);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent updateIntent = new Intent(UPDATE);
        this.sendBroadcast(updateIntent);
    }
}

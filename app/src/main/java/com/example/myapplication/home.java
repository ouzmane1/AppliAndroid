package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.btnCommencer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent debut = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(debut);
            }
        });
    }
}
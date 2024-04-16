package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_choice extends AppCompatActivity {
    private Button pays;
    private Button partenaire;
    private Button produit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        pays = findViewById(R.id.btnPays);
        pays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentpays = new Intent(getApplicationContext(), PaysActivity.class);
                startActivity(intentpays);
            }
        });
        partenaire = findViewById(R.id.btnPartnaire);
        partenaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentpartnaire = new Intent(getApplicationContext(), PartnerActivity.class);
                startActivity(intentpartnaire);
            }
        });
        produit = findViewById(R.id.btnProduit);
        produit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentproduit = new Intent(getApplicationContext(), ProduitActivity.class);
                startActivity(intentproduit);
            }
        });
    }
}
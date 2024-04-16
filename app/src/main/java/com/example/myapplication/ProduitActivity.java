package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProduitActivity extends AppCompatActivity {
    JSONArray jArray;
    JSONObject json_data;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);
        jArray=null;
        EditText rech = (findViewById(R.id.rech));
        findViewById(R.id.buttonProduit).setOnClickListener(view -> {
            try {
                String adresse = "http://192.168.1.106/testProduit.php?rech="+rech.getText().toString();
                String wololo = new HTTPRequest.HTTPSELECTRequest().execute(adresse).get();
                jArray = new JSONArray(wololo);
                i=0;
                json_data = jArray.getJSONObject(i);
                ((TextView) findViewById(R.id.NomProduit)).setText(json_data.getString("name"));
                ((TextView) findViewById(R.id.NomComplet)).setText(json_data.getString("complete_name"));
                ((TextView) findViewById(R.id.Path)).setText(json_data.getString("parent_path"));
                ((TextView) findViewById(R.id.Method)).setText(json_data.getString("packaging_reserve_method"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.buttonProduit2).setOnClickListener(view -> {
            try {
                if(i>0) {
                    i--;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.NomProduit)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.NomComplet)).setText(json_data.getString("complete_name"));
                    ((TextView) findViewById(R.id.Path)).setText(json_data.getString("parent_path"));
                    ((TextView) findViewById(R.id.Method)).setText(json_data.getString("packaging_reserve_method"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.buttonProduit3).setOnClickListener(view -> {
            try {
                if(i<jArray.length()-1) {
                    i++;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.NomProduit)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.NomComplet)).setText(json_data.getString("complete_name"));
                    ((TextView) findViewById(R.id.Path)).setText(json_data.getString("parent_path"));
                    ((TextView) findViewById(R.id.Method)).setText(json_data.getString("packaging_reserve_method"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
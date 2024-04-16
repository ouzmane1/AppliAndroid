package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class PaysActivity extends AppCompatActivity {

    JSONArray jArray;
    JSONObject json_data;
    int i;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pays);
        jArray=null;
        EditText rech = (findViewById(R.id.rechP));
        findViewById(R.id.buttonPays).setOnClickListener(view -> {
            try {
                String adresse = "http://192.168.1.106/testPays.php?rech="+rech.getText().toString();
                String wololo = new HTTPRequest.HTTPSELECTRequest().execute(adresse).get();
                jArray = new JSONArray(wololo);
                i=0;
                json_data = jArray.getJSONObject(i);
                ((TextView) findViewById(R.id.CodePays)).setText(json_data.getString("code"));
                ((TextView) findViewById(R.id.Code)).setText(json_data.getString("phone_code"));
                ((TextView) findViewById(R.id.NomPays)).setText(json_data.getString("name"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.buttonPays2).setOnClickListener(view -> {
            try {
                if(i>0) {
                    i--;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.CodePays)).setText(json_data.getString("code"));
                    ((TextView) findViewById(R.id.Code)).setText(json_data.getString("phone_code"));
                    ((TextView) findViewById(R.id.NomPays)).setText(json_data.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.buttonPays3).setOnClickListener(view -> {
            try {
                if(i<jArray.length()-1) {
                    i++;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.CodePays)).setText(json_data.getString("code"));
                    ((TextView) findViewById(R.id.Code)).setText(json_data.getString("phone_code"));
                    ((TextView) findViewById(R.id.NomPays)).setText(json_data.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
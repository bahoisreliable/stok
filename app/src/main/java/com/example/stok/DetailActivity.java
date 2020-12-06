package com.example.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView detayIsim;
    TextView detayFiyat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detayIsim = (TextView) findViewById(R.id.detayIsim);
        detayFiyat = (TextView) findViewById(R.id.detayFiyat);

        Intent intent=getIntent();
        detayIsim.setText(intent.getStringExtra("isim"));
        detayFiyat.setText(intent.getStringExtra("fiyat"));

    }

    public void don(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
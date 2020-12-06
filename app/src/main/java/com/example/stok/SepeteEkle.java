package com.example.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SepeteEkle extends AppCompatActivity {

    TextView isimText;
    TextView fiyatText;
    TextView urunToplam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepete_ekle);

        isimText = (TextView) findViewById(R.id.textViewUrunAdi);
        fiyatText = (TextView) findViewById(R.id.textViewUrunFiyat);
        urunToplam = (TextView) findViewById(R.id.textViewUrunToplam);

        Intent intent = getIntent();

        isimText.setText(intent.getStringExtra("name"));
        fiyatText.setText(intent.getStringExtra("price"));
        urunToplam.setText(intent.getStringExtra("price"));

    }

    public void arttir(View view){
        int eklenecekDeger;
        int toplanDeger;
        int sonDeger;
        eklenecekDeger=Integer.parseInt(fiyatText.getText().toString());
        toplanDeger = Integer.parseInt(urunToplam.getText().toString());

        sonDeger = eklenecekDeger+toplanDeger;
        if (sonDeger <= 0)
            urunToplam.setText("0");
        else
            urunToplam.setText(String.valueOf(sonDeger));
    }

    public void azalt(View view){
        int cikarilacakDeger;
        int toplanDeger;
        int sonDeger;
        cikarilacakDeger = Integer.parseInt(fiyatText.getText().toString());
        toplanDeger = Integer.parseInt(urunToplam.getText().toString());

        sonDeger = toplanDeger - cikarilacakDeger;
        if (sonDeger <= 0)
            urunToplam.setText("0");
        else
            urunToplam.setText(String.valueOf(sonDeger));
    }

    public void sepeteEkle(View view){
        int toplam;
        int fiyat;
        int adet;

        fiyat = Integer.parseInt(fiyatText.getText().toString());
        toplam = Integer.parseInt(urunToplam.getText().toString());
        adet = toplam / fiyat;

        KayitActivity.database.execSQL("CREATE TABLE IF NOT EXISTS sepet (isim VARCHAR, fiyat INT, adet INT)");
        String sqlString = "INSERT INTO sepet (isim, fiyat,adet) VALUES (?,?,?)";
        SQLiteStatement statement = KayitActivity.database.compileStatement(sqlString);
        statement.bindString(1,isimText.getText().toString());
        statement.bindString(2,fiyatText.getText().toString());
        statement.bindString(3,String.valueOf(adet));
        statement.execute();

        Intent intent = new Intent(getApplicationContext(),IslemActivity.class);
        startActivity(intent);
    }
}
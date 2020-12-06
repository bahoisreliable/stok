package com.example.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ListView listView = (ListView) findViewById(R.id.listviewDeneme);
        final List<Siparis> siparisList = new ArrayList<>();

        try {
            KayitActivity.database = this.openOrCreateDatabase("Product",MODE_PRIVATE,null);
            KayitActivity.database.execSQL("CREATE TABLE IF NOT EXISTS sepet (isim VARCHAR, fiyat INT, adet INT)");

            Cursor cursor = KayitActivity.database.rawQuery("SELECT * FROM sepet",null);

            int isimIndex = cursor.getColumnIndex("isim");
            int fiyatIndex = cursor.getColumnIndex("fiyat");
            int adetIndex = cursor.getColumnIndex("adet");

            cursor.moveToFirst();

            while (cursor != null){
                siparisList.add(new Siparis(cursor.getString(isimIndex),cursor.getString(fiyatIndex),cursor.getString(adetIndex)));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        CustomAdapter adapter = new CustomAdapter(this,siparisList);
        listView.setAdapter(adapter);


        /*
        siparisList.add(new Siparis("telefon","250","12"));
        siparisList.add(new Siparis("bilgisayar","125","7"));
        siparisList.add(new Siparis("saat","50","3"));
        siparisList.add(new Siparis("bisiklet","1500","21"));
        siparisList.add(new Siparis("kravat","4100","12"));

        final ListView listView = (ListView) findViewById(R.id.listviewDeneme);
        CustomAdapter adapter = new CustomAdapter(this,siparisList);
        listView.setAdapter(adapter);*/

    }
}
package com.example.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class IslemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islem);

        ListView listView = (ListView) findViewById(R.id.listview);

        final ArrayList<String> malzemeAd=new ArrayList<String>();
        final ArrayList<String> malzemeFiyat=new ArrayList<String>();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,malzemeAd);
        listView.setAdapter(arrayAdapter);

        try {
            KayitActivity.database = this.openOrCreateDatabase("Product",MODE_PRIVATE,null);
            KayitActivity.database.execSQL("CREATE TABLE IF NOT EXISTS product (isim VARCHAR, fiyat INT)");

            Cursor cursor = KayitActivity.database.rawQuery("SELECT * FROM product",null);

            int adIndex = cursor.getColumnIndex("isim");
            int fiyatIndex = cursor.getColumnIndex("fiyat");

            cursor.moveToFirst();

            while (cursor != null){
                malzemeAd.add(cursor.getString(adIndex));
                malzemeFiyat.add(cursor.getString(fiyatIndex));

                cursor.moveToNext();

                arrayAdapter.notifyDataSetChanged();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),SepeteEkle.class);
                intent.putExtra("name",malzemeAd.get(position));
                intent.putExtra("price",malzemeFiyat.get(position));

                startActivity(intent);
            }
        });
    }

    public void sepetiGöster(View view){
        Intent intent = new Intent(getApplicationContext(),SepetiGoster.class);
        startActivity(intent);
    }

    public void listiDene(View view){
        Intent intent = new Intent(getApplicationContext(),ListActivity.class);
        startActivity(intent);
    }
}
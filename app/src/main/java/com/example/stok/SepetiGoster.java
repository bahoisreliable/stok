package com.example.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SepetiGoster extends AppCompatActivity {

    TextView sepetToplam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepeti_goster);

        ListView listView = (ListView) findViewById(R.id.sepetList);
        sepetToplam = (TextView) findViewById(R.id.textViewToplam);

        final ArrayList<String> siparisIsim=new ArrayList<>();
        final ArrayList<String> siparisFiyat=new ArrayList<>();
        final ArrayList<String> siprasiAdet=new ArrayList<>();

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,siparisIsim);
        listView.setAdapter(arrayAdapter);
        //sepetToplam.setText("Siparis Hesaplanıyor");
        int siparisToplam=0;

        try {


            KayitActivity.database = this.openOrCreateDatabase("Product",MODE_PRIVATE,null);
            KayitActivity.database.execSQL("CREATE TABLE IF NOT EXISTS sepet (isim VARCHAR, fiyat INT, adet INT)");

            Cursor cursor = KayitActivity.database.rawQuery("SELECT * FROM sepet",null);

            int adIndex = cursor.getColumnIndex("isim");
            int fiyatIndex = cursor.getColumnIndex("fiyat");
            int adetIndex = cursor.getColumnIndex("adet");

            cursor.moveToFirst();

            int i=1;

            while (cursor != null){

                System.out.println(i+". aşama gerçekleşti");
                i++;

                siparisIsim.add(cursor.getString(adIndex));

                siparisFiyat.add(cursor.getString(fiyatIndex));
                siprasiAdet.add(cursor.getString(adetIndex));

                siparisToplam = siparisToplam + Integer.parseInt(cursor.getString(fiyatIndex));

                cursor.moveToNext();

                arrayAdapter.notifyDataSetChanged();
            }
        }catch (Exception e){
            System.out.println("*/**/*//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
            e.printStackTrace();
        }

        String yazi = "Toplam Tutar : ";
        sepetToplam.setText(yazi + String.valueOf(siparisToplam));
    }

    public void yaz(View view){
        try {
            KayitActivity.database=this.openOrCreateDatabase("Product",MODE_PRIVATE,null);
            KayitActivity.database.execSQL("DROP TABLE sepet");

            Intent intent = new Intent(getApplicationContext(),IslemActivity.class);
            startActivity(intent);
        }catch (Exception e ){
            //Toast.makeText(getApplicationContext(),"hata çıktı",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}

package com.example.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class KayitActivity extends AppCompatActivity {

    EditText editTextName ;
    EditText editTextPrice;
    static ArrayList<Product> liste;
    static SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
    }

    public void kayit(View view){
        editTextName= (EditText) findViewById(R.id.editTextName);
        editTextPrice= (EditText) findViewById(R.id.editTextPrice);

        String textName = editTextName.getText().toString();
        String textPrice = editTextPrice.getText().toString();

        try {
            database = this.openOrCreateDatabase("Product",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS product (isim VARCHAR, fiyat INT)");
            database.execSQL("CREATE TABLE IF NOT EXISTS sepet (isim VARCHAR, fiyat INT, adet INT)");
            //database.execSQL("DROP TABLE sepet");

            String sqlString = "INSERT INTO product (isim, fiyat) VALUES (?,?)";
            SQLiteStatement statement = database.compileStatement(sqlString);
            statement.bindString(1,textName);
            statement.bindString(2,textPrice);
            statement.execute();


        }catch (Exception e){
            e.printStackTrace();
        }

        Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
        intent.putExtra("isim",textName);
        intent.putExtra("fiyat",textPrice);
        startActivity(intent);
    }
}
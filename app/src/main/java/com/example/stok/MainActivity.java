package com.example.stok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void kayit(View view){
        Intent intent=new Intent(getApplicationContext(),KayitActivity.class);
        startActivity(intent);
    }
    public void islem(View view){
        Intent intent=new Intent(getApplicationContext(),IslemActivity.class);
        startActivity(intent);
    }

}


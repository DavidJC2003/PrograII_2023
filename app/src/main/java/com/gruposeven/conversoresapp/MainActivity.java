package com.gruposeven.conversoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gruposeven.conversoresapp.db.DbHelper;

public class MainActivity extends AppCompatActivity {

        Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db !=null){

            Toast.makeText(this, "Base de datos cargada", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "No se pudo cargar la Base de Datos", Toast.LENGTH_SHORT).show();
        }




















        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btncatalogo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AgregarProductos.class);
                startActivity(i);
            }
        });







    }
}
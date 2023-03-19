package com.gruposeven.conversoresapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.gruposeven.conversoresapp.adaptadores.listaproductosadd;
import com.gruposeven.conversoresapp.db.DbHelper;
import com.gruposeven.conversoresapp.db.DbProductos;
import com.gruposeven.conversoresapp.entidades.Productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        FloatingActionButton btn;

        RecyclerView listaProductos;
        ArrayList<Productos> listaarrayPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaProductos=findViewById(R.id.listaProductos);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DbProductos dbProductos = new DbProductos(MainActivity.this);

        listaarrayPro = new ArrayList<>();
        listaproductosadd adapter = new listaproductosadd(dbProductos.mostrarproductos());

        listaProductos.setAdapter(adapter);




        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db !=null){

            Toast.makeText(this, "Base de datos cargada", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "No se pudo cargar la Base de Datos", Toast.LENGTH_SHORT).show();
        }











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
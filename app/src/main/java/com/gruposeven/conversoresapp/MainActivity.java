package com.gruposeven.conversoresapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.gruposeven.conversoresapp.adaptadores.listaproductosadd;
import com.gruposeven.conversoresapp.db.DbHelper;
import com.gruposeven.conversoresapp.db.DbProductos;
import com.gruposeven.conversoresapp.entidades.Productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

        FloatingActionButton btn, btn2;

        RecyclerView listaProductos;
        ArrayList<Productos> listaarrayPro;
    listaproductosadd adapter;

        SearchView buscar;


        // Salvador Ernesto Andrade Peña        USSS008322
        // Maria Estefany Salgado Osorio        USSS026222
        // Ronald Aldair Granillo
        // David Ernesto Jaime Carrillo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscar= findViewById(R.id.txtbuscar);


        listaProductos=findViewById(R.id.listaProductos);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DbProductos dbProductos = new DbProductos(MainActivity.this);

        listaarrayPro = new ArrayList<>();
        adapter = new listaproductosadd(dbProductos.mostrarproductos());

        listaProductos.setAdapter(adapter);




        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db !=null){

            Toast.makeText(this, "Base de datos cargada", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "No se pudo cargar la Base de Datos", Toast.LENGTH_SHORT).show();
        }

            buscar.setOnQueryTextListener(this);









        btn = findViewById(R.id.btncatalogo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AgregarProductos.class);
                startActivity(i);
            }
        });







    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}
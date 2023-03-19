package com.gruposeven.conversoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.gruposeven.conversoresapp.db.DbProductos;
import com.gruposeven.conversoresapp.entidades.Productos;

public class Ver extends AppCompatActivity {

    EditText nom,mar,pres,prec;

    Productos productos;

    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);


        nom = findViewById(R.id.nom);
        mar = findViewById(R.id.mar);
        pres = findViewById(R.id.pres);
        prec = findViewById(R.id.prec);

        if (savedInstanceState == null){
            Bundle extra = getIntent().getExtras();
            if (extra == null){
                id = Integer.parseInt(null);

            }          else {
                id = extra.getInt("ID");
            }

        }else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbProductos dbProductos = new DbProductos(Ver.this);
        productos = dbProductos.verproductos(id);

        nom.setText(productos.getNombre());
        mar.setText(productos.getMarca());
        pres.setText(productos.getPrecio());
        prec.setText(productos.getPresentacion());
    }
}
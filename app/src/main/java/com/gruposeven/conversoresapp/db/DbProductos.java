package com.gruposeven.conversoresapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbProductos extends DbHelper{

    Context context;
    public DbProductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public long insertaProducto(String nombre, String marca, String presentacion, String precio){

        long id = 0;

        try {



        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre" ,nombre);
        values.put("marca" ,marca);
        values.put("presentacion" ,presentacion);
        values.put("precio" ,precio);

        id = db.insert(TABLE_PRODUCTOS, null , values);

        } catch (Exception e){

            e.toString();

        }

        return id;
    }







}

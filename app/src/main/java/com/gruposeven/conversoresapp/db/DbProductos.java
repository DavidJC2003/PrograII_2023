package com.gruposeven.conversoresapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gruposeven.conversoresapp.entidades.Productos;

import java.lang.reflect.Array;
import java.util.ArrayList;

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


        public ArrayList<Productos> mostrarproductos(){

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ArrayList<Productos> listaproductod = new ArrayList<>();

            Productos productos = null;
            Cursor cursorproductos = null;

            cursorproductos = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS, null);
            if (cursorproductos.moveToFirst()){
                do {
                    productos = new Productos();
                    productos.setId(cursorproductos.getInt(0));
                    productos.setNombre(cursorproductos.getString(1));
                    productos.setMarca(cursorproductos.getString(2));
                    productos.setPresentacion(cursorproductos.getString(3));
                    productos.setPrecio(cursorproductos.getString(4));

                    listaproductod.add(productos);
                } while (cursorproductos.moveToNext());

            }
            cursorproductos.close();
            return listaproductod;


        }
    public Productos verproductos(int id){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();



        Productos ver = null;
        Cursor cursorproductos ;

        cursorproductos = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS + "WHERE id = " + id + "LIMIT 1", null);
        if (cursorproductos.moveToFirst()){

                ver = new Productos();
                ver.setId(cursorproductos.getInt(0));
                ver.setNombre(cursorproductos.getString(1));
                ver.setMarca(cursorproductos.getString(2));
                ver.setPresentacion(cursorproductos.getString(3));
                ver.setPrecio(cursorproductos.getString(4));




        }
        cursorproductos.close();
        return ver;


    }



}

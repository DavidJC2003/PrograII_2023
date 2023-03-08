package com.gruposeven.conversoresapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class BD extends SQLiteOpenHelper {
    public static final String dbname="db.agenda";

    public static final int v=1;

    static final String sqlDb = "CREATE TABLE agenda(idagenda interger primary key autoincrement, txtnombre, txtdireccion, txttelefono, txtmail)";

    public BD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, v);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlDb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String administracion (String id, String nom, String dir, String tel, String em, String accion){
        try {
            SQLiteDatabase db = getWritableDatabase();
            if (accion.equals("Nuevo")){

                db.execSQL("INSERT INTO agenda(nombre, direccion, telefono, email) VALUES ('"+nom+"','"+dir+"','"+tel+"','"+em+"') ");

            } else if (accion.equals("modificar")){

                db.execSQL("UPDATE agenda set nombre = '"+nom+"', direccion = '"+dir+"', telefono = '"+tel+"'email = '"+em+"' WHERE idagenda= '"+id+"'");

            } else if (accion.equals("eliminar")) {
                db.execSQL("DELETE FROM agenda WHERE idagenda = '"+id+"'");
            }

            return "ok";


        }catch (Exception e){

            return "Error:" + e.getMessage();
        }


    }
}

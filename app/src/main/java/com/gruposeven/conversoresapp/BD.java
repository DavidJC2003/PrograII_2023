package com.gruposeven.conversoresapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {
    public static final String dbname="db_agenda";
    public static final int v=1;
    static final String sqlDb = "CREATE TABLE agenda(id text, rev text, idUnico text, nombre text, direccion text, telefono text, email text, urlfoto text)";
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
    public String administrar_agenda(String id, String rev, String idUnico, String nom, String dir, String tel, String em, String urlfoto, String accion){
        try{
            SQLiteDatabase db = getWritableDatabase();
            if(accion.equals("nuevo")){
                db.execSQL("INSERT INTO agenda(id, rev, idUnico, nombre,direccion,telefono,email, urlfoto) " +
                        "VALUES('"+id+"', '"+rev+"', '"+idUnico+"', '"+nom+"','"+dir+"','"+tel+"','"+em+"','"+urlfoto+"')");
            } else if (accion.equals("modificar")) {
                db.execSQL("UPDATE agenda SET id='"+id+"', rev='"+rev+"', nombre='"+nom+"', direccion='"+dir+"', " +
                        "telefono='"+tel+"', email='"+em+"', urlfoto='"+urlfoto+"' WHERE idUnico='"+idUnico+"'");
            }else if(accion.equals("eliminar")){
                db.execSQL("DELETE FROM agenda WHERE idUnico='"+idUnico+"'");
            }
            return "ok";
        }catch (Exception e){
            return "Error: "+ e.getMessage();
        }
    }
    public Cursor consultar_agenda(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM agenda ORDER BY nombre";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
}

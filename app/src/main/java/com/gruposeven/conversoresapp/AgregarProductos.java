package com.gruposeven.conversoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.gruposeven.conversoresapp.db.DbProductos;
import com.gruposeven.conversoresapp.entidades.Productos;

import org.w3c.dom.Text;

public class AgregarProductos extends AppCompatActivity {

    EditText txtnombre, txtmarca, txtpresentacion, txtprecio;
    Button btnagregarP;

    FloatingActionButton btn;



    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_productos);





     btn=findViewById(R.id.btnregresar);
     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent m = new Intent(AgregarProductos.this, MainActivity.class);
             startActivity(m);
         }
     });

        txtnombre=findViewById(R.id.txtnombre);
        txtmarca=findViewById(R.id.txtmarca);
        txtpresentacion=findViewById(R.id.txtpresentacion);
        txtprecio=findViewById(R.id.txtprecio);
        btnagregarP=findViewById(R.id.btnagregarP);

        btnagregarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               DbProductos dbProductos = new DbProductos(AgregarProductos.this);
                long id = dbProductos.insertaProducto(txtnombre.getText().toString(), txtmarca.getText().toString(), txtpresentacion.getText().toString(), txtprecio.getText().toString());

                if (id>0){
                    Toast.makeText(AgregarProductos.this, "Producto Agregado", Toast.LENGTH_SHORT).show();
                    limpiar();

                }else {
                    Toast.makeText(AgregarProductos.this, "Error al guardar Producto", Toast.LENGTH_SHORT).show();
                    limpiar();
                }
            }
        });




    }

    private void limpiar(){
        txtnombre.setText("");
        txtmarca.setText("");
        txtpresentacion.setText("");
        txtprecio.setText("");
    }
}
package com.gruposeven.conversoresapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gruposeven.conversoresapp.entidades.Productos;

import java.util.ArrayList;

public class listaproductosadd extends RecyclerView.Adapter<listaproductosadd.ContactViewHolder> {


    ArrayList<Productos> listaproductos1;

    public listaproductosadd(ArrayList<Productos> listaproductos1){
        this.listaproductos1 = listaproductos1;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item,null, false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.viewnombre.setText(listaproductos1.get(position).getNombre());
        holder.viewmarca.setText(listaproductos1.get(position).getMarca());
        holder.viewpersentacion.setText(listaproductos1.get(position).getPresentacion());
        holder.viewprecio.setText(listaproductos1.get(position).getPrecio());


    }

    @Override
    public int getItemCount() {
        return listaproductos1.size();

    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView viewnombre, viewmarca, viewpersentacion, viewprecio;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            viewnombre = itemView.findViewById(R.id.viewnombre);
            viewmarca = itemView.findViewById(R.id.viewmarca);
            viewpersentacion = itemView.findViewById(R.id.viewpresentacion);
            viewprecio = itemView.findViewById(R.id.viewprecio);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Ver.class);

                    intent.putExtra("ID", listaproductos1.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}

package com.gruposeven.conversoresapp.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gruposeven.conversoresapp.R;
import com.gruposeven.conversoresapp.Ver;
import com.gruposeven.conversoresapp.entidades.Productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class listaproductosadd extends RecyclerView.Adapter<listaproductosadd.ContactViewHolder> {


    ArrayList<Productos> listaproductos1;
    ArrayList<Productos> listaOriginal;

    public listaproductosadd(ArrayList<Productos> listaproductos1){
        this.listaproductos1 = listaproductos1;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaproductos1);
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


    public void filtrado(String txtbuscar){
        int longitud = txtbuscar.length();
        if (longitud== 0){
            listaproductos1.clear();
            listaproductos1.addAll(listaOriginal);
        }else{

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Productos> colletion = listaproductos1.stream().filter(i -> i.getNombre().toLowerCase().contains(txtbuscar.toLowerCase())).collect(Collectors.toList());
                listaproductos1.addAll(colletion);

            }


        }
        notifyDataSetChanged();
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

            //itemView.setOnClickListener(new View.OnClickListener() {
               // @Override
                //public void onClick(View view) {
                    //Context context = view.getContext();
                    //Intent intent = new Intent(context, Ver.class);

                    //intent.putExtra("ID", listaproductos1.get(getAdapterPosition()).getNombre());
                    //context.startActivity(intent);
               // }
            //});
        }
    }
}

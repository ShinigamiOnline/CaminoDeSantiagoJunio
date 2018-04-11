package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.MutableInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shinigami on 10/04/2018.
 */

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {
    private ArrayList<Municipio> listaMunicipios;
    private LayoutInflater inflador;

    public MiAdaptador(Context context, ArrayList<Municipio> listaMunicipios){
        this.listaMunicipios = listaMunicipios;
        this.inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MiAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflador.inflate(R.layout.elemento_municipio,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiAdaptador.ViewHolder holder, int position) {

        Municipio municipio = listaMunicipios.get(position);
        holder.municipio = municipio;
        holder.id.setText(municipio.getId());
        holder.nombre.setText(municipio.getNombre());
        holder.descripcion.setText(municipio.getDescripcion());
        holder.numHabitantes.setText(municipio.getHabitantes());

    }

    @Override
    public int getItemCount() {
        return listaMunicipios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre,descripcion,numHabitantes,id;
        private Municipio municipio;

        ViewHolder(View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.IDMunicipio);
            nombre = itemView.findViewById(R.id.NombreMunicipio);
            descripcion = itemView.findViewById(R.id.DescripcionMunicipio);
            numHabitantes = itemView.findViewById(R.id.numHabitantesMunicipio);



        }
    }
}

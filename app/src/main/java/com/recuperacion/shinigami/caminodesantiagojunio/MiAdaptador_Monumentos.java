package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador_Monumentos  extends RecyclerView.Adapter<MiAdaptador_Monumentos.ViewHolder> implements View.OnClickListener {
    private ArrayList<Monumento> listaMonumentos = new ArrayList<Monumento>();
    private LayoutInflater inflador;
    private View.OnClickListener listener;

    public MiAdaptador_Monumentos(Context context, ArrayList<Monumento> listaMonumentos){
        this.listaMonumentos = listaMonumentos;
        this.inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MiAdaptador_Monumentos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflador.inflate(R.layout.elemento_monumento,parent,false);
        view.setOnClickListener(this);
        return  new MiAdaptador_Monumentos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiAdaptador_Monumentos.ViewHolder holder, int position) {

        Monumento monumento = listaMonumentos.get(position);

        holder.nombre.setText(String.valueOf(monumento.getNombre()));
        holder.descripcion.setText(String.valueOf(monumento.getDescripcion()));
        holder.precio.setText("Precio : " + String.valueOf(monumento.getPrecioEntrada()));
        holder.id.setText(String.valueOf(monumento.getId()));
        holder.horario.setText("Horario : " +String.valueOf(monumento.getHorario()));

    }

    @Override
    public int getItemCount() {
        return listaMonumentos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre,descripcion,precio,id,horario;
        ViewHolder(View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.txtIDMonumento_elemento);
            nombre = itemView.findViewById(R.id.txtTituloMonumento_elemento);
            descripcion = itemView.findViewById(R.id.txtDescripcionMonumento_elemento);
            precio = itemView.findViewById(R.id.txtPrecioMonumento_elemento);
            horario = itemView.findViewById(R.id.txtHorarioMonumento_elemento);
        }
    }
}


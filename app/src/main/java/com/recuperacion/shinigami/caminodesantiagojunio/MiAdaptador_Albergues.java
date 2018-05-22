package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador_Albergues extends RecyclerView.Adapter<MiAdaptador_Albergues.ViewHolder> implements View.OnClickListener {
    private ArrayList<Albergue> listaAlbergues = new ArrayList<Albergue>();
    private LayoutInflater inflador;
    private View.OnClickListener listener;

    public MiAdaptador_Albergues(Context context, ArrayList<Albergue> listaAlbergues){
        this.listaAlbergues = listaAlbergues;
        this.inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MiAdaptador_Albergues.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflador.inflate(R.layout.elemento_albergue,parent,false);
        view.setOnClickListener(this);
        return  new MiAdaptador_Albergues.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiAdaptador_Albergues.ViewHolder holder, int position) {

        Albergue albergue = listaAlbergues.get(position);
        float valoracion = albergue.getValoracionSum()/albergue.getVotos();

        holder.nombre.setText(String.valueOf(albergue.getNombre()));
        holder.descripcion.setText(String.valueOf(albergue.getDescripcion()));
        holder.precio.setText("Precio por noche : " + String.valueOf(albergue.getPrecio()));


        if(valoracion >=0  || valoracion <= 2.4){
            holder.imagenIcono.setImageResource(R.drawable.malo);

        }else if(valoracion >= 2.5  || valoracion <= 3.9){
            holder.imagenIcono.setImageResource(R.drawable.medio);

        }else if(valoracion >= 4  || valoracion <= 5){
            holder.imagenIcono.setImageResource(R.drawable.bueno);

        }

    }

    @Override
    public int getItemCount() {
        return listaAlbergues.size();
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

        private ImageView imagenIcono;
        private TextView nombre,descripcion,precio;
        ViewHolder(View itemView){
            super(itemView);
            imagenIcono = itemView.findViewById(R.id.imgImagen_elemento);
            nombre = itemView.findViewById(R.id.txtTituloAlbergues_elemento);
            descripcion = itemView.findViewById(R.id.txtDescripcionAlbergues_elemento);
            precio = itemView.findViewById(R.id.txtPrecio_elemento);
        }
    }
}


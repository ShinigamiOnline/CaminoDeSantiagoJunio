package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class Recyclerview_Municipios extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MiAdaptador adaptador;
    private ArrayList<Municipio> lista = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview__municipios);
        recyclerView = findViewById(R.id.recycler);

        lista = (ArrayList<Municipio>) getIntent().getSerializableExtra("listaFiltrada");

        adaptador = new MiAdaptador(this, lista);

        adaptador.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Has pulsado aquí : " +  lista.get(recyclerView.getChildAdapterPosition(view)), Toast.LENGTH_SHORT).show();
                Municipio municipioAEnviar = lista.get(recyclerView.getChildAdapterPosition(view));
                Intent intent = new Intent(getApplicationContext(),Ver_Municipio_Consultar.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Municipio",municipioAEnviar);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }
}

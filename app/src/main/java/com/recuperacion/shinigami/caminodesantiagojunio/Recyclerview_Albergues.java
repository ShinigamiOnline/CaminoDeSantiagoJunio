package com.recuperacion.shinigami.caminodesantiagojunio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Recyclerview_Albergues extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MiAdaptador_Albergues adaptador;
    private ArrayList<Albergue> listaAlbergues = new ArrayList<>();
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private Municipio municipioRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview__albergues);
        recyclerView = findViewById(R.id.recycler_lista_Albergues);

        municipioRecibido = (Municipio) getIntent().getSerializableExtra("Monumento");

        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);
        listaAlbergues = almacenarEnDBSQLite.cargarAlbergues(municipioRecibido);

        adaptador = new MiAdaptador_Albergues(this, listaAlbergues);

        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}

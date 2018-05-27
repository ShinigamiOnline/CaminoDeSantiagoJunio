package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class Recyclerview_Albergues extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MiAdaptador_Albergues adaptador;
    private ArrayList<Albergue> listaAlbergues = new ArrayList<>();
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private Municipio municipioRecibido;
    private String respuestaRecibida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_albergues);
        recyclerView = findViewById(R.id.recycler_lista_Albergues);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);

        Bundle objetoEnviado = getIntent().getExtras();
        municipioRecibido = (Municipio) objetoEnviado.getSerializable("Municipio");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 5555 && resultCode == RESULT_OK) {
            respuestaRecibida = data.getExtras().getString("respuesta");
        }
    }

    @Override
    protected void onResume() {

        listaAlbergues = almacenarEnDBSQLite.cargarAlbergues(municipioRecibido);

        adaptador = new MiAdaptador_Albergues(this, listaAlbergues);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Albergue AlbergueAEnviar = listaAlbergues.get(recyclerView.getChildAdapterPosition(view));
                Intent intent = new Intent(getApplicationContext(), Puntuar_Albergue.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Albergue", AlbergueAEnviar);
                intent.putExtras(bundle);
                startActivityForResult(intent, 5555);
            }
        });

        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        super.onResume();
    }
}

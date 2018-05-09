package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class VerMonumentosDelMunicipio extends AppCompatActivity {

    private ListView listView_MonumentosDelMunicipio;
    private Button btnAniadirMonumento;
    private ArrayAdapter<Monumento> arrayAdapter;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private ArrayList<Monumento> listaMonumentos = new ArrayList<>();
    private Municipio municipioRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_monumentos_del_municipio);

        listView_MonumentosDelMunicipio = findViewById(R.id.listView_VerMonumentosDelMunicipio);
        btnAniadirMonumento = findViewById(R.id.btnAniadirMonumento);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);

        Bundle objetoEnviado = getIntent().getExtras();
        municipioRecibido = (Municipio) objetoEnviado.getSerializable("Municipio");

        listaMonumentos = almacenarEnDBSQLite.cargarMonumentos(municipioRecibido);

        arrayAdapter = new ArrayAdapter<Monumento>(this, android.R.layout.simple_list_item_1, listaMonumentos);

        listView_MonumentosDelMunicipio.setAdapter(arrayAdapter);

        listView_MonumentosDelMunicipio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                Monumento monumento = listaMonumentos.get(posicion);
                Intent intent = new Intent(VerMonumentosDelMunicipio.this, Ver_Monumento.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Monumento", monumento);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnAniadirMonumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerMonumentosDelMunicipio.this, Aniadir_Monumento.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Municipio",municipioRecibido);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        listaMonumentos = almacenarEnDBSQLite.cargarMonumentos(municipioRecibido);
        arrayAdapter = new ArrayAdapter<Monumento>(this, android.R.layout.simple_list_item_1, listaMonumentos);
        listView_MonumentosDelMunicipio.setAdapter(arrayAdapter);

    }
}

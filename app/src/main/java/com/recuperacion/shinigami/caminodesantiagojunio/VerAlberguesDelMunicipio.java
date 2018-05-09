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

public class VerAlberguesDelMunicipio extends AppCompatActivity {

    private ListView listView_AlberguesDelMunicipio;
    private Button btnAniadirAlbergue;
    private ArrayAdapter<Albergue> arrayAdapter;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private ArrayList<Albergue> listaAlbergues = new ArrayList<>();
    private Municipio municipioRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_albergues_del_municipio);

        listView_AlberguesDelMunicipio = findViewById(R.id.listView_VerAlbergueDelMunicipio);
        btnAniadirAlbergue = findViewById(R.id.btnAniadirAlbergue);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);

        Bundle objetoEnviado = getIntent().getExtras();
        municipioRecibido = (Municipio) objetoEnviado.getSerializable("Municipio");

        listaAlbergues = almacenarEnDBSQLite.cargarAlbergues(municipioRecibido);

        arrayAdapter = new ArrayAdapter<Albergue>(this, android.R.layout.simple_list_item_1, listaAlbergues);

        listView_AlberguesDelMunicipio.setAdapter(arrayAdapter);

        listView_AlberguesDelMunicipio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                Albergue albergue = listaAlbergues.get(posicion);
                Intent intent = new Intent(VerAlberguesDelMunicipio.this, Ver_Albergue.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Albergue", albergue);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnAniadirAlbergue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerAlberguesDelMunicipio.this,AniadirAlbergue.class);
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
        listaAlbergues = almacenarEnDBSQLite.cargarAlbergues(municipioRecibido);
        arrayAdapter = new ArrayAdapter<Albergue>(this, android.R.layout.simple_list_item_1, listaAlbergues);
        listView_AlberguesDelMunicipio.setAdapter(arrayAdapter);

    }
}

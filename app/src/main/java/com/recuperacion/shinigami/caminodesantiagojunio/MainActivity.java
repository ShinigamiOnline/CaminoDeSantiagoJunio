package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnGestionMunicipios;
    private Button btnConsultaMunicipios;
    private Button btnPreferencias;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private ArrayList<Municipio> listaMunicipiosFiltrada = new ArrayList<Municipio>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGestionMunicipios = findViewById(R.id.btnGestionMunicipios);
        btnConsultaMunicipios = findViewById(R.id.btnConsultaMunicipios);
        btnPreferencias = findViewById(R.id.btnPreferencias);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);

        btnGestionMunicipios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Gestion_Municipios.class);
                startActivity(intent);
            }
        });

        btnConsultaMunicipios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intent a lista de municipios filtrado, con recycler view.
                SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);

                boolean conAlbergues = preferences.getBoolean("MunicipioConAlbergue",true);

                int minNumHabitantes = Integer.parseInt(preferences.getString("MinNumHabitantes","10"));

                String descripcionMunicipio = preferences.getString("descripcionMunicipio","Antigua");


                listaMunicipiosFiltrada = almacenarEnDBSQLite.cargarMunicipios(minNumHabitantes,descripcionMunicipio,conAlbergues);


                Intent intent = new Intent(MainActivity.this,Recyclerview_Municipios.class);
                intent.putExtra("listaFiltrada",listaMunicipiosFiltrada);
                startActivity(intent);

            }
        });

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PreferenciasActivity.class);
                startActivity(intent);

            }
        });

    }

}

package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();
    private Button btnGestionMunicipios;
    private Button btnConsultaMunicipios;
    private Button btnPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellenarLista();
        btnGestionMunicipios = findViewById(R.id.btnGestionMunicipios);
        btnConsultaMunicipios = findViewById(R.id.btnConsultaMunicipios);
        btnPreferencias = findViewById(R.id.btnPreferencias);

        btnGestionMunicipios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Recyclerview_Municipios.class);
                startActivity(intent);
            }
        });

    }
    public void rellenarLista(){
        listaMunicipios.add(new Municipio(01,"Logroño",12020,"Logroño, donde hay muchisimas cosas"));
    }
}

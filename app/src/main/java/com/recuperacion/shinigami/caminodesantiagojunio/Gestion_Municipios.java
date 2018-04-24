package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Gestion_Municipios extends AppCompatActivity {

    private Button btnAniadirMunicipio;
    private ListView listView_Municipios;
    private ArrayList<Municipio> listaMunicipio = new ArrayList<>();
    private ArrayAdapter<Municipio> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion__municipios);

        AlmacenarEnDBSQLite almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this,"Gestion",null,1);
        listaMunicipio = almacenarEnDBSQLite.cargarMunicipios();

        listView_Municipios = findViewById(R.id.listView_gestion_Municipios);
        btnAniadirMunicipio = findViewById(R.id.btnAniadirMunicipio);

        arrayAdapter = new ArrayAdapter<Municipio>(this,android.R.layout.simple_list_item_1,listaMunicipio);

        listView_Municipios.setAdapter(arrayAdapter);

        listView_Municipios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                Municipio municipio = listaMunicipio.get(posicion);
                Intent intent = new Intent(Gestion_Municipios.this,Ver_municipio.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Municipio",municipio);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });



        btnAniadirMunicipio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gestion_Municipios.this,Aniadir_Municipio.class);
                startActivity(intent);
            }
        });



    }
}

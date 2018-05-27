package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class Recyclerview_Municipios extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MiAdaptador adaptador;
    private ArrayList<Municipio> lista;
    private SharedPreferences preferences;
    private boolean conAlbergues;
    private int minNumHabitantes;
    private String descripcionRecibida = "";
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview__municipios);
        recyclerView = findViewById(R.id.recycler);
            almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);
            lista = new ArrayList<>();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * Método para establecer un menú en el activity.
         */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.filtro_menu) {

            Intent intent = new Intent(Recyclerview_Municipios.this, Filtro_En_Recycler.class);
            Bundle bundle =  new Bundle();
            bundle.putString("descripcion",descripcionRecibida);
            intent.putExtras(bundle);
            startActivityForResult(intent, 4444);

        }

        if (id == R.id.preferencias_menu) {

            Intent intent = new Intent(Recyclerview_Municipios.this, PreferenciasActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 4444 && resultCode == RESULT_OK) {
            descripcionRecibida = data.getExtras().getString("respuesta");
        }
    }

    @Override
    protected void onResume() {
        /**
         * Con esto cada vez que se llame al metodo onResume se estableceran las siguiente variables.
         */
            preferences = PreferenceManager.getDefaultSharedPreferences(this);

            try {
                this.conAlbergues = preferences.getBoolean("MunicipioConAlbergue", true);
                this.minNumHabitantes = Integer.parseInt(preferences.getString("MinNumHabitantes", "1"));
            } catch (NumberFormatException ex) {
                minNumHabitantes = 0;
            }

            lista = almacenarEnDBSQLite.cargarMunicipios(minNumHabitantes, descripcionRecibida, conAlbergues);

            adaptador = new MiAdaptador(this, lista);
            adaptador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Municipio municipioAEnviar = lista.get(recyclerView.getChildAdapterPosition(view));
                    Intent intent = new Intent(getApplicationContext(), Ver_Municipio_Consultar.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Municipio", municipioAEnviar);
                    intent.putExtras(bundle);
                    startActivity(intent);


                }
            });
            recyclerView.setAdapter(adaptador);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(
                    new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            super.onResume();

    }


}

package com.recuperacion.shinigami.caminodesantiagojunio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Aniadir_Municipio extends AppCompatActivity {

    private EditText txtCodMunicipio;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private EditText txtNumHabitantes;
    private Button btnAltaNuevoMunicipio;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private Municipio nuevoMunicipio;
    private ArrayList<Municipio> listaMunicipios = new ArrayList<Municipio>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniadir__municipio);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);

        txtCodMunicipio = findViewById(R.id.txtCodMunicipio);
        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtNumHabitantes = findViewById(R.id.txtNumHabitantes);

        btnAltaNuevoMunicipio = findViewById(R.id.btnAltaNuevoMunicipio);

        btnAltaNuevoMunicipio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bandera = true;
                listaMunicipios = almacenarEnDBSQLite.cargarMunicipios();
                for (Municipio muni : listaMunicipios) {
                    if (muni.getId() == Integer.parseInt(txtCodMunicipio.getText().toString())) {
                        bandera = false;
                    }
                }
                if (bandera) {
                    nuevoMunicipio = new Municipio(Integer.parseInt(txtCodMunicipio.getText().toString()), txtNombre.getText().toString(), Integer.parseInt(txtNumHabitantes.getText().toString()), txtDescripcion.getText().toString());
                    almacenarEnDBSQLite.aniadirMunicipio(nuevoMunicipio);
                    Toast.makeText(Aniadir_Municipio.this, "Municipio creado correctamente.", Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    Toast.makeText(Aniadir_Municipio.this, "El ID ya está siendo utilizado.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

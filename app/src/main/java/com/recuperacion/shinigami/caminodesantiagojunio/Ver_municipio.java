package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ver_municipio extends AppCompatActivity {

    private EditText txtCodMunicipio;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private EditText txtNumHabitantes;
    private Button btnModificar;
    private Button btnBorrar;
    private Button btnVerAlbergues;
    private Button btnVerMonumentos;
    private Municipio municipio;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private Municipio municipioModificado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_municipio);

        txtCodMunicipio = findViewById(R.id.txtCodMunicipio_VerMunicipio);
        txtNombre = findViewById(R.id.txtNombre_VerMunicipio);
        txtDescripcion = findViewById(R.id.txtDescripcion_VerMunicipio);
        txtNumHabitantes = findViewById(R.id.txtNumHabitantes_VerMunicipio);
        btnModificar = findViewById(R.id.btnModificar_VerMunicipio);
        btnBorrar = findViewById(R.id.btnBorrar_VerMunicipio);
        btnVerAlbergues = findViewById(R.id.btnVerAlbergues);
        btnVerMonumentos = findViewById(R.id.btnVerMonumentos);

        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this,"Gestion",null,1);
        Bundle objetoEnviado = getIntent().getExtras();
        municipio = (Municipio) objetoEnviado.getSerializable("Municipio");

        txtCodMunicipio.setText(String.valueOf(municipio.getId()));
        txtNombre.setText(municipio.getNombre());
        txtDescripcion.setText(municipio.getDescripcion());
        txtNumHabitantes.setText(String.valueOf(municipio.getHabitantes()));

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                municipioModificado = new Municipio(Integer.parseInt(txtCodMunicipio.getText().toString()),txtNombre.getText().toString(),Integer.parseInt(txtNumHabitantes.getText().toString()), txtDescripcion.getText().toString());

                almacenarEnDBSQLite.modificarMunicipio(municipioModificado);
                Toast.makeText(getApplicationContext(), "Municipio modificado correctamente.", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                municipioModificado = new Municipio(Integer.parseInt(txtCodMunicipio.getText().toString()),txtNombre.getText().toString(),Integer.parseInt(txtNumHabitantes.getText().toString()), txtDescripcion.getText().toString());

                ArrayList<Albergue> listaAlbergues = new ArrayList<>();
                listaAlbergues = almacenarEnDBSQLite.cargarAlbergues(municipio);
                ArrayList<Monumento> listaMonumentos = new ArrayList<>();
                listaMonumentos = almacenarEnDBSQLite.cargarMonumentos(municipio);

                if(listaAlbergues.size() >= 1 || listaMonumentos.size() >= 1){
                    Toast.makeText(getApplicationContext(), "Error. El Municipio contiene Albergues o Monumentos.", Toast.LENGTH_SHORT).show();

                }else {
                    almacenarEnDBSQLite.eliminarMunicipio(municipio);
                    Toast.makeText(getApplicationContext(), "Municipio borrado correctamente.", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

        btnVerAlbergues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Ver_municipio.this,VerAlberguesDelMunicipio.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Municipio",municipio);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        btnVerMonumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Ver_municipio.this,VerMonumentosDelMunicipio.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Municipio",municipio);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}

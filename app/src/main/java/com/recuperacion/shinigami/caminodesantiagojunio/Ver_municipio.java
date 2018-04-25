package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ver_municipio extends AppCompatActivity {

    private EditText txtCodMunicipio;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private EditText txtNumHabitantes;
    private Button btnModificar;
    private Button btnBorrar;
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

                almacenarEnDBSQLite.eliminarMunicipio(municipioModificado);
                Toast.makeText(getApplicationContext(), "Municipio borrado correctamente.", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }
}

package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ver_municipio extends AppCompatActivity {

    private EditText txtCodMunicipio;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private EditText txtNumHabitantes;
    private Button btnModificar;
    private Button btnBorrar;
    private Municipio municipio;

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

        Bundle objetoEnviado = getIntent().getExtras();
        municipio = (Municipio) objetoEnviado.getSerializable("Municipio");

        txtCodMunicipio.setText(String.valueOf(municipio.getId()));
        txtNombre.setText(municipio.getNombre());
        txtDescripcion.setText(municipio.getDescripcion());
        txtNumHabitantes.setText(String.valueOf(municipio.getHabitantes()));




    }
}

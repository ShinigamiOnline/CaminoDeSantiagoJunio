package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ver_Municipio_Consultar extends AppCompatActivity {

    private EditText txtCodMunicipio;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private EditText txtNumHabitantes;
    private Button btnVerAlbergues;
    private Button btnVerMonumentos;
    private Municipio municipioRecibido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__municipio__consultar);

        txtCodMunicipio = findViewById(R.id.txtCodMunicipio_Consulta);
        txtNombre = findViewById(R.id.txtNombre_Consulta);
        txtDescripcion = findViewById(R.id.txtDescripcion_Consulta);
        txtNumHabitantes = findViewById(R.id.txtNumHabitantes_Consulta);
        btnVerAlbergues = findViewById(R.id.btnVerAlbergues_Consulta);
        btnVerMonumentos = findViewById(R.id.btnVerMonumentos_Consulta);

        Bundle objetoEnviado = getIntent().getExtras();
        municipioRecibido = (Municipio) objetoEnviado.getSerializable("Municipio");

        txtCodMunicipio.setText(String.valueOf(municipioRecibido.getId()));
        txtNombre.setText(municipioRecibido.getNombre());
        txtDescripcion.setText(municipioRecibido.getDescripcion());
        txtNumHabitantes.setText(String.valueOf(municipioRecibido.getHabitantes()));

        btnVerAlbergues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Has pulsado El botón Ver Albergues", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Ver_Municipio_Consultar.this,Recyclerview_Albergues.class);


                startActivity(intent);


            }
        });

        btnVerMonumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Has pulsado El botón Ver Monumentos", Toast.LENGTH_SHORT).show();

            }
        });


    }
}

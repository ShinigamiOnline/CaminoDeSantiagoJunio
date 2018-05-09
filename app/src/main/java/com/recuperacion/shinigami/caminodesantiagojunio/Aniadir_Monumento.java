package com.recuperacion.shinigami.caminodesantiagojunio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Aniadir_Monumento extends AppCompatActivity {

    private EditText txtCodMonumento;
    private EditText txtNombreMonumento;
    private EditText txtDescripcionMonumento;
    private EditText txtHorarioMonumento;
    private EditText txtPrecioMonumento;
    private Button btnAltaMonumento;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private ArrayList<Monumento> listaMonumentos;
    private Municipio municipioRecibido;
    private Monumento nuevoMonumento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniadir__monumento);

        txtCodMonumento = findViewById(R.id.txtCodMonumento);
        txtNombreMonumento = findViewById(R.id.txtNombreMonumentoNuevo);
        txtDescripcionMonumento = findViewById(R.id.txtDescripcionMonumentoNuevo);
        txtHorarioMonumento = findViewById(R.id.txtHorarioMonumento);
        txtPrecioMonumento = findViewById(R.id.txtPrecioMonumento);
        btnAltaMonumento = findViewById(R.id.btnAltaNuevoMonumento);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);
        listaMonumentos = new ArrayList<Monumento>();

        Bundle objetoEnviado = getIntent().getExtras();
        municipioRecibido = (Municipio) objetoEnviado.getSerializable("Municipio");

        btnAltaMonumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bandera = true;
                listaMonumentos = almacenarEnDBSQLite.cargarMonumentos(municipioRecibido);
                for (Monumento monumento : listaMonumentos) {
                    if (monumento.getId() == Integer.parseInt(txtCodMonumento.getText().toString())) {
                        bandera = false;
                    }
                }
                if (bandera) {
                    nuevoMonumento = new Monumento(Integer.parseInt(txtCodMonumento.getText().toString()),txtNombreMonumento.getText().toString(), txtDescripcionMonumento.getText().toString(),txtHorarioMonumento.getText().toString(),Double.parseDouble(txtPrecioMonumento.getText().toString()),municipioRecibido.getId());
                    almacenarEnDBSQLite.aniadirMonumento(nuevoMonumento);
                    Toast.makeText(Aniadir_Monumento.this, "Monumento creado correctamente.", Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    Toast.makeText(Aniadir_Monumento.this, "El ID ya está siendo utilizado.", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}

package com.recuperacion.shinigami.caminodesantiagojunio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AniadirAlbergue extends AppCompatActivity {

    private EditText txtCodAlbergue;
    private EditText txtNombre;
    private EditText txtDescripcion;
    private EditText txtValoracionSum;
    private EditText txtVotos;
    private EditText txtPrecio;
    private Button btnAltaAlbergue;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private ArrayList<Albergue> listaAlbergues;
    private Municipio municipioRecibido;
    private Albergue nuevoAlbergue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniadir_albergue);

        txtCodAlbergue = findViewById(R.id.txtCodAlbergue);
        txtNombre = findViewById(R.id.txtNombreAlbergue);
        txtDescripcion = findViewById(R.id.txtDescripcionAlbergue);
        txtValoracionSum = findViewById(R.id.txtValoracionAlbergue);
        txtVotos = findViewById(R.id.txtVotosAlbergue);
        txtPrecio = findViewById(R.id.txtPrecioAlbergue);

        btnAltaAlbergue = findViewById(R.id.btnAltaNuevoAlbergue);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);
        listaAlbergues = new ArrayList<Albergue>();

        Bundle objetoEnviado = getIntent().getExtras();
        municipioRecibido = (Municipio) objetoEnviado.getSerializable("Municipio");


        btnAltaAlbergue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bandera = true;
                listaAlbergues = almacenarEnDBSQLite.cargarAlbergues();
                for (Albergue albergue : listaAlbergues) {
                    if (albergue.getId() == Integer.parseInt(txtCodAlbergue.getText().toString())) {
                        bandera = false;
                    }
                }
                if (bandera) {
                    if (txtCodAlbergue.getText().toString().equals("") || txtNombre.getText().toString().equals("") || txtDescripcion.getText().toString().equals("") || txtValoracionSum.getText().toString().equals("") || txtVotos.getText().toString().equals("") || txtPrecio.getText().toString().equals("")) {
                        Toast.makeText(AniadirAlbergue.this, "Tienes que rellenar todos los campos.", Toast.LENGTH_SHORT).show();
                    } else {
                        nuevoAlbergue = new Albergue(Integer.parseInt(txtCodAlbergue.getText().toString()), txtDescripcion.getText().toString(), txtNombre.getText().toString(), Integer.parseInt(txtValoracionSum.getText().toString()), Integer.parseInt(txtVotos.getText().toString()), Double.parseDouble(txtPrecio.getText().toString()), municipioRecibido.getId());
                        almacenarEnDBSQLite.aniadirAlbergue(nuevoAlbergue);
                        Toast.makeText(AniadirAlbergue.this, "Albergue creado correctamente.", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                } else {
                    Toast.makeText(AniadirAlbergue.this, "El ID ya está siendo utilizado.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}

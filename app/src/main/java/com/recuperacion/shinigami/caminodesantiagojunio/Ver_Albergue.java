package com.recuperacion.shinigami.caminodesantiagojunio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ver_Albergue extends AppCompatActivity {

    private EditText txtCodAlbergue;
    private EditText txtNombreAlbergue;
    private EditText txtDescipcionAlbergue;
    private EditText txtValoracionAlbergue;
    private EditText txtVotosAlbergue;
    private EditText txtPrecioAlbergue;
    private Button btnModificarAlbergue;
    private Button btnBorrarAlbergue;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private Albergue albergueRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__albergue);

        txtCodAlbergue = findViewById(R.id.txtCodAlbergueSeleccionado);
        txtNombreAlbergue = findViewById(R.id.txtNombreAlbergueSeleccionado);
        txtDescipcionAlbergue = findViewById(R.id.txtDescripcionAlbergueSeleccionado);
        txtValoracionAlbergue = findViewById(R.id.txtValoracionAlbergueSeleccionado);
        txtVotosAlbergue = findViewById(R.id.txtVotosAlbergueSeleccionado);
        txtPrecioAlbergue = findViewById(R.id.txtPrecioAlbergueSeleccionado);
        btnModificarAlbergue = findViewById(R.id.btnModificarAlbergueSeleccionado);
        btnBorrarAlbergue = findViewById(R.id.btnBorrarAlbergueSeleccionado);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);

        Bundle objetoEnviado = getIntent().getExtras();
        albergueRecibido = (Albergue) objetoEnviado.getSerializable("Albergue");

        txtCodAlbergue.setText(String.valueOf(albergueRecibido.getId()));
        txtNombreAlbergue.setText(albergueRecibido.getNombre()) ;
        txtDescipcionAlbergue.setText(albergueRecibido.getDescripcion());
        txtValoracionAlbergue.setText(String.valueOf(albergueRecibido.getValoracionSum()));
        txtVotosAlbergue.setText(String.valueOf(albergueRecibido.getVotos()));
        txtPrecioAlbergue.setText(String.valueOf(albergueRecibido.getPrecio()));

        btnModificarAlbergue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Albergue albergueModificado = new Albergue(Integer.parseInt(txtCodAlbergue.getText().toString()),txtDescipcionAlbergue.getText().toString(),txtNombreAlbergue.getText().toString(),Integer.parseInt(txtValoracionAlbergue.getText().toString()),Integer.parseInt(txtVotosAlbergue.getText().toString()),Double.parseDouble(txtPrecioAlbergue.getText().toString()),albergueRecibido.getId_Municipio());
                almacenarEnDBSQLite.modificarAlbergue(albergueModificado);
                Toast.makeText(Ver_Albergue.this, "Albergue Modificado correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnBorrarAlbergue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                almacenarEnDBSQLite.eliminarAlbergue(albergueRecibido);
                Toast.makeText(Ver_Albergue.this, "Albergue Elimiado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });








    }
}

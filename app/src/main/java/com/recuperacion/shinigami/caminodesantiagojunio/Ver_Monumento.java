package com.recuperacion.shinigami.caminodesantiagojunio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Ver_Monumento extends AppCompatActivity {


    private EditText txtCodMonumento;
    private EditText txtNombreMonumento;
    private EditText txtDescripcionMonumento;
    private EditText txtHorarioMonumento;
    private EditText txtPrecioMonumento;
    private Button btnModificarMonumento;
    private Button btnBorrarMonumento;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private Monumento monumentoRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__monumento);

        txtCodMonumento = findViewById(R.id.txtCodMonumentoSeleccionado);
        txtNombreMonumento = findViewById(R.id.txtNombreMonumentoSeleccionado);
        txtDescripcionMonumento = findViewById(R.id.txtDescripcionMonumentoSeleccionado);
        txtHorarioMonumento = findViewById(R.id.txtHorarioMonumentoSeleccionado);
        txtPrecioMonumento = findViewById(R.id.txtPrecioMonumentoSeleccionado);
        btnModificarMonumento = findViewById(R.id.btnModificarMonumentoSeleccionado);
        btnBorrarMonumento = findViewById(R.id.btnBorrarMonumentoSeleccionado);

        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);

        Bundle objetoEnviado = getIntent().getExtras();
        monumentoRecibido = (Monumento) objetoEnviado.getSerializable("Monumento");

        txtCodMonumento.setText(String.valueOf(monumentoRecibido.getId()));
        txtNombreMonumento.setText(monumentoRecibido.getNombre());
        txtDescripcionMonumento.setText(monumentoRecibido.getDescripcion());
        txtHorarioMonumento.setText(monumentoRecibido.getHorario());
        txtPrecioMonumento.setText(String.valueOf(monumentoRecibido.getPrecioEntrada()));

        btnModificarMonumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Monumento monumentoModificado = new Monumento(monumentoRecibido.getId(),txtNombreMonumento.getText().toString(),txtDescripcionMonumento.getText().toString(),txtHorarioMonumento.getText().toString(),Double.parseDouble(txtPrecioMonumento.getText().toString()),monumentoRecibido.getId_Municipio());
                almacenarEnDBSQLite.modificarMonumento(monumentoModificado);
                Toast.makeText(Ver_Monumento.this, "Monumento Modificado correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnBorrarMonumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                almacenarEnDBSQLite.eliminarMonumento(monumentoRecibido);
                Toast.makeText(Ver_Monumento.this, "Monumento eliminado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

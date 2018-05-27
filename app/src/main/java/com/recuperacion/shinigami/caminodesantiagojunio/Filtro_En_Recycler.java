package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Filtro_En_Recycler extends AppCompatActivity {

    private EditText txtDescripcionABuscar;
    private Button btnAplicar;
    private String descripionABuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro__en__recycler);
        txtDescripcionABuscar = findViewById(R.id.txtDescripcionABuscar_Filtro);
        btnAplicar = findViewById(R.id.btnAplicarFiltroDescripcion);
        Bundle objetoRecibido = getIntent().getExtras();
        txtDescripcionABuscar.setText(objetoRecibido.getString("descripcion"));
        txtDescripcionABuscar.selectAll();


        btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descripionABuscar = txtDescripcionABuscar.getText().toString();
                Intent intent =  new Intent();
                intent.putExtra("respuesta",descripionABuscar);
                setResult(RESULT_OK,intent);
                finish();
            }
        });



    }
}

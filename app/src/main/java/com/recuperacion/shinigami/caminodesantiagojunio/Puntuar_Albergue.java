package com.recuperacion.shinigami.caminodesantiagojunio;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class Puntuar_Albergue extends AppCompatActivity {
    private RatingBar ratingBar;
    private Button btnPuntuar;
    private AlmacenarEnDBSQLite almacenarEnDBSQLite;
    private Albergue albergueRecibido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuar__albergue);
        almacenarEnDBSQLite = new AlmacenarEnDBSQLite(this, "Gestion", null, 1);
        Bundle objetoRecibido = getIntent().getExtras();
        albergueRecibido = (Albergue) objetoRecibido.getSerializable("Albergue");

        ratingBar = findViewById(R.id.ratingBar_Albergue);
        btnPuntuar = findViewById(R.id.btnPuntuar_Albergue);

        btnPuntuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float valoracion = ratingBar.getRating();
                almacenarEnDBSQLite.guardarValoracion(albergueRecibido,valoracion);
                finish();
            }
        });

    }
}

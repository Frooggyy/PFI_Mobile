package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListeAchat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_achat);

        Button btnVersListe = (Button) findViewById(R.id.achat_btnVersListe);

        btnVersListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versLE = new Intent(ListeAchat.this, ListeEpicerie.class);
                startActivity(versLE);
            }
        });

    }
}
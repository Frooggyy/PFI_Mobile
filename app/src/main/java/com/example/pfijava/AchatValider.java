package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AchatValider extends AppCompatActivity {
    private Panier panier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat_valider);
        panier = Panier.getInstance();

        Button btnRetour = (Button) findViewById(R.id.btn_retour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versLE = new Intent(AchatValider.this, ListeEpicerie.class);
                startActivity(versLE);
            }
        });
    }
}
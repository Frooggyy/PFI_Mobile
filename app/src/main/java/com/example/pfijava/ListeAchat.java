package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ListeAchat extends AppCompatActivity {
    private Panier panier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_achat);

        ArrayList<Article> arrArticle = new ArrayList<Article>();
        RecyclerView recycleAchat = (RecyclerView) findViewById(R.id.achat_RecyclerView);

        PanierAdapter adaptateur = new PanierAdapter(getApplicationContext());
        recycleAchat.setAdapter(adaptateur);

        recycleAchat.setLayoutManager(new LinearLayoutManager(this));

        recycleAchat.setItemAnimator(new DefaultItemAnimator());
        recycleAchat.setHasFixedSize(true);


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
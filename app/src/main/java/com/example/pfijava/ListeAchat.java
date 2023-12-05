package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListeAchat extends AppCompatActivity {
    private Panier panier;
    private PanierAdapter adaptateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_achat);
        panier = Panier.getInstance();

        ArrayList<Article> arrArticle = new ArrayList<Article>();
        RecyclerView recycleAchat = (RecyclerView) findViewById(R.id.achat_RecyclerView);

        adaptateur = new PanierAdapter(getApplicationContext());
        recycleAchat.setAdapter(adaptateur);

        recycleAchat.setLayoutManager(new LinearLayoutManager(this));

        recycleAchat.setItemAnimator(new DefaultItemAnimator());
        recycleAchat.setHasFixedSize(true);

        Button btnVersListe = (Button) findViewById(R.id.achat_btnVersListe);
        Button btnAnnuler = (Button) findViewById(R.id.achat_btnViderPanier);
        Button btnValider = (Button) findViewById(R.id.achat_btnAchatPanier);

        TextView totalPrix = (TextView) findViewById(R.id.achat_txtCalculTotal);

        double total = panier.calculerPrixTotal();
        String totalArrondi = String.format("%.2f", total);
        totalPrix.setText(totalArrondi + " $");



        btnVersListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versLE = new Intent(ListeAchat.this, ListeEpicerie.class);
                startActivity(versLE);
            }
        });

        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panier.viderPanier();
                adaptateur.clearList();

                Intent versLE = new Intent(ListeAchat.this, ListeEpicerie.class);
                startActivity(versLE);

            }
        });

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panier.viderPanier();
                adaptateur.clearList();

                Intent versAchatValider = new Intent(ListeAchat.this, AchatValider.class);
                startActivity(versAchatValider);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adaptateur.notifyDataSetChanged();

        TextView totalPrix = (TextView) findViewById(R.id.achat_txtCalculTotal);
        double total = panier.calculerPrixTotal();
        String totalArrondi = String.format("%.2f", total);
        totalPrix.setText(totalArrondi + " $");
    }
}
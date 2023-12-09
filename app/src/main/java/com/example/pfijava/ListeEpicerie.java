package com.example.pfijava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ListeEpicerie extends AppCompatActivity implements Serializable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_epicerie);


        ArrayList<Article> arrArticle = new ArrayList<Article>();
        RecyclerView recycleArticle = (RecyclerView) findViewById(R.id.LE_RecyclerView);
        RemplirArticle(arrArticle);

        Adaptateur adaptateur = new Adaptateur(getApplicationContext(),arrArticle);
        recycleArticle.setAdapter(adaptateur);

        recycleArticle.setLayoutManager(new LinearLayoutManager(this));

        recycleArticle.setItemAnimator(new DefaultItemAnimator());
        recycleArticle.setHasFixedSize(true);

        adaptateur.setOnClickListener(new Adaptateur.OnClickListener() {            // TOUTE LA SECTION DE ONLCICKLISTENER DU RECYCLER VIEW
                                                                                    // PRIS DE https://www.geeksforgeeks.org/how-to-apply-onclicklistener-to-recyclerview-items-in-android/
            @Override
            public void onClick(Article article) {
                Intent versDA = new Intent(ListeEpicerie.this, ActivityDetailArticle.class);
                versDA.putExtra("nom", article.getNom());
                versDA.putExtra("prix", article.getPrix());
                versDA.putExtra("desc", article.getDescription());
                versDA.putExtra("image", article.getIdImage());
                startActivity(versDA);
            }
        });

        Button btnVersPanier = (Button) findViewById(R.id.LE_btnVersPanier);



        btnVersPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent versPanier = new Intent(ListeEpicerie.this, ListeAchat.class);
                startActivity(versPanier);
            }
        });
    }

    void RemplirArticle(ArrayList<Article> listeArticles) {
        listeArticles.add(new Article("banane",1.02,R.drawable.banane, getResources().getString(R.string.articleDesc_banane)));
        listeArticles.add(new Article("cerise",4.99,R.drawable.cerise, getResources().getString(R.string.articleDesc_cerise)));
        listeArticles.add(new Article("chou",2.48,R.drawable.chou, getResources().getString(R.string.articleDesc_chou)));
        listeArticles.add(new Article("Champignon",2.48,R.drawable.champignon, getResources().getString(R.string.articleDesc_champignon)));
        listeArticles.add(new Article("courgette",1.50,R.drawable.courgette, getResources().getString(R.string.articleDesc_courgette)));
        listeArticles.add(new Article("épinard",3.99,R.drawable.epinard, getResources().getString(R.string.articleDesc_epinard)));
        listeArticles.add(new Article("Maïs",5.60,R.drawable.mais, getResources().getString(R.string.articleDesc_mais)));
        listeArticles.add(new Article("orange",0.99,R.drawable.orange, getResources().getString(R.string.articleDesc_orange)));
        listeArticles.add(new Article("pois",2.99,R.drawable.pois, getResources().getString(R.string.articleDesc_pois)));
        listeArticles.add(new Article("raisin",3.50,R.drawable.raisin, getResources().getString(R.string.articleDesc_raisin)));
    }

}